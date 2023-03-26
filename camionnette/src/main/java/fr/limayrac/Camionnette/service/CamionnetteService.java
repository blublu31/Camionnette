package fr.limayrac.Camionnette.service;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.limayrac.Camionnette.model.Camionnette;
import fr.limayrac.Camionnette.repository.CamionnetteRepository;
import java.util.Optional;

@Data
@Service
public class CamionnetteService {
    @Autowired
    private CamionnetteRepository camionnetteRepository;

    public Optional<Camionnette> getCamionnette(final Integer id){
        return camionnetteRepository.findById(id);
    }

    public Iterable<Camionnette> getCamionnettes() {
        return camionnetteRepository.findAll();
    }
    
    public Camionnette saveCamionnette(Camionnette camionnette){
        return camionnetteRepository.save(camionnette);
    }
}
