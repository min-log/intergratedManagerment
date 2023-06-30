package student;

import java.util.ArrayList;

public interface StudentSearch  extends StudentOutput{
          //학생의 학번을 매개변수로 하여 해당 학생정보를 검색하는 기능 정의 
	    public ArrayList<Student> searchStudent(String strSno);
}
