package com.stef.rh.repository;

import com.stef.rh.entity.Regions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RegionsRepositoryTest {
    @Autowired
    RegionsRepository repository;

    @Test
    @Disabled
    void testSave() {
        Regions regions = new Regions();
        regions.setRegionName("bitter");

        Regions value = repository.save(regions);
        assertThat(value.getRegionId()).isNotNull();
        assertThat(value.getRegionName()).isEqualTo("bitter");

    }

}