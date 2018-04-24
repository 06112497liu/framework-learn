package com.lwb.demo.guava;

import com.google.common.collect.Range;
import org.junit.Test;

/**
 * @Author liuweibo
 * @Date ${date}
 **/
public class GuavaDemo {

    @Test
    public void test01() {
        Range range1 = Range.open(9, 11);
        Range range2 = Range.open(10, 12);
        Range range3 = Range.open(5, 6);
        boolean flag = range1.isConnected(range2);
        System.out.println(flag);

        Boolean t = Boolean.valueOf(true);
        Boolean f = Boolean.valueOf(true);
        System.out.println(t == f);
    }
}
