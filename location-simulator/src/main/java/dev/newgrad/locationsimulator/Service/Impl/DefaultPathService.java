package dev.newgrad.locationsimulator.Service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.LatLng;
import dev.newgrad.locationsimulator.Domain.DirectionInput;
import dev.newgrad.locationsimulator.Domain.Point;
import dev.newgrad.locationsimulator.Domain.ServiceLocation;
import dev.newgrad.locationsimulator.Domain.SimulatorFixture;
import dev.newgrad.locationsimulator.Service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Service
public class DefaultPathService implements PathService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Environment environment;

    @Override
    public List<DirectionInput> loadDirectionInput() {
        // Read data from the local json file

        final InputStream is = this.getClass().getResourceAsStream("/directions.json");

        try {
            return objectMapper.readValue(is, new TypeReference<List<DirectionInput>>() {

            });
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public SimulatorFixture loadSimulatorFixture() {
        // Load the fixture data for the simulator
        final InputStream is = this.getClass().getResourceAsStream("/fixture.json");
        try {
            return objectMapper.readValue(is, SimulatorFixture.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
    // This method calls Google MAP API to retrive a list of points for the direction
    @Override
    public List<Point> getCoordinatesFromGoogle(DirectionInput directionInput) {
        final GeoApiContext context = new GeoApiContext()
                .setApiKey(environment.getRequiredProperty("gpsSimmulator.googleApiKey"));
        final DirectionsApiRequest request = DirectionsApi.getDirections(
                context,
                directionInput.getFrom(),
                directionInput.getTo());

        List<LatLng> latlongList = null;

        try {
            DirectionsResult result = request.await();
            latlongList = result.routes[0].overviewPolyline.decodePath();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        List<Point> points = new ArrayList<>();
        if (latlongList != null ) {
            for (LatLng latlng : latlongList) {
                points.add(new Point(latlng.lat, latlng.lng));
            }
        }

        return points;
    }

    @Override
    public String getCoordinatesFromGoogleAsPolyline(DirectionInput directionInput) {
        final GeoApiContext context = new GeoApiContext()
                .setApiKey(environment.getRequiredProperty("gpsSimmulator.googleApiKey"));
        final DirectionsApiRequest request = DirectionsApi.getDirections(
                context,
                directionInput.getFrom(),
                directionInput.getTo());

        try {
            DirectionsResult result  = request.await();
            return result.routes[0].overviewPolyline.getEncodedPath();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<ServiceLocation> getServiceStations() {
        return null;
    }
}
