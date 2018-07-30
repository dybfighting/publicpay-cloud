package com.publicpay.base.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生成序列工具类
 * @author : minchao.du
 */
public class SequenceUtil {

    private static AtomicInteger counter = new AtomicInteger(0);
    private static int lastIp = 0;
    private static long lastTimestamp = -1L;       //最后生成id的时间戳 0xFFFFFFFFFFFFFFFF 

    static {
        String hostAddress = "127.0.0.1";

        //初始化idWorkder
        int workerId = 1;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
            String[] numbers = hostAddress.split("\\.");
            workerId = Integer.parseInt(numbers[numbers.length-1]);
            lastIp = workerId;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 取得不重复的32位字符串
     * @return
     */
    public static String getId() {
        String uuid = UUID.randomUUID().toString();
        String id = "";
        String[] strs = uuid.split("-");
        for (String str : strs) {
            id += str;
        }
        return id;
    }

    /**
     * @return String 六位数字字符串
     * @author : minchao.du
     */
    public static  String getSixNumStr(){
        return getNumber(6);
    }

    public static  String getEightNumStr(){
        return getNumber(8);
    }
    
    /**
     * @return String n位数字字符串
     * @author : minchao.du
     */
    public static  String getNumber(int length){
	    String str = "";  
	    Random random = new Random();  
	    for (int i = 0; i < length; i++) {  
	        boolean b = random.nextBoolean();  
//	        if (b) { // 字符串  
//	             // int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母  
//	             str += (char) (65 + random.nextInt(26));// 取得大写字母  
//	         } else { // 数字  
	             str += String.valueOf(random.nextInt(10));  
//	         }
	     }
	    return str;  
    }

    
    /**
     * 生成不重复的总体自增的id，分布式除外
     * 毫秒值 + 3位毫秒内计数器 + 3位ip地址 
     * @author : minchao.du
     * @date : 2017/12/5 AUTO_INC
     */
    public static String getAutoIncSeqId(){
        
        String dateStr = getTimeStamp();
        int num = nextId();
        String numStr = String.format("%03d", num); // 毫秒级计数器
        String lastIpStr = String.format("%03d", lastIp);
        
        return dateStr + numStr + lastIpStr;
    }

    /**
     * 时间戳加6位随机数
     * @author : minchao.du
     * @date : 2017/12/6
     */
    public static String getSeqNo(){
        
        String timeStamp = getTimeStamp();
        String sixNum = getSixNumStr();
        
        return timeStamp + sixNum;
    }

    /* 毫秒级时间戳 */
    public static String getTimeStamp(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
        return sdf.format(new Date());
    }
    
    public static int nextId() {
        int sequence = 0;
        long timestamp = timeGen();     //系统毫秒值
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = counter.incrementAndGet();
            if (sequence < 0) {
                timestamp = tilNextMillis(lastTimestamp); 
            }
        } else {
            synchronized (counter) {
                counter.set(0);// 不在同意毫秒内，counter 置0
                sequence = 0;
            }
        }

        lastTimestamp = timestamp;  //记录最后生成id时间

        return sequence;
    }

    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private static long timeGen() {
        return System.currentTimeMillis();
    }
    
    
    public static void main(String[] args){

       
//        for (int i = 0; i< 1; i++){
//            String sequenceId = getAutoIncSeqId();
//            System.out.println(sequenceId);
//        
//            /*new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    long id = nextId();
//                    System.out.println(id);
//                }
//            }).start();*/
//            
//        }
    	System.out.println(getNumber(6));
    	System.out.println(getNumber(10));
    	System.out.println(getNumber(11));
    	System.out.println(getNumber(16));
    }

}

