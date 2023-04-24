package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VendedorDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    EntidadVendedor ev = new EntidadVendedor();

    public EntidadVendedor ValidarVendedor(String dni, String user, String id_rol) {
        String sql = "select *  from vendedor  where Dni = ? and User = ? and id_rol = ? ;";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            ps.setString(3, id_rol);
            rs = ps.executeQuery();

            while (rs.next()) {
                ev.setId(rs.getInt(1));
                ev.setDni(rs.getString(2));
                ev.setNom(rs.getString(3));
                ev.setTel(rs.getString(4));
                ev.setUser(rs.getString(5));
                ev.setId_rol(rs.getString(6));

            }
        } catch (Exception e) {
        }

        return ev;
    }

    @Override

    public List listar() {
        List<Vendedor> lista = new ArrayList<>();
        String sql = "SELECT v.IdVendedor,v.Dni,v.Nombres,v.Telefono, v.User,r.nombre_rol FROM vendedor v INNER JOIN rol r ON v.id_rol = r.id_rol ORDER BY v.IdVendedor ASC ";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setId(rs.getInt(1));
                v.setDni(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setTel(rs.getString(4));

                v.setUser(rs.getString(5));
                v.setId_rol(rs.getString(6));
                lista.add(v);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO vendedor( Dni, Nombres, Telefono,  User ,  id_rol) values(?, ?, ?, ?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "erorr");
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update vendedor set Dni = ?, Nombres = ?, Telefono = ?, User = ? , id_rol=? where IdVendedor = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "erorr");

        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from vendedor where IdVendedor = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

}
