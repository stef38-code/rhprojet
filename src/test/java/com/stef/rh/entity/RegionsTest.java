package com.stef.rh.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegionsTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Regions()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Regions regions = new Regions();

        Regions regions1 = new Regions();
        regions1.setRegionId(123L);
        regions1.setRegionName("us-east-2");
        assertTrue(regions.canEqual(regions1));
    }

    @Test
    public void testEquals() {
        assertFalse((new Regions()).equals("42"));
    }

    @Test
    public void testEquals2() {
        Regions regions = new Regions();

        Regions regions1 = new Regions();
        regions1.setRegionId(123L);
        regions1.setRegionName("us-east-2");
        assertFalse(regions.equals(regions1));
    }

    @Test
    public void testEquals3() {
        Regions regions = new Regions();
        assertTrue(regions.equals(new Regions()));
    }

    @Test
    public void testEquals4() {
        Regions regions = new Regions();

        Regions regions1 = new Regions();
        regions1.setRegionId(null);
        regions1.setRegionName("us-east-2");
        assertFalse(regions.equals(regions1));
    }

    @Test
    public void testEquals5() {
        Regions regions = new Regions();
        regions.setRegionId(123L);

        Regions regions1 = new Regions();
        regions1.setRegionId(123L);
        regions1.setRegionName("us-east-2");
        assertFalse(regions.equals(regions1));
    }

    @Test
    public void testEquals6() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        assertFalse(regions.equals(new Regions()));
    }

    @Test
    public void testEquals7() {
        Regions regions = new Regions();
        regions.setRegionName("us-east-2");
        assertFalse(regions.equals(new Regions()));
    }

    @Test
    public void testEquals8() {
        Regions regions = new Regions();
        regions.setRegionName("us-east-2");

        Regions regions1 = new Regions();
        regions1.setRegionId(null);
        regions1.setRegionName("us-east-2");
        assertTrue(regions.equals(regions1));
    }

    @Test
    public void testHashCode() {
        assertEquals(6061, (new Regions()).hashCode());
    }

    @Test
    public void testHashCode2() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        assertEquals(10781, regions.hashCode());
    }

    @Test
    public void testHashCode3() {
        Regions regions = new Regions();
        regions.setRegionName("us-east-2");
        assertEquals(1808581619, regions.hashCode());
    }

    @Test
    public void testSetRegionId() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        assertEquals(123L, regions.getRegionId().longValue());
    }

    @Test
    public void testSetRegionName() {
        Regions regions = new Regions();
        regions.setRegionName("us-east-2");
        assertEquals("us-east-2", regions.getRegionName());
    }

    @Test
    public void testToString() {
        assertEquals("Regions(regionId=null, regionName=null)", (new Regions()).toString());
    }
}

