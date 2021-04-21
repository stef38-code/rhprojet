package com.stef.rh.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class RegionsTest {
    @Test
    void testCanEqual() {
       assertFalse((new Regions()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
       Regions regions = new Regions();

       Regions regions1 = new Regions();
       regions1.setRegionId(123L);
       regions1.setRegionName("us-east-2");
       assertTrue(regions.canEqual(regions1));
    }

    @Test
    void testEquals() {
       assertFalse((new Regions()).equals("42"));
    }

    @Test
    void testEquals2() {
       Regions regions = new Regions();

       Regions regions1 = new Regions();
       regions1.setRegionId(123L);
       regions1.setRegionName("us-east-2");
       assertFalse(regions.equals(regions1));
    }

    @Test
    void testEquals3() {
       Regions regions = new Regions();
       assertTrue(regions.equals(new Regions()));
    }

    @Test
    void testEquals4() {
       Regions regions = new Regions();

       Regions regions1 = new Regions();
       regions1.setRegionId(null);
       regions1.setRegionName("us-east-2");
       assertFalse(regions.equals(regions1));
    }

    @Test
    void testEquals5() {
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
    void testEquals7() {
       Regions regions = new Regions();
       regions.setRegionName("us-east-2");
       assertFalse(regions.equals(new Regions()));
    }

    @Test
    void testEquals8() {
       Regions regions = new Regions();
       regions.setRegionName("us-east-2");

       Regions regions1 = new Regions();
       regions1.setRegionId(null);
       regions1.setRegionName("us-east-2");
       assertTrue(regions.equals(regions1));
    }

    @Test
    void testHashCode() {
       assertEquals(6061, (new Regions()).hashCode());
    }

    @Test
    void testHashCode2() {
       Regions regions = new Regions();
       regions.setRegionId(123L);
       assertEquals(10781, regions.hashCode());
    }

    @Test
    void testHashCode3() {
       Regions regions = new Regions();
       regions.setRegionName("us-east-2");
       assertEquals(1808581619, regions.hashCode());
    }

    @Test
    void testSetRegionId() {
       Regions regions = new Regions();
       regions.setRegionId(123L);
       assertEquals(123L, regions.getRegionId().longValue());
    }

    @Test
    void testSetRegionName() {
       Regions regions = new Regions();
       regions.setRegionName("us-east-2");
       assertEquals("us-east-2", regions.getRegionName());
    }

    @Test
    void testToString() {
       assertEquals("Regions(regionId=null, regionName=null)", (new Regions()).toString());
    }
}

