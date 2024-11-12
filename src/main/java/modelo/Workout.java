//Antoni Maqueda Bestard - DI01 - Entrenamiento
package modelo;

import java.time.LocalDate;

public class Workout {
    
    private int id;
    private String name;
    private LocalDate date;
    private int userId;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
