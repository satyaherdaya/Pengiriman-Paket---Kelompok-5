package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuUser extends JFrame{
    JLabel labeljudul = new JLabel("MENU PENGIRIMAN BARANG");
    JButton btnantarpaket = new JButton("Kirim Paket");
    JButton btnviewtransaksi = new JButton("View Resi");
    JButton btnlogout = new JButton("<<Logout");
    JButton btnprofil = new JButton("Profil Anda");
    JButton btnupdatepass = new JButton("Ubah Password");
    
    public MenuUser(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("HOME MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(140, 60, 320, 25);
        labeljudul.setFont(new Font("Segoe Print",1,20));
        add(labeljudul);
        
        btnantarpaket.setBounds(140, 150, 140, 100);
        btnantarpaket.setCursor(new Cursor(12));
        btnantarpaket.setBackground(Color.black);
        btnantarpaket.setForeground(Color.white);
        add(btnantarpaket);
        
        btnviewtransaksi.setBounds(320, 150, 140, 100);
        btnviewtransaksi.setCursor(new Cursor(12));
        btnviewtransaksi.setBackground(Color.black);
        btnviewtransaksi.setForeground(Color.white);
        add(btnviewtransaksi);
        
        btnprofil.setBounds(140, 270, 140, 100);
        btnprofil.setCursor(new Cursor(12));
        btnprofil.setBackground(Color.black);
        btnprofil.setForeground(Color.white);
        add(btnprofil);
        
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
                        AllObjController.pengirimController.updatePassUser(cek,inputpass);
                        JOptionPane.showMessageDialog(null, "Berhasil Update Password");
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception exSatya){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnantarpaket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new KirimPaket(cek).setVisible(true);
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
                new LoginUser().setVisible(true);
                dispose();
            }
        });
        
        btnviewtransaksi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewResiPengirim(cek).setVisible(true);
                dispose();
            }
        });
        
        btnprofil.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfileUser(cek).setVisible(true);
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
        
        btnantarpaket.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnantarpaket.setBackground(Color.white);
                btnantarpaket.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnantarpaket.setBackground(Color.black);
                btnantarpaket.setForeground(Color.white);
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
        
        btnprofil.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnprofil.setBackground(Color.white);
                btnprofil.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnprofil.setBackground(Color.black);
                btnprofil.setForeground(Color.white);
            }
        });
    }
}
