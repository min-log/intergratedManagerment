package student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lib.ObjectDBIO;

public abstract class StudentDBIO extends ObjectDBIO implements StudentIO {
	public ArrayList<Student> getStudentList() {    //DB에서 저장한 학생정보를 받아와서 자바의 ArrayList에 저장기능
		ArrayList<Student> resArray = new ArrayList<Student>();
		String strSql = "select * from STUDENT";
		ResultSet rs = null;

		try {
			rs = super.execute(strSql, rs);
			while(rs.next()) {

				Student stu = new Student(rs.getString("sno"), rs.getString("name"),
						rs.getInt("korean"),rs.getInt("english"),
						rs.getInt("math"), rs.getInt("science"),
						rs.getInt("total"), rs.getFloat("average"),rs.getString("grade"));
				resArray.add(stu);
			}
			rs.close();
			super.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return resArray;
	}

	public boolean insertStudent(Student stu) {
		String sql = "insert into STUDENT values('" + stu.getSno() + "','" + stu.getName() + "'," + stu.getRecord()[0] + "," +
				stu.getRecord()[1] + "," + stu.getRecord()[2] + "," + stu.getRecord()[3] + "," + stu.getTotal() + "," + stu.getAverage() + ",'" +
				stu.getGrade() + "')";

		super.execute(sql);
		return true;

	}


	public ArrayList<Student> searchStudent(String strSno){
		ArrayList<Student> resArray = new ArrayList<Student>(); //DB로 부터 조건(학번)에 맞게 검색한 학생정보 저장할 학생 객체 생성
		String strSql = "select * from STUDENT where sno = '" + strSno + "'";
		ResultSet rs = null;
		try {
			rs = super.execute(strSql, rs);
			while(rs.next()) {

				Student stu = new Student(rs.getString("sno"), rs.getString("name"), rs.getInt("korean"),
						rs.getInt("english"), rs.getInt("math"), rs.getInt("science"),
						rs.getInt("total"), rs.getFloat("average"), rs.getString("grade"));

				resArray.add(stu);
			}
			rs.close();
			super.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resArray;
	}


}