/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





/**
 *
 * @author aunishah
 */
public class Admin_Host extends javax.swing.JFrame {

    private String date1, date2;
    private int row, column;
    private static int uid = 1001;
    private int hostId;
    
    
    /**
     * Creates new form Admin_Host
     */
    public Admin_Host() {
        initComponents();
        
        hostId = uid++;
        String hostIDInString = "H" +Integer.toString(hostId);
        lbl_hIDno.setText(hostIDInString);
        
        //set size of column
        host_data.getColumnModel().getColumn(0).setPreferredWidth(50);
        host_data.getColumnModel().getColumn(1).setPreferredWidth(100);
        host_data.getColumnModel().getColumn(2).setPreferredWidth(100);
        host_data.getColumnModel().getColumn(3).setPreferredWidth(100);
        host_data.getColumnModel().getColumn(4).setPreferredWidth(90);
        host_data.getColumnModel().getColumn(5).setPreferredWidth(80);
        host_data.getColumnModel().getColumn(6).setPreferredWidth(50);
        host_data.getColumnModel().getColumn(7).setPreferredWidth(50);
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupZshield = new javax.swing.ButtonGroup();
        btnGroupZtrack = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        hostFnameLbl = new javax.swing.JLabel();
        hostLnameLbl = new javax.swing.JLabel();
        hostIdentityLbl = new javax.swing.JLabel();
        hostLicenseLbl = new javax.swing.JLabel();
        ZShieldLbl = new javax.swing.JLabel();
        deleteHostBtn = new javax.swing.JButton();
        updateHostBtn = new javax.swing.JButton();
        saveHostBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        host_data = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        homeBtn = new javax.swing.JButton();
        registerCar = new javax.swing.JLabel();
        hostLogo = new javax.swing.JLabel();
        zLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        hostLastName = new javax.swing.JTextField();
        hostIdentity = new javax.swing.JTextField();
        hostFirstName = new javax.swing.JTextField();
        DateFrom_license = new com.toedter.calendar.JDateChooser();
        DateTo_license = new com.toedter.calendar.JDateChooser();
        hostValidLbl = new javax.swing.JLabel();
        dateFromLbl = new javax.swing.JLabel();
        dateToLbl = new javax.swing.JLabel();
        ZtrackLbl = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        zshieldNo = new javax.swing.JRadioButton();
        ztrackNo = new javax.swing.JRadioButton();
        zshieldYes = new javax.swing.JRadioButton();
        ztrackYes = new javax.swing.JRadioButton();
        resetBtn = new javax.swing.JButton();
        IDlbl = new javax.swing.JLabel();
        lbl_hIDno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[Z] Z's HOSTS");
        setLocation(new java.awt.Point(325, 95));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(810, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hostFnameLbl.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        hostFnameLbl.setForeground(new java.awt.Color(66, 63, 63));
        hostFnameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostFnameLbl.setText("First name");
        jPanel1.add(hostFnameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        hostLnameLbl.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        hostLnameLbl.setForeground(new java.awt.Color(66, 63, 63));
        hostLnameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostLnameLbl.setText("Last name");
        jPanel1.add(hostLnameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        hostIdentityLbl.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        hostIdentityLbl.setForeground(new java.awt.Color(66, 63, 63));
        hostIdentityLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hostIdentityLbl.setText("NRIC");
        jPanel1.add(hostIdentityLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 60, -1));

        hostLicenseLbl.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        hostLicenseLbl.setForeground(new java.awt.Color(66, 63, 63));
        hostLicenseLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostLicenseLbl.setText("Driving license");
        jPanel1.add(hostLicenseLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 100, -1));

        ZShieldLbl.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        ZShieldLbl.setForeground(new java.awt.Color(66, 63, 63));
        ZShieldLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ZShieldLbl.setText("Z Shield?");
        jPanel1.add(ZShieldLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, 40));

        deleteHostBtn.setBackground(new java.awt.Color(255, 105, 97));
        deleteHostBtn.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        deleteHostBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteHostBtn.setText("Delete");
        deleteHostBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteHostBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteHostBtnMouseClicked(evt);
            }
        });
        jPanel1.add(deleteHostBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 70, 30));

        updateHostBtn.setBackground(new java.awt.Color(255, 255, 255));
        updateHostBtn.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        updateHostBtn.setForeground(new java.awt.Color(66, 63, 63));
        updateHostBtn.setText("Update");
        updateHostBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        updateHostBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateHostBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateHostBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 70, 30));

        saveHostBtn.setBackground(new java.awt.Color(252, 205, 146));
        saveHostBtn.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        saveHostBtn.setForeground(new java.awt.Color(66, 63, 63));
        saveHostBtn.setText("Save");
        saveHostBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        saveHostBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveHostBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveHostBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 70, 30));

        host_data.setBackground(new java.awt.Color(255, 255, 255));
        host_data.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        host_data.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        host_data.setForeground(new java.awt.Color(66, 63, 63));
        host_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "NRIC", "Date valid from", "Date valid to ", "Z Shield", "Z Track"
            }
        ));
        host_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                host_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(host_data);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 670, 190));

        jPanel3.setBackground(new java.awt.Color(198, 225, 176));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeBtn.setBackground(new java.awt.Color(252, 205, 146));
        homeBtn.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(66, 63, 63));
        homeBtn.setText("HOME");
        homeBtn.setBorder(null);
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        jPanel3.add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 60, 30));

        registerCar.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        registerCar.setForeground(new java.awt.Color(66, 63, 63));
        registerCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerCar.setText("Register car");
        registerCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerCarMouseClicked(evt);
            }
        });
        jPanel3.add(registerCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        hostLogo.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        hostLogo.setForeground(new java.awt.Color(249, 255, 245));
        hostLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostLogo.setText("HOST");
        hostLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hostLogoMouseClicked(evt);
            }
        });
        jPanel3.add(hostLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        zLogo.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        zLogo.setForeground(new java.awt.Color(249, 255, 245));
        zLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zLogo.setText("Z");
        jPanel3.add(zLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 10, 20, -1));

        jSeparator1.setForeground(new java.awt.Color(66, 63, 63));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 10));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 510));

        hostLastName.setBackground(new java.awt.Color(255, 255, 255));
        hostLastName.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        hostLastName.setForeground(new java.awt.Color(66, 63, 63));
        hostLastName.setBorder(null);
        hostLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostLastNameFocusGained(evt);
            }
        });
        jPanel1.add(hostLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 180, -1));

        hostIdentity.setBackground(new java.awt.Color(255, 255, 255));
        hostIdentity.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        hostIdentity.setForeground(new java.awt.Color(66, 63, 63));
        hostIdentity.setBorder(null);
        jPanel1.add(hostIdentity, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 180, -1));

        hostFirstName.setBackground(new java.awt.Color(255, 255, 255));
        hostFirstName.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        hostFirstName.setForeground(new java.awt.Color(66, 63, 63));
        hostFirstName.setBorder(null);
        hostFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostFirstNameFocusGained(evt);
            }
        });
        jPanel1.add(hostFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 180, 20));

        DateFrom_license.setForeground(new java.awt.Color(66, 63, 63));
        DateFrom_license.setDateFormatString("dd-MM-yyyy");
        DateFrom_license.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        jPanel1.add(DateFrom_license, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 130, -1));

        DateTo_license.setForeground(new java.awt.Color(66, 63, 63));
        DateTo_license.setDateFormatString("dd-MM-yyyy");
        DateTo_license.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        jPanel1.add(DateTo_license, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 130, -1));

        hostValidLbl.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        hostValidLbl.setForeground(new java.awt.Color(66, 63, 63));
        hostValidLbl.setText("Validity");
        jPanel1.add(hostValidLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        dateFromLbl.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        dateFromLbl.setForeground(new java.awt.Color(66, 63, 63));
        dateFromLbl.setText("From");
        jPanel1.add(dateFromLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        dateToLbl.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        dateToLbl.setForeground(new java.awt.Color(66, 63, 63));
        dateToLbl.setText("To");
        jPanel1.add(dateToLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, 20));

        ZtrackLbl.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        ZtrackLbl.setForeground(new java.awt.Color(66, 63, 63));
        ZtrackLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ZtrackLbl.setText("Z Track?");
        jPanel1.add(ZtrackLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 70, 30));

        jSeparator3.setForeground(new java.awt.Color(66, 63, 63));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 180, -1));

        jSeparator4.setForeground(new java.awt.Color(66, 63, 63));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 180, -1));

        jSeparator5.setForeground(new java.awt.Color(66, 63, 63));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 180, -1));

        zshieldNo.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupZshield.add(zshieldNo);
        zshieldNo.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        zshieldNo.setForeground(new java.awt.Color(66, 63, 63));
        zshieldNo.setText("No");
        zshieldNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zshieldNoActionPerformed(evt);
            }
        });
        jPanel1.add(zshieldNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, -1));

        ztrackNo.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupZtrack.add(ztrackNo);
        ztrackNo.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        ztrackNo.setForeground(new java.awt.Color(66, 63, 63));
        ztrackNo.setText("No");
        ztrackNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ztrackNoActionPerformed(evt);
            }
        });
        jPanel1.add(ztrackNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        zshieldYes.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupZshield.add(zshieldYes);
        zshieldYes.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        zshieldYes.setForeground(new java.awt.Color(66, 63, 63));
        zshieldYes.setText("Yes");
        zshieldYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zshieldYesActionPerformed(evt);
            }
        });
        jPanel1.add(zshieldYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        ztrackYes.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupZtrack.add(ztrackYes);
        ztrackYes.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        ztrackYes.setForeground(new java.awt.Color(66, 63, 63));
        ztrackYes.setText("Yes");
        ztrackYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ztrackYesActionPerformed(evt);
            }
        });
        jPanel1.add(ztrackYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, -1));

        resetBtn.setBackground(new java.awt.Color(198, 225, 176));
        resetBtn.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(66, 63, 63));
        resetBtn.setText("Reset");
        resetBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        jPanel1.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 70, 30));

        IDlbl.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        IDlbl.setForeground(new java.awt.Color(66, 63, 63));
        IDlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IDlbl.setText("ID");
        jPanel1.add(IDlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, -1, -1));

        lbl_hIDno.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        lbl_hIDno.setForeground(new java.awt.Color(66, 63, 63));
        jPanel1.add(lbl_hIDno, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 70, 20));

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

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        Admin_Home_Page acc = new Admin_Home_Page();
        acc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void registerCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerCarMouseClicked
        Admin_Cars regCar = new Admin_Cars();
        regCar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerCarMouseClicked

    private void saveHostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveHostBtnActionPerformed

        
        //to format the date and display on the Jtable (host_data)
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        date1 = dFormat.format(DateFrom_license.getDate());
        date2 = dFormat.format(DateTo_license.getDate());
       
        //to get the table
        DefaultTableModel host_table = (DefaultTableModel)this.host_data.getModel();
        //to add row
        host_table.addRow(new Object[]{this.lbl_hIDno.getText(),this.hostFirstName.getText(),this.hostLastName.getText(),this.hostIdentity.getText(),date1,date2,
        this.btnGroupZshield.getSelection().getActionCommand(),this.btnGroupZtrack.getSelection().getActionCommand()});
        
        String filepath = "src/main/java/database/host.txt";
        File file = new File(filepath);
        
        if ((!hostFirstName.equals(" ") && (hostFirstName.equals("[a-zA-Z]+")) || (!hostLastName.equals(" ")) && (hostFirstName.equals("[a-zA-Z]+")) || (!hostIdentity.equals(" ")) && (hostIdentity.equals("[0-9]+")) || (date1 != null) || (date2 != null) || (!btnGroupZshield.equals(" "))) || !btnGroupZtrack.equals(" "))
        {
            try {
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i = 0; i < host_data.getRowCount(); i++ ){
                
                for(int j = 0; j <host_data.getColumnCount(); j++){ //rows
                    bw.write(host_data.getValueAt(i , j).toString() + ",");//columns
                        
                }
                bw.newLine();
            
            }
            JOptionPane.showMessageDialog(this, "Saved");
            
            bw.flush(); //to clear whatever in buffered writer stream
            bw.close();
            fw.close();
     
        } catch (IOException ex) {
            Logger.getLogger(Admin_Host.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //auto generate ID when saved
        hostId = uid++;
        String hostIDInString = "H" +Integer.toString(hostId);
        lbl_hIDno.setText(hostIDInString);
        }
        
        else
        {
            JOptionPane.showMessageDialog(this, "Please make sure all fields are not empty and entered correctly.");
        }
    
        
        
    }//GEN-LAST:event_saveHostBtnActionPerformed

    private void zshieldYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zshieldYesActionPerformed
        //to get the selected value'yes' return as text in Jtable
        this.zshieldYes.setActionCommand("Yes");
    }//GEN-LAST:event_zshieldYesActionPerformed

    private void zshieldNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zshieldNoActionPerformed
        //to get the selected value 'no' return as text in Jtable
        this.zshieldNo.setActionCommand("No");
    }//GEN-LAST:event_zshieldNoActionPerformed

    private void ztrackYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ztrackYesActionPerformed
        // to get the selected value'yes' return as text in Jtable
        this.ztrackYes.setActionCommand("Yes");
    }//GEN-LAST:event_ztrackYesActionPerformed

    private void ztrackNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ztrackNoActionPerformed
        // to get the selected value 'no' return as text in Jtable
        this.ztrackNo.setActionCommand("No");
    }//GEN-LAST:event_ztrackNoActionPerformed

    private void hostFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostFirstNameFocusGained
        hostFirstName.setText("");
    }//GEN-LAST:event_hostFirstNameFocusGained

    private void hostLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostLastNameFocusGained
        hostLastName.setText("");
    }//GEN-LAST:event_hostLastNameFocusGained

    private void host_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_host_dataMouseClicked
        //To get any number of row or column to get it clicked so that it could be
        //update or delete
        
        // get value when point, and store the value in this.row / this.column
        this.row = this.host_data.getSelectedRow();
        this.column = this.host_data.columnAtPoint(evt.getPoint());
        
        //means that it's a valid row not just anywhere
        if(row >= 0) {
            //to get the value, set to text
            String idNum = this.host_data.getModel().getValueAt(this.row,0).toString();
            this.lbl_hIDno.setText(idNum);
            String fname = this.host_data.getModel().getValueAt(this.row,1).toString();  
            this.hostFirstName.setText(fname);
            String lname = this.host_data.getModel().getValueAt(this.row,2).toString();  
            this.hostLastName.setText(lname);
            String IC = this.host_data.getModel().getValueAt(this.row,3).toString();  
            this.hostIdentity.setText(IC);
            try 
            {
                Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(this.host_data.getModel().getValueAt(this.row,4).toString());
                DateFrom_license.setDate(date1);
                Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(this.host_data.getModel().getValueAt(this.row,5).toString());
                DateTo_license.setDate(date2);
            } 
            catch (ParseException ex) 
            {
                Logger.getLogger(Admin_Host.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String Zshield = this.host_data.getModel().getValueAt(this.row,6).toString();
            if (Zshield.equals("Yes"))
            {
                zshieldYes.setSelected(true);
            }
            else
            {
                zshieldNo.setSelected(true);
            }
            String Ztrack = this.host_data.getModel().getValueAt(this.row,7).toString();
            if (Ztrack.equals("Yes"))
            {
                ztrackYes.setSelected(true);
            }
            else
            {
                ztrackNo.setSelected(true);
            }
        } 
    }//GEN-LAST:event_host_dataMouseClicked

    private void updateHostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateHostBtnActionPerformed
        // to get the value and set the value
        DefaultTableModel host_table = (DefaultTableModel)this.host_data.getModel();
        int i = host_data.getSelectedRow();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        date1 = dFormat.format(DateFrom_license.getDate());
        date2 = dFormat.format(DateTo_license.getDate());
       
        if (i >= 0)
        {
            host_table.setValueAt(this.lbl_hIDno.getText(),i,0);
            host_table.setValueAt(this.hostFirstName.getText(), i, 1);
            host_table.setValueAt(this.hostLastName.getText(),i, 2);
            host_table.setValueAt(this.hostIdentity.getText(),i,3);
            host_table.setValueAt(this.date1,i,4);
            host_table.setValueAt(this.date2,i,5);
            host_table.setValueAt(this.btnGroupZshield.getSelection().getActionCommand(),i,6);
            host_table.setValueAt(this.btnGroupZtrack.getSelection().getActionCommand(),i,7);       
        }
            
       
       String filepath = "src/main/java/database/host.txt";
       File file = new File(filepath);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(i = 0; i < host_data.getRowCount(); i++ )
            {
                
                for(int j = 0; j <host_data.getColumnCount(); j++)
                { //rows
                    bw.write(host_data.getValueAt(i , j).toString() + ",");//columns
                        
                }
                bw.newLine();
            
            }
            bw.flush(); //to clear whatever in buffered writer stream
            bw.close();
            fw.close();
     
        }
        
        catch (IOException ex) 
        {
            Logger.getLogger(Admin_Host.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }//GEN-LAST:event_updateHostBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        //reset
        hostFirstName.setText("");
        hostLastName.setText("");
        hostIdentity.setText("");
        DateFrom_license.setCalendar(null);
        DateTo_license.setCalendar(null);
        btnGroupZshield.clearSelection();
        btnGroupZtrack.clearSelection();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void hostLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hostLogoMouseClicked
        String filePath = "src/main/java/database/host.txt";
        File file = new File(filePath);
        
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            DefaultTableModel model = (DefaultTableModel)host_data.getModel();
            Object[] lines = br.lines().toArray();
            
            for (int i = 0; i < lines.length; i++)
            {
                String [] row = lines[i].toString().split("[,\n]");
                model.addRow(row);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin_Host.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_hostLogoMouseClicked

    private void deleteHostBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteHostBtnMouseClicked
          // To delete row from the table and in txt file
       String filePath = "src/main/java/database/host.txt";
       File file = new File(filePath);
       DefaultTableModel host_table = (DefaultTableModel)this.host_data.getModel();
       
       this.row = this.host_data.rowAtPoint(evt.getPoint()); 
       this.column = this.host_data.columnAtPoint(evt.getPoint());
       try
       {
           BufferedWriter out = new BufferedWriter(new FileWriter(file)); // no longer append;
           for(int i=0; i<row; i++){
               for(int j=0; j<column; j++){
               Object data = host_table.getValueAt(i,j);   
               out.write(data+":");
           }   
           }
           out.close(); // to make sure the file connection is dropped
       }
       catch (IOException e) {
           System.out.println(e);
       }
       ((DefaultTableModel)this.host_data.getModel()).removeRow(this.row);
    }//GEN-LAST:event_deleteHostBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Admin_Host.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Host.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Host.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Host.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin_Host().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFrom_license;
    private com.toedter.calendar.JDateChooser DateTo_license;
    private javax.swing.JLabel IDlbl;
    private javax.swing.JLabel ZShieldLbl;
    private javax.swing.JLabel ZtrackLbl;
    private javax.swing.ButtonGroup btnGroupZshield;
    private javax.swing.ButtonGroup btnGroupZtrack;
    private javax.swing.JLabel dateFromLbl;
    private javax.swing.JLabel dateToLbl;
    private javax.swing.JButton deleteHostBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JTextField hostFirstName;
    private javax.swing.JLabel hostFnameLbl;
    private javax.swing.JTextField hostIdentity;
    private javax.swing.JLabel hostIdentityLbl;
    private javax.swing.JTextField hostLastName;
    private javax.swing.JLabel hostLicenseLbl;
    private javax.swing.JLabel hostLnameLbl;
    private javax.swing.JLabel hostLogo;
    private javax.swing.JLabel hostValidLbl;
    private javax.swing.JTable host_data;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_hIDno;
    private javax.swing.JLabel registerCar;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveHostBtn;
    private javax.swing.JButton updateHostBtn;
    private javax.swing.JLabel zLogo;
    private javax.swing.JRadioButton zshieldNo;
    private javax.swing.JRadioButton zshieldYes;
    private javax.swing.JRadioButton ztrackNo;
    private javax.swing.JRadioButton ztrackYes;
    // End of variables declaration//GEN-END:variables

    private void setActionCommand(String yes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
