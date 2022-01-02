package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MenuAdmin extends JFrame{
    JLabel labeljudul = new JLabel("MENU ADMIN");
    JButton btnaddadmin = new JButton("Register Admin");
    JButton btnviewtransaksi = new JButton("View Transaksi");
    JButton btnlogout = new JButton("<<Logout");
    JButton btnupdatepass = new JButton("Ubah Password");
    JButton btnviewadmin = new JButton("View Admin");
    
    public MenuAdmin(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("MENU ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(240, 60, 200, 25);
        labeljudul.setFont(new Font("Segoe Print",1,20));
        add(labeljudul);
        
        btnaddadmin.setBounds(140, 150, 140, 100);
        btnaddadmin.setCursor(new Cursor(12));
        btnaddadmin.setBackground(Color.black);
        btnaddadmin.setForeground(Color.white);
        add(btnaddadmin);
        
        btnviewtransaksi.setBounds(320, 150, 140, 100);
        btnviewtransaksi.setCursor(new Cursor(12));
        btnviewtransaksi.setBackground(Color.black);
        btnviewtransaksi.setForeground(Color.white);
        add(btnviewtransaksi);
        
        btnviewadmin.setBounds(140, 270, 140, 100);
        btnviewadmin.setCursor(new Cursor(12));
        btnviewadmin.setBackground(Color.black);
        btnviewadmin.setForeground(Color.white);
        add(btnviewadmin);
        
        btnupdatepass.setBounds(320, 270, 140, 100);
        btnupdatepass.setCursor(new Cursor(12));
        btnupdatepass.setBackground(Color.black);
        btnupdatepass.setForeground(Color.white);
        add(btnupdatepass);
        
        btnlogout.setBounds(25, 20, 80, 25);
        btnlogout.setBackground(Color.white);
        btnlogout.setCursor(new Cursor(12));
        btnlogout.setBorder(null);
        add(btnlogout);
        
        btnupdatepass.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
                    if(inputpass.length()>0){
                        AllObjController.adminController.updatePassword(cek,inputpass);
                        JOptionPane.showMessageDialog(null, "Berhasil Update Password");
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception exSatya){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnaddadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterAdmin(cek).setVisible(true);
                dispose();                
            }
        });
        
        btnlogout.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogout.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogout.setForeground(Color.black);
            }
        });
        
        btnlogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAdmin loginAdmin = new LoginAdmin();
                loginAdmin.setVisible(true);
                dispose();
            }
        });
        
        btnviewtransaksi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerifTransaksi(cek).setVisible(true);
                dispose();
            }
        });
        
        btnviewadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAdmin(cek).setVisible(true);
                dispose();
            }
        });
    
        btnupdatepass.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnupdatepass.setBackground(Color.white);
                btnupdatepass.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnupdatepass.setBackground(Color.black);
                btnupdatepass.setForeground(Color.white);
            }
        });
        
        btnaddadmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnaddadmin.setBackground(Color.white);
                btnaddadmin.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnaddadmin.setBackground(Color.black);
                btnaddadmin.setForeground(Color.white);
            }
        });
        
        btnviewtransaksi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnviewtransaksi.setBackground(Color.white);
                btnviewtransaksi.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnviewtransaksi.setBackground(Color.black);
                btnviewtransaksi.setForeground(Color.white);
            }
        });
        
        btnviewadmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnviewadmin.setBackground(Color.white);
                btnviewadmin.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnviewadmin.setBackground(Color.black);
                btnviewadmin.setForeground(Color.white);
            }
        });
    }
}
