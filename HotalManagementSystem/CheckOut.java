package HotalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice cCustomerId;
    JLabel lblroomnumber, lblcheckinTime, lblcheckoutTime;
    JButton  checkout, back;
    CheckOut() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("CheckOut");
        heading.setBounds(100,20,150,30);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);


        JLabel lblId = new JLabel("Customer Id");
        lblId.setBounds(30, 80, 100, 30);
        add(lblId);

        cCustomerId = new Choice();
        cCustomerId.setBounds(150, 80, 150, 25);
        add(cCustomerId);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 100, 30);
        add(lblroomnumber);


        JLabel lblcheckin = new JLabel("CheckIn Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);

        lblcheckinTime = new JLabel();
        lblcheckinTime.setBounds(150, 180, 100, 30);
        add(lblcheckinTime);

        JLabel lblcheckout = new JLabel("CheckOut Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);

        lblcheckoutTime = new JLabel();
        lblcheckoutTime.setBounds(150, 230, 100, 30);
        add(lblcheckoutTime);

        Date date = new Date();
        lblcheckoutTime = new JLabel(""+ date); // double quotes makes date into string ; 
        lblcheckoutTime.setBounds(150, 230, 150, 30);
        add(lblcheckoutTime);

        checkout = new JButton("CheckOut");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(350, 50, 400, 250);
        add(image1);

        try {
            Connector conn = new Connector();
            ResultSet rs = conn.s.executeQuery("select * from customerInfo");
            while(rs.next()) {
                cCustomerId.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckinTime.setText(rs.getString("checkintime"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        setBounds(300, 200, 800, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkout ) {
            String time = lblcheckoutTime.getText();
            String query = "update records set checkouttime = '"+time+"' where number = '"+cCustomerId.getSelectedItem()+"' ";
            String query1 = "delete from customerInfo where number = '"+cCustomerId.getSelectedItem()+"' ";
            String query2 = " update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"' ";

            try {
                Connector conn = new Connector();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Checkout Done" );
                setVisible(false);
                new Reception();

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == back ) {

            setVisible(false);
            new Reception();
        }
        
    }


    public static void main(String[] args) {
        new CheckOut();
    }
}
