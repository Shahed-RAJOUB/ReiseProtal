package at.rajoub.blogservice.client;

import at.rajoub.blogservice.model.Location;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("location-service")
@LoadBalancerClient(name = "location-service")
public interface LocationServiceClient {

    @GetMapping("/api/locations/{id}")
    Location findLocationById(@PathVariable("id") int locationId);

    @PostMapping("/api/locations/")
    Location saveLocation(@RequestBody Location location);
}
