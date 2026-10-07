package com.nexushr.controller;

import com.nexushr.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Health check controller to verify backend foundation startup and API availability.
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> checkHealth() {
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("status", "UP");
        details.put("platform", "NexusHR Workforce Intelligence Platform");
        details.put("version", "0.0.1-SNAPSHOT");
        details.put("timestamp", LocalDateTime.now());

        return ResponseEntity.ok(ApiResponse.success("NexusHR backend service is running successfully", details));
    }
}
