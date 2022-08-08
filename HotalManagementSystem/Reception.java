package HotalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{

    JButton newCustomer, rooms, department, allEmployee, managerInfo, 
    custermers, searchRoom, status, roomStatus, checkout, pickup, records, logout;

    Reception(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer =  new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms =  new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        department =  new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allEmployee =  new JButton("All Employee");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        custermers =  new JButton("Customer Info");
        custermers.setBounds(10, 190, 200, 30);
        custermers.setBackground(Color.BLACK);
        custermers.setForeground(Color.WHITE);
        custermers.addActionListener(this);
        add(custermers);

        managerInfo =  new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout =  new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        status =  new JButton("Update Status");
        status.setBounds(10, 310, 200, 30);
        status.setBackground(Color.BLACK);
        status.setForeground(Color.WHITE);
        status.addActionListener(this);
        add(status);        

        roomStatus =  new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup =  new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup); 
        
        searchRoom =  new JButton("Search Room");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        records =  new JButton("Previous Records");
        records.setBounds(10, 470, 200, 30);
        records.setBackground(Color.BLACK);
        records.setForeground(Color.WHITE);
        records.addActionListener(this);
        add(records);

        logout =  new JButton("Logout"); 
        logout.setBounds(10, 510, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/recep.jpg"));
        // Image  i2 = i1.getImage().getScaledInstance(width, height, hints);
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);

        setBounds(350, 150, 800, 610);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newCustomer){
            setVisible(false);
            new CustumerForm();
        }
        else if(e.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(e.getSource()==department){
            setVisible(false);
            new Department();
        }
        else if(e.getSource()==allEmployee){
            setVisible(false);
            new Employee();
        }
        else if(e.getSource() == managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(e.getSource() == custermers){
            setVisible(false);
            new CustumerInfo();
        }
        else if(e.getSource() == searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(e.getSource() == status){
            setVisible(false);
            new UpdateCheck();
        }
        else if(e.getSource() == roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(e.getSource() == pickup){
            setVisible(false);
            new PickUp();
        }
        else if(e.getSource() == checkout){
            setVisible(false);
            new CheckOut();
        }
        else if(e.getSource() == records){
            setVisible(false);
            new Records();
        }

        else if(e.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }
        
    }
    public static void main(String[] args){
        new Reception();
    }
     
}
