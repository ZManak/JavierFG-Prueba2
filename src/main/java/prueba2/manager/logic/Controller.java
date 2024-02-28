/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba2.manager.logic;

import java.util.List;
import java.util.stream.Stream;
import prueba2.manager.persistence.PersistenceController;
import prueba2.manager.persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author Manak
 */
public class Controller {
    
    PersistenceController controlPersis = new PersistenceController();
    PersistenceController controlTurn = new PersistenceController();
    
     public void createPerson (Person perso) {
        controlPersis.createPerson(perso);
    }
    
    public void deletePerson (Long id) throws NonexistentEntityException {
        controlPersis.deletePerson(id);
    }
    
    public Person getPerson (int id) {
        return controlPersis.getPerson(id);
    }
    
    public List<Person> getAllPerson () {
        return controlPersis.getAll();
    }
    
    public void editPerson (Person perso) {
        controlPersis.editPerson(perso);
    }
    
    public void createTurn(Turn turn) {
        controlPersis.createTurn(turn);
    }
    
    public void deleteTurn(int id) throws NonexistentEntityException {
        controlPersis.deleteTurn(id);
    } 
    
    public void editTurn(Turn turn){
        controlPersis.editTurn(turn);
    }
    
    public Turn getTurn (int id) {
        return controlPersis.getTurn(id);
    }
    
    public List<Turn> getAllTurns(String name){
        return controlPersis.getAllTurns();
    }

}
