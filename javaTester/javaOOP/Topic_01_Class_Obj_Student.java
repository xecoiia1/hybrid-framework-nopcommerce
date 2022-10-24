package javaOOP;

public class Topic_01_Class_Obj_Student {
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public float getStudentKnowLedgeScore() {
		return studentKnowLedgeScore;
	}
	public void setStudentKnowLedgeScore(float studentKnowLedgeScore) {
		this.studentKnowLedgeScore = studentKnowLedgeScore;
	}
	public float getStudentPracticeScore() {
		return studentPracticeScore;
	}
	public void setStudentPracticeScore(float studentPracticeScore) {
		this.studentPracticeScore = studentPracticeScore;
	}
	private int studentID;
	private String studentName;
	private float studentKnowLedgeScore;
	private float studentPracticeScore;
		
	private void showStudentInfo() {
		System.out.println("************************************************");
		System.out.println("Name: " + getStudentName());
		System.out.println("ID: " + getStudentID());
		System.out.println("KnowLedgeScore: " + getStudentKnowLedgeScore());
		System.out.println("PracticeScore: " + getStudentPracticeScore());
		System.out.println("AverageScroce: " + getAveragePoint());
	}
	
	private float getAveragePoint() {
		return (this.studentKnowLedgeScore + this.studentPracticeScore*2)/3;
	}
	
	
	public static void main(String[] arg) {
		Topic_01_Class_Obj_Student studentNo1 = new Topic_01_Class_Obj_Student();
		
		studentNo1.setStudentID(01);
		studentNo1.setStudentName("John");
		studentNo1.setStudentKnowLedgeScore(8.0f);
		studentNo1.setStudentPracticeScore(8.0f);
		studentNo1.showStudentInfo();
		
		Topic_01_Class_Obj_Student studentNo2 = new Topic_01_Class_Obj_Student();
		
		studentNo2.setStudentID(02);
		studentNo2.setStudentName("Terry");
		studentNo2.setStudentKnowLedgeScore(6.8f);
		studentNo2.setStudentPracticeScore(9.2f);
		studentNo2.showStudentInfo();
	}
}
