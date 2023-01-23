//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class customer_details extends JFrame implements ActionListener{
//
//    JTable t1;
//    JButton b1;
//    String x[] = {"Emp Name","Meter No","Address","State","City","Email","Phone"};
//    String y[][] = new String[20][8];
//    int i=0, j=0;
//    customer_details(){
//        super("Customer Details");
//        setSize(1200,650);
//        setLocation(200,200);
//
//        try{
//            conn c1  = new conn();
//            String s1 = "select * from emp";
//            ResultSet rs  = c1.s.executeQuery(s1);
//            while(rs.next()){
//                y[i][j++]=rs.getString("name");
//                y[i][j++]=rs.getString("meter");
//                y[i][j++]=rs.getString("address");
//                y[i][j++]=rs.getString("state");
//                y[i][j++]=rs.getString("city");
//                y[i][j++]=rs.getString("email");
//                y[i][j++]=rs.getString("phone");
//                i++;
//                j=0;
//            }
//            t1 = new JTable(y,x);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//
//        b1 = new JButton("Print");
//        add(b1,"South");
//        JScrollPane sp = new JScrollPane(t1);
//        add(sp);
//        b1.addActionListener(this);
//    }
//    public void actionPerformed(ActionEvent ae){
//        try{
//            t1.print();
//        }catch(Exception e){}
//    }
//
//    public static void main(String[] args){
//        new customer_details().setVisible(true);
//    }
//
//}

//import java.awt.*;
//import javax.swing.*;
//import java.sql.*;
//import net.proteanit.sql.DbUtils;
//import java.awt.event.*;
//
//public class customer_details extends JFrame implements ActionListener{
//
//    Choice meternumber, cmonth;
//    JTable table;
//    JButton search, print;
//
//    customer_details(){
//        super("Customer Details");
//
//        setSize(700, 700);
//        setLocation(400, 100);
//
//        setLayout(null);
//        getContentPane().setBackground(Color.WHITE);
//
//        JLabel lblmeternumber = new JLabel("Search By Meter Number");
//        lblmeternumber.setBounds(20, 20, 150, 20);
//        add(lblmeternumber);
//
//        meternumber = new Choice();
//        meternumber.setBounds(180, 20, 150, 20);
//        add(meternumber);
//
//        try {
//            conn c1  = new conn();
//            ResultSet rs = c1.s.executeQuery("select * from emp");
//            while(rs.next()) {
//                meternumber.add(rs.getString("meter"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JLabel lblmonth = new JLabel("Search By Month");
//        lblmonth.setBounds(400, 20, 100, 20);
//        add(lblmonth);
//
//        cmonth = new Choice();
//        cmonth.setBounds(520, 20, 150, 20);
//        cmonth.add("January");
//        cmonth.add("February");
//        cmonth.add("March");
//        cmonth.add("April");
//        cmonth.add("May");
//        cmonth.add("June");
//        cmonth.add("July");
//        cmonth.add("August");
//        cmonth.add("September");
//        cmonth.add("October");
//        cmonth.add("November");
//        cmonth.add("December");
//        add(cmonth);
//
//        table = new JTable();
//
//        try {
//            conn c1 = new conn();
//            ResultSet rs = c1.s.executeQuery("select * from bill");
//
//            table.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JScrollPane sp = new JScrollPane(table);
//        sp.setBounds(0, 100, 700, 600);
//        add(sp);
//
//        search = new JButton("Search");
//        search.setBounds(20, 70, 80, 20);
//        search.addActionListener(this);
//        add(search);
//
//        print = new JButton("Print");
//        print.setBounds(120, 70, 80, 20);
//        print.addActionListener(this);
//        add(print);
//
//
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == search) {
//            String query = "select * from bill where meter = '"+meternumber.getSelectedItem()+"' and month = '"+cmonth.getSelectedItem()+"'";
//
//            try {
//                conn c1 = new conn();
//                ResultSet rs = c1.s.executeQuery(query);
//                table.setModel(DbUtils.resultSetToTableModel(rs));
//            } catch (Exception e) {
//
//            }
//        } else  {
//            try {
//                table.print();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new customer_details();
//    }
//}

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class customer_details extends JFrame implements ActionListener{

    Choice meternumber, cmonth;
    JTable table;
    JButton search, print;

    customer_details(){
        super("Customer Details");

        setSize(1200, 650);
        setLocation(200, 150);

        table = new JTable();

        try {
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from emp");

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        add(sp);

        print = new JButton("Print");
        print.addActionListener(this);
        add(print, "South");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new customer_details();
    }
}

