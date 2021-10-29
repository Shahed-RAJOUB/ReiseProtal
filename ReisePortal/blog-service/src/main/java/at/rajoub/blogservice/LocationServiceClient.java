package at.rajoub.blogservice;

import at.rajoub.blogservice.ValueObject.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("LOCATION-SERVICE")
@RequestMapping("/locations")
public interface LocationServiceClient {
    @GetMapping("/{id}")
    public Location findLocationById(@PathVariable("id") int locationId);
}
