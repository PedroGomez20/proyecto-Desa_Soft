/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vistas.VendedorForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author prgc1
 */
public class Rol_DAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
 
   

    public DefaultComboBoxModel cargarcombo(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();
DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        String sql = ("SELECT nombre_rol FROM rol");

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Rol_combo rc = new Rol_combo();

                rc.setNom_rol(rs.getString(1));
                

                lr.Agregar_rol(rc);
                combo.addElement(rc.getNom_rol());
            }
           
           
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "se realio mal ");

        }
        return combo;
        

    }
    
    
    
    
//    
//    public DefaultComboBoxModel id_1_rol(JComboBox c) {
//
////        VendedorForm vfd = new VendedorForm();
//        DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
//
//        c.setModel(combo1);
//        Listado_rol lr = new Listado_rol();
//        String sql2 = ("SELECT id_rol FROM rol WHERE nombre_rol ='ADMINISTRADOR'");
//
//        //AQUI HACEMOS UNA SENTENCIA SQL PARA LA OBTENCION DEL ID ROL DE LA TABLA ROL
//        try {
//            con = cn.Conectar();
//            ps = con.prepareStatement(sql2);
//            rs = ps.executeQuery();
//
//            //AQUI HACEMOS COMPARACIONES SI EL USUARIO SELECCIONA EN EL COMBO BOX comborool alguna de las 3 opciones debera hacer una consulta sql con dicha opcion que seleccione y obtendra el ID DE ESE ROL
////            if (vfd.comborool.getSelectedItem().equals("ADMINISTRADOR")) {
//                
//                while (rs.next()) {
//                    //Rol_combo ES UNA CLASE DONDE ESTA LOS SET AND GET
//                    Rol_combo rc = new Rol_combo();
//
//                    rc.setNom_id(rs.getString(1));
//                    lr.Agregar_rol(rc);
//                    combo1.addElement(rc.getNom_id());
//
//                }
////            }
//        } catch (Exception e) {
//
//        }
//        return combo1;
//    }
//    
//    
//     public DefaultComboBoxModel id_1_rol2(JComboBox c) {
//
////        VendedorForm vfd = new VendedorForm();
//        DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
//
//        c.setModel(combo1);
//        Listado_rol lr = new Listado_rol();
//        String sql2 = ("SELECT id_rol FROM rol WHERE nombre_rol ='VENDEDOR'");
//
//        //AQUI HACEMOS UNA SENTENCIA SQL PARA LA OBTENCION DEL ID ROL DE LA TABLA ROL
//        try {
//            con = cn.Conectar();
//            ps = con.prepareStatement(sql2);
//            rs = ps.executeQuery();
//
//            //AQUI HACEMOS COMPARACIONES SI EL USUARIO SELECCIONA EN EL COMBO BOX comborool alguna de las 3 opciones debera hacer una consulta sql con dicha opcion que seleccione y obtendra el ID DE ESE ROL
////            if (vfd.comborool.getSelectedItem().equals("ADMINISTRADOR")) {
//                
//                while (rs.next()) {
//                    //Rol_combo ES UNA CLASE DONDE ESTA LOS SET AND GET
//                    Rol_combo rc = new Rol_combo();
//
//                    rc.setNom_id(rs.getString(1));
//                    lr.Agregar_rol(rc);
//                    combo1.addElement(rc.getNom_id());
//
//                }
////            }
//        } catch (Exception e) {
//
//        }
//        return combo1;
//    }

//    
}
