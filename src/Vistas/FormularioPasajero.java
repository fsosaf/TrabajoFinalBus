/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.PasajeroData;
import Entidades.Pasajero;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author debor
 */
public class FormularioPasajero extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioPasajero
     */
    private final String expRegNyA = "^[^\\d\\s]\\D*$";
    private final String expRegDni = "^[1-9]{1}[\\d]{7}$";
    private final String expRegMail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9]+)*(?:\\.[A-Za-z]+)$";
    private PasajeroData pasaData;
    List<Pasajero> pasajeros;
    public FormularioPasajero() {
        initComponents();
        pasaData = new PasajeroData();
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
        jtfDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfTelefono = new javax.swing.JTextField();
        jtfCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setBackground(new java.awt.Color(0, 3, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario pasajero");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dni");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellido");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Telefono");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Correo electrónico");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDni, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfNombre)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                        .addComponent(jtfCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(jtfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbGuardar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        Pasajero pasajero = new Pasajero();
        String nombre,apellido,dni,correo,telefono;
        
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
            telefono = jtfTelefono.getText();
        }
        //validar tel
        
        //dni/correo repetido
        pasajeros = pasaData.listarPasajeros();
        for(Pasajero p : pasajeros){
            if(p.getDni().equals(jtfDni.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un dni que no este repetido");
                return;
            }
            if(p.getCorreo().equals(jtfCorreo.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un correo que no este repetido");
                return;
            }
        }
        jtfApellido.setText("");
        jtfDni.setText("");
        jtfNombre.setText("");
        jtfTelefono.setText("");
        jtfCorreo.setText("");
        //dni/correo repetido
        
        pasajero.setNombre(nombre);
        pasajero.setApellido(apellido);
        pasajero.setCorreo(correo);
        pasajero.setTelefono(telefono);
        pasajero.setDni(dni);
        pasaData.guardarPasajero(pasajero);
    }//GEN-LAST:event_jbGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfCorreo;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfTelefono;
    // End of variables declaration//GEN-END:variables
}
