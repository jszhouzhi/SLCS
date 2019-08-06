package com.slzr.common.utils;
 
 import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



 
 public class YXDate{
		private static final Log log=LogFactory.getLog(YXDate.class);
	
		/**
		 * 
		 * @param timeMillis 时间戳
		 * @param pattern 如：yyyy-MM-dd HH:mm:ss
		 * @param date 天 
		 * @param hour 时 
		 * @param minute 分
	 	 * @param flag true 加 false 减
		 * @return
		 */
		public static Date calculateDate(String timeMillis,int date,int hour,int minute,boolean flag){
			if(! StringUtils.isBlank(timeMillis)){
				Random random=new Random();
				long time =(timeMillis.length() < 11)? Long.valueOf(timeMillis).longValue() * 1000L : Long.valueOf(timeMillis).longValue();
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(time);
				int day=flag?c.get(Calendar.DATE)+date:c.get(Calendar.DATE)-date;
				hour=flag?c.get(Calendar.HOUR)+hour:c.get(Calendar.HOUR)-hour;
				minute=flag?c.get(Calendar.MINUTE)+random.nextInt(minute):c.get(Calendar.MINUTE)-random.nextInt(minute);
				c.set(Calendar.DATE,day); //天
				c.set(Calendar.HOUR,hour); //时
				c.set(Calendar.MINUTE,minute); //分 
				c.set(Calendar.SECOND, c.get(Calendar.SECOND)-random.nextInt(60)); //秒 
				return c.getTime();
			}
			return null;
		}
		
		/**
		 * 根据当前时间获取一周时间
		 * @param mdate  当前系统时间
		 * @return
		 */
		public static List<String> dateToWeek(Date mdate,String pattern) {
			Calendar c = Calendar.getInstance();
			List<String> list = new ArrayList<String>();  
			for (int i =7; i >0; i--) {
				c.setTime(mdate);
				c.add(Calendar.DAY_OF_MONTH,-i); 
				list.add(new SimpleDateFormat(pattern).format(c.getTime()));
			}
			return list;
		}
		
		 public static Long dateDiff2(String startTime, String endTime,String format, String str) {
				// 按照传入的格式生成一个simpledateformate对象
				SimpleDateFormat sd = new SimpleDateFormat(format);
				long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
				long nh = 1000 * 60 * 60;// 一小时的毫秒数
				long nm = 1000 * 60;// 一分钟的毫秒数
				long diff;
				long day = 0;
				long hour = 0;
				long min = 0;
				// 获得两个时间的毫秒时间差异
				try {
					diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
					day = diff / nd;// 计算差多少天
					hour = diff % nd / nh + day * 24;// 计算差多少小时
					min = diff % nd / nm + day * 24 * 60;// 计算差多少分钟
					// 输出结果
					//System.out.println("时间相差：" + day + "天" + (hour - day * 24) + "小时"
					//		+ (min - day * 24 * 60) + "分钟" + sec + "秒。");
					//System.out.println("hour=" + hour + ",min=" + min);
					if (str.equalsIgnoreCase("h")) {
						return hour+1;
					} else {
						return min+1;
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (str.equalsIgnoreCase("h")) {
					return hour;
				} else {
					return min;
				}
	   }
		 

	    /**
	     * 将时间戳转为字符串格式
	     * @param timeMillis 时间戳
	     * @param pattern  如：yyyyMMddhhmmss
	     * @return 
	     */
		public static String formatDate (final String timeMillis,final String pattern){
			
			if(! StringUtils.isBlank(timeMillis)){
				
				long time =(timeMillis.length() < 11)? Long.valueOf(timeMillis).longValue() * 1000L : Long.valueOf(timeMillis).longValue();
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(time);
				SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
				try {
					return dateformat.format(c.getTime());
				} catch (RuntimeException e) {
					log.error("将时间戳转为字符串格式出错！", e);
					e.printStackTrace();
				}
			}
			return " ";
			
		}
	 	
		public static String getLastMonth(){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1);
			return sdf.format(c.getTime());
		} 
		
		/**
		 * 获取当前月份
		 * @param month =0 : 为当月  <0 :当前月份减多少月  >0 当前月份加多少月
		 * @return
		 */
		public static String getMonth(Integer month){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, month);
			return sdf.format(c.getTime());
		} 
			
		/** 
	     * 计算两个日期之间相差的天数 
	     * @param smdate 较小的时间
	     * @param bdate  较大的时间
	     * @return 相差天数
		 * @throws ParseException 
	     */  
	    public static int daysBetween(Date smdate,Date bdate) throws ParseException  
	    {  
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    	smdate=sdf.parse(sdf.format(smdate));
	    	bdate=sdf.parse(sdf.format(bdate));
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(smdate);  
	        long time1 = cal.getTimeInMillis();               
	        cal.setTime(bdate);  
	        long time2 = cal.getTimeInMillis();       
	        long between_days=(time2-time1)/(1000*3600*24);
	          
	       return Integer.parseInt(String.valueOf(between_days));         
	    }  
	    
	    /** 
	     * 计算两个时间戳之间相差的天数 
	     * @param smdate 较小的时间戳
	     * @param bdate  较大的时间戳
	     * @return 相差天数
	     */  
	    public static int daysBetween1(String smdate,String bdate)  {  
    	    Calendar cal = Calendar.getInstance();  
    	    cal.setTimeInMillis((smdate.length() < 11)? Long.valueOf(smdate).longValue() * 1000L : Long.valueOf(smdate).longValue());
	        long time1 = cal.getTimeInMillis();               
	        cal.setTimeInMillis((bdate.length() < 11)? Long.valueOf(bdate).longValue() * 1000L : Long.valueOf(bdate).longValue());
	        long time2 = cal.getTimeInMillis();       
	        long between_days=(time2-time1)/(1000*3600*24);
		    return Integer.parseInt(String.valueOf(between_days));          
	    }  
		    
		/**
		*字符串的日期格式的计算
		*/
	    public static int daysBetween(String smdate,String bdate) throws ParseException{
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(sdf.parse(smdate));  
	        long time1 = cal.getTimeInMillis();               
	        cal.setTime(sdf.parse(bdate));  
	        long time2 = cal.getTimeInMillis();       
	        long between_days=(time2-time1)/(1000*3600*24); 
	        return Integer.parseInt(String.valueOf(between_days));   
	    }
	    
	    public static Long dateDiff(String startTime, String endTime,String format, String str) {
			// 按照传入的格式生成一个simpledateformate对象
			SimpleDateFormat sd = new SimpleDateFormat(format);
			long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
			long nh = 1000 * 60 * 60;// 一小时的毫秒数
			long nm = 1000 * 60;// 一分钟的毫秒数
			long ns = 1000;// 一秒钟的毫秒数
			long diff;
			long day = 0;
			long hour = 0;
			long min = 0;
			long sec = 0;
			// 获得两个时间的毫秒时间差异
			try {
				diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
				day = diff / nd;// 计算差多少天
				hour = diff % nd / nh + day * 24;// 计算差多少小时
				min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
				sec = diff % nd % nh % nm / ns;// 计算差多少秒
				// 输出结果
				//System.out.println("时间相差：" + day + "天" + (hour - day * 24) + "小时"
				//		+ (min - day * 24 * 60) + "分钟" + sec + "秒。");
				//System.out.println("hour=" + hour + ",min=" + min);
				if (str.equalsIgnoreCase("h")) {
					return hour;
				} else {
					return min;
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (str.equalsIgnoreCase("h")) {
				return hour;
			} else {
				return min;
			}
   }
	 
   private static Calendar getCalendar()
   {
     TimeZone tz = TimeZone.getDefault();
     return Calendar.getInstance(tz);
   }
 
   public static String getYear()
   {
     return String.valueOf(getCalendar().get(1));
   }
 
   public static String getMonth()
   {
     return strFormat(getCalendar().get(2) + 1);
   }
 
   public static String getDay()
   {
     return strFormat(getCalendar().get(5));
   }
 
   public static String getFormatDate(String separator)
   {
     return getYear() + separator + getMonth() + separator + getDay();
   }
 
   public static String getHour()
   {
     return strFormat(getCalendar().get(11));
   }
 
   public static String getMinute()
   {
     return strFormat(getCalendar().get(12));
   }
 
   public static String getSecond()
   {
     return strFormat(getCalendar().get(13));
   }
 
   public static String getDateTime(String s1, String s2)
   {
     return getYear() + s1 + getMonth() + s1 + getDay() + " " + getHour() + 
       s2 + getMinute() + s2 + getSecond();
   }
 
   public static String getDateTime2(String s1, String s2)
   {
     return getYear() + s1 + getMonth() + s1 + getDay() + getHour() + 
       s2 + getMinute() + s2 + getSecond();
   }
 
   public static String getTime(String s1)
   {
     return getHour() + s1 + getMinute() + s1 + getSecond();
   }
 
   //当前时间戳带毫秒
   public static String getTimeL()
   {
     return String.valueOf(System.currentTimeMillis());
   }
   
   //当前时间戳
   public static String getTime()
   {
     return String.valueOf(System.currentTimeMillis()/1000L);
   }
   
   /**
    * 当前时间戳
    * @param s1 yyyy-MM-dd
    */
   public static String getTimeStamp(String s1)
   {
	   String timeStamp=null;
	   try {  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			timeStamp = String.valueOf(sdf.parse(s1).getTime()/1000);
			System.out.println(timeStamp);
		} catch (Exception e) {  
			e.printStackTrace();  
		}
	   return timeStamp;  
   }
   
 
   public static String getTimeToday()
   {
     long now = System.currentTimeMillis() / 1000L;
 
     return String.valueOf(11);
   }
 
   private static String strFormat(int data)
   {
     String str = String.valueOf(data);
     if (data <= 9) {
       str = "0" + str;
     }
     return str;
   }
 
   public static String TimeStamp2DateTime(String timestampString)
   {
     Long timestamp = Long.valueOf(Long.parseLong(timestampString));
     String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp.longValue()));
     return date;
   }
 
   public static String TimeStamp2Date(String timestampString)
   {
     Long timestamp = Long.valueOf(timestampString.length() < 13 ? Long.parseLong(timestampString) * 1000L : Long.parseLong(timestampString));
     String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp.longValue()));
     return date;
   }
 
   public static String TimeStamp2Date_month(String timestamp2String)
   {
     Long timestamp = Long.valueOf(Long.parseLong(timestamp2String) * 1000L);
     String date = new SimpleDateFormat("yyyy-MM").format(new Date(timestamp.longValue()));
     return date;
   }

   public static String TimeStamp2Date_day(String timestamp2String)
   {
     Long timestamp = Long.valueOf(Long.parseLong(timestamp2String) * 1000L);
     String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp.longValue()));
     return date;
   }
 
   public static String date2TimeStamp(String date)
   {
     try
     {
       SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
       Date s = dateformat.parse(date);
       return String.valueOf(s.getTime() / 1000L);
     } catch (ParseException e) {
       e.printStackTrace();
     }return null;
   }
 
   public static String dateTime2TimeStamp(String date)
   {
     try
     {
       SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date s = dateformat.parse(date);
       return String.valueOf(s.getTime() / 1000L);
     } catch (ParseException e) {
       e.printStackTrace();
     }return null;
   }
 
   public static String getTimeDayFirstSecond(){
	     return dateTime2TimeStamp(TimeStamp2Date(String.valueOf(System.currentTimeMillis())) + " 00:00:00");
	   }
   
   public static String getTimeDayLastSecond(){
     return dateTime2TimeStamp(TimeStamp2Date(String.valueOf(System.currentTimeMillis())) + " 23:59:59");
   }
 
   public static String getMonthTime(int month)
   {
     Calendar cal = Calendar.getInstance();
     cal.add(2, month);
     String timeStamp = String.valueOf(cal.getTimeInMillis() / 1000L);
     return timeStamp;
   }
   
   public static String getAddMonthTime(String time, int month) throws ParseException{
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	   Date now = sdf.parse(time);
	   Calendar calendar = Calendar.getInstance();
	   calendar.setTime(now);
	   calendar.add(Calendar.MONTH, month);
	   return sdf.format(calendar.getTime());
   }
 
   public static String getMonthTime3PM(int month){
	   return dateTime2TimeStamp(TimeStamp2Date(getMonthTime(month))+" 15:00:00");
   }
   public static String getDayTime(int days)
   {
     Calendar cal = Calendar.getInstance();
     cal.add(6, days);
     String timeStamp = String.valueOf(cal.getTimeInMillis() / 1000L);
     return timeStamp;
   }
   
   public static String getHourTime(int hour)
   {
	   Long curTime = System.currentTimeMillis()/1000L;
     String timeStamp = String.valueOf(curTime+(3600*hour));
     return timeStamp;
   }

   public static String getDateTime(int days)
   {
     Calendar cal = Calendar.getInstance();
     cal.add(Calendar.DATE,days);//加1天
     String timeStamp = String.valueOf(cal.getTimeInMillis() / 1000L);
     return timeStamp;
   }    

   public static String getDateTime3PM(int days){
	   return dateTime2TimeStamp(TimeStamp2Date(getDateTime(days))+" 15:00:00");
   }
   
   public static String getYearTime(int years)
   {    
     Calendar cal = Calendar.getInstance();
     cal.add(1, years);
     String timeStamp = String.valueOf(cal.getTimeInMillis() / 1000L);
     return timeStamp;
   }    
        
   public static String getYearTime(long timeStamp1, int years)
   {    
     Calendar cal = Calendar.getInstance();
     cal.setTimeInMillis(timeStamp1 * 1000L);
     cal.add(1, years);
     String timeStamp = String.valueOf(cal.getTimeInMillis() / 1000L);
     return timeStamp;
   }    
        
   public static int lateDays(long time)
   {    
     Calendar c = Calendar.getInstance();
     Calendar nowTime = Calendar.getInstance();
     try {
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       Date date = format.parse(format.format(Long.valueOf(String.valueOf(time).length() < 13 ? time * 1000L : time)));
       c.setTime(date);
       long now = System.currentTimeMillis();
       Date date2 = format.parse(format.format(Long.valueOf(now)));
       nowTime.setTime(date2);
     } catch (ParseException e) {
       e.printStackTrace();
     }  
     return countDays(c, nowTime);
   }    
        
   public static int lateDays(long time1, long time2)
   {    
     Calendar c = Calendar.getInstance();
     Calendar nowTime = Calendar.getInstance();
     try {
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       Date date = format.parse(format.format(Long.valueOf(String.valueOf(time1).length() < 13 ? time1 * 1000L : time1)));
       c.setTime(date);
        
       Date date2 = format.parse(format.format(Long.valueOf(String.valueOf(time2).length() < 13 ? time2 * 1000L : time2)));
       nowTime.setTime(date2);
     } catch (ParseException e) {
       e.printStackTrace();
     }  
     return countDays(c, nowTime);
   }    
        
   public static int countDays(Calendar c_b, Calendar c_e) {
     int days = 0;
     while (c_b.before(c_e)) {
       days++;
       c_b.add(6, 1);
     }  
     return days;
   }    
        
   public static String getOffsetMonthDate(Date protoDate, int monthOffset)
   {    
     Calendar cal = Calendar.getInstance();
     cal.setTime(protoDate);
     cal.add(2, -monthOffset);
     System.out.println(cal.get(2));
     Date date = cal.getTime();
     return new SimpleDateFormat("yyyy-MM").format(date);
   }    
        
   public static String getLastMonth(int month) {
     return getYear() + "-" + strFormat(getCalendar().get(2) + 1 - month);
   }    
   
   public static String getTimeAfterTime(long curryTime,int differenceMonths,int differenceDays){
	       Date date = new Date(curryTime*1000);
		   Calendar currTime = Calendar.getInstance();
		   currTime.setTime(date);
		   currTime.add(2, differenceMonths);
		   currTime.add(5, differenceDays);
	   return String.valueOf(currTime.getTime().getTime());
   }
        
   public static String getTimeAfterTime1(long curryTime,int differenceMonths,int differenceDays){
       Date date = new Date(curryTime*1000);
	   Calendar currTime = Calendar.getInstance();
	   currTime.setTime(date);
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   String str = format.format(currTime.getTime())+" 15:00:00";
	   SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   try {
		   currTime.setTime(format1.parse(str));
	   } catch (ParseException e) {
		   e.printStackTrace();
	   }
	   currTime.add(2, differenceMonths);
	   currTime.add(5, differenceDays);
   return String.valueOf(currTime.getTime().getTime());
}
   
   /**
    * 比较两个时间相差多少天
    * @param comparisonTime1
    * @param comparisonTime2
    * @return
    */
   public static int getDifferenceDays(long comparisonTime1,long comparisonTime2){
	    int differenceDays =   (int) ((comparisonTime1/1000 - comparisonTime2/1000)/24/3600);
	    if((((comparisonTime1/1000 - comparisonTime2/1000))%(24*3600))>0){
	    	differenceDays = differenceDays+1;
	    }
	    return Math.abs(differenceDays);
   }
   
   /** 格式化时间 */
	public static String fromDate (String vv){
		String reslut= "";
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}

			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			reslut = dateformat.format(c.getTime());
		}
		return reslut;
	}
	
	/** 格式化当前时间 */
	public static String formateDate(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
	}

	
	//获取时间上月
	public static String prevMonth(String date) throws ParseException{
		int start = 201309;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String prevMonth = "";
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();
		c.setTime(format1.parse(date));
		c.add(Calendar.MONTH, -1);

		int pMonth = Integer.valueOf(sdf.format(c.getTime()));
		if(start > pMonth){
			prevMonth = "";
		}else{
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
			prevMonth = format.format(c.getTime());
		}
		
		return prevMonth;
	}
	//获取时间下月
	public static String nextMonth(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		int end = Integer.valueOf(sdf.format(new Date()));
		String nextMonth = "";
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();
		c.setTime(format1.parse(date));
		c.add(Calendar.MONTH, 1);
		
		int nMonth = Integer.valueOf(sdf.format(c.getTime()));
		if(nMonth > end){
			nextMonth = "";
		}else{
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
			nextMonth = format.format(c.getTime());
		}
		
		return nextMonth;
	}
	
	
	//格式化时间
	public static String myfromDate(String vv){
		String reslut= "";
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}

			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			reslut = dateformat.format(c.getTime());
		}
		return reslut;
	}
	
	//格式化时间
	public static Integer myfromDate2(String vv){
		Integer reslut= 0;
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}

			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMM");
			reslut = Integer.parseInt(dateformat.format(c.getTime()));
		}
		return reslut;
	}
	
	
	
	/** 格式化当前时间 */
	public static String formateDate(String vv){
		String reslut= "";
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
			reslut = dateformat.format(c.getTime());
		}
		return reslut;
	}
	
	   /** 格式化时间 */
	public static String myfromDate1 (String vv){
		String reslut= "";
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmss");
			reslut = dateformat.format(c.getTime());
		}
		return reslut;
	}
	
	//时间差  （天）
	public static long  myDatediffer(String str1,String str2){
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
		 Date one;  
		 Date two;  
		 long days=0;
		 try {  
           	 one = df.parse(str1);  
             two = df.parse(str2);  
             long time1 = one.getTime();  
             long time2 = two.getTime();  
             long diff ;  
             diff = time1 - time2;  
             days = diff / (1000 * 60 * 60 * 24);  
	         } catch (ParseException e) {  
	            e.printStackTrace();  
	         }  
	        return days;  
	}
	
	//时间差  （小时）
	public static long  myDatedifferByHour(String str1,String str2){
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date one;  
		 Date two;  
		 long days=0;
		 try {  
           	 one = df.parse(str1);  
             two = df.parse(str2);  
             long time1 = one.getTime();  
             long time2 = two.getTime();  
             long diff ;  
             diff = time1 - time2;  
             days = diff / (1000 * 60 * 60);  
	         } catch (ParseException e) {  
	            e.printStackTrace();  
	         }  
	        return days;  
	}
	/**
	 * 时间差  （天-时-分-秒）
	 * @param str1 大 
	 * @param str2 小
	 * @return
	 */
	public static Map<String,Object>  myDatedifferhms(String str1,String str2){
		Map<String,Object> time = new HashMap<String, Object>();
		try {
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			  java.util.Date now =df.parse(str1);   
			  java.util.Date date=df.parse(str2);   
			  long l=now.getTime()-date.getTime();   
			  long day=l/(24*60*60*1000);   
			  long hour=(l/(60*60*1000)-day*24);   
			  long min=((l/(60*1000))-day*24*60-hour*60);   
			  long s=(l/1000-day*24*60*60-hour*60*60-min*60);   
			  if(day>0){
				  time.put("day",day<10 ? "0"+day:day);
			  }
			  if(hour>0){
				  time.put("hour",hour<10 ? "0"+hour:hour);
			  }
			  if(min>0){
				  time.put("min",min<10 ? "0"+min:min);
			  }
			  if(s>0){
				  time.put("s",s<10 ? "0"+s:s);
			  }
		} catch (ParseException e) {
			e.printStackTrace();
		}
	        return time;  
	}

	//今天是星期几
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
		w = 0;
		return weekDays[w];
	}
	
	
	/**
	 * 获取今天星期几
	 * @param 当前时间
	 * @return
	 */
	public static int getDayOfWeek(Date nowDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 获取今天小时
	 * @param 当前时间
	 * @return
	 */
	public static int getHourOfDay(Date nowDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate); 
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	


	/**
	 * 日期转成字符串格式
	 * @param date
	 * @param pattern  yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public static String dateFormatString(Date date,String pattern ){
		
		if(StringUtils.isBlank(pattern)){
			pattern="yyyyMMddhh";
		}
		try {
			return new SimpleDateFormat(pattern).format(date);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	// 首页固定时间格式-计算预审中的倒计时
	public static String syfromDate (){
		String vv=YXDate.getTime();
		String reslut= "";
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}

			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			reslut = dateformat.format(c.getTime());
		}
		return reslut;
	}
	
	// 发标固定时间格式 
	public static String sendBorrowFromDate (){
		String vv=YXDate.getTime();
		String reslut= "";
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}

			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			reslut = dateformat.format(c.getTime());
		}
		return reslut;
	}
	
	/** 格式化时间    -- 毫秒数  */
	public static String myfromDatebymillisecond (String vv){
		String reslut= "";
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
			reslut = dateformat.format(c.getTime());
		}
		return reslut;
	}
	
	
	
	/** 格式化时间    -- 毫秒数
	 * 商品详情页使用
	 *   */
	public static String myfromDatebymillisecondDetail (String vv){
		String reslut= "";
		if(vv!=null && !"".equals(vv)){
			long time = 0L;
			if (vv.length() < 11)
				time = Long.valueOf(vv).longValue() * 1000L;
			else {
				time = Long.valueOf(vv).longValue();
			}
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(time);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
			reslut = dateformat.format(c.getTime());
		}
		return reslut;
	}
	
	
	public static void main1(String[] args) {
		  try {
			  String time ="";
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			  java.util.Date now =df.parse("2016-01-07 13:31:40");   
			  java.util.Date date=df.parse("2016-01-07 13:31:24");   
			  long l=now.getTime()-date.getTime();   
			  long day=l/(24*60*60*1000);   
			  long hour=(l/(60*60*1000)-day*24);   
			  long min=((l/(60*1000))-day*24*60-hour*60);   
			  long s=(l/1000-day*24*60*60-hour*60*60-min*60);   
			  if(day>0){
				  time+=day+"天";
			  }
			  if(hour>0){
				  time+=hour+"时";
			  }
			  if(min>0){
				  time+=min+"分";
			  }
			  if(s>0){
				  time+=s+"秒";
			  }
			  System.out.println(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 判断字符串是否为日期格式
	 * @param str
	 * @return
	 */
	public static boolean isValidDate(String str) {
		boolean convertSuccess=true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		 } catch (ParseException e) {
			 // e.printStackTrace();
			 // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			 convertSuccess=false;
		} 
			return convertSuccess;
	}
	
	
	/**
	 * 获取系统时间  带毫秒
	 */
	public static String getCurrentTimeMillis(){
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
		return dateformat.format(System.currentTimeMillis());
	}
	
	/**
	 * 获取系统时间(时间戳)  带毫秒
	 */
	public static long getCurrentTimeMillisTimeStamp (){
		return System.currentTimeMillis();
	}
	
	
	
	
	/**
	 * 时间字符串加天数
	 * @author PengYu
	 * @date 2016年6月30日 下午4:22:21
	 */
	public static String getDateTimeAddDay(String d,int days){
		String timeStamp =null;		 
		try {
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = sdf.parse(d);
			 Calendar cal = Calendar.getInstance();
		     cal.setTime(date);
		     
		     cal.add(Calendar.DATE,days);//加1天
		     timeStamp = String.valueOf(cal.getTimeInMillis() / 1000L);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeStamp;
	  }    
	
	
	
	
	
	public static void main(String[] args) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
		System.out.println(getCurrentTimeMillisTimeStamp());
	}

 }      
        
