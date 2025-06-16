package com.example.recommendationservice.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Value("${spring.spark.master}")
    private String masterUri;

    @Value("${spring.spark.app.name}")
    private String appName;

    @Bean
    public JavaSparkContext javaSparkContext() {
        SparkConf sparkConf = new SparkConf()
                .setAppName(appName)
                .setMaster(masterUri);
        return new JavaSparkContext(sparkConf);
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .appName(appName)
                .master(masterUri)
                .getOrCreate();
    }

}
