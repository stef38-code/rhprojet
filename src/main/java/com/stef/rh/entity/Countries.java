package com.stef.rh.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

 /*  @ManyToOne
   private Regions region;*/

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="country_id")
    private List<Locations> locations;

}
