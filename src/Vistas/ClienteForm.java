package Vistas;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteForm extends javax.swing.JInternalFrame {

    ClienteDAO dao = new ClienteDAO();
    Cliente cl = new Cliente();

    DefaultTableModel modelo = new DefaultTableModel();

    int id;

    public ClienteForm() {

        initComponents();

    }

    void Agregar() {
        if (TxtDni.getText().isEmpty() || TxtNombres.getText().isEmpty() || TxtDireccion.getText().isEmpty() ) {
//MANDA UN MENSAJE AL USUARIO DE ESE ERROR
            JOptionPane.showMessageDialog(null, "FALTO INGRESAR ALGUN DATO EN LOS CAMPOS");
        } else {
            String dni = TxtDni.getText();
            String nom = TxtNombres.getText();
            String dir = TxtDireccion.getText();
            Object[] ob = new Object[3];
            ob[0] = dni;
            ob[1] = nom;
            ob[2] = dir;
            dao.add(ob);
        }
    }

    void Nuevo() {
        TxtDni.setText("");
        TxtNombres.setText("");
        TxtDireccion.setText("");
        TxtDni.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtDni = new javax.swing.JTextField();
        TxtNombres = new javax.swing.JTextField();
        TxtDireccion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Cliente");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("RFC:");

        jLabel2.setText("NOMBRES:");

        jLabel3.setText("DIRECCION:");

        TxtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDniKeyTyped(evt);
            }
        });

        TxtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombresKeyTyped(evt);
            }
        });

        TxtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDireccionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtDni)
                    .addComponent(TxtNombres)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnAgregar.setBackground(new java.awt.Color(204, 255, 255));
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar-usuario.png"))); // NOI18N
        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnNuevo.setBackground(new java.awt.Color(204, 255, 204));
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/limpio.png"))); // NOI18N
        BtnNuevo.setText("LIMPIAR");
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
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed

        //PARA OBTENER EL NOMBRE Y MOSTRALO EN EL MENSAJE DE ABVERTENCIA
        String nom1 = TxtNombres.getText();
        int respuesta = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DE AGREGAR AL CLIENTE:  " + nom1 + " ?", "ALERTA", JOptionPane.YES_NO_OPTION, 2);
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

    private void TxtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDniKeyTyped
        // TODO add your handling code here:
        
        Character ch = evt.getKeyChar();

        //AQUI PERIMITE SOLO NUMEROS Y LETRAS NO LO PERIMITE
        if (!Character.isDigit(ch) && !Character.isLetter(ch)) {

            evt.consume();
        }
    }//GEN-LAST:event_TxtDniKeyTyped

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

    private void TxtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDireccionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtDni;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
