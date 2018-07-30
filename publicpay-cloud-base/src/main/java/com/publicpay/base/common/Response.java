//package com.publicpay.base.common;
//
//
//import com.publicpay.base.encrypt.Coder;
//import com.publicpay.base.encrypt.DESCoder;
//import com.publicpay.base.encrypt.RSACoder;
//import com.publicpay.base.utils.ComUtils;
//import com.publicpay.base.utils.JsonHelper;
//import com.publicpay.base.utils.Md5Util;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 响应报文工具类
// * @author Shixy
// */
//public class Response implements Serializable {
//
//	private static final long serialVersionUID = -7057101792135081848L;
//
//	private int status;
//
//    private String message;
//
//    private Object data;
//
//    private String timestamp;
//
//    private String sign;
//
//    public Response() {
//
//    }
//
//    public Response(ReturnCodeEnum returnCodeEnum){
//        this.status = returnCodeEnum.value();
//        this.message = returnCodeEnum.desc();
//    }
//
//
//    public Response(int status, String message, Object data) {
//		this.status = status;
//        this.message = message;
//        this.data = data;
//    }
//
//    public Response(ReturnCodeEnum returnStatus, Object data) {
//        this.status = returnStatus.value();
//        this.message = returnStatus.desc();
//        this.data = data;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data =  data;
//    }
//
//    public String getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(String timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getSign() {
//        return sign;
//    }
//
//    public void setSign(String sign) {
//        this.sign = sign;
//    }
//
//
//
//    /**
//     * 用token签名
//     * @param accessToken
//     * @return
//     */
//    @Deprecated
//    public String makeSign(String accessToken) {
//        try {
//            if (StringUtils.isNotBlank(accessToken)) {
//                Map<String,Object > paramsMap = JsonHelper.toMap(JsonHelper.toJsonStr(this));
//                paramsMap.remove("data");
//                paramsMap.putAll(JsonHelper.toMap(JsonHelper.toJsonStr(this.data)));
//                paramsMap.remove("sign");
//                paramsMap.remove("message");
//                paramsMap.put("accessToken", accessToken);
//
//                String sortStr = ComUtils.sortStr(paramsMap);
//
//                this.sign = Md5Util.getMd5Str(sortStr);
//            }
//        } catch (Exception ex) {
//
//        }
//        return this.sign;
//    }
//
//    /**
//     * 此方法作废, 功能被Gateway中过滤器替代
//     * @param request
//     */
//    @Deprecated
//    public void buildReponse(String desKey, String privateKey) {
////        try {
////            if (StringUtils.isNotBlank(privateKey) && StringUtils.isNotBlank(desKey)) {
////                Map<String, Object> paramsMap = new HashMap<String, Object>();
////
////                paramsMap.put("status", this.status);
////
////                if (StringUtils.isBlank(this.message)) {
////                	this.message = "";
////                }
////                paramsMap.put("message", this.message);
////
////                if (this.data == null) {
////                	this.data = "{}";
////                }
////                this.data = Coder.encryptBASE64(DESCoder.encrypt(JsonHelper.toJsonStr(this.data).getBytes(), desKey));
////            	paramsMap.put("data", this.data);
////
////                if (StringUtils.isBlank(this.timestamp)) {
////                	this.timestamp = System.currentTimeMillis()+"";
////                }
////                paramsMap.put("timestamp", this.timestamp);
////
////                this.sign = RSACoder.sign(paramsMap, privateKey);
////            }
////        } catch (Exception ex) {
////        	ex.printStackTrace();
////        }
//    }
//
//    /**
//     * 构建加密响应信息
//     * 该方法不需要再程序中被显式的调用
//     * @param desKey
//     * @param privateKey
//     */
//    public void buildReponseWithKey(String desKey, String privateKey) {
//        try {
//            if (StringUtils.isNotBlank(privateKey) && StringUtils.isNotBlank(desKey)) {
//                Map<String, Object> paramsMap = new HashMap<String, Object>();
//
//                paramsMap.put("status", this.status);
//
//                if (StringUtils.isBlank(this.message)) {
//                	this.message = "";
//                }
//                paramsMap.put("message", this.message);
//
//                if (this.data == null) {
//                	this.data = new HashMap<String, Object>();
//                }
//                this.data = Coder.encryptBASE64(DESCoder.encrypt(JsonHelper.toJsonStr(this.data).getBytes(), desKey));
//            	paramsMap.put("data", this.data);
//
//                if (StringUtils.isBlank(this.timestamp)) {
//                	this.timestamp = System.currentTimeMillis()+"";
//                }
//                paramsMap.put("timestamp", this.timestamp);
//
//                this.sign = RSACoder.sign(paramsMap, privateKey);
//            }
//        } catch (Exception ex) {
//        	ex.printStackTrace();
//        }
//    }
//
//    /**
//     * 此方法作废, 功能被Gateway中过滤器替代
//     * @param request
//     */
//    @Deprecated
//    public void buildReponse(HttpServletRequest request) {
//    	if (request != null) {
//    		String desKey = ComUtils.replaceNull2Space(request.getAttribute("desKey")+"");
//    		String privateKey = ComUtils.replaceNull2Space(request.getAttribute("privateKey")+"");
//    		if (StringUtils.isNotBlank(desKey)
//    				&& StringUtils.isNotBlank(desKey)) {
//    			this.buildReponse(desKey, privateKey);
//    		}
//    	}
//    }
//
//    public static void main(String[] args) {
//    	Response response = new Response();
//
//    	Map<String, String> map = new HashMap<String, String>();
//    	response.setData(map);
//
//    	System.out.println(JsonHelper.toJsonStr(response));
//    }
//}
//
