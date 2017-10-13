/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author preguajoshua
 */
public class frmEditTable extends javax.swing.JFrame {

    /**
     * Creates new form Transaction
     */
    public frmEditTable() {
        initComponents();
        txtItemNo.setEditable(false);
        if(SQLite.openDB()){
            String[][] data = SQLite.read("tblItem");
            String[] column = {"itemID", "itemName","description","price","categoryNumber","brandNo", "serialNo","quantity","supplier","status"};
            
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column){
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };
            
            this.tblItem.setModel(model);
            SQLite.closeDB();
        }
        this.FillCombo();
        this.refreshTable();
    }
    public void FillCombo(){
        try{
            if(SQLite.openDB()){
                String[][] data = SQLite.read("tblCategory");
                String sql = "SELECT * FROM tblCategory";
                
                for(int i=0;i<data.length;i++){
                    for(int j=0; j<data.length; j++){
                        if(j==1){
                            cmbCategory.addItem(data[i][j]);
                        }
                    }
                }
                String[][] data1 = SQLite.read("tblBrand");
                
                for(int b=0;b<data1.length;b++){
                    for(int a=0; a<data1.length; a++){
                        if(a==1){
                            cmbBrand.addItem(data1[b][a]);
                        }
                    }
                }
                
                String[][] data3 = SQLite.read("tblSuppliers");
                for(int p=0;p<data3.length;p++){
                    for(int b=0; b<data3.length; b++){
                        if(b==1){
                            cmbSupplier.addItem(data3[p][b]);
                        }
                    }
                }
                
//                String x;
//                for(int i=0;i<=100;i++){
//                    x = Integer.toString(i);
//                    cmbQuantity.addItem(x);
//                }
                
                String[][] data2 = SQLite.read("tblSuppliers");
                for(int i=0;i<data2.length;i++){
                    for(int j=0; j<data2.length; j++){
                        if(j==1){
                            cmbSupplier.addItem(data2[i][j]);
                        }
                    }
                }
                
            
            }
            SQLite.closeDB();
            
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void refreshTable(){
        //Load data
        if(SQLite.openDB()){
            String[] columns = {"itemID", "itemName","description","price","categoryNumber","brandNo", "serialNo","quantity","supplier","status"};
            String[][] records = SQLite.read("tblItem",columns);
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(records, columns){
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };
            this.tblItem.setModel(model);
            
            //Additional COde Snippets for JTABLE behavior
            ListSelectionListener lsl = new ListSelectionListener(){
                public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                    if (tblItem.getSelectedRow() > -1) {
                        int row = tblItem.getSelectedRow();
                        //JOptionPane.showMessageDialog(null, "Row is " + row);
                        if(SQLite.openDB()){
                            String sr_id = tblItem.getValueAt(tblItem.getSelectedRow(), 0).toString();
                            int id = Integer.parseInt(sr_id);
                            String[][] result = SQLite.read("tblItem", "itemID=" + id);
                            txtItemNo.setText(result[0][0]);
                            txtName.setText(result[0][1]);
                            txtDescription.setText(result[0][2]);
                            txtPrice.setText(result[0][3]);
                            cmbCategory.setSelectedItem(result[0][4]);
                            cmbBrand.setSelectedItem(result[0][5]);
                            
                            txtSerialNumber.setText(result[0][6]);
                            cmbSupplier.setSelectedItem(result[0][8]);
                            txtStatus.setText(result[0][9]);
                            SQLite.closeDB();
                        }
                    }
                }
            };
            this.tblItem.getSelectionModel().addListSelectionListener(lsl);
            
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtSerialNumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtItemNo = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        cmbCategory = new javax.swing.JComboBox<>();
        cmbBrand = new javax.swing.JComboBox<>();
        cmbSupplier = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cmbSearch = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/table.png"))); // NOI18N
        jLabel9.setText("EDIT TABLE");

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addplus.png"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

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

        jButton1.setText("Item No");

        jButton2.setText("Item Name");

        jButton3.setText("Description");

        jButton4.setText("Price");

        jButton5.setText("Category");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Brand");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("Serial Number");

        jButton9.setText("Supplier");

        jButton10.setText("Status");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/three-circling-arrows.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(txtSerialNumber)
                            .addComponent(txtPrice)
                            .addComponent(txtItemNo)
                            .addComponent(cmbBrand, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(txtSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(jButton11)))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblItem);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "itemNo", "itemName", "Category", "Brand", "Status" }));
        cmbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/error.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(SQLite.openDB()){
            String name = this.txtName.getText();
            String description = this.txtDescription.getText();
            int price = Integer.parseInt(this.txtPrice.getText());
            String serialNo = this.txtSerialNumber.getText();
            String category = cmbCategory.getSelectedItem().toString();
            String brand = cmbBrand.getSelectedItem().toString();
            String status = this.txtStatus.getText();
            String supplier = cmbSupplier.getSelectedItem().toString();
            int quantity = 1;
            String values  = "NULL"+","+"'"+name +"'" +"," + "'" + description + "'" +","+ price + ","  +"'"+ category +"'"+ "," + "'" + brand+ "'" +","+"'"+serialNo+"'"+","+quantity+","+"'"+supplier+"'"+","+"'"+status+"'";

            String sql = "INSERT INTO tblItem VALUES ("+values+")";
            System.out.println("QUERY IS " + sql);
            if(SQLite.create("tblItem", values)){
                JOptionPane.showMessageDialog(null, "Item Added Successfully!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Item already exist!");
            }

        }
        this.refreshTable();
        SQLite.closeDB();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(SQLite.openDB()){
            String name = this.txtName.getText();
            String description = this.txtDescription.getText();
            int price = Integer.parseInt(this.txtPrice.getText());
            String serialNo = this.txtSerialNumber.getText();
            String category = cmbCategory.getSelectedItem().toString();
            String brand = cmbBrand.getSelectedItem().toString();
            String status = this.txtStatus.getText();
            String supplier = cmbSupplier.getSelectedItem().toString();
            //            int quantity = Integer.parseInt(cmbQuantity.getSelectedItem().toString());
            int itemNo = Integer.parseInt(this.txtItemNo.getText());
            String values  = "itemName="+ "'"+name +"'" +"," + "description="+"'"+description+"'" +","+ "price= "+price+","+"categoryNumber="+"'"+category+"'"+"," +"brandNo="+"'"+brand+"'"+","+"serialNo="+"'"+serialNo+"'"+","+"supplier="+"'"+supplier+"'"+","+"Status="+"'"+status+"'";

            String sql = "UPDATE TABLE tblItem SET("+values+") WHERE itemName="+itemNo+"";
            System.out.println("QUERY IS " + sql);
            if(SQLite.updateItem("tblItem", values,itemNo)){
                JOptionPane.showMessageDialog(null, "Item updated Successfully!");
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR! Cannot update an Item");
            }

        }
        this.refreshTable();
        SQLite.closeDB();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you wanted to delete this item?", "DELETE ITEM", JOptionPane.YES_NO_CANCEL_OPTION);

        if(x==0){
            if(SQLite.openDB()){
                int itemNo = Integer.parseInt(this.txtItemNo.getText());
                String table = "tblItem";
                if(SQLite.deleteItem(table, itemNo)) {
                    JOptionPane.showMessageDialog(null, "ITEM HAS BEEN DELETED!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "ITEM CANNOT BE DELETED!");
                }
            }
        }
        else if(x==1){
            return;
        }
        else{
            return;
        }
        this.refreshTable();
        SQLite.closeDB();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        app.frmCategory cat = new frmCategory();
        cat.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        app.frmBrand brand = new frmBrand();
        brand.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        this.txtItemNo.setText("");
        this.txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        this.txtStatus.setText("");
        this.txtSearch.setText("");
        this.txtSerialNumber.setText("");

        String brand = cmbBrand.getSelectedItem().toString();
        String status = this.txtStatus.getText();
        String supplier = cmbSupplier.getSelectedItem().toString();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        String search = txtSearch.getText();
        String[] column = {"itemID", "itemName","description","price","categoryNumber","brandNo", "serialNo","quantity","supplier","status"};
        String cmboSearch = this.cmbSearch.getSelectedItem().toString();

        if(cmboSearch.equals("itemName")){
            try{
                if(SQLite.openDB()){
                    String query = "itemName LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblItem", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblItem.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

        else if(cmboSearch.equals("Category")){
            try{
                if(SQLite.openDB()){
                    String query = " categoryNumber LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblItem", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblItem.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

        else if(cmboSearch.equals("itemNo")){
            try{
                if(SQLite.openDB()){
                    String query = "itemID LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblItem", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblItem.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

        else if(cmboSearch.equals("Brand")){
            try{
                if(SQLite.openDB()){
                    String query = "brandNo LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblItem", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblItem.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

        else if(cmboSearch.equals("Status")){
            try{
                if(SQLite.openDB()){
                    String query = "status LIKE '"+search+"%'";
                    String[][] data = SQLite.read("tblItem", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblItem.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void cmbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSearchActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(frmEditTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEditTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEditTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEditTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEditTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbBrand;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbSearch;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtItemNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSerialNumber;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
