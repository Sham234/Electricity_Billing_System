

import java.awt.*;
import javax.swing.*;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel panel,p2,p3,p4;

    login()
    {
        super("Login Page");
        panel = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        l1=new JLabel("User Name");
        l2=new JLabel("Password");
        tf1=new JTextField(15);
        pf2=new JPasswordField(15);

        /* User text label size */
        l1.setBounds(100,25,70,20);
        l1.setOpaque(true);
        l1.setForeground(Color.BLACK);
        l1.setBackground(Color.WHITE);
        l1.setFont(new Font("SansSerif", 1, 12));

        /* User text field size */
        tf1.setBounds(100,125,193,28);

        /* Password label size */
        l2.setBounds(100,150,70,20);
        l2.setForeground(Color.BLACK);
        l2.setBackground(Color.WHITE);
        l2.setFont(new Font("SansSerif", 1, 12));

        /* Password field size */
        pf2.setBounds(100,150,193,28);

        //-------------------------------------------------------------------------------------------------------

        /* Button */
//        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("images/login.jpg"));
//        Image i1=ic1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        b1=new JButton("Login");
        b1.setBounds(100,110,90,25);
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(242, 121, 53));

//        ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("images/cancel.png"));
//        Image i2=ic2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        b2=new JButton("Cancel");
        b2.setBounds(350,110,90,25);
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(242, 121, 53));

        b1.addActionListener(this);
        b2.addActionListener(this);

        ImageIcon ic3=new ImageIcon(ClassLoader.getSystemResource("images/login2.png"));
        Image i3=ic3.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon icc3=new ImageIcon(i3);

        l3=new JLabel(icc3);

        setLayout(new BorderLayout(20,20));

        add(l3,BorderLayout.WEST);
        add(p2,BorderLayout.NORTH);
        add(p3,BorderLayout.AFTER_LINE_ENDS);
        p2.setBackground(Color.WHITE);
        p3.setBackground(Color.WHITE);

        panel.add(l1);
        panel.add(tf1);
        panel.add(l2);
        panel.add(pf2);
        p4.add(b1);
        p4.add(b2);
        add(panel,BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);

        add(p4,BorderLayout.SOUTH);
        p4.setBackground(Color.WHITE);

        setSize(new Dimension(500,300));
        setLocation(new Point(400,200));
        getContentPane().setBackground(Color.WHITE);
        add(panel);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        try{
            conn c1 = new conn();
            String a  = tf1.getText();
            String b  = pf2.getText();
            String q  = "select * from login where username = '"+a+"' and password = '"+b+"'";
            ResultSet rs = c1.s.executeQuery(q);
            if(rs.next()){
                new Project().setVisible(true);
                this.setVisible(false);

            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
        }
    }

    public static void main(String[] args){
        new login().setVisible(true);
    }

}
