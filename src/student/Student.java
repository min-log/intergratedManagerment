package student;

//학생정보를 저장하는 클래스 (VO => Value Object)

public class Student {
	private String sno; // 학번
	private String name; // 학생이름
	private int[] record = new int[4];
	private int total;
	private float average;
	private String grade;
	private int rank = -1;

	static enum GRADE {
		A, B, C, D, E, F
	}

	// 생성자를 통해서 학번, 이름, 국어점수,영어점수,수학점수,과학점수를 받아서 초기화 하세요!
	public Student(String sno, String name, int korean, int english, int math, int science) {

		this.sno = sno;
		this.name = name;
		this.record[0] = korean;
		this.record[1] = english;
		this.record[2] = math;
		this.record[3] = science;
		// makeScores() 메소드를 통해서 총합(total)과 평균을 바로 계산하여 저장하고 싶어요!
		this.makeScores();
	}
	
	//DB로 부터 받아온 학생정보를 저장하기 위한 생성자 구현해 주세요!
	public Student(String sno, String name, int korean, int english, int math, int science,int total,float average,String grade) {

		this.sno = sno;
		this.name = name;
		this.record[0] = korean;
		this.record[1] = english;
		this.record[2] = math;
		this.record[3] = science;
		this.total = total;
		this.average = average;
		this.grade = grade;
	}
	
	
	

	// 총합(total)과 평균을 바로 계산
	private void makeScores() {
		for (int i = 0; i < record.length; i++) {
			this.total += this.record[i];
		}
		this.average = (float) this.total / record.length;
		// 등급을 바로 연결하여 저장하고 싶다! makeGarde()
		makeGarde();
	}

	private void makeGarde() {
		/*
		 * 90점 부터 100점까지 A 80~ 89 B 70~79 C 60~69 D 50~59 E 0~49 F
		 */
		if (90 <= this.average && this.average <= 100)
			this.grade = GRADE.A.toString();

		else if (80 <= this.average && this.average < 90)
			this.grade = GRADE.B.toString();

		else if (70 <= this.average && this.average < 80)
			this.grade = GRADE.C.toString();

		else if (60 <= this.average && this.average < 70)
			this.grade = GRADE.D.toString();
		
		else if (50 <= this.average && this.average < 60)
			this.grade = GRADE.E.toString();

		else if (0 <= this.average && this.average < 50)
			this.grade = GRADE.F.toString();

	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSno() {
		return sno;
	}

	public String getName() {
		return name;
	}

	public int[] getRecord() {
		return record;
	}

	public int getTotal() {
		return total;
	}

	public float getAverage() {
		return average;
	}

	public String getGrade() {
		return grade;
	}
	
	

}
