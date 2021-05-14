package com.stef.rh.repository;

import com.stef.rh.entity.Regions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RegionsRepositoryTest {
    @Autowired
    RegionsRepository repository;

    @Test
    void testSave() {
        Regions regions = new Regions();
        regions.setRegionName("bitter");

        Regions value = repository.save(regions);
        assertThat(value.getRegionId()).isNotNull();
        assertThat(value.getRegionName()).isEqualTo("bitter");
    }

    @Test
    @Sql("/sql/createRegions.sql")
    @Disabled("juste pour avoir un exemple avec un script en entree du test")
    void testFindById() {
        Optional< Regions > value = repository.findById(1L);
        assertThat(value).isPresent()
                .containsInstanceOf(Regions.class);
        Regions regions = value.get();
        assertThat(regions.getRegionId()).isNotNull();
        assertThat(regions.getRegionName()).isEqualTo("Europe");
    }
}