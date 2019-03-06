package cn.taofen8.dao;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import cn.taofen8.exception.DAOException;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Generic CRUD
 * Created by lemon on 2014/7/2.
 */
public class GenericDAO<T>  {
    private static final Logger logger = Logger.getLogger(GenericDAO.class);
    private static final String SQL_ID_TEMPLATE = "%s.%s";

    private SqlMapClient sqlMapClient;
    private SqlMapClientTemplate sqlMapClientTemplate;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }
    
    protected SqlMapClientTemplate getSqlMapClientTemplate() {
        if(sqlMapClientTemplate == null){
            sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
        }
        return sqlMapClientTemplate;
    }

    protected Object insert(String statement) {
        return insert(statement, null);
    }

    protected Object insert(String statement, Object parameter) {
        try {
            if (parameter == null) {
                return getSqlMapClientTemplate().insert(getWholeSqlId(statement));
            } else {
                return getSqlMapClientTemplate().insert(getWholeSqlId(statement), parameter);
            }
        } catch (DataAccessException e) {
            throw new DAOException(e);
        }
    }

    protected List<T> selectList(String statement) {
        return selectList(statement, null);
    }

    @SuppressWarnings("unchecked")
    protected List<T> selectList(String statement, Object parameter) {
        if (parameter == null) {
            return getSqlMapClientTemplate().queryForList(getWholeSqlId(statement));
        } else {
            return getSqlMapClientTemplate().queryForList(getWholeSqlId(statement), parameter);
        }
    }

    /**
     * 通用分页查询, 参数类型是map<br>
     * select * from table_name limit #start#, #limit#
     *
     * @param statement SQL语句
     * @param start     start
     * @param limit     返回记录数
     * @return 结果集
     */
    protected List<T> selectList(String statement, int start, int limit) {
        return selectList(statement, null, start, limit);
    }

    /**
     * 通用分页查询, 参数类型是map<br>
     * select * from table_name limit #start#, #limit#
     *
     * @param statement SQL语句
     * @param parameter 参数
     * @param start     start
     * @param limit     返回记录数
     * @return 结果集
     */
    protected List<T> selectList(String statement, Object parameter, int start, int limit) {
        if (start > 50000)
            logger.warn(String.format("SQL语句[%s:start=%d,limit=%d]可能存在性能问题。", statement, start, limit));

        Map<String, Object> params = new HashMap<String, Object>(parameter == null ? 4 : 16);
        params.put("start", start);
        params.put("limit", limit);

        if (parameter != null) {
            convertParameter(params, parameter);
        }

        return selectList(statement, params);
    }

    protected T selectOne(String statement) {
        return selectOne(statement, null);
    }

    protected T selectOne(String statement, Object parameter) {
        List<T> result;
        if (parameter == null) {
            result = selectList(statement);
        } else {
            result = selectList(statement, parameter);
        }
        if (result == null || result.isEmpty())
            return null;
        return result.get(0);
    }

    protected boolean exists(String statement){
        return exists(statement, null);
    }

    protected boolean exists(String statement, Object parameter){
        Object result;
        if (parameter == null) {
            result = getSqlMapClientTemplate().queryForObject(getWholeSqlId(statement));
        } else {
            result = getSqlMapClientTemplate().queryForObject(getWholeSqlId(statement), parameter);
        }
        return result != null;
    }

    protected int update(String statement) {
        return update(statement, null);
    }

    protected int update(String statement, Object parameter) {
        try {
            if (parameter == null) {
                return getSqlMapClientTemplate().update(getWholeSqlId(statement));
            } else {
                return getSqlMapClientTemplate().update(getWholeSqlId(statement), parameter);
            }
        } catch (DataAccessException e) {
            throw new DAOException(e);
        }
    }

    protected int count(String statement) {
        return count(statement, null);
    }

    protected int count(String statement, Object parameter) {
        Object result;
        if (parameter == null) {
            result = getSqlMapClientTemplate().queryForObject(getWholeSqlId(statement));
        } else {
            result = getSqlMapClientTemplate().queryForObject(getWholeSqlId(statement), parameter);
        }
        if (result == null)
            throw new DAOException("执行COUNT时返回null，请检查SQL语句。");
        try {
            return Integer.parseInt(result.toString());
        } catch (NumberFormatException e) {
            throw new DAOException("执行COUNT时返回结果非整形，请检查SQL语句。");
        }
    }

    /**
     * 获取完整的SQL_ID<br>
     * 规则：sql映射文件对应的namespace必须是对应的DAO接口完整名称
     *
     * @param sqlId sqlId
     * @return 完整的SQL ID
     */
    protected String getWholeSqlId(String sqlId) {
        return String.format(SQL_ID_TEMPLATE, getClass().getInterfaces()[0].getName(), sqlId);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void convertParameter(Map<String, Object> params, Object parameter) {
        if (parameter == null)
            return;

        //TODO 其他类型的扩展，比如枚举
        if(parameter instanceof Boolean || parameter instanceof  String || parameter instanceof Number){
            params.put("param", parameter);
            return;
        }

        if(parameter instanceof Map){
            params.putAll((Map) parameter);
            return;
        }

        Field[] fields = parameter.getClass().getDeclaredFields();
        parseFields(params, parameter, fields);

        // 处理父类的字段
        Class<?> superClass = parameter.getClass().getSuperclass();
        while (!superClass.equals(Object.class)) {
            parseFields(params, parameter, superClass.getDeclaredFields());
            superClass = superClass.getClass().getSuperclass();
        }
    }

    private void parseFields(Map<String, Object> params, Object parameter, Field[] fields) {
        String fieldName;
        Object fieldValue;
        // 处理对象内部的字段
        for (Field field : fields) {
            field.setAccessible(true);
            fieldName = field.getName();
            if ("serialVersionUID".equals(fieldName))
                continue;

            if ("start".equals(fieldName) || "limit".equals(fieldName)) {
                throw new DAOException(parameter.getClass().getName() + "的字段含有start或者limit，这和分页的字段冲突。");
            }
            try {
                fieldValue = field.get(parameter);
                if (fieldValue != null) {
                    params.put(field.getName(), fieldValue);
                }
            } catch (IllegalAccessException e) {
                logger.error(String.format("读取字段%s出错", fieldName));
                throw new DAOException(e);
            }
        }
    }

    protected void delete(String statement) {
        delete(statement, null);
    }
    
    protected void delete(String statement, Object parameter) {
        try {
            if (parameter == null) {
                getSqlMapClientTemplate().delete(getWholeSqlId(statement));
            } else {
                getSqlMapClientTemplate().delete(getWholeSqlId(statement), parameter);
            }
        } catch (DataAccessException e) {
            throw new DAOException(e);
        }
    }
}
