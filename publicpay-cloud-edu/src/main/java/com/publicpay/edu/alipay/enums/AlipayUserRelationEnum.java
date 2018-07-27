package com.publicpay.edu.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 孩子与家长的关系： 1、爸爸 2、妈妈 3、爷爷 4、奶奶 5、外公 6、外婆 7、家长
 * @date 2018/7/27 下午2:23
 */
public enum AlipayUserRelationEnum {
    FATHER("1","爸爸"),MOTHER("2","妈妈"),GRANDFATHER("3","爷爷"),GRANDMOTHER("4","奶奶"),
    GRANDPA("5","外公"),GRANDMA("6","外婆"),PARENT("7","家长");

    private String value;
    private String desc;

    AlipayUserRelationEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
