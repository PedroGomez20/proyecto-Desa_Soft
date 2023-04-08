/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author prgc1
 */
public class Listado_rol_id {
    
    
    ArrayList<Id_rol>lista;
    
  
    public Listado_rol_id(){ 
        lista=new ArrayList();
    }
    
    public void Agregar_rol(Id_rol r){
        lista.add(r);
        
    }
    
    
}
