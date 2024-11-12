//Antoni Maqueda Bestard - DI01 - WorkoutService
package service;

import model.Workout;
import model.Usuari;
import java.util.List;
import application.DataAccess;

public class WorkoutService {
    public List<Workout> getWorkoutsByUserId(Usuari user) {
        return DataAccess.getWorkoutsPerUser(user);
    }
}