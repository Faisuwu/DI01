//Antoni Maqueda Bestard - DI01 - Usuario
package model;

public class Usuari {
    
    private int id;
    private String email;
    private String hashedPassword;
    private String name;
    private Boolean instructor;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return hashedPassword; }
    public void setPasswordHash(String hashedPassword) { this.hashedPassword = hashedPassword; }

    public String getNom() { return name; }
    public void setNom(String name) { this.name = name; }
    
    public Boolean isInstructor() { return instructor; }
    public void setInstructor (Boolean instructor) { this.instructor = instructor; }
    
  
    
}