package HotalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {
    JTextField tfName, tfcompany, tfLocation, tfAge, tfmodel;
    JButton addButton, cancel;
    JComboBox<String> cbAvail, cbGender;
    AddDrivers() {

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("serif", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

        setLayout(null);
        setBounds(300, 200, 980, 470 );

        JLabel Name = new JLabel("NAME");
        Name.setFont(new Font("serif", Font.PLAIN, 16));
        Name.setBounds(60, 70, 120, 30);
        add(Name);
        

        tfName = new JTextField();
        tfName.setBounds(200, 70, 150, 30);
        add(tfName);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("serif", Font.PLAIN, 16));
        age.setBounds(60, 110, 120, 30);
        add(age);

        tfAge = new JTextField();
        tfAge.setBounds(200, 110, 150, 30);
        add(tfAge);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("serif", Font.PLAIN, 16));
        gender.setBounds(60, 150, 120, 30);
        add(gender);

        String[] genderOption = {"Male", "Female"};
        cbGender = new JComboBox<>(genderOption);
        cbGender.setBounds(200, 150, 150, 30);
        cbGender.setBackground(Color.white);
        add(cbGender);

        JLabel company = new JLabel("Car Company");
        company.setFont(new Font("serif", Font.PLAIN, 16));
        company.setBounds(60, 190, 120, 30);
        add(company);


        tfcompany= new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        JLabel model = new JLabel("Car Model");
        model.setFont(new Font("serif", Font.PLAIN, 16));
        model.setBounds(60, 230, 120, 30);
        add(model);

        tfmodel= new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);

        JLabel lblAvailble = new JLabel("Available");
        lblAvailble.setFont(new Font("serif", Font.PLAIN, 16));
        lblAvailble.setBounds(60, 270, 120, 30);
        add(lblAvailble);

        String[] AvailableOption = {"Available", "Busy"};
        cbAvail = new JComboBox<>(AvailableOption);
        cbAvail.setBounds(200, 270, 150, 30);
        cbAvail.setBackground(Color.white);
        add(cbAvail);

        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("serif", Font.PLAIN, 16));
        lblLocation.setBounds(60, 310, 120, 30);
        add(lblLocation);

        tfLocation= new JTextField();
        tfLocation.setBounds(200, 310, 150, 30);
        add(tfLocation);

        addButton =  new JButton("Add Driver");
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.black);
        addButton.setBounds(60, 360, 130, 30);
        addButton.addActionListener(this);
        add(addButton);


        cancel =  new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(220, 360, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/car.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);


       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== addButton ){
            String name = tfName.getText();
            String age = tfAge.getText();
            String gender = (String) cbAvail.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String Available = (String) cbAvail.getSelectedItem();
            String location = tfLocation.getText();

            try {
                Connector conn = new Connector();
                String query = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"', '"+Available+"', '"+location+"')";
                
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Driver added successfully");

                setVisible(false);
                new AddDrivers();
            } catch (Exception ex) {
                
            }
        } else if ( e.getSource()==cancel ){
            setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
