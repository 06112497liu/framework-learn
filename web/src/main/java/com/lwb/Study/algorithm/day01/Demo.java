package com.lwb.Study.algorithm.day01;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<MaxSumAndList> rs = calMaxCombination(Arrays.asList(1, 2, -3, 3, -1));
        System.out.println(rs);
    }

    /**
     * 对于一个有正有负的整数数组，请找出总和最大的连续数列。给定一个int数组A和数组大小n，请返回最大的连续数列的和
     */
    public static List<MaxSumAndList> calMaxCombination(List<Integer> list) {
        Integer max = 0;
        Integer maxTemp = 0;
        List<Integer> maxList = new LinkedList<>();
        List<MaxSumAndList> rs = new LinkedList<>();
        for (int i=0; i<list.size(); i++) {
            if (i == 0) {
                max = list.get(i);
                maxList.add(list.get(i));
            }
            List<Integer> maxTempList = new LinkedList<>();
            for (int j=i; j<list.size(); j++) {
                Integer val = list.get(j);
                maxTemp = maxTemp + val;
                maxTempList.add(val);
                if (maxTemp > max) {
                    rs.clear();
                    max = maxTemp;
                    rs.add(new MaxSumAndList(max, new LinkedList<>(maxTempList)));
                } else if (maxTemp == max) {
                    rs.add(new MaxSumAndList(max, new LinkedList<>(maxTempList)));
                }
            }
            maxTemp = 0;
        }
        return rs;
    }
}

class MaxSumAndList {

    private Integer total;

    private List<Integer> list;

    public MaxSumAndList() {
    }

    public MaxSumAndList(Integer total, List<Integer> list) {
        this.total = total;
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MaxSumAndList{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
