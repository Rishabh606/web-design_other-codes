package Lecture4;

public class F2C {

	public static void main(String[] args) {
//		System.out.println(5/9);
//		System.out.println(5.0/9);
		int minF = 0, maxF = 300, step = 20;
		
		int currF = minF;
		while(currF <= maxF){
//			int celsius = (5 / 9) * (currF - 32);
//			int celsius = (5.0 / 9) * (currF - 32);
//			int celsius = (int)(5.0 / 9) * (currF - 32);
			int celsius = (int)((5.0 / 9) * (currF - 32));
			
//			System.out.println(currF + ' ' + celsius);
			System.out.println(currF + "\t" + celsius);
			
			currF = currF + step;
		}
	}

}
