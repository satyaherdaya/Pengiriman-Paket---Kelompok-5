package gui;

import controller.AmbilSatuData;
import entity.AdminEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class UpdateDataAdmin extends JFrame{
    JButton btnback = new JButton("<<back");
    JLabel labeljudul = new JLabel("Ubah Data Admin");
    JLabel labelid = new JLabel("Id");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelalamat = new JLabel("Alamat");
    JLabel labelnotelp = new JLabel("NoTelp");
    JTextField tfid = new JTextField();
    JTextField tfnama = new JTextField();
    JTextField tfalamat = new JTextField();
    JTextField tfnotelp = new JTextField();
    JButton btnupdatenama = new JButton("Ubah");
    JButton btnupdatealamat = new JButton("Ubah");
    JButton btnupdatenotelp = new JButton("Ubah");
    
    int id;
    String nama,alamat,notelp;
    
    AmbilSatuData<AdminEntity> ambilSatuData = AllObjController.adminController;
    
    public UpdateDataAdmin(int cek) {
        initComponent(cek);
    }
    void initComponent(int cek){
        for(AdminEntity admin : ambilSatuData.ambilSatuData(cek)){
            this.id=admin.getId();
            this.nama=admin.getNama();
            this.alamat=admin.getAlamat();
            this.notelp=admin.getNoTelp();
        }
        
        setTitle("UPDATE DATA ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(120, 50, 130, 25);
        add(labeljudul);
        
        labelid.setBounds(30,100,80,25);
        add(labelid);
        tfid.setBounds(100,100,130,25);
        tfid.setText(Integer.toString(id));
        tfid.setEditable(false);
        add(tfid);
        
        labelnama.setBounds(30,150,80,25);
        add(labelnama);
        tfnama.setBounds(100,150,130,25);
        tfnama.setText(nama);
        tfnama.setEditable(false);
        add(tfnama);
        
        labelalamat.setBounds(30,200,80,25);
        add(labelalamat);
        tfalamat.setBounds(100,200,130,25);
        tfalamat.setText(alamat);
        tfalamat.setEditable(false);
        add(tfalamat);
        
        labelnotelp.setBounds(30,250,80,25);
        add(labelnotelp);
        tfnotelp.setBounds(100,250,130,25);
        tfnotelp.setText(notelp);
        tfnotelp.setEditable(false);
        add(tfnotelp);
        
        btnupdatenama.setBounds(240, 150, 80, 25);
        btnupdatenama.setCursor(new Cursor(12));
        btnupdatealamat.setBounds(240, 200, 80, 25);
        btnupdatealamat.setCursor(new Cursor(12));
        btnupdatenotelp.setBounds(240, 250, 80, 25);
        btnupdatenotelp.setCursor(new Cursor(12));
        add(btnupdatenama);
        add(btnupdatealamat);
        add(btnupdatenotelp);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
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
                new ViewAdmin(cek).setVisible(true);
                dispose();
            }
        });
        
        btnupdatenama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputNama = JOptionPane.showInputDialog("Masukkan Nama Baru");
                    if(inputNama.length()>0){
                        AllObjController.adminController.updateNama(cek,inputNama);
                        tfnama.setText(inputNama);
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception exSatya){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnupdatealamat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputAlamat = JOptionPane.showInputDialog("Masukkan NPM Baru");
                    if(inputAlamat.length()>0){
                        AllObjController.adminController.updateAlamat(cek,inputAlamat);
                        tfalamat.setText(inputAlamat);
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception exSatya){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnupdatenotelp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputNoTelp = JOptionPane.showInputDialog("Masukkan Nomor Telepon Baru");
                    if(inputNoTelp.length()>0){
                        AllObjController.adminController.updateNoTelp(cek,inputNoTelp);
                        tfnotelp.setText(inputNoTelp);
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception exSatya){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
    }
}
