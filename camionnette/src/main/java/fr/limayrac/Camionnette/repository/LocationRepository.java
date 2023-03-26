package fr.limayrac.Camionnette.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.limayrac.Camionnette.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>
{
    
}