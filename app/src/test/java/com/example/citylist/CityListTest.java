package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("A", "X");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }
    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "SK");
        cityList.add(city);
        cityList.delete(city);

        assertEquals(1, cityList.getCities(1).size());
        assertTrue(!cityList.getCities(1).contains(city));
    }
    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "SK");


        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
    @Test
    public void testCount() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "SK");
        cityList.add(city);
        assertEquals(2, cityList.count());

    }
    @Test
    public void testSort() {
        CityList cityList = mockCityList();

        City city = new City("B", "Y");
        cityList.add(city);
        City city1 = new City("C", "Z");
        cityList.add(city1);
        City city2 = new City("D", "U");
        cityList.add(city2);
        City city3 = new City("E", "V");
        cityList.add(city3);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0, city.compareTo(cityList.getCities(2).get(3)));
    }

}
