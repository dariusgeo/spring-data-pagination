package edu.link.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="log_audit")
public class LogAudit implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="log_audit_seq_gen")
    @SequenceGenerator(name="log_audit_seq_gen", sequenceName="log_audit_seq", allocationSize = 1)
    private Long id;

    @Column(name="action_name")
    private String actionName;

    @Column(name="username")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
