package dev.newgrad.locationservice.RestController;

import dev.newgrad.locationservice.Domin.Location;
import dev.newgrad.locationservice.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FleetBulkUploadController {
    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping(value = "/fleet", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Location> fleet) throws Exception {
        for (Location location: fleet) {
            this.locationRepository.save(location);
        }

    }

    @RequestMapping(value = "/purge", method = RequestMethod.POST)
    public void purge() {
        this.locationRepository.deleteAll();
    }
}
