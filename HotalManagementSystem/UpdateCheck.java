package HotalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{

    Choice ccustomer;
    JTextField tfRoom, tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, back;

    UpdateCheck(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.WHITE);
        add(text);

        JLabel id = new JLabel("Customer Id");
        id.setBounds(30,80,100,20);
        add(id);

        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try {
            Connector conn = new Connector();
            ResultSet rs = conn.s.executeQuery("select * from customerInfo");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel room = new JLabel("Room Number");
        room.setBounds(30,120,100,20);
        add(room);

        tfRoom = new JTextField();
        tfRoom.setBounds(200,120,150,25);
        add(tfRoom);

        JLabel name = new JLabel("Name");
        name.setBounds(30,160,100,20);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel checkin = new JLabel("Checkin Time");
        checkin.setBounds(30,200,100,20);
        add(checkin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);

        JLabel paid = new JLabel("Amount Paid");
        paid.setBounds(30,240,100,20);
        add(paid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);

        JLabel pending = new JLabel("Amount Pending");
        pending.setBounds(30,280,100,20);
        add(pending);

        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);

        check = new JButton("Check");
        check.setBounds(30,340,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,340,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,340,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/check.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(370,50,500,300);
        add(image);


        setBounds(300,200,900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customerInfo where number = '"+id+"' ";
            try {
                Connector c = new Connector();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfRoom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }

                ResultSet rs2 = c.s.executeQuery("select*from room where roomnumber = '"+tfRoom.getText()+"' ");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountpending = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText("" + amountpending);
                }
                
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = tfRoom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();

            try {
                Connector conn = new Connector();
                conn.s.executeUpdate("update customerInfo set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"' ");
                JOptionPane.showMessageDialog(null, "Data Upadated Successfully!");

                setVisible(false);
                new Reception();
            } catch (Exception aae) {
                aae.printStackTrace();
            }
        }
        else if(e.getSource() == back) {
            setVisible(false);
            new Reception();
        } 
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
    
}

