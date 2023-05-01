package Vistas;

import Modelo.Producto;
import Modelo.ProductoDAO;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoForm_UP extends javax.swing.JInternalFrame {

    ProductoDAO dao = new ProductoDAO();
    Producto pd = new Producto();

    DefaultTableModel modelo = new DefaultTableModel();

    int id;

    public ProductoForm_UP() {

        initComponents();
//        listar();

        if (this.OPCION.getSelectedIndex() == 0) {
            dao.busqueda(0, null);
            this.buscar.doClick();
        }
    }

    void listar() {
        List<Producto> lista = dao.listar();
        modelo = (DefaultTableModel) TablaP.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNom();
            ob[2] = lista.get(i).getPrecio();
            ob[3] = lista.get(i).getStock();
//            ob[4] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        TablaP.setModel(modelo);
    }

    void Actualizar() {
        int fila = TablaP.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA");
        } else if (TxtStock.getText().isEmpty() || TxtNombres.getText().isEmpty() || TxtPrecio.getText().isEmpty()) {
//MANDA UN MENSAJE AL USUARIO DE ESE ERROR
            JOptionPane.showMessageDialog(null, "FALTO INGRESAR ALGUN DATO EN LOS CAMPOS");
        } else {
            {
                String nom = TxtNombres.getText();
                String precio = TxtPrecio.getText();
                String stock = TxtStock.getText();
//            String es = CbxEstado.getSelectedItem().toString();
                Object[] obj = new Object[4];
                obj[0] = nom;
                obj[1] = precio;
                obj[2] = stock;
//            obj[3] = es;
                obj[3] = id;
                dao.actualizar(obj);
            }
        }
    }

    void Nuevo() {
        TxtNombres.setText("");
        TxtPrecio.setText("");
        TxtStock.setText("");
//        CbxEstado.setSelectedIndex(0);
        TxtNombres.requestFocus();
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
        TxtNombres = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        TxtStock = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BtnActualizar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        OPCION = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JButton();
        valor = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Producto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL PRODUCTO:"));

        jLabel1.setText("NOMBRES:");

        jLabel2.setText("PRECIO:");

        jLabel3.setText("STOCK:");

        TxtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombresKeyTyped(evt);
            }
        });

        TxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioKeyTyped(evt);
            }
        });

        TxtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtStockKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(TxtNombres)
                    .addComponent(TxtPrecio))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS:"));

        TablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRES", "PRECIO", "STOCK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnActualizar.setBackground(new java.awt.Color(153, 255, 255));
        BtnActualizar.setText("ACTUALIZAR");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
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
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSQUEDA:"));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OPCION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OPCION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿ESTAS SEGURO DE MODIFICAR EL PRODUCTO: " + nom + " ? ", "CONFIRMACION", JOptionPane.YES_NO_OPTION, 3);
        switch (respuesta) {
            case JOptionPane.YES_OPTION:
                Actualizar();
                LimpiarTabla();
                listar();
                Nuevo();
                break;
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            default:
                break;
        }
    }//GEN-LAST:event_BtnActualizarActionPerformed
    String nom;
    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        Nuevo();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void TablaPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPMouseClicked
        int fila = TablaP.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA");
        } else {
            id = Integer.parseInt(TablaP.getValueAt(fila, 0).toString());
            nom = TablaP.getValueAt(fila, 1).toString();
            double precio = Double.parseDouble(TablaP.getValueAt(fila, 2).toString());
            int stock = Integer.parseInt(TablaP.getValueAt(fila, 3).toString());
//            String es = TablaP.getValueAt(fila, 4).toString();
            TxtNombres.setText(nom);
            TxtPrecio.setText("" + precio);
            TxtStock.setText("" + stock);
//            CbxEstado.setSelectedItem(es);
        }
    }//GEN-LAST:event_TablaPMouseClicked

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

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        int opcions = OPCION.getSelectedIndex();
        String val = valor.getText();
        //        dao.busqeuda(opcions, val);

        List<Producto> lista = dao.busqueda(opcions, val);
        modelo = (DefaultTableModel) TablaP.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNom();
            ob[2] = lista.get(i).getPrecio();
            ob[3] = lista.get(i).getStock();
            //            ob[4] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        TablaP.setModel(modelo);

        valor.setText("");
    }//GEN-LAST:event_buscarActionPerformed

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

    private void TxtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioKeyTyped
        // TODO add your handling code here:
        
         Character ch = evt.getKeyChar();

        //AQUI PERIMITE SOLO NUMEROS Y LETRAS NO LO PERIMITE
        if (!Character.isDigit(ch) && Character.isLetter(ch)) {

            evt.consume();
        }
    }//GEN-LAST:event_TxtPrecioKeyTyped

    private void TxtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtStockKeyTyped
        // TODO add your handling code here:
        Character ch = evt.getKeyChar();

        //AQUI PERIMITE SOLO NUMEROS Y LETRAS NO LO PERIMITE
        if (!Character.isDigit(ch)) {

            evt.consume();
        }
    }//GEN-LAST:event_TxtStockKeyTyped

                              
                                


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> OPCION;
    private javax.swing.JTable TablaP;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtStock;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
