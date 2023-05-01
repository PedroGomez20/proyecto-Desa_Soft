package Vistas;

import Modelo.Conexion;

import Modelo.Listado_rol;
import Modelo.Rol_DAO;

import Modelo.Rol_combo;
import Modelo.Vendedor;
import Modelo.VendedorDAO;
import Modelo.encriptacion;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendedorForm extends javax.swing.JInternalFrame {
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

    public VendedorForm() {

        initComponents();

        id_num.setVisible(false);
//        cargarcombo(comborool);
        sas.cargarcombo(comborool);

    }

    //ESTA VARIABLE (roll) NOS AYUDA A OBTENER EL VALOR DEL COMBO BOX (id_mun) QUE HACE REFERENCIA A LA LLAVE PRIMARIA DEL LA TABLA ROL
    String roll;

    void Agregar() {

        //ESTE IF ES PARA VALIDAR QUE LOS CAMPOS ESTEN LLENOS Y NO SE INSERTEN DATOS VACIOS
        if (TxtDni.getText().isEmpty() || TxtNombres.getText().isEmpty() || TxtTelefono.getText().isEmpty() || TxtUser.getText().isEmpty() || comborool.getSelectedIndex() == 0) {
            //MANDA UN MENSAJE AL USUARIO DE ESE ERROR
            JOptionPane.showMessageDialog(null, "FALTO INGRESAR ALGUN DATO EN LOS CAMPOS");

        } else {

            // AQUI LA VARIABLE roll TOMARA EL VALOR DEL COMBO BOX id_num QUE HACE REFERENCIA AL ID DE LA TABLA ROL
            roll = (String) id_num.getSelectedItem();

            //ES LA CONTRASENIA DEL USUARIO 
            String dni = TxtDni.getText();

            //ESTA VARIABLE aEncriptar NOS AYUDA A PODER OBTENER EL VALOR DE  LA CONTRASENIA DEL EMPLEADO , EL VALOR DE LA VARIABLE dni LO TENDRA LA VARIABLE aEncriptar
            aEnccriptar = dni;

            //ESTA VARIABLE encriptada NOS AYUDA A ENCRIPTAR LA CONTRASENIA DE LA VARIABLE aEncriptar CON METODO Encriptar QUE ESTA EN  MODELO > encriptacion CON LA VARIABLE encrip hacemos el llamado de esa clase.
            encriptada = encrip.Encriptar(aEnccriptar);

            String nom = TxtNombres.getText();
            String tel = TxtTelefono.getText();
            String user = TxtUser.getText();
            String rol = roll;
            Object[] ob = new Object[6];
            ob[0] = encriptada;
            ob[1] = nom;
            ob[2] = tel;
            ob[3] = user;
            ob[4] = rol;
            dao.add(ob);
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
        TxtDni = new javax.swing.JPasswordField();
        desencriptarbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Vendedor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("CONTRASEÑA:");

        jLabel2.setText("NOMBRES:");

        jLabel3.setText("TELEFONO:");

        jLabel4.setText("USUARIO:");

        TxtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombresKeyTyped(evt);
            }
        });

        TxtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTelefonoKeyTyped(evt);
            }
        });

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

        desencriptarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ojo.png"))); // NOI18N
        desencriptarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desencriptarbtnActionPerformed(evt);
            }
        });

        BtnAgregar.setBackground(new java.awt.Color(153, 255, 255));
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar-usuario.png"))); // NOI18N
        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comborool, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(TxtTelefono)
                    .addComponent(TxtDni)
                    .addComponent(TxtUser))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desencriptarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(id_num, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(desencriptarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(TxtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comborool, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(id_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("AGREGAR NUEVO EMPLEADO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //PARA OBTENER EL NOMBRE Y MOSTRALO EN EL MENSAJE DE ABVERTENCIA
        String nom1=TxtNombres.getText();
        int respuesta = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DE AGREGAR AL EMPLEADO:  " + nom1 + " ?", "ALERTA", JOptionPane.YES_NO_OPTION, 2);
        switch (respuesta) {
            case JOptionPane.YES_OPTION:
                Agregar();
                Nuevo();
                break;
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            default:
                break;
        }


    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        Nuevo();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void comboroolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboroolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboroolActionPerformed

    //ESTA ACCION ES CUANDO SE REALIZA ALGUN CAMBIO EN EL CMOBO BOX PARA QUE ESTE ACTUALIZANDO CON LOS METODOS PARA OBTENER EL ID ROL LINEA 551 EN ADELANTE
    private void comboroolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboroolItemStateChanged
        // TODO add your handling code here:

//        ESTE IF HACE REFERENCIA A QUE SI SE OBTIENE ALGUN CAMBIO Y SEA IGUAL EVENTO SELECCIONADO
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            // ESTE IF OBTENEMOS LA DIRECCION QUE SE SELECCIONO EN EL COMBO BOX comborool POR MEDIO DE INDEX
            if (this.comborool.getSelectedIndex() == 3) {
                id_1_rol(id_num);
                // LLAMAMOS AL METODO QUE ESTA EN LA LINEA 551 Y LE MANDAMDO COMO id_num YA QUE ES UN COMBO BOX Y ESTA PIDIENDO ESE OBJECTO

            }
            if (this.comborool.getSelectedIndex() == 2) {

                id_2_rol(id_num);
//               ;

            }
            if (this.comborool.getSelectedIndex() == 1) {
                id_3_rol(id_num);
//                

            }

        }

    }//GEN-LAST:event_comboroolItemStateChanged

    private void desencriptarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desencriptarbtnActionPerformed


    }//GEN-LAST:event_desencriptarbtnActionPerformed

    private void TxtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombresKeyTyped
        // TODO add your handling code here:
          Character ch = evt.getKeyChar();

        //IS LETTER NOS AYUDA A PERMITIR ENTRADAS POR TECLADO SOLAMENTE PERO TENEMOS EL SIGNO ! SI ES DIFERENTE Y SI ES DIFERENTE AL SIMBOLO O A LA ENTRADA ESPACIO
        //SI SE INGRESA COMO UN NUMERO NO LO PERMITE PERO SI PERMITIRA LA ENTRA DE ESAPCIOS Y LETRAS
        if (!Character.isLetter(ch) && ch != KeyEvent.VK_SPACE) {
            //CON LA VARIABLE EVT CONSUME NO PERMITIRA ESCRIBIR EN EL CAMPO
            evt.consume();
        }
    }//GEN-LAST:event_TxtNombresKeyTyped

    private void TxtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelefonoKeyTyped
        // TODO add your handling code here:
        
          Character ch = evt.getKeyChar();

        //AQUI PERIMITE SOLO NUMEROS Y LETRAS NO LO PERIMITE
        if (!Character.isDigit(ch)) {

            evt.consume();
        }
    }//GEN-LAST:event_TxtTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JPasswordField TxtDni;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtUser;
    public javax.swing.JComboBox<String> comborool;
    private javax.swing.JButton desencriptarbtn;
    private javax.swing.JComboBox<String> id_num;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
