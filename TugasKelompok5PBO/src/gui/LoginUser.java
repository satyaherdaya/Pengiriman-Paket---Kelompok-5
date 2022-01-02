package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class LoginUser extends JFrame{
    JButton btnlogin = new JButton("Login");
    JButton btnregister = new JButton("Regis");
    JButton btnloginadmin = new JButton();
    JButton btnloginuser = new JButton();
    JButton btnupdatenama = new JButton("ubah");
    JButton btnupdatealamat = new JButton("ubah");
    JButton btnupdatenotelp = new JButton("ubah");
    JLabel labelusername = new JLabel("Username");
    JLabel labelpassword = new JLabel("Password");
    JTextField tfusername = new JTextField();
    JPasswordField pfpassword = new JPasswordField();
    
    public LoginUser() {
        initComponent();
    }
    
    void initComponent(){
        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelusername.setBounds(35, 250, 80, 25);
        add(labelusername);
        tfusername.setBounds(130, 250, 130, 25);
        add(tfusername);
        
        labelpassword.setBounds(35,290,100,25);
        add(labelpassword);
        pfpassword.setBounds(130,290,130,25);
        add(pfpassword);
        
        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setCursor(new Cursor(12));
        add(btnlogin);
        
        btnloginadmin.setBounds(0, 405, 20, 20);
        btnloginadmin.setBorder(null);
        btnloginadmin.setBackground(Color.black);
        add(btnloginadmin);
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });

        btnloginadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new LoginAdmin().setVisible(true);
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
                String password = pfpassword.getText();
                int cek = AllObjController.pengirimController.cekLogin(username, password);
                if(cek>0){
                    dispose();
                    MenuUser menuuser = new MenuUser(cek);
                    menuuser.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
    
    void kosong(){
        tfusername.setText(null);
        pfpassword.setText(null);
    }
}
