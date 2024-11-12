package service;

import model.Exercici;
import java.util.List;
import application.DataAccess;

public class ExerciseService {
    public List<Exercici> getAllExercises() {
        return DataAccess.getAllExercicis();
    }
}