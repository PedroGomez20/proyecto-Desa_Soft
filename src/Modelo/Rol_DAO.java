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
import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author prgc1
 */
public class Rol_DAO {

    Conexion cn = new Conexion();
    Connection con = cn.Conectar();//////23
    PreparedStatement ps;
    ResultSet rs;
//    public int add(Object[] o) {
//        int r = 0;
//        String sql = "insert into cliente(Dni, Nombres, Direccion, Estado) values(?, ?, ?, ?)";
//        try {
//            con = cn.Conectar();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, o[0]);
//            ps.setObject(2, o[1]);
//            ps.setObject(3, o[2]);
//            ps.setObject(4, o[3]);
//            r = ps.executeUpdate();
//        } catch (Exception e) {
//        }
//        return r;
//    }
    
    
    
//    public JTextField id_1_rol(JComboBox c) {
//
//        DefaultComboBoxModel combo = new DefaultComboBoxModel();
//ComboBox<Rol_combo> comn = new ComboBox<>();
//
//JTextField<Rol_combo> coamn = new JTextField<>();
//String sql = "SELECT id_rol FROM rol WHERE nombre_rol ='ADMINISTRADOR'";
//        try {
//            con = cn.Conectar();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Rol_combo cq = new Rol_combo();
//                cq.getNom_id(rs.getString(1));
//                
//                
//            }
        
    

        


//        c.setModel(combo);
//        Listado_rol lr = new Listado_rol();
//
////        Rol_DAO rd = new Rol_DAO();
////        rd.id_1_rol();
//        try {
//            VendedorForm vfr =new VendedorForm();
//            Statement st = con.createStatement();
//
//            if (vfr.comborool.getSelectedIndex() == 0) {
////                 Rol_combo rc = new Rol_combo();
////                combo.addElement(rc.getNom_id());
//                ResultSet rs = st.executeQuery("SELECT id_rol FROM rol WHERE nombre_rol ='ADMINISTRADOR'");
//                while (rs.next()) {
//
//                    Rol_combo rc = new Rol_combo();
//
//                    rc.setNom_id(rs.getString(1));
//                    lr.Agregar_rol(rc);
//                    combo.addElement(rc.getNom_id());
//
//                }
//            }
//        } catch (Exception e) {
//
//        }
//        return comn;
//    }
//    
    
    
    
    
    
    

//    String rol_dato;
//
//    public void rol_ge(String rol_dato) {
//        this.rol_dato = rol_dato;
//
//    }
//String estado;
//    public void id_1_rol() {
//        
//        if (rol_dato.equals("ADMINISTRADOR")) {
//            
//           estado  = "1";
//            
//        }
//
//        VendedorForm fvv = new VendedorForm();
//        fvv.obt_id_rol(rol_dato);
//
////    String r=null;
////
//////        DefaultComboBoxModel combo = new DefaultComboBoxModel();
//////
//////        c.setModel(combo);
////        Listado_rol lr = new Listado_rol();
////        VendedorForm vfr =new VendedorForm();
////
////        try {
////           
////            Statement st = con.createStatement();
////
////           
////                ResultSet rs = st.executeQuery("SELECT id_rol FROM rol WHERE nombre_rol = 'ADMINISTRADOR'");
////                while (rs.next()) {
////
////                    Rol_combo rc = new Rol_combo();
////
////                    rc.setNom_id(rs.getString(1));
////                    lr.Agregar_rol(rc);
////                    r=rc.getNom_id();
//////                    combo.addElement(rc.getNom_id());
////
////                }
////            
////        } catch (Exception e) {
////
////        }
////        return r;
//    }
//
//}
}