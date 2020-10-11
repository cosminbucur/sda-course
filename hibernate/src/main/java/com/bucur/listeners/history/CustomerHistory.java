package com.bucur.listeners.history;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity(name = "CustomerHistory")
@Table(name = "customer_history")
public class CustomerHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;

    @Enumerated(EnumType.STRING)
    private Action action;

    private LocalDateTime creationDate;
    private String modifiedBy;

    public CustomerHistory() {
    }

    public CustomerHistory(Long customerId, Action action, LocalDateTime creationDate, String modifiedBy) {
        this.customerId = customerId;
        this.action = action;
        this.creationDate = creationDate;
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "CustomerHistory{" +
            "id=" + id +
            ", customerId=" + customerId +
            ", action=" + action +
            ", creationDate=" + creationDate +
            ", modifiedBy='" + modifiedBy + '\'' +
            '}';
    }
}
