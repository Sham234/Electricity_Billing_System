import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class calculate_bill extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    Choice meternumber,c2;
    JButton b1,b2;
    JPanel p,p2,p3;

    calculate_bill(){

        setTitle("Calculate bill");

        p = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        p.setLayout(new GridLayout(4,2,30,30));
        p.setBackground(Color.WHITE);

        l1 = new JLabel("Calculate Electricity Bill");
        l2 = new JLabel("Meter No");
        l2.setFont(new Font("Serif",Font.BOLD,16));
        l2.setForeground(Color.BLACK);
        l3 = new JLabel("Units Consumed");
        l3.setFont(new Font("Serif",Font.BOLD,16));
        l3.setForeground(Color.BLACK);
        l5 = new JLabel("Month");
        l5.setFont(new Font("Serif",Font.BOLD,16));
        l5.setForeground(Color.BLACK);

        t1 = new JTextField();

        meternumber = new Choice();

        try {
            conn c1  = new conn();
            ResultSet rs = c1.s.executeQuery("select * from emp");
            while(rs.next()) {
                meternumber.add(rs.getString("meter"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c2 = new Choice();
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        c2.setForeground(Color.BLACK);

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");

        b1.setBackground(new Color(255, 148, 112));
        b1.setForeground(Color.WHITE);

        b2.setBackground(new Color(255, 148, 112));
        b2.setForeground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/hicon4.png"));
        Image i2 = i1.getImage().getScaledInstance(180, 270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l4 = new JLabel(i3);



        l1.setFont(new Font("Serif",Font.ITALIC,40));
        l1.setForeground(Color.BLACK);
        //Move the label to center
        l1.setHorizontalAlignment(JLabel.CENTER);


        p2.add(l1);
        p2.setBackground(new Color(255, 148, 112));
        p.add(l2);
        p.add(meternumber);
        p.add(l5);
        p.add(c2);
        p.add(l3);
        p.add(t1);
        p3.add(b1);
        p3.add(b2);
        p.setBackground(Color.WHITE);
        p3.setBackground(Color.WHITE);

        setLayout(new BorderLayout(20,20));

        add(p2,"North");
        add(p,"Center");
        add(p3,"South");
        add(l4,"West");


        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(680,400);
        setLocation(320,180);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1) {

            String a = meternumber.getSelectedItem();
            String b = t1.getText();
            String c = c2.getSelectedItem();

            int units_consumed = Integer.parseInt(b);

            int total_bill = 0;
            try {
                conn c1 = new conn();
                ResultSet rs = c1.s.executeQuery("select * from tax");
                while (rs.next()) {

                    if (units_consumed < 100)
                        {
                            total_bill = units_consumed * 2;
                        }
                    else if (units_consumed < 300) {
                            total_bill = 100 * 2 + (units_consumed - 100) * 3;
                        } else if (units_consumed > 300) {
                            total_bill = 100 * 2 + 200 * 3 + (units_consumed - 300) * 4;
                        }

                        total_bill += Integer.parseInt(rs.getString("meter_rent"));
                        total_bill += Integer.parseInt(rs.getString("service_rent"));
                        total_bill += Integer.parseInt(rs.getString("MCB_rent"));
                        total_bill += Integer.parseInt(rs.getString("GST"));
                    }

            } catch (Exception e) {
            }

            String q = "insert into bill values('" + a + "','" + c + "','" + b + "','" + total_bill + "')";

            try {
                conn c1 = new conn();
                c1.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Bill Updated");
                setVisible(false);
            } catch (Exception aee) {
                aee.printStackTrace();
            }
        }
        else if(ae.getSource() == b2){
            setVisible(false);
        }
    }


    public static void main(String[] args){
        new calculate_bill().setVisible(true);
    }
}