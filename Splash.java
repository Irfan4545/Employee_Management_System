package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    JButton back;
    Splash()
    {
        // Set the title of the JFrame
        setTitle("Employee Management System");

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,950,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,950);
        add(image);

        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(230,200,1400,200);
        heading.setFont(new Font("serif",Font.ITALIC,70));
        heading.setForeground(Color.RED);
        image.add(heading);

        JButton back=new JButton("CLICK ME TO CONTINUE");
        back.setBounds(600,700,300,50);
        back.setBackground(Color.decode("#000000"));
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        setSize(1550,950);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);


        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }
    public static void main(String[] args)
    {
        new Splash();
    }
}

