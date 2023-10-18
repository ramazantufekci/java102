package com.otelyonetimi.View;

import com.otelyonetimi.Helper.Helper;
import com.otelyonetimi.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JScrollPane scrl_login;
    private JPanel pnl_login_logo;
    private JTextField fld_login_uname;
    private JPasswordField fld_login_pass;
    private JButton btn_login;

    public LoginGUI() {
        Helper.setLayout();
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_login_uname) || Helper.isFieldEmpty(fld_login_pass)){
                Helper.shwMsg("fill");
            }else{
                User u = User.getFetch(fld_login_uname.getText(),fld_login_pass.getText());
                if(u == null){
                    Helper.shwMsg("Kullanıcı Bulunamadı !");
                }else{
                    HomeGUI home = new HomeGUI(u);
                    dispose();
                }
            }

        });
    }

    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
    }
}
