package gui;

import entity.LoginEntity;
import entity.PaketEntity;
import entity.PenerimaEntity;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class KirimPaket extends JFrame{
    String[] hari = {"Pilih Waktu Berangkat..","Same Day", "1-3 Hari","5 Hari"};
    String waktuberangkat;
    JButton btnaddkirimpaket = new JButton("Kirim Paket");
    JButton btnback = new JButton("<<back");
    JLabel labeljudul = new JLabel("Kirim Paket");
    JLabel labelnamapaket = new JLabel("Nama Paket");
    JLabel labelberatpaket = new JLabel("Berat Paket");
    JLabel labelnama = new JLabel("Nama Penerima");
    JLabel labelalamat = new JLabel("Alamat Penerima");
    JLabel labelnotelp = new JLabel("NoTelp Penerima");
    JLabel labelberangkat = new JLabel("Estimasi Sampai");
    JTextField tfnamapaket = new JTextField();
    JTextField tfberatpaket = new JTextField();
    JTextField tfnama = new JTextField();
    JTextField tfalamat = new JTextField();
    JTextField tfnotelp = new JTextField();
    JComboBox cbberangkat = new JComboBox(hari);
    
    public KirimPaket(int cek) {
        initComponent(cek);
    }
    
    
    
    void initComponent(int cek){
         setTitle("REGISTRASI PAKET");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(120, 50, 130, 25);
        add(labeljudul);
        
        labelnamapaket.setBounds(30, 100, 80, 25);
        add(labelnamapaket);
        tfnamapaket.setBounds(130, 100, 130, 25);
        add(tfnamapaket);
        
        labelberatpaket.setBounds(30, 150, 80, 25);
        add(labelberatpaket);
        tfberatpaket.setBounds(130, 150, 130, 25);
        add(tfberatpaket);
        
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
        
        labelberangkat.setBounds(30,350,80,25);
        add(labelberangkat);
        cbberangkat.setBounds(130,350,160,25);
        add(cbberangkat);
        
        btnaddkirimpaket.setBounds(80, 400, 140, 25);
        btnaddkirimpaket.setBackground(Color.black);
        btnaddkirimpaket.setForeground(Color.white);
        btnaddkirimpaket.setCursor(new Cursor(12));
        add(btnaddkirimpaket);
        
        btnback.setBounds(30, 50, 70, 25);
        btnback.setBorder(null);
        btnback.setCursor(new Cursor(12));
        btnback.setBackground(Color.white);
        btnback.setForeground(Color.black);
        add(btnback);
        
        btnaddkirimpaket.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnaddkirimpaket.setForeground(Color.blue);
                btnaddkirimpaket.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnaddkirimpaket.setForeground(Color.white);
                btnaddkirimpaket.setBackground(Color.black);
            }
        });
        
        btnaddkirimpaket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String namapaket = tfnamapaket.getText();
                int beratpaket = Integer.parseInt(tfberatpaket.getText());
                String nama = tfnama.getText();
                String alamat = tfalamat.getText();
                String noTelp = tfnotelp.getText();
                if(cbberangkat.getSelectedIndex()==1){
                    waktuberangkat = hari[1];
                }else if(cbberangkat.getSelectedIndex()==2){
                    waktuberangkat = hari[2];
                }else if(cbberangkat.getSelectedIndex()==3){
                    waktuberangkat = hari[3];
                }
                if(namapaket.length()!=0 && beratpaket!=0 && nama.length()!=0 && alamat.length()!=0 && noTelp.length()!=0){
                    AllObjController.paketController.insertData(new PaketEntity(namapaket,beratpaket));
                    AllObjController.penerimaController.insertPenerima(new PenerimaEntity(nama,alamat,noTelp));
                    AllObjController.resiController.insertData(AllObjController.pengirimController.getPengirim(cek), new PenerimaEntity(nama,alamat,noTelp), new PaketEntity(namapaket,beratpaket),waktuberangkat);
                    JOptionPane.showMessageDialog(null, "Paket Telah TErdata");
                    new MenuUser(cek).setVisible(true);
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
                new MenuUser(cek).setVisible(true);
                dispose();
            }
        });
    }
    
    void kosong(){
        tfnamapaket.setText(null);
        tfberatpaket.setText(null);
        tfnama.setText(null);
        tfalamat.setText(null);
        tfnotelp.setText(null);
    }
    
}
