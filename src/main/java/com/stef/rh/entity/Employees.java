package com.stef.rh.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "employees")
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "employee_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

     @ManyToOne
    private Jobs job;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "department_id")
    private Long departmentId;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="dependent_id")
    private List<Dependents> dependents;

}
