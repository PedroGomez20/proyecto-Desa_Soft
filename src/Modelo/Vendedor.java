
package Modelo;



public class Vendedor {
    
    int id , id_rol_rol;
    String dni, nom, tel, estado, user,id_rol;

    public Vendedor() {
    }

    public Vendedor(int id, String dni, String nom, String tel, String estado, String user,String id_rol, int id_rol_rol) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.tel = tel;
        this.estado = estado;
        this.user = user;
         this.id_rol = id_rol;
        
    }

    public int getId() {
        return id;
    }

    
   

    public String getDni() {
        
        
        
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getTel() {
        return tel;
    }

    public String getEstado() {
        return estado;
    }

    public String getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
        
        
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_rol_rol() {
        return id_rol_rol;
    }

    public void setId_rol_rol(int id_rol_rol) {
        this.id_rol_rol = id_rol_rol;
    }

   

   


    
}
