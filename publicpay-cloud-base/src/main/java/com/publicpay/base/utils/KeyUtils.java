//package com.publicpay.base.utils;
//
//import com.pay.common.util.DesUtil;
//import com.pay.common.util.ISO8583.ISO8583Utile;
//import com.publicpay.base.common.Constants;
//import com.publicpay.base.encrypt.DESCoder;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.security.MessageDigest;
//
///**
// * 秘钥相关工具类
// * Created by Shixy on 2017/12/1.
// */
//public class KeyUtils {
//
//    private final static Logger logger = LoggerFactory.getLogger(KeyUtils.class);
//
//    private final static String SUPER_KEY = "8CD8DCCE963E63AC";
//
//    private final static String SUPER_TRANS_KEY = "PUB8DCCE963E6PAY";
//
//    private final static String KVC_KEY = "0000000000000000";
//
//    public final static String MASTER_KEY = "masterKey";
//
//    public final static String PIN_KEY = "pinKey";
//
//    public final static String MAC_KEY = "macKey";
//
//    public final static String TRANS_KEY = "transKey";
//
//    /**
//     * 生成主秘钥
//     * @param sn
//     * @param posType
//     * @return
//     * @throws Exception
//     */
//    public static String getMasterKey_kvc(String transmissionKey, String orgiMasterKey) {
//
//        String master_kvc = "";
//
//        try {
//
//            String kvc = DesUtil.desEncrypt(KVC_KEY, orgiMasterKey);
//
//            master_kvc = DesUtil.desEncrypt(orgiMasterKey, transmissionKey) + kvc.substring(0, 8);
//        } catch (Exception ex) {
//            logger.error("KeyUtils.getMasterKey_kvc 执行出错:{}", ex);
//        }
//
//        logger.debug("KeyUtils.getMasterKey_kvc 输出结果 transmissionKey={}, master_kvc={}", transmissionKey, master_kvc);
//
//        return master_kvc;
//    }
//
//    /**
//     * 得到加密后带kvc的pinKey/macKey
//     * @param orgiKey
//     * @param origMasterKey
//     * @return
//     */
//    public static String getKey_kvc(String orgiKey, String origMasterKey) {
//
//    	String key_kvc = "";
//
//    	try {
//    		String key = DesUtil.desEncrypt(orgiKey, origMasterKey);
//
//            key_kvc = key + DesUtil.desEncrypt(KeyUtils.KVC_KEY, orgiKey).substring(0, 8);
//    	} catch (Exception ex) {
//    		logger.error("KeyUtils.getKey_kvc 执行出错:{}", ex);
//    	}
//
//        return key_kvc;
//    }
//
//    /**
//     * 生成传输秘钥
//     * @param sn
//     * @param posType
//     * @return
//     * @throws Exception
//     */
//    public static String getTransmissionKey(String sn, String posType, String softVersion) {
//
//        String hexString = "";
//
//        try {
//            MessageDigest sha1 = null;
//            sha1 = MessageDigest.getInstance("SHA-1");
//            //卡友机具sn末位+sn+sn首位来加密
//            if(StringUtils.isNotBlank(softVersion) && softVersion.startsWith("N")) {
//            	sn = sn.substring(sn.length()-1,sn.length()) + sn + sn.substring(0,1);
//            }
//            sha1.update(sn.getBytes());
//            byte[] digest = sha1.digest();
//
//            byte[] resultBytes = new byte[8];
//            if("N38".equals(posType)){
//                System.arraycopy(digest, 0, resultBytes, 0, 4);
//                System.arraycopy(digest, digest.length - 4, resultBytes, 4, 4);
//            }else if("C821".equals(posType)){
//                System.arraycopy(digest, digest.length - 8 , resultBytes, 0, 8);
//            }else if("ME30".equals(posType) || "ME11".equals(posType)){
//                System.arraycopy(digest, 1, resultBytes, 0, 4);
//                System.arraycopy(digest, digest.length - 5, resultBytes, 4, 4);
//            }
//            else if("M35".equals(posType)){
//                System.arraycopy(digest, 0, resultBytes, 0, 8);
//            }else{
//                System.arraycopy(digest, 0, resultBytes, 0, 8);
//            }
//            hexString = ISO8583Utile.bytesToHexString(resultBytes);
//        } catch (Exception ex) {
//            logger.error("KeyUtils.getTransmissionKey 执行出错:{}", ex);
//        }
//
//        logger.info("KeyUtils.getTransmissionKey 输出结果 sn={}, posType={}, softVersion={}, tansKey={}", sn, posType, softVersion, hexString);
//
//        return hexString;
//    }
//
//    /**
//     * 生成加密后传输秘钥
//     * @param transmissKey 原始传输秘钥
//     * @return
//     * @throws Exception
//     */
//    public static String encryptTransmissKey(String transmissKey) {
//
//    	String transKey = "";
//
//    	try {
//    		transKey = DesUtil.desEncrypt(transmissKey, KeyUtils.SUPER_TRANS_KEY);
//    	} catch (Exception ex) {
//    		logger.error("KeyUtils.encryptTransmissKey 执行出错:{}", ex);
//    	}
//
//    	return transKey;
//    }
//
//    /**
//     * 得到原始传输秘钥
//     * @param transKey 加密后的传输秘钥
//     * @return
//     */
//    public static String decryptTransKey(String transKey) {
//
//    	String transmissKey = "";
//
//    	try {
//    		transmissKey = DesUtil.desDecrypt(transKey, KeyUtils.SUPER_TRANS_KEY);
//    	} catch (Exception ex) {
//    		logger.error("KeyUtils.decryptTransKey 执行出错:{}", ex);
//    	}
//
//    	return transmissKey;
//    }
//
//    /**
//     * 生成传输秘钥
//     * @param sn
//     * @param posType
//     * @return
//     * @throws Exception
//     */
//    public static String getTransmissionKey_old(String sn, String posType) {
//
//        String hexString = "";
//
//        try {
//            MessageDigest sha1 = null;
//            sha1 = MessageDigest.getInstance("SHA-1");
//            sha1.update(sn.getBytes());
//            byte[] digest = sha1.digest();
//
//            byte[] resultBytes = new byte[8];
//            if("N38".equals(posType)){
//                System.arraycopy(digest, 0, resultBytes, 0, 4);
//                System.arraycopy(digest, digest.length - 4, resultBytes, 4, 4);
//            }else if("C821".equals(posType)){
//                System.arraycopy(digest, digest.length - 8 , resultBytes, 0, 8);
//            }else if("ME30".equals(posType)){
//                System.arraycopy(digest, 1, resultBytes, 0, 4);
//                System.arraycopy(digest, digest.length - 5, resultBytes, 4, 4);
//            }else if("M35".equals(posType)){
//                System.arraycopy(digest, 0, resultBytes, 0, 8);
//            }else{
//                System.arraycopy(digest, 0, resultBytes, 0, 8);
//            }
//            hexString = ISO8583Utile.bytesToHexString(resultBytes);
//        } catch (Exception ex) {
//            logger.error("KeyUtils.getTransmissionKey 执行出错:{}", ex);
//        }
//
//        logger.debug("KeyUtils.getTransmissionKey 输出结果 sn={}, posType={}, tansKey={}", sn, posType, hexString);
//
//        return hexString;
//    }
//
//    /**
//     * 软加密得到MacSign
//     * @param source
//     * @param macKey
//     * @return
//     */
//    public static String getMacSign(String source, String macKey) {
//
//        logger.debug("KeyUtils.getMacSign 传入参数 source={}, macKey={}", source, macKey);
//
//        String macSign = "";
//
//        try {
//            if (StringUtils.isNotBlank(source) && StringUtils.isNotBlank(macKey)) {
//
//                byte[] rawMacData = source.getBytes();
//
//                String str=ISO8583Utile.bytesToHexString(rawMacData);
//                byte [] macStr=ISO8583Utile.string2Bcd(str);
//                String ss1=ISO8583Utile.getXorString(macStr);  //对报文异或
//                String before8=ISO8583Utile.toHexString(ss1.substring(0,8));
//
//                //String bankmac= EsscUtil.createMacForBank(Constant.INTERFACE_CODE,bankPosCati, ISO8583Utile.string2Bcd(before8));  // 取前8个字节进行加密
//                String bankmac = DesUtil.desEncrypt(before8, macKey);
//
//                String after8=ISO8583Utile.toHexString(ss1.substring(8,16));  //后8直接转16进制数字
//                byte [] xfo=ISO8583Utile.string2Bcd(bankmac+after8);
//                String xforesult=ISO8583Utile.getXorString(xfo); // 将加密后的结果与后8 个字节异或
//
//                //String macResult=EsscUtil.createMacForBank(Constant.INTERFACE_CODE,bankPosCati, ISO8583Utile.string2Bcd(xforesult));//用异或的结果TEMP BLOCK 再进行一次加密
//                macSign = DesUtil.desEncrypt(xforesult, macKey);
//
//                if (StringUtils.isNotBlank(macSign) && macSign.length() > 7) {
//                    macSign = macSign.substring(0, 8);
//                }
//
//            }
//        } catch (Exception ex) {
//            logger.error("KeyUtils.getMacSign 执行出错:{}", ex);
//        }
//
//        logger.debug("KeyUtils.getMacSign 输出参数 macSign={}", macSign);
//
//        return macSign;
//
//    }
//
//    /**
//     * 解密PIN
//     * @param pin
//     * @param cardNo
//     * @param pinKey
//     * @return
//     */
//    public static String getOrgiPin(String pin, String cardNo, String pinKey) {
//        logger.debug("KeyUtils.getOrgiPin 输入参数 pin={}, cardNo={}, pinKey={}", pin, cardNo, pinKey);
//
//        String orgiPin = "";
//
//        try {
//            String subPan = cardNo.substring(cardNo.length()-13, cardNo.length()-1);
//
//            byte[] xors= ISO8583Utile.hexStringToByte(DesUtil.desDecrypt(pin, pinKey));
//
//            byte[] pinBlock = getXOR(xors, ISO8583Utile.hexStringToByte("0000" + subPan), 8);
//
//            String pinHex = ISO8583Utile.bytesToHexString(pinBlock);
//
//            if (StringUtils.isNotBlank(pinHex) && pinHex.length() > 7) {
//                orgiPin = pinHex.substring(2, 2 + Integer.valueOf(pinHex.substring(0, 2)));
//            }
//
//            logger.debug("KeyUtils.getOrgiPin 输出参数 pin={}, cardNo={}, pinKey={}, orgiPin={}, pinHex={}", pin, cardNo, pinKey, pinHex, orgiPin);
//
//        } catch (Exception ex) {
//            logger.error("KeyUtils.getOrgiPin 执行出错:{}", ex);
//        }
//
//        return orgiPin;
//    }
//
//    /**
//     * 还原字符串
//     * @param source
//     * @param key
//     * @return
//     */
//    public static String getOrgiStr(String source, String key) {
//        String orgiStr = "";
//
//        try {
//            String str = DesUtil.desDecrypt(source, key);
//            if (StringUtils.isNotBlank(str) && str.length() > 0) {
//                orgiStr = str.substring(1, str.length() - Integer.valueOf(str.substring(0, 1)));
//            }
//        } catch (Exception ex) {
//            logger.error("KeyUtils.getOrgiStr 执行出错:{}", ex);
//        }
//
//        return orgiStr;
//    }
//
//    public static byte[] getXOR(byte[] xorSou,byte[] tar,int length){
//        byte[]   sum=new byte[length];
//        for (int i = 0; i < length; i++) {
//            sum[i]=(byte) (xorSou[i]^tar[i]);
//        }
//        return sum;
//
//    }
//
//    /**
//     * 获取缓存中的秘钥
//     * @param callerType
//     * @param callerCode
//     * @param keyType
//     * @return
//     */
//    public static String getCacheKey(String keyType, String callerType, String callerCode){
//        String key = "";
//        if (Constants.USER.equals(callerType)) {
//        	key = RedisUtils.getString(keyType, Constants.USER);
//        } else if (Constants.DEVICE.equals(callerType)) {
//        	key = RedisUtils.getString(keyType, Constants.DEVICE);
//        }else {
//        	key = RedisUtils.getString(keyType, callerCode);
//        }
//        return key;
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        /**计算DES加密*/
//        String inputStr = "abcdef12345678";
//        String key = "15810000325-1512461497858-0000000";
//
//        String inputStr_en = DESCoder.encryptToHexString(inputStr, key);
//
//        String outputStr = DESCoder.decryptHexString(inputStr_en, key);
//
//        logger.debug("str1={}, key={}, inputStr_en={}, str={}", inputStr, key, inputStr_en, outputStr);
//
//        /**计算macSign*/
//        String serialNo = "5031779992090239";
//        String source = "accNo=50FDA2813421F384B84A570526CBC517559E6BCA31816EE5&accountPeriod=201712&amount=1&bussCode=D1_2900_0050&expired=2304&icCardData=9F26082D088FF14164107B9F2701809F101307010103A0A000010A0100000000001D37CF069F37040004735E9F3602003E950580000008009A031712189C01009F02060000000000005F2A02015682027C009F1A0201569F03060000000000009F330390C8C09F34033F00009F3501229F1E0831323334353637388408A0000003330101019F090200209F410400000003&icCardSeqNumber=01&origQryId=391712182120055149188&outorderNo=644aa0f5ab253e84e2f7705250ad102b&phoneNumber=15822511708&pin=841BE72EC7AF161B&posEntryModeCode=05&serialNo=6692017060200002&track2=50FDA2813421F384B84A570526CBC5177B749DB92CDAB502921431DE9BC2099380C2FF1F3C0BFEAF&type=POWER&unitCode=D1_2900_0050&unitName=上海市电力公司&userNo=1327345270";
//        String masterKey = "A6A673F8A8D79375A02EA38B".substring(0, 16);
//        String macKey = "BF0ACA2A225503055D8B8950".substring(0, 16);
//        String softVersion = "2017081501";
//
//        String transmissionKey = KeyUtils.getTransmissionKey(serialNo, "", softVersion);
//
//        String orgiMasterKey = DesUtil.desDecrypt(masterKey, transmissionKey);
//
//        String orgiMacKey = DesUtil.desDecrypt(macKey, orgiMasterKey);
//
//        String macSign = KeyUtils.getMacSign(source, orgiMacKey);
//
//        logger.info("serialNo={}, transmissionKey={}, source={}, macKey={}, orgiMacKey={}, macSign={}",
//                serialNo, transmissionKey, source, macKey, orgiMacKey, macSign);
//
//    }
//}
