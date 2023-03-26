package fr.limayrac.Camionnette.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.limayrac.Camionnette.model.Client;
import fr.limayrac.Camionnette.model.Location;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>
{
    List<Client> findByLocationsNotContaining(Location location);
}