//Antoni Maqueda Bestard - DI01 - WorkoutService
package service;

import model.Workout;
import model.Exercici;
import model.Usuari;
import java.util.ArrayList;
import java.util.List;
import conection.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class WorkoutService {

    // Métode per obtenir tots els workouts d'un usuari
    public List<Workout> getWorkoutsByUserId(Usuari user) {
        return DataAccess.getWorkoutsPerUser(user);
    }

    // Métode per crear un nou workout
    public void createWorkout(Workout workout, ArrayList<Exercici> exercicis) {
        DataAccess.insertWorkout(workout, exercicis);
    }

    // Métode per actualitzar un workout existent
    public void updateWorkout(Workout workout) {
    
        String sql = "UPDATE Workouts SET ForDate = ?, UserId = ?, Comments = ? WHERE Id = ?";
        
        try (Connection conn = DataAccess.getConnection();
             PreparedStatement updateStatement = conn.prepareStatement(sql)) {
            
            updateStatement.setString(1, workout.getForDate());
            updateStatement.setInt(2, workout.getIdUsuari());
            updateStatement.setString(3, workout.getComments());
            updateStatement.setInt(4, workout.getId());
            
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métode per eliminar un workout específic per id
    public void deleteWorkout(int workoutId) {
        
        String sql = "DELETE FROM Workouts WHERE Id = ?";
        
        try (Connection conn = DataAccess.getConnection();
             PreparedStatement deleteStatement = conn.prepareStatement(sql)) {
            
            deleteStatement.setInt(1, workoutId);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}