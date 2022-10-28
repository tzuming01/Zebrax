/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rent;

/**
 *
 * @author aunir
 */
public class Admin_Home_Page extends javax.swing.JFrame {

    /**
     * Creates new form Home_Page
     */
    public Admin_Home_Page() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        goTo_customer = new javax.swing.JLabel();
        goTo_booking = new javax.swing.JLabel();
        goTo_payment = new javax.swing.JLabel();
        goTo_host = new javax.swing.JLabel();
        goTo_carModels = new javax.swing.JLabel();
        ViewAccountBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        report_Btn = new javax.swing.JButton();
        employeeList_Btn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ZEBRAX");
        setLocation(new java.awt.Point(325, 95));

        jPanel1.setBackground(new java.awt.Color(255, 248, 240));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goTo_customer.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        goTo_customer.setForeground(new java.awt.Color(66, 63, 63));
        goTo_customer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goTo_customer.setText("Customers");
        goTo_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goTo_customerMouseClicked(evt);
            }
        });
        jPanel2.add(goTo_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 24, -1, -1));

        goTo_booking.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        goTo_booking.setForeground(new java.awt.Color(66, 63, 63));
        goTo_booking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goTo_booking.setText("Booking");
        goTo_booking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goTo_bookingMouseClicked(evt);
            }
        });
        jPanel2.add(goTo_booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 24, -1, -1));

        goTo_payment.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        goTo_payment.setForeground(new java.awt.Color(66, 63, 63));
        goTo_payment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goTo_payment.setText("Payments");
        goTo_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goTo_paymentMouseClicked(evt);
            }
        });
        jPanel2.add(goTo_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 24, -1, -1));

        goTo_host.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        goTo_host.setForeground(new java.awt.Color(66, 63, 63));
        goTo_host.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goTo_host.setText("Host");
        goTo_host.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goTo_hostMouseClicked(evt);
            }
        });
        jPanel2.add(goTo_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 24, -1, -1));

        goTo_carModels.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        goTo_carModels.setForeground(new java.awt.Color(66, 63, 63));
        goTo_carModels.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goTo_carModels.setText("Car Models");
        goTo_carModels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goTo_carModelsMouseClicked(evt);
            }
        });
        jPanel2.add(goTo_carModels, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 24, -1, -1));

        ViewAccountBtn.setBackground(new java.awt.Color(252, 205, 146));
        ViewAccountBtn.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        ViewAccountBtn.setForeground(new java.awt.Color(66, 63, 63));
        ViewAccountBtn.setText("Z ");
        ViewAccountBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ViewAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAccountBtnActionPerformed(evt);
            }
        });
        jPanel2.add(ViewAccountBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 30, -1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 50, 10));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 50, 10));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 30, 10));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 60, 10));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 60, 11));

        jLabel1.setBackground(new java.awt.Color(198, 225, 176));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(198, 225, 176));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("What drives you today?");

        report_Btn.setBackground(new java.awt.Color(252, 205, 146));
        report_Btn.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        report_Btn.setForeground(new java.awt.Color(66, 63, 63));
        report_Btn.setText("Reports");
        report_Btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        report_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_BtnActionPerformed(evt);
            }
        });

        employeeList_Btn1.setBackground(new java.awt.Color(252, 205, 146));
        employeeList_Btn1.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        employeeList_Btn1.setForeground(new java.awt.Color(66, 63, 63));
        employeeList_Btn1.setText("Employees");
        employeeList_Btn1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        employeeList_Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeList_Btn1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(198, 225, 176));
        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(66, 63, 63));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("What drives you today?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(employeeList_Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(report_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(155, 155, 155))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(158, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(154, 154, 154)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(report_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeList_Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 215, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(jLabel2)
                    .addContainerGap(286, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goTo_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goTo_customerMouseClicked
        Admin_Customer customer = new Admin_Customer();
        customer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goTo_customerMouseClicked

    private void goTo_bookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goTo_bookingMouseClicked
        Admin_Booking book = new Admin_Booking();
        book.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goTo_bookingMouseClicked

    private void goTo_paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goTo_paymentMouseClicked
        Admin_payment pay = new Admin_payment();
        pay.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goTo_paymentMouseClicked

    private void goTo_hostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goTo_hostMouseClicked
        Admin_Host host = new Admin_Host();
        host.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goTo_hostMouseClicked

    private void goTo_carModelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goTo_carModelsMouseClicked
        Admin_Cars cars = new Admin_Cars();
        cars.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goTo_carModelsMouseClicked

    private void employeeList_Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeList_Btn1ActionPerformed
        Admin_employeeList empList = new Admin_employeeList();
        empList.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_employeeList_Btn1ActionPerformed

    private void ViewAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAccountBtnActionPerformed
        Admin_viewAccount acc = new Admin_viewAccount();
        acc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ViewAccountBtnActionPerformed

    private void report_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_report_BtnActionPerformed
        Admin_genReport report = new Admin_genReport();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_report_BtnActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Home_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewAccountBtn;
    private javax.swing.JButton employeeList_Btn1;
    private javax.swing.JLabel goTo_booking;
    private javax.swing.JLabel goTo_carModels;
    private javax.swing.JLabel goTo_customer;
    private javax.swing.JLabel goTo_host;
    private javax.swing.JLabel goTo_payment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton report_Btn;
    // End of variables declaration//GEN-END:variables
}
