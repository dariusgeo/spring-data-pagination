package edu.link.jpa.service;


import edu.link.jpa.model.LogAudit;
import edu.link.jpa.repository.LogAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class LogAuditService {

    @Autowired
    private LogAuditRepository logAuditRepository;

    @Transactional(propagation = REQUIRES_NEW)
    public void createAuditEntry(String username, String actionName){
        LogAudit logAudit = new LogAudit();
        logAudit.setUsername(username);
        logAudit.setActionName(actionName);
        logAuditRepository.save(logAudit);
    }
}
