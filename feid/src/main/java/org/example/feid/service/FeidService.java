package org.example.feid.service;

import org.example.feid.entity.FeidEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeidService {

    private final List<FeidEntity> feid = new ArrayList<>();
    private int nextId = 11; // El siguiente ID disponible después de los 10 iniciales

    public FeidService() {
        feid.add(new FeidEntity(1, "LUNA", "3:17", "Feid"));
        feid.add(new FeidEntity(2, "FRESH KERIAS", "3:24", "Feid"));
        feid.add(new FeidEntity(3, "POR FAZ", "3:05", "Feid"));
        feid.add(new FeidEntity(4, "NO TE VAYAS", "3:42", "Feid"));
        feid.add(new FeidEntity(5, "FERXXO", "3:09", "Feid"));
        feid.add(new FeidEntity(6, "LA INOCENTE", "3:36", "Feid"));
        feid.add(new FeidEntity(7, "SI TU SABES", "3:10", "Feid"));
        feid.add(new FeidEntity(8, "UN COPO DE CIELO", "3:00", "Feid"));
        feid.add(new FeidEntity(9, "DANDY", "3:19", "Feid"));
        feid.add(new FeidEntity(10, "BELLO", "3:30", "Feid"));
    }

    public List<FeidEntity> getAllFeid() {
        return feid;
    }

    public FeidEntity getFeidById(int id) {
        Optional<FeidEntity> result = feid.stream()
                .filter(song -> song.getId() == id)
                .findFirst();

        return result.orElse(null);
    }

    public FeidEntity addFeid(FeidEntity newSong) {
        newSong.setId(nextId++);
        feid.add(newSong);
        return newSong;
    }

    public FeidEntity updateFeid(int id, FeidEntity updatedSong) {
        for (int i = 0; i < feid.size(); i++) {
            if (feid.get(i).getId() == id) {
                updatedSong.setId(id);
                feid.set(i, updatedSong);
                return updatedSong;
            }
        }
        return null;
    }

    public boolean deleteFeid(int id) {
        return feid.removeIf(song -> song.getId() == id);
    }
}