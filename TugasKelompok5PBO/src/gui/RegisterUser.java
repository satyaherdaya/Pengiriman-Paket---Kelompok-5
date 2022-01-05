package gui;
import entity.PengirimEntity;
import entity.LoginEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class RegisterUser extends JFrame{
    JButton btnadduser = new JButton("Register User");
    JButton btnback = new JButton("<<back");
    JLabel labeljudul = new JLabel("Registrasi User");
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
    
    public RegisterUser() {
        initComponent();
    }
    void initComponent(){
        setTitle("REGISTRASI USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(120, 50, 130, 25);
        add(labeljudul);
        
        labelusername.setBounds(30, 100, 80, 25);
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
        
        btnadduser.setBounds(80, 350, 140, 25);
        btnadduser.setBackground(Color.black);
        btnadduser.setForeground(Color.white);
        btnadduser.setCursor(new Cursor(12));
        add(btnadduser);
        
        btnback.setBounds(30, 50, 70, 25);
        btnback.setBorder(null);
        btnback.setCursor(new Cursor(12));
        btnback.setBackground(Color.white);
        btnback.setForeground(Color.black);
        add(btnback);
        
        btnadduser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnadduser.setForeground(Color.blue);
                btnadduser.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnadduser.setForeground(Color.white);
                btnadduser.setBackground(Color.black);
            }
        });
        
        btnadduser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
                String password = tfpassword.getText();
                String nama = tfnama.getText();
                String alamat = tfalamat.getText();
                String noTelp = tfnotelp.getText();
                
                if(username.length()!=0 && password.length()!=0 && nama.length()!=0 && alamat.length()!=0 && noTelp.length()!=0){
                    AllObjController.pengirimController.insert(new PengirimEntity(new LoginEntity(username, password),nama, alamat, noTelp));
                    JOptionPane.showMessageDialog(null, "Akun Berhasil Dibuat");
                    new LoginUser().setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginUser().setVisible(true);
                dispose();
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
