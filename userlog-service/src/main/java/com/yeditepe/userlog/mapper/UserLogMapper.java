package com.yeditepe.userlog.mapper;

import com.yeditepe.userlog.dto.UserLogCreateRequest;
import com.yeditepe.userlog.dto.UserLogResponse;
import com.yeditepe.userlog.entity.UserLog;

import java.time.LocalDateTime;

public class UserLogMapper {

    // DTO -> Entity
    public static UserLog toEntity(UserLogCreateRequest request) {
        UserLog log = new UserLog();

        log.setServiceName(request.getServiceName());
        log.setLevel(request.getLevel());
        log.setAction(request.getAction());
        log.setUserId(request.getUserId());
        log.setUsername(request.getUsername());
        log.setCorrelationId(request.getCorrelationId());
        log.setDetails(request.getDetails());

        // timestamp server tarafından set edilir
        log.setTimestamp(LocalDateTime.now());

        return log;
    }

    // Entity -> Response DTO
    public static UserLogResponse toResponse(UserLog log) {
        UserLogResponse response = new UserLogResponse();

        response.setId(log.getId());
        response.setTimestamp(log.getTimestamp());
        response.setServiceName(log.getServiceName());
        response.setLevel(log.getLevel());
        response.setAction(log.getAction());
        response.setUserId(log.getUserId());
        response.setUsername(log.getUsername());
        response.setCorrelationId(log.getCorrelationId());
        response.setDetails(log.getDetails());

        return response;
    }
}
