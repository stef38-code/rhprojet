package com.stef.rh.mapper;

import com.stef.rh.entity.Regions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RegionsMapperImpl.class})
@ExtendWith(SpringExtension.class)
class RegionsMapperTest {
    @Autowired
    @Spy
    RegionsMapper mapper;

    @Test
    void testToDtoNull() {
        Assertions.assertThat(mapper.toDto(null)).isNull();
    }

    @Test
    void testToDtoMapNull() {
        Assertions.assertThat(mapper.toDtoMap(null)).isNull();
    }

    @Test
    void testToNewEntityMapNull() {
        Assertions.assertThat(mapper.toNewEntity(null)).isNull();
    }

    @Test
    void testUpdateEntityMapNull() {
        Regions region = new Regions();
        mapper.updateEntity(null, region);
        Assertions.assertThat(region.getRegionId()).isNull();
        Assertions.assertThat(region.getRegionName()).isNull();
    }
}
