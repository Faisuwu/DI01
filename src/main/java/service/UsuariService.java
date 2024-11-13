//Antoni Maqueda Bestard - DI01 - UsuariService
package service;

import model.Usuari;
import model.Workout;
import java.util.List;
import conection.DataAccess;

public class UsuariService {
    
    //Métode per obtenir els Workouts d'un usuari
    public  List<Workout> getWorkoutsByUser(Usuari user) {
        return DataAccess.getWorkoutsPerUser(user);
    }
    //Métode per obtenir tots els usuaris
    public List<Usuari> getAllUsers(){
        return DataAccess.getAllUsers();
    }
}
