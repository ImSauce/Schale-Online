////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////         CODE MADE BY: S A M U E L   J A M E S    A.    C I N C O            ///////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//BUGS:
// 
//MUSIC PREVENTS THE HOME BUTTONS FROM BEING CLICKED IF THE PC HAS NO MUSIC



package Frame;

import Classes.ColorMouseEvent; 
import Classes.MouseEnteredClass;
import Classes.MouseExitedClass;
import Classes.Popups;
import Classes.ProductMethods;
import Classes.Sounds;
import Classes.StartupMethods;
import Classes.TextPaneUtils;
import Classes.UIcolors;
import Run.run;
import Socials.DISCORD;
import Socials.FB;
import Socials.GITHUB;
import Socials.X;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;
import panels.itemPanel;

/**
 *
 * @author GodisGood
 */
public class main extends javax.swing.JFrame {
    
    
    //SOCIALS
    FB fb = new FB();
    DISCORD dis = new DISCORD();
    X x = new X();
    GITHUB git = new GITHUB();
    
    Popups pop = new Popups();
    Sounds sound = new Sounds();
    StartupMethods startup = new StartupMethods();
    ProductMethods ProductMethods = new ProductMethods();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    serverConfig server = new serverConfig();
    
    boolean skibidiclicked = false;
    
     Date currentDate = new Date();

    // Create a SimpleDateFormat object to format the date and time
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    // Format the date and time
    String formattedDate = dateFormat.format(currentDate);
    String formattedTime = timeFormat.format(currentDate);
    
    
    NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    DecimalFormat df = (DecimalFormat)nf;
 
     
    
    private Clip clip;  
    
    

    ArrayList <itemPanel> ITEMPANELS = new ArrayList<>();
    
    String musicFilePath = "aru terror.wav";
    float volume = -18.0f;
    
    public double wallet =0;
    
    
    private final login loginInstance;
    
    int ShopClicked = 0;
    int CartClicked = 0;
    
    int AddClicked = 0;
    int EditClicked = 0;
    
    int TransactionClicked = 0;
    int ImportClicked = 0;
    int EarningClicked = 0;
    
   
    
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    
    
    public void forConnection(Connection conn, String serverIP,String userID ,String passwordID){
        local.setText(userID);
        local2.setText(serverIP);
        local3.setText(passwordID);
        
 
    }
    
    
    public void connect() {
        serverCredentials sv = new serverCredentials();
        sv.setServerIP(local2.getText());
        sv.setUserID(local.getText());
        sv.setPass(local3.getText());
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+sv.getServerIP() +"/schale_online", sv.getUserID(), sv.getPass());
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(run.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(run.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    

    
    
    
    
    File f1 = null;
    String  path1 = null;
    private ImageIcon format1 = null;
    
    File f2 = null;
    String  path2 = null;
    private ImageIcon format2 = null;
    
    
    File f3 = null;
    String  path3 = null;
    private ImageIcon format3 = null;
 


    
    
    
private void formWindowOpened(java.awt.event.WindowEvent evt) {
    //Automatically run the refresh button when the app is run for the first time    
    //activated in the innitcomponents
    ShopLabelMouseClicked(null);
    HomeLabelShopMouseClicked(null);
    sound.playMusicLoop1();
    }


    
    public main(login loginInstance) {
        initComponents();
        local.setText(loginInstance.userID);
        local2.setText(loginInstance.serverIP);
        local3.setText(loginInstance.passwordID);
        
    
            
        this.loginInstance = loginInstance;
        
        connect();
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        
        
        TransactionTable.setShowGrid(true);
        ImportTable.setShowGrid(true);
        EditTable.setShowGrid(true);
        EarningsTABLE.setShowGrid(true);
        ImportTABLE.setShowGrid(true);
        
        
     
        df.applyPattern("###,###.##");
        
       
        
        walletTxt.setText(df.format(wallet));
 
         
        

        ProductPanel.setVisible(false);
        AddProductPanel.setVisible(false);
        EditProductPanel.setVisible(false);
        
        ShopFirearms.setVisible(false);
        ShopPanel.setVisible(false);
        ShopCart.setVisible(false);
        
        TransactionPanel.setVisible(false);
        TransactionTransaction.setVisible(false);
        TransactionImport.setVisible(false);
        
        AdminPanel.setVisible(false);
        
        ShopMenu.setVisible(true);
        
        initProds();
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);       

        
        
  
        // Create a cell renderer to center align the data
        
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Set the cell renderer for each column in the table
        for (int i = 0; i < CartTable.getColumnCount(); i++) {
            CartTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }        
        for (int i = 0; i < TransactionTable.getColumnCount(); i++) {
            TransactionTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < ImportTable.getColumnCount(); i++) {
            ImportTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < ImportTABLE.getColumnCount(); i++) {
            ImportTABLE.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < EarningsTABLE.getColumnCount(); i++) {
            EarningsTABLE.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }for (int i = 0; i < adminTable.getColumnCount(); i++) {
            adminTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                
               if (skibidiclicked == true){
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                EasterEgg egg = new EasterEgg();
                egg.setVisible(true);
                
               
               }

            }
        });

        
        
        
          
        
        //setExtendedState(main.MAXIMIZED_BOTH);
        ImageIcon Mainicon = new ImageIcon ("SCHALE_resized.jpg");
        setIconImage(Mainicon.getImage());
        setTitle("S.C.H.A.L.E Online");
        setResizable(false);
        
        
        startup.ShopResize(ShopLabel);
        startup.ProductResize(ProductLabel);
        startup.TransactionResize(TransactionLabel);
         
