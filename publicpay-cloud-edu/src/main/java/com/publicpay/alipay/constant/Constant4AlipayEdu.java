package com.publicpay.alipay.constant;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.constant
 * @Description: TODO
 * @date 2018/7/19 上午10:44
 */
public class Constant4AlipayEdu {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    /**
     * 公共
     */
    public static final String CODE = "code";
    public static final String MSG = "msg";
    public static final String SUB_CODE = "sub_code";
    public static final String SUB_MSG = "sub_msg";
    public static final String SIGN = "sign";
    /**
     * 商户授权
     */
    public static final String AUTHORIZATION_CODE= "authorization_code";//商户授权类型：通过code生成token
    public static final String REFRESH_TOKEN = "refresh_token";//刷新token
    public static final String GRANT_TYPE = "grant_type";//商户授权类型



    public static final String AUTH_APP_ID = "auth_app_id";//授权商户的appid(即开发者appId)
    public static final String APP_AUTH_TOKEN = "app_auth_token";//应用授权令牌
    public static final String APP_REFRESH_TOKEN = "app_refresh_token";//刷新令牌
    public static final String EXPIRES_IN = "expires_in";//应用授权令牌的有效时间（从接口调用时间作为起始时间），单位到秒
    public static final String RE_EXPIRES_IN = "re_expires_in";//刷新令牌的有效时间（从接口调用时间作为起始时间），单位到秒

    /**
     * 教育缴费学校信息录入接口
     */
    public static final String APP_ID = "app_id";//支付宝分配给开发者的应用ID
    public static final String SCHOOL_NAME = "school_name";//学校名称
    public static final String SCHOOL_ICON = "school_icon";//学校的校徽或logo，在学校展示页面作为学校的标识。该字段为图片的链接地址，只支持png或jpg图片格式，图片高度为108，宽度为108 ，不大于20k。注意：此链接要求公网可以访问，否则无法正常展示。
    public static final String SCHOOL_ICON_TYPE = "school_icon_type";//如果填写了school_icon参数，则此字段不能为空。目前只支持png和jpg两种格式
    public static final String SCHOOL_STDCODE = "school_stdcode";//学校(机构)标识码（由教育部按照国家标准及编码规则编制，可以在教育局官网查询）
    public static final String SCHOOL_TYPE = "school_type";//学校的类型：1：代表托儿所； 2：代表幼儿园；3：代表小学；4：代表初中；5：代表高中。如果学校兼有多种属性，可以连写，比如：45：代表兼有初中部高中部；34：代表兼有小学部初中部
    public static final String PROVINCE_CODE = "province_code";//省份的国家编码（国家统计局出版的行政区划代码 http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/）
    public static final String PROVINCE_NAME = "province_name";//省名称
    public static final String CITY_CODE = "city_code";//城市的国家编码（国家统计局出版的行政区划代码 http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/）
    public static final String CITY_NAME = "city_name";//城市名称
    public static final String DISTRICT_CODE = "district_code";//区县的国家编码（国家统计局出版的行政区划代码 http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/）
    public static final String DISTRICT_NAME = "district_name";//区县名称
    public static final String ISV_NO = "isv_no";//注意：本参数从1.3版本开始已经废弃，不再需要传递。由支付宝提供的给已经签约的isv的编码，业务上一般直接采用isv的支付宝PID
    public static final String ISV_NAME = "isv_name";//商家名称，每个接入教育缴费的ISV商家名称，由ISV自己提供
    public static final String ISV_NOTIFY_URL = "isv_notify_url";//此通知地址是为了保持教育缴费平台与ISV商户支付状态一致性。用户支付成功后，支付宝会根据本isv_notify_url，通过POST请求的形式将支付结果作为参数通知到商户系统，ISV商户可以根据返回的参数更新账单状态。
    public static final String ISV_PID = "isv_pid";//填写已经签约教育缴费的isv的支付宝PID
    public static final String ISV_PHONE = "isv_phone";//ISV联系电话,用于账单详情页面显示
    public static final String SCHOOL_PID = "school_pid";//学校用来签约支付宝教育缴费的支付宝PID
    public static final String BANKCARD_NO = "bankcard_no";//对应集团到卡模式的银行编号.学校与支付宝后台签约时，由学校提交给支付宝的编号
    public static final String BANK_UID = "bank_uid";//与浙江网商交易见证平台有交互的ISV在创建账户获得的member_id，由网商分配
    public static final String BANK_NOTIFY_URL = "bank_notify_url";//与浙江网商交易见证平台有交互ISV输入网商交易异步通知回调URL，教育缴费同步账单信息给网商，网商会回调此url，ISV即可获取网商相关的参数，根据教育缴费平台账单发送接口返回的 order_no和网商返回的outer_trade_no来对应账单信息。
    public static final String BANK_PARTNER_ID = "bank_partner_id";//与浙江网商交易见证平台有交互的ISV,由交易见证平台分配给合作方业务平台 签约唯一ID ，由网商分配给ISV的渠道参数
    public static final String WHITE_CHANNEL_CODE = "white_channel_code";//与浙江网商交易见证平台有交互的ISV,由网商分配给ISV的渠道参数


