//Antoni Maqueda Bestard - DI01 - ExerciseService
package service;

import model.Exercici;
import java.util.List;
import conection.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExerciseService {

    // Métode per obtenir tots els exercicis
    public List<Exercici> getAllExercises() {
        return DataAccess.getAllExercicis();
    }

    // Métode per crear un nou exercici
    public void createExercise(Exercici exercise) {
        String sql = "INSERT INTO Exercicis (NomExercici, Descripcio, DemoFoto) VALUES (?, ?, ?)";

        try (Connection conn = DataAccess.getConnection();
             PreparedStatement insertStatement = conn.prepareStatement(sql)) {

            insertStatement.setString(1, exercise.getNomExercici());
            insertStatement.setString(2, exercise.getDescripcio());
            insertStatement.setString(3, exercise.getDemoFoto());

            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método per actualitzar un exercici existent
    public void updateExercise(Exercici exercise) {
        String sql = "UPDATE Exercicis SET NomExercici = ?, Descripcio = ?, DemoFoto = ? WHERE Id = ?";

        try (Connection conn = DataAccess.getConnection();
             PreparedStatement updateStatement = conn.prepareStatement(sql)) {

            updateStatement.setString(1, exercise.getNomExercici());
            updateStatement.setString(2, exercise.getDescripcio());
            updateStatement.setString(3, exercise.getDemoFoto());
            updateStatement.setInt(4, exercise.getId());

            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métode per eliminar un exercici
    public void deleteExercise(int exerciseId) {
        String sql = "DELETE FROM Exercicis WHERE Id = ?";

        try (Connection conn = DataAccess.getConnection();
             PreparedStatement deleteStatement = conn.prepareStatement(sql)) {

            deleteStatement.setInt(1, exerciseId);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
