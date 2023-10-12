package com.drn.View;

import com.drn.Helper.Config;
import com.drn.Helper.Helper;
import com.drn.Model.Operator;
import com.drn.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_name;
    private JPasswordField fld_user_pass;
    private JButton btn_login;

    public LoginGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_name)||Helper.isFieldEmpty(fld_user_pass)){
                Helper.shwMsg("fill");
            }else{
                User u = User.getFetch(fld_user_name.getText(),fld_user_pass.getText());
                if(u == null){
                    Helper.shwMsg("Kullanıcı Bulunamadı !");
                }else{
                    switch (u.getType()){
                        case "operator":
                            OperatorGUI opGUI = new OperatorGUI((Operator) u);
                            break;
                        case "educator":
                            EducatorGUI eduGUI = new EducatorGUI(u);
                            break;
                        case "student":
                            StudentGUI stuGUI = new StudentGUI();
                            break;
                    }
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI login = new LoginGUI();
    }
}
