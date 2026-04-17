package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class OumuamuaObservationRequest {

    @NotNull(message = "observationDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate observationDate;

    @NotBlank(message = "details must not be blank")
    private String details;

    public OumuamuaObservationRequest() {
    }

    public LocalDate getObservationDate() {
        return observationDate;
    }

    public void setObservationDate(LocalDate observationDate) {
        this.observationDate = observationDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
