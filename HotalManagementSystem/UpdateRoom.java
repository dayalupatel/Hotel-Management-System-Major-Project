package HotalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{

    Choice ccustomer;
    JTextField tfRoom, tfavailable, tfcleaning, tfpaid, tfpending;
    JButton check, update, back;

    UpdateRoom(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setBounds(30,20,300,30);
        text.setForeground(Color.BLUE);
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
        room.setBounds(30,130,100,20);
        add(room);

        tfRoom = new JTextField();
        tfRoom.setBounds(200,130,150,25);
        add(tfRoom);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(30,180,100,20);
        add(availability);

        tfavailable = new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        JLabel cleaning = new JLabel("Cleaning Status");
        cleaning.setBounds(30,230,100,20);
        add(cleaning);

        tfcleaning = new JTextField();
        tfcleaning.setBounds(200,230,150,25);
        add(tfcleaning);


        check = new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


        setBounds(300,200,980,450);
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
                }

                ResultSet rs2 = c.s.executeQuery("select*from room where roomnumber = '"+tfRoom.getText()+"' ");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfcleaning.setText(rs2.getString("cleaning_status"));
                }
                
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }

        else if(e.getSource() == update){
            // String number = ccustomer.getSelectedItem();
            String room = tfRoom.getText();
            String isAvailable = tfavailable.getText();
            String cleanStatus = tfcleaning.getText();

            try {
                Connector conn = new Connector();
                conn.s.executeUpdate("update room set availability = '"+isAvailable+"', cleaning_status = '"+cleanStatus+"'  where roomnumber = '"+room+"' ");
                JOptionPane.showMessageDialog(null, "Data Upadated Successfully");

                setVisible(false);
                new Reception();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == back) {
            setVisible(false);
            new Reception();
        } 
    }

    public static void main(String[] args){
        new UpdateRoom();
    }
    
}

