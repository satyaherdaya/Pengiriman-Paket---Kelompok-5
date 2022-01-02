package gui;

import entity.PengirimEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateDataUser extends JFrame{
    JButton btnaddadmin = new JButton("Register Admin");
    JButton btnback = new JButton("<<back");
    JLabel labeljudul = new JLabel("Registrasi Admin");
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

    public UpdateDataUser(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        for(PengirimEntity pengirim : AllObjController.pengirimController.getData(cek)){
            this.id=pengirim.getId();
            this.nama=pengirim.getNama();
            this.alamat=pengirim.getAlamat();
            this.notelp=pengirim.getNoTelp();
        }
        
        setTitle("ZUPDATE DATA USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(120, 50, 130, 25);
        add(labeljudul);
        
        labelid.setBounds(30,100,80,25);
        add(labelid);
        tfid.setBounds(130,100,130,25);
        tfid.setText(Integer.toString(id));
        tfid.setEditable(false);
        add(tfid);
        
        labelnama.setBounds(30,150,80,25);
        add(labelnama);
        tfnama.setBounds(130,150,130,25);
        tfnama.setText(nama);
        tfnama.setEditable(false);
        add(tfnama);
        
        labelalamat.setBounds(30,200,80,25);
        add(labelalamat);
        tfalamat.setBounds(130,200,130,25);
        tfalamat.setText(alamat);
        tfalamat.setEditable(false);
        add(tfalamat);
        
        labelnotelp.setBounds(30,250,80,25);
        add(labelnotelp);
        tfnotelp.setBounds(130,250,130,25);
        tfnotelp.setText(notelp);
        tfnotelp.setEditable(false);
        add(tfnotelp);
        
        btnupdatenama.setBounds(260, 150, 80, 25);
        btnupdatealamat.setBounds(260, 200, 80, 25);
        btnupdatenotelp.setBounds(260, 250, 80, 25);
        add(btnupdatenama);
        add(btnupdatealamat);
        add(btnupdatenotelp);
        
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
