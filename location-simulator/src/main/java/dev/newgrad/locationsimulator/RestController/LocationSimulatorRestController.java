package dev.newgrad.locationsimulator.RestController;

import dev.newgrad.locationsimulator.Domain.DirectionInput;
import dev.newgrad.locationsimulator.Domain.Point;
import dev.newgrad.locationsimulator.Service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationSimulatorRestController {
    @Autowired
    private PathService pathService;

    // Test api point to verify google map api works
    @PostMapping("/path")
    public List<Point> findPathWithDirection(@RequestBody DirectionInput input) {
        return pathService.getCoordinatesFromGoogle(input);
    }
}
