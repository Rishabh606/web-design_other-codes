package Lecture6;

import java.util.Scanner;

public class Test {
	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int one = takeinput();
        int two = takeinput();
        int three = one + two;
        breaker(three);

    }
  
 // private static int[] sum(int[] one, int[] two){
  
 // }
    public static void breaker(int N)
        {
        int[] a = null;
        int i=0, p = N,counter = 0;
		int n = 0;
       while(p!=0)
           {
           p = p/10;
           n++;
       }
        a = new int[n+1];
        while(N!=0)
        {
            i = N%10;
            a[counter] = i;
            counter++;
            N = N/10;
        }
        for(i = n; i>=0; i--)
            {
            System.out.print(a[i]+", ");
        }
        System.out.print("END");
    }
    public static int takeinput() {
		int[] rv = null;
        int sum=0;
		int n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
            sum = sum*10 + rv[i];
		}
		return sum;
	}

}
