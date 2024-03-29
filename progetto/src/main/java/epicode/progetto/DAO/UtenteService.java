package epicode.progetto.DAO;

import epicode.progetto.entities.Utente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;
    public void saveUtente(Utente newUtente) {
        if (newUtente.getName().length() < 2)
            throw new RuntimeException("Il nome non può essere più corto di 2 caratteri!");
        utenteDAO.save(newUtente);
        log.info("Utente salvato correttamente");
    }
    public Utente findById(long userId) throws ItemNotFoundException {
        return utenteDAO.findById(userId).orElseThrow(() -> new ItemNotFoundException(userId));
    }

    public void findByIdAndDelete(long utenteId) {
        Utente found = this.findById(utenteId);
        utenteDAO.delete(found);
        log.info("L'utente con l'id " + utenteId + " è stato cancellato correttamente!");
    }
}
