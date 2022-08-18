package HotalManagementSystem;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField forName, forAge, forEmail, forPhone, forSalary, forAadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox<String> cbJob;
    AddEmployee() {

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        setBounds(350, 200, 850, 540);


        JLabel name = new JLabel("NAME : ");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("serif", Font.PLAIN, 17));
        add(name);

        forName = new JTextField();
        forName.setBounds(200, 30, 150, 30);
        add(forName);

        JLabel age = new JLabel("AGE : ");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("serif", Font.PLAIN, 17));
        add(age);

        forAge = new JTextField();
        forAge.setBounds(200, 80, 150, 30);
        add(forAge);

        JLabel gender = new JLabel("GENDER : ");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("serif", Font.PLAIN, 17));
        add(gender);

        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 130, 70,30);
        rbmale.setFont(new Font("serif", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(270, 130, 100,30);
        rbfemale.setFont(new Font("serif", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);


        JLabel job = new JLabel("JOB : ");
        job.setBounds(60,170,120,30);
        job.setFont(new Font("serif", Font.PLAIN, 17));
        add(job);

        String str[] = {"Front Desk Clerk", "Porters", "Guard", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant"};
        cbJob = new JComboBox<>(str);
        cbJob.setBounds(200,180,150,30);
        cbJob.setBackground(Color.WHITE);
        add(cbJob);

        JLabel salary = new JLabel("SALARY : ");
        salary.setBounds(60,220,120,30);
        salary.setFont(new Font("serif", Font.PLAIN, 17));
        add(salary);

        forSalary = new JTextField();
        forSalary.setBounds(200, 220, 150, 30);
        add(forSalary);

        JLabel phone = new JLabel("PHONE : ");
        phone.setBounds(60,270,120,30);
        phone.setFont(new Font("serif", Font.PLAIN, 17));
        add(phone);

        forPhone = new JTextField();
        forPhone.setBounds(200, 270, 150, 30);
        add(forPhone);


        JLabel email = new JLabel("EMAIL : ");
        email.setBounds(60,320,120,30);
        email.setFont(new Font("serif", Font.PLAIN, 17));
        add(email);

        forEmail = new JTextField();
        forEmail.setBounds(200, 320, 150, 30);
        add(forEmail);

        JLabel aadhar = new JLabel("AADHAR : ");
        aadhar.setBounds(60,370,120,30);
        aadhar.setFont(new Font("serif", Font.PLAIN, 17));
        add(aadhar);

        forAadhar = new JTextField();
        forAadhar.setBounds(200, 370, 150, 30);
        add(forAadhar);


        submit = new JButton("SUBMIT");
        submit.setBounds(200, 430, 150, 30);
        submit.setFont(new Font("serif", Font.PLAIN, 17));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/employ.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = forName.getText();
        String age = forAge.getText();
        String salary = forSalary.getText();
        String email = forEmail.getText();
        String phone = forPhone.getText();
        String aadhar = forAadhar.getText();

        String gender = null;

        if(rbmale.isSelected()){
            gender = "Male";
        }
        else if(rbfemale.isSelected()){
            gender = "Female";
        }

        String job = (String) cbJob.getSelectedItem();

        try {
            Connector conn = new Connector();

            String query = "insert into employee values( '"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"' )";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee added successfully");

            setVisible(false);
            new AddEmployee();

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
    
}
