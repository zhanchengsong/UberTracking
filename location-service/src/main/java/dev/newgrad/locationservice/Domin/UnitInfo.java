package dev.newgrad.locationservice.Domin;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
// This class can be embedded into Location
public class UnitInfo {
    private final String unitVin;
    private String engineMake;
    private String customerName;
    private String unitNumber;

    @SuppressWarnings("unused")
    private UnitInfo() {
        this.unitVin = "";
    }
}
