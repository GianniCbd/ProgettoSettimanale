package epicode.progetto.DAO;

import epicode.progetto.entities.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LocationService {

    @Autowired
    private LocationDAO locationDAO;

    public void saveLocation(Location newLocation) {
        locationDAO.save(newLocation);
        log.info("Location salvata correttamente");
    }

    public Location findById(long locationId) throws ItemNotFoundException {
        return locationDAO.findById(locationId).orElseThrow(() -> new ItemNotFoundException(locationId));
    }
}
