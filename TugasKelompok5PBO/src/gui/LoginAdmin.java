package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class LoginAdmin extends JFrame{
    private ComponentGui cg = new ComponentGui();

    public LoginAdmin() {
        initComponent();
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
        
        cg.btnloginuser.setBounds(0, 405, 20, 20);
        cg.btnloginuser.setBorder(null);
        cg.btnloginuser.setBackground(Color.black);
        add(cg.btnloginuser);
        
        cg.btnloginuser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                cg.btnloginuser.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                cg.btnloginuser.setForeground(Color.black);
            }
        });
        
        cg.btnloginuser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new LoginUser().setVisible(true);
            }
        });
        
        cg.btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                cg.btnlogin.setForeground(Color.black);
                cg.btnlogin.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                cg.btnlogin.setForeground(Color.white);
                cg.btnlogin.setBackground(Color.black);
            }
        });
        
        cg.btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = cg.tfusername.getText();
                String password = cg.tfpassword.getText();
                int cek = AllObjController.adminController.cekLogin(username, password);
                
                if(cek>0){
                    dispose();
                    MenuAdmin menuadmin = new MenuAdmin(cek);
                    menuadmin.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    cg.kosong();
                }
            }
        });
    }
}
