//Antoni Maqueda Bestard - DI01 - Entrenamiento
package model;

import java.time.LocalDate;

public class Workout {
    
    private int id;
    private String name;
    private String date;
    private int userId;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getForDate() { return date; }
    public void setForDate(String date) { this.date = date; }

    public int getIdUsuari() { return userId; }
    public void setIdUsuari(int userId) { this.userId = userId; }
}
