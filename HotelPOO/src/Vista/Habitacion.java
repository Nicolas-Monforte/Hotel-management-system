/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import hotelpoo.HabitacionController;

/**
 *
 * @author monfo
 */
public class Habitacion extends javax.swing.JFrame {

    private HabitacionController habitacionController = new HabitacionController();

    /**
     * Creates new form Habitacion
     */
    public Habitacion() {
        initComponents();
        habitacionController.cargarTablaPasajeros(tablaHabitaciones);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        habitacionesLbl = new javax.swing.JLabel();
        precioLbl = new javax.swing.JLabel();
        numHablbl1 = new javax.swing.JLabel();
        cantSingleLbl = new javax.swing.JLabel();
        cantDoblesLbl = new javax.swing.JLabel();
        numHabTxt = new javax.swing.JTextField();
        precioTxt = new javax.swing.JTextField();
        camasSinglesBox = new javax.swing.JComboBox<>();
        camasDoblesBox = new javax.swing.JComboBox<>();
        agegarHabBtn = new javax.swing.JButton();
        modificarHabBtn = new javax.swing.JButton();
        eliminarHabBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();
        volverButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        habitacionesLbl.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        habitacionesLbl.setText("Habitaciones");
        habitacionesLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        precioLbl.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        precioLbl.setText("Precio Por Día:");

        numHablbl1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        numHablbl1.setText("Numero de Habitación:");

        cantSingleLbl.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        cantSingleLbl.setText("Cantidad de Camas Single:");

        cantDoblesLbl.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        cantDoblesLbl.setText("Cantidad de Camas Doble:");

        camasSinglesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));

        camasDoblesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        agegarHabBtn.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        agegarHabBtn.setText("Agregar");
        agegarHabBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agegarHabBtnActionPerformed(evt);
            }
        });

        modificarHabBtn.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        modificarHabBtn.setText("Modificar");
        modificarHabBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarHabBtnActionPerformed(evt);
            }
        });

        eliminarHabBtn.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        eliminarHabBtn.setText("Eliminar");
        eliminarHabBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarHabBtnActionPerformed(evt);
            }
        });

        tablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero Habitación", "Camas Singles", "Camas Dobles", "Precio", "ID"
            }
        ));
        tablaHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaHabitaciones);

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(precioLbl)
                                    .addComponent(numHablbl1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numHabTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cantDoblesLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(camasDoblesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cantSingleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(camasSinglesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(277, 277, 277)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eliminarHabBtn)
                            .addComponent(modificarHabBtn)
                            .addComponent(agegarHabBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(habitacionesLbl)
                .addGap(435, 435, 435))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(habitacionesLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cantDoblesLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(camasDoblesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numHabTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numHablbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cantSingleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(camasSinglesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(agegarHabBtn)
                        .addGap(35, 35, 35)
                        .addComponent(modificarHabBtn)
                        .addGap(34, 34, 34)
                        .addComponent(eliminarHabBtn)
                        .addGap(54, 54, 54)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(volverButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agegarHabBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agegarHabBtnActionPerformed
        habitacionController.agregarHabitacion(
                numHabTxt.getText().trim(),
                (String) camasSinglesBox.getSelectedItem(),
                (String) camasDoblesBox.getSelectedItem(),
                precioTxt.getText().trim(),
                tablaHabitaciones
        );
        numHabTxt.setText("");
        camasSinglesBox.setSelectedIndex(0);
        camasDoblesBox.setSelectedIndex(0);
        precioTxt.setText("");
    }//GEN-LAST:event_agegarHabBtnActionPerformed

    private void modificarHabBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarHabBtnActionPerformed
        habitacionController.modificarPasajero(
                numHabTxt.getText().trim(),
                (String) camasSinglesBox.getSelectedItem(),
                (String) camasDoblesBox.getSelectedItem(),
                precioTxt.getText().trim(),
                tablaHabitaciones
        );
        numHabTxt.setText("");
        camasSinglesBox.setSelectedIndex(0);
        camasDoblesBox.setSelectedIndex(0);
        precioTxt.setText("");
    }//GEN-LAST:event_modificarHabBtnActionPerformed

    private void eliminarHabBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarHabBtnActionPerformed
        habitacionController.eliminarPasajero(tablaHabitaciones);
    }//GEN-LAST:event_eliminarHabBtnActionPerformed


    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        Menu pasajero = new Menu();
        pasajero.setLocationRelativeTo(null);
        pasajero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_volverButtonActionPerformed

    private void tablaHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHabitacionesMouseClicked
        habitacionController.establecerIdSeleccionadoFromTable(tablaHabitaciones);
    }//GEN-LAST:event_tablaHabitacionesMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agegarHabBtn;
    private javax.swing.JComboBox<String> camasDoblesBox;
    private javax.swing.JComboBox<String> camasSinglesBox;
    private javax.swing.JLabel cantDoblesLbl;
    private javax.swing.JLabel cantSingleLbl;
    private javax.swing.JButton eliminarHabBtn;
    private javax.swing.JLabel habitacionesLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modificarHabBtn;
    private javax.swing.JTextField numHabTxt;
    private javax.swing.JLabel numHablbl1;
    private javax.swing.JLabel precioLbl;
    private javax.swing.JTextField precioTxt;
    private javax.swing.JTable tablaHabitaciones;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
