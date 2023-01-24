import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class new_customer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    new_customer(){
        super("Add Customer");
        setLocation(350,80);
        setSize(650,600);

        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p.setLayout(new GridLayout(9,2,0,18));

        p.setBackground(Color.WHITE);

        l9 = new JLabel("New Customer Information");
        l9.setFont(new Font("Serif",Font.ITALIC,40));
        //Move the label to center
        l9.setHorizontalAlignment(JLabel.CENTER);
        p3.add(l9);
        p3.setBackground(new Color(255, 148, 112));

        l10 = new JLabel("");
        p.add(l10);
        l11 = new JLabel("");
        p.add(l11);
        l1 = new JLabel("Name");
        t1 = new JTextField();
        l1.setFont(new Font("Serif",Font.BOLD,16));
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Meter No");
        t2 = new JTextField();
        l2.setFont(new Font("Serif",Font.BOLD,16));
        p.add(l2);
        p.add(t2);
        l3 = new JLabel("Address");
        t3 = new JTextField();
        l3.setFont(new Font("Serif",Font.BOLD,16));
        p.add(l3);
        p.add(t3);
        l4 = new JLabel("State");
        t4 = new JTextField();
        l4.setFont(new Font("Serif",Font.BOLD,16));
        p.add(l4);
        p.add(t4);
        l5 = new JLabel("City");
        t5 = new JTextField();
        l5.setFont(new Font("Serif",Font.BOLD,16));
        p.add(l5);
        p.add(t5);
        l6 = new JLabel("Email");
        t6 = new JTextField();
        l6.setFont(new Font("Serif",Font.BOLD,16));
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Phone Number");
        t7 = new JTextField();
        l7.setFont(new Font("Serif",Font.BOLD,16));
        p.add(l7);
        p.add(t7);
        l12 = new JLabel("");
        p.add(l12);
        l13 = new JLabel("");
        p.add(l13);

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");

        b1.setBackground(new Color(255, 148, 112));
        b1.setForeground(Color.WHITE);

        b2.setBackground(new Color(255, 148, 112));
        b2.setForeground(Color.WHITE);

        p2.add(b1);
        p2.add(b2);
        p2.setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        add(p,"Center");
        add(p2,BorderLayout.SOUTH);
        add(p3,BorderLayout.NORTH);

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("images/hicon3.png"));
        Image i3 = ic1.getImage().getScaledInstance(150, 280,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);


        add(l8,"West");
        //for changing the color of the whole 
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){

        String a = t1.getText();
        String c = t2.getText();
        String d = t3.getText();
        String e = t4.getText();
        String f = t5.getText();
        String g = t6.getText();
        String h = t7.getText();

        String q1 = "insert into emp values('"+a+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"')";

        try{
            conn c1 = new conn();
            c1.s.executeUpdate(q1);
            JOptionPane.showMessageDialog(null,"Customer Created");
            this.setVisible(false);


        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


    public static void main(String[] args){
        new new_customer().setVisible(true);
    }
}