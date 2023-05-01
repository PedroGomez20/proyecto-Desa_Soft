package Vistas;

import Modelo.Producto;
import Modelo.ProductoDAO;
import com.sun.glass.events.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoForm extends javax.swing.JInternalFrame {

    ProductoDAO dao = new ProductoDAO();
    Producto pd = new Producto();

    DefaultTableModel modelo = new DefaultTableModel();

    int id;

    public ProductoForm() {

        initComponents();

    }

    void Agregar() {

        if (TxtStock.getText().isEmpty() || TxtNombres.getText().isEmpty() || TxtPrecio.getText().isEmpty()) {
//MANDA UN MENSAJE AL USUARIO DE ESE ERROR
            JOptionPane.showMessageDialog(null, "FALTO INGRESAR ALGUN DATO EN LOS CAMPOS");
        } else {
            String nom = TxtNombres.getText();
            String precio = TxtPrecio.getText();
            String stock = TxtStock.getText();

            Object[] ob = new Object[3];
            ob[0] = nom;
            ob[1] = precio;
            ob[2] = stock;

            dao.add(ob);
        }
    }

    void Nuevo() {
        TxtNombres.setText("");
        TxtPrecio.setText("");
        TxtStock.setText("");
//        CbxEstado.setSelectedIndex(0);
        TxtNombres.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtNombres = new javax.swing.JTextField();
        TxtStock = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Producto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("NOMBRES:");

        jLabel2.setText("PRECIO:");

        jLabel3.setText("STOCK:");

        TxtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombresKeyTyped(evt);
            }
        });

        TxtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtStockKeyTyped(evt);
            }
        });

        TxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioKeyTyped(evt);
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
                    .addComponent(TxtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(TxtPrecio)
                    .addComponent(TxtStock))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        BtnAgregar.setBackground(new java.awt.Color(153, 255, 255));
        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnNuevo.setBackground(new java.awt.Color(153, 255, 153));
        BtnNuevo.setText("LIMPIAR");
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
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed

        //PARA OBTENER EL NOMBRE Y MOSTRALO EN EL MENSAJE DE ABVERTENCIA
        String nom1 = TxtNombres.getText();
        int respuesta = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DE AGREGAR EL PRODUCTO:  " + nom1 + " ?", "ALERTA", JOptionPane.YES_NO_OPTION, 2);
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

    //ESTE METODO O ACCION QUE SE PUEDE OBTENER EN LOS EVENTOS DEL CAMPO NOS AYUDA AQUE NO SE ESCRIBA NUMEROS EN CAMPOS DONDE LO NECESITA COMO ES EN NOMBRES NO PERMITE ESCRIBIR NUMEROS
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

    private void TxtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtStockKeyTyped
        // TODO add your handling code here:

        Character ch = evt.getKeyChar();

        //AQUI PERIMITE SOLO NUMEROS Y LETRAS NO LO PERIMITE
        if (!Character.isDigit(ch)) {

            evt.consume();
        }
    }//GEN-LAST:event_TxtStockKeyTyped

    private void TxtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioKeyTyped
        // TODO add your handling code here:

        Character ch = evt.getKeyChar();

        //AQUI PERIMITE SOLO NUMEROS Y LETRAS NO LO PERIMITE
        if (!Character.isDigit(ch) && Character.isLetter(ch)) {

            evt.consume();
        }
    }//GEN-LAST:event_TxtPrecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
