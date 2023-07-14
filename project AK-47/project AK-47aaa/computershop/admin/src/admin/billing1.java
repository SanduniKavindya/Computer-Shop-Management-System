/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import codes.BDconect;
import com.mysql.jdbc.PreparedStatement;
import com.sun.glass.events.KeyEvent;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import prabthbookshop.invoice21;

/**
 *
 * @author InspireTech
 */
public class billing1 extends javax.swing.JFrame {

    
     public void sales()
    
    
    {
    String subtottle= subtotle.getText();
    String payment1= payment.getText();
    String bal= balnce.getText();
    
    int lastinsertid = 0;
    
    
        try {
             java.sql.Connection conn = BDconect.getConnection(); 
            String query ="insert into sales(subtotal,pay,balnce)Values(?,?,?)  ";
            pst =conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, subtottle);
            pst.setString(2, payment1);
            pst.setString(3, bal);
            pst.executeUpdate();
            ResultSet generatekey = pst.getGeneratedKeys();
            
            if(generatekey.next())
            {
            
                lastinsertid = generatekey.getInt(1);
            
            
            
            }
            
            
            int rows = billTable1.getRowCount();
             String query1 ="insert into sales_product(sales_id,prod_id,price,qty,total )Values(  ?,?,?,?,?)  ";
              pst1 =conn.prepareStatement(query1);
              
              String prodid = "";
               String price = "";
                String qty = "";
                 int total = 0;
                 
                 
               for(int i=0 ; i<billTable1.getRowCount(); i++)
               {
               
               prodid = (String)billTable1.getValueAt(i, 0);
                 price = (String)billTable1.getValueAt(i, 2);
                   qty = (String)billTable1.getValueAt(i, 3);
                    total = (int)billTable1.getValueAt(i, 4);
                    
                    
                    pst1.setInt(1,lastinsertid);
                     pst1.setString(2,prodid);
                      pst1.setString(3,price);
                       pst1.setString(4,qty);
                        pst1.setInt(5,total);
                        pst1.executeUpdate();
                        
               }
                 
                pst.addBatch();
                pst1.addBatch();
                JOptionPane.showMessageDialog(this,"Record added");
                 
                 
            HashMap m = new HashMap(); 
            m.put("Invoiceno",lastinsertid);
            
//        try {
//            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\nuwan\\Downloads\\Prabath Bookshop 1\\Prabath Bookshop\\Prabath Bookshop\\prabthBookshop\\src\\prabthbookshop\\resipt.jrxml ");
//            JasperReport ireport = JasperCompileManager.compileReport(jdesign);
//            JasperPrint Jprint = JasperFillManager.fillReport(ireport , m ,con);
//            
//            JasperViewer.viewReport(Jprint , false);
//            
//            
//            
//           // JasperReport ireport = JasperCompileManger.compileReport(jdesign);
//            //JasperPrint Jprint = JasperFileManger.fileReport(ireport,m,con);
//        
//        } catch (JRException ex) {
//            Logger.getLogger(invoice21.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                  
            
        } catch (SQLException ex) {
            Logger.getLogger(invoice21.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }
    
    
    
    
    
    public billing1() {
        
        initComponents();
        connect();
        
        


    

   
    
    }

    
    
    
    
   
public void connect(){
    
    
      try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ak47-s","root","");
        
            }
    
         catch (ClassNotFoundException ex) {
            Logger.getLogger(invoice21.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(invoice21.class.getName()).log(Level.SEVERE, null, ex);
           } 
           }
    
    Connection conn;
    java.sql.PreparedStatement pst;
     java.sql.PreparedStatement pst1;
    ResultSet rs;
    DefaultTableModel  Model = new DefaultTableModel(); 
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        mainButton = new javax.swing.JButton();
        storelabel = new javax.swing.JLabel();
        billLabel = new javax.swing.JLabel();
        maintenslabel1 = new javax.swing.JLabel();
        storelabel2 = new javax.swing.JLabel();
        reportslabel3 = new javax.swing.JLabel();
        employelabel = new javax.swing.JLabel();
        updatlabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tLabel = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        datename = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        unitprice = new javax.swing.JTextField();
        billprodu = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        billqty = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        prodname = new javax.swing.JTextField();
        subtotle = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        payment = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        balnce = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        paidamount = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        dueamount = new javax.swing.JTextField();
        deletButton1 = new javax.swing.JButton();
        subtotalButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("billinginterface");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(22, 67, 108));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mainButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/main menu last.png"))); // NOI18N
        mainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainButtonActionPerformed(evt);
            }
        });

        storelabel.setForeground(new java.awt.Color(255, 255, 255));
        storelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/LAST STORE (1).png"))); // NOI18N
        storelabel.setPreferredSize(new java.awt.Dimension(95, 37));
        storelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                storelabelMouseClicked(evt);
            }
        });

        billLabel.setForeground(new java.awt.Color(255, 255, 255));
        billLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/LAST BILL.png"))); // NOI18N
        billLabel.setPreferredSize(new java.awt.Dimension(95, 37));

        maintenslabel1.setForeground(new java.awt.Color(255, 255, 255));
        maintenslabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/maintenance last.png"))); // NOI18N
        maintenslabel1.setPreferredSize(new java.awt.Dimension(95, 37));
        maintenslabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintenslabel1MouseClicked(evt);
            }
        });

        storelabel2.setForeground(new java.awt.Color(255, 255, 255));
        storelabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/supplier last (1).png"))); // NOI18N
        storelabel2.setPreferredSize(new java.awt.Dimension(95, 37));
        storelabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                storelabel2MouseClicked(evt);
            }
        });

        reportslabel3.setForeground(new java.awt.Color(255, 255, 255));
        reportslabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/report last.png"))); // NOI18N
        reportslabel3.setPreferredSize(new java.awt.Dimension(95, 37));
        reportslabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportslabel3MouseClicked(evt);
            }
        });

        employelabel.setForeground(new java.awt.Color(255, 255, 255));
        employelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/update last.png"))); // NOI18N
        employelabel.setPreferredSize(new java.awt.Dimension(95, 37));
        employelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employelabelMouseClicked(evt);
            }
        });

        updatlabel.setForeground(new java.awt.Color(255, 255, 255));
        updatlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/notification last.png"))); // NOI18N
        updatlabel.setPreferredSize(new java.awt.Dimension(95, 37));
        updatlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatlabelMouseClicked(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/cyber.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(storelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(billLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maintenslabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(storelabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportslabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employelabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updatlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(billLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(storelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(maintenslabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(storelabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(reportslabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(employelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(updatlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(mainButton)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 1010));

        jPanel5.setBackground(new java.awt.Color(57, 151, 196));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("         BILL DETAILS");

        tLabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tLabelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        l_date.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                l_dateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        datename.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        datename.setText("DATE");

        time.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        time.setText("TIME");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1048, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(l_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datename, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 1710, 80));

        billTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "unit price", "qty", "total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        billTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(billTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 600, 190));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        bill.setColumns(20);
        bill.setRows(5);
        jScrollPane2.setViewportView(bill);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 320, 390));

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        unitprice.setName(" repary coustomer"); // NOI18N

        billprodu.setName("repare item"); // NOI18N
        billprodu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billproduActionPerformed(evt);
            }
        });
        billprodu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                billproduKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("Product name");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("qty");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("unit prioce");

        billqty.setName("repare item"); // NOI18N
        billqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billqtyActionPerformed(evt);
            }
        });
        billqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                billqtyKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Total");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("id");

        prodname.setName("repare item"); // NOI18N
        prodname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodnameActionPerformed(evt);
            }
        });

        subtotle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotleActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel18.setText("Sub Totle");

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton.setText("print");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel21.setText("pay");

        balnce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balnceActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel23.setText("balnce");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(billprodu, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(billqty, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unitprice, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(subtotle, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prodname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(balnce, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(billprodu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(prodname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitprice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billqty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(subtotle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(balnce, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 510, 470));

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 102, 102), null, null));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel20.setText("Paid Amount");

        paidamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidamountActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel22.setText("Due Amount");

        dueamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueamountActionPerformed(evt);
            }
        });

        deletButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deletButton1.setText("Clear");
        deletButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletButton1ActionPerformed(evt);
            }
        });

        subtotalButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        subtotalButton2.setText("Add sub total");
        subtotalButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotalButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(paidamount, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(deletButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dueamount, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(subtotalButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(paidamount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dueamount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletButton1)
                    .addComponent(subtotalButton2))
                .addContainerGap())
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 790, 960, 170));

        jPanel3.setBackground(new java.awt.Color(57, 151, 196));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1900, 80, 30, 930));

        jPanel6.setBackground(new java.awt.Color(57, 151, 196));

        jLabel11.setText("                                           @ THE AK-47 S P.L.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(955, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 980, 1680, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainButtonActionPerformed

    private void billproduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billproduActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billproduActionPerformed

    private void subtotleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotleActionPerformed

    private void paidamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paidamountActionPerformed

    private void dueamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dueamountActionPerformed

    private void l_dateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_l_dateAncestorAdded
        // TODO add your handling code here:
        times();
    }//GEN-LAST:event_l_dateAncestorAdded

    private void tLabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tLabelAncestorAdded
        // TODO add your handling code here:
        dt();
    }//GEN-LAST:event_tLabelAncestorAdded

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
       int pay = Integer.parseInt(payment.getText());
         int subtot = Integer.parseInt(subtotle.getText());
         int bal = pay - subtot;
         balnce.setText(String.valueOf(bal));
         sales();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deletButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletButton1ActionPerformed
       
    }//GEN-LAST:event_deletButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void billqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billqtyActionPerformed
       
    }//GEN-LAST:event_billqtyActionPerformed

    private void storelabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storelabelMouseClicked
        stork j1=new stork ();
                j1.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_storelabelMouseClicked

    private void maintenslabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintenslabel1MouseClicked
        
    }//GEN-LAST:event_maintenslabel1MouseClicked

    private void storelabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storelabel2MouseClicked
        supplierdetails j1=new supplierdetails ();
                j1.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_storelabel2MouseClicked

    private void reportslabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportslabel3MouseClicked
        
              repoarts j1 = new repoarts();
                      j1.setVisible(true);
                     this.dispose();

    }//GEN-LAST:event_reportslabel3MouseClicked

    private void employelabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employelabelMouseClicked
       
    }//GEN-LAST:event_employelabelMouseClicked

    private void updatlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatlabelMouseClicked
           updat j1 = new updat ();
           j1.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_updatlabelMouseClicked

    private void subtotalButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotalButton2ActionPerformed
       
        
        
    }//GEN-LAST:event_subtotalButton2ActionPerformed

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        
    }//GEN-LAST:event_saveButtonMouseClicked

    private void billTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTable1MouseClicked
       
    }//GEN-LAST:event_billTable1MouseClicked

    private void prodnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodnameActionPerformed

    private void billproduKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billproduKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()== KeyEvent.VK_ENTER )
        {
        
        String productid = billprodu.getText();
            try {
                pst =conn.prepareStatement("select * from stork where id=?");
                pst.setString(1,productid);
                rs = pst.executeQuery();
                
                if(rs.next() == false)
                {
                
                JOptionPane.showMessageDialog(this, "Insert Value not Valid" );     
                }
                
                else
                {
                
                    String prodname1 = rs.getString("itemname");
                     String price = rs.getString("price");
                     
                     prodname.setText(prodname1.trim());
                     unitprice.setText(price.trim());
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(invoice21.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        
        
        
    }//GEN-LAST:event_billproduKeyPressed

    private void billqtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billqtyKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()== KeyEvent.VK_ENTER )
        {
            
        int price =Integer.parseInt(unitprice.getText());
        int qtyn =Integer.parseInt(billqty.getText());
            
            int tot=price * qtyn ;
             
            
        
           Model = (DefaultTableModel)billTable1.getModel();
           Model.addRow(new Object[]
           {
           billprodu.getText(),
           prodname.getText(),
           unitprice.getText(),
           billqty.getText(),
           tot,
          
           }
              
           );
           
         int sum = 0;
         for(int i =0; i<billTable1.getRowCount(); i++)
         {
         
         sum= sum + Integer.parseInt(billTable1.getValueAt(i,4).toString());
         
         subtotle.setText(String.valueOf(sum));
          billprodu.setText("");
           prodname.setText("");
           unitprice.setText("");
           billqty.setText("");
         
         }
           
           
           
           
           
        }
        
        
        
    }//GEN-LAST:event_billqtyKeyPressed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentActionPerformed

    private void balnceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balnceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balnceActionPerformed

    public void dt() {

        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");

        String dd = sdf.format(d);
        l_date.setText(dd);

    }
    Timer t;
    SimpleDateFormat st;

  public void times(){

   
    
  t = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Date dt  =new Date();
        st = new SimpleDateFormat("hh:mm:ss");
        
        String tt = st.format(dt);
        tLabel.setText(tt);
        
        }
    });
  
    t.start();
    
    

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
            java.util.logging.Logger.getLogger(billing1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billing1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billing1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billing1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new billing1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField balnce;
    private javax.swing.JTextArea bill;
    private javax.swing.JLabel billLabel;
    private javax.swing.JTable billTable1;
    private javax.swing.JTextField billprodu;
    private javax.swing.JTextField billqty;
    private javax.swing.JLabel datename;
    private javax.swing.JButton deletButton1;
    private javax.swing.JTextField dueamount;
    private javax.swing.JLabel employelabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_date;
    private javax.swing.JButton mainButton;
    private javax.swing.JLabel maintenslabel1;
    private javax.swing.JTextField paidamount;
    private javax.swing.JTextField payment;
    private javax.swing.JTextField prodname;
    private javax.swing.JLabel reportslabel3;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel storelabel;
    private javax.swing.JLabel storelabel2;
    private javax.swing.JButton subtotalButton2;
    private javax.swing.JTextField subtotle;
    private javax.swing.JLabel tLabel;
    private javax.swing.JLabel time;
    private javax.swing.JTextField total;
    private javax.swing.JTextField unitprice;
    private javax.swing.JLabel updatlabel;
    // End of variables declaration//GEN-END:variables
}
