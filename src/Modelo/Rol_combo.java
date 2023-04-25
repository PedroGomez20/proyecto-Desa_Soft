
package Modelo;


public class Rol_combo {
    
   private int id;
    private String nom_rol,nom_id;

  

    public Rol_combo() {
    }
    
    
      public Rol_combo( int id,String nom_rol, String nom_id) {
        this.id = id;
        this.nom_rol = nom_rol;
        this.nom_id = nom_id;
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

    public String getNom_id() {
        return nom_id;
    }

    public void setNom_id(String nom_id) {
        this.nom_id = nom_id;
    }
    
    
    
}
