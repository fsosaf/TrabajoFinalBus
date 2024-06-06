/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.HorarioData;
import AccesoADatos.RutaData;
import Entidades.Horario;
import Entidades.Ruta;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class RegistroHorarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistroHorarios
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
    private final String expRegHora = "^(0?[1-9]|1[0-9]|2[0-3])$";
    private final String expRegMin = "^(0?[1-9]|[0-5][0-9])$";
    private final String expRegTime = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";

    public RegistroHorarios() {
        initComponents();
        horaData = new HorarioData();
        rutaData = new RutaData();
        armarCabecera();
        restaurarTabla();
        cargarCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jbRestaurar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfHoraLlegada = new javax.swing.JTextField();
        jtfHoraSalida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jbBuscarHoraS = new javax.swing.JButton();
        jtfBuscarMin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfBuscarHora = new javax.swing.JTextField();
        jcbBuscarRuta = new javax.swing.JComboBox<>();
        jbBuscarRuta = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jtfOrigen = new javax.swing.JTextField();
        jtfDestino = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfIdRuta = new javax.swing.JTextField();

        setClosable(true);

        jlTitulo.setBackground(new java.awt.Color(0, 3, 102));
        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Registro de horarios");

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
        jtTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabla);

        jbRestaurar.setText("Restaurar");
        jbRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRestaurarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setText("Hora de salida");

        jLabel2.setText("Hora de llegada");

        jtfHoraLlegada.setEnabled(false);

        jtfHoraSalida.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ruta");

        jLabel6.setText("ID");

        jtfId.setEnabled(false);

        jbBuscarHoraS.setText("Buscar por hora de salida");
        jbBuscarHoraS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarHoraSActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");

        jbBuscarRuta.setText("Buscar por ruta");
        jbBuscarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarRutaActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.setEnabled(false);
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");
        jbBorrar.setEnabled(false);
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jtfOrigen.setEnabled(false);

        jtfDestino.setEnabled(false);

        jLabel8.setText("Destino");

        jLabel9.setText("Origen");

        jLabel3.setText("ID de Ruta");

        jtfIdRuta.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbRestaurar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfOrigen)
                                    .addComponent(jtfDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbModificar)
                                        .addGap(86, 86, 86)
                                        .addComponent(jbBorrar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfHoraLlegada))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfBuscarHora, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfBuscarMin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbBuscarHoraS))
                                    .addComponent(jcbBuscarRuta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbBuscarRuta)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRestaurar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbBuscarHoraS)
                            .addComponent(jtfBuscarMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jtfBuscarHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(jcbBuscarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscarRuta)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jtfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jtfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbModificar)
                                    .addComponent(jbBorrar)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRestaurarActionPerformed
        restaurarTabla();
    }//GEN-LAST:event_jbRestaurarActionPerformed

    private void jbBuscarHoraSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarHoraSActionPerformed
        Time hora;
        String hour, min;

        //validar horas
        if (validarHorario(jtfBuscarHora, jtfBuscarMin)) {
            hour = jtfBuscarHora.getText();
            min = jtfBuscarMin.getText();
            hora = Time.valueOf(hour + ":" + min + ":00");
        } else {
            return;
        }
        //validar horas

        horarios = horaData.buscarHorarioPorHoraSalida(hora);
        borrarFilas();
        for (Horario h : horarios) {
            modelo.addRow(new Object[]{h.getId_horario(), h.getRuta().getOrigen(), h.getRuta().getDestino(), h.getHora_salida(), h.getHora_llegada(), h.getRuta().getId_ruta()});
        }
    }//GEN-LAST:event_jbBuscarHoraSActionPerformed

    private void jbBuscarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarRutaActionPerformed
        Ruta ruta;

        //validar ruta
        ruta = (Ruta) jcbBuscarRuta.getSelectedItem();
        if (ruta == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar o registrar una ruta");
            return;
        }
        //validar ruta

        horarios = horaData.buscarHorarioPorRuta(ruta);
        borrarFilas();
        for (Horario h : horarios) {
            modelo.addRow(new Object[]{h.getId_horario(), h.getRuta().getOrigen(), h.getRuta().getDestino(), h.getHora_salida(), h.getHora_llegada(), h.getRuta().getId_ruta()});
        }
    }//GEN-LAST:event_jbBuscarRutaActionPerformed

    private void jtTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaMouseClicked
        int fila = jtTabla.getSelectedRow();
        if (fila != -1) {
            jtfOrigen.setText(modelo.getValueAt(fila, 1) + "");
            jtfDestino.setText(modelo.getValueAt(fila, 2) + "");
            jtfHoraSalida.setText(modelo.getValueAt(fila, 3) + "");
            jtfHoraSalida.setEnabled(true);
            jtfHoraLlegada.setText(modelo.getValueAt(fila, 4) + "");
            jtfIdRuta.setText(modelo.getValueAt(fila, 5) + "");
            jtfHoraLlegada.setEnabled(true);
            jtfId.setText(modelo.getValueAt(fila, 0) + "");
            jbModificar.setEnabled(true);
            jbBorrar.setEnabled(true);
        }
    }//GEN-LAST:event_jtTablaMouseClicked

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        int id;
        id = Integer.parseInt(jtfId.getText());
        Horario h = new Horario();
        h.setId_horario(id);
        horaData.eliminarHorario(h);
        terminarManipulacion();
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        Horario horario = new Horario();
        Ruta ruta = new Ruta();
        Time hora_salida, hora_llegada, duracionTime;
        Duration duracion;
        long hours,minutes;
        ruta = rutaData.buscarRutaPorId(Integer.parseInt(jtfIdRuta.getText()));

        //validar horas
        if (jtfHoraSalida.getText().matches(expRegTime) && jtfHoraLlegada.getText().matches(expRegTime)) {
            hora_salida = Time.valueOf(jtfHoraSalida.getText());
            hora_llegada = Time.valueOf(jtfHoraLlegada.getText());
            
            LocalTime salida = hora_salida.toLocalTime();
            LocalTime llegada = hora_llegada.toLocalTime();
            // Calcular la duración
            if (llegada.equals(salida)) {
                // Caso 24hrs
                duracion = Duration.ofHours(23).plusMinutes(59);
            } else if (llegada.isBefore(salida)) {
                // Caso en que la llegada es al día siguiente
                duracion = Duration.between(salida, LocalTime.MIDNIGHT).plus(Duration.between(LocalTime.MIDNIGHT, llegada));
            } else {
                // Caso normal
                duracion = Duration.between(salida, llegada);
            }
            // Convertir la duración a horas y minutos
            hours = duracion.toHours();
            minutes = duracion.toMinutes() % 60;
            duracionTime = Time.valueOf(hours + ":" + minutes + ":00");
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un horario válido(hh:mm:ss)");
            return;
        }
        //validar horas
        
        ruta.setOrigen(jtfOrigen.getText());
        ruta.setDestino(jtfDestino.getText());
        ruta.setId_ruta(Integer.parseInt(jtfIdRuta.getText()));
        ruta.setDuracion_estimada(duracionTime);
        rutaData.modificarRuta(ruta);
        JOptionPane.showMessageDialog(this, "Se actualizo la duracion estimada de la ruta");
        
        horario.setEstado(true);
        horario.setId_horario(Integer.parseInt(jtfId.getText()));
        horario.setHora_salida(hora_salida);
        horario.setHora_llegada(hora_llegada);
        horaData.modificarHorario(horario);
        terminarManipulacion();
    }//GEN-LAST:event_jbModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscarHoraS;
    private javax.swing.JButton jbBuscarRuta;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbRestaurar;
    private javax.swing.JComboBox<Ruta> jcbBuscarRuta;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField jtfBuscarHora;
    private javax.swing.JTextField jtfBuscarMin;
    private javax.swing.JTextField jtfDestino;
    private javax.swing.JTextField jtfHoraLlegada;
    private javax.swing.JTextField jtfHoraSalida;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfIdRuta;
    private javax.swing.JTextField jtfOrigen;
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
        horarios = horaData.listarHorarios();
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

    private void cargarCombos() {
        rutas = rutaData.listarRutas();
        for (Ruta r : rutas) {
            jcbBuscarRuta.addItem(r);
        }
    }

    private boolean validarHorario(JTextField hora, JTextField min) {
        if (hora.getText().equals("") || min.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una horario.");
            return false;
        }
        if (!hora.getText().matches(expRegHora)) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una hora válida (1-23).");
            return false;
        }
        if (!min.getText().matches(expRegMin)) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un minuto válido (00-59).");
            return false;
        }
        return true;
    }

    private void terminarManipulacion() {
        restaurarTabla();
        jtfHoraLlegada.setEnabled(false);
        jtfHoraLlegada.setText("");
        jtfHoraSalida.setEnabled(false);
        jtfHoraSalida.setText("");
        jtfOrigen.setText("");
        jtfDestino.setText("");
        jtfId.setText("");
        jtfIdRuta.setText("");
        jbModificar.setEnabled(false);
        jbBorrar.setEnabled(false);
    }
}