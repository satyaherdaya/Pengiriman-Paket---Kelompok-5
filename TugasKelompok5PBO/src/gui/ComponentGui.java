package gui;

import javax.swing.*;

public class ComponentGui extends JFrame{
    JButton btnlogin = new JButton("Login");
    JButton btnregister = new JButton("Regis");
    JButton btnupdate = new JButton("Ubah Data");
    JButton btnview = new JButton("Lihat Data");
    JButton btnupdatepass = new JButton("Ubah Password");
    JButton btnloginadmin = new JButton();
    JButton btnloginuser = new JButton();
    JButton btnback = new JButton();
    
    JButton btnupdatenama = new JButton("ubah");
    JButton btnupdatealamat = new JButton("ubah");
    JButton btnupdatenotelp = new JButton("ubah");

    JLabel labelid = new JLabel("Id");
    JLabel labelusername = new JLabel("Username");
    JLabel labelpassword = new JLabel("Password");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelalamat = new JLabel("Alamat");
    JLabel labelnotelp = new JLabel("NoTelp");
    JLabel labelidpaket = new JLabel("Id");    
    JLabel labelnamapaket = new JLabel("Nama");
    JLabel labelberatpaket = new JLabel("Berat");
    JLabel labelnoresi = new JLabel("Nomor Resi");
    JLabel labelwaktuberangkat = new JLabel("Waktu Berangkat");
    JLabel labelwaktusampai = new JLabel("Waktu Sampai");
    JLabel labelstatus = new JLabel("status");
    
    JTextField tfid = new JTextField();
    JTextField tfusername = new JTextField();
    JTextField tfpassword = new JTextField();
    JTextField tfnama = new JTextField();
    JTextField tfalamat = new JTextField();
    JTextField tfnotelp = new JTextField();
    JTextField tfidpaket = new JTextField();    
    JTextField tfnamapaket = new JTextField();
    JTextField tfberatpaket = new JTextField();
    JTextField tfnoresi = new JTextField();
    JTextField tfwaktuberangkat = new JTextField();
    JTextField tfwaktusampai = new JTextField();
    JTextField tfstatus = new JTextField();
    
    void kosong(){
        tfid.setText(null);
        tfnama.setText(null);
        tfalamat.setText(null);
        tfnotelp.setText(null);
        tfidpaket.setText(null);
        tfnamapaket.setText(null);
        tfberatpaket.setText(null);
        tfnoresi.setText(null);
        tfwaktuberangkat.setText(null);
        tfwaktusampai.setText(null);
        tfstatus.setText(null);
    }
}
