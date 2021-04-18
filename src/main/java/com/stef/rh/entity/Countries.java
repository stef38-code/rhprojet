package com.stef.rh.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "countries")
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "country_id", nullable = false)
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "region_id", nullable = false)
    private Long regionId;

    @Column(name = "region_region_id")
    private Long regionRegionId;

}
