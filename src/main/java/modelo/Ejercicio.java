//Antoni Maqueda Bestard - DI01 - Ejercicio
package modelo;

public class Ejercicio {
    
     private int id;
    private String name;
    private String description;
    private String imagePath; // Ruta a la imagen del ejercicio

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    
}
