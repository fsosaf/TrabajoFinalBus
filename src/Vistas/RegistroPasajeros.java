/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.PasajeroData;
import Entidades.Pasajero;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author debor
 */
public class RegistroPasajeros extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistroPasajeros
     */
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    PasajeroData pasaData;
    List<Pasajero> pasajeros;
    private final String expRegNyA = "^[^\\d\\s]\\D*$";
    private final String expRegDni = "^[1-9]{1}[\\d]{7}$";
    private final String expRegMail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9]+)*(?:\\.[A-Za-z]+)$";
    
    
    public RegistroPasajeros() {
        initComponents();
        pasaData = new PasajeroData();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jtfDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfCorreo = new javax.swing.JTextField();
        jtfTelefono = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jtfBuscarDni = new javax.swing.JTextField();
        jbBuscarDni = new javax.swing.JButton();
        jtfBuscarId = new javax.swing.JTextField();
        jbBuscarId = new javax.swing.JButton();
        jtfBuscarNombre = new javax.swing.JTextField();
        jtfBuscarApellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jbBuscarNyA = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jbRestaurar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setBackground(new java.awt.Color(0, 3, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de pasajeros");

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

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("DNI");

        jtfNombre.setEnabled(false);

        jtfApellido.setEnabled(false);

        jtfDni.setEnabled(false);

        jLabel5.setText("Correo");

        jLabel6.setText("Telefono");

        jtfCorreo.setEnabled(false);

        jtfTelefono.setEnabled(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jbBuscarDni.setText("Buscar por DNI");
        jbBuscarDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarDniActionPerformed(evt);
            }
        });

        jbBuscarId.setText("Buscar por ID");
        jbBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarIdActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre");

        jLabel8.setText("Apellido");

        jbBuscarNyA.setText("Buscar por nombre y apellido ");
        jbBuscarNyA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarNyAActionPerformed(evt);
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

        jLabel9.setText("ID");

        jtfId.setEnabled(false);

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfApellido))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfDni))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfCorreo))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfTelefono))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jbModificar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbBorrar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfBuscarDni)
                                    .addComponent(jtfBuscarId))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbBuscarDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbBuscarId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfBuscarApellido))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfBuscarNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jbBuscarNyA)
                                .addGap(35, 35, 35))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbRestaurar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRestaurar)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNombre)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfApellido)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDni)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCorreo)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfTelefono)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbBorrar)
                            .addComponent(jbModificar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscarDni))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscarId))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBuscarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarNyA)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaMouseClicked
        int fila = jtTabla.getSelectedRow();
        if (fila != -1) {
            jtfNombre.setEnabled(true);
            jtfNombre.setText(modelo.getValueAt(fila, 1) + "");
            jtfApellido.setText(modelo.getValueAt(fila, 2) + "");
            jtfApellido.setEnabled(true);
            jtfDni.setText(modelo.getValueAt(fila, 3) + "");
            jtfDni.setEnabled(true);
            jtfTelefono.setText(modelo.getValueAt(fila, 4) + "");
            jtfTelefono.setEnabled(true);
            jtfCorreo.setText(modelo.getValueAt(fila, 5) + "");
            jtfCorreo.setEnabled(true);
            jtfId.setText(modelo.getValueAt(fila, 0) + "");
            jbModificar.setEnabled(true);
            jbBorrar.setEnabled(true);
        }
    }//GEN-LAST:event_jtTablaMouseClicked

    private void jbBuscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarDniActionPerformed
        if (jtfBuscarDni.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI para buscar");
            return;
        }
        Pasajero p;
        p = pasaData.buscarPasajeroPorDni(jtfBuscarDni.getText());
        if (p != null) {
            borrarFilas();
            modelo.addRow(new Object[]{p.getId_pasajero(), p.getNombre(), p.getApellido(), p.getDni(), p.getTelefono(), p.getCorreo()});
        }
    }//GEN-LAST:event_jbBuscarDniActionPerformed

    private void jbRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRestaurarActionPerformed
        restaurarTabla();
    }//GEN-LAST:event_jbRestaurarActionPerformed

    private void jbBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarIdActionPerformed
        if (jtfBuscarId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar");
            return;
        }
        if (!jtfBuscarId.getText().matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID valido(numero)");
            return;
        }
        Pasajero p;
        int id;
        id = Integer.parseInt(jtfBuscarId.getText());
        p = pasaData.buscarPasajeroPorId(id);
        if (p != null) {
            borrarFilas();
            modelo.addRow(new Object[]{p.getId_pasajero(), p.getNombre(), p.getApellido(), p.getDni(), p.getTelefono(), p.getCorreo()});
        }
    }//GEN-LAST:event_jbBuscarIdActionPerformed

    private void jbBuscarNyAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarNyAActionPerformed
        if (jtfBuscarNombre.getText().equals("") || jtfBuscarApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre y un apellido para buscar");
            return;
        }
        String nombre, apellido;
        nombre = jtfBuscarNombre.getText();
        apellido = jtfBuscarApellido.getText();
        pasajeros = pasaData.buscarPasajeroPorNombreyApellido(nombre, apellido);
        borrarFilas();
        for (Pasajero p : pasajeros) {
            modelo.addRow(new Object[]{p.getId_pasajero(), p.getNombre(), p.getApellido(), p.getDni(), p.getTelefono(), p.getCorreo()});
        }
    }//GEN-LAST:event_jbBuscarNyAActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        Pasajero p = new Pasajero();
        String nombre,apellido,correo,tel,dni;
        
        //validar nombre y apellido
        if(!jtfNombre.getText().matches(expRegNyA) || !jtfApellido.getText().matches(expRegNyA)){
            JOptionPane.showMessageDialog(this, "Ingrese un nombre y apellido válidos");
            return;
        }else{
            nombre = jtfNombre.getText();
            apellido = jtfApellido.getText();
        }
        //validar nombre y apellido
        
        //validar dni
        if(!jtfDni.getText().matches(expRegDni)){            
            JOptionPane.showMessageDialog(this, "Ingrese un dni válido(8 cifras)");
            return;
        }else{
            dni = jtfDni.getText();
        }
        //validar dni
        
        //validar correo
        if(!jtfCorreo.getText().matches(expRegMail)){
            JOptionPane.showMessageDialog(this, "Ingrese un correo válido(***@***.***)");
            return;            
        }else{
            correo = jtfCorreo.getText();
        }
        //validar correo
        
        //validar tel
        if(!jtfTelefono.getText().matches("^\\d+$")){
            JOptionPane.showMessageDialog(this, "Ingrese un telefono válido(solo numeros)");
            return;            
        }else{
            tel = jtfTelefono.getText();
        }
        //validar tel
        
        p.setId_pasajero(Integer.parseInt(jtfId.getText()));
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDni(dni);
        p.setCorreo(correo);
        p.setTelefono(tel);
        p.setEstado(true);
        pasaData.modificarPasajero(p);
        terminarManipulacion();
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        int id;
        id = Integer.parseInt(jtfId.getText());        
        Pasajero p = new Pasajero();
        p.setId_pasajero(id);
        pasaData.EliminarPasajero(p);
        terminarManipulacion();
    }//GEN-LAST:event_jbBorrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscarDni;
    private javax.swing.JButton jbBuscarId;
    private javax.swing.JButton jbBuscarNyA;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbRestaurar;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfBuscarApellido;
    private javax.swing.JTextField jtfBuscarDni;
    private javax.swing.JTextField jtfBuscarId;
    private javax.swing.JTextField jtfBuscarNombre;
    private javax.swing.JTextField jtfCorreo;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfTelefono;
    // End of variables declaration//GEN-END:variables

    private void restaurarTabla() {
        borrarFilas();
        pasajeros = pasaData.listarPasajeros();
        for (Pasajero p : pasajeros) {
            modelo.addRow(new Object[]{p.getId_pasajero(), p.getNombre(), p.getApellido(), p.getDni(), p.getTelefono(), p.getCorreo()});
        }
    }

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DNI");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        jtTabla.setModel(modelo);
    }

    private void borrarFilas() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void terminarManipulacion() {
        restaurarTabla();
        jtfNombre.setEnabled(false);
        jtfNombre.setText("");
        jtfApellido.setEnabled(false);
        jtfApellido.setText("");
        jtfDni.setEnabled(false);
        jtfDni.setText("");
        jtfCorreo.setEnabled(false);
        jtfCorreo.setText("");
        jtfTelefono.setEnabled(false);
        jtfTelefono.setText("");
        jtfId.setText("");
        jbModificar.setEnabled(false);
        jbBorrar.setEnabled(false);
    }
}
