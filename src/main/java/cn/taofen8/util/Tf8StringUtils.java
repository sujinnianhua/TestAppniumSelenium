package cn.taofen8.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


/**
 * 以后尽量用common包中的StringUtils工具类
 * @author 
 *
 */
public class Tf8StringUtils {

    // 按照声 母表示，这个表是在GB2312中的出现的第一个汉字，也就是说“啊”是代表首字母a的第一个汉字。
    // i, u, v都不做声母, 自定规则跟随前面的字母
    private static char[] chartable = {'啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈', '哈', '击', '喀', '垃',
            '妈', '拿', '哦', '啪', '期', '然', '撒', '塌', '塌', '塌', '挖', '昔', '压', '匝',};

    // 对应首字母区间表
    private static char[] initialtable = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'h', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 't', 't', 'w', 'x', 'y', 'z',};
    
    // 二十六个字母区间对应二十七个端点
    // GB2312码汉字区间十进制表示
    private static int[] table = new int[27];

    // 简体中文的编码范围从B0A1（45217）一直到F7FE（63486）
    private static int BEGIN = 45217;
    private static int END = 63486;
    
    // 初始化
    static {
        for (int i = 0; i < 26; i++) {
            table[i] = gbValue(chartable[i]);// 得到GB2312码的首字母区间端点表，十进制。
        }
        table[26] = END;// 区间表结尾
    }
    
	/**
	 * 判断是否为空
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return s == null || "".equals(s.trim());
	}
	
	/**
	 * 判断是否非空
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
	
	/**
	 * 将NULL字符转成""返回
	 * @param s
	 * @return
	 */
	public static String noNUll(String s) {
		if (isEmpty(s)) {
			return "";
		} else {
			return s.trim();
		}
	}
	
	/**
	 * 检查字符串是否是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
	 * 
	 * <pre>
	 * StringUtil.isBlank(null)      = true
	 * StringUtil.isBlank("")        = true
	 * StringUtil.isBlank(" ")       = true
	 * StringUtil.isBlank("bob")     = false
	 * StringUtil.isBlank("  bob  ") = false
	 * </pre>
	 * 
	 * @param str 要检查的字符串
	 * @return 如果为空白, 则返回<code>true</code>
	 */
	public static boolean isBlank(String str) {
		int length;

		if (str == null || (length = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 非空检查 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
	
	// ==========================================================================
	// 默认值函数。 
	//  
	// 当字符串为empty或blank时，将字符串转换成指定的默认字符串。
	// 注：判断字符串为null时，可用更通用的ObjectUtil.defaultIfNull。
	// ==========================================================================

	/**
	 * 如果字符串是<code>null</code>或空字符串<code>""</code>，则返回指定默认字符串，否则返回字符串本身。
	 * 
	 * <pre>
	 * StringUtil.defaultIfEmpty(null, "default")  = "default"
	 * StringUtil.defaultIfEmpty("", "default")    = "default"
	 * StringUtil.defaultIfEmpty("  ", "default")  = "  "
	 * StringUtil.defaultIfEmpty("bat", "default") = "bat"
	 * </pre>
	 * 
	 * @param str 要转换的字符串
	 * @param defaultStr 默认字符串
	 * @return 字符串本身或指定的默认字符串
	 */
	public static String defaultIfEmpty(String str, String defaultStr) {
		return str == null || str.length() == 0 ? defaultStr : str;
	}

	/**
	 * 如果字符串是<code>null</code>或空字符串<code>""</code>，则返回指定默认字符串，否则返回字符串本身。
	 * 
	 * <pre>
	 * StringUtil.defaultIfBlank(null, "default")  = "default"
	 * StringUtil.defaultIfBlank("", "default")    = "default"
	 * StringUtil.defaultIfBlank("  ", "default")  = "default"
	 * StringUtil.defaultIfBlank("bat", "default") = "bat"
	 * </pre>
	 * 
	 * @param str 要转换的字符串
	 * @param defaultStr 默认字符串
	 * @return 字符串本身或指定的默认字符串
	 */
	public static String defaultIfBlank(String str, String defaultStr) {
		return isBlank(str) ? defaultStr : str;
	}
	
	/**
	 * 通过正则表达式 pattern 在输入的字符串str中 搜索第一个符合正则格式的字符串
	 * 		如果pattern为null或者str为null或者没有匹配 返回null
	 * @param pattern
	 * @param str
	 * @return
	 */
	public static String getRegexFromStr(Pattern pattern, String str) {
		return getRegexFromStr(pattern, str, -1);
	}
	
	/**
	 * 如果group大于等于0 则返回匹配的组的数据 
	 * @param pattern
	 * @param str
	 * @param group
	 * @return
	 */
	public static String getRegexFromStr(Pattern pattern, String str, int group) {
		if(pattern == null || str == null) {
			return null;
		}
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			return group < 0 ? matcher.group() : matcher.group(group);
		}
		return null;
	}
	
	/**
	 * 去除空格、回车、换行、制表符
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
	
	/**
	 * 除去字符串首尾和中间的空白符
	 * @param str
	 * @return
	 */
	public static String trimAllWhitespace(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		int index = 0;
		while (sb.length() > index) {
			if (Character.isWhitespace(sb.charAt(index))) {
				sb.deleteCharAt(index);
			}
			else {
				index++;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 去除开头和结尾的空字符
	 * @param str the String to check
	 * @return the trimmed String
	 * @see java.lang.Character#isWhitespace
	 */
	public static String trimWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	/**
	 * Check that the given String is neither {@code null} nor of length 0.
	 * Note: Will return {@code true} for a String that purely consists of whitespace.
	 * @param str the String to check (may be {@code null})
	 * @return {@code true} if the String is not null and has length
	 * @see #hasLength(CharSequence)
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}
	
	/**
	 * Check that the given CharSequence is neither {@code null} nor of length 0.
	 * Note: Will return {@code true} for a CharSequence that purely consists of whitespace.
	 * <p><pre class="code">
	 * StringUtils.hasLength(null) = false
	 * StringUtils.hasLength("") = false
	 * StringUtils.hasLength(" ") = true
	 * StringUtils.hasLength("Hello") = true
	 * </pre>
	 * @param str the CharSequence to check (may be {@code null})
	 * @return {@code true} if the CharSequence is not null and has length
	 * @see #hasText(String)
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}
	
	
	 /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString().toUpperCase();
    }
    
    
    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            String msg = "Unable to convert byte array to String with encoding utf-8";
            throw new RuntimeException(msg);
        }
    }

    public static byte[] toBytes(String source) {
        try {
            return source.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            String msg =
                    "Unable to convert source [" + source + "] to byte array using encoding utf-8'";
            throw new RuntimeException(msg, e);
        }
    }
    
    // 根据一个包含汉字的字符串返回一个汉字拼音首字母的字符串 最重要的一个方法，思路如下：一个个字符读入、判断、输出
    public static String getFirstSpellForChinese(String SourceStr) {
        String Result = "";
        int StrLength = SourceStr.length();
        int i;
        try {
            for (i = 0; i < StrLength; i++) {
                Result += char2Initial(SourceStr.charAt(i));
            }
        } catch (Exception e) {
            Result = "";
            e.printStackTrace();
        }
        return Result;
    }
    
    /**
     * 输入字符,得到他的声母,英文字母返回对应的大写字母,其他非简体汉字返回 '0' 　　* 　　
     */
    private static char char2Initial(char ch) {
        // 对英文字母的处理：小写字母转换为大写，大写的直接返回
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 'a' + 'A');
        }
        if (ch >= 'A' && ch <= 'Z') {
            return ch;
        }
        // 对非英文字母的处理：转化为首字母，然后判断是否在码表范围内，
        // 若不是，则直接返回。
        // 若是，则在码表内的进行判断。
        int gb = gbValue(ch);// 汉字转换首字母
        if ((gb < BEGIN) || (gb > END))// 在码表区间之前，直接返回
        {
            return ch;
        }
        int i;
        for (i = 0; i < 26; i++) {// 判断匹配码表区间，匹配到就break,判断区间形如“[,)”
            if ((gb >= table[i]) && (gb < table[i + 1])) {
                break;
            }
        }
        if (gb == END) {// 补上GB2312区间最右端
            i = 25;
        }
        return initialtable[i]; // 在码表区间中，返回首字母
    }
    
    /**
     * 取出汉字的编码 cn 汉字 　　
     */
    private static int gbValue(char ch) {// 将一个汉字（GB2312）转换为十进制表示。
        String str = new String();
        str += ch;
        try {
            byte[] bytes = str.getBytes("GB2312");
            if (bytes.length < 2) {
                return 0;
            }
            return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static final String leftString(String s, int len) {
        if (s == null || getlength(s) < len)
            return s;
        for(int i = 0; i < s.length() && i < len; i++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(0, i + 1);
            if(getlength(s1) <= len && getlength(s2) > len)
                return s1;
        }
        return s;
    }


    public static final int getlength(String str){ 
        int t=0; 
        byte[] bt = str.getBytes(); 
        int i = 1;
        while(i <=bt.length){ 
            if   (bt[i-1] <0)   {t=t+2;i+=3;} 
            else  {t=t+1;i++;} 
        } 
        return   t; 
    }
    
    /**
     * 驼峰式结构转换为下划线分割的小写单词
     * @param str
     * @return
     */
    public static String camel2Underscore(String str){
        if(!StringUtils.isEmpty(str)){
            StringBuffer s= new StringBuffer(str);
            for(int i=0; i<s.length(); i++){
                if(Character.isUpperCase(s.charAt(i))){
                    String tmp=s.charAt(i)+"";
                    s.deleteCharAt(i);
                    s.insert(i, "_"+tmp.toLowerCase());
                }
            }
            return s.toString();
        }
        return "";
    }
    
    /**
     * 是否包含emoji表情
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        boolean isEmoji = false;
        for (int i = 0; i < len; i++) {
            char hs = source.charAt(i);
            if (0xd800 <= hs && hs <= 0xdbff) {
                if (source.length() > 1) {
                    char ls = source.charAt(i + 1);
                    int uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;
                    if (0x1d000 <= uc && uc <= 0x1f77f) {
                        return true;
                    }
                }
            } else {
                // non surrogate
                if (0x2100 <= hs && hs <= 0x27ff && hs != 0x263b) {
                    return true;
                } else if (0x2B05 <= hs && hs <= 0x2b07) {
                    return true;
                } else if (0x2934 <= hs && hs <= 0x2935) {
                    return true;
                } else if (0x3297 <= hs && hs <= 0x3299) {
                    return true;
                } else if (hs == 0xa9 || hs == 0xae || hs == 0x303d
                        || hs == 0x3030 || hs == 0x2b55 || hs == 0x2b1c
                        || hs == 0x2b1b || hs == 0x2b50 || hs == 0x231a) {
                    return true;
                }
                if (!isEmoji && source.length() > 1 && i < source.length() - 1) {
                    char ls = source.charAt(i + 1);
                    if (ls == 0x20e3) {
                        return true;
                    }
                }
            }
        }
        return isEmoji;
    }
    
    /**
     * 过滤emoji 或者 其他非文字类型的字符
     * 
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        if (isBlank(source)) {
            return source;
        }
        
        if (!containsEmoji(source)) {
        	return source;
        }
        
        if(source != null)
        {
            Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;
            Matcher emojiMatcher = emoji.matcher(source);
            if ( emojiMatcher.find()) 
            {
                source = emojiMatcher.replaceAll("*");
                return source ; 
            }
        return source;
       }
       return source;  
    }
    
}
