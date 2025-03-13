package org.example.feid.controller;

import org.example.feid.entity.FeidEntity;
import org.example.feid.service.FeidService;
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
    public FeidEntity getOneFeid(@PathVariable int id) {
        return feidService.getFeidById(id);
    }

    @PostMapping
    public FeidEntity addFeid(@RequestBody FeidEntity newSong) {
        return feidService.addFeid(newSong);
    }

    @PutMapping("/{id}")
    public FeidEntity updateFeid(@PathVariable int id, @RequestBody FeidEntity updatedSong) {
        return feidService.updateFeid(id, updatedSong);
    }

    @DeleteMapping("/{id}")
    public String deleteFeid(@PathVariable int id) {
        boolean isDeleted = feidService.deleteFeid(id);
        if (isDeleted) {
            return "Canción con ID " + id + " eliminada correctamente";
        } else {
            return "No se encontró la canción con ID " + id;
        }
    }
}