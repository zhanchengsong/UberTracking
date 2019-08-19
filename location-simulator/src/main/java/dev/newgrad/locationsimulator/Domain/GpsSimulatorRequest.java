package dev.newgrad.locationsimulator.Domain;

import lombok.Data;

@Data
public class GpsSimulatorRequest {

    private String vin;
    private Double speedInKph;
    private boolean move = true;
    private boolean exportPositionsToKml = false;
    private boolean exportPositionsToMessaging = true;
    private Integer reportInterval = 500;
    private int secondsToError = 0;
    private VehicleStatus vehicleStatus = VehicleStatus.NONE;
    private String polyline;
    private FaultCode faultCode;



    public boolean isMove() {
        return move;
    }

    public boolean isExportPositionsToKml() {
        return exportPositionsToKml;
    }




    public boolean isExportPositionsToMessaging() {
        return exportPositionsToMessaging;
    }



    @Override
    public String toString() {
        return "GpsSimulatorRequest [vin=" + vin + ", speedInKph=" + speedInKph + ", move=" + move + ", exportPositionsToKml="
                + exportPositionsToKml + ", exportPositionsToMessaging=" + exportPositionsToMessaging
                + ", reportInterval=" + reportInterval + "]";
    }



}
