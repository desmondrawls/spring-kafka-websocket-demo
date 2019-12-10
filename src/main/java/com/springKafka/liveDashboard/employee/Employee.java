package com.springKafka.liveDashboard.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    String id;

    String name;
}
