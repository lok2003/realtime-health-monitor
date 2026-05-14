package com.loki.devops.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
        System.out.println("🚀 Real-time Health Monitor is running on http://localhost:8080/api/realtime-stats");
    }
}
