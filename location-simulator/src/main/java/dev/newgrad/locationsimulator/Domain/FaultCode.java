package dev.newgrad.locationsimulator.Domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

// Same Data Structure as the location-service
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class FaultCode {

    private String engineMake;
    private String faultCode;
    private String faultCodeId;
    private String faultCodeClassification;
    private String description;
    private String repairInstructions;
    private String fmi;
    private String sa;
    private String spn;

}