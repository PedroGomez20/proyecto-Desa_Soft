package Vistas;

import Modelo.Conexion;
import Modelo.EntidadVendedor;
import Modelo.Listado_rol;
import Modelo.Rol_combo;
import Modelo.VendedorDAO;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {
    
    VendedorDAO vdao = new VendedorDAO();
    EntidadVendedor ev = new EntidadVendedor();
    String a;
    
    int aa;
    String id_rol;
    
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        cargarcombo(combo1);
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
    VendedorDAO dao =new VendedorDAO();
    
    public LoginForm(String id_rol) {
        this.id_rol = id_rol;
    }
    
    public String getId_rol() {
        return id_rol;
    }
    
    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }
    
    public void Validar() {
        String dni = TxtPass.getText();
      aEnccriptar=dni;
      encriptada= dao.Encriptar(aEnccriptar);
        
        String user = TxtUser.getText();
//        int id_rol =Integer.parseInt(TxtUser1.getText());

//     String rol = TxtUser1.getText();
//     
//     int id_rol= Integer.parseInt(rol);
//     ev.setId_rol(id_rol);
//        if (id_rol.equals("1")) {
//            a = 1;
//        } else if (TxtUser1.getText().equals("2")) {
//            a = 2;
//        }
//        JOptionPane.showMessageDialog(this, a + "A3333333");
//        
//        aa=a;
        if (combo1.getSelectedItem().equals("ADMINISTRADOR")) {
            a = "1";
            
        } else if (combo1.getSelectedItem().equals("VENDEDOR")) {
            a = "2";
            
        } else if (combo1.getSelectedItem().equals("GERENTE")) {
            a = "5";
            
        }
        
        String id_rol = a;
        if (TxtUser.getText().equals("") || TxtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS EN LAs CAJAS DE TEXTO");
            TxtUser.requestFocus();
        } else {
            
            ev = vdao.ValidarVendedor(encriptada, user, id_rol);
            if (ev.getUser() != null && ev.getDni() != null && ev.getId_rol() != null) {

//                if ("1".equals(id_rol)) {
//
//                    a = false;
//                } else if ("2".equals(id_rol)) {
//                    a = true;
//
//                }
                if (combo1.getSelectedItem().equals("ADMINISTRADOR")) {
                    
                    Principal m = new Principal();
//                    m.jMenu2.setVisible(false);
                    

                    m.usuario(TxtUser.getText());
                    
                    
                    m.usuario_rol((String) combo1.getSelectedItem());
                    m.show();
                    ClienteForm cfa = new ClienteForm();
                    cfa.setVass(true);
//                    cfa.ocultar(true);
                    cfa.show();
                    
                    
                } else if (combo1.getSelectedItem().equals("VENDEDOR")) {
                    
                    Principal m = new Principal();

//                    m.jMenu3.setVisible(false);
                    m.jMenuItem6.setVisible(false);
                     m.usuario(TxtUser.getText());
                      m.usuario_rol((String) combo1.getSelectedItem());
                    m.show();

                    //ocualtar el boton 
                    ClienteForm cfa = new ClienteForm();
                    cfa.setVass(false);
                    cfa.show();
                    
                } else if (combo1.getSelectedItem().equals("GERENTE")) {
                    
                    Principal m = new Principal();
                     m.usuario(TxtUser.getText());
                      m.usuario_rol((String) combo1.getSelectedItem());
                    m.show();
                    
                }

//              
                dispose();
                
            } else {
                JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS VALIDOS");
                
                TxtUser.requestFocus();
                
            }
            
        }
        
    }

//    void ocultar() {
//        if (combo1.getSelectedItem().equals("ADMIN")) {
//            String a = "1";
//
//            Principal m = new Principal();
//            m.show();
//
//        } else if (combo1.getSelectedItem().equals("VENDEDOR")) {
//            String a = "2";
//            Principal m = new Principal();
//
//            m.jMenu2.setVisible(false);
//            m.jMenu4.setVisible(false);
//            m.show();
//        }
//
//    }
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtPass)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(27, 27, 27))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/desbloquear.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JPasswordField TxtPass;
    private javax.swing.JTextField TxtUser;
    public static javax.swing.JComboBox<String> combo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
