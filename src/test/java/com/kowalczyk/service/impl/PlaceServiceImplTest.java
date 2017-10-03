package com.kowalczyk.service.impl;

import com.kowalczyk.controller.PlaceController;
import com.kowalczyk.model.http.ModelPlace;
import com.kowalczyk.model.maps.Location;
import com.kowalczyk.service.LocationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlaceServiceImplTest {

    @MockBean
    private LocationService locationService;
    @Autowired
    private PlaceController placeController;

    @Before
    public void setUp() throws Exception {
        Mockito.doReturn(getPoznanTestLocation()).when(locationService).getLocation(Mockito.anyString(), Mockito.anyString());
    }

    private Location getPoznanTestLocation() {
        Location location = new Location();
        location.setLat(Float.valueOf("52.406374"));
        location.setLng(Float.valueOf("16.9251681"));
        return location;
    }

    @Test
    public void getPlacesByCity() throws Exception {
        String egnyte = "Egnyte";
        List<ModelPlace> modelPlaces = placeController.getPlacesByCity("Poland", "Poznan", egnyte);
        assertTrue(modelPlaces.size() == 1);
        assertTrue(modelPlaces.stream().anyMatch(modelPlace -> modelPlace.getName().contains(egnyte)));
    }

}