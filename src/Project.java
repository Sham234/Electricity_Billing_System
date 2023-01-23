import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Box;

public class Project extends JFrame implements ActionListener{
    Project(){
        super("Electricity Billing System");

        setSize(1200,700);

        /* Adding background image */
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("images/23.png"));
        Image i3 = ic.getImage().getScaledInstance(1280,660,Image.SCALE_SMOOTH);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);

        /* Create the menubar */
        JMenuBar mb  = new JMenuBar();
        mb.setBackground(new Color(242, 121, 53));
        mb.setPreferredSize(new Dimension(100,50));
        mb.setOpaque(true);

        /* First Column */
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");
        master.setForeground(Color.BLACK);
        master.setFont(new Font("serif", Font.BOLD, 15));

        /* ---- New Customer ---- */
        m1.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/icon1.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('N');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        m1.setForeground(Color.BLACK);

        /* ---- Customer Details ---- */
        m2.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('C');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
        m2.setForeground(Color.BLACK);

        /* ---- Deposit Details  ----- */
        m3.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("images/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image3));
        m3.setMnemonic('N');
        m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        m3.setBackground(Color.WHITE);
        m3.setForeground(Color.BLACK);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

        // --------------------------------------------------------------------------------------------

        /* Spacing Column */
        JMenu sp1 = new JMenu("");
        sp1.setEnabled(false);
        JMenu sp2 = new JMenu("");
        sp2.setEnabled(false);
        JMenu sp3 = new JMenu("");
        sp3.setEnabled(false);
        JMenu sp4 = new JMenu("");
        sp4.setEnabled(false);
        JMenu sp5 = new JMenu("");
        sp5.setEnabled(false);
        JMenu sp6 = new JMenu("");
        sp6.setEnabled(false);
        JMenu sp7 = new JMenu("");
        sp7.setEnabled(false);
//        JMenu sp8 = new JMenu("");
//        sp8.setEnabled(false);
//        JMenu sp9 = new JMenu("");
//        sp9.setEnabled(false);
//        JMenu sp10 = new JMenu("");
//        sp10.setEnabled(false);

        // --------------------------------------------------------------------------------------------

        /* Second Column */
        JMenu user = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Pay Bill");
        JMenuItem u2 = new JMenuItem("Calculate Bill");
        JMenuItem u3 = new JMenuItem("Last Bill");
        user.setForeground(Color.BLACK);
        user.setFont(new Font("serif", Font.BOLD, 15));

        /* ---- Pay Bill ---- */
        u1.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("images/icon3.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic('P');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);

        /* ---- Bill Details ---- */
        u2.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("images/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image5));
        u2.setMnemonic('B');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);

        /* ---- Last Bill ----*/
        u3.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("images/icon5.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u3.setIcon(new ImageIcon(image6));
        u3.setMnemonic('L');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        u3.setBackground(Color.WHITE);

        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);


        // ---------------------------------------------------------------------------------------------

        /* Third Column*/
        JMenu report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Generate Bill");
        report.setForeground(Color.BLACK);
        report.setFont(new Font("serif", Font.BOLD, 15));

        /* ---- Report ---- */
        r1.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("images/icon6.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(image7));
        r1.setMnemonic('G');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        r1.setBackground(Color.WHITE);

        r1.addActionListener(this);

        // -----------------------------------------------------------------------------------------------

        /* Fourth Column*/
        JMenu utility = new JMenu("Utility");
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");
        utility.setForeground(Color.BLACK);
        utility.setFont(new Font("serif", Font.BOLD, 15));

        /* ---- Notepad ---- */
        ut1.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("images/icon7.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut1.setIcon(new ImageIcon(image8));
        ut1.setMnemonic('N');
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        ut1.setBackground(Color.WHITE);

        /* ---- Calculator ---- */
        ut2.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("images/icon8.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut2.setIcon(new ImageIcon(image9));
        ut2.setMnemonic('C');
        ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        ut2.setBackground(Color.WHITE);

        /* ---- Web Browser ---- */
        ut3.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("images/icon9.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut3.setIcon(new ImageIcon(image10));
        ut3.setMnemonic('W');
        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        ut3.setBackground(Color.WHITE);


        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);

        // ---------------------------------------------------------------------------------------

        /*Fifth Column */
        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("serif", Font.BOLD, 15));

        /* ---- Exit ---- */
        ex.setFont(new Font("serif",Font.PLAIN,13));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("images/icon10.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);


        // ---------------------------------------------------------------------------------------------


        master.add(m1);
        master.add(m2);
        master.add(m3);

        user.add(u1);
        user.add(u2);
        user.add(u3);

        report.add(r1);

        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);

        exit.add(ex);
        mb.add(sp1);
        mb.add(sp2);
        mb.add(master);
        mb.add(sp3);
        mb.add(user);
        mb.add(sp4);
        mb.add(report);
        // Separate between two columns
        mb.add(Box.createHorizontalGlue());
        mb.add(utility);
        mb.add(sp5);
        mb.add(exit);
        mb.add(sp6);
        mb.add(sp7);

        setJMenuBar(mb);

        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Customer Details")){
            new customer_details().setVisible(true);

        }else if(msg.equals("New Customer")) {
            new new_customer().setVisible(true);
        }
        else if(msg.equals("Deposit Details")){
            new deposit_details().setVisible(true);

        }else if(msg.equals("Calculate Bill")){
            new calculate_bill().setVisible(true);

        }else if(msg.equals("Pay Bill")){
            new pay_bill().setVisible(true);

        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Exit")){
            System.exit(0);
        }else if(msg.equals("Generate Bill")){
            new generate_bill().setVisible(true);

        }else if(msg.equals("Last Bill")){
            new LastBill().setVisible(true);

        }
    }

    public static void main(String[] args){
        new Project().setVisible(true);
    }

}