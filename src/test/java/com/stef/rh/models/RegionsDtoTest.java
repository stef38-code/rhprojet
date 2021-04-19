package com.stef.rh.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegionsDtoTest {
    @Test
    public void testId() {
        RegionsDto regionsDto = new RegionsDto();
        RegionsDto actualIdResult = regionsDto.id(123L);
        assertSame(regionsDto, actualIdResult);
        assertEquals(123L, actualIdResult.getId().longValue());
    }

    @Test
    public void testSetId() {
        RegionsDto regionsDto = new RegionsDto();
        regionsDto.setId(123L);
        assertEquals(123L, regionsDto.getId().longValue());
    }

    @Test
    public void testRegionName() {
        RegionsDto regionsDto = new RegionsDto();
        RegionsDto actualRegionNameResult = regionsDto.regionName("us-east-2");
        assertSame(regionsDto, actualRegionNameResult);
        assertEquals("us-east-2", actualRegionNameResult.getRegionName());
    }

    @Test
    public void testSetRegionName() {
        RegionsDto regionsDto = new RegionsDto();
        regionsDto.setRegionName("us-east-2");
        assertEquals("us-east-2", regionsDto.getRegionName());
    }

    @Test
    public void testEquals() {
        assertFalse((new RegionsDto()).equals("42"));
        assertFalse((new RegionsDto()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(961, (new RegionsDto()).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("class RegionsDto {\n    id: null\n    regionName: null\n}", (new RegionsDto()).toString());
    }

    @Test
    public void testToString2() {
        RegionsDto regionsDto = new RegionsDto();
        regionsDto.id(123L);
        assertEquals("class RegionsDto {\n    id: 123\n    regionName: null\n}", regionsDto.toString());
    }
}

