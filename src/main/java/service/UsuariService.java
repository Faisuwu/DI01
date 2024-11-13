//Antoni Maqueda Bestard - DI01 - UsuariService
package service;

import model.Usuari;
import model.Workout;
import java.util.List;
import conection.DataAccess;

public class UsuariService {
    public  List<Workout> getWorkoutsByUser(Usuari user) {
        return DataAccess.getWorkoutsPerUser(user);
    }
    public List<Usuari> getAllUsers(){
        return DataAccess.getAllUsers();
    }
}
