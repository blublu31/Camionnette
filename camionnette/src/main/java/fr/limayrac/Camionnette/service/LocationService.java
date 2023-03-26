package fr.limayrac.Camionnette.service;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.limayrac.Camionnette.model.Location;
import fr.limayrac.Camionnette.repository.LocationRepository;

@Data
@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Iterable<Location> getLocations(){
        return locationRepository.findAll();
    }

    public Location saveLocation(Location location){
        return locationRepository.save(location);
    }

}
