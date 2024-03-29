/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.yasinsolak.views;

import com.yasinsolak.entity.Car;
import com.yasinsolak.entity.Dealership;
import com.yasinsolak.repository.CarRepository;
import com.yasinsolak.repository.DealershipRepository;
import java.util.List;

/**
 *
 * @author xmeny
 */
public class UpdateCarPage extends javax.swing.JFrame {

    DealershipRepository dealershipRepository;
    CarRepository carRepository;
    List<Dealership> dealerships;

    public UpdateCarPage() {
        initComponents();
        dealershipRepository = new DealershipRepository();
        carRepository = new CarRepository();
        dealerships = dealershipRepository.findAll();
        dealerships.stream().forEach(s -> {
            comboCompanyId.addItem(s);
        });

    }
    long carId;

    public void transferValues(Car car) {
        txtBrand.setText(car.getBrand());
        txtCarModel.setText(car.getCarModel());
        txtModelYear.setText(car.getModelYear());
        comboCompanyId.setSelectedIndex((int) car.getDealerShipId() - 1);
        carId = car.getId();
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
        txtBrand = new javax.swing.JTextField();
        txtCarModel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtModelYear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboCompanyId = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Car Page");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(999, 999));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Brand");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 165, 122, -1));

        txtBrand.setBackground(new java.awt.Color(255, 255, 255));
        txtBrand.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 162, 160, -1));

        txtCarModel.setBackground(new java.awt.Color(255, 255, 255));
        txtCarModel.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtCarModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 202, 160, -1));

        jLabel2.setText("Car Model");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 205, 122, -1));

        txtModelYear.setBackground(new java.awt.Color(255, 255, 255));
        txtModelYear.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtModelYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 242, 160, -1));

        jLabel3.setText("Model Year");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 245, 122, -1));

        jLabel4.setText("Company Id");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 285, 122, -1));

        comboCompanyId.setBackground(new java.awt.Color(255, 255, 255));
        comboCompanyId.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(comboCompanyId, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 282, 160, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("UPDATE CAR");
        jLabel5.setToolTipText("");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 34, -1, 57));

        btnUpdate.setBackground(new java.awt.Color(0, 204, 51));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 360, 118, 41));

        btnCancel.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 360, 118, 41));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        CarPage carPage = new CarPage();
        dispose();
        carPage.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Car car = updateCarInformation();
        carRepository.update(car, carId);
        carRepository.update(car, carId);
        setVisible(false);
        CarPage carPage = new CarPage();
        carPage.setVisible(true);
        carPage.getCars();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private Car updateCarInformation() {
        String brand = txtBrand.getText();
        String carModel = txtCarModel.getText();
        String modelYear = txtModelYear.getText();
        int dealershipId = comboCompanyId.getSelectedIndex();
        Car car = new Car(brand, carModel, modelYear, dealershipId);
        return car;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateCarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCarPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Dealership> comboCompanyId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCarModel;
    private javax.swing.JTextField txtModelYear;
    // End of variables declaration//GEN-END:variables
}
