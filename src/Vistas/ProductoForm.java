package Vistas;

import Modelo.Producto;
import Modelo.ProductoDAO;
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
        listar();
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

    void Agregar() {
        String nom = TxtNombres.getText();
        String precio = TxtPrecio.getText();
        String stock = TxtStock.getText();
//        String es = CbxEstado.getSelectedItem().toString();
        Object[] ob = new Object[3];
        ob[0] = nom;
        ob[1] = precio;
        ob[2] = stock;
//        ob[3] = es;
        dao.add(ob);
    }

    void Actualizar() {
        int fila = TablaP.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA");
        } else {
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

    void Eliminar() {
        int fila = TablaP.getSelectedRow();
        int ids = Integer.parseInt(TablaP.getValueAt(fila, 0).toString());
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminar(ids);
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
        BtnActualizar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaP = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Producto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("NOMBRES:");

        jLabel2.setText("PRECIO:");

        jLabel3.setText("STOCK:");

        BtnActualizar.setText("ACTUALIZAR");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
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
                    .addComponent(TxtNombres)
                    .addComponent(TxtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(TxtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void TablaPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPMouseClicked
        int fila = TablaP.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA");
        } else {
            id = Integer.parseInt(TablaP.getValueAt(fila, 0).toString());
            String nom = TablaP.getValueAt(fila, 1).toString();
            double precio = Double.parseDouble(TablaP.getValueAt(fila, 2).toString());
            int stock = Integer.parseInt(TablaP.getValueAt(fila, 3).toString());
//            String es = TablaP.getValueAt(fila, 4).toString();
            TxtNombres.setText(nom);
            TxtPrecio.setText("" + precio);
            TxtStock.setText("" + stock);
//            CbxEstado.setSelectedItem(es);
        }
    }//GEN-LAST:event_TablaPMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    public javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTable TablaP;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
