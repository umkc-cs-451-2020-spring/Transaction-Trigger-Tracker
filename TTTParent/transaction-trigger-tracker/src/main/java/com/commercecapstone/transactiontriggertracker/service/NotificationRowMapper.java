package com.commercecapstone.transactiontriggertracker.service;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.commercecapstone.transactiontriggertracker.domain.NotificationDomain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Service @Data @Slf4j
public class NotificationRowMapper implements RowMapper<NotificationDomain> {
	//@Override //mapRow method is not overridden
    public NotificationDomain mapRow(ResultSet rs, int rowNum) throws SQLException{
        return NotificationDomain.builder()
                                .notificationID(rs.getInt("Notification_ID"))
                                .notificationType(rs.getString("Notification_Type"))
                                .triggerID(rs.getInt("Trigger_ID"))
                                .transactionID(rs.getInt("Transaction_ID"))
                                .accountID(rs.getInt("Account_ID"))
                                .build();
    }
}
