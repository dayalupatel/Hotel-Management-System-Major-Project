package HotalManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    Login() {

        getContentPane().setBackground(Color.white);

        setBounds(450, 270, 600, 300);

        setLayout(null);

        setBackground(Color.WHITE);
        // ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/loginback.jpg"));
        // // Image i5 = i4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // to scalling image (awt)
        // // ImageIcon i6 = new ImageIcon(i5);  // i2 can't be passed in JLabel so again converting to ImageIcon
        // JLabel im = new JLabel(i4);
        // im.setBounds(100, 0, 600, 300);
        // add(im);


        JLabel user = new JLabel("Username : ");
        user.setBounds(40, 20, 100, 30);
        user.setFont(new Font("serif", Font.BOLD, 18));
        add(user);

        JLabel pass = new JLabel("Password : ");
        pass.setBounds(40, 70, 100, 30);
        pass.setFont(new Font("serif", Font.BOLD, 18));
        add(pass);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);




        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(210, 150, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // to scalling image (awt)
        ImageIcon i3 = new ImageIcon(i2);  // i2 can't be passed in JLabel so again converting to ImageIcon
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);


        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String user = username.getText();
            char[] passChar = password.getPassword();
            String pass = new String(passChar);
            
            try {
                Connector c = new Connector();

                String query = "select * from login_info where username = '" + user + "' and password = '" + pass + "'";

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next() == true){
                    setVisible(false);
                    new DashBoard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    // setVisible(false);
                }
            } catch (Exception ae) {
                
            }
        } else if(e.getSource() == cancel){
            setVisible(false);
        }
        
    }
}