    public static final String STATUS = "status";//Y：代表成功；N：代表失败
    public static final String SCHOOL_NO = "school_no";//支付宝分配给学校的编码，作为学校在支付宝的标识


    /**
     * 教育缴费账单发送接口
     */
    public static final String USERS = "users";//孩子的家长信息，最多一次输入10个家长，此字段做为识别家长的孩子用，与student_identify、student_code至少选一个
    public static final String USER_MOBILE = "user_mobile";//孩子家长的手机号，可根据此手机号推送账单消息给家长，如果有此家长，则家长手机号必填
    public static final String USER_NAME = "user_name";//家长姓名
    public static final String USER_RELATION = "user_relation";//孩子与家长的关系： 1、爸爸 2、妈妈 3、爷爷 4、奶奶 5、外公 6、外婆 7、家长
    public static final String USER_CHANGE_MOBILE = "user_change_mobile";//用户变更手机号，替换旧的手机号，只有修改手机号时，此项才需要填
    public static final String CHILD_NAME = "child_name";//孩子名字
    public static final String GRADE = "grade";//孩子所在年级
    public static final String CLASS_IN = "class_in";//孩子所在班级
    public static final String STUDENT_CODE = "student_code";//学生的学号，只支持字母和数字类型，一般以教育局学号为准，作为学生的唯一标识。此字段与student_identify、家长user_mobile至少选一个
    public static final String STUDENT_IDENTIFY = "student_identify";//学生的身份证号，如果ISV有学生身份证号，则同步身份证号作为学生唯一标识。此字段与student_code、家长user_mobile至少选一个。大陆身份证必须是18位 ， 其它地区或国家的身份证开头需要加"IC"开头区分并且不超过18位，但查询账单的时候不要带"IC"
    public static final String OUT_TRADE_NO = "out_trade_no";//ISV端的缴费账单编号
    public static final String CHARGE_BILL_TITLE = "charge_bill_title";//缴费账单名称
    public static final String CHARGE_TYPE = "charge_type";//缴费项模式：空或"N"，表示缴费项不可选，"M"表示缴费项为可选 ，支持单选和多选。
    public static final String CHARGE_ITEM = "charge_item";//缴费详情：输入json格式字符串。Json定义：key填写缴费项名称，value填写缴费项金额，金额保留2位小数
    public static final String CHARGEITEM = "chargeItem";
    public static final String ITEM_NAME = "item_name";//缴费项名称
    public static final String ITEM_PRICE = "item_price";//缴费项金额
    public static final String ITEM_SERIAL_NUMBER = "item_serial_number";//缴费项序号，如果缴费项是多选模式，此项为必填，建议从1开始的连续数字，用户支付成功后，通过passback_params参数带回已选择的缴费项。例如:orderNo=uoo234234&isvOrderNo=24werwe&items=1-2|2-1|3-51-2|2-1|3-5 表示：缴费项序列号-缴费项数|缴费项序列号-缴费项数
    public static final String ITEM_MAXIMUM = "item_maximum";//缴费项最大可选数如果缴费项是多选模式，此参数生效，范围是1-9，如果为空，则最大项默认为9
    public static final String ITEM_MANDATORY = "item_mandatory";//缴费项是否必选如果缴费项是多选模式，此参数生效。 “Y”表示必填，“N”或空表示非必填。
    public static final String AMOUNT = "amount";//总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]，如果是非多选项，是要和缴费项的总和相同，多选模式不做验证
    public static final String GMT_END = "gmt_end";//缴费截止时间，格式"yyyy-MM-dd HH:mm:ss"，日期要大于当前时间。请注意，过期时间不宜设置过短。
    public static final String END_ENABLE = "end_enable";//截止日期是否生效，与gmt_end发布配合使用,N为gmt_end不生效，用户过期后仍可以缴费；Y为gmt_end生效，用户过期后，不能再缴费。
    public static final String PARTNER_ID = "partner_id";//Isv支付宝pid, 支付宝签约后，返回给ISV编号

