package com.example.demo.controller;

import com.example.demo.model.LogEntry;
import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public ResponseEntity<LogEntry> saveLog(@RequestBody LogEntry logEntry) {
        return ResponseEntity.ok(logService.saveLog(logEntry));
    }

    @GetMapping
    public ResponseEntity<List<LogEntry>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogEntry> getLogById(@PathVariable Long id) {
        LogEntry log = logService.getLogById(id);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }

    @PostMapping("/logs")
    public ResponseEntity<String> addLog(@RequestBody LogEntry logEntry) {
        logService.saveLog(logEntry);
        return ResponseEntity.ok("Log saved successfully.");
    }
}
