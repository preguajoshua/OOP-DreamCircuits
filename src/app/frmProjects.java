/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author preguajoshua
 */
public class frmProjects extends javax.swing.JFrame {

    /**
     * Creates new form Projects
     */
    public frmProjects() {
        initComponents();
        txtProjectID.setEditable(false);
        if(SQLite.openDB()){
            String[][] data = SQLite.read("tblClient");
            String[] column = {"ID","First Name","Middle Name","Last Name"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblProjects.setModel(model);
            
            
            
            String[][] data1 = SQLite.read("tblProjects");
            String[] column1 = {"projectID","projectName","projectDescription","projectDate","firstName","lastName","cost"};
            javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(data1, column1);
            this.tblClient.setModel(model1);
            
            SQLite.closeDB();
        }
        this.refreshClient();
        this.refreshProjects();
    }

    
     public void refreshClient(){
        //Load data
        if(SQLite.openDB()){
            String[] columns = {"clientID", "firstName","middleName","lastName","contactNo","clientAddress"};
            String[][] records = SQLite.read("tblClient",columns);
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(records, columns);
            this.tblClient.setModel(model);
            
            //Additional COde Snippets for JTABLE behavior
            ListSelectionListener lsl = new ListSelectionListener(){
                public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                    if (tblClient.getSelectedRow() > -1) {
                        int row = tblClient.getSelectedRow();
                        //JOptionPane.showMessageDialog(null, "Row is " + row);
                        if(SQLite.openDB()){
                            String sr_id = tblClient.getValueAt(tblClient.getSelectedRow(), 0).toString();
                            int id = Integer.parseInt(sr_id);
                            String[][] result = SQLite.read("tblClient", "clientID=" + id);
                            txtFirstName.setText(result[0][1]);
                            txtLastName.setText(result[0][3]);
//                            String date = result[0][7];
//                            try {
//                                java.util.Date date2 = new SimpleDateFormat("MMM dd, yyy").parse(date);
//                                dcDate.setDate(date2);
//                            } catch (ParseException ex) {
//                                Logger.getLogger(stockIn.class.getName()).log(Level.SEVERE, null, ex);
//                            }
                            SQLite.closeDB();
                        }
                    }
                }
            };
            this.tblClient.getSelectionModel().addListSelectionListener(lsl);
            
            SQLite.closeDB();
        }        
    }
     public void refreshProjects(){
        //Load data
        if(SQLite.openDB()){
            String[][] data1 = SQLite.read("tblProjects");
            String[] column1 = {"projectID","projectName","projectDescription","projectDate","firstName","lastName","cost"};
            javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(data1, column1);
            this.tblProjects.setModel(model1);
            
            //Additional COde Snippets for JTABLE behavior
            ListSelectionListener lsl = new ListSelectionListener(){
                public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                    if (tblProjects.getSelectedRow() > -1) {
                        int row = tblProjects.getSelectedRow();
                        //JOptionPane.showMessageDialog(null, "Row is " + row);
                        if(SQLite.openDB()){
                            String sr_id = tblProjects.getValueAt(tblProjects.getSelectedRow(), 0).toString();
                            int id = Integer.parseInt(sr_id);
                            String[][] result = SQLite.read("tblProjects", "projectID=" + id);
                            txtProjectID.setText(result[0][0]);
                            txtProjectName.setText(result[0][1]);
                            txtDescription.setText(result[0][2]);
                            String date = result[0][3];
                            try {
                                java.util.Date date2 = new SimpleDateFormat("MMM dd, yyy").parse(date);
                                dcDate.setDate(date2);
                            } catch (ParseException ex) {
                                Logger.getLogger(frmStockIn.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            txtFirstName.setText(result[0][4]);
                            txtLastName.setText(result[0][5]);
                            txtCost.setText(result[0][6]);
                            SQLite.closeDB();
                        }
                    }
                }
            };
            this.tblProjects.getSelectionModel().addListSelectionListener(lsl);
            
            SQLite.closeDB();
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

        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtProjectName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        dcDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjects = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txtProjectID = new javax.swing.JTextField();
        txtKey = new javax.swing.JTextField();
        cmbClient = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/project(64).png"))); // NOI18N
        jLabel1.setText("ADD PROJECT");

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(0, 102, 102));

        jButton2.setText("First Name");

        jButton3.setText("Last Name");

        jButton4.setText("Estimated Cost");

        jButton5.setText("Project Name");

        jButton7.setText("Description");

        jButton6.setText("Date");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CLIENT INFORMATION");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addplus.png"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/three-circling-arrows.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(33, 33, 33))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton5)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(5, 5, 5)
                .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtFirstName)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnUpdate)
                        .addComponent(btnDelete)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton11))
                .addContainerGap())
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/error.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        tblProjects.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProjects);

        tblClient.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblClient);

        jButton1.setText("CLIENT");

        jButton8.setText("PROJECTS");

        txtKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeyActionPerformed(evt);
            }
        });
        txtKey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeyKeyTyped(evt);
            }
        });

        cmbClient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ClientID", "FirstName", "MiddleName", "LastName" }));
        cmbClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbClient, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton8)
                                .addComponent(txtProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(cmbClient)
                            .addComponent(txtKey))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        SQLite.openDB();
        try{
        String projectName = this.txtProjectName.getText();
        String description = this.txtDescription.getText();
        String date = DatePick.dcGetDate(dcDate);
        String firstName = this.txtFirstName.getText();
        String lastName = this.txtLastName.getText();
        float cost = Float.parseFloat(this.txtCost.getText());
        
        String sql1 = "NULL"+","+"'"+projectName+"'"+","+"'"+description+"'"+","+"'"+date+"'"+","+"'"+firstName+"'"+","+"'"+lastName+"'"+","+cost;
        
        if(SQLite.create("tblProjects", sql1)){
            JOptionPane.showMessageDialog(null, "Project Added Successfully!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Cannot add Project, Project already exist!");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        SQLite.closeDB();
        this.refreshProjects();
        this.refreshClient();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(SQLite.openDB()){
            int projectID = Integer.parseInt(this.txtProjectID.getText());
            String projectName = this.txtProjectName.getText();
            String description = this.txtDescription.getText();
            String date = DatePick.dcGetDate(dcDate);
            String firstName = this.txtFirstName.getText();
            String lastName = this.txtLastName.getText();
            double cost = Double.parseDouble(this.txtCost.getText());
            String values  = "projectName="+ "'"+projectName +"'" +"," + "description="+"'"+description+"'" +","+"projectDate="+"'"+date+"'"+","+"firstName="+"'"+firstName+"'"+","+"lastName="+"'"+lastName+"'"+","+"cost="+cost;
            String sql = "UPDATE TABLE tblProjecrs SET("+values+") WHERE projectID="+projectID+"";
            System.out.println("QUERY IS " + sql);
            if(SQLite.updateProjects("tblProjects", values ,projectID)){
                JOptionPane.showMessageDialog(null, "Project updated Successfully!");
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR! Cannot update Project!");
            }
            
        }
        this.refreshClient();
        this.refreshProjects();
        SQLite.closeDB();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you wanted to delete this Project?", "DELETE PROJECT", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if(x==0){
            if(SQLite.openDB()){
                int projectID = Integer.parseInt(this.txtProjectID.getText());
                String table = "tblProjects";
                if(SQLite.deleteProject(table, projectID)) {
                    JOptionPane.showMessageDialog(null, "PROJECT HAS BEEN DELETED!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "PROJECT CANNOT BE DELETED!");
                }
            }
        }
        else if(x==1){
            return;
        }
        else{
            return;
        }
        this.refreshClient();
        this.refreshProjects();
        SQLite.closeDB();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        this.txtCost.setText("");
        this.txtDescription.setText("");
        this.txtFirstName.setText("");
        this.txtLastName.setText("");
        this.txtProjectID.setText("");
        this.txtProjectName.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeyActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtKeyActionPerformed

    private void txtKeyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyKeyTyped
        // TODO add your handling code here:
        String[] column = {"clientID", "firstName", "middleName","lastName"};
        String search = txtKey.getText();
        String cmboSearch = this.cmbClient.getSelectedItem().toString();

        if(cmboSearch.equals("ClientID")){
            try{
                if(SQLite.openDB()){
                    String query = "clientID LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblClient", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblProjects.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

        else if(cmboSearch.equals("FirstName")){
            try{
                if(SQLite.openDB()){
                    String query = " firstName LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblClient", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblProjects.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

        else if(cmboSearch.equals("MiddleName")){
            try{
                if(SQLite.openDB()){
                    String query = "middleName LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblClients", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblProjects.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

        else if(cmboSearch.equals("LastName")){
            try{
                if(SQLite.openDB()){
                    String query = "lastName LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblClients", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblProjects.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

    }//GEN-LAST:event_txtKeyKeyTyped

    private void cmbClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClientActionPerformed

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
            java.util.logging.Logger.getLogger(frmProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProjects().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbClient;
    private com.toedter.calendar.JDateChooser dcDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tblClient;
    private javax.swing.JTable tblProjects;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtProjectID;
    private javax.swing.JTextField txtProjectName;
    // End of variables declaration//GEN-END:variables
}
