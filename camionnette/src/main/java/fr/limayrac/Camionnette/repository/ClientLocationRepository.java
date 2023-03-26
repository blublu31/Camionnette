package fr.limayrac.Camionnette.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.limayrac.Camionnette.model.ClientLocation;

@Repository
public interface ClientLocationRepository extends CrudRepository<ClientLocation, Integer> {
    
    public ClientLocation findByClient_IdAndLocation_Id(Integer clientId, Integer id);

}
