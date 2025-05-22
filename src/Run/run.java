////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////         CODE MADE BY: S A M U E L   J A M E S    A.    C I N C O            ///////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package Run;


import Classes.UIcolors;
import Frame.login;
import Frame.receipt;
import Frame.serverConfig;


//UIcolors receiptColor = new UIcolors();
//        receiptColor.UIcolor2();
//        receipt receipt = new receipt();
//        receipt.setVisible(true);

public class run {

    public static void main(String[] args) {
        UIcolors color = new UIcolors();
        color.UIcolor();
    

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
                
                
            }
        });
    }
}
