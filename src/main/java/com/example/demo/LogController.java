package com.example.demo;

import com.example.demo.model.LogEntry;
import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/logs")
    public String receiveLog(@RequestBody LogEntry logEntry) {
        String redisKey = logService.saveLog(logEntry);
        return "日志已保存到 Redis，key = " + redisKey;
    }

    @GetMapping("/logs/test")
    public String test() {
        return "Log system is working!";
    }
    // ✅ 查询指定日志
    @GetMapping("/logs/{key}")
    public ResponseEntity<?> getLog(@PathVariable String key) {
        LogEntry logEntry = logService.getLog(key);
        if (logEntry != null) {
            return ResponseEntity.ok(logEntry);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("日志不存在，key = " + key);
        }
    }
    // ✅ 查询所有日志
    @GetMapping("/logs")
    public ResponseEntity<List<LogEntry>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }

}
