package week3.day1.assignments;


public class Desktop extends computer{
	public void desktopsize(){
		System.out.println("This desktop size is   : 5.5");
	}
	public static void main(String[] args)
	{
		System.out.println("*********Computer**********");

		computer comp=new computer();
		comp.computermode1();
		
		System.out.println("*********Desktop**********");
		Desktop obj1 = new Desktop();
		obj1.desktopsize();
		obj1.computermode1();

		
	}
}