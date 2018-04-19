package com.lwb.Study.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    final static List<BigDecimal> prices = Arrays.asList(
            new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
            new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
            new BigDecimal("45"), new BigDecimal("12"));
    public static void main(String[] args) {
        DateTime now = DateTime.now();

        BigDecimal start = BigDecimal.ZERO;
        final BigDecimal totalOfDiscountedPrices =
                prices.stream()
                        .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                        .reduce(start, (a, b) -> a.add(b));
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    public void test01() {
        Map<Boolean, List<BigDecimal>> rs = prices.stream().collect(Collectors.partitioningBy(o -> o.compareTo(BigDecimal.valueOf(20)) > 0));
    }

    public void test02() {
        // 计算时间差
        LocalDate start=new LocalDate(2012, 12,14);
        LocalDate end=new LocalDate(2012, 12, 15);
        int days = Days.daysBetween(start, end).getDays();

        String dateStr = new DateTime().plusDays(18).plusMonths(1)
            .dayOfWeek().withMinimumValue().toString("yyyy-MM-dd HH:mm:ss");

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        //时间解析
        DateTime dateTime = DateTime.parse("2012-12-21 23:22:45", format);

        //时间格式化，输出==> 2012/12/21 23:22:45 Fri
        String string_u = dateTime.toString("yyyy/MM/dd HH:mm:ss EE");
        System.out.println(string_u);

        //格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五
        String string_c = dateTime.toString("yyyy年MM月dd日 HH:mm:ss EE", Locale.CHINESE);
        System.out.println(string_c);
    }
}
