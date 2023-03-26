package fr.limayrac.Camionnette.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.limayrac.Camionnette.model.Camionnette;

@Repository
public interface CamionnetteRepository extends CrudRepository<Camionnette, Integer>
{
    
}