package com.yeditepe.userlog.service;

import com.yeditepe.userlog.dto.UserLogCreateRequest;
import com.yeditepe.userlog.dto.UserLogResponse;
import com.yeditepe.userlog.entity.UserLog;
import com.yeditepe.userlog.mapper.UserLogMapper;
import com.yeditepe.userlog.repository.UserLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLogService {

    private final UserLogRepository repo;

    public UserLogService(UserLogRepository repo) {
        this.repo = repo;
    }

    public UserLogResponse create(UserLogCreateRequest req) {
        UserLog entity = UserLogMapper.toEntity(req);
        UserLog saved = repo.save(entity);
        return UserLogMapper.toResponse(saved);
    }

    public List<UserLogResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(UserLogMapper::toResponse)
                .toList();
    }

    public List<UserLogResponse> getByUserId(String userId) {
        return repo.findUserLogByUserId(userId)
                .stream()
                .map(UserLogMapper::toResponse)
                .toList();
    }

    public List<UserLogResponse> getByAction(String action) {
        return repo.findUserLogByAction(action)
                .stream()
                .map(UserLogMapper::toResponse)
                .toList();
    }

    public List<UserLogResponse> getByServiceName(String serviceName) {
        return repo.findUserLogByServiceName(serviceName)
                .stream()
                .map(UserLogMapper::toResponse)
                .toList();
    }

    public List<UserLogResponse> getByUserIdAndAction(String userId, String action) {
        return repo.findUserLogByUserIdAndAction(userId, action)
                .stream()
                .map(UserLogMapper::toResponse)
                .toList();
    }
}