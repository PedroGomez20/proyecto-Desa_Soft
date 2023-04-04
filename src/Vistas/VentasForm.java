package Vistas;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.DetalleVentas;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Ventas;
import Modelo.VentasDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentasForm extends javax.swing.JInternalFrame {

    VentasDAO vdao = new VentasDAO();
    ClienteDAO cdao = new ClienteDAO();
    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    Ventas v = new Ventas();
    DetalleVentas dv = new DetalleVentas();
    Cliente cliente = new Cliente();

    int idp, cant, stock;
    double tpagar, pre;

    DefaultTableModel modelo = new DefaultTableModel();

    public VentasForm() {
        initComponents();
        TxtFecha.setText(fechaActual());
    }

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
        return formatoFecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtSerie = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TxtCodCliente = new javax.swing.JTextField();
        TxtCodProduc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BtnBuscarC = new javax.swing.JButton();
        BtnBuscarP = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TxtProducto = new javax.swing.JTextField();
        TxtCliente = new javax.swing.JTextField();
        TxtStock = new javax.swing.JTextField();
        TxtVende = new javax.swing.JTextField();
        SpnCantidad = new javax.swing.JSpinner();
        TxtFecha = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        TxtTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        BtnGenerar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sistema de Ventas");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("PUNTO DE VENTA \"LA ESQUINITA\"");

        jLabel2.setText("VENTA DE PRODUCTOS DE ABARROTES");

        jLabel3.setText("TEL: 963 184 83 40");

        jLabel4.setText("NO. SERIE:");

        TxtSerie.setEditable(false);
        TxtSerie.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(235, 235, 235))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("COD. CLIENTE:");

        jLabel6.setText("COD. PRODUC:");

        TxtPrecio.setEditable(false);
        TxtPrecio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtPrecio.setForeground(new java.awt.Color(0, 0, 204));

        jLabel7.setText("PRECIO:");

        jLabel8.setText("CANTIDAD:");

        BtnBuscarC.setText("BUSCAR");
        BtnBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarCActionPerformed(evt);
            }
        });

        BtnBuscarP.setText("BUSCAR");
        BtnBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarPActionPerformed(evt);
            }
        });

        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        jLabel9.setText("CLIENTE:");

        jLabel10.setText("PRODUC:");

        jLabel11.setText("STOCK:");

        jLabel12.setText("VENDE:");

        TxtProducto.setEditable(false);
        TxtProducto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtProducto.setForeground(new java.awt.Color(0, 0, 204));

        TxtCliente.setEditable(false);
        TxtCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtCliente.setForeground(new java.awt.Color(0, 0, 204));

        TxtStock.setEditable(false);
        TxtStock.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtStock.setForeground(new java.awt.Color(0, 0, 204));

        TxtVende.setEditable(false);
        TxtVende.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        TxtFecha.setEditable(false);
        TxtFecha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtPrecio)
                    .addComponent(TxtCodProduc)
                    .addComponent(TxtCodCliente)
                    .addComponent(SpnCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnBuscarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnBuscarC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtCliente)
                    .addComponent(TxtProducto)
                    .addComponent(TxtStock)
                    .addComponent(TxtVende, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnBuscarC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(TxtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(TxtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCodProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(BtnBuscarP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addComponent(TxtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(TxtVende, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRO", "COD", "PRODUCTO", "CANTIDAD", "PRE C/U", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaDetalle);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TxtTotal.setEditable(false);
        TxtTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel13.setText("TOTAL A PAGAR:");

        BtnGenerar.setText("GENERAR VENTA");
        BtnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerarActionPerformed(evt);
            }
        });

        BtnCancelar.setText("CANCELAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(BtnCancelar)
                .addGap(18, 18, 18)
                .addComponent(BtnGenerar)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(BtnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarCActionPerformed
        buscarCliente();
    }//GEN-LAST:event_BtnBuscarCActionPerformed

    private void BtnBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarPActionPerformed
        buscarProducto();
    }//GEN-LAST:event_BtnBuscarPActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        agregarProducto();
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerarActionPerformed
        guardarVenta();
        //guardarDetalle();
    }//GEN-LAST:event_BtnGenerarActionPerformed

    void buscarCliente() {
        int r;
        String cod = TxtCodCliente.getText();
        if (TxtCodCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR COD CLIENTE");
        } else {
            cliente = cdao.listarID(cod);
            if (cliente.getDni() != null) {
                TxtCliente.setText(cliente.getNom());
                TxtCodProduc.requestFocus();
            } else {
                r = JOptionPane.showConfirmDialog(this, "CLIENTE NO REGISTRADO, ¿DESEA REGISTRAR?");
                if (r == 0) {
                    ClienteForm cf = new ClienteForm();
                    Principal.VentanaPrincipal.add(cf);
                    cf.setVisible(true);
                }
            }
        }
    }

    void buscarProducto() {
        String id2 = TxtCodProduc.getText();
        if (TxtCodProduc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR COD PRODUCTO");
        } else {
            int id = Integer.parseInt(TxtCodProduc.getText());
            p = pdao.listarID(id);
            if (p.getId() != 0) {
                TxtProducto.setText(p.getNom());
                TxtPrecio.setText("" + p.getPrecio());
                TxtStock.setText("" + p.getStock());
            } else {
                JOptionPane.showMessageDialog(this, "PRODUCTO NO REGISTRADO");
                TxtCodProduc.requestFocus();
            }
        }
    }

    void calcularTotal() {
        tpagar = 0;
        for (int i = 0; i < TablaDetalle.getRowCount(); i++) {
            cant = Integer.parseInt(TablaDetalle.getValueAt(i, 3).toString());
            pre = Double.parseDouble(TablaDetalle.getValueAt(i, 4).toString());
            tpagar = tpagar + (cant * pre);
        }
        TxtTotal.setText("$" + tpagar + "0");
    }

    void agregarProducto() {
        double total;
        int item = 0;
        modelo = (DefaultTableModel) TablaDetalle.getModel();
        item = item + 1;
        idp = p.getId();
        String nomp = TxtProducto.getText();
        cant = Integer.parseInt(SpnCantidad.getValue().toString());
        pre = Double.parseDouble(TxtPrecio.getText());
        stock = Integer.parseInt(TxtStock.getText());
        total = cant * pre;
        ArrayList lista = new ArrayList();
        if (stock > 0) {
            lista.add(item);
            lista.add(idp);
            lista.add(nomp);
            lista.add(cant);
            lista.add(pre);
            lista.add(total);
            Object[] ob = new Object[6];
            ob[0] = lista.get(0);
            ob[1] = lista.get(1);
            ob[2] = lista.get(2);
            ob[3] = lista.get(3);
            ob[4] = lista.get(4);
            ob[5] = lista.get(5);
            modelo.addRow(ob);
            TablaDetalle.setModel(modelo);
            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(this, "STOCK PRODUCTO NO DISPONIBLE");
        }
    }

    void guardarVenta() {
        int idc = cliente.getId();
        int idv = 1;
        String serie = TxtSerie.getText();
        String fecha = TxtFecha.getText();
        double monto = tpagar;
        String estado = "1";

        v.setIdCliente(idc);
        v.setIdVendedor(idv);
        v.setSerie(serie);
        v.setFecha(fecha);
        v.setMonto(monto);
        v.setEstado(estado);
        vdao.guardarVentas(v);
    }

    void guardarDetalle() {
        String idv = vdao.IdVentas();
        int idve = Integer.parseInt(idv);
        for (int i = 0; i < TablaDetalle.getRowCount(); i++) {
            int idp = Integer.parseInt(TablaDetalle.getValueAt(i, 1).toString());
            int cant = Integer.parseInt(TablaDetalle.getValueAt(i, 3).toString());
            double pre = Double.parseDouble(TablaDetalle.getValueAt(i, 4).toString());

            dv.setIdVentas(idve);
            dv.setIdProducto(idp);
            dv.setCantidad(cant);
            dv.setPreVenta(pre);
            vdao.guardarDetalleVentas(dv);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBuscarC;
    private javax.swing.JButton BtnBuscarP;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGenerar;
    private javax.swing.JSpinner SpnCantidad;
    private javax.swing.JTable TablaDetalle;
    private javax.swing.JTextField TxtCliente;
    private javax.swing.JTextField TxtCodCliente;
    private javax.swing.JTextField TxtCodProduc;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtProducto;
    private javax.swing.JTextField TxtSerie;
    private javax.swing.JTextField TxtStock;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JTextField TxtVende;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
