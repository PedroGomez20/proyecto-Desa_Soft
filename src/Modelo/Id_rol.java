/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vistas.VendedorForm;

/**
 *
 * @author prgc1
 */
public class Id_rol {
    
    private int id;

    public Id_rol() {
    }

    
    public Id_rol(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public void sss(){
         VendedorForm vf =new VendedorForm();
         vf.id_rol_usu(id);
    }
   
  
    
}
