package com.qs.enumutil;

public enum StatusEnum {
    ONE("1", "吃饭"), TWO("2", "睡觉"), ;

    private String code;
    private String act;
    StatusEnum(String s, String a) {
        this.code = s;
        this.act = a;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }


}
