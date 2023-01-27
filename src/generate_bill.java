import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class generate_bill extends JFrame implements ActionListener{
    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice meternumber,c2;
    JPanel p1;
    generate_bill(){

        super("Generate Bill");
        setSize(500,900);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        l1 = new JLabel("Generate Bill");

        meternumber = new Choice();
        c2 = new Choice();

        try {
            conn c1  = new conn();
            ResultSet rs = c1.s.executeQuery("select * from emp");
            while(rs.next()) {
                meternumber.add(rs.getString("meter"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


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


        t1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif",Font.ITALIC,18));

        b1 = new JButton("Generate Bill");

        p1.add(l1);
        p1.add(meternumber);
        p1.add(c2);
        add(p1,"North");

        add(jsp,"Center");
        add(b1,"South");

        b1.addActionListener(this);

        setLocation(350,40);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            conn c1 = new conn();

            String month = c2.getSelectedItem();
            t1.setText("\tReliance Power Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+" ,2023\n\n\n");

            ResultSet rs = c1.s.executeQuery("select * from emp where meter="+meternumber.getSelectedItem());

            if(rs.next()){
                t1.append("\n    Customer Name:"+rs.getString("name"));
                t1.append("\n    Meter Number:  "+rs.getString("meter"));
                t1.append("\n    Address:            "+rs.getString("address"));
                t1.append("\n    State:                 "+rs.getString("state"));
                t1.append("\n    City:                   "+rs.getString("city"));
                t1.append("\n    Email:                "+rs.getString("email"));
                t1.append("\n    Phone Number:  "+rs.getString("phone"));
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
            }

            rs = c1.s.executeQuery("select * from tax");

            if(rs.next()){
                t1.append("\n    Meter Location:"+rs.getString("meter_location")); // Set in SQL
                t1.append("\n    Meter Type:      "+rs.getString("meter_type")); // Set in SQL
                t1.append("\n    Phase Code:    "+rs.getString("phase_code")); // Set in SQL
                t1.append("\n    Bill Type:         "+rs.getString("bill_type")); // Set in SQL
                t1.append("\n    Days:               "+rs.getString("days")); // Set in SQL
                t1.append("\n");
                t1.append("---------------------------------------------------------------");
                t1.append("\n\n");
                t1.append("\n    Meter Rent:\t\t"+rs.getString("meter_rent")); // Set in SQL
                t1.append("\n    MCB Rent:  \t\t"+rs.getString("MCB_rent")); // Set in SQL
                t1.append("\n    Service Tax:\t\t"+rs.getString("service_rent")); // Set in SQL
                t1.append("\n    GST:\t\t"+rs.getString("gst")); // Set in SQL
                t1.append("\n");

            }

            rs = c1.s.executeQuery("select * from bill where meter="+meternumber.getSelectedItem());

            if(rs.next()){
                t1.append("\n    Current Month :\t"+rs.getString("month"));
                t1.append("\n    Units Consumed:\t"+rs.getString("units"));
                t1.append("\n    Total Charges :\tRM "+rs.getString("amount"));
                t1.append("\n---------------------------------------------------------------");
                t1.append("\n    TOTAL PAYABLE :\tRM "+rs.getString("amount"));
            }






        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new generate_bill().setVisible(true);
    }
}