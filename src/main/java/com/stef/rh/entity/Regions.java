package com.stef.rh.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "regions")
public class Regions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "region_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;

    @Column(name = "region_name")
    private String regionName;

   /* @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="regionId")
    private List<Countries> countries;*/

}
