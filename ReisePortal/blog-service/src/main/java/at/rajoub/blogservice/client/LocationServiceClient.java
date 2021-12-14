package at.rajoub.blogservice.client;

import at.rajoub.blogservice.model.Location;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("LOCATION-SERVICE")
@LoadBalancerClient(name = "LOCATION-SERVICE")
@RequestMapping("/api/locations")
public interface LocationServiceClient {
    @GetMapping("/{id}")
    public Location findLocationById(@PathVariable("id") int locationId);
}