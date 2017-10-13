/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author preguajoshua
 */
public class frmPurchase extends javax.swing.JFrame {

    public frmPurchase() {
        initComponents();
        
        SQLite.url = "jdbc:sqlite:C:\\Users\\joshua\\Desktop\\Dream Circuits Inventory System\\src\\app\\tblInventory.sqlite";
        SQLite.username = "";
        SQLite.password = "";
        SQLite.className = "org.sqlite.JDBC";
        
        if (SQLite.openDB()) {
            String[][] data = SQLite.read("tblPurchaseiReport");
            String[] column = {"purchaseID", "firstName", "lastName", "itemName", "quantity","dateOfPurchase"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            this.tblPurchase.setModel(model);

            String[] columns = {"itemID", "itemName", "price"};
            String[][] records = SQLite.read("tblItem", columns);
            javax.swing.table.DefaultTableModel model2 = new javax.swing.table.DefaultTableModel(records, columns) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            this.tblItems.setModel(model2);

            String[] columns1 = {"clientID", "firstName", "middleName", "lastName"};
            String[][] records1 = SQLite.read("tblClient", columns1);
            javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(records1, columns1) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            this.tblClients.setModel(model1);
            SQLite.closeDB();
        }
        this.refreshTable();
        //SQLite.closeDB();
    }

    public void refreshTable() {
        //Load data

        if (SQLite.openDB()) {
            String[] columns = {"itemID", "itemName", "price"};
            String[][] records = SQLite.read("tblItem", columns);
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(records, columns) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            this.tblItems.setModel(model);

            String[] columns1 = {"clientID", "firstName", "middleName", "lastName"};
            String[][] records1 = SQLite.read("tblClient", columns1);
            javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(records1, columns1) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            this.tblClients.setModel(model1);

            ListSelectionListener lsl = new ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                    if (tblClients.getSelectedRow() > -1) {
                        int row = tblClients.getSelectedRow();
                        //JOptionPane.showMessageDialog(null, "Row is " + row);
                        if (SQLite.openDB()) {
                            String sr_id = tblClients.getValueAt(tblClients.getSelectedRow(), 0).toString();
                            int id = Integer.parseInt(sr_id);
                            String[][] result = SQLite.read("tblClient", "clientID=" + id);

                            txtLastName.setText(result[0][1]);
                            txtFirstName.setText(result[0][3]);

                            SQLite.closeDB();
                        }
                    }
                }
            };
            this.tblClients.getSelectionModel().addListSelectionListener(lsl);

            ListSelectionListener lis = new ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                    if (tblItems.getSelectedRow() > -1) {
                        int row = tblItems.getSelectedRow();
                        //JOptionPane.showMessageDialog(null, "Row is " + row);
                        if (SQLite.openDB()) {
                            String sr_id = tblItems.getValueAt(tblItems.getSelectedRow(), 0).toString();
                            int id = Integer.parseInt(sr_id);
                            String[][] result = SQLite.read("tblItem", "itemID=" + id);
                            txtItemID.setText(result[0][0]);
                            txtItemName.setText(result[0][1]);

                            SQLite.closeDB();
                        }
                    }
                }
            };
            this.tblItems.getSelectionModel().addListSelectionListener(lis);

            SQLite.closeDB();

        }
    }

    public void refreshPurchase() {
        //Load data

        if (SQLite.openDB()) {
            String[] columns = {"purchaseID", "firstName", "lastName", "itemName", "quantity","dateOfPurchase"};
            String[][] records = SQLite.read("tblPurchaseiReport", columns);
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(records, columns) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            this.tblPurchase.setModel(model);

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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPurchase = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        txtItemName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        dcDate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        txtItemID = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cmbSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        cmbClient = new javax.swing.JComboBox<>();
        txtKey = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/error.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Purchase ID", "Last Name", "First Name", "Item Name", "Quantity", "Date"
            }
        ));
        jScrollPane1.setViewportView(tblPurchase);

        jButton13.setText("Item Name");

        jButton15.setText("Quantity");

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        jButton19.setText("Date");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cash-register.png"))); // NOI18N
        jButton1.setText("PURCHASE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton21.setText("PURCHASE HISTORY");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton20.setText("Last Name");

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        jButton14.setText("ItemID");

        jButton23.setText("First Name");

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer.png"))); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFirstName)
                            .addComponent(dcDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtItemName)
                                    .addComponent(txtQuantity)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_print)
                        .addGap(49, 49, 49))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton19)
                            .addComponent(dcDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton20)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton14)
                            .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13)
                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton23))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton15)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton21)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_print))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jButton17.setText("List of Clients");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("List of Items");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblItems);

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblClients);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cart1.png"))); // NOI18N
        jLabel9.setText("PURCHASE");

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "itemNo", "itemName" }));
        cmbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        cmbClient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ClientID", "FirstName", "MiddleName", "LastName" }));
        cmbClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClientActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbClient, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton17))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton18)
                            .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int itemID = Integer.parseInt(this.txtItemID.getText());
        int quantity = Integer.parseInt(this.txtQuantity.getText());
        String firstName = this.txtFirstName.getText();
        String lastName = this.txtLastName.getText();
        String itemName = this.txtItemName.getText();
        String date = DatePick.dcGetDate(dcDate);
        String value = null + "," + "'" + firstName + "'" + ","+ "'"+ lastName + "'" + "," + "'" + itemName + "'" + "," + quantity + "," + "'" + date + "'";
        String set = "quantity = quantity - " + quantity;
        int l = JOptionPane.showConfirmDialog(null, "Are you sure you wanted to purchase this item?", "PURCHASE ITEM", JOptionPane.YES_NO_CANCEL_OPTION);

        if (l == 0) {
            if (SQLite.openDB()) {
                try {
                    String id = "itemID=" + itemID;
                    String[][] count = SQLite.readS("tblItem", id);
                    for (int x = 0; x < count.length; x++) {
                        for (int y = 0; y < count.length; y++) {
                            int num = Integer.parseInt(count[x][y]);
                            int total = num - quantity;
                            if (total < 0) {
                                JOptionPane.showMessageDialog(null, "Cannot Purchase item, not enough supply!");
                            } else {
                                String sql = "UPDATE tblItem SET quantity = quantity + " + quantity + " WHERE itemID=" + itemID + "";
                                SQLite.updateStocks("tblItem", set, itemID);
                                System.out.println("Query is: " + value);
                                SQLite.create("tblPurchase", value);
                                SQLite.create("tblPurchaseiReport", value);
                                JOptionPane.showMessageDialog(null, "Success!");
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Purchase Failed to add!");
//                    JOptionPane.showMessageDialog(null, "");
                }

            }
        }
        SQLite.closeDB();
        this.refreshPurchase();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        frmPurchaseHistory h = new frmPurchaseHistory();
        h.setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
       try{
            if(SQLite.openDB()){
                String reportName = "src\\app\\PurchaseReport.jrxml";
                UIC.Report.viewReport(reportName);
                //UIC.Report.viewReport(jspReport, reportName);
                SQLite.Truncate("tblPurchaseiReport");
                SQLite.closeDB();
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
       this.refreshPurchase();
    }//GEN-LAST:event_btn_printActionPerformed

    private void cmbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        String[] column = {"itemID", "itemName", "description"};
        String searchKey = txtSearch.getText();
        String cmboSearch = this.cmbSearch.getSelectedItem().toString();

        if(cmboSearch.equals("itemName")){
            try{
                if(SQLite.openDB()){
                    String query = "itemName LIKE '"+searchKey+"%'";
                    String[][] data = SQLite.read("tblItem", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblItems.setModel(model);
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
                    String query = "itemID LIKE '"+searchKey+"%'";
                    String[][] data = SQLite.read("tblItem", query);
                    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
                    this.tblItems.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void cmbClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClientActionPerformed

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
                    this.tblClients.setModel(model);
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
                    this.tblClients.setModel(model);
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
                    this.tblClients.setModel(model);
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
                    this.tblClients.setModel(model);
                    SQLite.closeDB();
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

    
        
    }//GEN-LAST:event_txtKeyKeyTyped

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(frmPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPurchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> cmbClient;
    private javax.swing.JComboBox<String> cmbSearch;
    private com.toedter.calendar.JDateChooser dcDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblClients;
    private javax.swing.JTable tblItems;
    private javax.swing.JTable tblPurchase;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
