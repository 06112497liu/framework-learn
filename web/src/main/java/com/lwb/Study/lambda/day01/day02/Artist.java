package com.lwb.Study.lambda.day01.day02;

import java.util.List;

/**
 * 乐队类
 */
public class Artist {

    /**
     * 乐队名称（团体或者个人）
     */
    private String name;

    /**
     * 乐队成员
     */
    private List<String> members;

    /**
     * 乐队来自哪里
     */
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
