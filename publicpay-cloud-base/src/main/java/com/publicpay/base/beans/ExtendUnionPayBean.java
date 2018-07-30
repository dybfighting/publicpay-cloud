package com.publicpay.base.beans;

import java.util.Map;

/**
 * ExtendUnionPayBean
 *
 * @author : minchao.du
 * @description : 银行请求bean
 * @date : 2017/12/4
 */
public class ExtendUnionPayBean {
    
    private UnionPayBean unionPayBean;
    private CardInfo cardInfo;
    private CardCustIno cardCustIno;
    
    private Map<String,String> cardInfoMap;
    private Map<String,String> cardCustInfo;

    public Map<String, String> getCardInfoMap() {
        return cardInfoMap;
    }

    public void setCardInfoMap(Map<String, String> cardInfoMap) {
        this.cardInfoMap = cardInfoMap;
    }

    public Map<String, String> getCardCustInfo() {
        return cardCustInfo;
    }

    public void setCardCustInfo(Map<String, String> cardCustInfo) {
        this.cardCustInfo = cardCustInfo;
    }

    public UnionPayBean getUnionPayBean() {
        return unionPayBean;
    }

    public void setUnionPayBean(UnionPayBean unionPayBean) {
        this.unionPayBean = unionPayBean;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public CardCustIno getCardCustIno() {
        return cardCustIno;
    }

    public void setCardCustIno(CardCustIno cardCustIno) {
        this.cardCustIno = cardCustIno;
    }
}
