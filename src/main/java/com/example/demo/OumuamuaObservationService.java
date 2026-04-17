package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OumuamuaObservationService {

    private final OumuamuaObservationRepository repository;

    public OumuamuaObservationService(OumuamuaObservationRepository repository) {
        this.repository = repository;
    }

    public List<OumuamuaObservation> findAll() {
        return repository.findAll();
    }

    public OumuamuaObservation findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Observation not found"));
    }

    public OumuamuaObservation create(OumuamuaObservationRequest request) {
        return repository.save(new OumuamuaObservation(request.getObservationDate(), request.getDetails()));
    }

    public OumuamuaObservation update(Long id, OumuamuaObservationRequest request) {
        OumuamuaObservation existing = findById(id);
        existing.setObservationDate(request.getObservationDate());
        existing.setDetails(request.getDetails());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Observation not found");
        }
        repository.deleteById(id);
    }
}
