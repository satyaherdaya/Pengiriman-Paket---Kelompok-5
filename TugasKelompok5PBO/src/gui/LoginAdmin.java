package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class LoginAdmin extends JFrame{
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
    JTextField tfpassword = new JTextField();

    public LoginAdmin() {
        initComponent();
    }
    
    void initComponent(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelusername.setBounds(35, 250, 40, 25);
        add(labelusername);
        tfusername.setBounds(130, 250, 130, 25);
        add(tfusername);
        
        labelpassword.setBounds(35,290,100,25);
        add(labelpassword);
        tfpassword.setBounds(130,290,130,25);
        add(tfpassword);
        
        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);
        
        btnloginuser.setBounds(0, 405, 20, 20);
        btnloginuser.setBorder(null);
        btnloginuser.setBackground(Color.black);
        add(btnloginuser);
        
        btnloginuser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnloginuser.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnloginuser.setForeground(Color.black);
            }
        });
        
        btnloginuser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new LoginUser().setVisible(true);
            }
        });
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
                String password = tfpassword.getText();
                int cek = AllObjController.adminController.cekLogin(username, password);
                
                if(cek>0){
                    dispose();
                    MenuAdmin menuadmin = new MenuAdmin(cek);
                    menuadmin.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
    
    void kosong(){
        tfusername.setText(null);
        tfpassword.setText(null);
    }
}
