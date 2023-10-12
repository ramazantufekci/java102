package com.drn.View;

import com.drn.Helper.Config;
import com.drn.Helper.Helper;
import com.drn.Helper.Item;
import com.drn.Model.Content;
import com.drn.Model.Course;
import com.drn.Model.Quiz;
import com.drn.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wcontent;
    private JTable tbl_educator_course;
    private JPanel pnl_educator_add;
    private JTextField fld_content_title;
    private JTextField fld_content_desc;
    private JTextField fld_content_link;
    private JComboBox cmb_content_quiz;
    private JComboBox cmb_content_course;
    private JButton btn_add;
    private JPanel pnl_educator_filter;
    private JTextField fld_educator_ders;
    private JTextField fld_educator_title;
    private JButton btn_educator_search;
    private DefaultTableModel mdl_educator_course;
    private Object[] row_educator_course;

    public EducatorGUI(User user) {
        Helper.setLayout();
        add(wrapper);
        setSize(1000, 600);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        mdl_educator_course = new DefaultTableModel();
        Object[] col_educator_course = {"ID","Ders Adı","Açıklama","Link","Soru","Ders"};
        mdl_educator_course.setColumnIdentifiers(col_educator_course);
        row_educator_course = new Object[col_educator_course.length];
        ArrayList<Content> content = Content.getList();
        if(!content.isEmpty()){
            loadContentModel();
        }
        tbl_educator_course.setModel(mdl_educator_course);
        tbl_educator_course.getTableHeader().setReorderingAllowed(false);
        //cmb_content_course.addItem(new Item());
        loadContentCombo(user.getId());
        loadContentQuiz();
        btn_add.addActionListener(e -> {
            Item course_id = (Item) cmb_content_course.getSelectedItem();
            if(Helper.isFieldEmpty(fld_content_title) || Helper.isFieldEmpty(fld_content_desc) || Helper.isFieldEmpty(fld_content_link)){
                Helper.shwMsg("fill");
            }else{
                if(Content.add(fld_content_title.getText(),fld_content_desc.getText(),fld_content_link.getText(),1,course_id.getKey())){
                    Helper.shwMsg("done");
                    loadContentModel();
                    fld_content_desc.setText(null);
                    fld_content_link.setText(null);
                    fld_content_title.setText(null);
                }else{
                    Helper.shwMsg("error");
                }
            }
        });
    }

    private void loadContentQuiz() {
        cmb_content_quiz.removeAllItems();
        Quiz q = Quiz.getFetch();
        cmb_content_quiz.addItem(new Item(q.getId(),q.getSoru()));
    }

    private void loadContentCombo(int id) {
        cmb_content_course.removeAllItems();
        for (Course c : Course.getListByUser(id)){
            cmb_content_course.addItem(new Item(c.getId(),c.getName()));
        }
    }

    private void loadContentModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_course.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for(Content obj: Content.getList()){
            i=0;
           row_educator_course[i++] = obj.getId();
            row_educator_course[i++] = obj.getTitle();
            row_educator_course[i++] = obj.getDescription();
            row_educator_course[i++] = obj.getLink();
            row_educator_course[i++] = obj.getCourse().getName();
            row_educator_course[i++] = obj.getQuiz().getSoru();
           mdl_educator_course.addRow(row_educator_course);

        }
    }


}
