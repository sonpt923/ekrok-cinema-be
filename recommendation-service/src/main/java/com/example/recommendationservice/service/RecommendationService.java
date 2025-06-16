package com.example.recommendationservice.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final JavaSparkContext sparkContext;
    private final SparkSession sparkSession;

    public RecommendationService(JavaSparkContext sparkContext, SparkSession sparkSession) {
        this.sparkContext = sparkContext;
        this.sparkSession = sparkSession;
    }

    public List<String> recommendForUser(String userId) {
        JavaRDD<String> data = sparkContext.textFile("path/to/data.csv");

        // Logic xử lý, ví dụ filter, group, map
        JavaRDD<String> recommended = data.filter(line -> line.contains(userId));
        return recommended.collect();
    }

}
