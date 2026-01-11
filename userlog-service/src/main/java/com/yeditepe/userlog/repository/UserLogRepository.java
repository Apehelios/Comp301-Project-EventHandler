package com.yeditepe.userlog.repository;

import com.yeditepe.userlog.entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {

    List<UserLog> findUserLogByUserId(String userId);

    List<UserLog> findUserLogByUsername(String username);

    List<UserLog> findUserLogByAction(String action);

    List<UserLog> findUserLogByLevel(String level);

    List<UserLog> findUserLogByServiceName(String serviceName);

    List<UserLog> findUserLogByUserIdAndAction(String userId, String action);
}