        sound.playSound(clip);
        
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HomePanel = new javax.swing.JPanel();
        TitleMenu = new javax.swing.JLabel();
        ShopPanelHome = new javax.swing.JPanel();
        ShopLabel = new javax.swing.JLabel();
        ProductPanelHome = new javax.swing.JPanel();
        ProductLabel = new javax.swing.JLabel();
        TransactionPanelHome = new javax.swing.JPanel();
        TransactionLabel = new javax.swing.JLabel();
        local = new javax.swing.JLabel();
        local2 = new javax.swing.JLabel();
        local3 = new javax.swing.JLabel();
        ProductPanel = new javax.swing.JPanel();
        ProductMenu = new javax.swing.JPanel();
        HomeLabelProduct = new javax.swing.JLabel();
        AddProductLabelProduct = new javax.swing.JLabel();
        EditProductLabelProduct = new javax.swing.JLabel();
        ProductLayerPanel = new javax.swing.JPanel();
        AddProductPanel = new javax.swing.JPanel();
        productImage = new javax.swing.JLabel();
        removeImage = new javax.swing.JButton();
        FirearmItemName1 = new javax.swing.JLabel();
        add_id = new javax.swing.JTextField();
        FirearmItemName2 = new javax.swing.JLabel();
        add_name = new javax.swing.JTextField();
        FirearmItemName3 = new javax.swing.JLabel();
        FirearmItemName4 = new javax.swing.JLabel();
        FirearmItemName5 = new javax.swing.JLabel();
        add_cost = new javax.swing.JTextField();
        add_stock = new javax.swing.JTextField();
        add_type = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        add_description = new javax.swing.JTextPane();
        add_imageName = new javax.swing.JTextField();
        add_imagePath = new javax.swing.JTextField();
        add_businessFunds = new javax.swing.JTextField();
        add_importFee = new javax.swing.JTextField();
        FirearmItemName14 = new javax.swing.JLabel();
        saveBT = new SystemOtherComps.PH_Button();
        clearBT = new SystemOtherComps.PH_Button();
        FirearmItemName36 = new javax.swing.JLabel();
        add_power = new javax.swing.JTextField();
        add_firerate = new javax.swing.JTextField();
        FirearmItemName46 = new javax.swing.JLabel();
        FirearmItemName47 = new javax.swing.JLabel();
        add_ammo = new javax.swing.JTextField();
        add_reloadspeed = new javax.swing.JTextField();
        FirearmItemName48 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        FirearmItemName49 = new javax.swing.JLabel();
        FirearmItemName50 = new javax.swing.JLabel();
        FirearmItemName51 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        FirearmItemName52 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        FirearmItemName53 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        p2 = new javax.swing.JTextField();
        p3 = new javax.swing.JTextField();
        p4 = new javax.swing.JTextField();
        p5 = new javax.swing.JTextField();
        p6 = new javax.swing.JTextField();
        p7 = new javax.swing.JTextField();
        p8 = new javax.swing.JTextField();
        p9 = new javax.swing.JTextField();
        p10 = new javax.swing.JTextField();
        p1 = new javax.swing.JTextField();
        fr1 = new javax.swing.JTextField();
        fr10 = new javax.swing.JTextField();
        fr9 = new javax.swing.JTextField();
        fr8 = new javax.swing.JTextField();
        fr7 = new javax.swing.JTextField();
        fr6 = new javax.swing.JTextField();
        fr5 = new javax.swing.JTextField();
        fr4 = new javax.swing.JTextField();
        fr3 = new javax.swing.JTextField();
        fr2 = new javax.swing.JTextField();
        r8 = new javax.swing.JTextField();
        r1 = new javax.swing.JTextField();
        r6 = new javax.swing.JTextField();
        r3 = new javax.swing.JTextField();
        r10 = new javax.swing.JTextField();
        r5 = new javax.swing.JTextField();
        r7 = new javax.swing.JTextField();
        r2 = new javax.swing.JTextField();
        r9 = new javax.swing.JTextField();
        r4 = new javax.swing.JTextField();
        a3 = new javax.swing.JTextField();
        a8 = new javax.swing.JTextField();
        a6 = new javax.swing.JTextField();
        a1 = new javax.swing.JTextField();
        a4 = new javax.swing.JTextField();
        a10 = new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        a9 = new javax.swing.JTextField();
        a5 = new javax.swing.JTextField();
        a7 = new javax.swing.JTextField();
        EditProductPanel = new javax.swing.JPanel();
        EditTableScroll = new javax.swing.JScrollPane();
        EditTable = new javax.swing.JTable();
        InfoPanelEdit = new javax.swing.JPanel();
        productImageEdit = new javax.swing.JLabel();
        FirearmItemName7 = new javax.swing.JLabel();
        FirearmItemName8 = new javax.swing.JLabel();
        FirearmItemName9 = new javax.swing.JLabel();
        FirearmItemName10 = new javax.swing.JLabel();
        FirearmItemName11 = new javax.swing.JLabel();
        edit_cost = new javax.swing.JTextField();
        edit_stock = new javax.swing.JTextField();
        edit_name = new javax.swing.JTextField();
        edit_type = new javax.swing.JComboBox<>();
        edit_id = new javax.swing.JTextField();
        decrease_stock = new javax.swing.JButton();
        UpdateBT = new SystemOtherComps.PH_Button();
        pH_TextAreaScroll2 = new SystemOtherComps.PH_TextAreaScroll();
        edit_description = new SystemOtherComps.PH_TextArea();
        edit_fee = new javax.swing.JTextField();
        FirearmItemName12 = new javax.swing.JLabel();
        increase_stock = new javax.swing.JButton();
        new_stock = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        FirearmItemName16 = new javax.swing.JLabel();
        OriginalPrice = new javax.swing.JTextField();
        edit_power = new javax.swing.JTextField();
        edit_firerate = new javax.swing.JTextField();
        edit_reloadspeed = new javax.swing.JTextField();
        edit_ammo = new javax.swing.JTextField();
        FirearmItemName31 = new javax.swing.JLabel();
        FirearmItemName54 = new javax.swing.JLabel();
        FirearmItemName55 = new javax.swing.JLabel();
        FirearmItemName56 = new javax.swing.JLabel();
        addpower = new javax.swing.JButton();
        reducepower = new javax.swing.JButton();
        addfirerate = new javax.swing.JButton();
        reducefirerate = new javax.swing.JButton();
        addreloadspeed = new javax.swing.JButton();
        reducereloadspeed = new javax.swing.JButton();
        addaccuracy = new javax.swing.JButton();
        reduceaccuracy = new javax.swing.JButton();
        RemoveBT = new SystemOtherComps.PH_Button();
        edit_sorter = new javax.swing.JComboBox<>();
        edit_imagePath = new javax.swing.JTextField();
        edit_imageName = new javax.swing.JTextField();
        edit_id_2 = new javax.swing.JTextField();
        FirearmItemName15 = new javax.swing.JLabel();
        edit_businessFunds = new javax.swing.JTextField();
        TransactionPanel = new javax.swing.JPanel();
        TransactionMenu = new javax.swing.JPanel();
        HomeLabelTransaction = new javax.swing.JLabel();
        TransactionLabelTransaction = new javax.swing.JLabel();
        ImportLabelTransaction = new javax.swing.JLabel();
        EarningLabelTransaction = new javax.swing.JLabel();
        TransactionLayerPanel = new javax.swing.JPanel();
        TransactionTransaction = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        NumberOfTransactions = new javax.swing.JTextField();
        EarningsTableScroll = new javax.swing.JScrollPane();
        TransactionTable = new javax.swing.JTable();
        TransactionSearchTXT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TransactionEarnings = new javax.swing.JPanel();
        ImportTableScroll1 = new javax.swing.JScrollPane();
        EarningsTABLE = new javax.swing.JTable();
        ImportTableScroll3 = new javax.swing.JScrollPane();
        ImportTABLE = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Total_Earnings = new javax.swing.JLabel();
        Total_Expenses = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Total_Amount_Owned = new javax.swing.JLabel();
        shadowgunimage = new javax.swing.JLabel();
        TransactionImport = new javax.swing.JPanel();
        NumberOfImports = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        EarningsTableScroll1 = new javax.swing.JScrollPane();
        ImportTable = new javax.swing.JTable();
        ImportSearchTXT = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        ShopPanel = new javax.swing.JPanel();
        ShopMenu = new javax.swing.JPanel();
        HomeLabelShop = new javax.swing.JLabel();
        FirearmLabelShop = new javax.swing.JLabel();
        CartLabelShop = new javax.swing.JLabel();
        usernameMain = new javax.swing.JLabel();
        passwordMain = new javax.swing.JLabel();
        ShopLayerPanel = new javax.swing.JPanel();
        ShopFirearms = new javax.swing.JPanel();
        FirearmProductInfo = new javax.swing.JPanel();
        FirearmImage = new javax.swing.JLabel();
        FirearmItemName = new javax.swing.JLabel();
        FirearmCost = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        FirearmQuantity = new javax.swing.JTextField();
        FirearmStock = new javax.swing.JLabel();
        pH_Button1 = new SystemOtherComps.PH_Button();
        FirearmType = new javax.swing.JLabel();
        FirearmCost1 = new javax.swing.JLabel();
        FirearmCost2 = new javax.swing.JLabel();
        addQuantity = new javax.swing.JButton();
        reduceQuantity = new javax.swing.JButton();
        pH_TextAreaScroll1 = new SystemOtherComps.PH_TextAreaScroll();
        FirearmDescription = new SystemOtherComps.PH_TextArea();
        FirearmID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FlowPanelScroll = new javax.swing.JScrollPane();
        FlowPanel = new SystemOtherComps.PH_BettterFlowLayoutPanel();
        walletPanel = new javax.swing.JPanel();
        walletTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ShopCart = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        purchaseBT = new SystemOtherComps.PH_Button();
        jLabel10 = new javax.swing.JLabel();
        cartSubtotal = new javax.swing.JTextField();
        cartTax = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cartTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cartPayment = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cartChange = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        FirearmProductInfo1 = new javax.swing.JPanel();
        cart_Image = new javax.swing.JLabel();
        cart_Name = new javax.swing.JLabel();
        cart_Cost = new javax.swing.JLabel();
        RemoveCart = new SystemOtherComps.PH_Button();
        cart_Type = new javax.swing.JLabel();
        FirearmCost4 = new javax.swing.JLabel();
        FirearmCost5 = new javax.swing.JLabel();
        pH_TextAreaScroll3 = new SystemOtherComps.PH_TextAreaScroll();
        cart_Description = new SystemOtherComps.PH_TextArea();
        EditTableScroll1 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        walletPanel1 = new javax.swing.JPanel();
        walletTxtCart = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AdminPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        FirearmItemName18 = new javax.swing.JLabel();
        admin_password = new javax.swing.JTextField();
        FirearmItemName19 = new javax.swing.JLabel();
        admin_cash = new javax.swing.JTextField();
        FirearmItemName20 = new javax.swing.JLabel();
        adminTableScroll = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        admin_status = new javax.swing.JComboBox<>();
        admin_save = new SystemOtherComps.PH_Button();
        admin_delete = new SystemOtherComps.PH_Button();
        admin_username = new javax.swing.JTextField();
        FirearmItemName17 = new javax.swing.JLabel();
        adminBackBT = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        FirearmItemName26 = new javax.swing.JLabel();
        FirearmItemName27 = new javax.swing.JLabel();
        FirearmItemName28 = new javax.swing.JLabel();
        FirearmItemName29 = new javax.swing.JLabel();
        FirearmItemName30 = new javax.swing.JLabel();
        fbicon = new javax.swing.JLabel();
        discordicon = new javax.swing.JLabel();
        githubicon = new javax.swing.JLabel();
        xicon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        FirearmItemName21 = new javax.swing.JLabel();
        FirearmItemName25 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        YTname1 = new javax.swing.JLabel();
        YTname2 = new javax.swing.JLabel();
        YTname3 = new javax.swing.JLabel();
        YTname5 = new javax.swing.JLabel();
        FirearmItemName35 = new javax.swing.JLabel();
        YTmusic1 = new javax.swing.JLabel();
        YTmusic2 = new javax.swing.JLabel();
        YTmusic3 = new javax.swing.JLabel();
        YTmusic5 = new javax.swing.JLabel();
        YTname4 = new javax.swing.JLabel();
        YTmusic4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        giflabel1 = new javax.swing.JLabel();
        giflabel2 = new javax.swing.JLabel();
        giflabel3 = new javax.swing.JLabel();
        giflabel4 = new javax.swing.JLabel();
        giflabel5 = new javax.swing.JLabel();
        VolumeYT = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        FirearmItemName37 = new javax.swing.JLabel();
        FirearmItemName38 = new javax.swing.JLabel();
        FirearmItemName41 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        FirearmItemName39 = new javax.swing.JLabel();
        FirearmItemName40 = new javax.swing.JLabel();
        FirearmItemName42 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        FirearmItemName43 = new javax.swing.JLabel();
        admin_ip = new javax.swing.JLabel();
        admin_pass = new javax.swing.JLabel();
        admin_user = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        FirearmItemName44 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        FirearmItemName45 = new javax.swing.JLabel();
        admin_active = new javax.swing.JLabel();
        admin_username2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(100, 600));
        setMinimumSize(new java.awt.Dimension(100, 600));
        setPreferredSize(new java.awt.Dimension(1300, 720));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        HomePanel.setBackground(new java.awt.Color(0, 0, 0));

        TitleMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/asaaaaaaaa.png"))); // NOI18N
        TitleMenu.setToolTipText("<html>ADMIN HEADQUARTERS<br>authorized personnel only</html>");
        TitleMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TitleMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TitleMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TitleMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TitleMenuMouseExited(evt);
            }
        });

        ShopPanelHome.setBackground(new java.awt.Color(0, 0, 0));
        ShopPanelHome.setPreferredSize(new java.awt.Dimension(187, 0));

        ShopLabel.setForeground(new java.awt.Color(0, 0, 0));
        ShopLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShopLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ShopLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ShopLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ShopPanelHomeLayout = new javax.swing.GroupLayout(ShopPanelHome);
        ShopPanelHome.setLayout(ShopPanelHomeLayout);
        ShopPanelHomeLayout.setHorizontalGroup(
            ShopPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ShopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ShopPanelHomeLayout.setVerticalGroup(
            ShopPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ShopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ProductPanelHome.setBackground(new java.awt.Color(0, 0, 0));
        ProductPanelHome.setPreferredSize(new java.awt.Dimension(187, 0));

        ProductLabel.setForeground(new java.awt.Color(0, 0, 0));
        ProductLabel.setToolTipText("AUTHORIZED PERSONNEL ONLY");
        ProductLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProductLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ProductPanelHomeLayout = new javax.swing.GroupLayout(ProductPanelHome);
        ProductPanelHome.setLayout(ProductPanelHomeLayout);
        ProductPanelHomeLayout.setHorizontalGroup(
            ProductPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ProductPanelHomeLayout.setVerticalGroup(
            ProductPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );

        TransactionPanelHome.setBackground(new java.awt.Color(0, 0, 0));
        TransactionPanelHome.setPreferredSize(new java.awt.Dimension(187, 0));

        TransactionLabel.setForeground(new java.awt.Color(0, 0, 0));
        TransactionLabel.setToolTipText("AUTHORIZED PERSONNEL ONLY");
        TransactionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TransactionLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TransactionLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout TransactionPanelHomeLayout = new javax.swing.GroupLayout(TransactionPanelHome);
        TransactionPanelHome.setLayout(TransactionPanelHomeLayout);
        TransactionPanelHomeLayout.setHorizontalGroup(
            TransactionPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TransactionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TransactionPanelHomeLayout.setVerticalGroup(
            TransactionPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionPanelHomeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(TransactionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE))
        );

        local.setBackground(new java.awt.Color(0, 0, 0));
        local.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        local.setForeground(new java.awt.Color(0, 0, 0));

        local2.setBackground(new java.awt.Color(0, 0, 0));
        local2.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        local2.setForeground(new java.awt.Color(0, 0, 0));

        local3.setBackground(new java.awt.Color(0, 0, 0));
        local3.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        local3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(ShopPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(ProductPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(TransactionPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addComponent(TitleMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(local3)
                .addGap(48, 48, 48)
                .addComponent(local)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(local2)
                .addGap(1225, 1225, 1225))
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                .addComponent(TitleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProductPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addComponent(TransactionPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addComponent(ShopPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(local2)
                .addGap(2, 2, 2)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(local3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        getContentPane().add(HomePanel);

        ProductPanel.setBackground(new java.awt.Color(0, 0, 0));

        ProductMenu.setBackground(new java.awt.Color(0, 0, 0));

        HomeLabelProduct.setBackground(new java.awt.Color(0, 0, 0));
        HomeLabelProduct.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        HomeLabelProduct.setForeground(new java.awt.Color(255, 255, 255));
        HomeLabelProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HomeIcon.jpg"))); // NOI18N
        HomeLabelProduct.setText("HOME");
        HomeLabelProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HomeLabelProduct.setOpaque(true);
        HomeLabelProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeLabelProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeLabelProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeLabelProductMouseExited(evt);
            }
        });

        AddProductLabelProduct.setBackground(new java.awt.Color(0, 0, 0));
        AddProductLabelProduct.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        AddProductLabelProduct.setForeground(new java.awt.Color(255, 255, 255));
        AddProductLabelProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add gun icon.jpg"))); // NOI18N
        AddProductLabelProduct.setText("ADD ITEM");
        AddProductLabelProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AddProductLabelProduct.setOpaque(true);
        AddProductLabelProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddProductLabelProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddProductLabelProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddProductLabelProductMouseExited(evt);
            }
        });

        EditProductLabelProduct.setBackground(new java.awt.Color(0, 0, 0));
        EditProductLabelProduct.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        EditProductLabelProduct.setForeground(new java.awt.Color(255, 255, 255));
        EditProductLabelProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit ICON.jpg"))); // NOI18N
        EditProductLabelProduct.setText("EDIT PRODUCT");
        EditProductLabelProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EditProductLabelProduct.setOpaque(true);
        EditProductLabelProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditProductLabelProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditProductLabelProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditProductLabelProductMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ProductMenuLayout = new javax.swing.GroupLayout(ProductMenu);
        ProductMenu.setLayout(ProductMenuLayout);
        ProductMenuLayout.setHorizontalGroup(
            ProductMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeLabelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AddProductLabelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(EditProductLabelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ProductMenuLayout.setVerticalGroup(
            ProductMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeLabelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddProductLabelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditProductLabelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(865, Short.MAX_VALUE))
        );

        ProductLayerPanel.setBackground(new java.awt.Color(255, 153, 0));
        ProductLayerPanel.setLayout(new javax.swing.OverlayLayout(ProductLayerPanel));

        AddProductPanel.setBackground(new java.awt.Color(0, 0, 0));

        productImage.setBackground(new java.awt.Color(20, 20, 20));
        productImage.setForeground(new java.awt.Color(255, 255, 255));
        productImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/insertimage.jpg"))); // NOI18N
        productImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        productImage.setOpaque(true);
        productImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productImageMouseClicked(evt);
            }
        });

        removeImage.setBackground(new java.awt.Color(0, 0, 0));
        removeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trashIcon.jpg"))); // NOI18N
        removeImage.setBorder(null);
        removeImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeImageActionPerformed(evt);
            }
        });

        FirearmItemName1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName1.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName1.setText("PRODUCT ID");
        FirearmItemName1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        add_id.setBackground(new java.awt.Color(21, 21, 21));
        add_id.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_id.setForeground(new java.awt.Color(255, 255, 255));
        add_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        add_id.setCaretColor(new java.awt.Color(255, 255, 255));
        add_id.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName2.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName2.setText("ITEM NAME");
        FirearmItemName2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        add_name.setBackground(new java.awt.Color(21, 21, 21));
        add_name.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_name.setForeground(new java.awt.Color(255, 255, 255));
        add_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        add_name.setCaretColor(new java.awt.Color(255, 255, 255));
        add_name.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName3.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName3.setText("COST");
        FirearmItemName3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName4.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName4.setText("STOCK");
        FirearmItemName4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName5.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName5.setText("WEAPON TYPE");
        FirearmItemName5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        add_cost.setBackground(new java.awt.Color(21, 21, 21));
        add_cost.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_cost.setForeground(new java.awt.Color(255, 255, 255));
        add_cost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        add_cost.setCaretColor(new java.awt.Color(255, 255, 255));
        add_cost.setSelectionColor(new java.awt.Color(38, 38, 38));
        add_cost.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                add_costCaretUpdate(evt);
            }
        });

        add_stock.setBackground(new java.awt.Color(21, 21, 21));
        add_stock.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_stock.setForeground(new java.awt.Color(255, 255, 255));
        add_stock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        add_stock.setCaretColor(new java.awt.Color(255, 255, 255));
        add_stock.setSelectionColor(new java.awt.Color(38, 38, 38));
        add_stock.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                add_stockCaretUpdate(evt);
            }
        });

        add_type.setBackground(new java.awt.Color(21, 21, 21));
        add_type.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_type.setForeground(new java.awt.Color(255, 255, 255));
        add_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Handgun", "Semi-automatic Pistol", "Bolt-action rifle", "Semi-automatic rifle", "Assault rifle", "Marksman Rifle", "Sniper Rifle", "Anti-material rifle", "Anti-tank Rifle", "Shotgun", "Automatic Shotgun", "Sawed-Off Shotgun", "Submachine Gun (SMG)", "Light Machine Gun (LMG)", "Medium Machine Gun (MMG)", "Heavy Machine Gun (HMG)", "Carbine", "Grenade Launcher", "RPG", "Anti-tank Missile", "Flamethrower", "Gatling Gun", "Chain Gun", "Minigun", "Artillery Gun", "Howitzer", "Mortar", "Stun Gun", "Flare Gun", "Granade", "Mine", "Ammunition", "Consumable" }));
        add_type.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));

        add_description.setBackground(new java.awt.Color(21, 21, 21));
        add_description.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_description.setForeground(new java.awt.Color(255, 255, 255));
        add_description.setCaretColor(new java.awt.Color(255, 255, 255));
        add_description.setSelectionColor(new java.awt.Color(38, 38, 38));
        jScrollPane1.setViewportView(add_description);

        add_businessFunds.setEditable(false);
        add_businessFunds.setBackground(new java.awt.Color(20, 20, 20));
        add_businessFunds.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_businessFunds.setForeground(new java.awt.Color(255, 255, 255));
        add_businessFunds.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add_businessFunds.setText("0");
        add_businessFunds.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        add_businessFunds.setCaretColor(new java.awt.Color(255, 255, 255));
        add_businessFunds.setSelectionColor(new java.awt.Color(38, 38, 38));

        add_importFee.setEditable(false);
        add_importFee.setBackground(new java.awt.Color(20, 20, 20));
        add_importFee.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_importFee.setForeground(new java.awt.Color(255, 255, 255));
        add_importFee.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add_importFee.setText("0");
        add_importFee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        add_importFee.setCaretColor(new java.awt.Color(255, 255, 255));
        add_importFee.setOpaque(true);
        add_importFee.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName14.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName14.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName14.setText("IMPORT FEE");
        FirearmItemName14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        saveBT.setBackground(new java.awt.Color(20, 20, 20));
        saveBT.setForeground(new java.awt.Color(255, 255, 255));
        saveBT.setText("SAVE");
        saveBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        saveBT.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        saveBT.setAA_DrawBorder(true);
        saveBT.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        saveBT.setAA_PressColor(new java.awt.Color(20, 20, 20));
        saveBT.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        saveBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        saveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTActionPerformed(evt);
            }
        });

        clearBT.setBackground(new java.awt.Color(20, 20, 20));
        clearBT.setForeground(new java.awt.Color(255, 255, 255));
        clearBT.setText("CLEAR");
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

        FirearmItemName36.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName36.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        FirearmItemName36.setText("DAMAGE");
        FirearmItemName36.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        add_power.setBackground(new java.awt.Color(0, 0, 0));
        add_power.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_power.setForeground(new java.awt.Color(255, 255, 255));
        add_power.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add_power.setText("0");
        add_power.setBorder(null);
        add_power.setCaretColor(new java.awt.Color(255, 255, 255));
        add_power.setSelectionColor(new java.awt.Color(38, 38, 38));

        add_firerate.setBackground(new java.awt.Color(0, 0, 0));
        add_firerate.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_firerate.setForeground(new java.awt.Color(255, 255, 255));
        add_firerate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add_firerate.setText("0");
        add_firerate.setBorder(null);
        add_firerate.setCaretColor(new java.awt.Color(255, 255, 255));
        add_firerate.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName46.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName46.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName46.setText("FIRE RATE");
        FirearmItemName46.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        FirearmItemName47.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName47.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName47.setText("ACCURACY");
        FirearmItemName47.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        add_ammo.setBackground(new java.awt.Color(0, 0, 0));
        add_ammo.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_ammo.setForeground(new java.awt.Color(255, 255, 255));
        add_ammo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add_ammo.setText("0");
        add_ammo.setBorder(null);
        add_ammo.setCaretColor(new java.awt.Color(255, 255, 255));
        add_ammo.setSelectionColor(new java.awt.Color(38, 38, 38));

        add_reloadspeed.setBackground(new java.awt.Color(0, 0, 0));
        add_reloadspeed.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        add_reloadspeed.setForeground(new java.awt.Color(255, 255, 255));
        add_reloadspeed.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add_reloadspeed.setText("0");
        add_reloadspeed.setBorder(null);
        add_reloadspeed.setCaretColor(new java.awt.Color(255, 255, 255));
        add_reloadspeed.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName48.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName48.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName48.setText("RELOAD SPEED");
        FirearmItemName48.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jPanel12.setBackground(new java.awt.Color(66, 66, 66));
        jPanel12.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        FirearmItemName49.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName49.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName49.setText("STATS");
        FirearmItemName49.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName50.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName50.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName50.setText("BUSINESS FUNDS");
        FirearmItemName50.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName51.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName51.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName51.setText("WEAPON DETAILS");
        FirearmItemName51.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel13.setBackground(new java.awt.Color(66, 66, 66));
        jPanel13.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        FirearmItemName52.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName52.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName52.setText("IMAGE");
        FirearmItemName52.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel14.setBackground(new java.awt.Color(66, 66, 66));
        jPanel14.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        FirearmItemName53.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName53.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName53.setText("DESCRIPTION");
        FirearmItemName53.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel15.setBackground(new java.awt.Color(66, 66, 66));
        jPanel15.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dmg.jpg"))); // NOI18N
        jLabel21.setText(" ");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fr.jpg"))); // NOI18N
        jLabel22.setText(" ");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rs.jpg"))); // NOI18N
        jLabel23.setText(" ");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginlogo.jpg"))); // NOI18N
        jLabel24.setText(" ");

        p2.setEditable(false);
        p2.setBackground(new java.awt.Color(21, 21, 21));
        p2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p2.setForeground(new java.awt.Color(255, 255, 255));
        p2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p2.setCaretColor(new java.awt.Color(255, 255, 255));
        p2.setSelectionColor(new java.awt.Color(38, 38, 38));
        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2MouseClicked(evt);
            }
        });

        p3.setEditable(false);
        p3.setBackground(new java.awt.Color(21, 21, 21));
        p3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p3.setForeground(new java.awt.Color(255, 255, 255));
        p3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p3.setCaretColor(new java.awt.Color(255, 255, 255));
        p3.setSelectionColor(new java.awt.Color(38, 38, 38));
        p3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p3MouseClicked(evt);
            }
        });

        p4.setEditable(false);
        p4.setBackground(new java.awt.Color(21, 21, 21));
        p4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p4.setForeground(new java.awt.Color(255, 255, 255));
        p4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p4.setCaretColor(new java.awt.Color(255, 255, 255));
        p4.setSelectionColor(new java.awt.Color(38, 38, 38));
        p4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p4MouseClicked(evt);
            }
        });

        p5.setEditable(false);
        p5.setBackground(new java.awt.Color(21, 21, 21));
        p5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p5.setForeground(new java.awt.Color(255, 255, 255));
        p5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p5.setCaretColor(new java.awt.Color(255, 255, 255));
        p5.setSelectionColor(new java.awt.Color(38, 38, 38));
        p5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p5MouseClicked(evt);
            }
        });

        p6.setEditable(false);
        p6.setBackground(new java.awt.Color(21, 21, 21));
        p6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p6.setForeground(new java.awt.Color(255, 255, 255));
        p6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p6.setCaretColor(new java.awt.Color(255, 255, 255));
        p6.setSelectionColor(new java.awt.Color(38, 38, 38));
        p6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p6MouseClicked(evt);
            }
        });

        p7.setEditable(false);
        p7.setBackground(new java.awt.Color(21, 21, 21));
        p7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p7.setForeground(new java.awt.Color(255, 255, 255));
        p7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p7.setCaretColor(new java.awt.Color(255, 255, 255));
        p7.setSelectionColor(new java.awt.Color(38, 38, 38));
        p7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p7MouseClicked(evt);
            }
        });

        p8.setEditable(false);
        p8.setBackground(new java.awt.Color(21, 21, 21));
        p8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p8.setForeground(new java.awt.Color(255, 255, 255));
        p8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p8.setCaretColor(new java.awt.Color(255, 255, 255));
        p8.setSelectionColor(new java.awt.Color(38, 38, 38));
        p8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p8MouseClicked(evt);
            }
        });

        p9.setEditable(false);
        p9.setBackground(new java.awt.Color(21, 21, 21));
        p9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p9.setForeground(new java.awt.Color(255, 255, 255));
        p9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p9.setCaretColor(new java.awt.Color(255, 255, 255));
        p9.setSelectionColor(new java.awt.Color(38, 38, 38));
        p9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p9MouseClicked(evt);
            }
        });

        p10.setEditable(false);
        p10.setBackground(new java.awt.Color(21, 21, 21));
        p10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p10.setForeground(new java.awt.Color(255, 255, 255));
        p10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p10.setCaretColor(new java.awt.Color(255, 255, 255));
        p10.setSelectionColor(new java.awt.Color(38, 38, 38));
        p10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p10MouseClicked(evt);
            }
        });

        p1.setEditable(false);
        p1.setBackground(new java.awt.Color(21, 21, 21));
        p1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 255, 255));
        p1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        p1.setCaretColor(new java.awt.Color(255, 255, 255));
        p1.setSelectionColor(new java.awt.Color(38, 38, 38));
        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
        });

        fr1.setEditable(false);
        fr1.setBackground(new java.awt.Color(21, 21, 21));
        fr1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr1.setForeground(new java.awt.Color(255, 255, 255));
        fr1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr1.setCaretColor(new java.awt.Color(255, 255, 255));
        fr1.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr1MouseClicked(evt);
            }
        });

        fr10.setEditable(false);
        fr10.setBackground(new java.awt.Color(21, 21, 21));
        fr10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr10.setForeground(new java.awt.Color(255, 255, 255));
        fr10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr10.setCaretColor(new java.awt.Color(255, 255, 255));
        fr10.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr10MouseClicked(evt);
            }
        });

        fr9.setEditable(false);
        fr9.setBackground(new java.awt.Color(21, 21, 21));
        fr9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr9.setForeground(new java.awt.Color(255, 255, 255));
        fr9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr9.setCaretColor(new java.awt.Color(255, 255, 255));
        fr9.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr9MouseClicked(evt);
            }
        });

        fr8.setEditable(false);
        fr8.setBackground(new java.awt.Color(21, 21, 21));
        fr8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr8.setForeground(new java.awt.Color(255, 255, 255));
        fr8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr8.setCaretColor(new java.awt.Color(255, 255, 255));
        fr8.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr8MouseClicked(evt);
            }
        });

        fr7.setEditable(false);
        fr7.setBackground(new java.awt.Color(21, 21, 21));
        fr7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr7.setForeground(new java.awt.Color(255, 255, 255));
        fr7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr7.setCaretColor(new java.awt.Color(255, 255, 255));
        fr7.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr7MouseClicked(evt);
            }
        });

        fr6.setEditable(false);
        fr6.setBackground(new java.awt.Color(21, 21, 21));
        fr6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr6.setForeground(new java.awt.Color(255, 255, 255));
        fr6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr6.setCaretColor(new java.awt.Color(255, 255, 255));
        fr6.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr6MouseClicked(evt);
            }
        });

        fr5.setEditable(false);
        fr5.setBackground(new java.awt.Color(21, 21, 21));
        fr5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr5.setForeground(new java.awt.Color(255, 255, 255));
        fr5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr5.setCaretColor(new java.awt.Color(255, 255, 255));
        fr5.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr5MouseClicked(evt);
            }
        });

        fr4.setEditable(false);
        fr4.setBackground(new java.awt.Color(21, 21, 21));
        fr4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr4.setForeground(new java.awt.Color(255, 255, 255));
        fr4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr4.setCaretColor(new java.awt.Color(255, 255, 255));
        fr4.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr4MouseClicked(evt);
            }
        });

        fr3.setEditable(false);
        fr3.setBackground(new java.awt.Color(21, 21, 21));
        fr3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr3.setForeground(new java.awt.Color(255, 255, 255));
        fr3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr3.setCaretColor(new java.awt.Color(255, 255, 255));
        fr3.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr3MouseClicked(evt);
            }
        });

        fr2.setEditable(false);
        fr2.setBackground(new java.awt.Color(21, 21, 21));
        fr2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        fr2.setForeground(new java.awt.Color(255, 255, 255));
        fr2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        fr2.setCaretColor(new java.awt.Color(255, 255, 255));
        fr2.setSelectionColor(new java.awt.Color(38, 38, 38));
        fr2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr2MouseClicked(evt);
            }
        });

        r8.setEditable(false);
        r8.setBackground(new java.awt.Color(21, 21, 21));
        r8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r8.setForeground(new java.awt.Color(255, 255, 255));
        r8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r8.setCaretColor(new java.awt.Color(255, 255, 255));
        r8.setSelectionColor(new java.awt.Color(38, 38, 38));
        r8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r8MouseClicked(evt);
            }
        });

        r1.setEditable(false);
        r1.setBackground(new java.awt.Color(21, 21, 21));
        r1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r1.setForeground(new java.awt.Color(255, 255, 255));
        r1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r1.setCaretColor(new java.awt.Color(255, 255, 255));
        r1.setSelectionColor(new java.awt.Color(38, 38, 38));
        r1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r1MouseClicked(evt);
            }
        });

        r6.setEditable(false);
        r6.setBackground(new java.awt.Color(21, 21, 21));
        r6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r6.setForeground(new java.awt.Color(255, 255, 255));
        r6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r6.setCaretColor(new java.awt.Color(255, 255, 255));
        r6.setSelectionColor(new java.awt.Color(38, 38, 38));
        r6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r6MouseClicked(evt);
            }
        });

        r3.setEditable(false);
        r3.setBackground(new java.awt.Color(21, 21, 21));
        r3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r3.setForeground(new java.awt.Color(255, 255, 255));
        r3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r3.setCaretColor(new java.awt.Color(255, 255, 255));
        r3.setSelectionColor(new java.awt.Color(38, 38, 38));
        r3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r3MouseClicked(evt);
            }
        });

        r10.setEditable(false);
        r10.setBackground(new java.awt.Color(21, 21, 21));
        r10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r10.setForeground(new java.awt.Color(255, 255, 255));
        r10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r10.setCaretColor(new java.awt.Color(255, 255, 255));
        r10.setSelectionColor(new java.awt.Color(38, 38, 38));
        r10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r10MouseClicked(evt);
            }
        });

        r5.setEditable(false);
        r5.setBackground(new java.awt.Color(21, 21, 21));
        r5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r5.setForeground(new java.awt.Color(255, 255, 255));
        r5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r5.setCaretColor(new java.awt.Color(255, 255, 255));
        r5.setSelectionColor(new java.awt.Color(38, 38, 38));
        r5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r5MouseClicked(evt);
            }
        });

        r7.setEditable(false);
        r7.setBackground(new java.awt.Color(21, 21, 21));
        r7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r7.setForeground(new java.awt.Color(255, 255, 255));
        r7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r7.setCaretColor(new java.awt.Color(255, 255, 255));
        r7.setSelectionColor(new java.awt.Color(38, 38, 38));
        r7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r7MouseClicked(evt);
            }
        });

        r2.setEditable(false);
        r2.setBackground(new java.awt.Color(21, 21, 21));
        r2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r2.setForeground(new java.awt.Color(255, 255, 255));
        r2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r2.setCaretColor(new java.awt.Color(255, 255, 255));
        r2.setSelectionColor(new java.awt.Color(38, 38, 38));
        r2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r2MouseClicked(evt);
            }
        });

        r9.setEditable(false);
        r9.setBackground(new java.awt.Color(21, 21, 21));
        r9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r9.setForeground(new java.awt.Color(255, 255, 255));
        r9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r9.setCaretColor(new java.awt.Color(255, 255, 255));
        r9.setSelectionColor(new java.awt.Color(38, 38, 38));
        r9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r9MouseClicked(evt);
            }
        });

        r4.setEditable(false);
        r4.setBackground(new java.awt.Color(21, 21, 21));
        r4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        r4.setForeground(new java.awt.Color(255, 255, 255));
        r4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        r4.setCaretColor(new java.awt.Color(255, 255, 255));
        r4.setSelectionColor(new java.awt.Color(38, 38, 38));
        r4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r4MouseClicked(evt);
            }
        });

        a3.setEditable(false);
        a3.setBackground(new java.awt.Color(21, 21, 21));
        a3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a3.setForeground(new java.awt.Color(255, 255, 255));
        a3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a3.setCaretColor(new java.awt.Color(255, 255, 255));
        a3.setSelectionColor(new java.awt.Color(38, 38, 38));
        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a3MouseClicked(evt);
            }
        });

        a8.setEditable(false);
        a8.setBackground(new java.awt.Color(21, 21, 21));
        a8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a8.setForeground(new java.awt.Color(255, 255, 255));
        a8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a8.setCaretColor(new java.awt.Color(255, 255, 255));
        a8.setSelectionColor(new java.awt.Color(38, 38, 38));
        a8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a8MouseClicked(evt);
            }
        });

        a6.setEditable(false);
        a6.setBackground(new java.awt.Color(21, 21, 21));
        a6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a6.setForeground(new java.awt.Color(255, 255, 255));
        a6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a6.setCaretColor(new java.awt.Color(255, 255, 255));
        a6.setSelectionColor(new java.awt.Color(38, 38, 38));
        a6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a6MouseClicked(evt);
            }
        });

        a1.setEditable(false);
        a1.setBackground(new java.awt.Color(21, 21, 21));
        a1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a1.setForeground(new java.awt.Color(255, 255, 255));
        a1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a1.setCaretColor(new java.awt.Color(255, 255, 255));
        a1.setSelectionColor(new java.awt.Color(38, 38, 38));
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a1MouseClicked(evt);
            }
        });

        a4.setEditable(false);
        a4.setBackground(new java.awt.Color(21, 21, 21));
        a4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a4.setForeground(new java.awt.Color(255, 255, 255));
        a4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a4.setCaretColor(new java.awt.Color(255, 255, 255));
        a4.setSelectionColor(new java.awt.Color(38, 38, 38));
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a4MouseClicked(evt);
            }
        });

        a10.setEditable(false);
        a10.setBackground(new java.awt.Color(21, 21, 21));
        a10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a10.setForeground(new java.awt.Color(255, 255, 255));
        a10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a10.setCaretColor(new java.awt.Color(255, 255, 255));
        a10.setSelectionColor(new java.awt.Color(38, 38, 38));
        a10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a10MouseClicked(evt);
            }
        });

        a2.setEditable(false);
        a2.setBackground(new java.awt.Color(21, 21, 21));
        a2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a2.setForeground(new java.awt.Color(255, 255, 255));
        a2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a2.setCaretColor(new java.awt.Color(255, 255, 255));
        a2.setSelectionColor(new java.awt.Color(38, 38, 38));
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2MouseClicked(evt);
            }
        });

        a9.setEditable(false);
        a9.setBackground(new java.awt.Color(21, 21, 21));
        a9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a9.setForeground(new java.awt.Color(255, 255, 255));
        a9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a9.setCaretColor(new java.awt.Color(255, 255, 255));
        a9.setSelectionColor(new java.awt.Color(38, 38, 38));
        a9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a9MouseClicked(evt);
            }
        });

        a5.setEditable(false);
        a5.setBackground(new java.awt.Color(21, 21, 21));
        a5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a5.setForeground(new java.awt.Color(255, 255, 255));
        a5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a5.setCaretColor(new java.awt.Color(255, 255, 255));
        a5.setSelectionColor(new java.awt.Color(38, 38, 38));
        a5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a5MouseClicked(evt);
            }
        });

        a7.setEditable(false);
        a7.setBackground(new java.awt.Color(21, 21, 21));
        a7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        a7.setForeground(new java.awt.Color(255, 255, 255));
        a7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        a7.setCaretColor(new java.awt.Color(255, 255, 255));
        a7.setSelectionColor(new java.awt.Color(38, 38, 38));
        a7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout AddProductPanelLayout = new javax.swing.GroupLayout(AddProductPanel);
        AddProductPanel.setLayout(AddProductPanelLayout);
        AddProductPanelLayout.setHorizontalGroup(
            AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addGap(537, 537, 537)
                        .addComponent(removeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(FirearmItemName50)
                                            .addComponent(FirearmItemName14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(add_importFee, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                            .addComponent(FirearmItemName52, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                            .addComponent(FirearmItemName53, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(add_imageName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createSequentialGroup()
                                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                        .addComponent(add_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(14, 14, 14))
                                                    .addComponent(FirearmItemName2)
                                                    .addComponent(FirearmItemName1)
                                                    .addComponent(FirearmItemName3)
                                                    .addComponent(FirearmItemName4)
                                                    .addComponent(FirearmItemName5)
                                                    .addComponent(FirearmItemName47)
                                                    .addComponent(FirearmItemName46)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(FirearmItemName36, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                                        .addComponent(add_type, javax.swing.GroupLayout.Alignment.LEADING, 0, 478, Short.MAX_VALUE)
                                                        .addComponent(add_stock, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(add_cost, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(add_name, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(add_id, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                                        .addComponent(FirearmItemName49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(FirearmItemName51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createSequentialGroup()
                                                        .addComponent(clearBT, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(saveBT, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(add_power, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(12, 12, 12))))
                                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                        .addComponent(fr1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fr10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(add_firerate, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                                .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(add_ammo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                                                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(add_reloadspeed, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(11, 11, 11)))))
                                .addGap(13, 13, 13))
                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                .addGap(498, 498, 498)
                                .addComponent(FirearmItemName48))
                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(add_businessFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        AddProductPanelLayout.setVerticalGroup(
            AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProductPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addComponent(FirearmItemName51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                .addComponent(add_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add_imageName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addComponent(FirearmItemName52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmItemName1)
                            .addComponent(add_id, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmItemName2)
                            .addComponent(add_name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmItemName3)
                            .addComponent(add_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmItemName4)
                            .addComponent(add_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmItemName5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_type, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createSequentialGroup()
                                .addComponent(FirearmItemName49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createSequentialGroup()
                                .addComponent(FirearmItemName53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(FirearmItemName36)
                                            .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(add_power, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10)
                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FirearmItemName46)
                                    .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(add_firerate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductPanelLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(add_reloadspeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddProductPanelLayout.createSequentialGroup()
                                .addComponent(FirearmItemName48)
                                .addGap(12, 12, 12)
                                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(add_ammo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(FirearmItemName47, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FirearmItemName50)
                            .addComponent(add_businessFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_importFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FirearmItemName14)))
                    .addGroup(AddProductPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(AddProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveBT, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBT, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))))
                .addGap(326, 326, 326))
        );

        ProductLayerPanel.add(AddProductPanel);

        EditProductPanel.setBackground(new java.awt.Color(0, 0, 0));

        EditTable.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        EditTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCT", "COST", "STOCK", "TYPE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EditTable.setRowHeight(30);
        EditTable.getTableHeader().setReorderingAllowed(false);
        EditTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditTableMouseClicked(evt);
            }
        });
        EditTableScroll.setViewportView(EditTable);
        if (EditTable.getColumnModel().getColumnCount() > 0) {
            EditTable.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        InfoPanelEdit.setBackground(new java.awt.Color(6, 6, 6));
        InfoPanelEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));

        productImageEdit.setBackground(new java.awt.Color(20, 20, 20));
        productImageEdit.setToolTipText("<html>CLICK TO EDIT IMAGE<br>RIGHT CLICK TO REMOVE IMAGE</html>");
        productImageEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        productImageEdit.setOpaque(true);
        productImageEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productImageEditMouseClicked(evt);
            }
        });

        FirearmItemName7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName7.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName7.setText("PRODUCT ID");
        FirearmItemName7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName8.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName8.setText("ITEM NAME");
        FirearmItemName8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName9.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName9.setText("COST");
        FirearmItemName9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName10.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName10.setText("STOCK");
        FirearmItemName10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName11.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName11.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName11.setText("WEAPON TYPE");
        FirearmItemName11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        edit_cost.setBackground(new java.awt.Color(20, 20, 20));
        edit_cost.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_cost.setForeground(new java.awt.Color(255, 255, 255));
        edit_cost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_cost.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_cost.setSelectionColor(new java.awt.Color(38, 38, 38));

        edit_stock.setEditable(false);
        edit_stock.setBackground(new java.awt.Color(25, 25, 25));
        edit_stock.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_stock.setForeground(new java.awt.Color(255, 255, 255));
        edit_stock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_stock.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_stock.setSelectionColor(new java.awt.Color(38, 38, 38));

        edit_name.setBackground(new java.awt.Color(20, 20, 20));
        edit_name.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_name.setForeground(new java.awt.Color(255, 255, 255));
        edit_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_name.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_name.setSelectionColor(new java.awt.Color(38, 38, 38));

        edit_type.setBackground(new java.awt.Color(20, 20, 20));
        edit_type.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Handgun", "Semi-automatic Pistol", "Bolt-action rifle", "Semi-automatic rifle", "Assault rifle", "Marksman Rifle", "Sniper Rifle", "Anti-material rifle", "Anti-tank Rifle", "Shotgun", "Automatic Shotgun", "Sawed-Off Shotgun", "Submachine Gun (SMG)", "Light Machine Gun (LMG)", "Medium Machine Gun (MMG)", "Heavy Machine Gun (HMG)", "Carbine", "Grenade Launcher", "RPG", "Anti-tank Missile", "Flamethrower", "Gatling Gun", "Chain Gun", "Minigun", "Artillery Gun", "Howitzer", "Mortar", "Stun Gun", "Flare Gun", "Granade", "Mine", "Ammunition", "Consumable" }));
        edit_type.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));

        edit_id.setBackground(new java.awt.Color(20, 20, 20));
        edit_id.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_id.setForeground(new java.awt.Color(255, 255, 255));
        edit_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_id.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_id.setSelectionColor(new java.awt.Color(38, 38, 38));

        decrease_stock.setBackground(new java.awt.Color(20, 20, 20));
        decrease_stock.setText("-");
        decrease_stock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        decrease_stock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        decrease_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrease_stockActionPerformed(evt);
            }
        });
        decrease_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                decrease_stockKeyTyped(evt);
            }
        });

        UpdateBT.setBackground(new java.awt.Color(20, 20, 20));
        UpdateBT.setForeground(new java.awt.Color(255, 255, 255));
        UpdateBT.setText("UPDATE");
        UpdateBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        UpdateBT.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        UpdateBT.setAA_DrawBorder(true);
        UpdateBT.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        UpdateBT.setAA_PressColor(new java.awt.Color(20, 20, 20));
        UpdateBT.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        UpdateBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        UpdateBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTActionPerformed(evt);
            }
        });

        pH_TextAreaScroll2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        pH_TextAreaScroll2.setLabelText("DESCRIPTION");
        pH_TextAreaScroll2.setLineColor(new java.awt.Color(32, 32, 32));

        edit_description.setBackground(new java.awt.Color(20, 20, 20));
        edit_description.setColumns(20);
        edit_description.setForeground(new java.awt.Color(255, 255, 255));
        edit_description.setRows(5);
        edit_description.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_description.setSelectionColor(new java.awt.Color(32, 32, 32));
        pH_TextAreaScroll2.setViewportView(edit_description);

        edit_fee.setEditable(false);
        edit_fee.setBackground(new java.awt.Color(25, 25, 25));
        edit_fee.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_fee.setForeground(new java.awt.Color(52, 196, 57));
        edit_fee.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edit_fee.setText("0");
        edit_fee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_fee.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_fee.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName12.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName12.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName12.setText("EDIT FEE");
        FirearmItemName12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        increase_stock.setBackground(new java.awt.Color(20, 20, 20));
        increase_stock.setText("+");
        increase_stock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        increase_stock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        increase_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increase_stockActionPerformed(evt);
            }
        });
        increase_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                increase_stockKeyTyped(evt);
            }
        });

        new_stock.setEditable(false);
        new_stock.setBackground(new java.awt.Color(20, 20, 20));
        new_stock.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        new_stock.setForeground(new java.awt.Color(255, 255, 255));
        new_stock.setText("0");
        new_stock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        new_stock.setCaretColor(new java.awt.Color(255, 255, 255));
        new_stock.setSelectionColor(new java.awt.Color(38, 38, 38));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel17.setText("                                        owned stocks                                buy stocks");

        FirearmItemName16.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName16.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName16.setText("ORIGINAL PRICE");
        FirearmItemName16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        OriginalPrice.setEditable(false);
        OriginalPrice.setBackground(new java.awt.Color(25, 25, 25));
        OriginalPrice.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        OriginalPrice.setForeground(new java.awt.Color(255, 255, 255));
        OriginalPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        OriginalPrice.setCaretColor(new java.awt.Color(255, 255, 255));
        OriginalPrice.setSelectionColor(new java.awt.Color(38, 38, 38));

        edit_power.setBackground(new java.awt.Color(20, 20, 20));
        edit_power.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_power.setForeground(new java.awt.Color(255, 255, 255));
        edit_power.setToolTipText("Damage");
        edit_power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_power.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_power.setSelectionColor(new java.awt.Color(38, 38, 38));

        edit_firerate.setBackground(new java.awt.Color(20, 20, 20));
        edit_firerate.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_firerate.setForeground(new java.awt.Color(255, 255, 255));
        edit_firerate.setToolTipText("Firerate");
        edit_firerate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_firerate.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_firerate.setSelectionColor(new java.awt.Color(38, 38, 38));

        edit_reloadspeed.setBackground(new java.awt.Color(20, 20, 20));
        edit_reloadspeed.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_reloadspeed.setForeground(new java.awt.Color(255, 255, 255));
        edit_reloadspeed.setToolTipText("Reload Speed");
        edit_reloadspeed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_reloadspeed.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_reloadspeed.setSelectionColor(new java.awt.Color(38, 38, 38));

        edit_ammo.setBackground(new java.awt.Color(20, 20, 20));
        edit_ammo.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_ammo.setForeground(new java.awt.Color(255, 255, 255));
        edit_ammo.setToolTipText("Accuracy");
        edit_ammo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_ammo.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_ammo.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName31.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName31.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dmg.jpg"))); // NOI18N
        FirearmItemName31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName54.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName54.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fr.jpg"))); // NOI18N
        FirearmItemName54.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName55.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName55.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rs.jpg"))); // NOI18N
        FirearmItemName55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName56.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName56.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginlogo.jpg"))); // NOI18N
        FirearmItemName56.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addpower.setBackground(new java.awt.Color(20, 20, 20));
        addpower.setText("+");
        addpower.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        addpower.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addpower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpowerActionPerformed(evt);
            }
        });

        reducepower.setBackground(new java.awt.Color(20, 20, 20));
        reducepower.setText("-");
        reducepower.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        reducepower.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reducepower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reducepowerActionPerformed(evt);
            }
        });

        addfirerate.setBackground(new java.awt.Color(20, 20, 20));
        addfirerate.setText("+");
        addfirerate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        addfirerate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addfirerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addfirerateActionPerformed(evt);
            }
        });

        reducefirerate.setBackground(new java.awt.Color(20, 20, 20));
        reducefirerate.setText("-");
        reducefirerate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        reducefirerate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reducefirerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reducefirerateActionPerformed(evt);
            }
        });

        addreloadspeed.setBackground(new java.awt.Color(20, 20, 20));
        addreloadspeed.setText("+");
        addreloadspeed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        addreloadspeed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addreloadspeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addreloadspeedActionPerformed(evt);
            }
        });

        reducereloadspeed.setBackground(new java.awt.Color(20, 20, 20));
        reducereloadspeed.setText("-");
        reducereloadspeed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        reducereloadspeed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reducereloadspeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reducereloadspeedActionPerformed(evt);
            }
        });

        addaccuracy.setBackground(new java.awt.Color(20, 20, 20));
        addaccuracy.setText("+");
        addaccuracy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        addaccuracy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addaccuracy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addaccuracyActionPerformed(evt);
            }
        });

        reduceaccuracy.setBackground(new java.awt.Color(20, 20, 20));
        reduceaccuracy.setText("-");
        reduceaccuracy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        reduceaccuracy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reduceaccuracy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reduceaccuracyActionPerformed(evt);
            }
        });

        RemoveBT.setBackground(new java.awt.Color(20, 20, 20));
        RemoveBT.setForeground(new java.awt.Color(255, 255, 255));
        RemoveBT.setText("REMOVE");
        RemoveBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        RemoveBT.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        RemoveBT.setAA_DrawBorder(true);
        RemoveBT.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        RemoveBT.setAA_PressColor(new java.awt.Color(20, 20, 20));
        RemoveBT.setAA_RippleColor(new java.awt.Color(201, 15, 15));
        RemoveBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        RemoveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoPanelEditLayout = new javax.swing.GroupLayout(InfoPanelEdit);
        InfoPanelEdit.setLayout(InfoPanelEditLayout);
        InfoPanelEditLayout.setHorizontalGroup(
            InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pH_TextAreaScroll2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(InfoPanelEditLayout.createSequentialGroup()
                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(FirearmItemName10)
                                .addGap(164, 164, 164)
                                .addComponent(new_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decrease_stock)
                            .addComponent(increase_stock)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InfoPanelEditLayout.createSequentialGroup()
                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FirearmItemName11)
                            .addComponent(FirearmItemName9)
                            .addComponent(FirearmItemName16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OriginalPrice)
                            .addComponent(edit_cost)
                            .addComponent(edit_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                .addComponent(edit_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InfoPanelEditLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(FirearmItemName12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_fee))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InfoPanelEditLayout.createSequentialGroup()
                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(FirearmItemName8)
                                    .addComponent(FirearmItemName7)))
                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InfoPanelEditLayout.createSequentialGroup()
                                        .addComponent(FirearmItemName56)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edit_ammo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InfoPanelEditLayout.createSequentialGroup()
                                        .addComponent(FirearmItemName55)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edit_reloadspeed, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InfoPanelEditLayout.createSequentialGroup()
                                        .addComponent(FirearmItemName54)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edit_firerate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InfoPanelEditLayout.createSequentialGroup()
                                        .addComponent(FirearmItemName31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edit_power, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reducepower)
                                    .addComponent(addpower)
                                    .addComponent(reducefirerate)
                                    .addComponent(addfirerate)
                                    .addComponent(reducereloadspeed)
                                    .addComponent(addreloadspeed)
                                    .addComponent(reduceaccuracy)
                                    .addComponent(addaccuracy))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                .addComponent(productImageEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(edit_id, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edit_name)))
                    .addGroup(InfoPanelEditLayout.createSequentialGroup()
                        .addComponent(RemoveBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpdateBT, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        InfoPanelEditLayout.setVerticalGroup(
            InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productImageEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InfoPanelEditLayout.createSequentialGroup()
                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(edit_power, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FirearmItemName31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                                .addComponent(addpower, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(reducepower, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(edit_firerate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                                .addComponent(addfirerate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(reducefirerate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(FirearmItemName54, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edit_reloadspeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelEditLayout.createSequentialGroup()
                                        .addComponent(addreloadspeed, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(reducereloadspeed, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(FirearmItemName55, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edit_ammo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FirearmItemName56, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InfoPanelEditLayout.createSequentialGroup()
                                .addComponent(addaccuracy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(reduceaccuracy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirearmItemName7)
                    .addComponent(edit_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirearmItemName8)
                    .addComponent(edit_name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirearmItemName16)
                    .addComponent(OriginalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirearmItemName9)
                    .addComponent(edit_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirearmItemName11, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(edit_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FirearmItemName10)
                        .addComponent(edit_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(new_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InfoPanelEditLayout.createSequentialGroup()
                        .addComponent(increase_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(decrease_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pH_TextAreaScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FirearmItemName12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        edit_sorter.setBackground(new java.awt.Color(20, 20, 20));
        edit_sorter.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_sorter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Handgun", "Semi-automatic Pistol", "Bolt-action rifle", "Semi-automatic rifle", "Assault rifle", "Marksman Rifle", "Sniper Rifle", "Anti-material rifle", "Anti-tank Rifle", "Shotgun", "Automatic Shotgun", "Sawed-Off Shotgun", "Submachine Gun (SMG)", "Light Machine Gun (LMG)", "Medium Machine Gun (MMG)", "Heavy Machine Gun (HMG)", "Carbine", "Grenade Launcher", "RPG", "Anti-tank Missile", "Flamethrower", "Gatling Gun", "Chain Gun", "Minigun", "Artillery Gun", "Howitzer", "Mortar", "Stun Gun", "Flare Gun", "Granade", "Mine", "Ammunition", "Consumable" }));
        edit_sorter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_sorter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sorterActionPerformed(evt);
            }
        });

        edit_imagePath.setBackground(new java.awt.Color(0, 0, 0));
        edit_imagePath.setBorder(null);

        edit_imageName.setBackground(new java.awt.Color(0, 0, 0));
        edit_imageName.setBorder(null);

        FirearmItemName15.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName15.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName15.setText("BUSINESS FUNDS");
        FirearmItemName15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        edit_businessFunds.setEditable(false);
        edit_businessFunds.setBackground(new java.awt.Color(20, 20, 20));
        edit_businessFunds.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        edit_businessFunds.setForeground(new java.awt.Color(255, 255, 255));
        edit_businessFunds.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edit_businessFunds.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        edit_businessFunds.setCaretColor(new java.awt.Color(255, 255, 255));
        edit_businessFunds.setSelectionColor(new java.awt.Color(38, 38, 38));

        javax.swing.GroupLayout EditProductPanelLayout = new javax.swing.GroupLayout(EditProductPanel);
        EditProductPanel.setLayout(EditProductPanelLayout);
        EditProductPanelLayout.setHorizontalGroup(
            EditProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditProductPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(EditProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(EditTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EditProductPanelLayout.createSequentialGroup()
                        .addComponent(FirearmItemName15, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_businessFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit_id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(edit_imageName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_sorter, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InfoPanelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        EditProductPanelLayout.setVerticalGroup(
            EditProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditProductPanelLayout.createSequentialGroup()
                .addGroup(EditProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(InfoPanelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EditProductPanelLayout.createSequentialGroup()
                        .addGroup(EditProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit_sorter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_imageName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FirearmItemName15)
                            .addComponent(edit_businessFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(EditTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 322, Short.MAX_VALUE))
        );

        ProductLayerPanel.add(EditProductPanel);

        javax.swing.GroupLayout ProductPanelLayout = new javax.swing.GroupLayout(ProductPanel);
        ProductPanel.setLayout(ProductPanelLayout);
        ProductPanelLayout.setHorizontalGroup(
            ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1419, Short.MAX_VALUE)
            .addGroup(ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ProductPanelLayout.createSequentialGroup()
                    .addComponent(ProductMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1269, Short.MAX_VALUE)))
            .addGroup(ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductPanelLayout.createSequentialGroup()
                    .addGap(0, 260, Short.MAX_VALUE)
                    .addComponent(ProductLayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        ProductPanelLayout.setVerticalGroup(
            ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
            .addGroup(ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ProductMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ProductLayerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(ProductPanel);

        TransactionPanel.setBackground(new java.awt.Color(0, 0, 0));

        TransactionMenu.setBackground(new java.awt.Color(0, 0, 0));

        HomeLabelTransaction.setBackground(new java.awt.Color(0, 0, 0));
        HomeLabelTransaction.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        HomeLabelTransaction.setForeground(new java.awt.Color(255, 255, 255));
        HomeLabelTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HomeIcon.jpg"))); // NOI18N
        HomeLabelTransaction.setText("HOME");
        HomeLabelTransaction.setOpaque(true);
        HomeLabelTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeLabelTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeLabelTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeLabelTransactionMouseExited(evt);
            }
        });

        TransactionLabelTransaction.setBackground(new java.awt.Color(0, 0, 0));
        TransactionLabelTransaction.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        TransactionLabelTransaction.setForeground(new java.awt.Color(255, 255, 255));
        TransactionLabelTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transaction.jpg"))); // NOI18N
        TransactionLabelTransaction.setText("TRANSACTIONS");
        TransactionLabelTransaction.setOpaque(true);
        TransactionLabelTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionLabelTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TransactionLabelTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TransactionLabelTransactionMouseExited(evt);
            }
        });

        ImportLabelTransaction.setBackground(new java.awt.Color(0, 0, 0));
        ImportLabelTransaction.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        ImportLabelTransaction.setForeground(new java.awt.Color(255, 255, 255));
        ImportLabelTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imports.jpg"))); // NOI18N
        ImportLabelTransaction.setText("IMPORTS");
        ImportLabelTransaction.setOpaque(true);
        ImportLabelTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImportLabelTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImportLabelTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImportLabelTransactionMouseExited(evt);
            }
        });

        EarningLabelTransaction.setBackground(new java.awt.Color(0, 0, 0));
        EarningLabelTransaction.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        EarningLabelTransaction.setForeground(new java.awt.Color(255, 255, 255));
        EarningLabelTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/earnings.jpg"))); // NOI18N
        EarningLabelTransaction.setText("EARNINGS");
        EarningLabelTransaction.setOpaque(true);
        EarningLabelTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EarningLabelTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EarningLabelTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EarningLabelTransactionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout TransactionMenuLayout = new javax.swing.GroupLayout(TransactionMenu);
        TransactionMenu.setLayout(TransactionMenuLayout);
        TransactionMenuLayout.setHorizontalGroup(
            TransactionMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeLabelTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TransactionLabelTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(ImportLabelTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(EarningLabelTransaction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        TransactionMenuLayout.setVerticalGroup(
            TransactionMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeLabelTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionLabelTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImportLabelTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(EarningLabelTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TransactionLayerPanel.setBackground(new java.awt.Color(255, 153, 0));
        TransactionLayerPanel.setLayout(new javax.swing.OverlayLayout(TransactionLayerPanel));

        TransactionTransaction.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TRANSACTIONS");

        NumberOfTransactions.setEditable(false);
        NumberOfTransactions.setBackground(new java.awt.Color(0, 0, 0));
        NumberOfTransactions.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        NumberOfTransactions.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NumberOfTransactions.setText("0");

        TransactionTable.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        TransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENT", "PRODUCT", "TYPE", "COST", "TAX", "QUANTITY", "TOTAL PRICE", "", "", "DATE", "TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TransactionTable.setRowHeight(30);
        TransactionTable.getTableHeader().setReorderingAllowed(false);
        EarningsTableScroll.setViewportView(TransactionTable);
        if (TransactionTable.getColumnModel().getColumnCount() > 0) {
            TransactionTable.getColumnModel().getColumn(8).setMinWidth(0);
            TransactionTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            TransactionTable.getColumnModel().getColumn(8).setMaxWidth(0);
            TransactionTable.getColumnModel().getColumn(9).setMinWidth(0);
            TransactionTable.getColumnModel().getColumn(9).setPreferredWidth(0);
            TransactionTable.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        TransactionSearchTXT.setBackground(new java.awt.Color(0, 0, 0));
        TransactionSearchTXT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        TransactionSearchTXT.setForeground(new java.awt.Color(66, 66, 66));
        TransactionSearchTXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TransactionSearchTXT.setText("search...");
        TransactionSearchTXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TransactionSearchTXTCaretUpdate(evt);
            }
        });
        TransactionSearchTXT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TransactionSearchTXTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TransactionSearchTXTFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchW.jpg"))); // NOI18N

        javax.swing.GroupLayout TransactionTransactionLayout = new javax.swing.GroupLayout(TransactionTransaction);
        TransactionTransaction.setLayout(TransactionTransactionLayout);
        TransactionTransactionLayout.setHorizontalGroup(
            TransactionTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionTransactionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(TransactionTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TransactionTransactionLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NumberOfTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TransactionSearchTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(EarningsTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        TransactionTransactionLayout.setVerticalGroup(
            TransactionTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionTransactionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TransactionTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NumberOfTransactions)
                    .addComponent(TransactionSearchTXT)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EarningsTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
        );

        TransactionLayerPanel.add(TransactionTransaction);

        TransactionEarnings.setBackground(new java.awt.Color(0, 0, 0));

        EarningsTABLE.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        EarningsTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EarningsTABLE.setRowHeight(30);
        EarningsTABLE.getTableHeader().setReorderingAllowed(false);
        ImportTableScroll1.setViewportView(EarningsTABLE);

        ImportTABLE.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        ImportTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ImportTABLE.setRowHeight(30);
        ImportTABLE.getTableHeader().setReorderingAllowed(false);
        ImportTableScroll3.setViewportView(ImportTABLE);

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 19)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TOTAL EARNINGS");

        jLabel15.setFont(new java.awt.Font("Agency FB", 0, 19)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("TOTAL EXPENSES");

        Total_Earnings.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        Total_Earnings.setForeground(new java.awt.Color(255, 255, 255));
        Total_Earnings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Total_Earnings.setText("0");

        Total_Expenses.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        Total_Expenses.setForeground(new java.awt.Color(255, 255, 255));
        Total_Expenses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Total_Expenses.setText("0");

        jLabel16.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("TOTAL AMOUNT OWNED");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        Total_Amount_Owned.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        Total_Amount_Owned.setForeground(new java.awt.Color(255, 255, 255));
        Total_Amount_Owned.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Total_Amount_Owned.setText("0");

        shadowgunimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/aafffff.jpg"))); // NOI18N

        javax.swing.GroupLayout TransactionEarningsLayout = new javax.swing.GroupLayout(TransactionEarnings);
        TransactionEarnings.setLayout(TransactionEarningsLayout);
        TransactionEarningsLayout.setHorizontalGroup(
            TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionEarningsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Total_Earnings, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImportTableScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TransactionEarningsLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Total_Amount_Owned, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(TransactionEarningsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shadowgunimage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImportTableScroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total_Expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 156, Short.MAX_VALUE))
        );
        TransactionEarningsLayout.setVerticalGroup(
            TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionEarningsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Total_Amount_Owned, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransactionEarningsLayout.createSequentialGroup()
                        .addGroup(TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TransactionEarningsLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionEarningsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Total_Earnings, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Total_Expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TransactionEarningsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(TransactionEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ImportTableScroll1)
                    .addComponent(ImportTableScroll3)
                    .addComponent(shadowgunimage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(352, Short.MAX_VALUE))
        );

        TransactionLayerPanel.add(TransactionEarnings);

        TransactionImport.setBackground(new java.awt.Color(0, 0, 0));

        NumberOfImports.setEditable(false);
        NumberOfImports.setBackground(new java.awt.Color(0, 0, 0));
        NumberOfImports.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        NumberOfImports.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NumberOfImports.setText("0");

        jLabel9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("IMPORTS");

        ImportTable.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        ImportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USER", "PRODUCT ID", "PRODUCT", "COST", "STOCK", "TYPE", "EXPENSE", "DATE", "TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ImportTable.setRowHeight(30);
        ImportTable.getTableHeader().setReorderingAllowed(false);
        EarningsTableScroll1.setViewportView(ImportTable);

        ImportSearchTXT.setBackground(new java.awt.Color(0, 0, 0));
        ImportSearchTXT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        ImportSearchTXT.setForeground(new java.awt.Color(66, 66, 66));
        ImportSearchTXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ImportSearchTXT.setText("search...");
        ImportSearchTXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ImportSearchTXTCaretUpdate(evt);
            }
        });
        ImportSearchTXT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ImportSearchTXTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ImportSearchTXTFocusLost(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchW.jpg"))); // NOI18N

        javax.swing.GroupLayout TransactionImportLayout = new javax.swing.GroupLayout(TransactionImport);
        TransactionImport.setLayout(TransactionImportLayout);
        TransactionImportLayout.setHorizontalGroup(
            TransactionImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionImportLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(TransactionImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EarningsTableScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TransactionImportLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NumberOfImports, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ImportSearchTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        TransactionImportLayout.setVerticalGroup(
            TransactionImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionImportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TransactionImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TransactionImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NumberOfImports)
                        .addComponent(ImportSearchTXT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EarningsTableScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        TransactionLayerPanel.add(TransactionImport);

        javax.swing.GroupLayout TransactionPanelLayout = new javax.swing.GroupLayout(TransactionPanel);
        TransactionPanel.setLayout(TransactionPanelLayout);
        TransactionPanelLayout.setHorizontalGroup(
            TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionPanelLayout.createSequentialGroup()
                .addComponent(TransactionMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionLayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TransactionPanelLayout.setVerticalGroup(
            TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TransactionMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TransactionLayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(TransactionPanel);

        ShopPanel.setBackground(new java.awt.Color(0, 0, 0));

        ShopMenu.setBackground(new java.awt.Color(0, 0, 0));

        HomeLabelShop.setBackground(new java.awt.Color(0, 0, 0));
        HomeLabelShop.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        HomeLabelShop.setForeground(new java.awt.Color(255, 255, 255));
        HomeLabelShop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HomeIcon.jpg"))); // NOI18N
        HomeLabelShop.setText("HOME");
        HomeLabelShop.setOpaque(true);
        HomeLabelShop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeLabelShopMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeLabelShopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeLabelShopMouseExited(evt);
            }
        });

        FirearmLabelShop.setBackground(new java.awt.Color(0, 0, 0));
        FirearmLabelShop.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmLabelShop.setForeground(new java.awt.Color(255, 255, 255));
        FirearmLabelShop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/FirearmIcon.jpg"))); // NOI18N
        FirearmLabelShop.setText("FIREARMS");
        FirearmLabelShop.setOpaque(true);
        FirearmLabelShop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FirearmLabelShopMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FirearmLabelShopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FirearmLabelShopMouseExited(evt);
            }
        });

        CartLabelShop.setBackground(new java.awt.Color(0, 0, 0));
        CartLabelShop.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        CartLabelShop.setForeground(new java.awt.Color(255, 255, 255));
        CartLabelShop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CartIcon.jpg"))); // NOI18N
        CartLabelShop.setText("CART");
        CartLabelShop.setOpaque(true);
        CartLabelShop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CartLabelShopMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CartLabelShopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CartLabelShopMouseExited(evt);
            }
        });

        usernameMain.setBackground(new java.awt.Color(0, 0, 0));
        usernameMain.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        usernameMain.setForeground(new java.awt.Color(0, 0, 0));

        passwordMain.setBackground(new java.awt.Color(0, 0, 0));
        passwordMain.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        passwordMain.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout ShopMenuLayout = new javax.swing.GroupLayout(ShopMenu);
        ShopMenu.setLayout(ShopMenuLayout);
        ShopMenuLayout.setHorizontalGroup(
            ShopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeLabelShop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(FirearmLabelShop, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(CartLabelShop, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addGroup(ShopMenuLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(ShopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ShopMenuLayout.setVerticalGroup(
            ShopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeLabelShop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FirearmLabelShop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CartLabelShop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 487, Short.MAX_VALUE)
                .addComponent(passwordMain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameMain)
                .addGap(39, 39, 39))
        );

        ShopLayerPanel.setBackground(new java.awt.Color(255, 153, 0));
        ShopLayerPanel.setLayout(new javax.swing.OverlayLayout(ShopLayerPanel));

        ShopFirearms.setBackground(new java.awt.Color(0, 0, 0));

        FirearmProductInfo.setBackground(new java.awt.Color(0, 0, 0));
        FirearmProductInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        FirearmImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));

        FirearmItemName.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName.setText("ITEM NAME");
        FirearmItemName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FirearmItemName.setMinimumSize(new java.awt.Dimension(251, 29));

        FirearmCost.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmCost.setForeground(new java.awt.Color(52, 196, 57));
        FirearmCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmCost.setText("COST");
        FirearmCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        FirearmCost.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FirearmCost.setMinimumSize(new java.awt.Dimension(207, 31));
        FirearmCost.setPreferredSize(new java.awt.Dimension(207, 31));

        jLabel7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("STOCK");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("QUANTITY");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmQuantity.setEditable(false);
        FirearmQuantity.setBackground(new java.awt.Color(0, 0, 0));
        FirearmQuantity.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmQuantity.setForeground(new java.awt.Color(255, 255, 255));
        FirearmQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FirearmQuantity.setText("1");

        FirearmStock.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmStock.setForeground(new java.awt.Color(255, 255, 255));
        FirearmStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmStock.setText("1");
        FirearmStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pH_Button1.setBackground(new java.awt.Color(20, 20, 20));
        pH_Button1.setForeground(new java.awt.Color(255, 255, 255));
        pH_Button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CartIcon.jpg"))); // NOI18N
        pH_Button1.setText("ADD TO CART");
        pH_Button1.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        pH_Button1.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        pH_Button1.setAA_DrawBorder(true);
        pH_Button1.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        pH_Button1.setAA_PressColor(new java.awt.Color(20, 20, 20));
        pH_Button1.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        pH_Button1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        pH_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pH_Button1ActionPerformed(evt);
            }
        });

        FirearmType.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmType.setForeground(new java.awt.Color(255, 255, 255));
        FirearmType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmType.setText("TYPE");
        FirearmType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        FirearmType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FirearmType.setMinimumSize(new java.awt.Dimension(207, 31));
        FirearmType.setPreferredSize(new java.awt.Dimension(207, 31));

        FirearmCost1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmCost1.setForeground(new java.awt.Color(255, 255, 255));
        FirearmCost1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmCost1.setText("COST");
        FirearmCost1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmCost2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmCost2.setForeground(new java.awt.Color(255, 255, 255));
        FirearmCost2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmCost2.setText("TYPE");
        FirearmCost2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addQuantity.setBackground(new java.awt.Color(20, 20, 20));
        addQuantity.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        addQuantity.setText("+");
        addQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        addQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuantityActionPerformed(evt);
            }
        });
        addQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addQuantityKeyTyped(evt);
            }
        });

        reduceQuantity.setBackground(new java.awt.Color(20, 20, 20));
        reduceQuantity.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        reduceQuantity.setText("-");
        reduceQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        reduceQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reduceQuantityActionPerformed(evt);
            }
        });
        reduceQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reduceQuantityKeyTyped(evt);
            }
        });

        pH_TextAreaScroll1.setForeground(new java.awt.Color(51, 51, 51));
        pH_TextAreaScroll1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        pH_TextAreaScroll1.setLabelText("DESCRIPTION");
        pH_TextAreaScroll1.setLineColor(new java.awt.Color(38, 38, 38));

        FirearmDescription.setEditable(false);
        FirearmDescription.setBackground(new java.awt.Color(0, 0, 0));
        FirearmDescription.setColumns(20);
        FirearmDescription.setForeground(new java.awt.Color(255, 255, 255));
        FirearmDescription.setRows(5);
        FirearmDescription.setEnabled(false);
        FirearmDescription.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmDescription.setSelectionColor(new java.awt.Color(32, 32, 32));
        pH_TextAreaScroll1.setViewportView(FirearmDescription);

        FirearmID.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmID.setForeground(new java.awt.Color(255, 255, 255));
        FirearmID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmID.setText("id");
        FirearmID.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout FirearmProductInfoLayout = new javax.swing.GroupLayout(FirearmProductInfo);
        FirearmProductInfo.setLayout(FirearmProductInfoLayout);
        FirearmProductInfoLayout.setHorizontalGroup(
            FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FirearmProductInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FirearmItemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FirearmImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pH_TextAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pH_Button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(FirearmProductInfoLayout.createSequentialGroup()
                        .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FirearmStock, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(FirearmQuantity))
                        .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FirearmProductInfoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reduceQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FirearmProductInfoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FirearmID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(FirearmProductInfoLayout.createSequentialGroup()
                        .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmCost2)
                            .addComponent(FirearmCost1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FirearmType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        FirearmProductInfoLayout.setVerticalGroup(
            FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FirearmProductInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(FirearmItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FirearmImage, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FirearmCost2)
                    .addComponent(FirearmType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FirearmCost1)
                    .addComponent(FirearmCost, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pH_TextAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(FirearmStock)
                    .addComponent(FirearmID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FirearmProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FirearmProductInfoLayout.createSequentialGroup()
                        .addComponent(addQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(reduceQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FirearmQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pH_Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AVAILABLE");

        FlowPanelScroll.setBorder(null);

        FlowPanel.setBackground(new java.awt.Color(30, 30, 30));
        FlowPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FlowPanelScroll.setViewportView(FlowPanel);

        walletPanel.setBackground(new java.awt.Color(0, 0, 0));

        walletTxt.setEditable(false);
        walletTxt.setBackground(new java.awt.Color(0, 0, 0));
        walletTxt.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        walletTxt.setForeground(new java.awt.Color(255, 255, 255));
        walletTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        walletTxt.setText("0");

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/earnings.jpg"))); // NOI18N

        javax.swing.GroupLayout walletPanelLayout = new javax.swing.GroupLayout(walletPanel);
        walletPanel.setLayout(walletPanelLayout);
        walletPanelLayout.setHorizontalGroup(
            walletPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, walletPanelLayout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(walletTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        walletPanelLayout.setVerticalGroup(
            walletPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(walletTxt)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ShopFirearmsLayout = new javax.swing.GroupLayout(ShopFirearms);
        ShopFirearms.setLayout(ShopFirearmsLayout);
        ShopFirearmsLayout.setHorizontalGroup(
            ShopFirearmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopFirearmsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ShopFirearmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShopFirearmsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 601, Short.MAX_VALUE)
                        .addComponent(walletPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FlowPanelScroll))
                .addGap(18, 18, 18)
                .addComponent(FirearmProductInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ShopFirearmsLayout.setVerticalGroup(
            ShopFirearmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopFirearmsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ShopFirearmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(walletPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FlowPanelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(FirearmProductInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ShopLayerPanel.add(ShopFirearms);

        ShopCart.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        purchaseBT.setBackground(new java.awt.Color(20, 20, 20));
        purchaseBT.setForeground(new java.awt.Color(255, 255, 255));
        purchaseBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CartIcon.jpg"))); // NOI18N
        purchaseBT.setText("PURCHASE");
        purchaseBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        purchaseBT.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        purchaseBT.setAA_DrawBorder(true);
        purchaseBT.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        purchaseBT.setAA_PressColor(new java.awt.Color(20, 20, 20));
        purchaseBT.setAA_RippleColor(new java.awt.Color(52, 196, 57));
        purchaseBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        purchaseBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseBTActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SUBTOTAL");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartSubtotal.setEditable(false);
        cartSubtotal.setBackground(new java.awt.Color(0, 0, 0));
        cartSubtotal.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        cartSubtotal.setForeground(new java.awt.Color(255, 255, 255));
        cartSubtotal.setText("0");

        cartTax.setEditable(false);
        cartTax.setBackground(new java.awt.Color(0, 0, 0));
        cartTax.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        cartTax.setForeground(new java.awt.Color(255, 255, 255));
        cartTax.setText("0");

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("TOTAL TAX");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartTotal.setEditable(false);
        cartTotal.setBackground(new java.awt.Color(0, 0, 0));
        cartTotal.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        cartTotal.setForeground(new java.awt.Color(255, 255, 255));
        cartTotal.setText("0");

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL AMOUNT");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartPayment.setEditable(false);
        cartPayment.setBackground(new java.awt.Color(0, 0, 0));
        cartPayment.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        cartPayment.setForeground(new java.awt.Color(255, 255, 255));
        cartPayment.setText("0");

        jLabel13.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("PAYMENT");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartChange.setEditable(false);
        cartChange.setBackground(new java.awt.Color(0, 0, 0));
        cartChange.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        cartChange.setForeground(new java.awt.Color(255, 255, 255));
        cartChange.setText("0");

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CHANGE");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cartSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cartTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cartTax, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartChange, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(purchaseBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(purchaseBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        FirearmProductInfo1.setBackground(new java.awt.Color(0, 0, 0));
        FirearmProductInfo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        cart_Image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));

        cart_Name.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        cart_Name.setForeground(new java.awt.Color(255, 255, 255));
        cart_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cart_Name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cart_Name.setMaximumSize(new java.awt.Dimension(251, 29));
        cart_Name.setMinimumSize(new java.awt.Dimension(251, 29));
        cart_Name.setPreferredSize(new java.awt.Dimension(251, 29));

        cart_Cost.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        cart_Cost.setForeground(new java.awt.Color(52, 196, 57));
        cart_Cost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cart_Cost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        cart_Cost.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cart_Cost.setMaximumSize(new java.awt.Dimension(207, 31));
        cart_Cost.setMinimumSize(new java.awt.Dimension(207, 31));
        cart_Cost.setPreferredSize(new java.awt.Dimension(207, 31));

        RemoveCart.setBackground(new java.awt.Color(20, 20, 20));
        RemoveCart.setForeground(new java.awt.Color(255, 255, 255));
        RemoveCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trashIcon.jpg"))); // NOI18N
        RemoveCart.setText("REMOVE");
        RemoveCart.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        RemoveCart.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        RemoveCart.setAA_DrawBorder(true);
        RemoveCart.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        RemoveCart.setAA_PressColor(new java.awt.Color(20, 20, 20));
        RemoveCart.setAA_RippleColor(new java.awt.Color(201, 15, 15));
        RemoveCart.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        RemoveCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveCartActionPerformed(evt);
            }
        });

        cart_Type.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        cart_Type.setForeground(new java.awt.Color(255, 255, 255));
        cart_Type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cart_Type.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        cart_Type.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cart_Type.setMaximumSize(new java.awt.Dimension(207, 31));
        cart_Type.setMinimumSize(new java.awt.Dimension(207, 31));
        cart_Type.setName(""); // NOI18N
        cart_Type.setPreferredSize(new java.awt.Dimension(207, 31));

        FirearmCost4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmCost4.setForeground(new java.awt.Color(255, 255, 255));
        FirearmCost4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmCost4.setText("COST");
        FirearmCost4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmCost5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmCost5.setForeground(new java.awt.Color(255, 255, 255));
        FirearmCost5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmCost5.setText("TYPE");
        FirearmCost5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pH_TextAreaScroll3.setForeground(new java.awt.Color(51, 51, 51));
        pH_TextAreaScroll3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        pH_TextAreaScroll3.setLabelText("DESCRIPTION");
        pH_TextAreaScroll3.setLineColor(new java.awt.Color(38, 38, 38));

        cart_Description.setBackground(new java.awt.Color(0, 0, 0));
        cart_Description.setColumns(20);
        cart_Description.setForeground(new java.awt.Color(255, 255, 255));
        cart_Description.setRows(5);
        cart_Description.setEnabled(false);
        cart_Description.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        pH_TextAreaScroll3.setViewportView(cart_Description);

        javax.swing.GroupLayout FirearmProductInfo1Layout = new javax.swing.GroupLayout(FirearmProductInfo1);
        FirearmProductInfo1.setLayout(FirearmProductInfo1Layout);
        FirearmProductInfo1Layout.setHorizontalGroup(
            FirearmProductInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FirearmProductInfo1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(FirearmProductInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cart_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cart_Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RemoveCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(FirearmProductInfo1Layout.createSequentialGroup()
                        .addGroup(FirearmProductInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmCost5)
                            .addComponent(FirearmCost4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FirearmProductInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cart_Cost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cart_Type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pH_TextAreaScroll3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        FirearmProductInfo1Layout.setVerticalGroup(
            FirearmProductInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FirearmProductInfo1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cart_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cart_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FirearmProductInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FirearmCost5)
                    .addComponent(cart_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FirearmProductInfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirearmCost4)
                    .addComponent(cart_Cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pH_TextAreaScroll3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(RemoveCart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CartTable.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT", "TYPE", "COST", "TAX", "QUANTITY", "TOTAL PRICE", "id", "PRODUCTID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CartTable.setRowHeight(30);
        CartTable.getTableHeader().setReorderingAllowed(false);
        CartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CartTableMouseClicked(evt);
            }
        });
        EditTableScroll1.setViewportView(CartTable);
        if (CartTable.getColumnModel().getColumnCount() > 0) {
            CartTable.getColumnModel().getColumn(6).setMinWidth(0);
            CartTable.getColumnModel().getColumn(6).setPreferredWidth(0);
            CartTable.getColumnModel().getColumn(6).setMaxWidth(0);
            CartTable.getColumnModel().getColumn(7).setMinWidth(0);
            CartTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            CartTable.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ITEMS SELECTED");

        walletPanel1.setBackground(new java.awt.Color(0, 0, 0));

        walletTxtCart.setEditable(false);
        walletTxtCart.setBackground(new java.awt.Color(0, 0, 0));
        walletTxtCart.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        walletTxtCart.setForeground(new java.awt.Color(255, 255, 255));
        walletTxtCart.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        walletTxtCart.setText("0");

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/earnings.jpg"))); // NOI18N

        javax.swing.GroupLayout walletPanel1Layout = new javax.swing.GroupLayout(walletPanel1);
        walletPanel1.setLayout(walletPanel1Layout);
        walletPanel1Layout.setHorizontalGroup(
            walletPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, walletPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(walletTxtCart, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        walletPanel1Layout.setVerticalGroup(
            walletPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(walletTxtCart)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ShopCartLayout = new javax.swing.GroupLayout(ShopCart);
        ShopCart.setLayout(ShopCartLayout);
        ShopCartLayout.setHorizontalGroup(
            ShopCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopCartLayout.createSequentialGroup()
                .addGroup(ShopCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ShopCartLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(walletPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(EditTableScroll1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FirearmProductInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ShopCartLayout.setVerticalGroup(
            ShopCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopCartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ShopCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(walletPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditTableScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(FirearmProductInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ShopLayerPanel.add(ShopCart);

        javax.swing.GroupLayout ShopPanelLayout = new javax.swing.GroupLayout(ShopPanel);
        ShopPanel.setLayout(ShopPanelLayout);
        ShopPanelLayout.setHorizontalGroup(
            ShopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopPanelLayout.createSequentialGroup()
                .addComponent(ShopMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShopLayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ShopPanelLayout.setVerticalGroup(
            ShopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopPanelLayout.createSequentialGroup()
                .addComponent(ShopMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ShopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ShopLayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
        );

        getContentPane().add(ShopPanel);

        AdminPanel.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        FirearmItemName18.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName18.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName18.setText("PASSWORD");
        FirearmItemName18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        admin_password.setBackground(new java.awt.Color(21, 21, 21));
        admin_password.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_password.setForeground(new java.awt.Color(255, 255, 255));
        admin_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        admin_password.setCaretColor(new java.awt.Color(255, 255, 255));
        admin_password.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName19.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName19.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName19.setText("CASH");
        FirearmItemName19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        admin_cash.setBackground(new java.awt.Color(21, 21, 21));
        admin_cash.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_cash.setForeground(new java.awt.Color(255, 255, 255));
        admin_cash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        admin_cash.setCaretColor(new java.awt.Color(255, 255, 255));
        admin_cash.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName20.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName20.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName20.setText("STATUS");
        FirearmItemName20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        adminTable.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USERNAME", "PASSWORD", "CASH", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adminTable.setRowHeight(30);
        adminTable.getTableHeader().setReorderingAllowed(false);
        adminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTableMouseClicked(evt);
            }
        });
        adminTableScroll.setViewportView(adminTable);

        admin_status.setBackground(new java.awt.Color(21, 21, 21));
        admin_status.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_status.setForeground(new java.awt.Color(255, 255, 255));
        admin_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CUSTOMER", "ADMIN" }));
        admin_status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));

        admin_save.setBackground(new java.awt.Color(20, 20, 20));
        admin_save.setForeground(new java.awt.Color(255, 255, 255));
        admin_save.setText("SAVE");
        admin_save.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        admin_save.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        admin_save.setAA_DrawBorder(true);
        admin_save.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        admin_save.setAA_PressColor(new java.awt.Color(20, 20, 20));
        admin_save.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        admin_save.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_saveActionPerformed(evt);
            }
        });

        admin_delete.setBackground(new java.awt.Color(20, 20, 20));
        admin_delete.setForeground(new java.awt.Color(255, 255, 255));
        admin_delete.setText("DELETE");
        admin_delete.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        admin_delete.setAA_ButtonColor(new java.awt.Color(20, 20, 20));
        admin_delete.setAA_DrawBorder(true);
        admin_delete.setAA_HoverColor(new java.awt.Color(38, 38, 38));
        admin_delete.setAA_PressColor(new java.awt.Color(20, 20, 20));
        admin_delete.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        admin_delete.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_deleteActionPerformed(evt);
            }
        });

        admin_username.setBackground(new java.awt.Color(21, 21, 21));
        admin_username.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_username.setForeground(new java.awt.Color(255, 255, 255));
        admin_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 38, 38)));
        admin_username.setCaretColor(new java.awt.Color(255, 255, 255));
        admin_username.setSelectionColor(new java.awt.Color(38, 38, 38));

        FirearmItemName17.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName17.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName17.setText("USERNAME");
        FirearmItemName17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(FirearmItemName19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(FirearmItemName20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin_status, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(FirearmItemName18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin_password, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(FirearmItemName17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin_username, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admin_save, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_username, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirearmItemName17)
                    .addComponent(admin_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirearmItemName18)
                    .addComponent(admin_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirearmItemName19))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_status, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirearmItemName20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adminTableScroll)
                .addContainerGap())
        );

        adminBackBT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminBackBT.setForeground(new java.awt.Color(102, 102, 102));
        adminBackBT.setText("<Back");
        adminBackBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminBackBTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminBackBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminBackBTMouseExited(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        FirearmItemName26.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName26.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName26.setText("Samuel James Cinco");
        FirearmItemName26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FirearmItemName26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FirearmItemName26MouseClicked(evt);
            }
        });

        FirearmItemName27.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName27.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName27.setText("imsauce_");
        FirearmItemName27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FirearmItemName27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FirearmItemName27MouseClicked(evt);
            }
        });

        FirearmItemName28.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName28.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName28.setText("ImSauce");
        FirearmItemName28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FirearmItemName28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FirearmItemName28MouseClicked(evt);
            }
        });

        FirearmItemName29.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName29.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName29.setText("imsauce_");
        FirearmItemName29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FirearmItemName29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FirearmItemName29MouseClicked(evt);
            }
        });

        FirearmItemName30.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName30.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName30.setText("SOCIALS");
        FirearmItemName30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fbicon.setBackground(new java.awt.Color(51, 51, 51));
        fbicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fb.jpg"))); // NOI18N
        fbicon.setToolTipText("facebook");
        fbicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fbiconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fbiconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fbiconMouseExited(evt);
            }
        });

        discordicon.setBackground(new java.awt.Color(51, 51, 51));
        discordicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/disc.jpg"))); // NOI18N
        discordicon.setToolTipText("discord");
        discordicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discordiconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                discordiconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                discordiconMouseExited(evt);
            }
        });

        githubicon.setBackground(new java.awt.Color(51, 51, 51));
        githubicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/git.jpg"))); // NOI18N
        githubicon.setToolTipText("github");
        githubicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                githubiconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                githubiconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                githubiconMouseExited(evt);
            }
        });

        xicon.setBackground(new java.awt.Color(51, 51, 51));
        xicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/x.jpg"))); // NOI18N
        xicon.setToolTipText("x");
        xicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xiconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                xiconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                xiconMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(discordicon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(githubicon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(xicon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmItemName26)
                            .addComponent(FirearmItemName27)
                            .addComponent(FirearmItemName28)
                            .addComponent(FirearmItemName29, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(FirearmItemName30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FirearmItemName30)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirearmItemName26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(discordicon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FirearmItemName27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(githubicon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FirearmItemName28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(xicon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FirearmItemName29, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/asdasdar3aaaaaaaa.png"))); // NOI18N
        jLabel19.setToolTipText("<html>DONT CLICK THIS!!<br>\nYOU WILL END UP LIKE HER  <br>\nAND YOU WILL REGRET IT</html>");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80), 2));
        jLabel19.setOpaque(true);
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        FirearmItemName21.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName21.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName21.setText("Developer: imsauce");
        FirearmItemName21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName25.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName25.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName25.setText("CREDITS TO:");
        FirearmItemName25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FirearmItemName21))
                    .addComponent(FirearmItemName25))
                .addContainerGap(417, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(FirearmItemName25)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirearmItemName21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        YTname1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        YTname1.setForeground(new java.awt.Color(255, 255, 255));
        YTname1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        YTname1.setText("[Epic Rock War/ Workout Music] - Annihilation");
        YTname1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        YTname1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTname1MouseClicked(evt);
            }
        });

        YTname2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        YTname2.setForeground(new java.awt.Color(255, 255, 255));
        YTname2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        YTname2.setText("[Epic Rock War/ Workout Music] - Arclight");
        YTname2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        YTname2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTname2MouseClicked(evt);
            }
        });

        YTname3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        YTname3.setForeground(new java.awt.Color(255, 255, 255));
        YTname3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        YTname3.setText("[Epic Rock War/ Workout Music] - First Blood");
        YTname3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        YTname3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTname3MouseClicked(evt);
            }
        });

        YTname5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        YTname5.setForeground(new java.awt.Color(255, 255, 255));
        YTname5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        YTname5.setText("Blue Archive Fan OST: Hard Boiled - Aru Terror");
        YTname5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        YTname5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTname5MouseClicked(evt);
            }
        });

        FirearmItemName35.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName35.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName35.setText("MUSIC USED");
        FirearmItemName35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        YTmusic1.setBackground(new java.awt.Color(51, 51, 51));
        YTmusic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yt.jpg"))); // NOI18N
        YTmusic1.setToolTipText("RIGHT CLICK TO REDIRECT");
        YTmusic1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTmusic1MouseClicked(evt);
            }
        });

        YTmusic2.setBackground(new java.awt.Color(51, 51, 51));
        YTmusic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yt.jpg"))); // NOI18N
        YTmusic2.setToolTipText("RIGHT CLICK TO REDIRECT");
        YTmusic2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTmusic2MouseClicked(evt);
            }
        });

        YTmusic3.setBackground(new java.awt.Color(51, 51, 51));
        YTmusic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yt.jpg"))); // NOI18N
        YTmusic3.setToolTipText("RIGHT CLICK TO REDIRECT");
        YTmusic3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTmusic3MouseClicked(evt);
            }
        });

        YTmusic5.setBackground(new java.awt.Color(51, 51, 51));
        YTmusic5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yt.jpg"))); // NOI18N
        YTmusic5.setToolTipText("RIGHT CLICK TO REDIRECT");
        YTmusic5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTmusic5MouseClicked(evt);
            }
        });

        YTname4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        YTname4.setForeground(new java.awt.Color(255, 255, 255));
        YTname4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        YTname4.setText("[Epic Rock War/ Workout Music] - Backfire");
        YTname4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        YTname4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTname4MouseClicked(evt);
            }
        });

        YTmusic4.setBackground(new java.awt.Color(51, 51, 51));
        YTmusic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yt.jpg"))); // NOI18N
        YTmusic4.setToolTipText("RIGHT CLICK TO REDIRECT");
        YTmusic4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YTmusic4MouseClicked(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));

        giflabel1.setBackground(new java.awt.Color(204, 204, 204));

        giflabel2.setBackground(new java.awt.Color(204, 204, 204));

        giflabel3.setBackground(new java.awt.Color(204, 204, 204));

        giflabel4.setBackground(new java.awt.Color(204, 204, 204));

        giflabel5.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(giflabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(giflabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(giflabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(giflabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(giflabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(giflabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(giflabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(giflabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(giflabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(giflabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        VolumeYT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lowvol.jpg"))); // NOI18N
        VolumeYT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolumeYTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(YTmusic4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YTname4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(YTmusic1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YTmusic2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YTmusic3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YTmusic5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(YTname5)
                            .addComponent(YTname1)
                            .addComponent(YTname2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YTname3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FirearmItemName35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VolumeYT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FirearmItemName35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VolumeYT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(YTmusic1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YTname1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(YTmusic2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YTname2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(YTmusic3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YTname3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(YTmusic4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YTname4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(YTmusic5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YTname5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        FirearmItemName37.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName37.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName37.setText("Date Created - March 12, 2024");
        FirearmItemName37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName38.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName38.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName38.setText("Date Finished - April 1, 2024");
        FirearmItemName38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName41.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName41.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName41.setText("DATE OF CREATION");
        FirearmItemName41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel30.setBackground(new java.awt.Color(51, 51, 51));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/date.jpg"))); // NOI18N

        jLabel31.setBackground(new java.awt.Color(51, 51, 51));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/date.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirearmItemName37)
                            .addComponent(FirearmItemName38)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(FirearmItemName41)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FirearmItemName41)
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirearmItemName37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FirearmItemName38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        FirearmItemName39.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName39.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName39.setText("SERVER IP - ");
        FirearmItemName39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName40.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName40.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName40.setText("USERNAME -");
        FirearmItemName40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FirearmItemName42.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName42.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName42.setText("SERVER");
        FirearmItemName42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel32.setBackground(new java.awt.Color(51, 51, 51));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/seerv.jpg"))); // NOI18N

        jLabel33.setBackground(new java.awt.Color(51, 51, 51));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/active admin.jpg"))); // NOI18N

        jLabel34.setBackground(new java.awt.Color(51, 51, 51));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/locck.jpg"))); // NOI18N

        FirearmItemName43.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName43.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName43.setText("PASSWORD - ");
        FirearmItemName43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        admin_ip.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_ip.setForeground(new java.awt.Color(255, 255, 255));
        admin_ip.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        admin_ip.setText("0");
        admin_ip.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        admin_pass.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_pass.setForeground(new java.awt.Color(255, 255, 255));
        admin_pass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        admin_pass.setText("0");
        admin_pass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        admin_user.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_user.setForeground(new java.awt.Color(255, 255, 255));
        admin_user.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        admin_user.setText("0");
        admin_user.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(FirearmItemName42))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(FirearmItemName40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(FirearmItemName39)
                                        .addGap(13, 13, 13))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FirearmItemName43)
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(admin_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(admin_ip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(admin_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FirearmItemName42)
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FirearmItemName39, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FirearmItemName40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FirearmItemName43, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(admin_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        FirearmItemName44.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName44.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName44.setText("ACTIVE ADMIN");
        FirearmItemName44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel35.setBackground(new java.awt.Color(51, 51, 51));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/active admin.jpg"))); // NOI18N

        FirearmItemName45.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        FirearmItemName45.setForeground(new java.awt.Color(255, 255, 255));
        FirearmItemName45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirearmItemName45.setText("USERNAME -");
        FirearmItemName45.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        admin_active.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        admin_active.setForeground(new java.awt.Color(255, 255, 255));
        admin_active.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        admin_active.setText("0");
        admin_active.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FirearmItemName45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(admin_active, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(FirearmItemName44)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FirearmItemName44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FirearmItemName45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_active, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel6);

        admin_username2.setBackground(new java.awt.Color(0, 0, 0));
        admin_username2.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        admin_username2.setForeground(new java.awt.Color(0, 0, 0));
        admin_username2.setText("jLabel20");

        javax.swing.GroupLayout AdminPanelLayout = new javax.swing.GroupLayout(AdminPanel);
        AdminPanel.setLayout(AdminPanelLayout);
        AdminPanelLayout.setHorizontalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdminPanelLayout.createSequentialGroup()
                        .addComponent(adminBackBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(admin_username2)
                        .addGap(593, 593, 593))))
        );
        AdminPanelLayout.setVerticalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminBackBT)
                    .addComponent(admin_username2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        getContentPane().add(AdminPanel);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ShopLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShopLabelMouseEntered
        sound.playSound2(clip);
        MouseEnteredClass mouse = new MouseEnteredClass();
        mouse.MouseEnteredShop(ShopLabel);
    }//GEN-LAST:event_ShopLabelMouseEntered

    private void ShopLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShopLabelMouseExited
        MouseExitedClass mouse = new MouseExitedClass();
        mouse.MouseEnteredShop(ShopLabel);
    }//GEN-LAST:event_ShopLabelMouseExited

    private void ProductLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductLabelMouseEntered
        sound.playSound2(clip);
        MouseEnteredClass mouse = new MouseEnteredClass();
        mouse.MouseEnteredProduct(ProductLabel);
    }//GEN-LAST:event_ProductLabelMouseEntered

    private void ProductLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductLabelMouseExited
        MouseExitedClass mouse = new MouseExitedClass();
        mouse.MouseEnteredProduct(ProductLabel);
    }//GEN-LAST:event_ProductLabelMouseExited

    private void TransactionLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionLabelMouseEntered
        sound.playSound2(clip);
        MouseEnteredClass mouse = new MouseEnteredClass();
        mouse.MouseEnteredTransaction(TransactionLabel);
    }//GEN-LAST:event_TransactionLabelMouseEntered

    private void TransactionLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionLabelMouseExited
        MouseExitedClass mouse = new MouseExitedClass();
        mouse.MouseEnteredTransaction(TransactionLabel);
    }//GEN-LAST:event_TransactionLabelMouseExited

    private boolean userClicked = false;
    private void ShopLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShopLabelMouseClicked

        if (evt != null) {
        userClicked = true; // Set the flag indicating user interaction
        }
        shopLabelClick();
    }//GEN-LAST:event_ShopLabelMouseClicked

    private void HomeLabelShopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelShopMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(HomeLabelShop);
    }//GEN-LAST:event_HomeLabelShopMouseEntered

    private void HomeLabelShopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelShopMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(HomeLabelShop);
    }//GEN-LAST:event_HomeLabelShopMouseExited

    private void FirearmLabelShopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FirearmLabelShopMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(FirearmLabelShop);
    }//GEN-LAST:event_FirearmLabelShopMouseEntered

    private void FirearmLabelShopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FirearmLabelShopMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(FirearmLabelShop);
    }//GEN-LAST:event_FirearmLabelShopMouseExited

    private void CartLabelShopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartLabelShopMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(CartLabelShop);
    }//GEN-LAST:event_CartLabelShopMouseEntered

    private void CartLabelShopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartLabelShopMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(CartLabelShop);
    }//GEN-LAST:event_CartLabelShopMouseExited

    private void HomeLabelShopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelShopMouseClicked
        ShopPanel.setVisible(false);
        HomePanel.setVisible(true);
        ShopClicked = 0;
        CartClicked = 0;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);        
        sound.playSound3(clip);
        
        ClearCart();
        ClearFirearmProductInfo();
        initProds();
        sound.startMusic1();
        sound.stopMusic2();
        
        
        
    }//GEN-LAST:event_HomeLabelShopMouseClicked

    private void FirearmLabelShopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FirearmLabelShopMouseClicked
        ShopFirearms.setVisible(true);
        ShopCart.setVisible(false);
        ShopClicked = 1;
        CartClicked = 0;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);        
        sound.playSound3(clip);
        
    }//GEN-LAST:event_FirearmLabelShopMouseClicked

    private void CartLabelShopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartLabelShopMouseClicked
        ShopFirearms.setVisible(false);
        ShopCart.setVisible(true);
        walletPanel.setVisible(true);
        ShopClicked = 0;
        CartClicked = 1;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);        
        sound.playSound3(clip);
        refreshCart();
        CartMath();
        
    }//GEN-LAST:event_CartLabelShopMouseClicked

    private void HomeLabelProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelProductMouseClicked
        ProductPanel.setVisible(false);
        HomePanel.setVisible(true);
        clearBTActionPerformed(null);
        
        AddClicked = 0;
        EditClicked = 0;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);       
        initProds();
        sound.playSound3(clip);
        
   
        sound.startMusic1();
        sound.stopMusic3();
    }//GEN-LAST:event_HomeLabelProductMouseClicked

    private void HomeLabelProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelProductMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(HomeLabelProduct);
    }//GEN-LAST:event_HomeLabelProductMouseEntered

    private void HomeLabelProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelProductMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(HomeLabelProduct);
    }//GEN-LAST:event_HomeLabelProductMouseExited

    private void AddProductLabelProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddProductLabelProductMouseClicked
        EditProductPanel.setVisible(false);
        AddProductPanel.setVisible(true);
        
        AddClicked = 1;
        EditClicked = 0;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);        
        autoIncrement();
        importFee();

        sound.playSound3(clip);
    }//GEN-LAST:event_AddProductLabelProductMouseClicked

    private void AddProductLabelProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddProductLabelProductMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(AddProductLabelProduct);
    }//GEN-LAST:event_AddProductLabelProductMouseEntered

    private void AddProductLabelProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddProductLabelProductMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(AddProductLabelProduct);
    }//GEN-LAST:event_AddProductLabelProductMouseExited

    private void EditProductLabelProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProductLabelProductMouseClicked
        AddProductPanel.setVisible(false);
        EditProductPanel.setVisible(true);
        clearBTActionPerformed(null);
        
        AddClicked = 0;
        EditClicked = 1;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);        
        refreshTable();
        sound.playSound3(clip);
    }//GEN-LAST:event_EditProductLabelProductMouseClicked

    private void EditProductLabelProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProductLabelProductMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(EditProductLabelProduct);
    }//GEN-LAST:event_EditProductLabelProductMouseEntered

    private void EditProductLabelProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProductLabelProductMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(EditProductLabelProduct);
    }//GEN-LAST:event_EditProductLabelProductMouseExited

    private void ProductLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductLabelMouseClicked
        if (evt != null) {
        userClicked = true; // Set the flag indicating user interaction
        }
       
        addFunds();
        productLabelClick();
        importFee();
        
        
        
    }//GEN-LAST:event_ProductLabelMouseClicked

    int add_remove_image = 0;
    int edit_remove_image = 0;
    private void EditTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditTableMouseClicked
        SelectEditProduct();
        LoadImageID();
        edit_remove_image=0;
    }//GEN-LAST:event_EditTableMouseClicked

    private void saveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTActionPerformed
         AddProduct();
        
    }//GEN-LAST:event_saveBTActionPerformed

    private void clearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTActionPerformed
        ProductMethods.resetAddProduct(add_id, add_name, add_cost, add_stock, add_description, add_type, add_imageName, add_imagePath, productImage, add_importFee, add_power, add_firerate, add_reloadspeed, add_ammo);
        emptyBlobFile(add_id.getText()); 
        autoIncrement();
        ProductMethods.clicked2(0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
        ProductMethods.clicked2(0, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
        ProductMethods.clicked2(0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        ProductMethods.clicked2(0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_clearBTActionPerformed

    private void UpdateBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTActionPerformed
         SaveBTclicked();

    }//GEN-LAST:event_UpdateBTActionPerformed

    private void RemoveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveBTActionPerformed
        DeleteButton();
        
    }//GEN-LAST:event_RemoveBTActionPerformed

    private void CartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartTableMouseClicked
       SelectCartItem();
    }//GEN-LAST:event_CartTableMouseClicked

    private void addQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuantityActionPerformed
        
        int plus = Integer.parseInt(FirearmQuantity.getText());
        int stock = Integer.parseInt(FirearmStock.getText());
        if (plus < stock ) {
        plus += 1;
        FirearmQuantity.setText(Integer.toString(plus)); 
        }else{
        sound.playSound4(clip);
        }
        
    }//GEN-LAST:event_addQuantityActionPerformed

    private void reduceQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reduceQuantityActionPerformed
        int plus = Integer.parseInt(FirearmQuantity.getText());
        if (plus > 1) {
        
        plus -= 1;
        FirearmQuantity.setText(Integer.toString(plus));
        
        }else {
        sound.playSound4(clip);
        }
        
        
    }//GEN-LAST:event_reduceQuantityActionPerformed

    private void pH_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pH_Button1ActionPerformed
       int id = Integer.parseInt(FirearmID.getText());
        Color textColor = FirearmCost.getForeground(); // Get the color of the label

        if (textColor.equals(new Color(52, 196, 57))) {
            AddToCart(id);
        }else{
        sound.playSound4(clip);
        }
        
      
        
    }//GEN-LAST:event_pH_Button1ActionPerformed

    private void RemoveCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveCartActionPerformed
         int selectedRow = CartTable.getSelectedRow();

  
        
        String ID = CartTable.getValueAt(selectedRow, 7).toString();
        
        int id = Integer.parseInt(ID);
 
        CartDeleteButton(id);
        CartMath();
    }//GEN-LAST:event_RemoveCartActionPerformed

    private void addQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addQuantityKeyTyped
        int plus = Integer.parseInt(FirearmQuantity.getText());
        int stock = Integer.parseInt(FirearmStock.getText());
        if (plus < stock ) {
        plus += 1;
        FirearmQuantity.setText(Integer.toString(plus)); 
        }else{
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_addQuantityKeyTyped

    private void reduceQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reduceQuantityKeyTyped
        int plus = Integer.parseInt(FirearmQuantity.getText());
        if (plus > 1) {
        
        plus -= 1;
        FirearmQuantity.setText(Integer.toString(plus));
        
        }else {
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_reduceQuantityKeyTyped

    private void HomeLabelTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelTransactionMouseClicked
        TransactionPanel.setVisible(false);
        HomePanel.setVisible(true);
        TransactionClicked = 0;
        ImportClicked = 0;
        sound.playSound3(clip);
       sound.startMusic1();
        sound.stopMusic4();
    }//GEN-LAST:event_HomeLabelTransactionMouseClicked

    private void HomeLabelTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelTransactionMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(HomeLabelTransaction);
    }//GEN-LAST:event_HomeLabelTransactionMouseEntered

    private void HomeLabelTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelTransactionMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(HomeLabelTransaction);
    }//GEN-LAST:event_HomeLabelTransactionMouseExited

    private void TransactionLabelTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionLabelTransactionMouseClicked
        TransactionTransaction.setVisible(true);
        TransactionImport.setVisible(false);
        TransactionEarnings.setVisible(false);
        TransactionClicked = 1;
        ImportClicked = 0;
        EarningClicked = 0;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);       

        
        sound.playSound3(clip);
    }//GEN-LAST:event_TransactionLabelTransactionMouseClicked

    private void TransactionLabelTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionLabelTransactionMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(TransactionLabelTransaction);
    }//GEN-LAST:event_TransactionLabelTransactionMouseEntered

    private void TransactionLabelTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionLabelTransactionMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(TransactionLabelTransaction);
    }//GEN-LAST:event_TransactionLabelTransactionMouseExited

    private void ImportLabelTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportLabelTransactionMouseClicked
        TransactionTransaction.setVisible(false);
        TransactionImport.setVisible(true);
        TransactionEarnings.setVisible(false);
        TransactionClicked = 0;
        ImportClicked = 1;
        EarningClicked = 0;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);       
        refreshImportTable();
        
        sound.playSound3(clip);
    }//GEN-LAST:event_ImportLabelTransactionMouseClicked

    private void ImportLabelTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportLabelTransactionMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(ImportLabelTransaction);
    }//GEN-LAST:event_ImportLabelTransactionMouseEntered

    private void ImportLabelTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportLabelTransactionMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(ImportLabelTransaction);
    }//GEN-LAST:event_ImportLabelTransactionMouseExited

    private void TransactionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionLabelMouseClicked
        if (evt != null) {
            userClicked = true; // Set the flag indicating user interaction
            }
        
        transactionLabelClick();
        
 
    }//GEN-LAST:event_TransactionLabelMouseClicked

    private void EarningLabelTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EarningLabelTransactionMouseClicked
        TransactionTransaction.setVisible(false);
        TransactionImport.setVisible(false);
        TransactionEarnings.setVisible(true);
        TransactionClicked = 0;
        ImportClicked = 0;
        EarningClicked = 1;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);       

        
        sound.playSound3(clip);
    }//GEN-LAST:event_EarningLabelTransactionMouseClicked

    private void EarningLabelTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EarningLabelTransactionMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelGray(EarningLabelTransaction);
    }//GEN-LAST:event_EarningLabelTransactionMouseEntered

    private void EarningLabelTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EarningLabelTransactionMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorlabelBlack(EarningLabelTransaction);
    }//GEN-LAST:event_EarningLabelTransactionMouseExited

    private void purchaseBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseBTActionPerformed
        
        purchaseBTclicked();
        
        
    }//GEN-LAST:event_purchaseBTActionPerformed

    private void add_costCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_add_costCaretUpdate
       importFee();
    }//GEN-LAST:event_add_costCaretUpdate

    private void add_stockCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_add_stockCaretUpdate
        importFee();
    }//GEN-LAST:event_add_stockCaretUpdate

    private void increase_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increase_stockActionPerformed
        editAddNewStock();
        
    }//GEN-LAST:event_increase_stockActionPerformed

    private void decrease_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrease_stockActionPerformed
        editReduceNewStock();
        
    }//GEN-LAST:event_decrease_stockActionPerformed

    private void increase_stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_increase_stockKeyTyped
        editAddNewStock();
    }//GEN-LAST:event_increase_stockKeyTyped

    private void decrease_stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_decrease_stockKeyTyped
         editReduceNewStock();
    }//GEN-LAST:event_decrease_stockKeyTyped

    private void edit_sorterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sorterActionPerformed
        edit_sort();
    }//GEN-LAST:event_edit_sorterActionPerformed

    private void productImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productImageMouseClicked
 
        if (evt.getButton() == MouseEvent.BUTTON3) {
        try{
        add_imagePath.setText(""); // Clear the text
        add_imageName.setText("");
        productImage.setIcon(new ImageIcon("insertimage.jpg")); // Clear the icon

        add_remove_image = 1;
    
        }catch(Exception e){}
    }else{
         AddImage();
        add_remove_image=0;
        
        }
       
    }//GEN-LAST:event_productImageMouseClicked

    private void TitleMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMenuMouseClicked
        if (evt != null) {
        userClicked = true; 
        }
        
        admin_ip.setText(local2.getText());
        admin_user.setText(local.getText());
        admin_pass.setText(local3.getText());
        admin_active.setText(usernameMain.getText());
        giflabel4.setIcon(new ImageIcon("MPGIF.gif"));
  
        AdminLabelClick();
    }//GEN-LAST:event_TitleMenuMouseClicked

    private void admin_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_saveActionPerformed
        skibimethod();
        adminEdit();
    }//GEN-LAST:event_admin_saveActionPerformed

    private void admin_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_deleteActionPerformed
        skibimethod();
        adminDelete();
    }//GEN-LAST:event_admin_deleteActionPerformed

    private void adminBackBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminBackBTMouseClicked


    if (skibidiclicked == true){

           EasterEgg egg = new EasterEgg();
           egg.setVisible(true);


    } else {
        
            AdminPanel.setVisible(false);
            HomePanel.setVisible(true);

            sound.stopMusic1();
            sound.stopMusic2();
            sound.stopMusic3();
            sound.stopMusic4();
            sound.stopMusic5();

            giflabel1.setIcon(null);
            giflabel2.setIcon(null);
            giflabel3.setIcon(null);
            giflabel4.setIcon(null);
            giflabel5.setIcon(null);
            VolumeYT.setIcon(new ImageIcon("lowvol.jpg"));
            volumepress = false;


            sound.playSound3(clip);
            sound.startMusic1();
            sound.midMusic();

   }
        
        
    
    }//GEN-LAST:event_adminBackBTMouseClicked

    private void adminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTableMouseClicked
        SelectAdmin();
    }//GEN-LAST:event_adminTableMouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        EasterEgg egg = new EasterEgg();
        egg.setVisible(true);
        sound.deafMusic();
        
        skibidiclicked = true;
    }//GEN-LAST:event_jLabel19MouseClicked

    private void adminBackBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminBackBTMouseEntered
        ColorMouseEvent color = new ColorMouseEvent();
        color.ColorlabelWhiteF(adminBackBT);
    }//GEN-LAST:event_adminBackBTMouseEntered

    private void adminBackBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminBackBTMouseExited
        ColorMouseEvent color = new ColorMouseEvent();
        color.AdminColorlabelGray(adminBackBT);
       
    }//GEN-LAST:event_adminBackBTMouseExited

    private void fbiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fbiconMouseClicked
        try{
             Desktop.getDesktop().browse(new URL("https://www.facebook.com/samueljames.cinco.5").toURI());
         }catch(Exception e){}
        skibimethod();
    }//GEN-LAST:event_fbiconMouseClicked

    private void discordiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discordiconMouseClicked
        try{Desktop.getDesktop().browse(new URL("https://discordapp.com/users/767280222311415819/").toURI());}catch(Exception e){}
        skibimethod();
    }//GEN-LAST:event_discordiconMouseClicked

    private void xiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xiconMouseClicked
        try{Desktop.getDesktop().browse(new URL("https://twitter.com/imsauce_").toURI());}catch(Exception e){}
        skibimethod();
    }//GEN-LAST:event_xiconMouseClicked

    private void githubiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_githubiconMouseClicked
        try{Desktop.getDesktop().browse(new URL("https://github.com/ImSauce").toURI());}catch(Exception e){}
        skibimethod();
    }//GEN-LAST:event_githubiconMouseClicked

    private void YTmusic1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTmusic1MouseClicked
      YTmethod1();
      
    if (evt.getButton() == MouseEvent.BUTTON3) {
    try{Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=2QAXjBQkbvQ").toURI());}catch(Exception e){}
    }
    }//GEN-LAST:event_YTmusic1MouseClicked

    private void YTmusic2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTmusic2MouseClicked
       YTmethod2();
       if (evt.getButton() == MouseEvent.BUTTON3) {
    try{Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=mkBdv0YzKJE").toURI());}catch(Exception e){}
    }
    }//GEN-LAST:event_YTmusic2MouseClicked

    private void YTmusic5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTmusic5MouseClicked
       YTmethod5();
       if (evt.getButton() == MouseEvent.BUTTON3) {
    try{Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=pu8t3geNVHU").toURI());}catch(Exception e){}
    }
    }//GEN-LAST:event_YTmusic5MouseClicked

    private void YTmusic3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTmusic3MouseClicked
       YTmethod3();
        if (evt.getButton() == MouseEvent.BUTTON3) {
    try{Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=8IdRnQRArRs").toURI());}catch(Exception e){}
    }
    }//GEN-LAST:event_YTmusic3MouseClicked

    private void YTmusic4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTmusic4MouseClicked
       YTmethod4();
       if (evt.getButton() == MouseEvent.BUTTON3) {
    try{Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=VQoaBqSLqFA").toURI());}catch(Exception e){}
    }
    }//GEN-LAST:event_YTmusic4MouseClicked

    private void YTname1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTname1MouseClicked
        YTmusic1MouseClicked(evt);
    }//GEN-LAST:event_YTname1MouseClicked

    private void YTname2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTname2MouseClicked
        YTmusic2MouseClicked(evt);
    }//GEN-LAST:event_YTname2MouseClicked

    private void YTname3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTname3MouseClicked
        YTmusic3MouseClicked(evt);
    }//GEN-LAST:event_YTname3MouseClicked

    private void YTname4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTname4MouseClicked
        YTmusic4MouseClicked(evt);
    }//GEN-LAST:event_YTname4MouseClicked

    private void YTname5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTname5MouseClicked
        YTmusic5MouseClicked(evt);
    }//GEN-LAST:event_YTname5MouseClicked

    private void TransactionSearchTXTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TransactionSearchTXTFocusGained
        if (TransactionSearchTXT.getText().equals("search...")) //mouseentered
        {
            TransactionSearchTXT.setText("");
            TransactionSearchTXT.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_TransactionSearchTXTFocusGained

    private void TransactionSearchTXTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TransactionSearchTXTFocusLost
        if (TransactionSearchTXT.getText().equals("")) //mouseexited
        {
            TransactionSearchTXT.setText("search...");
            TransactionSearchTXT.setForeground(new Color (66,66,66));
        }
    }//GEN-LAST:event_TransactionSearchTXTFocusLost

    private void TransactionSearchTXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TransactionSearchTXTCaretUpdate
         if (!TransactionSearchTXT.getText().equals("search...")) //mouseentered
        {
           SearchTransac();
        }
    }//GEN-LAST:event_TransactionSearchTXTCaretUpdate

    private void ImportSearchTXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ImportSearchTXTCaretUpdate
          SearchImport();
    }//GEN-LAST:event_ImportSearchTXTCaretUpdate

    private void ImportSearchTXTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ImportSearchTXTFocusGained
        if (ImportSearchTXT.getText().equals("search...")) //mouseentered
        {
            ImportSearchTXT.setText("");
            ImportSearchTXT.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_ImportSearchTXTFocusGained

    private void ImportSearchTXTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ImportSearchTXTFocusLost
        if (ImportSearchTXT.getText().equals("")) //mouseexited
        {
            ImportSearchTXT.setText("search...");
            ImportSearchTXT.setForeground(new Color (66,66,66));
        }
    }//GEN-LAST:event_ImportSearchTXTFocusLost

    private void FirearmItemName26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FirearmItemName26MouseClicked
        fbiconMouseClicked(evt);
    }//GEN-LAST:event_FirearmItemName26MouseClicked

    private void FirearmItemName27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FirearmItemName27MouseClicked
        discordiconMouseClicked(evt);
    }//GEN-LAST:event_FirearmItemName27MouseClicked

    private void FirearmItemName28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FirearmItemName28MouseClicked
        githubiconMouseClicked(evt);
    }//GEN-LAST:event_FirearmItemName28MouseClicked

    private void FirearmItemName29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FirearmItemName29MouseClicked
        xiconMouseClicked(evt);
    }//GEN-LAST:event_FirearmItemName29MouseClicked

    
    boolean volumepress = false;
    private void VolumeYTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolumeYTMouseClicked
        if (volumepress == false){
            volumepress = true;
            VolumeYT.setIcon(new ImageIcon("highvol.jpg"));
            sound.upMusic();
        }else {
            volumepress = false;
            VolumeYT.setIcon(new ImageIcon("lowvol.jpg"));
            sound.midMusic();
        }
    }//GEN-LAST:event_VolumeYTMouseClicked

    private void fbiconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fbiconMouseEntered
        
        fb.setVisible(true);   
    }//GEN-LAST:event_fbiconMouseEntered

    private void fbiconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fbiconMouseExited
        
        fb.setVisible(false);
    }//GEN-LAST:event_fbiconMouseExited

    private void discordiconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discordiconMouseEntered
        dis.setVisible(true);
    }//GEN-LAST:event_discordiconMouseEntered

    private void discordiconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discordiconMouseExited
        dis.setVisible(false);
    }//GEN-LAST:event_discordiconMouseExited

    private void githubiconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_githubiconMouseEntered
        git.setVisible(true);
    }//GEN-LAST:event_githubiconMouseEntered

    private void githubiconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_githubiconMouseExited
        git.setVisible(false);
    }//GEN-LAST:event_githubiconMouseExited

    private void xiconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xiconMouseEntered
        x.setVisible(true);
    }//GEN-LAST:event_xiconMouseEntered

    private void xiconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xiconMouseExited
        x.setVisible(false);
    }//GEN-LAST:event_xiconMouseExited

    private void TitleMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMenuMouseEntered
        TitleMenu.setIcon(new ImageIcon("asaaaaaaaa2.png"));
        sound.playSound2(clip);
    }//GEN-LAST:event_TitleMenuMouseEntered

    private void TitleMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMenuMouseExited
        TitleMenu.setIcon(new ImageIcon("asaaaaaaaa.png"));
    }//GEN-LAST:event_TitleMenuMouseExited

    private void productImageEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productImageEditMouseClicked
        
    if (evt.getButton() == MouseEvent.BUTTON3) {
        try{edit_imagePath.setText(""); // Clear the text
            edit_imageName.setText("");
            productImageEdit.setIcon(null); // Clear the icon
            edit_remove_image=1;
            }catch(Exception e){}
    }else { 
        EditImage(); 
        }
    }//GEN-LAST:event_productImageEditMouseClicked

    private void removeImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeImageActionPerformed
        add_imagePath.setText(""); // Clear the text
        add_imageName.setText("");
        productImage.setIcon(new ImageIcon("insertimage.jpg")); // Clear the icon

        add_remove_image = 1;

    }//GEN-LAST:event_removeImageActionPerformed

    int powernum = 0;
    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
        add_power.setText("0");
        powernum=0;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }else{
        add_power.setText("1");
        powernum=1;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10); 
        }     
    }//GEN-LAST:event_p1MouseClicked

    private void p2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseClicked
        add_power.setText("2");
        powernum=2;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p2MouseClicked

    private void p3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p3MouseClicked
        add_power.setText("3");
        powernum=3;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p3MouseClicked

    private void p4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p4MouseClicked
        add_power.setText("4");
        powernum=4;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p4MouseClicked

    private void p5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseClicked
        add_power.setText("5");
        powernum=5;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p5MouseClicked

    private void p6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p6MouseClicked
       add_power.setText("6");
        powernum=6;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p6MouseClicked

    private void p7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p7MouseClicked
        add_power.setText("7");
        powernum=7;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p7MouseClicked

    private void p8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p8MouseClicked
        add_power.setText("8");
        powernum=8;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p8MouseClicked

    private void p9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p9MouseClicked
        add_power.setText("9");
        powernum=9;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p9MouseClicked

    private void p10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p10MouseClicked
        add_power.setText("10");
        powernum=10;
        
        ProductMethods.clicked(powernum, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }//GEN-LAST:event_p10MouseClicked

    
    int fireratenum = 0;
    private void fr1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
        add_firerate.setText("0");
        fireratenum=0;
        
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }else{
        add_firerate.setText("1");
        fireratenum=1;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
        }     
    }//GEN-LAST:event_fr1MouseClicked

    private void fr2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr2MouseClicked
        add_firerate.setText("2");
        fireratenum=2;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr2MouseClicked

    private void fr3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr3MouseClicked
        add_firerate.setText("3");
        fireratenum=3;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr3MouseClicked

    private void fr4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr4MouseClicked
        add_firerate.setText("4");
        fireratenum=4;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr4MouseClicked

    private void fr5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr5MouseClicked
        add_firerate.setText("5");
        fireratenum=5;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr5MouseClicked

    private void fr6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr6MouseClicked
        add_firerate.setText("6");
        fireratenum=6;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr6MouseClicked

    private void fr7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr7MouseClicked
        add_firerate.setText("7");
        fireratenum=7;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr7MouseClicked

    private void fr8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr8MouseClicked
        add_firerate.setText("8");
        fireratenum=8;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr8MouseClicked

    private void fr9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr9MouseClicked
        add_firerate.setText("9");
        fireratenum=9;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr9MouseClicked

    private void fr10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fr10MouseClicked
        add_firerate.setText("10");
        fireratenum=10;
        ProductMethods.clicked(fireratenum, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
    }//GEN-LAST:event_fr10MouseClicked

    int reloadnum=0;
    private void r1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
        add_reloadspeed.setText("0");
        reloadnum=0;
        
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }else{
        add_reloadspeed.setText("1");
        reloadnum=1;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }     
    }//GEN-LAST:event_r1MouseClicked

    private void r2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r2MouseClicked
        add_reloadspeed.setText("2");
        reloadnum=2;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r2MouseClicked

    private void r3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r3MouseClicked
        add_reloadspeed.setText("3");
        reloadnum=3;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r3MouseClicked

    private void r4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r4MouseClicked
        add_reloadspeed.setText("4");
        reloadnum=4;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r4MouseClicked

    private void r5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r5MouseClicked
        add_reloadspeed.setText("5");
        reloadnum=5;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r5MouseClicked

    private void r6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r6MouseClicked
        add_reloadspeed.setText("6");
        reloadnum=6;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r6MouseClicked

    private void r7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r7MouseClicked
        add_reloadspeed.setText("7");
        reloadnum=7;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r7MouseClicked

    private void r8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r8MouseClicked
        add_reloadspeed.setText("8");
        reloadnum=8;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r8MouseClicked

    private void r9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r9MouseClicked
        add_reloadspeed.setText("9");
        reloadnum=9;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r9MouseClicked

    private void r10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r10MouseClicked
        add_reloadspeed.setText("10");
        reloadnum=10;
        ProductMethods.clicked(reloadnum, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }//GEN-LAST:event_r10MouseClicked

    
    
    int ammonum=0;
    private void a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
        add_ammo.setText("0");
        ammonum=0;
        
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }else{
        add_ammo.setText("1");
        ammonum=1;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
        }     
    }//GEN-LAST:event_a1MouseClicked

    private void a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseClicked
        add_ammo.setText("2");
        ammonum=2;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a2MouseClicked

    private void a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseClicked
        add_ammo.setText("3");
        ammonum=3;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a3MouseClicked

    private void a4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseClicked
        add_ammo.setText("4");
        ammonum=4;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a4MouseClicked

    private void a5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseClicked
        add_ammo.setText("5");
        ammonum=5;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a5MouseClicked

    private void a6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseClicked
        add_ammo.setText("6");
        ammonum=6;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a6MouseClicked

    private void a7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseClicked
        add_ammo.setText("7");
        ammonum=7;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a7MouseClicked

    private void a8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a8MouseClicked
        add_ammo.setText("8");
        ammonum=8;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a8MouseClicked

    private void a9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a9MouseClicked
        add_ammo.setText("9");
        ammonum=9;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a9MouseClicked

    private void a10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a10MouseClicked
        add_ammo.setText("10");
        ammonum=10;
        ProductMethods.clicked(ammonum, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }//GEN-LAST:event_a10MouseClicked

    private void addpowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpowerActionPerformed
        int plus = Integer.parseInt(edit_power.getText());
        int max = 10;
        if (plus != max ) {
        plus += 1;
        edit_power.setText(Integer.toString(plus)); 
        }else{
        sound.playSound4(clip);
        }

    }//GEN-LAST:event_addpowerActionPerformed

    private void reducepowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reducepowerActionPerformed
        int reduce = Integer.parseInt(edit_power.getText());
        if (reduce != 0) {
        
        reduce -= 1;
        edit_power.setText(Integer.toString(reduce));
        
        }else {
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_reducepowerActionPerformed

    private void addfirerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addfirerateActionPerformed
        int plus = Integer.parseInt(edit_firerate.getText());
        int max = 10;
        if (plus != max ) {
        plus += 1;
        edit_firerate.setText(Integer.toString(plus)); 
        }else{
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_addfirerateActionPerformed

    private void reducefirerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reducefirerateActionPerformed
       int reduce = Integer.parseInt(edit_firerate.getText());
        if (reduce != 0) {
        
        reduce -= 1;
        edit_firerate.setText(Integer.toString(reduce));
        
        }else {
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_reducefirerateActionPerformed

    private void addreloadspeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addreloadspeedActionPerformed
        int plus = Integer.parseInt(edit_reloadspeed.getText());
        int max = 10;
        if (plus != max ) {
        plus += 1;
        edit_reloadspeed.setText(Integer.toString(plus)); 
        }else{
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_addreloadspeedActionPerformed

    private void reducereloadspeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reducereloadspeedActionPerformed
        int reduce = Integer.parseInt(edit_reloadspeed.getText());
        if (reduce != 0) {
        
        reduce -= 1;
        edit_reloadspeed.setText(Integer.toString(reduce));
        
        }else {
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_reducereloadspeedActionPerformed

    private void addaccuracyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addaccuracyActionPerformed
        int plus = Integer.parseInt(edit_ammo.getText());
        int max = 10;
        if (plus != max ) {
        plus += 1;
        edit_ammo.setText(Integer.toString(plus)); 
        }else{
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_addaccuracyActionPerformed

    private void reduceaccuracyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reduceaccuracyActionPerformed
        int reduce = Integer.parseInt(edit_ammo.getText());
        if (reduce != 0) {
        
        reduce -= 1;
        edit_ammo.setText(Integer.toString(reduce));
        
        }else {
        sound.playSound4(clip);
        }
    }//GEN-LAST:event_reduceaccuracyActionPerformed
 
    
        
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddProductLabelProduct;
    private javax.swing.JPanel AddProductPanel;
    private javax.swing.JPanel AdminPanel;
    private javax.swing.JLabel CartLabelShop;
    private javax.swing.JTable CartTable;
    private javax.swing.JLabel EarningLabelTransaction;
    private javax.swing.JTable EarningsTABLE;
    private javax.swing.JScrollPane EarningsTableScroll;
    private javax.swing.JScrollPane EarningsTableScroll1;
    private javax.swing.JLabel EditProductLabelProduct;
    private javax.swing.JPanel EditProductPanel;
    private javax.swing.JTable EditTable;
    private javax.swing.JScrollPane EditTableScroll;
    private javax.swing.JScrollPane EditTableScroll1;
    private javax.swing.JLabel FirearmCost;
    private javax.swing.JLabel FirearmCost1;
    private javax.swing.JLabel FirearmCost2;
    private javax.swing.JLabel FirearmCost4;
    private javax.swing.JLabel FirearmCost5;
    private SystemOtherComps.PH_TextArea FirearmDescription;
    private javax.swing.JLabel FirearmID;
    private javax.swing.JLabel FirearmImage;
    private javax.swing.JLabel FirearmItemName;
    private javax.swing.JLabel FirearmItemName1;
    private javax.swing.JLabel FirearmItemName10;
    private javax.swing.JLabel FirearmItemName11;
    private javax.swing.JLabel FirearmItemName12;
    private javax.swing.JLabel FirearmItemName14;
    private javax.swing.JLabel FirearmItemName15;
    private javax.swing.JLabel FirearmItemName16;
    private javax.swing.JLabel FirearmItemName17;
    private javax.swing.JLabel FirearmItemName18;
    private javax.swing.JLabel FirearmItemName19;
    private javax.swing.JLabel FirearmItemName2;
    private javax.swing.JLabel FirearmItemName20;
    private javax.swing.JLabel FirearmItemName21;
    private javax.swing.JLabel FirearmItemName25;
    private javax.swing.JLabel FirearmItemName26;
    private javax.swing.JLabel FirearmItemName27;
    private javax.swing.JLabel FirearmItemName28;
    private javax.swing.JLabel FirearmItemName29;
    private javax.swing.JLabel FirearmItemName3;
    private javax.swing.JLabel FirearmItemName30;
    private javax.swing.JLabel FirearmItemName31;
    private javax.swing.JLabel FirearmItemName35;
    private javax.swing.JLabel FirearmItemName36;
    private javax.swing.JLabel FirearmItemName37;
    private javax.swing.JLabel FirearmItemName38;
    private javax.swing.JLabel FirearmItemName39;
    private javax.swing.JLabel FirearmItemName4;
    private javax.swing.JLabel FirearmItemName40;
    private javax.swing.JLabel FirearmItemName41;
    private javax.swing.JLabel FirearmItemName42;
    private javax.swing.JLabel FirearmItemName43;
    private javax.swing.JLabel FirearmItemName44;
    private javax.swing.JLabel FirearmItemName45;
    private javax.swing.JLabel FirearmItemName46;
    private javax.swing.JLabel FirearmItemName47;
    private javax.swing.JLabel FirearmItemName48;
    private javax.swing.JLabel FirearmItemName49;
    private javax.swing.JLabel FirearmItemName5;
    private javax.swing.JLabel FirearmItemName50;
    private javax.swing.JLabel FirearmItemName51;
    private javax.swing.JLabel FirearmItemName52;
    private javax.swing.JLabel FirearmItemName53;
    private javax.swing.JLabel FirearmItemName54;
    private javax.swing.JLabel FirearmItemName55;
    private javax.swing.JLabel FirearmItemName56;
    private javax.swing.JLabel FirearmItemName7;
    private javax.swing.JLabel FirearmItemName8;
    private javax.swing.JLabel FirearmItemName9;
    private javax.swing.JLabel FirearmLabelShop;
    private javax.swing.JPanel FirearmProductInfo;
    private javax.swing.JPanel FirearmProductInfo1;
    private javax.swing.JTextField FirearmQuantity;
    private javax.swing.JLabel FirearmStock;
    private javax.swing.JLabel FirearmType;
    private SystemOtherComps.PH_BettterFlowLayoutPanel FlowPanel;
    private javax.swing.JScrollPane FlowPanelScroll;
    private javax.swing.JLabel HomeLabelProduct;
    private javax.swing.JLabel HomeLabelShop;
    private javax.swing.JLabel HomeLabelTransaction;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JLabel ImportLabelTransaction;
    private javax.swing.JTextField ImportSearchTXT;
    private javax.swing.JTable ImportTABLE;
    private javax.swing.JTable ImportTable;
    private javax.swing.JScrollPane ImportTableScroll1;
    private javax.swing.JScrollPane ImportTableScroll3;
    private javax.swing.JPanel InfoPanelEdit;
    private javax.swing.JTextField NumberOfImports;
    private javax.swing.JTextField NumberOfTransactions;
    private javax.swing.JTextField OriginalPrice;
    private javax.swing.JLabel ProductLabel;
    private javax.swing.JPanel ProductLayerPanel;
    private javax.swing.JPanel ProductMenu;
    private javax.swing.JPanel ProductPanel;
    private javax.swing.JPanel ProductPanelHome;
    private SystemOtherComps.PH_Button RemoveBT;
    private SystemOtherComps.PH_Button RemoveCart;
    private javax.swing.JPanel ShopCart;
    private javax.swing.JPanel ShopFirearms;
    private javax.swing.JLabel ShopLabel;
    private javax.swing.JPanel ShopLayerPanel;
    private javax.swing.JPanel ShopMenu;
    private javax.swing.JPanel ShopPanel;
    private javax.swing.JPanel ShopPanelHome;
    private javax.swing.JLabel TitleMenu;
    private javax.swing.JLabel Total_Amount_Owned;
    private javax.swing.JLabel Total_Earnings;
    private javax.swing.JLabel Total_Expenses;
    private javax.swing.JPanel TransactionEarnings;
    private javax.swing.JPanel TransactionImport;
    private javax.swing.JLabel TransactionLabel;
    private javax.swing.JLabel TransactionLabelTransaction;
    private javax.swing.JPanel TransactionLayerPanel;
    private javax.swing.JPanel TransactionMenu;
    private javax.swing.JPanel TransactionPanel;
    private javax.swing.JPanel TransactionPanelHome;
    private javax.swing.JTextField TransactionSearchTXT;
    private javax.swing.JTable TransactionTable;
    private javax.swing.JPanel TransactionTransaction;
    private SystemOtherComps.PH_Button UpdateBT;
    private javax.swing.JLabel VolumeYT;
    private javax.swing.JLabel YTmusic1;
    private javax.swing.JLabel YTmusic2;
    private javax.swing.JLabel YTmusic3;
    private javax.swing.JLabel YTmusic4;
    private javax.swing.JLabel YTmusic5;
    private javax.swing.JLabel YTname1;
    private javax.swing.JLabel YTname2;
    private javax.swing.JLabel YTname3;
    private javax.swing.JLabel YTname4;
    private javax.swing.JLabel YTname5;
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a10;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JTextField a4;
    private javax.swing.JTextField a5;
    private javax.swing.JTextField a6;
    private javax.swing.JTextField a7;
    private javax.swing.JTextField a8;
    private javax.swing.JTextField a9;
    private javax.swing.JButton addQuantity;
    private javax.swing.JTextField add_ammo;
    private javax.swing.JTextField add_businessFunds;
    private javax.swing.JTextField add_cost;
    public javax.swing.JTextPane add_description;
    private javax.swing.JTextField add_firerate;
    private javax.swing.JTextField add_id;
    private javax.swing.JTextField add_imageName;
    private javax.swing.JTextField add_imagePath;
    private javax.swing.JTextField add_importFee;
    private javax.swing.JTextField add_name;
    private javax.swing.JTextField add_power;
    private javax.swing.JTextField add_reloadspeed;
    private javax.swing.JTextField add_stock;
    private javax.swing.JComboBox<String> add_type;
    private javax.swing.JButton addaccuracy;
    private javax.swing.JButton addfirerate;
    private javax.swing.JButton addpower;
    private javax.swing.JButton addreloadspeed;
    private javax.swing.JLabel adminBackBT;
    private javax.swing.JTable adminTable;
    private javax.swing.JScrollPane adminTableScroll;
    private javax.swing.JLabel admin_active;
    private javax.swing.JTextField admin_cash;
    private SystemOtherComps.PH_Button admin_delete;
    private javax.swing.JLabel admin_ip;
    private javax.swing.JLabel admin_pass;
    private javax.swing.JTextField admin_password;
    private SystemOtherComps.PH_Button admin_save;
    private javax.swing.JComboBox<String> admin_status;
    private javax.swing.JLabel admin_user;
    private javax.swing.JTextField admin_username;
    private javax.swing.JLabel admin_username2;
    private javax.swing.JTextField cartChange;
    private javax.swing.JTextField cartPayment;
    private javax.swing.JTextField cartSubtotal;
    private javax.swing.JTextField cartTax;
    private javax.swing.JTextField cartTotal;
    private javax.swing.JLabel cart_Cost;
    private SystemOtherComps.PH_TextArea cart_Description;
    private javax.swing.JLabel cart_Image;
    private javax.swing.JLabel cart_Name;
    private javax.swing.JLabel cart_Type;
    private SystemOtherComps.PH_Button clearBT;
    private javax.swing.JButton decrease_stock;
    private javax.swing.JLabel discordicon;
    private javax.swing.JTextField edit_ammo;
    private javax.swing.JTextField edit_businessFunds;
    private javax.swing.JTextField edit_cost;
    private SystemOtherComps.PH_TextArea edit_description;
    private javax.swing.JTextField edit_fee;
    private javax.swing.JTextField edit_firerate;
    private javax.swing.JTextField edit_id;
    private javax.swing.JTextField edit_id_2;
    private javax.swing.JTextField edit_imageName;
    private javax.swing.JTextField edit_imagePath;
    private javax.swing.JTextField edit_name;
    private javax.swing.JTextField edit_power;
    private javax.swing.JTextField edit_reloadspeed;
    private javax.swing.JComboBox<String> edit_sorter;
    private javax.swing.JTextField edit_stock;
    private javax.swing.JComboBox<String> edit_type;
    private javax.swing.JLabel fbicon;
    private javax.swing.JTextField fr1;
    private javax.swing.JTextField fr10;
    private javax.swing.JTextField fr2;
    private javax.swing.JTextField fr3;
    private javax.swing.JTextField fr4;
    private javax.swing.JTextField fr5;
    private javax.swing.JTextField fr6;
    private javax.swing.JTextField fr7;
    private javax.swing.JTextField fr8;
    private javax.swing.JTextField fr9;
    private javax.swing.JLabel giflabel1;
    private javax.swing.JLabel giflabel2;
    private javax.swing.JLabel giflabel3;
    private javax.swing.JLabel giflabel4;
    private javax.swing.JLabel giflabel5;
    private javax.swing.JLabel githubicon;
    private javax.swing.JButton increase_stock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel local;
    public javax.swing.JLabel local2;
    public javax.swing.JLabel local3;
    private javax.swing.JTextField new_stock;
    private javax.swing.JTextField p1;
    private javax.swing.JTextField p10;
    private javax.swing.JTextField p2;
    private javax.swing.JTextField p3;
    private javax.swing.JTextField p4;
    private javax.swing.JTextField p5;
    private javax.swing.JTextField p6;
    private javax.swing.JTextField p7;
    private javax.swing.JTextField p8;
    private javax.swing.JTextField p9;
    private SystemOtherComps.PH_Button pH_Button1;
    private SystemOtherComps.PH_TextAreaScroll pH_TextAreaScroll1;
    private SystemOtherComps.PH_TextAreaScroll pH_TextAreaScroll2;
    private SystemOtherComps.PH_TextAreaScroll pH_TextAreaScroll3;
    public javax.swing.JLabel passwordMain;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel productImageEdit;
    private SystemOtherComps.PH_Button purchaseBT;
    private javax.swing.JTextField r1;
    private javax.swing.JTextField r10;
    private javax.swing.JTextField r2;
    private javax.swing.JTextField r3;
    private javax.swing.JTextField r4;
    private javax.swing.JTextField r5;
    private javax.swing.JTextField r6;
    private javax.swing.JTextField r7;
    private javax.swing.JTextField r8;
    private javax.swing.JTextField r9;
    private javax.swing.JButton reduceQuantity;
    private javax.swing.JButton reduceaccuracy;
    private javax.swing.JButton reducefirerate;
    private javax.swing.JButton reducepower;
    private javax.swing.JButton reducereloadspeed;
    private javax.swing.JButton removeImage;
    private SystemOtherComps.PH_Button saveBT;
    private javax.swing.JLabel shadowgunimage;
    public javax.swing.JLabel usernameMain;
    private javax.swing.JPanel walletPanel;
    private javax.swing.JPanel walletPanel1;
    public javax.swing.JTextField walletTxt;
    public javax.swing.JTextField walletTxtCart;
    private javax.swing.JLabel xicon;
    // End of variables declaration//GEN-END:variables

////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////            HOME LABELS METHOD                //////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////// 
    public void shopLabelClick(){
       if (userClicked) {
            sound.stopMusic1(); // Stop the music only if the user clicked
            sound.playMusicLoop2();
        }

        
        ShopPanel.setVisible(true);
        ShopFirearms.setVisible(true);
        ShopCart.setVisible(false);
        HomePanel.setVisible(false);
        
    
        
        ShopClicked = 1;
        CartClicked = 0;
        ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);
        ClearCart();
        ClearFirearmProductInfo();
        //initProds();
        sound.playSound3(clip);   
    
    
    
    
    }
    
    
    
    public void productLabelClick(){
    String sql = "SELECT * FROM `user` WHERE username=? AND password=? AND admin =?";
         try {
            pst = con.prepareStatement(sql);
           
            pst.setString(1, usernameMain.getText());
            pst.setString(2, passwordMain.getText());
            pst.setString(3, "ADMIN");
            rs = pst.executeQuery();

            if (rs.next()) {
                
                 if (userClicked) {
                sound.stopMusic1(); // Stop the music only if the user clicked
                sound.playMusicLoop3();
            }
                
                
            refreshTable();
            ProductPanel.setVisible(true);
            AddProductPanel.setVisible(true);
            EditProductPanel.setVisible(false);
            HomePanel.setVisible(false);
            autoIncrement();
            AddClicked = 1;
            EditClicked = 0;
            
            
           

            ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);        
            sound.playSound3(clip);
             importFee();

            }else{
            sound.playSound4(clip);
            }
               
            
        } catch (SQLException ex) {
            sound.playSound4(clip);
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    
    }
    
    
    
      public void transactionLabelClick(){
    String sql = "SELECT * FROM `user` WHERE username=? AND password=? AND admin =?";
         try {
            pst = con.prepareStatement(sql);
           
            pst.setString(1, usernameMain.getText());
            pst.setString(2, passwordMain.getText());
            pst.setString(3, "ADMIN");
            rs = pst.executeQuery();

            if (rs.next()) {
                
                if (userClicked) {
                sound.stopMusic1(); // Stop the music only if the user clicked
                sound.playMusicLoop4();
            }
            
            refreshEarnings();
            refreshCharts();
            refreshTable();
            TransactionPanel.setVisible(true);
            TransactionTransaction.setVisible(true);
            TransactionImport.setVisible(false);
            TransactionEarnings.setVisible(false);
            HomePanel.setVisible(false);
            refreshImportTable();
            
            


            TransactionClicked = 1;
            ImportClicked = 0;
            EarningClicked = 0;
            ProductMethods.MenuClicked(EditClicked, EditProductLabelProduct, AddClicked, AddProductLabelProduct, ShopClicked, FirearmLabelShop, CartClicked, CartLabelShop, TransactionClicked, TransactionLabelTransaction, ImportClicked, ImportLabelTransaction,EarningClicked,EarningLabelTransaction);        


            sound.playSound3(clip);
           

            }else{
            sound.playSound4(clip);
            }
               
            
        } catch (SQLException ex) {
            sound.playSound4(clip);
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////            SHOP FIREARMS METHOD                //////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////// 

    public void initProds() {
    // DB connection  
    String COUNT = "SELECT COUNT(*) FROM product";
    String NAME = "SELECT product FROM product WHERE id = ?";
    String PRICE = "SELECT cost FROM product WHERE id = ?";
    String TYPE = "SELECT type FROM product WHERE id = ?";
    String DESCRIPTION = "SELECT description FROM product WHERE id = ?";
    String STOCK = "SELECT stock FROM product WHERE id = ?";
    String PRODUCTID = "SELECT id FROM product WHERE id = ?";
    
    String POWER = "SELECT power FROM product WHERE id = ?";
    String FIRERATE = "SELECT firerate FROM product WHERE id = ?";
    String RELOADSPEED = "SELECT reloadspeed FROM product WHERE id = ?";
    String AMMO = "SELECT ammo FROM product WHERE id = ?";
    PreparedStatement ptsCount, ptsName, ptsPrice, ptsType, ptsDescription,ptsStock, ptsID, ptsPower, ptsFirerate, ptsReloadSpeed, ptsAmmo ;
    ResultSet resultSet;
    
    try {
        // Clear the FlowPanel
        FlowPanel.removeAll();

        // Get the total count
        ptsCount = con.prepareStatement(COUNT);
        resultSet = ptsCount.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);

        for (int i = 1; i <= count; i++) {
            // Product name
            ptsName = con.prepareStatement(NAME);
            ptsName.setString(1, String.valueOf(i)); // Assuming i is still numeric for the loop index
            resultSet = ptsName.executeQuery();
            if (resultSet.next()) {
                String prdName = resultSet.getString(1);

                // Product price
                ptsPrice = con.prepareStatement(PRICE);
                ptsPrice.setString(1, String.valueOf(i));
                resultSet = ptsPrice.executeQuery();
                resultSet.next();
                int prdPrice = resultSet.getInt(1);
                
                // Product type
                ptsType = con.prepareStatement(TYPE);
                ptsType.setString(1, String.valueOf(i));
                resultSet = ptsType.executeQuery();
                resultSet.next();
                String prdType = resultSet.getString(1);
                
                  // Product description
                ptsDescription = con.prepareStatement(DESCRIPTION);
                ptsDescription.setString(1, String.valueOf(i));
                resultSet = ptsDescription.executeQuery();
                resultSet.next();
                String prdDescription = resultSet.getString(1);
                
                ptsStock = con.prepareStatement(STOCK);
                ptsStock.setString(1, String.valueOf(i));
                resultSet = ptsStock.executeQuery();
                resultSet.next();
                int prdStock = resultSet.getInt(1);
                
                ptsID = con.prepareStatement(PRODUCTID);
                ptsID.setString(1, String.valueOf(i));
                resultSet = ptsID.executeQuery();
                resultSet.next();
                int prdID = resultSet.getInt(1);
                
                ptsPower = con.prepareStatement(POWER);
                ptsPower.setString(1, String.valueOf(i));
                resultSet = ptsPower.executeQuery();
                resultSet.next();
                int prdPower = resultSet.getInt(1);
                
                ptsFirerate = con.prepareStatement(FIRERATE);
                ptsFirerate.setString(1, String.valueOf(i));
                resultSet = ptsFirerate.executeQuery();
                resultSet.next();
                int prdFirerate = resultSet.getInt(1);
                
                ptsReloadSpeed = con.prepareStatement(RELOADSPEED);
                ptsReloadSpeed.setString(1, String.valueOf(i));
                resultSet = ptsReloadSpeed.executeQuery();
                resultSet.next();
                int prdReloadspeed = resultSet.getInt(1);
                
                ptsAmmo = con.prepareStatement(AMMO);
                ptsAmmo.setString(1, String.valueOf(i));
                resultSet = ptsAmmo.executeQuery();
                resultSet.next();
                int prdAmmo = resultSet.getInt(1);
               
                
                double money = Double.parseDouble(walletTxt.getText().replace(",", ""));
                
                // Create itemPanel and set details
                itemPanel shopPanel = new itemPanel(this);
                shopPanel.setDetails(prdName, prdPrice, prdType,prdDescription,prdStock, prdID, money, prdPower, prdFirerate, prdReloadspeed, prdAmmo);

                // Load and add image
                loadAndAddImage(i, shopPanel);
                // Add itemPanel to FlowPanel
                FlowPanel.add(shopPanel);
                
                ITEMPANELS.add(shopPanel);
                
                
                
                 
            } else {
                System.out.println("No data found for product with ID: " + i);
                // Handle the case where no data is found (e.g., log a message, skip adding the item)
            }
        }

        // Repaint the FlowPanel
        FlowPanel.revalidate();
        FlowPanel.repaint();

    } catch (SQLException ex) {
        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
   
    public void setProductDetails(String productName, ImageIcon productImage, int productPrice, String productType, String productDescription, int productStock, int productID, int power, int firerate, int reloadspeed, int ammo) {
    FirearmItemName.setText(productName);
    
    // Scale the image to match the label width and height
    Image originalImage = productImage.getImage();
    Image scaledImage = originalImage.getScaledInstance(247, 203, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    FirearmImage.setIcon(scaledIcon);
    
    
    FirearmCost.setText(String.valueOf(productPrice));
    FirearmStock.setText(String.valueOf(productStock));
    FirearmID.setText(String.valueOf(productID));
    FirearmType.setText(productType);
    FirearmDescription.setText(productDescription);
    FirearmQuantity.setText("1"); // Clear quantity field if needed
    
    
     
        
    double money = Double.parseDouble( walletTxt.getText().replace(",", ""));
    
    if (productPrice <= money)
        {
            FirearmCost.setForeground(new java.awt.Color(52, 196, 57));
        } 
        else {
        FirearmCost.setForeground(new java.awt.Color(201,15,15));
        }
    
   
}
     

     
       public void autoIncrement() {
        String query = "SELECT MAX(id) AS id FROM product";
        
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                int highestID = rs.getInt("id");
                int increment = highestID+1;
               add_id.setText(Integer.toString(increment));
                  
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle or log the exception appropriately
        }
    }
     
       
    public void AddToCart(int firearmID) {
        
         
       
       
        
        
        pH_Button1.setAA_RippleColor(new java.awt.Color(80,80,80));
        serverCredentials sv = new serverCredentials();
        sv.setServerIP(local2.getText());
        sv.setUserID(local.getText());
        sv.setPass(local3.getText());
        
        int cost = Integer.parseInt(FirearmCost.getText());
        int stock = Integer.parseInt(FirearmStock.getText());
        int quantity = Integer.parseInt(FirearmQuantity.getText());
        int ProdID =  Integer.parseInt(FirearmID.getText());
        
        
        
        double tax = cost * 0.10;
        double subtotal = tax + cost;
        double totalTax = subtotal * quantity;
        double total = cost * quantity;
        
        if (stock != 0){
            try {
                purchaseBT.setAA_RippleColor(new java.awt.Color(80,80,80));
                String query = "INSERT INTO cart(`product`, `cost`, `description`, `quantity`, `total`, `imageName`, `imagePath`, `imageFile`, `productID`, `type`, `tax`, `totalnotax`, `user`, `Date`, `Time`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try (Connection con = DriverManager.getConnection("jdbc:mysql://"+sv.getServerIP() +"/schale_online", sv.getUserID(), sv.getPass());
            
                     PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, FirearmItemName.getText());
                pst.setDouble(2, cost);
                pst.setString(3, FirearmDescription.getText());
                pst.setInt(4, quantity);
                pst.setDouble(5, totalTax);
                pst.setString(6, ""); // imageName
                pst.setString(7, ""); // imagePath
                pst.setString(8, ""); // imageFile
                pst.setInt(9,ProdID); 
                pst.setString(10, FirearmType.getText()); 
                pst.setDouble(11, tax); 
                pst.setDouble(12, total); 
                pst.setString(13, usernameMain.getText()); 
                pst.setString(14, formattedDate); 
                pst.setString(15, formattedTime); 

                pst.executeUpdate();

              

                for (int i = 0; i < CartTable.getColumnCount(); i++) {
                CartTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
               
                }
                
                  // Update product stock on the itemPanel with the given firearmID
                updateProductStock(firearmID, quantity);
                
                int editedProductId = Integer.parseInt(FirearmID.getText());
                for (itemPanel panel : ITEMPANELS) {
                    if (panel.productID == editedProductId) {
                        panel.updateProductStock(Integer.parseInt(FirearmStock.getText()));
                        break;
                    }
                }

                sound.playSound(clip);
                
            }
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error adding product to cart: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }  
    }else {
        pH_Button1.setAA_RippleColor(new java.awt.Color(201,15,15));    
        sound.playSound4(clip);
        pop.NoStockPopup();
        
       
        
       
        }
}

private void updateProductStock(int firearmID, int quantity) {
    // Loop through all itemPanels in FlowPanel
    Component[] components = FlowPanel.getComponents();
    for (Component component : components) {
        if (component instanceof itemPanel) {
            itemPanel panel = (itemPanel) component;
            if (panel.productID == firearmID) {
                // Update product stock
                int currentStock = panel.productStock;
                panel.productStock=currentStock - quantity;
                
                FirearmStock.setText(Integer.toString(panel.productStock));
                panel.ProductStock.setText(FirearmStock.getText());
                FirearmQuantity.setText("1");
                break;
            }
        }
    }
}

private void updateProductStock2(int firearmID, int quantity) {
    // Loop through all itemPanels in FlowPanel
    Component[] components = FlowPanel.getComponents();
    for (Component component : components) {
        if (component instanceof itemPanel) {
            itemPanel panel = (itemPanel) component;
            if (panel.productID == firearmID) {
                // Update product stock
                int currentStock = panel.productStock;
                panel.productStock=currentStock + quantity;
                
                FirearmStock.setText(Integer.toString(panel.productStock));
                panel.ProductStock.setText(FirearmStock.getText());
                FirearmQuantity.setText("1");
                break;
            }
        }
    }
}


private void ClearFirearmProductInfo(){
    FirearmItemName.setText("");
    FirearmType.setText("");
    FirearmCost.setText("");
    FirearmDescription.setText("");
    FirearmStock.setText("");
    FirearmQuantity.setText("1");
    FirearmImage.setIcon(null);
    
    cartSubtotal.setText("0");
    cartTotal.setText("0");
    cartTax.setText("0");
    cartPayment.setText("0");
    cartChange.setText("0");

}
























////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////            HISTORY TRANSACTION METHOD                //////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////// 


public void refreshEarnings() {
    String sql = "SELECT * FROM transaction_earnings ORDER BY id DESC";

    
    try {
        DefaultTableModel model = (DefaultTableModel) TransactionTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
    while (rs.next()) {
    
        
        model.addRow(new Object[] {

            rs.getString(1),
            rs.getString(14),
            rs.getString(2),
            rs.getString(11),
            rs.getString(3),
            rs.getString(12),
            rs.getString(5),
            rs.getString(6),
            rs.getString(1),
            rs.getString(10),
            rs.getString(15),
            rs.getString(16),
                
         
            

        });
    }
           
        
    
       NumberOfTransactions.setText(Integer.toString(TransactionTable.getRowCount()));
       
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}  






public void addFunds(){
    
    String sql = "SELECT `funds` FROM `admin` WHERE id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 1);
            ResultSet rs = pst.executeQuery();

            double fund = 0;
            String Stringfund = "";
          
            if (rs.next()) {
                Stringfund = (rs.getString("funds"));

            }
            
            fund = Double.parseDouble(Stringfund);
            
            df.applyPattern("###,###.##");
            add_businessFunds.setText(df.format(fund));
            edit_businessFunds.setText(df.format(fund));
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    
}




public void importFee() {

    
 try {
        // Execute query to get the sum of total
        double cost = 0.0;
        double stock = 0.0;

        try {
            if (add_cost.getText() != null && !add_cost.getText().isEmpty()) {
                cost = Double.parseDouble(add_cost.getText());
            }
            if (add_stock.getText() != null && !add_stock.getText().isEmpty()) {
                stock = Double.parseDouble(add_stock.getText());
            }
        } catch (NumberFormatException e) {
            // Handle the case where text cannot be parsed to double
            // For simplicity, just setting cost and stock to 0
            cost = 0.0;
            stock = 0.0;
        }

        double total =  cost * stock;
 

        // Format the numbers to remove .0 and add commas
        
        df.applyPattern("###,###.##");
      
        add_importFee.setText(df.format(total));
        double funds = Double.parseDouble(add_businessFunds.getText());
        
        if (total <= funds){
        add_importFee.setForeground(new java.awt.Color(52, 196, 57));
        } 
        else if (total > funds) {
        add_importFee.setForeground(new java.awt.Color(201,15,15));
        }

        // Set the formatted values to your UI components
        
        

     
    } catch (Exception ex) {
        
    }


}


public void refreshImportTable() {
    String sql = "SELECT * FROM transaction_expenses ORDER BY id DESC";

    
    try {
        DefaultTableModel model = (DefaultTableModel) ImportTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
    while (rs.next()) {
    
        
        model.addRow(new Object[] {

            rs.getString(1),
            rs.getString(9),
            rs.getString(7),
            rs.getString(2),
            rs.getString(3),
            rs.getString(5),
            rs.getString(8),
            rs.getString(6),
            rs.getString(10),
            rs.getString(11),
            
     });
    }
    
    NumberOfImports.setText(Integer.toString(ImportTable.getRowCount()));
    
    } catch (Exception ex) {
       JOptionPane.showMessageDialog(null, ex);
    }
}





public void refreshCharts(){
    String sql = "SELECT * FROM transaction_earnings ORDER BY id DESC ";

    try {
        DefaultTableModel model = (DefaultTableModel) EarningsTABLE.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
    
    while (rs.next()) {
    
        
        model.addRow(new Object[] {

            rs.getString(2),
            rs.getString(6)
        });
    }
  
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    
    String sql2 = "SELECT * FROM transaction_expenses ORDER BY id DESC";

    try {
        DefaultTableModel model = (DefaultTableModel) ImportTABLE.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql2);
        ResultSet rs = pst.executeQuery();
    
    while (rs.next()) {
    
        
        model.addRow(new Object[] {

            rs.getString(2),
            rs.getString(6)
        });
    }
  
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    
    
    
    String query = "SELECT SUM(total) AS total FROM transaction_earnings";
        
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                double highestID = rs.getDouble("total");
                
               
                df.applyPattern("###,###.##");
                String total_earnings = df.format(highestID);
                Total_Earnings.setText(total_earnings);
                  
            }
     
       
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle or log the exception appropriately
        }
        
        String query2 = "SELECT SUM(expense) AS expense FROM transaction_expenses";
        
        try (PreparedStatement stmt = con.prepareStatement(query2);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                double highestID = rs.getDouble("expense");
               
         
                df.applyPattern("###,###.##");
                String total_expenses = df.format(highestID);
                Total_Expenses.setText(total_expenses);
                  
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle or log the exception appropriately
        }


         String sql3 = "SELECT `funds` FROM `admin` WHERE id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql3);
            pst.setInt(1, 1);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                double highestID = rs.getDouble("funds");
          
                df.applyPattern("###,###.##");
                String amount = df.format(highestID);
                Total_Amount_Owned.setText(amount);
                  

            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        

}

















////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////            SHOP CART METHOD                //////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////// 
public void refreshCart() {
    String sql = "SELECT * FROM cart";

    
    try {
        DefaultTableModel model = (DefaultTableModel) CartTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
    while (rs.next()) {
    
        
        model.addRow(new Object[] {

            rs.getString(2),
            rs.getString(11),
            rs.getString(3),
            rs.getString(12),
            rs.getString(5),
            rs.getString(6),
            rs.getString(1),
            rs.getString(10),
                
         
            

        });
    }
       
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}  

private void ClearCart() {
    String sql = "DELETE FROM `cart`";
    
    try {
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate();
        
    } catch (SQLException ex) {
       
    }
}

private void ClearFirearmProductInfo2(){
    cart_Name.setText("");
    cart_Type.setText("");
    cart_Cost.setText("");
    cart_Description.setText("");
    
    cart_Image.setIcon(null);
   

}
    
private void CartDeleteButton(int firearmID) {
    int selectedRow = CartTable.getSelectedRow();

    if (selectedRow != -1) {
        String studentID = CartTable.getValueAt(selectedRow, 6).toString();
        String ID = CartTable.getValueAt(selectedRow, 7).toString();
        String QUANTITY = CartTable.getValueAt(selectedRow, 4).toString();

        String sql = "DELETE FROM `cart` WHERE id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            pst.executeUpdate();
            sound.playSound4(clip);
            refreshCart();
            ClearFirearmProductInfo2();
           
            int quantity = Integer.parseInt(QUANTITY);
            int id = Integer.parseInt(ID);
            int id2 = id - 1;
            
          
            
            updateProductStock2(firearmID, quantity); 
            
//            // Subtract quantity from product stock
//            ITEMPANELS.get(id2).updateProductStock(ITEMPANELS.get(id2).productStock + quantity);
//
//            deletedstock.setText(String.valueOf(ITEMPANELS.get(id2).productStock));          
//            FirearmStock.setText(deletedstock.getText());
//           
//            
//            int editedProductId = id2;
//                for (itemPanel panel : ITEMPANELS) {
//                    if (panel.productID == editedProductId) {
//                        panel.updateProductStock(Integer.parseInt(FirearmStock.getText()));
//                        break;
//                    }
//                }
//                
//           ITEMPANELS.get(id2).ProductStock.setText(FirearmStock.getText());     
//      
       
           
            // Refresh UI
            refreshItemPanels();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    sound.playSound4(clip);
}
// Method to refresh the UI of all itemPanel instances
private void refreshItemPanels() {
    for (itemPanel panel : ITEMPANELS) {
        panel.refreshUI();
    }
}

public void SelectCartItem() {
    // Check if any row is selected
    int selectedRow = CartTable.getSelectedRow();
   
    if (selectedRow != -1) {
        // Get the ID from the selected row
        String productID = CartTable.getValueAt(selectedRow, 6).toString();

        String ID = CartTable.getValueAt(selectedRow, 7).toString();
        
        String sql = "SELECT `product`, `cost`, `description`, `type` FROM `cart` WHERE id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, productID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cart_Name.setText(rs.getString("product"));
                cart_Cost.setText(rs.getString("cost"));
                cart_Description.setText(rs.getString("description"));
                cart_Type.setText(rs.getString("type"));
                
                int id = Integer.parseInt(ID);
                // Adjust index to match the array index (subtract 1 if needed)
                int arrayIndex = id - 1;
                
                // Access the corresponding itemPanel from the list
                if (arrayIndex >= 0 && arrayIndex < ITEMPANELS.size()) {
                    itemPanel panel = ITEMPANELS.get(arrayIndex);
                    
                    // Get the image from the itemPanel
                    ImageIcon productImage = panel.productImage;
                    
                    // Scale the image to match the label width and height
                    Image originalImage = productImage.getImage();
                    Image scaledImage = originalImage.getScaledInstance(247, 203, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    cart_Image.setIcon(scaledIcon);
                    
                    if (Double.parseDouble(walletTxt.getText().replace(",", "")) >= Double.parseDouble(cart_Cost.getText()))
                    {
                        cart_Cost.setForeground(new java.awt.Color(52, 196, 57));
                    } 
                    else {
                    cart_Cost.setForeground(new java.awt.Color(201,15,15));
                    }
    
                } else {
                    // Handle the case where the array index is out of bounds
                    System.out.println("Invalid array index");
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    } 
}


       
public void purchaseBTclicked(){
    purchaseBT.setAA_RippleColor(new java.awt.Color(52, 196, 57));
    Color PAYMENTCOLOR = cartPayment.getForeground();
        System.out.println(PAYMENTCOLOR);
        if (PAYMENTCOLOR.equals(new Color (52, 196, 57))) {
            purchaseBT.setAA_RippleColor(new java.awt.Color(52, 196, 57));
            sound.playSound5(clip);
                Purchase();
                ClearCart();
                initProds();
                CartMath();
                ClearCart();
        } else if (PAYMENTCOLOR.equals(new Color (201,15,15))) {
           
           purchaseBT.setAA_RippleColor(new java.awt.Color(201,15,15));
           sound.playSound4(clip);
        }

}


public void SaveBTclicked(){
    
    Color PAYMENTCOLOR = edit_fee.getForeground();
    
    
    
        if (PAYMENTCOLOR.equals(new Color (52, 196, 57))) {
                UpdateBT.setAA_RippleColor(new java.awt.Color(52, 196, 57));
                sound.playSound5(clip);
                 EditProduct();
                 initProds();
               
            } else if (PAYMENTCOLOR.equals(new Color (201,15,15))) {

               UpdateBT.setAA_RippleColor(new java.awt.Color(201,15,15));
               sound.playSound4(clip);
            }else{
            
            }
    
        

}


public void CartMath() {
 cartPayment.setForeground(new Color (255,255,255));
 cartChange.setForeground(new Color (255,255,255));
 try {
        // Execute query to get the sum of total
        String sqlTotal = "SELECT SUM(totalnotax) FROM cart";
        PreparedStatement pstTotal = con.prepareStatement(sqlTotal);
        ResultSet rsTotal = pstTotal.executeQuery();
        double totalCost = 0;
        if (rsTotal.next()) {
            totalCost = rsTotal.getDouble(1);
        }
        
        double taxRate = 0.10;
        
        double tax = totalCost * taxRate;
        double total = totalCost + tax;
        double cash = Double.parseDouble(walletTxt.getText().replace(",", ""));
        double change = cash - total;
        
        

        
        df.applyPattern("###,###.##");
        
        String formattedSubtotal = df.format(totalCost);
        String formattedTax = df.format(tax);
        String formattedTotal = df.format(total);
        String formattedCash = df.format(cash);
        String formattedChange = df.format(change);
        
        Double walletwallet = Double.parseDouble(walletTxt.getText().replace(",", ""));
        
        walletTxtCart.setText(df.format(walletwallet));

        // Set the formatted values to your UI components
        cartSubtotal.setText(formattedSubtotal);
        cartTax.setText(formattedTax);
        cartTotal.setText(formattedTotal);
        
        String subtotalText = cartSubtotal.getText().replace(",", "");
        String taxText = cartTax.getText().replace(",", "");
        String totalText = cartTotal.getText().replace(",", "");
        
        if (Double.parseDouble(subtotalText) == 0.0 && Double.parseDouble(taxText) == 0.0 && Double.parseDouble(totalText) == 0.0) {
            cartPayment.setText("0");
            cartChange.setText("0");
        }else if(cash < total){
            cartPayment.setText(formattedCash);
            cartChange.setText(formattedChange);
            
            cartPayment.setForeground(new Color (201,15,15));
            cartChange.setForeground(new Color (201,15,15));
        
        } else {
            cartPayment.setText(formattedCash);
            cartChange.setText(formattedChange);
            cartPayment.setForeground(new Color (52, 196, 57));
            cartChange.setForeground(new Color (52, 196, 57));
        }
    
        

        // Now 'total' contains the multiplication of cost and quantity
        System.out.println("Total: " + total);
    } catch (SQLException ex) {
        // Handle SQL exceptions
        ex.printStackTrace();
    }


}

public void Purchase (){
    
    
    
 try {
        // Execute query to get the sum of total
        String sqlTotal = "SELECT SUM(total), SUM(tax),SUM(totalnotax) FROM cart";
        PreparedStatement pstTotal = con.prepareStatement(sqlTotal);
        ResultSet rsTotal = pstTotal.executeQuery();
        double totalCost = 0;
        double tax = 0;
        double subtotal = 0;
        if (rsTotal.next()) {
            totalCost = rsTotal.getDouble(1);
            tax = rsTotal.getDouble(2);
            subtotal = rsTotal.getDouble(3);
        }
        
        
        double total = totalCost;
        double cash = Double.parseDouble(walletTxt.getText().replace(",", ""));
        double change = cash - total;
        
        System.out.println(totalCost +"   = totalcost");
        System.out.println(tax +"    =tax");
        System.out.println(cash+"     =cash");
        System.out.println(change+"    =change");
        System.out.println(total+"    =total");
        
        
        UIcolors receiptColor = new UIcolors();
        receiptColor.UIcolor2();
        receipt receipt = new receipt(this);
        receipt.setVisible(true);
        
        // Define fields and their values
    String[] fields = {"Subtotal", "Tax", "Total", "Payment", "Change"};
double[] values = {subtotal, tax, totalCost, cash, change};

// Create a DecimalFormat object to format numbers with commas
DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

for (int i = 0; i < fields.length; i++) {
    // Format the value with commas and two decimal places
    String formattedValue = decimalFormat.format(values[i]);
    formattedValue = String.format("$%s", formattedValue);

    int numDots = Math.max(0, 55 - formattedValue.length());
    String dots = new String(new char[numDots]).replace('\0', '-');

    // Set text for each label separately based on the field
    switch (fields[i]) {
        case "Subtotal":
            receipt.r_subtotal.setText(dots + formattedValue);
            break;
        case "Tax":
            receipt.r_tax.setText(dots + formattedValue);
            break;
        case "Total":
            receipt.r_total.setText(dots + formattedValue);
            break;
        case "Payment":
            receipt.r_payment.setText(dots + formattedValue);
            break;
        case "Change":
            receipt.r_change.setText(dots + formattedValue);
            break;
        default:
            // Handle unexpected field
            break;
    }
}
        

        // Get current date and time
        Date currentDate = new Date();
        // Add date and time to the receipt labels
        receipt.r_date.setText(currentDate.toString());
        
        Random random = new Random();
        StringBuilder receiptNumber = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            receiptNumber.append(random.nextInt(10)); // Generates random digit from 0 to 9
        }
        receipt.r_number.setText(receiptNumber.toString());
        
        
  
        df.applyPattern("###,###.##");
        
    
        walletTxt.setText(df.format(change));
        
        
        String transac = "INSERT INTO transaction_earnings (product, cost, description, quantity, total, imageName, imagePath, imageFile, productID, type, tax, totalnotax, user, Date, Time) " +
                 "SELECT product, cost, description, quantity, total, imageName, imagePath, imageFile, productID, type, tax, totalnotax, user, Date, Time FROM cart";
        pst = con.prepareStatement(transac);
        pst.executeUpdate();
        
       


        String sql = "UPDATE user SET money=? WHERE username=? AND password=?";

        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sql);

         preparedStatement.setDouble(1, change);
         preparedStatement.setString(2, usernameMain.getText());
         preparedStatement.setString(3, passwordMain.getText());
        

        // Execute the update
        preparedStatement.executeUpdate();
        
        fundsIncreased(total);
        
        
        // Close resources
        refreshTable();

        stockPurchase();
        
        cartSubtotal.setText("0");
        cartTax.setText("0");
        cartTotal.setText("0");
        cartPayment.setText("0");
        cartChange.setText("0");
        
        
        

        // Now 'total' contains the multiplication of cost and quantity
        System.out.println("Total: " + total);
    } catch (SQLException ex) {
        // Handle SQL exceptions
        ex.printStackTrace();
    }



}


 public void fundsIncreased(double total){
      
     double totals = total;
     double cash = 0;
    String fund = "SELECT `funds` FROM `admin` WHERE id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(fund);
            pst.setInt(1, 1);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cash = rs.getDouble("funds");

            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

     double funds = totals + cash;
     
     
     String sql = "UPDATE admin SET funds=? WHERE id=1";
    try {
       
        pst= con.prepareStatement(sql);
        pst.setDouble(1, funds);
        pst.executeUpdate();
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }



}




public void stockPurchase(){
        int increment = 0;
        String query1 = "SELECT MAX(id) AS id FROM product";
        
        try (PreparedStatement stmt = con.prepareStatement(query1);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                int highestID = rs.getInt("id");
                 increment = highestID;       
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle or log the exception appropriately
        }
        
        try {
            
            
            
            for (int i = 0; i < increment; i++){
                int ha = i+1;
                System.out.print(i+" - "+ha+" -  i      ");
               int stock = ITEMPANELS.get(i).productStock;
                System.out.println(stock+" -  STOCK");
                // SQL Update Query
                String sql = "UPDATE product SET stock=? WHERE id=?";

                // Prepare the statement
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                
                 preparedStatement.setInt(1, stock);
                 preparedStatement.setInt(2, i+1);

                // Execute the update
                preparedStatement.executeUpdate();
                // Close resources
                refreshTable();
               sound.playSound(clip);
               
            }
           
            ClearFirearmProductInfo2();
            ClearCart();
            refreshCart();
            System.out.println("");
            System.out.println("");
            System.out.println("");
            
        
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        
        
     
   
   }



       
       
       
       
       
       
      
    
    
   
   
   
   
   
   
   
   
   
    
    
    
   



    
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////             EDIT PRODUCT METHODS              //////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void refreshTable() {
    String sql = "SELECT * FROM product";

    
    try {
        DefaultTableModel model = (DefaultTableModel) EditTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
    while (rs.next()) {
    
        
        model.addRow(new Object[] {

            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(6),
            

        });
    }
        // update the student count shown in the upper right corner
       
   
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}
    
    public void EditProduct() {
        df.applyPattern("###,###.##");
        
        double E_fee= Double.parseDouble(edit_fee.getText().replace(",", ""));
        
        double fee = Double.parseDouble(edit_fee.getText().replace(",", ""));
        double funds = Double.parseDouble(edit_businessFunds.getText().replace(",", ""));
        double change=0;
           if (fee <= funds){
           change = funds - fee;
           
           if (Double.parseDouble(edit_cost.getText()) < 1000000000 ){
                try {

                    String deduct = "UPDATE admin SET funds =? WHERE id=1";
                     pst = con.prepareStatement(deduct);
                     pst.setDouble(1, change);
                     pst.executeUpdate();


                 // SQL Update Query
                 String sql = "UPDATE product SET id=?, product=?, cost=?, stock=?, description=?, type=?, power=?, firerate=?, reloadspeed=?, ammo=? WHERE id=?";

                 double original_stock = Double.parseDouble(edit_stock.getText());
                 double add_stock = Double.parseDouble(new_stock.getText());

                 double stocks = original_stock + add_stock;

                 // Prepare the statement
                 PreparedStatement preparedStatement = con.prepareStatement(sql);

                 // Set parameters
                 preparedStatement.setString(1, edit_id.getText());
                 preparedStatement.setString(2, edit_name.getText());
                 preparedStatement.setString(3, edit_cost.getText());
                 preparedStatement.setDouble(4, stocks);
                 preparedStatement.setString(5, edit_description.getText());
                 preparedStatement.setString(6, edit_type.getSelectedItem().toString());
                 preparedStatement.setString(7, edit_power.getText());
                 preparedStatement.setString(8, edit_firerate.getText());
                 preparedStatement.setString(9, edit_reloadspeed.getText());
                 preparedStatement.setString(10, edit_ammo.getText());
                 preparedStatement.setString(11, edit_id_2.getText());


                 // Execute the update
                 preparedStatement.executeUpdate();

                 // Update the corresponding itemPanel in the ITEMPANELS array
                 int editedProductId = Integer.parseInt(edit_id_2.getText());
                 for (itemPanel panel : ITEMPANELS) {
                     if (panel.productID == editedProductId) {
                         panel.updateProductStock(Integer.parseInt(edit_stock.getText()));
                         break;
                     }
                 }

                 String productstoimport = "SELECT `id`, `product`, `stock`, `description`, `type`, `original_cost` FROM `product` WHERE id=?";


                 int Prod_ID=0;
                 String Product_item = "" ;
                 int stock = 0;
                 String desc = "";
                 String type = "";
                 double og_cost =0;


                 try {
                     PreparedStatement pst = con.prepareStatement(productstoimport);
                     pst.setString(1, edit_id.getText());
                     ResultSet rs = pst.executeQuery();

                     if (rs.next()) {
                         // Populate the fields with data from the ResultSet
                         Prod_ID = rs.getInt("id");
                         Product_item=rs.getString("product");
                         stock=rs.getInt("stock");
                         desc = rs.getString("description");
                         type=rs.getString("type");
                         og_cost =rs.getDouble("original_cost");
                     }
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex);
                 }

                 if(E_fee != 0){
                 String imports = "INSERT INTO `transaction_expenses` (`product`, `cost`, `description`, `stock`, `expense`, `productID`, `type`, `user`, `Date`, `Time`) VALUES(?,?,?,?,?,?,?,?,?,?)";
                 pst = con.prepareStatement(imports);

                 pst.setString(1, Product_item);
                 pst.setDouble(2, og_cost);
                 pst.setString(3, desc);
                 pst.setInt(4, Integer.parseInt(new_stock.getText()));
                 pst.setDouble(5,Double.parseDouble(edit_fee.getText().replace(",", "")));
                 pst.setDouble(6, Prod_ID);
                 pst.setString(7, type);
                 pst.setString(8, usernameMain.getText());
                 pst.setString(9, formattedDate);
                 pst.setString(10, formattedTime);

                 pst.executeUpdate();

                 }
                 
      
                add_businessFunds.setText(df.format(change));
                edit_businessFunds.setText(df.format(change));
  
                 
                 // Close resources
                 new_stock.setText("0");
                 edit_fee.setText("0");

                 String newstock = "SELECT `stock` FROM `product` WHERE id=?";
                 try {
                     PreparedStatement pst = con.prepareStatement(newstock);
                     pst.setString(1, edit_id.getText());
                     ResultSet rs = pst.executeQuery();

                     if (rs.next()) {
                         // Populate the fields with data from the ResultSet
                         edit_stock.setText(rs.getString("stock"));

                     }
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex);
                 }


                 refreshTable();
                 sound.playSound(clip);
                 
                 saveImageToDatabaseEdit(f2, path2);
                 
                 
                  if (edit_remove_image ==1){
                emptyBlobFile(edit_id.getText());
                }
                  edit_remove_image=0;


             } catch (Exception ex) {
                  sound.playSound4(clip);
                 JOptionPane.showMessageDialog(null, ex);
             }

         }else {
                 sound.playSound4(clip);
                JOptionPane.showMessageDialog(null, "1,000,000,000 is the maximum limit");
                }


           
           
           
           
          
           }

}
   
   

    public void SelectEditProduct() {
    // Check if any row is selected
    new_stock.setText("0");
    int selectedRow = EditTable.getSelectedRow();
    
    if (selectedRow != -1) {
        // Get the ID from the selected row
        String productID = EditTable.getValueAt(selectedRow, 0).toString();

        String sql = "SELECT `id`, `product`, `cost`, `stock`, `description`, `type`, `imageName`, `imagePath`,`original_cost`, `power`, `firerate`, `reloadspeed`, `ammo` FROM `product` WHERE id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, productID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Populate the fields with data from the ResultSet
                edit_id.setText(rs.getString("id"));
                edit_id_2.setText(rs.getString("id"));
                edit_name.setText(rs.getString("product"));
                edit_cost.setText(rs.getString("cost"));
                edit_stock.setText(rs.getString("stock"));
                edit_description.setText(rs.getString("description"));
                OriginalPrice.setText(rs.getString("original_cost"));
                edit_power.setText(rs.getString("power"));
                edit_firerate.setText(rs.getString("firerate"));
                edit_reloadspeed.setText(rs.getString("reloadspeed"));
                edit_ammo.setText(rs.getString("ammo"));
               
                String type = rs.getString("type");
                if (type != null) {
                    edit_type.setSelectedItem(type);
                }
                
                edit_imageName.setText(rs.getString("imageName"));
                edit_imagePath.setText(rs.getString("imagePath"));
                edit_fee.setText("0");
                
                
                
                double funds=Double.parseDouble(edit_businessFunds.getText().replace(",", ""));
                double fee=Double.parseDouble(edit_fee.getText().replace(",", ""));
                
                if (fee <= funds){
                    edit_fee.setForeground(new java.awt.Color(52, 196, 57));
                } else if (fee > funds){
                    edit_fee.setForeground(new java.awt.Color(201,15,15));
                }
                
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    } else {
        // If no row is selected, notify the user or handle it accordingly
        JOptionPane.showMessageDialog(null, "Please select a row to edit.");
    }
}
    
public void edit_sort(){
    String selectedValue = (String) edit_sorter.getSelectedItem();

    // Construct appropriate SQL query based on selected value
   
    String sql = null;
    if (selectedValue.equals("All")) {
        sql = "SELECT `id`, `product`, `cost` , `stock`, `type` FROM product ORDER BY id ASC, product DESC";
    } else {
        sql = "SELECT `id`, `product`, `cost` , `stock`, `type` FROM product WHERE type= '" + selectedValue + "' ORDER BY id ASC, product DESC";
    }

    try {
        // Prepare the statement
        pst = con.prepareStatement(sql);

        // Execute the query
        ResultSet resultSet = pst.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) EditTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        pst.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
}    
    
    
 private void DeleteButton() {
    int selectedRow = EditTable.getSelectedRow();

    if (selectedRow != -1) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            String studentID = EditTable.getValueAt(selectedRow, 0).toString(); //getrow

            String sql = "DELETE FROM `product` WHERE id = ?";
            
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, studentID);
                
                 pst.executeUpdate();
                 sound.playSound(clip);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            
         refreshTable();
        ProductMethods.resetEditProduct(edit_id, edit_name, edit_cost, edit_stock, edit_description, edit_type, edit_imageName, edit_imagePath, productImageEdit,edit_power, edit_firerate, edit_reloadspeed, edit_ammo);
        initProds();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a product to delete");
        sound.playSound4(clip);
    }
}
 
 
 
 
 public void editAddNewStock(){
     
        df.applyPattern("###,###.##");
        double price = Double.parseDouble(OriginalPrice.getText());
        int newstock = Integer.parseInt(new_stock.getText());
        newstock+=1;
        new_stock.setText(Integer.toString(newstock)); 
        
        
        double totalfee = price*newstock;
        edit_fee.setText(df.format(totalfee)); 
        
        
        double funds=Double.parseDouble(edit_businessFunds.getText().replace(",", ""));
        double fee=Double.parseDouble(edit_fee.getText().replace(",", ""));

        if (fee <= funds){
            edit_fee.setForeground(new java.awt.Color(52, 196, 57));
        } else if (fee > funds){
            edit_fee.setForeground(new java.awt.Color(201,15,15));
        }


 }
 
 
 
 public void editReduceNewStock(){
 
     df.applyPattern("###,###.##");
        double price = Double.parseDouble(OriginalPrice.getText());
        int newstock = Integer.parseInt(new_stock.getText());
        
        if (newstock > 0){
        newstock-=1;
        new_stock.setText(Integer.toString(newstock)); 
        
        double totalfee = price*newstock;
        edit_fee.setText(df.format(totalfee)); 
        
        
        double funds=Double.parseDouble(edit_businessFunds.getText().replace(",", ""));
        double fee=Double.parseDouble(edit_fee.getText().replace(",", ""));

        if (fee <= funds){
            edit_fee.setForeground(new java.awt.Color(52, 196, 57));
        } else if (fee > funds){
            edit_fee.setForeground(new java.awt.Color(201,15,15));
        }
        
        }else{
        sound.playSound4(clip);
        
        }
  
 }


    

   
   
   
   
   

   

    
    
    
   
   
   
   
   
   
   
   
   
   
    
    
    
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////             ADD PRODUCT METHODS              //////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
 public void AddProduct() {
    
     if (!validateFields()) {
        return; // Stop execution if fields are not validated
    }
     
     serverCredentials sv = new serverCredentials();
        sv.setServerIP(local2.getText());
        sv.setUserID(local.getText());
        sv.setPass(local3.getText());
        
        importFee();
        
        double fee = Double.parseDouble(add_importFee.getText().replace(",", ""));
        double funds = Double.parseDouble(add_businessFunds.getText().replace(",", ""));
      
        if (fee <= funds){
            try {
                
            double change = funds - fee;
                
            String query = "INSERT INTO product(`id`, `product`, `cost`, `stock`, `description`, `type`, `imageName`, `imagePath`, `imageFile`, `original_cost`, `power`, `firerate`, `reloadspeed`, `ammo`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            con = DriverManager.getConnection("jdbc:mysql://"+sv.getServerIP() +"/schale_online", sv.getUserID(), sv.getPass());
            pst = con.prepareStatement(query);
            pst.setString(1, add_id.getText());
            pst.setString(2, add_name.getText());
            pst.setInt(3, Integer.parseInt(add_cost.getText()));
            pst.setInt(4, Integer.parseInt(add_stock.getText()));
            pst.setString(5, add_description.getText());
            pst.setString(6, add_type.getSelectedItem().toString());
            pst.setString(7, "");
            pst.setString(8, "");
            pst.setString(9, "");
            pst.setInt(10, Integer.parseInt(add_cost.getText()));
            
            pst.setInt(11, Integer.parseInt(add_power.getText()));
            pst.setInt(12, Integer.parseInt(add_firerate.getText()));
            pst.setInt(13, Integer.parseInt(add_reloadspeed.getText()));
            pst.setInt(14, Integer.parseInt(add_ammo.getText()));

            pst.executeUpdate(); 
            sound.playSound(clip);
            
            
            

            df.applyPattern("###,###.##");
 
            add_businessFunds.setText(df.format(change));
            edit_businessFunds.setText(df.format(change));
            
            
            String deduct = "UPDATE admin SET funds =? WHERE id=1";
            pst = con.prepareStatement(deduct);
            pst.setDouble(1, change);
            pst.executeUpdate();

            String expense = "INSERT INTO `transaction_expenses`(`product`, `cost`, `description`, `stock`, `expense`, `productID`, `type`, `user`, `Date`, `Time`) VALUES(?,?,?,?,?,?,?,?,?,?)";
           
            pst = con.prepareStatement(expense);
            pst.setString(1, add_name.getText());
            pst.setInt(2, Integer.parseInt(add_cost.getText()));
            pst.setString(3, add_description.getText());
            pst.setInt(4, Integer.parseInt(add_stock.getText()));
            pst.setDouble(5, fee);
            
            pst.setInt(6, Integer.parseInt(add_id.getText()));
            pst.setString(7, add_type.getSelectedItem().toString());
            pst.setString(8, usernameMain.getText());
            pst.setString(9, formattedDate);
            pst.setString(10, formattedTime);
            pst.executeUpdate(); 
            
             if (add_remove_image ==1){
                emptyBlobFile(add_id.getText());
                
                }else{
             saveImageToDatabase(f1, path1);
             }
                add_remove_image=0;
            
        
            ProductMethods.resetAddProduct(add_id, add_name, add_cost, add_stock, add_description, add_type, add_imageName, add_imagePath, productImage, add_importFee, add_power, add_firerate, add_reloadspeed, add_ammo);
           
            
           

            ProductMethods.clicked2(0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
            ProductMethods.clicked2(0, fr1, fr2, fr3, fr4, fr5, fr6, fr7, fr8, fr9, fr10);
            ProductMethods.clicked2(0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
            ProductMethods.clicked2(0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
            
            autoIncrement();
            initProds();
            JOptionPane.showMessageDialog(null,"SAVED!");
            
            
      } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex + " save bt");
            }
        
        
        } else {
        JOptionPane.showMessageDialog(null,"NOT ENOUGH FUNDS");
        
        }
 
}
 
 private boolean validateFields() {
    if (add_id.getText().isEmpty() || add_name.getText().isEmpty() || add_cost.getText().isEmpty() ||
            add_stock.getText().isEmpty() || add_description.getText().isEmpty() || add_type.getSelectedItem() == null ||
            add_importFee.getText().isEmpty() || add_businessFunds.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}




   

        
    
    
   
   
   
   
   
   
   
   
   
   
    
    
   
   
   
   
   
   
   
   
   
   
    
    
    
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////             IMAGE METHODS                    //////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
 private void AddImage(){
    
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg","gif");
    fileChooser.setFileFilter(imageFilter);
    int load = fileChooser.showOpenDialog(null);
    
    if (load == JFileChooser.APPROVE_OPTION) {
        f1 = fileChooser.getSelectedFile();
        path1 = f1.getAbsolutePath();
        String imageName = f1.getName();
        add_imageName.setText(imageName);
        add_imageName.setColumns(6);
        
        add_imagePath.setText(path1);
        ImageIcon ii = new ImageIcon(path1);
        add_imagePath.setColumns(1);
        
        Image img = ii.getImage().getScaledInstance(478, 300, Image.SCALE_SMOOTH);
        productImage.setIcon(new ImageIcon(img));
        
       
    }
    } 
 
 private void EditImage(){
    
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg","gif");
    fileChooser.setFileFilter(imageFilter);
    int load = fileChooser.showOpenDialog(null);
    
    if (load == JFileChooser.APPROVE_OPTION) {
        f2 = fileChooser.getSelectedFile();
        path2 = f2.getAbsolutePath();
        String imageName = f2.getName();
        edit_imageName.setText(imageName);
        edit_imageName.setColumns(6);
        
        edit_imagePath.setText(path2);
        ImageIcon ii = new ImageIcon(path2);
        edit_imagePath.setColumns(1);
        
        Image img = ii.getImage().getScaledInstance(250, 173, Image.SCALE_SMOOTH);
        productImageEdit.setIcon(new ImageIcon(img));
        
        
        
    }
    } 
 
 
 private void saveImageToDatabase(File file, String path) {
     String ID =add_id.getText();
    if (file != null && path != null && !path.isEmpty()) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String query = "UPDATE product SET imageName = ?, imagePath = ?, imageFile = ? WHERE id=? ";
            pst = con.prepareStatement(query);
            pst.setString(1, file.getName());
            pst.setString(2, path);
            pst.setBinaryStream(3, fis, (int) file.length());
            pst.setString(4, ID);
            pst.executeUpdate();
            
         
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Image file not found: " + ex.getMessage());
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error saving image to database: " + ex.getMessage());
        }
    }
} 
 
 
 private void saveImageToDatabaseEdit(File file, String path) {
     String ID =edit_id.getText();
    if (file != null && path != null && !path.isEmpty()) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String query = "UPDATE product SET imageName = ?, imagePath = ?, imageFile = ? WHERE id=? ";
            pst = con.prepareStatement(query);
            pst.setString(1, file.getName());
            pst.setString(2, path);
            pst.setBinaryStream(3, fis, (int) file.length());
            pst.setString(4, ID);
            pst.executeUpdate();
            
          
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Image file not found: " + ex.getMessage());
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error saving image to database: " + ex.getMessage());
        }
    }
} 
 
 private void emptyBlobFile(String ID) {
    try {
        String query = "UPDATE product SET imageName = '', imagePath = '', imageFile = '' WHERE id = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, ID);
        pst.executeUpdate();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}
 
 
 
 
       public void LoadImageID(){
   
  try {
        String ID = edit_id.getText();
        
        pst = con.prepareStatement("SELECT imageFile, imagePath FROM product WHERE id=?");
        pst.setString(1, ID);
        
        // Execute the query and assign the result set to rs
        rs = pst.executeQuery();

        if (rs.next()){
            
        LoadImage();
        
     
        
        } else {
            JOptionPane.showMessageDialog(this, "no image found");
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  
   }
   
   public void LoadImage(){
   
    try {
        
        byte[] imagedata = rs.getBytes("imageFile");
        format1 = new ImageIcon(imagedata);
        Image mm = format1.getImage();
        Image img2 = mm.getScaledInstance(250,173,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        productImageEdit.setIcon(image);
      
    } catch (SQLException ex) {
        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
   
  public void LoadImageID2(){
   
  try {
        String ID = FirearmID.getText();
        
        pst = con.prepareStatement("SELECT imageFile, imagePath FROM product WHERE id=?");
        pst.setString(1, ID);
        
        // Execute the query and assign the result set to rs
        rs = pst.executeQuery();

        if (rs.next()){
             
        LoadImage2();
       
        } else {
            JOptionPane.showMessageDialog(this, "no image found");
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  
   }
   
   public void LoadImage2(){
   
    try {
        
        byte[] imagedata = rs.getBytes("imageFile");
        format3 = new ImageIcon(imagedata);
        Image mm = format3.getImage();
        Image img2 = mm.getScaledInstance(249,203,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        FirearmImage.setIcon(image);
      
    } catch (SQLException ex) {
        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
   public void loadAndAddImage(int productId, itemPanel panel) {
    try {
        // Retrieve image data from database
        pst = con.prepareStatement("SELECT imageFile FROM product WHERE id=?");
        pst.setInt(1, productId);
        rs = pst.executeQuery();

        if (rs.next()) {
            byte[] imageData = rs.getBytes("imageFile");
            ImageIcon format1 = new ImageIcon(imageData);
            Image mm = format1.getImage();
            Image img2 = mm.getScaledInstance(184, 132, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(img2);
            panel.setProductImage(image); // Set image in itemPanel
        } else {
            // Handle case where image is not found
            // You may want to display a placeholder image or handle it differently
            System.out.println("No image found for product with ID: " + productId);
        }
    } catch (SQLException ex) {
        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            // Close PreparedStatement and ResultSet
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   
   
   
   
   
   
   
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////            ADMIN LABELS METHOD                //////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////// 
    public void AdminLabelClick(){
    String sql = "SELECT * FROM `user` WHERE username=? AND password=? AND admin =?";
         try {
            pst = con.prepareStatement(sql);
           
            pst.setString(1, usernameMain.getText());
            pst.setString(2, passwordMain.getText());
            pst.setString(3, "ADMIN");
            rs = pst.executeQuery();

            if (rs.next()) {
            refreshTable();
            AdminPanel.setVisible(true);
            HomePanel.setVisible(false);

            refreshAdmin();
            
            if (userClicked) {
                sound.stopMusic1(); // Stop the music only if the user clicked
                sound.playMusicLoop5();
                
            }
            
            volumepress = false;

             sound.playSound3(clip);

            }else{
            sound.playSound4(clip);
            }
               
            
        } catch (SQLException ex) {
            sound.playSound4(clip);
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    
    }
   
    
    
    public void refreshAdmin() {
    String sql = "SELECT * FROM user";

    
    try {
        DefaultTableModel model = (DefaultTableModel) adminTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
    while (rs.next()) {
    
        
        model.addRow(new Object[] {

            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
          
            

        });
    }
        // update the student count shown in the upper right corner
       
   
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}
    
    
    
    
    
     public void SelectAdmin() {
    // Check if any row is selected
   
    int selectedRow = adminTable.getSelectedRow();
    
    if (selectedRow != -1) {
        // Get the ID from the selected row
        String productID = adminTable.getValueAt(selectedRow, 0).toString();

        String sql = "SELECT `username`, `password`, `money`, `admin` FROM `user` WHERE username=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, productID);
            rs = pst.executeQuery();

            if (rs.next()) {
                // Populate the fields with data from the ResultSet
                admin_username.setText(rs.getString("username"));
                admin_password.setText(rs.getString("password"));
                admin_cash.setText(Double.toString(rs.getDouble("money")));
                admin_username2.setText(rs.getString("username"));
                String type = rs.getString("admin");
                if (type != null) {
                    admin_status.setSelectedItem(type);
                }
                
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    } else {
        // If no row is selected, notify the user or handle it accordingly
        JOptionPane.showMessageDialog(null, "Please select a row to edit.");
    }
}
     
     
public void adminEdit() {
    if (validateInputs()) {
        try {
            String sql = "UPDATE `user` SET username=?,password=?,money=?,admin=? WHERE username=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, admin_username.getText());
            pst.setString(2, admin_password.getText());
            double money = Double.parseDouble(admin_cash.getText());
            pst.setDouble(3, money);
            pst.setString(4, admin_status.getSelectedItem().toString());
            pst.setString(5, admin_username2.getText());

            
            

            pst.executeUpdate();
            sound.playSound5(clip);
            refreshAdmin();
       
            df.applyPattern("###,###.##");
    
            walletTxt.setText(df.format(money));
            
            initProds();
            
            
            
        } catch (SQLException ex) {
            sound.playSound4(clip);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}




private boolean validateInputs() {
    // Check if username is not empty
    if (admin_username.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username cannot be empty.");
        return false;
    }
    
    // Check if password is not empty
    if (admin_password.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password cannot be empty.");
        return false;
    }

    // Check if admin_cash is a valid number
    try {
        Double.parseDouble(admin_cash.getText());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input for money field.");
        return false;
    }

    // You can add more validation as needed
    
    return true; // All inputs are valid
}


private void adminDelete() {
    int selectedRow = adminTable.getSelectedRow();

    if (selectedRow != -1) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            String studentID = adminTable.getValueAt(selectedRow, 0).toString(); //getrow

            String sql = "DELETE FROM `user` WHERE username = ?";
            
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, studentID);
                
                 pst.executeUpdate();
                 sound.playSound(clip);
                 refreshAdmin();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to delete");
        sound.playSound4(clip);
    }
}
     
 



public void skibimethod(){

    if (skibidiclicked == true){
           EasterEgg egg = new EasterEgg();
           egg.setVisible(true);
    }

}


















private void SearchTransac() {
    // Get the search text from the searchTXT field
    String searchText = TransactionSearchTXT.getText().trim();

    // Check if search text is empty
    if (searchText.equals("")||searchText.equals("search...")) {
        // If search text is empty, load all data from the database table
        String sqlQuery = "SELECT `id`, `user`, `product`, `type`, `cost`, `tax`, `quantity`, `total`,`id` ,`productID`, `Date`, `Time` FROM `transaction_earnings` ORDER BY id DESC";
        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with the data
            DefaultTableModel model = (DefaultTableModel) TransactionTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            NumberOfTransactions.setText(Integer.toString(model.getRowCount()));
            
           

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }
        
        return; // Exit the method
    }

    // Construct the SQL query to search across multiple columns
    String sqlQuery = "SELECT `id`, `user`, `product`, `type`, `cost`, `tax`, `quantity`, `total`, `id`, `productID`, `Date`, `Time` FROM `transaction_earnings` WHERE "
            + "CONCAT(`id`, ' ', `user`, ' ', `product`, ' ', `type`, ' ', `cost`, ' ', `tax`, ' ', `quantity`, ' ', `total`, ' ', `id`, ' ', `productID`, ' ', `Date`, ' ', `Time`) "
            + "LIKE ?";

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set the parameter for the search text
        preparedStatement.setString(1, "%" + searchText + "%");

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) TransactionTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        NumberOfTransactions.setText(Integer.toString(model.getRowCount()));


    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
}






private void SearchImport() {
    // Get the search text from the searchTXT field
    String searchText = ImportSearchTXT.getText().trim();

    // Check if search text is empty
    if (searchText.equals("")||searchText.equals("search...")) {
        // If search text is empty, load all data from the database table
        String sqlQuery = "SELECT `id`, `user`, `productID`, `product`, `cost`, `stock`, `type`, `expense`, `Date`, `Time` FROM `transaction_expenses` ORDER BY id DESC";
        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with the data
            DefaultTableModel model = (DefaultTableModel) ImportTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            NumberOfImports.setText(Integer.toString(model.getRowCount()));
            
           

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }
        
        return; // Exit the method
    }

    // Construct the SQL query to search across multiple columns
    String sqlQuery = "SELECT `id`, `user`, `productID`, `product`, `cost`, `stock`, `type`, `expense`, `Date`, `Time` FROM `transaction_expenses` WHERE "
            + "CONCAT(`id`, ' ', `user`, ' ', `productID`, ' ', `product`, ' ', `cost`, ' ', `stock`, ' ', `type`, ' ', `expense`, ' ', `Date`, ' ', `Time`) "
            + "LIKE ?";

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set the parameter for the search text
        preparedStatement.setString(1, "%" + searchText + "%");

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) ImportTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        NumberOfImports.setText(Integer.toString(model.getRowCount()));


    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
}




public void YTmethod1(){

 if (!sound.isMusicLoop1Playing()) {
           
            sound.stopMusic5();
            sound.playMusicLoop1();

            if (volumepress == true){
            sound.upMusic();
            }else {
            sound.midMusic();
            }
            
            sound.stopMusic2();
            sound.stopMusic3();
            sound.stopMusic4();
            
            giflabel1.setIcon(new ImageIcon("MPGIF.gif"));

            giflabel2.setIcon(null);
            giflabel3.setIcon(null);
            giflabel4.setIcon(null);
            giflabel5.setIcon(null);
           
          
       
       }
       skibimethod();

}



public void YTmethod2(){

 
if (!sound.isMusicLoop3Playing()) {
    
       sound.stopMusic5();
       sound.playMusicLoop3();
       
       if (volumepress == true){
        sound.upMusic();
        }else {
        sound.midMusic();
        }
       
       sound.stopMusic1();
       sound.stopMusic2();
       sound.stopMusic4();
       
       giflabel2.setIcon(new ImageIcon("MPGIF.gif"));
       
        giflabel1.setIcon(null);
        giflabel3.setIcon(null);
        giflabel4.setIcon(null);
        giflabel5.setIcon(null);
       }
       skibimethod();


}



public void YTmethod3(){
if (!sound.isMusicLoop4Playing()) {
       sound.stopMusic5();
       sound.playMusicLoop4();
       
        if (volumepress == true){
        sound.upMusic();
        }else {
        sound.midMusic();
        }
       
       sound.stopMusic1();
       sound.stopMusic2();
       sound.stopMusic3();
       
       giflabel3.setIcon(new ImageIcon("MPGIF.gif"));
       
        giflabel2.setIcon(null);
        giflabel1.setIcon(null);
        giflabel4.setIcon(null);
        giflabel5.setIcon(null);
       }
       skibimethod();
}


public void YTmethod4(){
    if (!sound.isMusicLoop5Playing()) {
       sound.playMusicLoop5();
       
       if (volumepress == true){
        sound.upMusic();
        }else {
        sound.midMusic();
        }
       
       sound.stopMusic1();
       sound.stopMusic2();
       sound.stopMusic3();
       sound.stopMusic4();
       
       giflabel4.setIcon(new ImageIcon("MPGIF.gif"));
       
        giflabel2.setIcon(null);
        giflabel3.setIcon(null);
        giflabel1.setIcon(null);
        giflabel5.setIcon(null);
       }
       skibimethod();

}


public void YTmethod5(){
    if (!sound.isMusicLoop2Playing()) {
        sound.stopMusic5();
        sound.playMusicLoop2();
        
        if (volumepress == true){
        sound.upMusic();
        }else {
        sound.midMusic();
        }
        
        sound.stopMusic1();
        sound.stopMusic3();
        sound.stopMusic4();
        
        giflabel5.setIcon(new ImageIcon("MPGIF.gif"));
        
        giflabel2.setIcon(null);
        giflabel3.setIcon(null);
        giflabel4.setIcon(null);
        giflabel1.setIcon(null);
    }
       skibimethod();

}


}