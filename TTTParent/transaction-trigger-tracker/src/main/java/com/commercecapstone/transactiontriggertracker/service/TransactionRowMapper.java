package com.commercecapstone.transactiontriggertracker.service;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.commercecapstone.transactiontriggertracker.domain.NotificationDomain;
import com.commercecapstone.transactiontriggertracker.domain.TransactionDomain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Service @Data @Slf4j
public class TransactionRowMapper  implements RowMapper<TransactionDomain> {
	//@Override //mapRow method is not overridden
    public TransactionDomain mapRow(ResultSet rs, int rowNum) throws SQLException{
        return TransactionDomain.builder()
                                .transactionID(rs.getInt("Transaction_ID"))
                                .transactionType(rs.getString("Transaction_Type"))
                                .transactionTime(asString(rs.getTimestamp("Transaction_time")))
                                .state(rs.getString("State"))
                                .category(rs.getString("Category"))
                                .transactionDescription(rs.getString("Transaction_description"))
                                .amount(rs.getInt("Amount"))
                                .accountID(rs.getInt("Account_ID"))
                                .build();
    }
	public String asString(Timestamp timestamp) {
        if(timestamp == null) return "";	
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(timestamp);
    }	
}