    public static final String ORDER_NO = "order_no";//支付宝－中小学－教育缴费的账单号

    /**
     * 教育缴费账单状态同步接口
     */
    public static final String TRADE_NO = "trade_no";//支付宝返回的交易号
    public static final String FUND_CHANGE = "fund_change";//本次退款是否发生了资金变化
    public static final String REFUND_AMOUNT = "refund_amount";//需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
    public static final String REFUND_REASON = "refund_reason";//退款原因，商家根据客户实际退款原因填写
    public static final String OUT_REQUEST_NO = "out_request_no";//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
    public static final String BUYER_LOGON_ID = "buyer_logon_id";//退款时，支付宝返回的用户的登录id
    public static final String GMT_REFUND = "gmt_refund";//支付宝返回的退款时间，而不是商户退款申请的时间
    public static final String BUYER_USER_ID = "buyer_user_id";//支付宝返回的买家支付宝用户id
    public static final String REFUND_DETAIL_ITEM_LIST = "refund_detail_item_list";//支付宝返回的退款资金渠道，json格式字符串

    /**
     * 缴费账单查询
     */
    public static final String ORDER_STATUS = "order_status";//NOT_PAY 待缴费 ,PAYING 支付中 ,PAY_SUCCESS 支付成功，处理中BILLING_SUCCESS 缴费成功TIMEOUT_CLOSED 逾期关闭账单ISV_CLOSED 账单关闭


    /**
     * 支付宝支付结果通知接口参数
     */
    public static final String NOTIFY_TIME = "notify_time";//
    public static final String FUND_CHANNEL = "fundChannel";//支付渠道

    /**
     * 学生信息查询接口参数
     */
    public static final String STUDENT_NO = "student_no";

    /**
     * 退款接口
     */
    public static final String REFUND_FEE = "refund_fee";
    public static final String OPERATOR_ID = "operator_id";//String	可选	30	商户的操作员编号
    public static final String STORE_ID = "store_id";//可选	32	商户的门店编号
    public static final String TERMINAL_ID = "terminal_id";//可选	32	商户的终端编号
    public static final String REFUND_CURRENCY = "refund_currency";//可选	8	订单退款币种信息
    public static final String GMT_REFUND_PAY = "gmt_refund_pay";//Date	必填	32	退款支付时间
    public static final String STORE_NAME = "store_name";//String	选填	512	交易在支付时候的门店名称
    public static final String PRESENT_REFUND_BUYER_AMOUNT = "present_refund_buyer_amount";//String	选填	11	本次退款金额中买家退款金额
    public static final String PRESENT_REFUND_DISCOUNT_AMOUNT = "present_refund_discount_amount";//String	选填	11	本次退款金额中平台优惠退款金额
    public static final String PRESENT_REFUND_MDISCOUNT_AMOUNT = "present_refund_mdiscount_amount";//String	选填	11	本次退款金额中商家优惠退款金额
    public static final String GOODS_DETAIL = "goods_detail";
    public static final String GOODS_ID = "goods_id";
    public static final String ALIPAY_GOODS_ID = "alipay_goods_id";
    public static final String GOODS_NAME = "goods_name";
    public static final String QUANTITY = "quantity";
    public static final String PRICE = "price";
    public static final String GOODS_CATEGORY = "goods_category";
    public static final String BODY = "body";
    public static final String SHOW_URL = "show_url";
    public static final String REFUND_ROYALTY_PARAMETERS = "refund_royalty_parameters";
    public static final String ROYALTY_TYPE = "royalty_type";
    public static final String TRANS_OUT = "trans_out";
    public static final String TRANS_OUT_TYPE = "trans_out_type";
    public static final String TRANS_IN_TYPE = "trans_in_type";
    public static final String TRANS_IN = "trans_in";
    public static final String AMOUNT_PERCENTAGE = "amount_percentage";
    public static final String DESC = "desc";

    /**
     * 优惠券信息
     */
    public static final String NAME = "name";

}
