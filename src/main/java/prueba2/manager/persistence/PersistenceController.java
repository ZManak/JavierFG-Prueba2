package prueba2.manager.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import prueba2.manager.logic.Person;
import prueba2.manager.logic.Turn;
import prueba2.manager.persistence.exceptions.NonexistentEntityException;

public class PersistenceController {
    
    private PersonJpaController controlPersJPA = new PersonJpaController();
    private TurnJpaController controlTurnJPA = new TurnJpaController();
    
    public void createPerson (Person perso) {
        controlPersJPA.create(perso);
    }
    
    public void deletePerson (Long id) throws NonexistentEntityException {
        controlPersJPA.destroy(0);
    }
    
    public Person getPerson (int id) {
        return controlPersJPA.getPerso(id);
    }
    
    public List<Person> getAll () {
        return controlPersJPA.findPersonaEntities();
    }
    
    public void editPerson (Person perso) {
        try {
            controlPersJPA.edit(perso);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createTurn (Turn turn) {
        controlTurnJPA.create(turn);
    }
    
    public void deleteTurn (int id) throws NonexistentEntityException {
        controlTurnJPA.destroy(id);
    }
    
    public void editTurn (Turn turn) {
        try{
           controlTurnJPA.edit(turn);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Turn getTurn (int personId) {
        return controlTurnJPA.findTurn(personId);
    }
    
    public List<Turn> getTurnsByPerson(Person perso) {
        List<Turn> turnsByPerson = new ArrayList<>();
        List<Turn> allTurns = controlTurnJPA.findTurnEntities();
        
        
        for (Turn turn : allTurns) {
            if (turn.getPersonId().equals(perso)) {
                turnsByPerson.add(turn);
            }
        }
        return turnsByPerson;
    }
    
    public List<Turn> getAllTurns () {
        return controlTurnJPA.findTurnEntities();
    }
    
    
    
}
    
