package com.drn.Model;

import com.drn.Helper.Config;
import com.drn.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private String title;
    private String description;
    private String link;
    private int quiz_id;
    private int course_id;
    private Quiz quiz;
    private Course course;

    public Content(int id, String title, String description, String link, int quiz_id, int course_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.quiz = Quiz.getFetch();
        this.course = Course.getFetch(course_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public static ArrayList<Content> getList(){
        ArrayList<Content> contents = new ArrayList<>();
        Content obj ;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM content");
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String link = rs.getString("link");
                int course_id = rs.getInt("course_id");
                obj = new Content(id,title,description,link,1,course_id);
                contents.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static boolean add(String title, String description, String link, int quiz_id, int course_id){
        String query = "INSERT INTO content(title,description,link,quiz_id,course_id) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,title);
            pr.setString(2,description);
            pr.setString(3,link);
            pr.setInt(4,quiz_id);
            pr.setInt(5,course_id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
