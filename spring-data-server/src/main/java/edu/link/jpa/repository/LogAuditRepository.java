package edu.link.jpa.repository;

import edu.link.jpa.model.LogAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogAuditRepository extends JpaRepository<LogAudit, Long> {
}
