package com.stef.rh.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "dependents")
public class Dependents implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dependent_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dependentId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "relationship", nullable = false)
    private String relationship;

   @ManyToOne
    private Employees employ;
}