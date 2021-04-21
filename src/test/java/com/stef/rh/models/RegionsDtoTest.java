package com.stef.rh.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RegionsDtoTest {

    @Test
    void testRegionName() {
        RegionsDto actualRegionNameResult = getSample();
        assertAll(() -> {
                    assertThat(actualRegionNameResult.getRegionName()).isEqualTo("bargain spit continue verse bag");
                    assertThat(actualRegionNameResult.getId()).isEqualTo(123L);
                }
        );
    }

    @Test
    void testEqualsWithNullObject() {
        assertAll(() -> {
                    assertFalse((new RegionsDto()).equals("42"));
                    assertFalse((new RegionsDto()).equals(null));
                }
        );
    }

    @Test
    void testHashCodeWithNullObject() {
        assertEquals(961, (new RegionsDto()).hashCode());
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
        toStringTest((new RegionsDto()).toString(), "class RegionsDto {\n    id: null\n    regionName: null\n}");
    }

    @Test
    void testToStringWithSample() {
        toStringTest(getSample().toString(), "class RegionsDto {\n    id: 123\n    regionName: bargain spit continue verse bag\n}");
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
        regionsDto.setId(123L);
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
        regionsDto.id(99L);
        regionsDto.regionName("arrive");
        return regionsDto;
    }
}

