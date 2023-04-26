package Vistas;

import Modelo.Conexion;
import Modelo.EntidadVendedor;
import Modelo.Listado_rol;
import Modelo.Rol_combo;
import Modelo.VendedorDAO;
import Modelo.encriptacion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Modelo.Rol_DAO;
import java.awt.event.ItemEvent;

public class LoginForm extends javax.swing.JFrame {

    Rol_DAO rdao = new Rol_DAO();
    VendedorDAO vdao = new VendedorDAO();
    EntidadVendedor ev = new EntidadVendedor();
    String a;
    String id_rol;

    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        //LLENAMOS EL COMBO BOX CON DATOS DE LA BASE DE DATOS
        rdao.cargarcombo(combo1);
        //OCULTAMOS EL COMBO BOX PARA QUE EL USUARIO NO SE CONFUNDA EN ESE COMBO BOX DEL ID ROL QUE ES AUTOMATICO ESE NUMERO
        numero_id_rol.setVisible(false);
        
        //DATOS TEMPORALES
//        TxtUser.setText("emp01");
//        TxtPass.setText("12345678");
        TxtUser.setText("root");
        TxtPass.setText("root");
    }

    Conexion cn = new Conexion();
    Connection con = cn.Conectar();//////23
    String encriptada = "";
    String aEnccriptar = "";

    //LLAMAMOS A LA CLASE encriptacion PARA OBTENER LOS METODOS ADECUADOS PARA QUE SE ENCRIPTE LA CONTRASENA ESCRITA POR EL EMPLEADO PARA INICIAR SESION
    encriptacion encrip = new encriptacion();

    public void Validar() {

        //OBTENEMOS EL VALOR ESCRITO Y SE GUARDA EN dni
        String dni = TxtPass.getText();
        //EL VALOR DE dni PASARA A LA VARIABLE aEnccriptar 
        aEnccriptar = dni;
        //CON LA VARIABLE aEnccriptar TOMARA EL VALOR DE LA ENCRIPTACION CON EL METODO Encriptar DE LA CLASE QUE LLAMAMOS Y LE MANDAMOS COMO PARAMETRO LA VARIABLE aEnccriptar
        encriptada = encrip.Encriptar(aEnccriptar);
        //OBTENEMOS EL VALOR DE USER
        String user = TxtUser.getText();
        //EN EL VALOR DE COMBO BOX OCULTO LO TOMARA LA VARIABLE id_rol YA QUE PARA HACER LA VALIDACION SE NECESITA UN NUMERO QUE CORRESPONDE AL ID ROL
        id_rol = (String) numero_id_rol.getSelectedItem();

        if (TxtUser.getText().equals("") || TxtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS EN LAs CAJAS DE TEXTO");
            TxtUser.requestFocus();
        } else {

            ev = vdao.ValidarVendedor(encriptada, user, id_rol);
            if (ev.getUser() != null && ev.getDni() != null && ev.getId_rol() != null) {

                //ESTOS IF ANINADOS HACE REFERENCIA A QUE OPCION SELECCIONO EL USUARIO EN CUESTION DE ROL
                //LA OPCION 0 ES ADMIN , 1 ES VENDEDOR, 2 ES GENERENTE
                //Y CON ESTO PODEMOS OCULTAR LAS OPCIONES QUE VA TENER CADA ROL
                if (combo1.getSelectedIndex() == 0) {
                    //LLAMAMOS LA CLASE Principal 
                    Principal m = new Principal();
                    //AQUI MANDAMOS EL VALOR USER PARA QUE SE MUESTRE EN LA VENTANA PRINCIPAL
                    m.usuario(TxtUser.getText());
                    //AQUI MANDAMOS EL VALOR DEL COMBO BOX A LA VENTANA PRINCIPAL
                    m.usuario_rol((String) combo1.getSelectedItem());
                    m.show();

                } else if (combo1.getSelectedIndex() == 1) {

                    //VENDEDOR
                    Principal m = new Principal();
                    //PARA EL ROL DE VENDEDOR ESTARAN OCULTOS ALGUNAS OPCIONES COMO SON MOD Y ELIMINAR CUALQUIER MENU SEGUN SEA EL CASO
                    m.de_producto.setVisible(false);
                     m.up_producto.setVisible(false);
                    m.vendedor.setVisible(false);
                     m.de_cliente.setVisible(false);
                      m.up_cliente.setVisible(false);
                    
                    //AQUI MANDAMOS EL VALOR USER PARA QUE SE MUESTRE EN LA VENTANA PRINCIPAL
                    m.usuario(TxtUser.getText());
                    //AQUI MANDAMOS EL VALOR DEL COMBO BOX A LA VENTANA PRINCIPAL
                    m.usuario_rol((String) combo1.getSelectedItem());
                    m.show();

                } else if (combo1.getSelectedIndex() == 2) {

                    Principal m = new Principal();
                    m.ventas.setVisible(false);
                    
                    m.usuario(TxtUser.getText());
                    m.usuario_rol((String) combo1.getSelectedItem());
                    m.show();
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS VALIDOS");

                TxtUser.requestFocus();

            }

        }

    }

    //AQUI SON CONSULTAS SQL PARA LLENAR EL COMBO BOX OCULTO QUE ESTA EL ID ROL
    public void id_1_rol(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        //AQUI HACEMOS UNA SENTENCIA SQL PARA LA OBTENCION DEL ID ROL DE LA TABLA ROL
        try {
            Statement st = con.createStatement();

            //AQUI HACEMOS COMPARACIONES SI EL USUARIO SELECCIONA EN EL COMBO BOX comborool alguna de las 3 opciones debera hacer una consulta sql con dicha opcion que seleccione y obtendra el ID DE ESE ROL
            if (combo1.getSelectedItem().equals("ADMINISTRADOR")) {
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

    public void id_2_rol(JComboBox c) {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        Listado_rol lr = new Listado_rol();

        try {
            Statement st = con.createStatement();

            if (combo1.getSelectedItem().equals("VENDEDOR")) {
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

            if (combo1.getSelectedItem().equals("GERENTE")) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtPass = new javax.swing.JPasswordField();
        combo1 = new javax.swing.JComboBox<>();
        BtnIngresar = new javax.swing.JButton();
        numero_id_rol = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("USUARIO:");

        TxtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtUserKeyPressed(evt);
            }
        });

        jLabel2.setText("CONTRASEÑA:");

        TxtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPassKeyPressed(evt);
            }
        });

        combo1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        combo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo1ItemStateChanged(evt);
            }
        });
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        BtnIngresar.setText("INGRESAR");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BtnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(TxtUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtPass, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(numero_id_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(BtnIngresar)
                .addGap(5, 5, 5)
                .addComponent(numero_id_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/desbloquear.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel3)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
//if (TxtUser1.getText().equals("1")) {
//            a = 1;
//        } else if (TxtUser1.getText().equals("2")) {
//            a = 2;
//        }
//        ocultar();

        Validar();


    }//GEN-LAST:event_BtnIngresarActionPerformed

    private void TxtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUserKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            BtnIngresar.doClick();
        }
    }//GEN-LAST:event_TxtUserKeyPressed

    private void TxtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPassKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            BtnIngresar.doClick();
        }
    }//GEN-LAST:event_TxtPassKeyPressed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo1ActionPerformed

    private void combo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo1ItemStateChanged
        // TODO add your handling code here:
