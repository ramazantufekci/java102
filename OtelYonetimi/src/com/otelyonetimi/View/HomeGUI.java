package com.otelyonetimi.View;

import com.otelyonetimi.Helper.Helper;
import com.otelyonetimi.Helper.Item;
import com.otelyonetimi.Helper.HotelType;
import com.otelyonetimi.Model.User;

import javax.swing.*;

public class HomeGUI extends JFrame{
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JTextField fld_period_bsl;
    private JTextField fld_period_bts;
    private JTextField fld_period_price;
    private JButton btn_ekle;
    private JComboBox cmb_pansiyon_type;
    private ImageIcon icon;

    public HomeGUI(User u) {
        Helper.setLayout();
        add(wrapper);
        setSize(1000,600);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        icon = new ImageIcon("image/icon.png");
        setIconImage(icon.getImage());
        HotelType[] deneme = HotelType.values();
        System.out.println(deneme.length);




    }

}
