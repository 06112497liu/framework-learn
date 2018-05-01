//package com.lwb.config;
//
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import com.github.pagehelper.PageInterceptor;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//import javax.sql.DataSource;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * jdbc配置类
// */
//@Configuration
//public class MybatisConfig implements TransactionManagementConfigurer, EnvironmentAware {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisConfig.class);
//
//    private RelaxedPropertyResolver propertyResolver;
//
//    @Value("${mybatis.mapperLocations}")
//    private String mapperLocations;
//
//    @Override
//    public void setEnvironment(Environment environment) {
//        this.propertyResolver = new RelaxedPropertyResolver(environment);
//    }
//
//    @Bean
//    public DataSource dataSource() throws Exception {
//        LOGGER.info("generate datasource bean begin...");
//        Map<String, Object> map = propertyResolver.getSubProperties("jdbc.");
//        DataSource datasource = DruidDataSourceFactory.createDataSource(map);
//        LOGGER.info("generate datasource bean end...");
//        return datasource;
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        this.LOGGER.info("generate sqlSessionFactory bean begin...");
//        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
//        sfb.setDataSource(dataSource());
//        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
//        sfb.setMapperLocations(resources);
//        sfb.setPlugins(new Interceptor[]{pageInterceptor()});
//        SqlSessionFactory sqlSessionFactory = sfb.getObject();
//        this.LOGGER.info("generate sqlSessionFactory bean end...");
//        return sqlSessionFactory;
//    }
//
//
//    @Bean
//    public PageInterceptor pageInterceptor() {
//        this.LOGGER.info("generate pageInterceptor bean begin...");
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        Map<String, Object> map = this.propertyResolver.getSubProperties("pagehelper.");
//        Properties p = new Properties();
//        p.putAll(map);
//        pageInterceptor.setProperties(p);
//        this.LOGGER.info("generate pageInterceptor bean end...");
//        return pageInterceptor;
//    }
//
//
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        try {
//            this.LOGGER.info("generate dataSourceTransactionManager bean begin...");
//            DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
//            this.LOGGER.info("generate dataSourceTransactionManager bean end...");
//            return transactionManager;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("annotationDrivenTransactionManager 异常");
//        }
//    }
//}