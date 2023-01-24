

import java.awt.*;
import javax.swing.*;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    JPanel panel,p2,p3,p4,p5,p6,p7;

    login()
    {
        super("Login Page");
        panel = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();

        l1=new JLabel("Username");
        l2=new JLabel("Password");
        l3=new JLabel("Log in");
        l4=new JLabel("Not yet a member?");
        l4.setForeground(Color.BLACK);
        tf1=new JTextField(15);
        pf2=new JPasswordField(15);

        /* User text label size */
        l1.setBounds(100,25,70,20);
        l1.setOpaque(true);
        l1.setForeground(Color.BLACK);
        l1.setBackground(Color.WHITE);
        l1.setFont(new Font("SansSerif", 1, 14));

        /* User text field size */
        tf1.setBounds(100,125,193,28);

        /* Password label size */
        l2.setBounds(100,150,70,20);
        l2.setForeground(Color.BLACK);
        l2.setBackground(Color.WHITE);
        l2.setFont(new Font("SansSerif", 1, 14));

        l3.setFont(new Font("Serif",Font.ITALIC,36));
        //Move the label to center
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setForeground(Color.BLACK);

        /* Password field size */
        pf2.setBounds(100,150,193,28);

        //-------------------------------------------------------------------------------------------------------

        /* Button */
//        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("images/login.jpg"));
//        Image i1=ic1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        b1=new JButton("Login");
        b1.setBounds(100,110,90,25);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(255, 148, 112));

//        ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("images/cancel.png"));
//        Image i2=ic2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        b2=new JButton("Cancel");
        b2.setBounds(350,110,90,25);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(255, 148, 112));

        b3=new JButton("Sign up");
        b3.setBounds(550,110,90,25);
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(255, 148, 112));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

//        ImageIcon ic3=new ImageIcon(ClassLoader.getSystemResource("images/login2.png"));
//        Image i3=ic3.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
//        ImageIcon icc3=new ImageIcon(i3);
//
//        l3=new JLabel(icc3);

        setLayout(new BorderLayout(20,20));

        add(p2,BorderLayout.NORTH);
        add(p3,BorderLayout.LINE_START);
        add(p5,BorderLayout.BEFORE_FIRST_LINE);
        p2.setBackground(Color.WHITE);
        p3.setBackground(Color.WHITE);
        p5.setBackground(Color.WHITE);

        p6.add(l3);
        add(p6,BorderLayout.BEFORE_FIRST_LINE);
        p6.setBackground(new Color(255, 148, 112));

        panel.add(l1);
        panel.add(tf1);
        panel.add(l2);
        panel.add(pf2);
        p4.add(b1);
        p4.add(b2);
        p7.add(l4);
        p7.add(b3);
        add(panel,BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);

        add(p4,BorderLayout.AFTER_LINE_ENDS);
        p4.setBackground(Color.WHITE);

        add(p7,BorderLayout.AFTER_LAST_LINE);

        setSize(new Dimension(480,350));
        setLocation(new Point(420,170));
        getContentPane().setBackground(Color.WHITE);
        add(panel);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == b1) {
            try {
                conn c1 = new conn();
                String a = tf1.getText();
                String b = pf2.getText();
                String q = "select * from login where username = '" + a + "' and password = '" + b + "'";
                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    new Project().setVisible(true);
                    this.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error: " + e);
            }
        }
        if (ae.getSource() == b2) {
            setVisible(false);
        } else if (ae.getSource() == b3) {
            setVisible(false);

            new signup();
        }
    }

    public static void main(String[] args){
        new login().setVisible(true);
    }

}
