
package Modelo;


public class Rol_combo {
    
    private int id;
    private String nom_rol;

    public Rol_combo() {
    }
    
    

    public Rol_combo(int id, String nom_rol) {
        this.id = id;
        this.nom_rol = nom_rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }
    
    
    
}
