//Antoni Maqueda Bestard - DI01 - ExerciseService
package service;

import model.Exercici;
import java.util.List;
import conection.DataAccess;

public class ExerciseService {
    public List<Exercici> getAllExercises() {
        return DataAccess.getAllExercicis();
    }
    public void createExercise(Exercici exercise) {
        //Void hipotética que no realitzarem
    }

    public void updateExercise(Exercici exercise) {
        //Void hipotética que no realitzarem
    }

    public void deleteExercise(int Exercici) {
        //Void hipotética que no realitzarem
    }
}