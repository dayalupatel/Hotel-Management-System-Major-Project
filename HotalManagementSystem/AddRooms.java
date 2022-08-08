package HotalManagementSystem;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JTextField tfroom, tfprice;
    JButton addButton, cancel;
    JComboBox<String> cbAvail, cbClean, cbbedType;
    AddRooms() {

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("serif", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        setLayout(null);
        setBounds(330, 200, 940, 470 );

        JLabel roomNo = new JLabel("Room Number");
        roomNo.setFont(new Font("serif", Font.PLAIN, 16));
        roomNo.setBounds(60, 80, 120, 30);
        add(roomNo);
        

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        JLabel avail = new JLabel("Available ");
        avail.setFont(new Font("serif", Font.PLAIN, 16));
        avail.setBounds(60, 130, 120, 30);
        add(avail);

        String[] availOption = {"Available", "Occupied"};
        cbAvail = new JComboBox<>(availOption);
        cbAvail.setBounds(200, 130, 150, 30);
        cbAvail.setBackground(Color.white);
        add(cbAvail);

        JLabel clean = new JLabel("Clean ");
        clean.setFont(new Font("serif", Font.PLAIN, 16));
        clean.setBounds(60, 180, 120, 30);
        add(clean);

        String[] cleanOption = {"Cleaned", "Dirty"};
        cbClean = new JComboBox<>(cleanOption);
        cbClean.setBounds(200, 180, 150, 30);
        cbClean.setBackground(Color.white);
        add(cbClean);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("serif", Font.PLAIN, 16));
        price.setBounds(60, 230, 120, 30);
        add(price);


        tfprice= new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel bedtype = new JLabel("Bed type");
        bedtype.setFont(new Font("serif", Font.PLAIN, 16));
        bedtype.setBounds(60, 280, 120, 30);
        add(bedtype);

        String[] bedtypeOption = {"Single", "Double"};
        cbbedType = new JComboBox<>(bedtypeOption);
        cbbedType.setBounds(200, 280, 150, 30);
        cbbedType.setBackground(Color.white);
        add(cbbedType);

        addButton =  new JButton("Add Rooms");
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.black);
        addButton.setBounds(60, 350, 130, 30);
        addButton.addActionListener(this);
        add(addButton);


        cancel =  new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bed.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);


       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== addButton ){
            String roomnumber = tfroom.getText();
            String availability = (String) cbAvail.getSelectedItem();
            String cleanStatus = (String) cbClean.getSelectedItem();
            String price = tfprice.getText();
            String bedType = (String) cbbedType.getSelectedItem();

            try {
                Connector conn = new Connector();
                String query = "insert into room values('"+roomnumber+"', '"+availability+"', '"+cleanStatus+"', '"+price+"', '"+bedType+"')";
                
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Room added successfully");

                setVisible(false);
                new AddRooms();
            } catch (Exception ex) {
                
            }
        } else if ( e.getSource()==cancel ){
            setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new AddRooms();
    }

}
