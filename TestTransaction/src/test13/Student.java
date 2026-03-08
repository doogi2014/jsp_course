package test13;

public class Student implements Comparable<Student> {
	private int number;
	private String sex;
	private int state;
	private int age;
	private int score;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		String str = "number:"+number + " sex:"+sex + " state:"+state + " age:"+age + " score:"+score ;
		return str;
	}
	@Override
	public int compareTo(Student s) {
		
		return s.score - this.score;
	}
}
