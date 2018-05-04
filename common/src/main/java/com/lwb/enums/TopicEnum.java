package com.lwb.enums;

/**
 * @author liuweibo
 * @date 2018/5/4
 */
public enum TopicEnum {

    TEST_TOPIC("test_topic", "测试topic"),;

    TopicEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private String name;

    private String desc;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}