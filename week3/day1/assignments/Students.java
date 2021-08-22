package week3.day1.assignments;

public class Students {
	public void getStudentInfo(int id) {
		System.out.println("ID of the student: "+id);
	}
	public void getStudentInfo(int id,String name) {
		System.out.println("ID of the student: "+id);
		System.out.println("Name of the student: "+name);
	}
	public void getStudentInfo(String email,long phonenumber) {
		System.out.println("emailId of the student: "+email);
		System.out.println("phonenumber of the student: "+phonenumber);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students obj = new Students();
		obj.getStudentInfo(4);
		obj.getStudentInfo(3, "vaishu");
		obj.getStudentInfo("vsidhu@gmail.com", 963876741);
	}

}
