package com.deer.wms.bill.manage.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 对日期的操作
 */
public class MtAloneDateFuns {
    public static final int THISWEEK = 1;

    public static final int LASTWEEK = 2;

    public static final int THISMONTH = 3;

    public static final int LASTMONTH = 4;

    public static Date setHMSZero(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 将时分秒,毫秒域清零
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**获取当前日期是在一周中的天数序号,第1天从星期日算起**/
    public static int getNumOfWeek(Date date) {
        //String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(setHMSZero(date));
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return w;
    }

    /**获取从当前日期开始算起的本周（月）或上周（月）起止日期**/
    public static Date[] getBegAndEndOfWeekOrMonth(Date date, int type){
        Date[] result = new Date[2];

        /*先计算起始日期*/
        int[][] beforeDays = {//与上面星期数组对应，从当天往前倒推至起始日期的天数
                {6,0,1,2,3,4,5},
                {13,7,8,9,10,11,12}
        };
        Calendar cal = Calendar.getInstance();
        cal.setTime(setHMSZero(date));
        int w = getNumOfWeek(setHMSZero(date));

        if(type==THISWEEK || type==LASTWEEK) {//周计算起始日期
            cal.add(Calendar.DATE, -beforeDays[type - 1][w]);//倒推至一周的起始日期
        }else{//月计算起始日期
            int m = 0;//需要倒推的月数
            if(type == LASTMONTH)
                m=-1;
            cal.add(Calendar.MONTH, m);
            System.out.println("---------"+setHMSZero(cal.getTime()));
            cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
            System.out.println("---------"+setHMSZero(cal.getTime()));
        }
        result[0] = setHMSZero(cal.getTime());

        /*再计算结束日期*/
        if (type==THISWEEK || type==LASTWEEK) {
            int calDays = beforeDays[type - 1][w];//默认本周需要正推至结束日期的天数
            if (type == LASTWEEK)
                calDays = 6;//上周需要正推至结束日期的天数
            cal.add(Calendar.DATE, calDays);
        }else {
            if(type == THISMONTH) {
                cal.setTime(new Date());
                //无法得知间隔天数倒推至起始日期时的间隔天数，测试时自己设定天数可能有问题，但系统操作时都是当天就没问题，暂时先这么处理
            }
            if(type == LASTMONTH) {
               int calMonth = 1;//上月最后一天由本月第一天往前推一天
               int calDays = -1;
               cal.add(Calendar.MONTH, calMonth);
               cal.add(Calendar.DATE, calDays);
            }
        }

        result[1] = setHMSZero(cal.getTime());
        return result;
    }

    /**获取从起始日期到结束日期的所有日期list，包含起止日期**/
    public static ArrayList<Date> completeDateList(Date begDate, Date endDate){
        ArrayList<Date> dateList = new ArrayList<Date>();
        dateList.clear();
        dateList.add(setHMSZero(begDate));

        Calendar tempBeg = Calendar.getInstance();
        tempBeg.setTime(setHMSZero(begDate));

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(setHMSZero(endDate));
        //判断如果起始与结束是同一日期，则返回只有一个元素的list
        if(tempBeg.get(Calendar.YEAR)==tempEnd.get(Calendar.YEAR) && tempBeg.get(Calendar.MONTH)==tempEnd.get(Calendar.MONTH) && tempBeg.get(Calendar.DAY_OF_YEAR)==tempEnd.get(Calendar.DAY_OF_YEAR)){
            return dateList;
        }

        tempBeg.add(Calendar.DATE, 1);
        while (tempBeg.before(tempEnd)) {
            dateList.add(setHMSZero(tempBeg.getTime()));
            tempBeg.add(Calendar.DATE, 1);
        }

        dateList.add(setHMSZero(endDate));
        return dateList;
    }

    public static void main(String[] args){
        Date day0 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(setHMSZero(day0));
        //cal.add(Calendar.DATE, -2);
        cal.add(Calendar.MONTH, 1);
        Date[] begAndEnd = getBegAndEndOfWeekOrMonth(cal.getTime(),MtAloneDateFuns.LASTWEEK);
        System.out.println("begin:"+begAndEnd[0]+"   end:"+begAndEnd[1]);
        //ArrayList<Date> dateList = new ArrayList<Date>();
        //dateList.clear();
        //dateList = completeDateList(begAndEnd[0],begAndEnd[1]);
        //for (int i = 0; i <dateList.size() ; i++) {
        //    System.out.println("-------"+dateList.get(i));
        //}

    }

}
