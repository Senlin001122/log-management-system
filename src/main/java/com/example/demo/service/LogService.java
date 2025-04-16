package com.example.demo.service;

import com.example.demo.model.LogEntry;
import com.example.demo.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogEntryRepository logEntryRepository;

    public LogEntry saveLog(LogEntry logEntry) {
        return logEntryRepository.save(logEntry);
    }

    public List<LogEntry> getAllLogs() {
        return logEntryRepository.findAll();
    }

    public LogEntry getLogById(Long id) {
        return logEntryRepository.findById(id).orElse(null);
    }
}
