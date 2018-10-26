package com.jcl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderNumUUId extends Thread{
	 
    
    public static void main(String[] args)  {  
    	OrderNumUUId.getOrderNo();
    }
    /** 
     * 生成订单编号 
     * @return 
     */  
    public static synchronized String getOrderNo() {  
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<4;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }
}
