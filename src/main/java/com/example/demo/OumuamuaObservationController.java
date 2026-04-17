package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observations")
public class OumuamuaObservationController {

    private final OumuamuaObservationService service;

    public OumuamuaObservationController(OumuamuaObservationService service) {
        this.service = service;
    }

    @GetMapping
    public List<OumuamuaObservation> getAllObservations() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OumuamuaObservation getObservation(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<OumuamuaObservation> createObservation(
            @Valid @RequestBody OumuamuaObservationRequest request) {
        OumuamuaObservation created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public OumuamuaObservation updateObservation(
            @PathVariable Long id,
            @Valid @RequestBody OumuamuaObservationRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteObservation(@PathVariable Long id) {
        service.delete(id);
    }
}
