package HotalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CustumerForm extends JFrame implements ActionListener{

    JComboBox<String> comboId;
    JTextField tfnumber, tfname, tfcountry, tfDeposit;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel checkinTime;
    JButton add, back;

    CustumerForm(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(text);

        JLabel id = new JLabel("Identity");
        id.setBounds(35, 80, 100, 20);
        id.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(id);

        String options[] = {"Aadhar Card", "Passport", "Driving License", "Voter-id Card", "Ration Card"};
        comboId = new JComboBox<>(options);
        comboId.setBounds(200, 80, 150, 25);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        JLabel number = new JLabel("Number");
        number.setBounds(35, 120, 100, 20);
        number.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(number);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel name = new JLabel("Name");
        name.setBounds(35, 160, 100, 20);
        name.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(35, 200, 100, 20);
        gender.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(gender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);

        JLabel country = new JLabel("Country");
        country.setBounds(35, 240, 100, 20);
        country.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(country);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel room = new JLabel("Room Number");
        room.setBounds(35, 280, 150, 20);
        room.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(room);

        croom = new Choice();
        
        try {
            Connector conn = new Connector();
            String query = "Select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel time = new JLabel("Checkin Time");
        time.setBounds(35, 320, 150, 20);
        time.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(time);

        Date date = new Date();

        checkinTime = new JLabel("" + date);
        checkinTime.setBounds(200, 320, 170, 25);
        checkinTime.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(checkinTime);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(35, 360, 100, 20);
        deposit.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(deposit);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200,360,150,25);
        add(tfDeposit);

        add = new JButton("ADD");
        add.setBounds(50, 410, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(200, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/yoga.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);


        setBounds(350, 200, 800, 500);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) { 
        if(ae.getSource() == add){
            String id = (String) comboId.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;

            if(rmale.isSelected()){
                gender = "Male";
            }
            else{
                gender = "Female";
            }

            String country = tfcountry.getText();
            String room = (String)croom.getSelectedItem();
            String time = checkinTime.getText();
            String deposit = tfDeposit.getText();

            try {
                String query = "insert into customerInfo values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query1 = "insert into records(document, number, name, gender, country, room, checkintime) values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"' )";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"' ";

                Connector conn = new Connector();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");

                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
        
    }

    public static void main(String[] args){
        new CustumerForm();
    }
}
