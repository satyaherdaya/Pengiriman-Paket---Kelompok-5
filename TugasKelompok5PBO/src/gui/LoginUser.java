package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class LoginUser extends JFrame{
    private ComponentGui cg = new ComponentGui();
    
    public LoginUser() {
    }
    
    void initComponent(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        cg.labelusername.setBounds(35, 250, 40, 25);
        add(cg.labelusername);
        cg.tfusername.setBounds(130, 250, 130, 25);
        add(cg.tfusername);
        
        cg.labelpassword.setBounds(35,290,100,25);
        add(cg.labelpassword);
        cg.tfpassword.setBounds(130,290,130,25);
        add(cg.tfpassword);
        
        cg.btnlogin.setBounds(110, 350, 100, 25);
        cg.btnlogin.setBackground(Color.black);
        cg.btnlogin.setForeground(Color.white);
        cg.btnlogin.setBorder(null);
        add(cg.btnlogin);
        
        cg.btnloginadmin.setBounds(0, 405, 20, 20);
        cg.btnloginadmin.setBorder(null);
        cg.btnloginadmin.setBackground(Color.black);
        add(cg.btnloginadmin);
        
        cg.btnloginadmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                cg.btnloginadmin.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                cg.btnloginadmin.setForeground(Color.black);
            }
        });
        
        cg.btnloginadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new LoginAdmin().setVisible(true);
            }
        });
        
        cg.btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = cg.tfusername.getText();
                String password = cg.tfpassword.getText();
                int cek = AllObjController.pengirimController.cekLogin(username, password);
                
                if(cek>0){
                    dispose();
                    MenuUser menuuser = new MenuUser(cek);
                    menuuser.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    cg.kosong();
                }
            }
        });
    }
}
