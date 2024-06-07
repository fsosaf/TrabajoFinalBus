/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.HorarioData;
import AccesoADatos.RutaData;
import Entidades.Horario;
import Entidades.Ruta;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class RecuperaHorario extends javax.swing.JInternalFrame {

    /**
     * Creates new form RecuperaHorario
     */
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    HorarioData horaData;
    RutaData rutaData;
    List<Horario> horarios;
    List<Ruta> rutas;
    public RecuperaHorario() {
        initComponents();
        horaData = new HorarioData();
        rutaData = new RutaData();
        armarCabecera();
        restaurarTabla();
        cargarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jbRecuperar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbRestaurar = new javax.swing.JButton();
        jbBuscarRuta = new javax.swing.JButton();
        jcbBuscarRuta = new javax.swing.JComboBox<>();

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

        jbRecuperar.setText("Recuperar horario");
        jbRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecuperarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 3, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Horarios eliminados");

        jbRestaurar.setText("Restaurar");
        jbRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRestaurarActionPerformed(evt);
            }
        });

        jbBuscarRuta.setText("Buscar por ruta");
        jbBuscarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbBuscarRuta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbBuscarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jbRecuperar)
                    .addComponent(jbBuscarRuta)
                    .addComponent(jcbBuscarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecuperarActionPerformed
        int id;
        int fila = jtTabla.getSelectedRow();
        if (fila != -1) {
            id = (Integer) modelo.getValueAt(fila, 0);
            horaData.recuperarHorario(id);
            restaurarTabla();
        }
    }//GEN-LAST:event_jbRecuperarActionPerformed

    private void jbRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRestaurarActionPerformed
        restaurarTabla();
    }//GEN-LAST:event_jbRestaurarActionPerformed

    private void jbBuscarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarRutaActionPerformed
        Ruta ruta;

        //validar ruta
        ruta = (Ruta) jcbBuscarRuta.getSelectedItem();
        if (ruta == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar o registrar una ruta");
            return;
        }
        //validar ruta

        horarios = horaData.buscarHorarioBorradoPorRuta(ruta);
        borrarFilas();
        for (Horario h : horarios) {
            modelo.addRow(new Object[]{h.getId_horario(), h.getRuta().getOrigen(), h.getRuta().getDestino(), h.getHora_salida(), h.getHora_llegada(), h.getRuta().getId_ruta()});
        }
    }//GEN-LAST:event_jbBuscarRutaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarRuta;
    private javax.swing.JButton jbRecuperar;
    private javax.swing.JButton jbRestaurar;
    private javax.swing.JComboBox<Ruta> jcbBuscarRuta;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Origen");
        modelo.addColumn("Destino");
        modelo.addColumn("Hora de salida");
        modelo.addColumn("Hora de llegada");
        modelo.addColumn("ID RUTA");
        jtTabla.setModel(modelo);
    }

    private void restaurarTabla() {
        borrarFilas();
        horarios = horaData.listarHorariosBorrados();
        for (Horario h : horarios) {
            modelo.addRow(new Object[]{h.getId_horario(), h.getRuta().getOrigen(), h.getRuta().getDestino(), h.getHora_salida(), h.getHora_llegada(), h.getRuta().getId_ruta()});
        }
    }

    private void borrarFilas() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void cargarCombo() {
        rutas = rutaData.listarRutas();
        for (Ruta r : rutas) {
            jcbBuscarRuta.addItem(r);
        }
    }

}