package dev.newgrad.locationservice.Domin;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@RequiredArgsConstructor
public class UnitFault {
    private final String vin;
    private Long spn;
    private Long fmi;

    @SuppressWarnings("unused")
    private UnitFault() {
        this.vin = "";
    }

}