//AQUI ES CUANDO SE REALIZA UN CAMBIO EN EL COMBO BOX NOMBRE DEL ROL DE IGUAL FORMA SE REALIZA LA CONSULTA SQL SEGUN SEA LA OPCION
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            // ESTE IF OBTENEMOS LA DIRECCION QUE SE SELECCIONO EN EL COMBO BOX comborool POR MEDIO DE INDEX
            //0 ES ADMIN, 1 VENDEDOR, 2 GERENTE
            if (this.combo1.getSelectedIndex() == 0) {
                // LLAMAMOS AL METODO QUE ESTA EN LA LINEA 551 Y LE MANDAMDO COMO id_num YA QUE ES UN COMBO BOX Y ESTA PIDIENDO ESE OBJECTO
                id_1_rol(numero_id_rol);
                

            }
            if (this.combo1.getSelectedIndex() == 1) {

                id_2_rol(numero_id_rol);
//               ;

            }
            if (this.combo1.getSelectedIndex() == 2) {
                id_3_rol(numero_id_rol);
//                

            }

        }
    }//GEN-LAST:event_combo1ItemStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JPasswordField TxtPass;
    private javax.swing.JTextField TxtUser;
    public static javax.swing.JComboBox<String> combo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> numero_id_rol;
    // End of variables declaration//GEN-END:variables
}
