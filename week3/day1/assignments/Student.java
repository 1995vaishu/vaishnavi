package week3.day1.assignments;

public class Student extends Department {
	public void Studentname(){
		System.out.println("My name is rani");
	}public void Studentid(){
		System.out.println("my id is 76765");
	}public void Studentdept(){
		System.out.println("My department  is physics");
	}
	public static void main(String[] args)
	{
		System.out.println("*********College**********");

		College clg =new College();
		clg.collegecode();
		clg.collegename();
		clg.collegerank();
		
		System.out.println("*********Department**********");
		Department dept = new Department();
		dept.collegecode();
		dept.collegename();
		dept.collegerank();
		dept.Deptname();
		
		System.out.println("*********Student**********");
		Student stud = new Student();
		stud.collegecode();
		stud.collegename();
		stud.collegerank();
		stud.Deptname();
		stud.Studentid();
		stud.Studentdept();
		stud.Studentname();

		

		
	}
}
