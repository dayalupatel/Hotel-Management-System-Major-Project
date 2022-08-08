package HotalManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    Main() {
        setSize(1366, 565); // set size of frame
        setLocation(100, 100);  // location from top left of laptop
        // setBounds(100,100, 1366, 565); this line can replace above two lines
        setLayout(null);  // by default layout is null

       

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")); // added main image
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 800, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD, 50));
        image.add(text);



        JButton start = new JButton("START");
        start.setBounds(1150, 450, 150, 50);
        start.setFont(new Font("serif", Font.BOLD, 25));
        start.addActionListener(this);
        start.setBackground(Color.WHITE);
        image.add(start);

        

        setVisible(true);


        while(true) {

            text.setVisible(false);
            start.setBackground(Color.PINK);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // e.printStackTrace();
            }

            text.setVisible(true);
            text.setForeground(Color.GREEN);
            start.setBackground(Color.PINK);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // e.printStackTrace();
            }

            text.setVisible(false);
            start.setBackground(Color.CYAN);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // e.printStackTrace();
            }

            text.setVisible(true);
            text.setForeground(Color.CYAN);
            start.setBackground(Color.CYAN);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // e.printStackTrace();
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);  // Main menu will disappear
        new Login();          // login page will open
          
    }

    public static void main(String[] args) {
        new Main() ;
    }

}