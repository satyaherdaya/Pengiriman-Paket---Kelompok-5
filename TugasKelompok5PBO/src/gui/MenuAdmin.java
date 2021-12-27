package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MenuAdmin extends JFrame{
    private int kode;
    JButton btnaddadmin = new JButton("Register Admin");
    JButton btnverfpengiriman = new JButton("Ubah Status");
    JButton btnlogout = new JButton("Lihat Data");
    JButton btnupdatepass = new JButton("Ubah Password");
    JButton btndeleteadmin = new JButton("Delete Admin");    
    JButton btnback = new JButton("<<back");
    JTable tabelresi = new JTable();
    JScrollPane spresi = new JScrollPane(tabelresi);
    JTextField textpilih = new JTextField();
    
    public MenuAdmin(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("PROGRAM VERIF MAHASISWA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        spresi.setBounds(20, 50, 1200, 350);
        tabelresi.setModel(AllObjController.resiController.dataResi());
        tabelresi.setDefaultEditor(Object.class, null);
        add(spresi);
        
        btnverfpengiriman.setBounds(1250, 50, 110, 25);
        btnverfpengiriman.setFocusPainted(false);
        btnverfpengiriman.setBorder(null);
        btnverfpengiriman.setCursor(new Cursor(12));
        btnverfpengiriman.setBackground(Color.black);
        btnverfpengiriman.setForeground(Color.white);
        add(btnverfpengiriman);
        
        btnupdatepass.setBounds(1250, 50, 110, 25);
        btnupdatepass.setFocusPainted(false);
        btnupdatepass.setBorder(null);
        btnupdatepass.setCursor(new Cursor(12));
        btnupdatepass.setBackground(Color.black);
        btnupdatepass.setForeground(Color.white);
        add(btnupdatepass);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnaddadmin.setBounds(1250, 100, 110, 25);
        btnaddadmin.setFocusPainted(false);
        btnaddadmin.setBorder(null);
        btnaddadmin.setCursor(new Cursor(12));
        btnaddadmin.setBackground(Color.black);
        btnaddadmin.setForeground(Color.white);
        add(btnaddadmin);
        
        btndeleteadmin.setBounds(1250, 100, 110, 25);
        btndeleteadmin.setFocusPainted(false);
        btndeleteadmin.setBorder(null);
        btndeleteadmin.setCursor(new Cursor(12));
        btndeleteadmin.setBackground(Color.black);
        btndeleteadmin.setForeground(Color.white);
        add(btndeleteadmin);
        
        tabelresi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelresi.getSelectedRow();
                textpilih.setText(AllObjController.resiController.dataResi().getValueAt(i, 0).toString());
            }
        });
        
        btnverfpengiriman.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjController.adminController.verifResi(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Verifikasi");
                tabelresi.setModel(AllObjController.resiController.dataResi());
            }
        });
        
        btndeleteadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNama = JOptionPane.showInputDialog("Masukkan Nama Admin yang akan di Hapus");
                    if(inputNama.length()>0){
                        AllObjController.adminController.delete(inputNama);
                        JOptionPane.showMessageDialog(null, "Berhasil Delete Admin");
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception exSatya){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAdmin loginAdmin = new LoginAdmin();
                loginAdmin.setVisible(true);
                dispose();
            }
        });
        
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
                RegisterAdmin registerAdmin =  new RegisterAdmin();
                registerAdmin.setVisible(true);
                dispose();                
            }
        });
    }
}
