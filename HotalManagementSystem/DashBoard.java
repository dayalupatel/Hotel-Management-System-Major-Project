package HotalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener {
    public static void main(String[] args) {
      new DashBoard();  
    }
    DashBoard() {
        setBounds(0, 0, 1550, 900);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel_view.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 900);
        add(image);


        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.BOLD, 46));
        text.setForeground(Color.BLUE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 50);
        mb.setBackground(Color.BLACK);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setFont(new Font("Serif",Font.BOLD,22));
        hotel.setForeground(Color.WHITE);
        hotel.setBounds(5, 2, 150, 50);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setFont(new Font("Tahoma",Font.BOLD,20));
        reception.setForeground(Color.BLUE);
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.WHITE);
        admin.setFont(new Font("Serif",Font.BOLD,22));
        // admin.setBounds(500, 0, 150, 50);
        mb.add(admin);

        JMenuItem addEmployee = new JMenuItem("Add New Employee");
        addEmployee.setFont(new Font("Tahoma",Font.PLAIN,20));
        addEmployee.setForeground(Color.RED);
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addRooms = new JMenuItem("Add New Rooms");
        addRooms.setFont(new Font("Tahoma",Font.PLAIN,20));
        addRooms.setForeground(Color.DARK_GRAY);
        addRooms.addActionListener(this);
        admin.add(addRooms);

        JMenuItem addDriver = new JMenuItem("Add A Driver");
        addDriver.setFont(new Font("Tahoma",Font.PLAIN,20));
        addDriver.setForeground(Color.BLUE);
        addDriver.addActionListener(this);
        admin.add(addDriver);

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add New Employee")){
            new AddEmployee(); 
        }
        else if(e.getActionCommand().equals("Add New Rooms")){
            new AddRooms();
        }
        else if(e.getActionCommand().equals("Add A Driver")){
            new AddDrivers();
        }
        else if(e.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }


}
