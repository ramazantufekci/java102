package com.drn.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setLayout(){
         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
             if("Nimbus".equals(info.getName())){
                 try {
                     UIManager.setLookAndFeel(info.getClassName());
                 } catch (ClassNotFoundException e) {
                     throw new RuntimeException(e);
                 } catch (InstantiationException e) {
                     throw new RuntimeException(e);
                 } catch (IllegalAccessException e) {
                     throw new RuntimeException(e);
                 } catch (UnsupportedLookAndFeelException e) {
                     throw new RuntimeException(e);
                 }
                 break;
             }
         }
    }
    public static int screenCenter(String eksen, Dimension size){
        int point = 0;
        switch (eksen){
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width-size.width)/2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height-size.height)/2;
            default:
                point = 0;
        }
        return point;

    }

    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();

    }

    public static void shwMsg(String str){
        String msg;
        String title;
        switch (str){
            case "fill":
                msg = "Lütfen Tüm alanları doldurunuz";
                title = "Hata";
                break;
            case "done":
                msg="İşlem Başarılı";
                title="Mesaj";
                break;
            case "error":
                msg="Bir Hata Oluştu !";
                title="Mesaj";
                break;
            default:
                msg = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }

    public static void optionPageTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");

    }

    public static boolean confirm(String str){
        optionPageTR();
        String msg;
        switch (str){
            case "sure":
                msg = "Bu işlemi gerçekleştirmek istediğinize emin misiniz?";
                break;
            default:
                msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Son Kararın :Mı?",JOptionPane.YES_NO_OPTION)==0;
    }


}
