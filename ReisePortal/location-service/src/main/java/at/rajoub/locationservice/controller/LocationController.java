package at.rajoub.locationservice.controller;

import at.rajoub.locationservice.entity.Location;
import at.rajoub.locationservice.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@Slf4j
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/")
    public Location saveLocation(@RequestBody Location location){
        return locationService.saveLocation(location);
    }
    @GetMapping("/{id}")
    public Location findLocationById(@PathVariable("id") int locationId){
        return locationService.findLocationById(locationId);
    }
    @GetMapping("/")
    public List<Location> selectAllAuthors(){
        return locationService.selectAllLocations();
    }
}
