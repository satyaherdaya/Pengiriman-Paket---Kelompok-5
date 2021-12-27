package gui;

import entity.AdminEntity;
import entity.LoginEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class RegisterAdmin extends JFrame{
    JButton btnaddadmin = new JButton("Register Admin");
    JButton btnback = new JButton("<<back");
    JLabel labeljudul = new JLabel("Registrasi Admin");
    JLabel labelusername = new JLabel("Username");
    JLabel labelpassword = new JLabel("Password");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelalamat = new JLabel("Alamat");
    JLabel labelnotelp = new JLabel("NoTelp");
    JTextField tfusername = new JTextField();
    JTextField tfpassword = new JTextField();
    JTextField tfnama = new JTextField();
    JTextField tfalamat = new JTextField();
    JTextField tfnotelp = new JTextField();
    
    public RegisterAdmin() {
        initComponent();
    }
    
    void initComponent(){
        setTitle("Register Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(120, 50, 130, 25);
        add(labeljudul);
        
        labelusername.setBounds(30, 100, 40, 25);
        add(labelusername);
        tfusername.setBounds(130, 100, 130, 25);
        add(tfusername);
        
        labelpassword.setBounds(30, 150, 80, 25);
        add(labelpassword);
        tfpassword.setBounds(130, 150, 130, 25);
        add(tfpassword);
        
        labelnama.setBounds(30,200,80,25);
        add(labelnama);
        tfnama.setBounds(130,200,130,25);
        add(tfnama);
        
        labelalamat.setBounds(30,250,80,25);
        add(labelalamat);
        tfalamat.setBounds(130,250,130,25);
        add(tfalamat);
        
        labelnotelp.setBounds(30,300,80,25);
        add(labelnotelp);
        tfnotelp.setBounds(130,300,130,25);
        add(tfnotelp);
        
        btnaddadmin.setBounds(80, 350, 140, 25);
        btnaddadmin.setBorder(null);
        btnaddadmin.setBackground(Color.black);
        btnaddadmin.setForeground(Color.white);
        btnaddadmin.setFocusPainted(false);
        add(btnaddadmin);
        
        btnback.setBounds(30, 50, 70, 25);
        btnback.setBorder(null);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setFocusPainted(false);
        add(btnback);
        
        btnaddadmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnaddadmin.setForeground(Color.black);
                btnaddadmin.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnaddadmin.setForeground(Color.white);
                btnaddadmin.setBackground(Color.black);
            }
        });
        
        btnaddadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
                String password = tfpassword.getText();
                String nama = tfnama.getText();
                String alamat = tfalamat.getText();
                String noTelp = tfnotelp.getText();
                
                if(username.length()!=0 && password.length()!=0 && nama.length()!=0 && alamat.length()!=0 && noTelp.length()!=0){
                    AllObjController.adminController.insert(new AdminEntity(new LoginEntity(username,password),nama,alamat,noTelp));
                    JOptionPane.showMessageDialog(null, nama + "adalah Admin");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
    
    void kosong(){
        tfusername.setText(null);
        tfpassword.setText(null);
        tfnama.setText(null);
        tfalamat.setText(null);
        tfnotelp.setText(null);
    }
}
