package com.stef.rh.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RegionsDtoTest {

    @Test
    void testRegionName() {
        RegionsDto actualRegionNameResult = getSample();
        assertAll(() -> {
            assertThat(actualRegionNameResult.getRegionName()).hasToString("bargain spit continue verse bag");
            assertThat(actualRegionNameResult.getRegionId()).isEqualTo(123L);
                }
        );
    }

    @Test
    void testEqualsWithNullObject() {
        assertAll(() -> assertThat((new RegionsDto())).isNotEqualTo(null)
        );
    }

    @Test
    void testHashCodeWithNullObject() {
        assertThat((new RegionsDto()).hashCode()).isEqualTo(961);
    }

    @Test
    void testHashCodeWithSample() {
        assertThat(getSample().hashCode()).isEqualTo(-1862650924);
    }

    @Test
    void testEqualsWithSample() {
        assertThat(getSample()).isEqualTo(getSample());
    }

    @Test
    void testEqualsWithSample2() {
        RegionsDto regionsDto = getSample2();
        assertThat(regionsDto).isEqualTo(regionsDto);
    }

    @Test
    void testToStringWithNullObject() {
        toStringTest((new RegionsDto()).toString(), "class RegionsDto {\n    regionId: null\n    regionName: null\n}");
    }

    @Test
    void testToStringWithSample() {
        toStringTest(getSample().toString(), "class RegionsDto {\n    regionId: 123\n    regionName: bargain spit continue verse bag\n}");
    }

    private void toStringTest(String actual, String except) {
        assertThat(actual).isEqualTo(except);
    }

    /**
     * Retourne un exemple de données
     *
     * @return RegionsDto
     */
    private RegionsDto getSample() {
        RegionsDto regionsDto = new RegionsDto();
        regionsDto.setRegionId(123L);
        regionsDto.setRegionName("bargain spit continue verse bag");
        return regionsDto;
    }

    /**
     * Retourne un exemple de données
     *
     * @return RegionsDto
     */
    private RegionsDto getSample2() {
        RegionsDto regionsDto = new RegionsDto();
        regionsDto.regionId(99L);
        regionsDto.regionName("arrive");
        return regionsDto;
    }
}

