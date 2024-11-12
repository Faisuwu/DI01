//Antoni Maqueda Bestard - DI01 - Ejercicio
package model;

public class Exercici {
    
     private int id;
    private String name;
    private String description;
    private String imagePath; // Ruta a la imagen del ejercicio

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomExercici() { return name; }
    public void setNomExercici(String name) { this.name = name; }

    public String getDescripcio() { return description; }
    public void setDescripcio(String description) { this.description = description; }

    public String getDemoFoto() { return imagePath; }
    public void setDemoFoto(String imagePath) { this.imagePath = imagePath; }
    
}
