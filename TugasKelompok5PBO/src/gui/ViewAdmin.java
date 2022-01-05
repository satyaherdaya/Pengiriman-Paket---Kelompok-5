package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ViewAdmin extends JFrame{
    private int kode;
    JButton btnaddadmin = new JButton("Register Admin");
    JButton btnupdate = new JButton("Ubah Data");
    JButton btnlogout = new JButton("Lihat Data");
    JButton btndeleteadmin = new JButton("Delete Admin");    
    JButton btnback = new JButton("<<back");
    JTable tabelresi = new JTable();
    JScrollPane spresi = new JScrollPane(tabelresi);
    JTextField textpilih = new JTextField();

    public ViewAdmin(int cek) {
        initComponent(cek);
    }    
    
    void initComponent(int cek){
        setTitle("VIEW ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        spresi.setBounds(20, 50, 500, 350);
        tabelresi.setModel(AllObjController.adminController.dataAdmin());
        tabelresi.setDefaultEditor(Object.class, null);
        add(spresi);
        
        btnupdate.setBounds(550, 50, 110, 25);
        btnupdate.setCursor(new Cursor(12));
        btnupdate.setBackground(Color.black);
        btnupdate.setForeground(Color.white);
        add(btnupdate);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
        btndeleteadmin.setBounds(550, 100, 110, 25);
        btndeleteadmin.setCursor(new Cursor(12));
        btndeleteadmin.setBackground(Color.black);
        btndeleteadmin.setForeground(Color.white);
        add(btndeleteadmin);
        
        tabelresi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelresi.getSelectedRow();
                textpilih.setText(AllObjController.adminController.dataAdmin().getValueAt(i, 0).toString());
            }
        });
        
        btnupdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                new UpdateDataAdmin(kode).setVisible(true);
                dispose();
            }
        });
        
        btndeleteadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjController.adminController.delete(kode);
                tabelresi.setModel(AllObjController.adminController.dataAdmin());
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
