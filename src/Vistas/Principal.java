package Vistas;

import Modelo.EntidadVendedor;
import Modelo.Vendedor;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

public class Principal extends javax.swing.JFrame {

    Vendedor ve = new Vendedor();
    EntidadVendedor ver = new EntidadVendedor();

    public Principal() {

        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

//      ClienteForm cfa = new ClienteForm();
//                        cfa.ocultar(false);
//jlusuario.setText(ve.getUser());
    }
    
    //AQUI ESTO NOS SIRVE PARA LLEVAR EL DATO OBTENIDO EN LOGIN PARA QUE SE MUESTRE EN ESTA VENTANA
    private String dato;

    public void usuario(String dato) {
        this.dato = dato;
        jlusuario.setText(dato);
    }

    private String rol_usuario;

    public void usuario_rol(String rol_usuario) {
        this.rol_usuario = rol_usuario;
        jlrol.setText(rol_usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VentanaPrincipal = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jlusuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlrol = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        ventas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        reportes = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        clientes = new javax.swing.JMenu();
        add_cliente = new javax.swing.JMenuItem();
        up_cliente = new javax.swing.JMenuItem();
        de_cliente = new javax.swing.JMenuItem();
        productos = new javax.swing.JMenu();
        add_producto = new javax.swing.JMenuItem();
        up_producto = new javax.swing.JMenuItem();
        de_producto = new javax.swing.JMenuItem();
        vendedor = new javax.swing.JMenu();
        add_vendedor = new javax.swing.JMenuItem();
        up_vendedor = new javax.swing.JMenuItem();
        de_vendedor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("USUARIO:");

        jlusuario.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jlusuario.setForeground(new java.awt.Color(51, 255, 0));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("CARGO (ROL):");

        jlrol.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlrol.setForeground(new java.awt.Color(51, 255, 0));

        VentanaPrincipal.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        VentanaPrincipal.setLayer(jlusuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        VentanaPrincipal.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        VentanaPrincipal.setLayer(jlrol, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout VentanaPrincipalLayout = new javax.swing.GroupLayout(VentanaPrincipal);
        VentanaPrincipal.setLayout(VentanaPrincipalLayout);
        VentanaPrincipalLayout.setHorizontalGroup(
            VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaPrincipalLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlrol, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VentanaPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        VentanaPrincipalLayout.setVerticalGroup(
            VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaPrincipalLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlrol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/menu.png"))); // NOI18N
        jMenu1.setText("Menu");

        jMenuItem1.setText("Ayuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/bienes.png"))); // NOI18N
        ventas.setText("Ventas");

        jMenuItem3.setText("GenerarVenta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        ventas.add(jMenuItem3);

        jMenuBar1.add(ventas);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/reporte.png"))); // NOI18N
        jMenu3.setText("Mantenimiento");

        jMenuItem5.setText("Producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Vendedor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/grafico-de-barras.png"))); // NOI18N
        reportes.setText("Reportes");

        jMenuItem7.setText("Reporte de Venta");
        reportes.add(jMenuItem7);

        jMenuBar1.add(reportes);

        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/cliente.png"))); // NOI18N
        clientes.setText("Clientes");

        add_cliente.setText("AGREGAR");
        add_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_clienteActionPerformed(evt);
            }
        });
        clientes.add(add_cliente);

