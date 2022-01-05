package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LoginAdmin extends JFrame{
    BufferedImage bufferedImage = null;
    Image gambarresize;
    String pathicon;
    JButton btnlogin = new JButton("Login");
    JButton btnregister = new JButton("Regis");
    JButton btnloginadmin = new JButton();
    JButton btnloginuser = new JButton();
    JButton btnupdatenama = new JButton("ubah");
    JButton btnupdatealamat = new JButton("ubah");
    JButton btnupdatenotelp = new JButton("ubah");
    JLabel labelusername = new JLabel("Username");
    JLabel labelpassword = new JLabel("Password");
    JLabel labelbingkai = new JLabel();
    JTextField tfusername = new JTextField();
    JPasswordField pfpassword = new JPasswordField();

    public LoginAdmin() {
        initComponent();
    }
    
    void initComponent(){
        setTitle("LOGIN ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelusername.setBounds(35, 250, 80, 25);
        add(labelusername);
        tfusername.setBounds(130, 250, 130, 25);
        add(tfusername);
        
        labelpassword.setBounds(35,290,100,25);
        add(labelpassword);
        pfpassword.setBounds(130,290,130,25);
        add(pfpassword);
        
        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setCursor(new Cursor(12));
        add(btnlogin);
        
        btnloginuser.setBounds(0, 405, 20, 20);
        btnloginuser.setBorder(null);
        btnloginuser.setBackground(Color.black);
        add(btnloginuser);

        labelbingkai.setBounds(80, 70, 150, 150);
        add(labelbingkai);
        
        pathicon = "./src/image/merah.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginUser.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        labelbingkai.setIcon(new ImageIcon(gambarresize));
        
        btnloginuser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnloginuser.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnloginuser.setForeground(Color.black);
            }
        });
        
        btnloginuser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new LoginUser().setVisible(true);
            }
        });
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
                String password = pfpassword.getText();
                int cek = AllObjController.adminController.cekLogin(username, password);
                
                if(cek>0){
                    dispose();
                    MenuAdmin menuadmin = new MenuAdmin(cek);
                    menuadmin.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
    
    void kosong(){
        tfusername.setText(null);
        pfpassword.setText(null);
    }
}
