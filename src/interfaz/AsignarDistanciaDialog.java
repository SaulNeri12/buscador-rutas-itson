
package interfaz;

import grafos.Locacion;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author saul
 */
public class AsignarDistanciaDialog extends javax.swing.JDialog {

    /**
     * Creates new form AsignarDistanciaDialog
     */
    public AsignarDistanciaDialog(java.awt.Frame parent, boolean modal, Locacion origen, List<Locacion> locaciones) {
        super(parent, modal);
        initComponents();
        
        DefaultComboBoxModel<Locacion> locacionesModel = new DefaultComboBoxModel<>();
             
        for (Locacion loc: locaciones) {
            if (loc.getId() != origen.getId()) {
                locacionesModel.addElement(loc);
            }
        }
        
        this.puntoDestinoComboBox.setModel(locacionesModel);
        
        this.setTitle("Asignar Distancia a " + origen.getNombre());
        this.setVisible(true);
    }
    
    public Locacion getDestino() {
        return (Locacion) this.puntoDestinoComboBox.getSelectedItem();
    }
    
    public int getDistancia() {
        return Integer.parseInt(this.campoDistanciaMetros.getText());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoDistanciaMetros = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        puntoDestinoComboBox = new javax.swing.JComboBox<>();
        botonAceptar = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        campoDistanciaMetros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDistanciaMetrosActionPerformed(evt);
            }
        });

        jLabel2.setText("Distancia (metros):");

        jLabel3.setText("Punto Destino:");

        DefaultComboBoxModel<Locacion> modelo = new DefaultComboBoxModel<>();
        puntoDestinoComboBox.setModel(modelo);
        puntoDestinoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntoDestinoComboBoxActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(84, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDistanciaMetros, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(puntoDestinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAceptar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(puntoDestinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDistanciaMetros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCerrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDistanciaMetrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDistanciaMetrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDistanciaMetrosActionPerformed

    private void puntoDestinoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntoDestinoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puntoDestinoComboBoxActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        
        boolean locacionSeleccionada = this.puntoDestinoComboBox.getSelectedIndex() != -1;
        
        if (!locacionSeleccionada) {
            JOptionPane.showMessageDialog(this, "Selecciona la locacion destino", "Locacion desconocida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        boolean distanciaValida = this.campoDistanciaMetros.getText().matches("\\d+");
        
        if (!distanciaValida) {
            JOptionPane.showMessageDialog(this, "La distancia solo acepta numeros enteros", "Distancia Erronea", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JTextField campoDistanciaMetros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<Locacion> puntoDestinoComboBox;
    // End of variables declaration//GEN-END:variables
}
