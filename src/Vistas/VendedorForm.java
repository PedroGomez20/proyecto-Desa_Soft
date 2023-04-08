package Vistas;

import Modelo.Conexion;

import Modelo.Listado_rol;

import Modelo.Rol_combo;
import Modelo.Vendedor;
import Modelo.VendedorDAO;
import static Vistas.LoginForm.combo1;
import static Vistas.Principal.jlrol;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendedorForm extends javax.swing.JInternalFrame {

    Conexion cn = new Conexion();
    Connection con = cn.Conectar();//////23

    VendedorDAO dao = new VendedorDAO();
    Vendedor vd = new Vendedor();

    DefaultTableModel modelo = new DefaultTableModel();

    int id;

    public VendedorForm() {

        initComponents();

        cargarcombo(comborool);
//        id_rol_sele(id_num);
        listar();

//        rec.Rellenar( "nombre_rol", comborol1);
    }
    
    
      private String rol_usuario;
     public void usuario_rol(String rol_usuario){
        this.rol_usuario = rol_usuario;
        jlrol.setText(rol_usuario);
    }

    int rol_id_general;

    public void id_rol_usu(int rol_id_general) {
        this.rol_id_general = rol_id_general;
        String con_v = String.valueOf(rol_id_general);
        id_rol_sele.setText(con_v);
    }

    void listar() {
        List<Vendedor> lista = dao.listar();
        modelo = (DefaultTableModel) TablaV.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getDni();
            ob[2] = lista.get(i).getNom();
            ob[3] = lista.get(i).getTel();
            ob[4] = lista.get(i).getEstado();
            ob[5] = lista.get(i).getUser();
            ob[6] = lista.get(i).getId_rol();
            modelo.addRow(ob);
        }
        TablaV.setModel(modelo);
    }

    void Agregar() {

        String roll;
        if (comborool.getSelectedItem().equals("ADMINISTRADOR")) {
//            if (this.comborool.getSelectedIndex() == 0) {
////               roll="1";
////                this.id_num.setModel(new DefaultComboBoxModel(this.id_rol_sele(this.comborool.getSelectedItem().toString())));
//
//            }
            roll= (String)  id_num.getSelectedItem();
           
//             comborol.getSelectedItem(roll);

//            String rsol= comborol.getSelectedItem().toString(roll);
            String dni = TxtDni.getText();
            String nom = TxtNombres.getText();
            String tel = TxtTelefono.getText();
            String es = CbxEstado.getSelectedItem().toString();
            String user = TxtUser.getText();
            String rol = roll;

            Object[] ob = new Object[6];
            ob[0] = dni;
            ob[1] = nom;
            ob[2] = tel;
            ob[3] = es;
            ob[4] = user;
            ob[5] = rol;
            dao.add(ob);

        } else if (comborool.getSelectedItem().equals("VENDEDOR")) {
            roll= (String)  id_num.getSelectedItem();
//           comborol.getSelectedItem().equals("2");
            String dni = TxtDni.getText();
            String nom = TxtNombres.getText();
            String tel = TxtTelefono.getText();
            String es = CbxEstado.getSelectedItem().toString();
            String user = TxtUser.getText();
            String rol = roll;

            Object[] ob = new Object[6];
            ob[0] = dni;
            ob[1] = nom;
            ob[2] = tel;
            ob[3] = es;
            ob[4] = user;
            ob[5] = rol;
            dao.add(ob);
        } else if (comborool.getSelectedItem().equals("GERENTE")) {
           roll= (String)  id_num.getSelectedItem();
//           comborol.getSelectedItem().equals("2");
            String dni = TxtDni.getText();
            String nom = TxtNombres.getText();
            String tel = TxtTelefono.getText();
            String es = CbxEstado.getSelectedItem().toString();
            String user = TxtUser.getText();
            String rol = roll;

            Object[] ob = new Object[6];
            ob[0] = dni;
            ob[1] = nom;
            ob[2] = tel;
            ob[3] = es;
            ob[4] = user;
            ob[5] = rol;
            dao.add(ob);

        }

    }
    String roll;

    void Actualizar() {

        int fila = TablaV.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA");
        } else {

            if (comborool.getSelectedItem().equals("ADMINISTRADOR")) {
                roll = "1";

                String dni = TxtDni.getText();
                String nom = TxtNombres.getText();
                String tel = TxtTelefono.getText();
                String es = CbxEstado.getSelectedItem().toString();
                String user = TxtUser.getText();
                String rol = roll;
                Object[] obj = new Object[7];
                obj[0] = dni;
                obj[1] = nom;
                obj[2] = tel;
                obj[3] = es;
                obj[4] = user;
                obj[5] = rol;
                obj[6] = id;
                dao.actualizar(obj);

            } else if (comborool.getSelectedItem().equals("VENDEDOR")) {
                roll = "2";

                String dni = TxtDni.getText();
                String nom = TxtNombres.getText();
                String tel = TxtTelefono.getText();
                String es = CbxEstado.getSelectedItem().toString();
                String user = TxtUser.getText();
                String rol = roll;
                Object[] obj = new Object[7];
                obj[0] = dni;
                obj[1] = nom;
                obj[2] = tel;
                obj[3] = es;
                obj[4] = user;
                obj[5] = rol;
                obj[6] = id;
                dao.actualizar(obj);
            } else if (comborool.getSelectedItem().equals("GERENTE")) {
                roll = "5";

                String dni = TxtDni.getText();
                String nom = TxtNombres.getText();
                String tel = TxtTelefono.getText();
                String es = CbxEstado.getSelectedItem().toString();
                String user = TxtUser.getText();
                String rol = roll;
                Object[] obj = new Object[7];
                obj[0] = dni;
                obj[1] = nom;
                obj[2] = tel;
                obj[3] = es;
                obj[4] = user;
                obj[5] = rol;
                obj[6] = id;
                dao.actualizar(obj);
            }
        }
    }

    void Eliminar() {
        int fila = TablaV.getSelectedRow();
        int ids = Integer.parseInt(TablaV.getValueAt(fila, 0).toString());
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminar(ids);
        }
    }

    void Nuevo() {
        TxtDni.setText("");
        TxtNombres.setText("");
        TxtTelefono.setText("");
        TxtUser.setText("");
        CbxEstado.setSelectedIndex(0);
        TxtDni.requestFocus();
        comborool.setSelectedIndex(0);
    }

    void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtDni = new javax.swing.JTextField();
        TxtNombres = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        CbxEstado = new javax.swing.JComboBox<>();
        BtnAgregar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        TxtUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comborool = new javax.swing.JComboBox<>();
        id_rol_sele = new javax.swing.JLabel();
        id_num = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaV = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Vendedor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("DNI:");

        jLabel2.setText("NOMBRES:");

        jLabel3.setText("TELEFONO:");

        jLabel4.setText("USUARIO:");

        CbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "1", "0" }));
        CbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxEstadoActionPerformed(evt);
            }
        });

        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnActualizar.setText("ACTUALIZAR");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnNuevo.setText("NUEVO");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        jLabel5.setText("ESTADO:");

        jLabel6.setText("ROL:");

        comborool.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboroolItemStateChanged(evt);
            }
        });
        comborool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboroolActionPerformed(evt);
            }
        });

        jLabel7.setText("COD. Rol:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtDni)
                                    .addComponent(TxtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(TxtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtUser)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comborool, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CbxEstado, 0, 160, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_num, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(id_rol_sele, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(id_rol_sele, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comborool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(id_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TablaV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRES", "TELEFONO", "ESTADO", "USUARIO", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaV);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        Agregar();
        LimpiarTabla();
        listar();
        Nuevo();
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        Actualizar();
        LimpiarTabla();
        listar();
        Nuevo();
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        Eliminar();
        LimpiarTabla();
        listar();
        Nuevo();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        Nuevo();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void TablaVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVMouseClicked
        int fila = TablaV.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA");
        } else {
            id = Integer.parseInt(TablaV.getValueAt(fila, 0).toString());
            String dni = TablaV.getValueAt(fila, 1).toString();
            String nom = TablaV.getValueAt(fila, 2).toString();
            String tel = TablaV.getValueAt(fila, 3).toString();
            String es = TablaV.getValueAt(fila, 4).toString();
            String user = TablaV.getValueAt(fila, 5).toString();
            String rol = TablaV.getValueAt(fila, 6).toString();
            TxtDni.setText(dni);
            TxtNombres.setText(nom);
            TxtTelefono.setText(tel);
            CbxEstado.setSelectedItem(es);
            TxtUser.setText(user);
            comborool.setSelectedItem(rol);

            if (rol.equals("ADMINISTRADOR")) {
                roll = "1";
            } else if (rol.equals("VENDEDOR")) {
                roll = "2";
            } else if (rol.equals("GERENTE")) {
                roll = "3";
            }
        }
    }//GEN-LAST:event_TablaVMouseClicked

    private void CbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbxEstadoActionPerformed

    private void comboroolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboroolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboroolActionPerformed

    private void comboroolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboroolItemStateChanged
        // TODO add your handling code here:

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            if (this.comborool.getSelectedIndex() == 0) {
                id_1_rol(id_num);
//                this.id_num.setModel(new DefaultComboBoxModel(this.id_rol_sele(this.comborool.getSelectedItem().toString())));

            }
            if (this.comborool.getSelectedIndex()  ==1) {
                id_2_rol(id_num);
//                this.id_num.setModel(new DefaultComboBoxModel(this.id_rol_sele(this.comborool.getSelectedItem().toString())));

            }if (this.comborool.getSelectedIndex()  ==2) {
                id_3_rol(id_num);
//                this.id_num.setModel(new DefaultComboBoxModel(this.id_rol_sele(this.comborool.getSelectedItem().toString())));

            }

        }

    }//GEN-LAST:event_comboroolItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CbxEstado;
    private javax.swing.JTable TablaV;
    private javax.swing.JTextField TxtDni;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtUser;
    public javax.swing.JComboBox<String> comborool;
    private javax.swing.JComboBox<String> id_num;
    public javax.swing.JLabel id_rol_sele;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
    
    private void cargarcombo(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre_rol FROM rol");
            while (rs.next()) {

                Rol_combo rc = new Rol_combo();

                rc.setNom_rol(rs.getString(1));
                lr.Agregar_rol(rc);
                combo.addElement(rc.getNom_rol());
//                JOptionPane.showMessageDialog(null, "se realio bien ");

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "se realio mal ");

        }

    }

    public void id_1_rol(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        try {
            Statement st = con.createStatement();

            if (comborool.getSelectedItem().equals("ADMINISTRADOR")) {
                ResultSet rs = st.executeQuery("SELECT id_rol FROM rol WHERE nombre_rol = 'ADMINISTRADOR'");
                while (rs.next()) {

                    Rol_combo rc = new Rol_combo();

                    rc.setNom_id(rs.getString(1));
                    lr.Agregar_rol(rc);
                    combo.addElement(rc.getNom_id());

                }
            }
        } catch (Exception e) {

        }
    }

    public void id_2_rol(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        try {
            Statement st = con.createStatement();

            if (comborool.getSelectedItem().equals("VENDEDOR")) {
                ResultSet rs = st.executeQuery("SELECT id_rol FROM rol WHERE nombre_rol = 'VENDEDOR'");
                while (rs.next()) {

                    Rol_combo rc = new Rol_combo();

                    rc.setNom_rol(rs.getString(1));
                    lr.Agregar_rol(rc);
                    combo.addElement(rc.getNom_rol());

                }
            }
        } catch (Exception e) {

        }
    }
    
    
    
    public void id_3_rol(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        try {
            Statement st = con.createStatement();

           if (comborool.getSelectedItem().equals("GERENTE")) {
                ResultSet rs = st.executeQuery("SELECT id_rol FROM rol WHERE nombre_rol = 'GERENTE'");
                while (rs.next()) {

                    Rol_combo rc = new Rol_combo();

                    rc.setNom_rol(rs.getString(1));
                    lr.Agregar_rol(rc);
                    combo.addElement(rc.getNom_rol());

                }
            }
        } catch (Exception e) {

        }
    }

    public void id_rol_sele(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        try {
            Statement st = con.createStatement();

             

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "se realio mal ");

        }
//         try {
//            Statement st = con.createStatement();
//            ResultSet rs;
//           
//            
//             if (comborool.getSelectedItem().equals("ADMINISTRADOR")) {
//                  rs= st.executeQuery("SELECT id_rol FROM rol WHERE nombre_rol = 'ADMINISTRADOR'");
//                  Rol_combo rc = new Rol_combo();
//                     
//                 rc.setId(rs.getInt(1));
//             
//                 String cov_id= String.valueOf(rc.getId());
//               id_rol_sele.setText(cov_id);
//                  
//             }
//                
////                Rol_combo rc = new Rol_combo();
////                
////                rc.setNom_rol(rs.getString(1));
////                lr.Agregar_rol(rc);
////                combo.addElement(rc.getNom_rol());
//////                JOptionPane.showMessageDialog(null, "se realio bien ");
//
//                
//            
//        } catch (Exception e) {
//
//            JOptionPane.showMessageDialog(null, e + "se realio mal ");
//
//        }
    }
}
