import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pay_bill extends JFrame implements ActionListener{

    JButton back;
    pay_bill(){

        super("Pay Bill");
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://www.mytnb.com.my/");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }

        JScrollPane scrollPane = new JScrollPane(j);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        setSize(800,800);
        setLocation(250,120);
        setVisible(true);

        back = new JButton("Back");
        back.setBounds(640, 20, 80, 30);
        back.addActionListener(this);
        j.add(back);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        JOptionPane.showMessageDialog(null,"Payment Completed!");
    }
    public static void main(String[] args){

        new pay_bill().setVisible(true);

    }
}