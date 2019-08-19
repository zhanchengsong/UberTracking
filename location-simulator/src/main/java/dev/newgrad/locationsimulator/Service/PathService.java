package dev.newgrad.locationsimulator.Service;

import dev.newgrad.locationsimulator.Domain.DirectionInput;
import dev.newgrad.locationsimulator.Domain.Point;
import dev.newgrad.locationsimulator.Domain.ServiceLocation;
import dev.newgrad.locationsimulator.Domain.SimulatorFixture;

import java.util.List;

// Service to get path infomation from Google Map apis
public interface PathService {

    List<DirectionInput> loadDirectionInput();

    SimulatorFixture loadSimulatorFixture();

    List<Point> getCoordinatesFromGoogle(DirectionInput directionInput);

    String getCoordinatesFromGoogleAsPolyline(DirectionInput directionInput);

    List<ServiceLocation> getServiceStations();

}
