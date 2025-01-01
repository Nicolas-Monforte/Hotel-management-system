
package Vista;

import hotelpoo.PasajeroController;


public class Pasajero extends javax.swing.JFrame {
  private PasajeroController pasajeroController = new PasajeroController();
  
    public Pasajero() {
        initComponents();
       pasajeroController.cargarTablaPasajeros(tablaPasajeros);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        correoLbl = new javax.swing.JLabel();
        documentoLbl = new javax.swing.JLabel();
        telefonoLbl = new javax.swing.JLabel();
        nombrelbl = new javax.swing.JLabel();
        apellidoLbl = new javax.swing.JLabel();
        apellidoTxt = new javax.swing.JTextField();
        nombreTxt1 = new javax.swing.JTextField();
        telefonoTxt = new javax.swing.JTextField();
        correoTxt = new javax.swing.JTextField();
        documentoTxt = new javax.swing.JTextField();
        agegarBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPasajeros = new javax.swing.JTable();
        pasajerosLbl = new javax.swing.JLabel();
        volverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        correoLbl.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        correoLbl.setText("Correo Electrónico:");

        documentoLbl.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        documentoLbl.setText("Documento:");

        telefonoLbl.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        telefonoLbl.setText("Teléfono:");

        nombrelbl.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        nombrelbl.setText("Nombre:");

        apellidoLbl.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        apellidoLbl.setText("Apellido:");

        agegarBtn.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        agegarBtn.setText("Agregar");
        agegarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agegarBtnActionPerformed(evt);
            }
        });

        modificarBtn.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        tablaPasajeros.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        tablaPasajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Documento", "Teléfono", "Correo Electrónico", "ID"
            }
        ));
        tablaPasajeros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPasajerosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPasajeros);

        pasajerosLbl.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        pasajerosLbl.setText("Pasajeros");
        pasajerosLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(correoLbl)
                                    .addComponent(telefonoLbl)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(documentoLbl)
                                        .addComponent(apellidoLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nombrelbl, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(correoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(apellidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(documentoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(telefonoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(144, 144, 144)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(eliminarBtn)
                                            .addComponent(modificarBtn)
                                            .addComponent(agegarBtn))))
                                .addGap(0, 315, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(pasajerosLbl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pasajerosLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(documentoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(documentoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarBtn)))
                    .addComponent(agegarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefonoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(eliminarBtn)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(volverButton)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agegarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agegarBtnActionPerformed
      pasajeroController.agregarPasajero(
        nombreTxt1.getText().trim(),
        apellidoTxt.getText().trim(),
        documentoTxt.getText().trim(),
        telefonoTxt.getText().trim(),
        correoTxt.getText().trim(),
        tablaPasajeros
    );
    nombreTxt1.setText("");
    apellidoTxt.setText("");
    documentoTxt.setText("");
    telefonoTxt.setText("");
    correoTxt.setText("");
    }//GEN-LAST:event_agegarBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        pasajeroController.modificarPasajero(
        nombreTxt1.getText().trim(),
        apellidoTxt.getText().trim(),
        documentoTxt.getText().trim(),
        telefonoTxt.getText().trim(),
        correoTxt.getText().trim(),
        tablaPasajeros
    );
    nombreTxt1.setText("");
    apellidoTxt.setText("");
    documentoTxt.setText("");
    telefonoTxt.setText("");
    correoTxt.setText("");
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
     pasajeroController.eliminarPasajero(tablaPasajeros);
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void tablaPasajerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPasajerosMouseClicked
    pasajeroController.establecerIdSeleccionadoFromTable(tablaPasajeros);
    }//GEN-LAST:event_tablaPasajerosMouseClicked

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        Menu pasajero = new Menu();
        pasajero.setLocationRelativeTo(null);
        pasajero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_volverButtonActionPerformed

 
   
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agegarBtn;
    private javax.swing.JLabel apellidoLbl;
    private javax.swing.JTextField apellidoTxt;
    private javax.swing.JLabel correoLbl;
    private javax.swing.JTextField correoTxt;
    private javax.swing.JLabel documentoLbl;
    private javax.swing.JTextField documentoTxt;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField nombreTxt1;
    private javax.swing.JLabel nombrelbl;
    private javax.swing.JLabel pasajerosLbl;
    private javax.swing.JTable tablaPasajeros;
    private javax.swing.JLabel telefonoLbl;
    private javax.swing.JTextField telefonoTxt;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
