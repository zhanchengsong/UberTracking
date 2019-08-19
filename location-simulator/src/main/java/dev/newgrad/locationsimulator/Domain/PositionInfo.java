package dev.newgrad.locationsimulator.Domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PositionInfo {
    private String vin;
    private Point position;
    private VehicleStatus vehicleStatus = VehicleStatus.NONE;

    private Leg leg;


    private Double distanceFromStart;


    private Double speed;
}
