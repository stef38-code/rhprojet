package com.stef.rh.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountriesTest {

    public static final String COUNTRY_ID = "42";
    public static final String COUNTRY_NAME = "Country Name";
    public static final long REGION_ID = 123L;
    public static final long REGION_REGION_ID = 123L;

    @Test
    public void testCanEqual() {
        assertThat((new Countries()).canEqual("Other")).isFalse();
    }

    @Test
    public void testCanEqual2() {
        Countries countries = new Countries();

        Countries countries1 = new Countries();
        countries1.setCountryId(COUNTRY_ID);
        countries1.setCountryName(COUNTRY_NAME);
        countries1.setRegionId(REGION_ID);
        countries1.setRegionRegionId(REGION_ID);
        assertThat(countries).hasSameClassAs(countries1);
    }

    @Test
    public void testConstructor() {
        Countries actualCountries = new Countries();
        actualCountries.setCountryId(COUNTRY_ID);
        actualCountries.setCountryName(COUNTRY_NAME);
        actualCountries.setRegionId(REGION_ID);
        actualCountries.setRegionRegionId(REGION_ID);
        assertThat(actualCountries.getCountryId()).isEqualTo(COUNTRY_ID);
        assertThat(actualCountries.getCountryName()).isEqualTo(COUNTRY_NAME);
        assertThat(actualCountries.getRegionId().longValue()).isEqualTo(REGION_ID);
        assertThat(actualCountries.getRegionRegionId().longValue()).isEqualTo(REGION_ID);
        assertThat(actualCountries.toString()).isEqualTo("Countries(countryId=42, countryName=Country Name, regionId=123, regionRegionId=123)");
    }

    @Test
    public void testEquals() {
        Countries countries = new Countries();

        Countries countries1 = new Countries();
        countries1.setCountryId(COUNTRY_ID);
        countries1.setCountryName(COUNTRY_NAME);
        countries1.setRegionId(REGION_ID);
        countries1.setRegionRegionId(REGION_REGION_ID);
        assertThat(countries).isNotEqualTo(countries1);
    }

    @Test
    public void testEquals2() {
        Countries countries = new Countries();
        assertThat(countries).isEqualTo(new Countries());
    }


    @Test
    public void testHashCode() {
        assertThat(new Countries()).hasSameHashCodeAs(21100921);
    }

    @Test
    public void testHashCode2() {
        Countries countries = new Countries();
        countries.setCountryId(COUNTRY_ID);
        countries.setRegionId(REGION_ID);
        countries.setRegionRegionId(REGION_ID);
        countries.setCountryName(COUNTRY_NAME);
        assertThat(countries).hasSameHashCodeAs(1624476740);
    }

}

