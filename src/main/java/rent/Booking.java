/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rent;

import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author tzuming
 */
public class Booking extends javax.swing.JFrame {

    public static int lastid;
    public static String carbrand;
    public static String carmodel;
    public static String carplate;
    public static String startdate;
    public static String enddate;
    public static long diffdate;
    public static String rental;
    
    User user = new User();
    User user_info = user.getUser();
        
    /**
     * Creates new form Rental
     */
    public Booking() {           
        initComponents();
        
        LoadCarBrand();
        txtstartdate.setDateFormatString("yyyy/MM/dd");
        txtenddate.setDateFormatString("yyyy/MM/dd");
    }
    
    public Booking getBooking() {
        return this;
    }
    
    public void setBooking (int lastid, String carbrand, String carmodel, String carplate, String startdate, String enddate, long diffdate, String rental) {
        this.lastid = lastid;
        this.carbrand = carbrand;
        this.carmodel = carmodel;
        this.carplate = carplate;
        this.startdate = startdate;
        this.enddate = enddate;
        this.diffdate = diffdate;
        this.rental = rental;
    }
    
    public void LoadCarBrand() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("car.txt"));
            String s="";
            txtcarbrand.removeAllItems();
            txtcarbrand.addItem("Please Select");
            while ((s=br.readLine()) != null) {
                String data[] = new String[5];
                data = s.split(",");
                int duplicate = 0;
                int size = txtcarbrand.getItemCount();
                for (int i = 0; i < size; i++) {
                  if (txtcarbrand.getItemAt(i).equals(data[1])) {
                      duplicate=1;
                  }
                }
                
                if(duplicate==0) {
                    txtcarbrand.addItem(data[1]);
                }
            }
        } catch (Exception e) {
      
        }
    }
    
    public void LoadCarModel(String carbrand) {
        try {
          
            BufferedReader br = new BufferedReader(new FileReader("car.txt"));
            String s="";
            txtcarmodel.removeAllItems();
            txtcarmodel.addItem("Please Select");
            while ((s=br.readLine()) != null) {
                String data[] = new String[5];
                data = s.split(",");
                if (carbrand.equals(data[1])) {
                    txtcarmodel.addItem(data[2]);
                }
            }
        } catch (Exception e) {
      
        }
    }
    
    private boolean isNumeric(String strNum) {
        if (!strNum.isEmpty()) {
            try {
                double d = Double.parseDouble(strNum);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }
    
    public void TableUpdate() {
        String carbrand = String.valueOf(txtcarbrand.getSelectedItem());
        String carmodel = String.valueOf(txtcarmodel.getSelectedItem());
        String transmission = ((chktransmission_auto.isSelected() && chktransmission_manual.isSelected()) || (!chktransmission_auto.isSelected() && !chktransmission_manual.isSelected())) ? "" : (chktransmission_manual.isSelected()) ? "Manual" : "Automatic";
        String min_seat = txtminseat.getText();
        String max_seat = txtmaxseat.getText();
        String min_rental = txtminrental.getText();
        String max_rental = txtmaxrental.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (txtstartdate.getDate() == null || txtenddate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Date is required.");
            return;
        }
        String date1 = sdf.format(txtstartdate.getDate());
        
        String errormsg = "";
        
        if (!isNumeric(min_seat) || !isNumeric(max_seat)) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Seat number must be numeric.";
        } else if (!min_seat.isEmpty() && !max_seat.isEmpty()) {
            if (Integer.parseInt(min_seat)>Integer.parseInt(max_seat)) {
                errormsg += (!errormsg.isEmpty())? "\n" :"" + "Min seat number must be euqla or lower than max seat number.";
            }
        }
        
        if (!isNumeric(min_rental) || !isNumeric(max_rental)) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Rental must be numeric.";
        } else if (!min_rental.isEmpty() && !max_rental.isEmpty()) {
            if (Integer.parseInt(min_rental)>Integer.parseInt(max_rental)) {
                errormsg += (!errormsg.isEmpty())? "\n" :"" + "Min rental must be equal or lower than max rental.";
            }
        }
        
        if(!errormsg.isEmpty()) {
            JOptionPane.showMessageDialog(this, errormsg);
        } else {

            Date d1;
            Date d2;
            long difference_In_Time;
            try {
                d1 = sdf.parse(sdf.format(txtstartdate.getDate()));
                d2 = sdf.parse(sdf.format(txtenddate.getDate()));
                difference_In_Time = d2.getTime() - d1.getTime();

                diffdate = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
            } catch (Exception e) {
                diffdate=0;

            }

            SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
            startdate = sdf_date.format(txtstartdate.getDate());
            enddate = sdf_date.format(txtenddate.getDate());

            if (enddate.compareTo(startdate)<0) {
                JOptionPane.showMessageDialog(this, "End Date must be equal or later than Start Date");
            } else {
                DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
                df.setRowCount(0);

                try {
                    BufferedReader br = new BufferedReader(new FileReader("car.txt"));
                    String s="";
                    while ((s=br.readLine()) != null) {
                        String data[] = new String[5];
                        data = s.split(",");

                        if ((!carbrand.equals("Please Select") && !carbrand.equals(data[1])) 
                                || (!carmodel.equals("Please Select") && !carmodel.equals(data[2])) 
                                || (!transmission.isEmpty() && !transmission.equals(data[7]))
                                || (!min_seat.isEmpty() && Integer.parseInt(min_seat)>Integer.parseInt(data[5]))
                                || (!max_seat.isEmpty() && Integer.parseInt(max_seat)<Integer.parseInt(data[5]))
                                || (!min_rental.isEmpty() && Integer.parseInt(min_rental)>Integer.parseInt(data[9]))
                                || (!max_rental.isEmpty() && Integer.parseInt(max_rental)<Integer.parseInt(data[9]))
                                ) {
                            continue;
                        }

                        BufferedReader br_rental = new BufferedReader(new FileReader("rental_history.txt"));
                        String s2="";
                        String available = "Yes";
                        while ((s2=br_rental.readLine()) != null) {
                            String data_rental[] = new String[8];
                            data_rental = s2.split(",");

                            int start_compare_startdate = data_rental[2].compareTo(startdate);
                            int start_compare_enddate = startdate.compareTo(data_rental[3]);

                            int end_compare_startdate = data_rental[2].compareTo(enddate);
                            int end_compare_enddate = enddate.compareTo(data_rental[3]);

                            if (data_rental[1].equals(data[4]) && ((start_compare_startdate<=0 && start_compare_enddate<=0) || (end_compare_startdate<=0 && end_compare_enddate<=0))) {
                                available = "No";
                            }
                            lastid = Integer.parseInt(data_rental[0]);
                        }

                        Vector v2 = new Vector();
                        v2.add(data[1]);
                        v2.add(data[2]);
                        v2.add(data[4]);
                        v2.add(data[7]);
                        v2.add(data[5]);
                        v2.add(data[6]);
                        v2.add(data[9]);
                        v2.add(available);

                        df.addRow(v2);
                    }

                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcarbrand = new javax.swing.JComboBox<>();
        txtcarmodel = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        txtstartdate = new com.toedter.calendar.JDateChooser();
        txtenddate = new com.toedter.calendar.JDateChooser();
        btnbook = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chktransmission_auto = new javax.swing.JCheckBox();
        chktransmission_manual = new javax.swing.JCheckBox();
        txtmaxseat = new javax.swing.JTextField();
        txtminseat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtminrental = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtmaxrental = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Rental"));

        jLabel1.setText("Car Brand");

        jLabel2.setText("Car Model");

        jLabel3.setText("Start Date");

        jLabel4.setText("End Date");

        txtcarbrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtcarbrand.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtcarbrandItemStateChanged(evt);
            }
        });
        txtcarbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarbrandActionPerformed(evt);
            }
        });

        txtcarmodel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtcarmodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarmodelActionPerformed(evt);
            }
        });

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        txtstartdate.setMinSelectableDate(new Date());

        txtenddate.setMinSelectableDate(txtstartdate.getMinSelectableDate());

        btnbook.setText("Book");
        btnbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbookActionPerformed(evt);
            }
        });

        jLabel5.setText("Transmission");

        jLabel6.setText("Seats");

        jLabel7.setText("Rental (RM)");

        chktransmission_auto.setText("Automatic");
        chktransmission_auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chktransmission_autoActionPerformed(evt);
            }
        });

        chktransmission_manual.setText("Manual");

        txtmaxseat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaxseatActionPerformed(evt);
            }
        });

        txtminseat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtminseatActionPerformed(evt);
            }
        });

        jLabel8.setText("Min");

        jLabel9.setText("Max");

        jLabel10.setText("Min");

        txtminrental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtminrentalActionPerformed(evt);
            }
        });

        jLabel11.setText("Max");

        txtmaxrental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaxrentalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtstartdate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsearch)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnbook, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(chktransmission_auto)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(chktransmission_manual))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtminrental, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtmaxrental, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtminseat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtmaxseat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(3, 3, 3))))
                                .addComponent(txtcarmodel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtcarbrand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtenddate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcarbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcarmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chktransmission_auto)
                    .addComponent(chktransmission_manual))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmaxseat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtminseat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(txtminrental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtmaxrental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtstartdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtenddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbook, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand", "Model", "No Plate", "Transmission", "Seats", "Petrol", "Rental (RM)", "Available"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDefaultEditor(Object.class, null);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcarbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarbrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcarbrandActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        TableUpdate();
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtcarmodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarmodelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcarmodelActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btncancelActionPerformed

    private void txtcarbrandItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtcarbrandItemStateChanged
        // TODO add your handling code here:
        LoadCarModel(String.valueOf(txtcarbrand.getSelectedItem()));
    }//GEN-LAST:event_txtcarbrandItemStateChanged

    private void btnbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbookActionPerformed
        // TODO add your handling code here:
        
        int row = jTable1.getSelectedRow();
        
        if (row==-1) {
            JOptionPane.showMessageDialog(this, "Please select the car from the table");
        } else {
            String carbrandtxt = jTable1.getModel().getValueAt(row, 0).toString();
            String carmodeltxt = jTable1.getModel().getValueAt(row, 1).toString();
            String carplatetxt = jTable1.getModel().getValueAt(row, 2).toString();
            String rentaltxt = jTable1.getModel().getValueAt(row, 6).toString();
            String availabilitytxt = jTable1.getModel().getValueAt(row, 7).toString();

            if (availabilitytxt.equals("No")) {
                JOptionPane.showMessageDialog(this, "This car is not available during this selected date");
            } else {
                setBooking(lastid, carbrandtxt, carmodeltxt, carplatetxt, startdate, enddate, diffdate, rentaltxt);

                Payment payment = new Payment();
                this.hide();
                payment.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnbookActionPerformed

    private void chktransmission_autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chktransmission_autoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chktransmission_autoActionPerformed

    private void txtmaxseatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaxseatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaxseatActionPerformed

    private void txtminseatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtminseatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtminseatActionPerformed

    private void txtminrentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtminrentalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtminrentalActionPerformed

    private void txtmaxrentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaxrentalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaxrentalActionPerformed

    public boolean makePayment() {
        try
        {
            File f =new File("rental_history.txt");
            PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            Date date = new Date();  
            pw.append((lastid+1)+","+formatter.format(date)+","+carplate+","+startdate+","+enddate+","+user_info.email+","+user_info.firstname+","+user_info.lastname+","+user_info.icnumber+","+(Integer.parseInt(rental)*diffdate)+",Paid\n");
            pw.close();
            JOptionPane.showMessageDialog(this, "Paid and Booked Successfully");
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            return false;
        }
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
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbook;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnsearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox chktransmission_auto;
    private javax.swing.JCheckBox chktransmission_manual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtcarbrand;
    private javax.swing.JComboBox<String> txtcarmodel;
    private com.toedter.calendar.JDateChooser txtenddate;
    private javax.swing.JTextField txtmaxrental;
    private javax.swing.JTextField txtmaxseat;
    private javax.swing.JTextField txtminrental;
    private javax.swing.JTextField txtminseat;
    private com.toedter.calendar.JDateChooser txtstartdate;
    // End of variables declaration//GEN-END:variables
}
