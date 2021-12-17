package at.rajoub.blogservice.client;

import at.rajoub.blogservice.model.Location;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("location-service")
@LoadBalancerClient(name = "location-service")
public interface LocationServiceClient {

    @GetMapping("/api/locations/{id}")
    Location findLocationById(@PathVariable("id") int locationId);

    @GetMapping("/api/locations/")
    List<Location> selectAllLocations();
}
