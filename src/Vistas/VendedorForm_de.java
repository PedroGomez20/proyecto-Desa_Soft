package Vistas;

import Modelo.Conexion;

import Modelo.Listado_rol;
import Modelo.Rol_DAO;

import Modelo.Rol_combo;
import Modelo.Vendedor;
import Modelo.VendedorDAO;
import Modelo.encriptacion;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendedorForm_de extends javax.swing.JInternalFrame {
// Rol_DAO sas = new Rol_DAO();

    Conexion cn = new Conexion();
    Connection con = cn.Conectar();//////23

    VendedorDAO dao = new VendedorDAO();
    Vendedor vd = new Vendedor();
    encriptacion encrip = new encriptacion();
    Rol_DAO sas = new Rol_DAO();
    DefaultTableModel modelo = new DefaultTableModel();

    int id;
    String encriptada = "";
    String aEnccriptar = "";

    String sectdec, dese;

    public VendedorForm_de() {

        initComponents();

//        cargarcombo(comborool);
//        listar();
        sas.cargarcombo(comborool);

        if (this.OPCION.getSelectedIndex() == 0) {
            dao.busqeuda(0, null);
            this.buscar.doClick();
        }

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
            ob[4] = lista.get(i).getUser();
            ob[5] = lista.get(i).getId_rol();
            modelo.addRow(ob);
        }
        TablaV.setModel(modelo);

    }

    //ESTA VARIABLE (roll) NOS AYUDA A OBTENER EL VALOR DEL COMBO BOX (id_mun) QUE HACE REFERENCIA A LA LLAVE PRIMARIA DEL LA TABLA ROL
    String roll;

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
        TxtDni.requestFocus();
        comborool.setSelectedIndex(0);
    }

    void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
//
//    public void rol_nom() {
//        String ro = comborool.getSelectedItem().toString();
//        Object[] ob = new Object[4];
//        ob[0] = ro;
//
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNombres = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        TxtUser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comborool = new javax.swing.JComboBox<>();
        id_num = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TxtDni = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        BtnEliminar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaV = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        OPCION = new javax.swing.JComboBox<>();
        valor = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("BUSQUEDA:"));
        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Vendedor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS PERSONALES:"));

        jLabel1.setText("CONTRASEÑA:");

        jLabel2.setText("NOMBRES:");

        jLabel3.setText("TELEFONO:");

        jLabel4.setText("USUARIO:");

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

        BtnEliminar.setBackground(new java.awt.Color(153, 255, 255));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/borrar-usuario.png"))); // NOI18N
        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnNuevo.setBackground(new java.awt.Color(153, 255, 153));
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/limpio.png"))); // NOI18N
        BtnNuevo.setText("NUEVO");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(TxtTelefono)
                            .addComponent(TxtDni)
                            .addComponent(TxtUser))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comborool, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_num, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comborool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(id_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(40, 40, 40))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS:"));

        TablaV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRES", "TELEFONO", "USUARIO", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSQUEDA:"));

        OPCION.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID EMPLEADO", "NOMBRE" }));
        OPCION.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                OPCIONItemStateChanged(evt);
            }
        });

        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OPCION, 0, 1, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscar)
                .addGap(259, 259, 259))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OPCION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

            //ASIGNACION DE VALOR A LA VARIABLE dni
            String dni = TablaV.getValueAt(fila, 1).toString();
            //ESTA VARIABLE sectdec (secreto-desencriptar) nos ayudara a obtener el valor encriptado de la contrasenia del empleado
            sectdec = dni;

            //LA VARIABLE dese NOS AYUDARA A DESENCRIPTAR LA CONTRASENIA PARA QUE EL EMPLEADO NO VEA ALGO DIFERENTE EN SU CONTRASENIA Y VEA QUE ES LA MISMA.
            //PODEMOS HACER LA DESENCRIPTACION CON EL METODO Desencriptar QUE ES EN LA CLASE encriptacion CON LA VARIABLE encrip Y LE MANDAMOS LA VARIABLE sectdec YA QUE AHI ESTA LA CONTRASENIA
            dese = encrip.Desencriptar(sectdec);

            String nom = TablaV.getValueAt(fila, 2).toString();
            String tel = TablaV.getValueAt(fila, 3).toString();
            String user = TablaV.getValueAt(fila, 4).toString();
            String rol = TablaV.getValueAt(fila, 5).toString();
            TxtDni.setText(dese);
            TxtNombres.setText(nom);
            TxtTelefono.setText(tel);
            TxtUser.setText(user);
            comborool.setSelectedItem(rol);
        }
    }//GEN-LAST:event_TablaVMouseClicked

    private void comboroolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboroolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboroolActionPerformed

    //ESTA ACCION ES CUANDO SE REALIZA ALGUN CAMBIO EN EL CMOBO BOX PARA QUE ESTE ACTUALIZANDO CON LOS METODOS PARA OBTENER EL ID ROL LINEA 551 EN ADELANTE
    private void comboroolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboroolItemStateChanged
        // TODO add your handling code here:

