package com.bucur.audit.history;

import com.bucur.audit.customer.Customer;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import java.time.LocalDateTime;

import static com.bucur.audit.history.Action.DELETED;
import static com.bucur.audit.history.Action.INSERTED;
import static com.bucur.audit.history.Action.UPDATED;

public class CustomerHistoryListener {

    private CustomerHistoryRepository customerHistoryRepository;

    public CustomerHistoryListener() {
        this.customerHistoryRepository = new CustomerHistoryRepository();
    }

    @PostPersist
    public void postPersist(Customer customer) {
        perform(customer, INSERTED);
    }

    @PostUpdate
    public void postUpdate(Customer customer) {
        perform(customer, UPDATED);
    }

    @PostRemove
    public void postRemove(Customer customer) {
        perform(customer, DELETED);
    }

    public void perform(Customer customer, Action action) {
        CustomerHistory customerHistory = new CustomerHistory();
        customerHistory.setAction(action);
        customerHistory.setCreationDate(LocalDateTime.now());
        customerHistory.setCustomerId(customer.getId());
        customerHistory.setModifiedBy("current user");
        customerHistory.setAction(action);

        customerHistoryRepository.create(customerHistory);
    }
}