        up_cliente.setText("MODIFICAR");
        up_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_clienteActionPerformed(evt);
            }
        });
        clientes.add(up_cliente);

        de_cliente.setText("ELIMINAR");
        de_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                de_clienteActionPerformed(evt);
            }
        });
        clientes.add(de_cliente);

        jMenuBar1.add(clientes);

        productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/productos.png"))); // NOI18N
        productos.setText("Productos");

        add_producto.setText("AGREGAR");
        add_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_productoActionPerformed(evt);
            }
        });
        productos.add(add_producto);

        up_producto.setText("MODIFICAR");
        up_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_productoActionPerformed(evt);
            }
        });
        productos.add(up_producto);

        de_producto.setText("ELIMINAR");
        de_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                de_productoActionPerformed(evt);
            }
        });
        productos.add(de_producto);

        jMenuBar1.add(productos);

        vendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/users_clients_group_16774.png"))); // NOI18N
        vendedor.setText("VENDEDOR");

        add_vendedor.setText("AGREGAR");
        vendedor.add(add_vendedor);

        up_vendedor.setText("MODIFICAR");
        up_vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_vendedorActionPerformed(evt);
            }
        });
        vendedor.add(up_vendedor);

        de_vendedor.setText("ELIMINAR");
        vendedor.add(de_vendedor);

        jMenuBar1.add(vendedor);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        VentasForm vf = new VentasForm();
        vf.show(true);
        CentrarVentana(vf);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void add_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_clienteActionPerformed
        ClienteForm cf = new ClienteForm();
        cf.show(true);
        CentrarVentana(cf);

    }//GEN-LAST:event_add_clienteActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ProductoForm pf = new ProductoForm();
        pf.show(true);
        CentrarVentana(pf);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        VendedorForm vf = new VendedorForm();
        vf.show(true);
        CentrarVentana(vf);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void up_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_clienteActionPerformed
        // TODO add your handling code here:

//        new ClienteForm_UP().setVisible(true);
//        this.setVisible(true);
        ClienteForm_UP cup = new ClienteForm_UP();
        cup.show(true);
        CentrarVentana(cup);

//        new ClienteForm_UP().setVisible(true);

    }//GEN-LAST:event_up_clienteActionPerformed

    private void de_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_de_clienteActionPerformed
        // TODO add your handling code here:
        
        ClienteForm_DE cde = new ClienteForm_DE();
        cde.show(true);
        CentrarVentana(cde);
    }//GEN-LAST:event_de_clienteActionPerformed

    private void de_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_de_productoActionPerformed
        // TODO add your handling code here:
        ProductoForm_DELETE cf = new ProductoForm_DELETE();
        cf.show(true);
        CentrarVentana(cf);
        
        
    }//GEN-LAST:event_de_productoActionPerformed

    private void up_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_productoActionPerformed
        // TODO add your handling code here:
        
        ProductoForm_UP pf =new ProductoForm_UP();
       pf.show(true);
        CentrarVentana(pf);
        
    }//GEN-LAST:event_up_productoActionPerformed

    private void add_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_productoActionPerformed
        // TODO add your handling code here:
        
         ProductoForm pf =new ProductoForm();
       pf.show(true);
        CentrarVentana(pf);
    }//GEN-LAST:event_add_productoActionPerformed

    private void up_vendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_vendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up_vendedorActionPerformed

    void CentrarVentana(JInternalFrame frame) {
        VentanaPrincipal.add(frame);
        Dimension dimension = VentanaPrincipal.getSize();
        Dimension Dframe = frame.getSize();
        frame.setLocation((dimension.width - Dframe.width) / 2, (dimension.height - Dframe.height) / 2);
        frame.show();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane VentanaPrincipal;
    public javax.swing.JMenuItem add_cliente;
    public javax.swing.JMenuItem add_producto;
    public javax.swing.JMenuItem add_vendedor;
    public javax.swing.JMenu clientes;
    public javax.swing.JMenuItem de_cliente;
    public javax.swing.JMenuItem de_producto;
    public javax.swing.JMenuItem de_vendedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JMenu jMenu1;
    public static javax.swing.JMenu jMenu3;
    public static javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public static javax.swing.JMenuItem jMenuItem5;
    public static javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    public static javax.swing.JLabel jlrol;
    public static javax.swing.JLabel jlusuario;
    public javax.swing.JMenu productos;
    public static javax.swing.JMenu reportes;
    public javax.swing.JMenuItem up_cliente;
    public javax.swing.JMenuItem up_producto;
    public javax.swing.JMenuItem up_vendedor;
    public javax.swing.JMenu vendedor;
    public static javax.swing.JMenu ventas;
    // End of variables declaration//GEN-END:variables
}
