package com.example.demo.service;

import com.example.demo.model.LogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final String LOG_KEY_LIST = "log_keys";

    public String saveLog(LogEntry logEntry) {
        String key = "log:" + UUID.randomUUID();
        redisTemplate.opsForValue().set(key, logEntry);
        // 👇 把 key 添加到 Redis 列表
        redisTemplate.opsForList().rightPush(LOG_KEY_LIST, key);
        return key;
    }


    public LogEntry getLog(String key) {
        Object result = redisTemplate.opsForValue().get(key);
        if (result instanceof LogEntry) {
            return (LogEntry) result;
        }
        return null;
    }

    public List<LogEntry> getAllLogs() {
        List<Object> keys = redisTemplate.opsForList().range(LOG_KEY_LIST, 0, -1);
        List<LogEntry> logs = new ArrayList<>();
        if (keys != null) {
            for (Object k : keys) {
                Object log = redisTemplate.opsForValue().get(k.toString());
                if (log instanceof LogEntry) {
                    logs.add((LogEntry) log);
                }
            }
        }
        return logs;
    }

}
