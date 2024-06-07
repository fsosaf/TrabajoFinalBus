/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.RutaData;
import Entidades.Ruta;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class RecuperaRuta extends javax.swing.JInternalFrame {

    /**
     * Creates new form RecuperaRuta
     */
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    RutaData rutaData;
    List<Ruta> rutas;

    public RecuperaRuta() {
        initComponents();
        rutaData = new RutaData();
        armarCabecera();
        restaurarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jbBuscarId = new javax.swing.JButton();
        jtfBuscarId = new javax.swing.JTextField();
        jbRecuperar = new javax.swing.JButton();
        jbRestaurar = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(0, 3, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rutas eliminadas");

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        jbBuscarId.setText("Buscar por ID");
        jbBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarIdActionPerformed(evt);
            }
        });

        jbRecuperar.setText("Recuperar ruta");
        jbRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecuperarActionPerformed(evt);
            }
        });

        jbRestaurar.setText("Restaurar");
        jbRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbBuscarId)
                        .addGap(18, 18, 18)
                        .addComponent(jtfBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbRecuperar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbRestaurar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jbRestaurar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscarId)
                    .addComponent(jtfBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRecuperar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarIdActionPerformed
        if (jtfBuscarId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar");
            return;
        }
        if (!jtfBuscarId.getText().matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID valido(numero)");
            return;
        }
        Ruta r;
        int id;
        id = Integer.parseInt(jtfBuscarId.getText());
        r = rutaData.buscarRutaPorIdBorrado(id);
        if (r != null) {
            borrarFilas();
            modelo.addRow(new Object[]{r.getId_ruta(), r.getOrigen(), r.getDestino(), r.getDuracion_estimada()});
        }
    }//GEN-LAST:event_jbBuscarIdActionPerformed

    private void jbRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRestaurarActionPerformed
        restaurarTabla();
    }//GEN-LAST:event_jbRestaurarActionPerformed

    private void jbRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecuperarActionPerformed
        int id;
        int fila = jtTabla.getSelectedRow();
        if (fila != -1) {
            id = (Integer) modelo.getValueAt(fila, 0);
            rutaData.recuperarRuta(id);
            restaurarTabla();
        }
    }//GEN-LAST:event_jbRecuperarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarId;
    private javax.swing.JButton jbRecuperar;
    private javax.swing.JButton jbRestaurar;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField jtfBuscarId;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Origen");
        modelo.addColumn("Destino");
        modelo.addColumn("Duracion");
        jtTabla.setModel(modelo);
    }

    private void restaurarTabla() {
        borrarFilas();
        rutas = rutaData.listarRutasEliminadas();
        for (Ruta r : rutas) {
            modelo.addRow(new Object[]{r.getId_ruta(), r.getOrigen(), r.getDestino(), r.getDuracion_estimada()});
        }
    }

    private void borrarFilas() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

}