//        ESTE IF HACE REFERENCIA A QUE SI SE OBTIENE ALGUN CAMBIO Y SEA IGUAL EVENTO SELECCIONADO
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            // ESTE IF OBTENEMOS LA DIRECCION QUE SE SELECCIONO EN EL COMBO BOX comborool POR MEDIO DE INDEX
            if (this.comborool.getSelectedIndex() == 0) {
                id_1_rol(id_num);
                // LLAMAMOS AL METODO QUE ESTA EN LA LINEA 551 Y LE MANDAMDO COMO id_num YA QUE ES UN COMBO BOX Y ESTA PIDIENDO ESE OBJECTO

            }
            if (this.comborool.getSelectedIndex() == 1) {

                id_2_rol(id_num);
//               ;

            }
            if (this.comborool.getSelectedIndex() == 2) {
                id_3_rol(id_num);
//                

            }

        }

    }//GEN-LAST:event_comboroolItemStateChanged


    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
LimpiarTabla();
        int opcions = OPCION.getSelectedIndex();
        String val = valor.getText();
//        dao.busqeuda(opcions, val);

        List<Vendedor> lista = dao.busqeuda(opcions, val);
        modelo = (DefaultTableModel) TablaV.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getDni();
            ob[2] = lista.get(i).getNom();
            ob[3] = lista.get(i).getTel();
            ob[4] = lista.get(i).getUser();
            ob[5] = lista.get(i).getId_rol();
            modelo.addRow(ob);
        }
        TablaV.setModel(modelo);

        valor.setText("");

    }//GEN-LAST:event_buscarActionPerformed

    private void OPCIONItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_OPCIONItemStateChanged
        // TODO add your handling code here:

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            // ESTE IF OBTENEMOS LA DIRECCION QUE SE SELECCIONO EN EL COMBO BOX comborool POR MEDIO DE INDEX
            if (this.OPCION.getSelectedIndex() == 0) {

                this.buscar.doClick();
            }
            if (this.OPCION.getSelectedIndex() == 1) {

                LimpiarTabla();

            }
            if (this.OPCION.getSelectedIndex() == 2) {
                LimpiarTabla();

            }

        }

    }//GEN-LAST:event_OPCIONItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> OPCION;
    private javax.swing.JTable TablaV;
    private javax.swing.JPasswordField TxtDni;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtUser;
    private javax.swing.JButton buscar;
    public javax.swing.JComboBox<String> comborool;
    private javax.swing.JComboBox<String> id_num;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables

    public void id_1_rol(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        //AQUI HACEMOS UNA SENTENCIA SQL PARA LA OBTENCION DEL ID ROL DE LA TABLA ROL
        try {
            Statement st = con.createStatement();

            //AQUI HACEMOS COMPARACIONES SI EL USUARIO SELECCIONA EN EL COMBO BOX comborool alguna de las 3 opciones debera hacer una consulta sql con dicha opcion que seleccione y obtendra el ID DE ESE ROL
            if (comborool.getSelectedItem().equals("ADMINISTRADOR")) {
                ResultSet rs = st.executeQuery("SELECT id_rol FROM rol WHERE nombre_rol ='ADMINISTRADOR'");
                while (rs.next()) {
                    //Rol_combo ES UNA CLASE DONDE ESTA LOS SET AND GET
                    Rol_combo rc = new Rol_combo();

                    rc.setNom_id(rs.getString(1));
                    lr.Agregar_rol(rc);
                    combo.addElement(rc.getNom_id());

                }
            }
        } catch (Exception e) {

        }
    }
// ES LO MISMO QUE EL ANTERIOR PERO SOLO CAMBIA EL TIPO DE SELECCION QUE HACE EL USUARIO VENDEDOR, ADMIN, GERENTE

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

}
