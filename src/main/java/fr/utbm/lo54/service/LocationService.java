package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.repository.LocationDao;

import java.util.List;

public class LocationService {

    public List<Location> listAllLocations() {
        LocationDao locationDao = new LocationDao();
        List<Location> listLocation = locationDao.getAllLocations();
        return listLocation;
    };

}
