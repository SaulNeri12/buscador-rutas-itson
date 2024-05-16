/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz;

import grafos.Locacion;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author saul
 */
public class CalcularDistanciaDialog extends javax.swing.JDialog {

    private Locacion destino;
    
    /**
     * Creates new form CalcularDistanciaDialog
     */
    public CalcularDistanciaDialog(java.awt.Frame parent, boolean modal, Locacion origen, List<Locacion> locaciones) {
        super(parent, modal);
        initComponents();
        
        DefaultComboBoxModel<Locacion> locacionesModel = new DefaultComboBoxModel<>();
             
        for (Locacion loc: locaciones) {
            if (loc.getId() != origen.getId()) {
                locacionesModel.addElement(loc);
            }
        }
        
        this.locacionesComboBox.setModel(locacionesModel);
        
        this.setTitle("Calcular distancia");
        this.setVisible(true);
    }
    
    public Locacion getDestino() {
        return this.destino;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        locacionesComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        botonCalcular = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        locacionesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locacionesComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Locacion Destino:");

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locacionesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCalcular)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locacionesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCalcular)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void locacionesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locacionesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locacionesComboBoxActionPerformed

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        boolean locacionSeleccionada = this.locacionesComboBox.getSelectedIndex() != -1;
        
        if (!locacionSeleccionada) {
            JOptionPane.showMessageDialog(this, "Selecciona la locacion destino", "Locacion desconocida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Locacion destino = this.locacionesComboBox.getModel().getElementAt(this.locacionesComboBox.getSelectedIndex());
        this.destino = destino;
        
        this.dispose();
    }//GEN-LAST:event_botonCalcularActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<Locacion> locacionesComboBox;
    // End of variables declaration//GEN-END:variables
}
