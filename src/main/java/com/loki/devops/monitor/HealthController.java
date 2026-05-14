package com.loki.devops.monitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

import java.util.Map;

@RestController
public class HealthController {

    private final SystemInfo si = new SystemInfo();

    // Home Page API
    @GetMapping("/")
    public String home() {
        return "Realtime Health Monitor Running Successfully";
    }

    // Realtime System Stats API
    @GetMapping("/api/realtime-stats")
    public Map<String, Object> getStats() {

        CentralProcessor processor = si.getHardware().getProcessor();

        // CPU usage percentage
        double load = processor.getSystemCpuLoad(1000) * 100;

        // Available memory
        long memory = si.getHardware().getMemory().getAvailable();

        return Map.of(
                "cpu_usage_percent", String.format("%.2f", load),
                "available_memory_bytes", memory,
                "status", "Healthy",
                "timestamp", System.currentTimeMillis()
        );
    }
}