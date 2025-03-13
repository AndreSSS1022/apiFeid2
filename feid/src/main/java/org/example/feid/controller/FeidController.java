package org.example.feid.controller;

import org.example.feid.entity.FeidEntity;
import org.example.feid.service.FeidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feid")
public class FeidController {

    public final FeidService feidService;

    public FeidController(FeidService feidService) {
        this.feidService = feidService;
    }

    @GetMapping
    public List<FeidEntity> getAllFeid() {
        return feidService.getAllFeid();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeidEntity> getOneFeid(@PathVariable int id) {
        FeidEntity song = feidService.getFeidById(id);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FeidEntity> addFeid(@RequestBody FeidEntity newSong) {
        FeidEntity addedSong = feidService.addFeid(newSong);
        return new ResponseEntity<>(addedSong, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeidEntity> updateFeid(@PathVariable int id, @RequestBody FeidEntity updatedSong) {
        FeidEntity result = feidService.updateFeid(id, updatedSong);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeid(@PathVariable int id) {
        boolean isDeleted = feidService.deleteFeid(id);
        if (isDeleted) {
            return ResponseEntity.ok("Canción con ID " + id + " eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la canción con ID " + id);
        }
    }
}