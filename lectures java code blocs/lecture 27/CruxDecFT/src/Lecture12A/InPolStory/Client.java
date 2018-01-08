package Lecture12A.InPolStory;

public class Client {

	public static void main(String[] args) {
		// P reference and P instance
		P o1 = new P();
		
		System.out.println(o1.d11);
		System.out.println(o1.d);
		o1.Fun();
		o1.Fun1();
		
		// Not allowed by compiler and neither is it sensical for JVM
//		System.out.println(o1.d21);
//		o1.Fun2();
		
		// Not allowed because is not senseful
//		System.out.println(((C)o1).d21);
//		((C)o1).Fun2();
		
		// P reference and C instance
		System.out.println("*******************************");
		P o2 = new C();
		
		System.out.println(o2.d11);
//		System.out.println(o2.d);
		o2.Fun();
		o2.Fun1();
	
		// Not allowed by compiler but is senseful (try type casting)
//		System.out.println(o2.d21);
//		o2.Fun2();
		
		System.out.println(((C)o2).d21);
		((C)o2).Fun2();
		
		// Reference C, Instance P
		// Never allowed by compiler because JVM cannot handle 
		// the extra properties and functions of C
//		C o3 = new P();
//		
//		o3.Fun2();
//		System.out.println(o3.d21);
		
		// Reference C, Instance C
		System.out.println("*******************************");
		C o4 = new C();
		
		System.out.println(o4.d11);
		System.out.println(o4.d);
		System.out.println(o4.d21);
		o4.Fun1();
		o4.Fun();
		o4.Fun2();
	}

}
