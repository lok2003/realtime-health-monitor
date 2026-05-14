package com.loki.devops.monitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import java.util.Map;

@RestController
public class HealthController {
    private final SystemInfo si = new SystemInfo();

    @GetMapping("/api/realtime-stats")
    public Map<String, Object> getStats() {
        CentralProcessor processor = si.getHardware().getProcessor();
        // Get CPU load over 1 second interval
        double load = processor.getSystemCpuLoad(1000) * 100;
        long memory = si.getHardware().getMemory().getAvailable();

        return Map.of(
            "cpu_usage_percent", String.format("%.2f", load),
            "available_memory_bytes", memory,
            "status", "Healthy",
            "timestamp", System.currentTimeMillis()
        );
    }
}
