package student;

import java.util.ArrayList;

public interface SearchStudent extends StudentOutput{
    //학생의 학번을 매개 변수로 해당 학생 정보를 검색
    public ArrayList<Student> searchStudent(String strSno);
}
