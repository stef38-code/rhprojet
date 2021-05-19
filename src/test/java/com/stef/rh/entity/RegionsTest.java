package com.stef.rh.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegionsTest {
    @Test
    void testCanEqual() {
        assertThat((new Regions()).canEqual("Other")).isFalse();
    }

    @Test
    void testCanEqual2() {
        Regions regions = new Regions();

        Regions regions1 = new Regions();
       regions1.setRegionId(123L);
        regions1.setRegionName("us-east-2");
        assertThat(regions.canEqual(regions1)).isTrue();
    }



    @Test
    void testEquals2() {
       Regions regions = new Regions();

       Regions regions1 = new Regions();
       regions1.setRegionId(123L);
        regions1.setRegionName("us-east-2");
        assertThat(regions).isNotEqualTo(regions1);
    }

    @Test
    void testEquals3() {
       Regions regions = new Regions();
        assertThat(regions).isEqualTo(new Regions());
    }

    @Test
    void testEquals4() {
       Regions regions = new Regions();

       Regions regions1 = new Regions();
       regions1.setRegionId(null);
        regions1.setRegionName("us-east-2");
        assertThat(regions).isNotEqualTo(regions1);
    }

    @Test
    void testEquals5() {
       Regions regions = new Regions();
       regions.setRegionId(123L);

       Regions regions1 = new Regions();
       regions1.setRegionId(123L);
        regions1.setRegionName("us-east-2");
        assertThat(regions).isNotEqualTo(regions1);
    }

    @Test
    void testEquals6() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        assertThat(regions).isNotEqualTo(new Regions());
    }

    @Test
    void testEquals7() {
       Regions regions = new Regions();
        regions.setRegionName("us-east-2");
        assertThat(regions).isNotEqualTo(new Regions());
    }

    @Test
    void testEquals8() {
       Regions regions = new Regions();
       regions.setRegionName("us-east-2");

       Regions regions1 = new Regions();
       regions1.setRegionId(null);
        regions1.setRegionName("us-east-2");
        assertThat(regions).isEqualTo(regions1);
    }

    @Test
    void testHashCode() {
        assertThat((new Regions()).hashCode()).isEqualTo(6061);
    }

    @Test
    void testHashCode2() {
       Regions regions = new Regions();
        regions.setRegionId(123L);
        assertThat(regions.hashCode()).isEqualTo(10781);
    }

    @Test
    void testHashCode3() {
       Regions regions = new Regions();
        regions.setRegionName("us-east-2");
        assertThat(regions.hashCode()).isEqualTo(1808581619);
    }

    @Test
    void testSetRegionId() {
       Regions regions = new Regions();
        regions.setRegionId(123L);
        assertThat(regions.getRegionId().longValue()).isEqualTo(123L);
    }

    @Test
    void testSetRegionName() {
       Regions regions = new Regions();
        regions.setRegionName("us-east-2");
        assertThat(regions.getRegionName()).isEqualTo("us-east-2");
    }

    @Test
    void testToString() {
        assertThat((new Regions()).toString()).hasToString("Regions(regionId=null, regionName=null)");
    }
}

