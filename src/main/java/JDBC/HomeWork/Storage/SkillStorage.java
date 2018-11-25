package JDBC.HomeWork.Storage;

import JDBC.HomeWork.Entity.Skill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillStorage extends Storage {
    private PreparedStatement createSkillSt;
    private PreparedStatement updateSkillSt;

    public SkillStorage(){
        initDriver();
        initConnection();
        initPrepareStatement();
    }

    private void initPrepareStatement(){
        try {
            createSkillSt = connection.prepareStatement("insert into skills (language, skill_level) values " +
                    "(?, ?)");

            updateSkillSt = connection.prepareStatement("update skills set language = ?, skill_level = ? " +
                    "where id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSkill(String language, String levelOfSkill){
        try {
            createSkillSt.setString(1, language);
            createSkillSt.setString(2, levelOfSkill);
            createSkillSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSkill(long id){
        String sql = "delete from skills where id = " + id;

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSkill(long id, String language, String level){
        try {
            updateSkillSt.setString(1, language);
            updateSkillSt.setString(2, level);
            updateSkillSt.setLong(3, id);
            updateSkillSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Skill getSkillById(long id){
        String sql = "select id, language, skill_level from skills where id = " + id;

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.first()){
                Skill skill = new Skill();
                skill.setId(rs.getLong("id"));
                skill.setLanguage(rs.getString("language"));
                skill.setLevel(rs.getString("skill_level"));
                return skill;
            }else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            closeResultSet(rs);
        }
    }

    public List<Skill> getAllSkills(){
        List<Skill> skills = new ArrayList<>();
        String sql = "select id, language, skill_level from skills";

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Skill skill = new Skill();
                skill.setId(rs.getLong("id"));
                skill.setLanguage(rs.getString("language"));
                skill.setLevel(rs.getString("skill_level"));
                skills.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rs);
        }
        return skills;
    }

}
