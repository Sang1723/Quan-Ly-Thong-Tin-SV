package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import query.Query;

/**
 *
 * @author dang
 */
public class AcademicDAO {

    public void insertStudent(String rollNumber, String memberCode,
            String mode, Date enrollDate, int studentId) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = Query.INSERT_ACADEMIC_STUDENT;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, rollNumber);
            stmt.setString(2, memberCode);
            stmt.setString(3, mode);
            stmt.setDate(4, enrollDate);
            stmt.setInt(5, studentId);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteStudent(String id) {
        Connection con = null;//mở cổng kết nối với sql
        DBContext db = new DBContext();
        try {
            con = db.getConnection();//kết nối với sql
            String sql = Query.DELETE_ACADEMIC_STUDENT; //đây là câu lệnh trong sql
            PreparedStatement stmt = con.prepareStatement(sql);//khởi tạo 1 biến thực thi câu lệnh sql
            stmt.setString(1, id);//set lấy giá trị của hàng 1 cột 1 của id
            stmt.executeUpdate();//câu lệnh này sec thực thi execute bên sql
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return;
    }

}
