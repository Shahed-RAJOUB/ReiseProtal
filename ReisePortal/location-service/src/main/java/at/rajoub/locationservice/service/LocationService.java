package at.rajoub.locationservice.service;

import at.rajoub.locationservice.entity.Location;
import at.rajoub.locationservice.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location saveLocation(Location location) {
        log.info("Inside saveLocation of LocationService");
        return locationRepository.save(location);
    }

    public Location findLocationById(int locationId) {
        return locationRepository.findById(locationId).orElseThrow();
    }

    public List<Location> selectAllLocations() {
        return locationRepository.findAll();
    }
}
