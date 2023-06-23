package com.nkxgen.spring.jdbc.listeners;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.nkxgen.spring.jdbc.Dao.AuditLogDAO;
import com.nkxgen.spring.jdbc.events.BankUserCreationEvent;
import com.nkxgen.spring.jdbc.model.AuditLogs;

@Component
public class BankUserCreationListener 
{
	
	@Autowired
	private AuditLogDAO auditLogDAO;
	
	@EventListener
	public void CreationEvent(BankUserCreationEvent event)
	{
		auditLogDAO.saveAudit(new AuditLogs(event.getEvent(),new Timestamp(System.currentTimeMillis()),"No User"));
		System.out.println("Bank User Account Created");
	}
}
