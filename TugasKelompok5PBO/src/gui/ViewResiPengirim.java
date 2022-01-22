package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ViewResiPengirim extends JFrame{
    private int kode;
    JButton btnaddadmin = new JButton("Register Admin");
    JButton btnback = new JButton("<<back");
    JTable tabelresi = new JTable();
    JScrollPane spresi = new JScrollPane(tabelresi);
    JTextField textpilih = new JTextField();
    
    public ViewResiPengirim(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("VERIFIKASI TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        spresi.setBounds(20, 50, 1300, 350);
        tabelresi.setModel(AllObjController.resiController.dataResi(cek));
        tabelresi.setDefaultEditor(Object.class, null);
        add(spresi);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
        tabelresi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelresi.getSelectedRow();
                textpilih.setText(AllObjController.resiController.dataResi(cek).getValueAt(i, 0).toString());
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
}
