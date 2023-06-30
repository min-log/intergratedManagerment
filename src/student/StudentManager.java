package student;

import java.util.ArrayList;

public class StudentManager extends StudentDBIO{
	//싱글톤 패턴을 이용하여 설계하여 학생객체에 대한 관리객체 한명의 매니저가 관리
	private static final  StudentManager instance =  new StudentManager();

	private StudentManager() {}
	public static StudentManager getInstance() {
		return instance;
	}


	public boolean insertStudent(Student stu) {

		return super.insertStudent(stu);
	}

	public ArrayList<Student> searchStudent(String strSno){
		return super.searchStudent(strSno);
	}


	@Override
	public ArrayList<Student> getSortedStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
