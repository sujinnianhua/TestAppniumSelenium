package cn.taofen8.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 时间区间
 *
 */
public class DateSection {
	
	private Date begin;
	
	private Date end;
	
    public boolean isBothRestrained() {
        return (begin != null && end != null);
    }
	
    public boolean isSingleRestrained() {
        return (begin == null && end != null) || (end == null && begin != null);
    }
	
    public boolean isBeginRestrained() {
        return begin != null;
    }
	
    public boolean isEndRestrained() {
        return end != null;
    }
	
    public DateSection(String begin, String end) {
        if (this.begin == null) {
            try {
                this.begin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(begin);
            } catch (ParseException e) {
            }
        }

        if (this.begin == null) {
            try {
                this.begin = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(begin);
            } catch (ParseException e) {
            }
        }
        
        if (this.begin == null) {
            try {
                this.begin = new SimpleDateFormat("yyyy-MM-dd").parse(begin);
            } catch (ParseException e) {
            }
        }

        if (this.end == null) {
            try {
                this.end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
            } catch (ParseException e) {
            }
        }

        if (this.end == null) {
            try {
                this.begin = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(end);
            } catch (ParseException e) {
            }
        }
        
        if (this.end == null) {
            try {
                this.begin = new SimpleDateFormat("yyyy-MM-dd").parse(end);
            } catch (ParseException e) {
            }
        }

    }

    public DateSection(Date begin, Date end) {
        this.begin = begin;
        this.end = end;
    }

	public Date getBegin() {
		return begin;
	}

	public Date getEnd() {
		return end;
	}

}
