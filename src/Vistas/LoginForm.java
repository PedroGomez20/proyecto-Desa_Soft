package Vistas;

import Modelo.EntidadVendedor;
import Modelo.VendedorDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    VendedorDAO vdao = new VendedorDAO();
    EntidadVendedor ev = new EntidadVendedor();
    int a;
    
    int aa;

    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);

        //DATOS TEMPORALES
        TxtUser.setText("emp01");
        TxtPass.setText("12345678");
    }
    
    
    
    
    
    public void Validar() {
        String dni = TxtPass.getText();
        String user = TxtUser.getText();
//        int id_rol =Integer.parseInt(TxtUser1.getText());
        String id_rol = TxtUser1.getText();
//     String rol = TxtUser1.getText();
//     
//     int id_rol= Integer.parseInt(rol);
//     ev.setId_rol(id_rol);

        if (id_rol.equals("1")) {
            a = 1;
        } else if (TxtUser1.getText().equals("2")) {
            a = 2;
        }
        JOptionPane.showMessageDialog(this, a + "A3333333");
        
        aa=a;
        if (TxtUser.getText().equals("") || TxtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS EN LAs CAJAS DE TEXTO");
            TxtUser.requestFocus();
        } else {
            ev = vdao.ValidarVendedor(dni, user, id_rol);
            if (ev.getUser() != null && ev.getDni() != null && ev.getId_rol() != null) {

//                if ("1".equals(id_rol)) {
//
//                    a = false;
//                } else if ("2".equals(id_rol)) {
//                    a = true;
//
//                }
                Principal p = new Principal();
                p.getValor(a);
                int vals = p.getValor();
                p.setVisible(true);
JOptionPane.showMessageDialog(this, vals + "finalA3333333");
                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS VALIDOS");

                TxtUser.requestFocus();

         
            }
             
           
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
        BtnIngresar = new javax.swing.JButton();
        combo1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        m = new javax.swing.JLabel();
        TxtUser1 = new javax.swing.JTextField();

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

        BtnIngresar.setText("INGRESAR");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "VENDEDOR" }));
        combo1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
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
                        .addGap(10, 10, 10)
                        .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(TxtUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtPass)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                .addComponent(BtnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/desbloquear.png"))); // NOI18N

        m.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(m, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(TxtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(m)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        Validar();
        JOptionPane.showMessageDialog(this, a + "Aasaswqqqqqa");

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JPasswordField TxtPass;
    private javax.swing.JTextField TxtUser;
    private javax.swing.JTextField TxtUser1;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel m;
    // End of variables declaration//GEN-END:variables
}
