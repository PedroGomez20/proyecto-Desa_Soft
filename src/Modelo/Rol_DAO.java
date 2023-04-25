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
}
