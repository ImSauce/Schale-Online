
package Frame;

import Classes.ProductMethods;
import Classes.Sounds;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class View extends javax.swing.JFrame {
ProductMethods prod = new ProductMethods();
    Sounds sound = new Sounds();
    

    private Clip clip;
    
    Connection con = null;
PreparedStatement pst = null;
Statement st;


File f1 = null;
String  path1 = null;
private ImageIcon format1 = null;
String fname1=null;
int s1 =0;
byte [] pimage1=null;


 int powers = 0;   
 int firerates = 0;  
 int reloadspeeds = 0;  
 int ammos = 0;  
  

    public View() {
        initComponents();
        
        
        setResizable(false);
    ImageIcon Mainicon = new ImageIcon("SCHALE_resized.jpg");
    setIconImage(Mainicon.getImage());
    setTitle("Details");

  
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                sound.playSound3(clip);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            }
        });
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Icon = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        FirearmItemName10 = new javax.swing.JLabel();
        FirearmItemName11 = new javax.swing.JLabel();
        pH_TextAreaScroll1 = new SystemOtherComps.PH_TextAreaScroll();
        description = new SystemOtherComps.PH_TextArea();
        powernum = new javax.swing.JLabel();
        cost = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        p10 = new javax.swing.JTextField();
        p1 = new javax.swing.JTextField();
        p2 = new javax.swing.JTextField();
        p3 = new javax.swing.JTextField();
        p4 = new javax.swing.JTextField();
        p5 = new javax.swing.JTextField();
        p6 = new javax.swing.JTextField();
        p7 = new javax.swing.JTextField();
        p8 = new javax.swing.JTextField();
        p9 = new javax.swing.JTextField();
        FirearmItemName13 = new javax.swing.JLabel();
        fireratenum = new javax.swing.JLabel();
        fr10 = new javax.swing.JTextField();
        fr1 = new javax.swing.JTextField();
        fr2 = new javax.swing.JTextField();
        fr3 = new javax.swing.JTextField();
        fr4 = new javax.swing.JTextField();
        fr5 = new javax.swing.JTextField();
        fr6 = new javax.swing.JTextField();
        fr7 = new javax.swing.JTextField();
        fr8 = new javax.swing.JTextField();
        fr9 = new javax.swing.JTextField();
        reloadspeednum = new javax.swing.JLabel();
        r10 = new javax.swing.JTextField();
        r1 = new javax.swing.JTextField();
        r2 = new javax.swing.JTextField();
        r3 = new javax.swing.JTextField();
        r4 = new javax.swing.JTextField();
        r5 = new javax.swing.JTextField();
        r6 = new javax.swing.JTextField();
        r7 = new javax.swing.JTextField();
        r8 = new javax.swing.JTextField();
        r9 = new javax.swing.JTextField();
        ammonum = new javax.swing.JLabel();
        a10 = new javax.swing.JTextField();
        a1 = new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        a3 = new javax.swing.JTextField();
        a4 = new javax.swing.JTextField();
        a5 = new javax.swing.JTextField();
        a6 = new javax.swing.JTextField();
        a7 = new javax.swing.JTextField();
        a8 = new javax.swing.JTextField();
        a9 = new javax.swing.JTextField();
        clearBT = new SystemOtherComps.PH_Button();
        background = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, 410, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 410, 1));

        Icon.setBackground(new java.awt.Color(20, 20, 20));
        Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        Icon.setOpaque(true);
        Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconMouseClicked(evt);
            }
        });
        jPanel1.add(Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 160));

        stock.setEditable(false);
        stock.setBackground(new java.awt.Color(0, 0, 0));
        stock.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        stock.setForeground(new java.awt.Color(255, 255, 255));
        stock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        stock.setCaretColor(new java.awt.Color(255, 255, 255));
        stock.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 130, 29));

        name.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("NAME");
        name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 60));

        FirearmItemName10.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        FirearmItemName10.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName10.setText("TYPE");
        FirearmItemName10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(FirearmItemName10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 130, 30));

        FirearmItemName11.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        FirearmItemName11.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName11.setText("STOCK");
        FirearmItemName11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(FirearmItemName11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 130, 30));

        pH_TextAreaScroll1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        pH_TextAreaScroll1.setLabelText("DESCRIPTION");
        pH_TextAreaScroll1.setLineColor(new java.awt.Color(221, 221, 221));

        description.setEditable(false);
        description.setBackground(new java.awt.Color(10, 10, 10));
        description.setColumns(20);
        description.setRows(5);
        description.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        description.setSelectionColor(new java.awt.Color(32, 32, 32));
        pH_TextAreaScroll1.setViewportView(description);

        jPanel1.add(pH_TextAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 410, 190));

        powernum.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        powernum.setForeground(new java.awt.Color(255, 255, 255));
        powernum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        powernum.setText("0");
        powernum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(powernum, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 30, 30));

        cost.setEditable(false);
        cost.setBackground(new java.awt.Color(0, 0, 0));
        cost.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        cost.setForeground(new java.awt.Color(255, 255, 255));
        cost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        cost.setCaretColor(new java.awt.Color(255, 255, 255));
        cost.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 130, 29));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dmg.jpg"))); // NOI18N
        jLabel21.setText(" ");
        jLabel21.setToolTipText("damage");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fr.jpg"))); // NOI18N
        jLabel22.setText(" ");
        jLabel22.setToolTipText("fire rate");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rs.jpg"))); // NOI18N
        jLabel23.setText(" ");
        jLabel23.setToolTipText("reload speed");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginlogo.jpg"))); // NOI18N
        jLabel24.setText(" ");
        jLabel24.setToolTipText("accuracy");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        type.setEditable(false);
        type.setBackground(new java.awt.Color(0, 0, 0));
        type.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        type.setForeground(new java.awt.Color(255, 255, 255));
        type.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        type.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        type.setCaretColor(new java.awt.Color(255, 255, 255));
        type.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 130, 29));

        p10.setEditable(false);
        p10.setBackground(new java.awt.Color(21, 21, 21));
        p10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p10.setForeground(new java.awt.Color(255, 255, 255));
        p10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p10.setCaretColor(new java.awt.Color(255, 255, 255));
        p10.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 10, 30));

        p1.setEditable(false);
        p1.setBackground(new java.awt.Color(21, 21, 21));
        p1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 255, 255));
        p1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p1.setCaretColor(new java.awt.Color(255, 255, 255));
        p1.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 10, 30));

        p2.setEditable(false);
        p2.setBackground(new java.awt.Color(21, 21, 21));
        p2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p2.setForeground(new java.awt.Color(255, 255, 255));
        p2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p2.setCaretColor(new java.awt.Color(255, 255, 255));
        p2.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 10, 30));

        p3.setEditable(false);
        p3.setBackground(new java.awt.Color(21, 21, 21));
        p3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p3.setForeground(new java.awt.Color(255, 255, 255));
        p3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p3.setCaretColor(new java.awt.Color(255, 255, 255));
        p3.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 10, 30));

        p4.setEditable(false);
        p4.setBackground(new java.awt.Color(21, 21, 21));
        p4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p4.setForeground(new java.awt.Color(255, 255, 255));
        p4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p4.setCaretColor(new java.awt.Color(255, 255, 255));
        p4.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 10, 30));

        p5.setEditable(false);
        p5.setBackground(new java.awt.Color(21, 21, 21));
        p5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p5.setForeground(new java.awt.Color(255, 255, 255));
        p5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p5.setCaretColor(new java.awt.Color(255, 255, 255));
        p5.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 10, 30));

        p6.setEditable(false);
        p6.setBackground(new java.awt.Color(21, 21, 21));
        p6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p6.setForeground(new java.awt.Color(255, 255, 255));
        p6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p6.setCaretColor(new java.awt.Color(255, 255, 255));
        p6.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 10, 30));

        p7.setEditable(false);
        p7.setBackground(new java.awt.Color(21, 21, 21));
        p7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p7.setForeground(new java.awt.Color(255, 255, 255));
        p7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p7.setCaretColor(new java.awt.Color(255, 255, 255));
        p7.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 10, 30));

        p8.setEditable(false);
        p8.setBackground(new java.awt.Color(21, 21, 21));
        p8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p8.setForeground(new java.awt.Color(255, 255, 255));
        p8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p8.setCaretColor(new java.awt.Color(255, 255, 255));
        p8.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 10, 30));

        p9.setEditable(false);
        p9.setBackground(new java.awt.Color(21, 21, 21));
        p9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p9.setForeground(new java.awt.Color(255, 255, 255));
        p9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p9.setCaretColor(new java.awt.Color(255, 255, 255));
        p9.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(p9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 10, 30));

        FirearmItemName13.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        FirearmItemName13.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName13.setText("COST");
        FirearmItemName13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(FirearmItemName13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 130, 30));

        fireratenum.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        fireratenum.setForeground(new java.awt.Color(255, 255, 255));
        fireratenum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fireratenum.setText("0");
        fireratenum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(fireratenum, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 30, 30));

        fr10.setEditable(false);
        fr10.setBackground(new java.awt.Color(21, 21, 21));
        fr10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr10.setForeground(new java.awt.Color(255, 255, 255));
        fr10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr10.setCaretColor(new java.awt.Color(255, 255, 255));
        fr10.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 10, 30));

        fr1.setEditable(false);
        fr1.setBackground(new java.awt.Color(21, 21, 21));
        fr1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr1.setForeground(new java.awt.Color(255, 255, 255));
        fr1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr1.setCaretColor(new java.awt.Color(255, 255, 255));
        fr1.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 10, 30));

        fr2.setEditable(false);
        fr2.setBackground(new java.awt.Color(21, 21, 21));
        fr2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr2.setForeground(new java.awt.Color(255, 255, 255));
        fr2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr2.setCaretColor(new java.awt.Color(255, 255, 255));
        fr2.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 10, 30));

        fr3.setEditable(false);
        fr3.setBackground(new java.awt.Color(21, 21, 21));
        fr3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr3.setForeground(new java.awt.Color(255, 255, 255));
        fr3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr3.setCaretColor(new java.awt.Color(255, 255, 255));
        fr3.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 10, 30));

        fr4.setEditable(false);
        fr4.setBackground(new java.awt.Color(21, 21, 21));
        fr4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr4.setForeground(new java.awt.Color(255, 255, 255));
        fr4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr4.setCaretColor(new java.awt.Color(255, 255, 255));
        fr4.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 10, 30));

        fr5.setEditable(false);
        fr5.setBackground(new java.awt.Color(21, 21, 21));
        fr5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr5.setForeground(new java.awt.Color(255, 255, 255));
        fr5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr5.setCaretColor(new java.awt.Color(255, 255, 255));
        fr5.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 10, 30));

        fr6.setEditable(false);
        fr6.setBackground(new java.awt.Color(21, 21, 21));
        fr6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr6.setForeground(new java.awt.Color(255, 255, 255));
        fr6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr6.setCaretColor(new java.awt.Color(255, 255, 255));
        fr6.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 10, 30));

        fr7.setEditable(false);
        fr7.setBackground(new java.awt.Color(21, 21, 21));
        fr7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr7.setForeground(new java.awt.Color(255, 255, 255));
        fr7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr7.setCaretColor(new java.awt.Color(255, 255, 255));
        fr7.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 10, 30));

        fr8.setEditable(false);
        fr8.setBackground(new java.awt.Color(21, 21, 21));
        fr8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr8.setForeground(new java.awt.Color(255, 255, 255));
        fr8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr8.setCaretColor(new java.awt.Color(255, 255, 255));
        fr8.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 10, 30));

        fr9.setEditable(false);
        fr9.setBackground(new java.awt.Color(21, 21, 21));
        fr9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr9.setForeground(new java.awt.Color(255, 255, 255));
        fr9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr9.setCaretColor(new java.awt.Color(255, 255, 255));
        fr9.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(fr9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 10, 30));

        reloadspeednum.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        reloadspeednum.setForeground(new java.awt.Color(255, 255, 255));
        reloadspeednum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reloadspeednum.setText("0");
        reloadspeednum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(reloadspeednum, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 30, 30));

        r10.setEditable(false);
        r10.setBackground(new java.awt.Color(21, 21, 21));
        r10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r10.setForeground(new java.awt.Color(255, 255, 255));
        r10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r10.setCaretColor(new java.awt.Color(255, 255, 255));
        r10.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 10, 30));

        r1.setEditable(false);
        r1.setBackground(new java.awt.Color(21, 21, 21));
        r1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r1.setForeground(new java.awt.Color(255, 255, 255));
        r1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r1.setCaretColor(new java.awt.Color(255, 255, 255));
        r1.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 10, 30));

        r2.setEditable(false);
        r2.setBackground(new java.awt.Color(21, 21, 21));
        r2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r2.setForeground(new java.awt.Color(255, 255, 255));
        r2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r2.setCaretColor(new java.awt.Color(255, 255, 255));
        r2.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 10, 30));

        r3.setEditable(false);
        r3.setBackground(new java.awt.Color(21, 21, 21));
        r3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r3.setForeground(new java.awt.Color(255, 255, 255));
        r3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r3.setCaretColor(new java.awt.Color(255, 255, 255));
        r3.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 10, 30));

        r4.setEditable(false);
        r4.setBackground(new java.awt.Color(21, 21, 21));
        r4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r4.setForeground(new java.awt.Color(255, 255, 255));
        r4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r4.setCaretColor(new java.awt.Color(255, 255, 255));
        r4.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 10, 30));

        r5.setEditable(false);
        r5.setBackground(new java.awt.Color(21, 21, 21));
        r5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r5.setForeground(new java.awt.Color(255, 255, 255));
        r5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r5.setCaretColor(new java.awt.Color(255, 255, 255));
        r5.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 10, 30));

        r6.setEditable(false);
        r6.setBackground(new java.awt.Color(21, 21, 21));
        r6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r6.setForeground(new java.awt.Color(255, 255, 255));
        r6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r6.setCaretColor(new java.awt.Color(255, 255, 255));
        r6.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 10, 30));

        r7.setEditable(false);
        r7.setBackground(new java.awt.Color(21, 21, 21));
        r7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r7.setForeground(new java.awt.Color(255, 255, 255));
        r7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r7.setCaretColor(new java.awt.Color(255, 255, 255));
        r7.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 10, 30));

        r8.setEditable(false);
        r8.setBackground(new java.awt.Color(21, 21, 21));
        r8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r8.setForeground(new java.awt.Color(255, 255, 255));
        r8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r8.setCaretColor(new java.awt.Color(255, 255, 255));
        r8.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 10, 30));

        r9.setEditable(false);
        r9.setBackground(new java.awt.Color(21, 21, 21));
        r9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r9.setForeground(new java.awt.Color(255, 255, 255));
        r9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r9.setCaretColor(new java.awt.Color(255, 255, 255));
        r9.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(r9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 10, 30));

        ammonum.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        ammonum.setForeground(new java.awt.Color(255, 255, 255));
        ammonum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ammonum.setText("0");
        ammonum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(ammonum, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 30, 30));

        a10.setEditable(false);
        a10.setBackground(new java.awt.Color(21, 21, 21));
        a10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a10.setForeground(new java.awt.Color(255, 255, 255));
        a10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a10.setCaretColor(new java.awt.Color(255, 255, 255));
        a10.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 10, 30));

        a1.setEditable(false);
        a1.setBackground(new java.awt.Color(21, 21, 21));
        a1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a1.setForeground(new java.awt.Color(255, 255, 255));
        a1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a1.setCaretColor(new java.awt.Color(255, 255, 255));
        a1.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 10, 30));

        a2.setEditable(false);
        a2.setBackground(new java.awt.Color(21, 21, 21));
        a2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a2.setForeground(new java.awt.Color(255, 255, 255));
        a2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a2.setCaretColor(new java.awt.Color(255, 255, 255));
        a2.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 10, 30));

        a3.setEditable(false);
        a3.setBackground(new java.awt.Color(21, 21, 21));
        a3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a3.setForeground(new java.awt.Color(255, 255, 255));
        a3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a3.setCaretColor(new java.awt.Color(255, 255, 255));
        a3.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 10, 30));

        a4.setEditable(false);
        a4.setBackground(new java.awt.Color(21, 21, 21));
        a4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a4.setForeground(new java.awt.Color(255, 255, 255));
        a4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a4.setCaretColor(new java.awt.Color(255, 255, 255));
        a4.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 10, 30));

        a5.setEditable(false);
        a5.setBackground(new java.awt.Color(21, 21, 21));
        a5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a5.setForeground(new java.awt.Color(255, 255, 255));
        a5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a5.setCaretColor(new java.awt.Color(255, 255, 255));
        a5.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 10, 30));

        a6.setEditable(false);
        a6.setBackground(new java.awt.Color(21, 21, 21));
        a6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a6.setForeground(new java.awt.Color(255, 255, 255));
        a6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a6.setCaretColor(new java.awt.Color(255, 255, 255));
        a6.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 10, 30));

        a7.setEditable(false);
        a7.setBackground(new java.awt.Color(21, 21, 21));
        a7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a7.setForeground(new java.awt.Color(255, 255, 255));
        a7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a7.setCaretColor(new java.awt.Color(255, 255, 255));
        a7.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 10, 30));

        a8.setEditable(false);
        a8.setBackground(new java.awt.Color(21, 21, 21));
        a8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a8.setForeground(new java.awt.Color(255, 255, 255));
        a8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a8.setCaretColor(new java.awt.Color(255, 255, 255));
        a8.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 10, 30));

        a9.setEditable(false);
        a9.setBackground(new java.awt.Color(21, 21, 21));
        a9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a9.setForeground(new java.awt.Color(255, 255, 255));
        a9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a9.setCaretColor(new java.awt.Color(255, 255, 255));
        a9.setSelectionColor(new java.awt.Color(38, 38, 38));
        jPanel1.add(a9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 10, 30));

        clearBT.setBackground(new java.awt.Color(20, 20, 20));
        clearBT.setForeground(new java.awt.Color(255, 255, 255));
        clearBT.setText("CLOSE");
        clearBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        clearBT.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        clearBT.setAA_DrawBorder(true);
        clearBT.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        clearBT.setAA_PressColor(new java.awt.Color(20, 20, 20));
        clearBT.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        clearBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        clearBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBTActionPerformed(evt);
            }
        });
        jPanel1.add(clearBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 410, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backgroundview.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 570));

        id.setFont(new java.awt.Font("Segoe Print", 0, 1)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 0));
        id.setText("jLabel1");
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTActionPerformed
       setVisible(false);
       sound.playSound3(clip);
    }//GEN-LAST:event_clearBTActionPerformed

    private void IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconMouseClicked
    
    }//GEN-LAST:event_IconMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FirearmItemName10;
    private javax.swing.JLabel FirearmItemName11;
    private javax.swing.JLabel FirearmItemName13;
    public javax.swing.JLabel Icon;
    public javax.swing.JTextField a1;
    public javax.swing.JTextField a10;
    public javax.swing.JTextField a2;
    public javax.swing.JTextField a3;
    public javax.swing.JTextField a4;
    public javax.swing.JTextField a5;
    public javax.swing.JTextField a6;
    public javax.swing.JTextField a7;
    public javax.swing.JTextField a8;
    public javax.swing.JTextField a9;
    public javax.swing.JLabel ammonum;
    private javax.swing.JLabel background;
    private SystemOtherComps.PH_Button clearBT;
    public javax.swing.JTextField cost;
    public SystemOtherComps.PH_TextArea description;
    public javax.swing.JLabel fireratenum;
    public javax.swing.JTextField fr1;
    public javax.swing.JTextField fr10;
    public javax.swing.JTextField fr2;
    public javax.swing.JTextField fr3;
    public javax.swing.JTextField fr4;
    public javax.swing.JTextField fr5;
    public javax.swing.JTextField fr6;
    public javax.swing.JTextField fr7;
    public javax.swing.JTextField fr8;
    public javax.swing.JTextField fr9;
    public javax.swing.JLabel id;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel name;
    public javax.swing.JTextField p1;
    public javax.swing.JTextField p10;
    public javax.swing.JTextField p2;
    public javax.swing.JTextField p3;
    public javax.swing.JTextField p4;
    public javax.swing.JTextField p5;
    public javax.swing.JTextField p6;
    public javax.swing.JTextField p7;
    public javax.swing.JTextField p8;
    public javax.swing.JTextField p9;
    public SystemOtherComps.PH_TextAreaScroll pH_TextAreaScroll1;
    public javax.swing.JLabel powernum;
    public javax.swing.JTextField r1;
    public javax.swing.JTextField r10;
    public javax.swing.JTextField r2;
    public javax.swing.JTextField r3;
    public javax.swing.JTextField r4;
    public javax.swing.JTextField r5;
    public javax.swing.JTextField r6;
    public javax.swing.JTextField r7;
    public javax.swing.JTextField r8;
    public javax.swing.JTextField r9;
    public javax.swing.JLabel reloadspeednum;
    public javax.swing.JTextField stock;
    public javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables
public void powerstats (){
powers = Integer.parseInt(powernum.getText());   
        prod.clicked3(powers, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);


}

public void fireratestats (){
firerates = Integer.parseInt(fireratenum.getText());   
        prod.clicked3(firerates, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);


}

public void reloadspeedstats (){
reloadspeeds = Integer.parseInt(reloadspeednum.getText());   
        prod.clicked3(reloadspeeds, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);


}

public void ammostats (){
ammos = Integer.parseInt(ammonum.getText());   
        prod.clicked3(ammos, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);


}


}



