package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class VerifTransaksi extends JFrame{
    private int kode;
    JButton btnaddadmin = new JButton("Register Admin");
    JButton btnverfpengiriman = new JButton("Ubah Status");  
    JButton btnback = new JButton("<<back");
    JTable tabelresi = new JTable();
    JScrollPane spresi = new JScrollPane(tabelresi);
    JTextField textpilih = new JTextField();
    
    public VerifTransaksi(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("VERIFIKASI TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        spresi.setBounds(20, 50, 1150, 350);
        tabelresi.setModel(AllObjController.resiController.dataResi());
        tabelresi.setDefaultEditor(Object.class, null);
        add(spresi);
        
        btnverfpengiriman.setBounds(1180, 50, 110, 25);
        btnverfpengiriman.setCursor(new Cursor(12));
        btnverfpengiriman.setBackground(Color.black);
        btnverfpengiriman.setForeground(Color.white);
        add(btnverfpengiriman);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
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
                new MenuAdmin(cek).setVisible(true);
                dispose();
            }
        });
    }
}
