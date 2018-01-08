package Lecture20.story_generics;

import java.util.Comparator;

public class GenericFunctions {

	public static void main(String[] args) {
		Integer[] iarr = {1, 5, -1, 34, 22};
		bubbleSort(iarr);
		
		Double[] farr = {1.0, 2.0, -1.0, 34.0, 22.0};
		bubbleSort(farr);
		
		Car[] cars = new Car[5];
		cars[0] = new Car(100, 1000);
		cars[1] = new Car(200, 3000);
		cars[2] = new Car(300, 2000);
		cars[3] = new Car(500, 5000);
		cars[4] = new Car(50, 1200);
		
//		bubbleSort(cars);
		bubbleSort(cars, new CarPriceComparator());
		
		for(Car car: cars){
			System.out.println(car);
		}
		
		
	}
	
//	public static void bubbleSort(int[] arr){
//		int counter = 1;
//		while(counter <= arr.length - 1){
//			for(int i = 0; i < arr.length - counter; i++){
//				if(arr[i + 1] < arr[i]){
//					int temp = arr[i];
//					arr[i] = arr[i + 1];
//					arr[i + 1] = temp;
//				}
//			}
//			
//			counter++;
//		}
//	}
//	
//	public static void bubbleSort(double[] arr){
//		int counter = 1;
//		while(counter <= arr.length - 1){
//			for(int i = 0; i < arr.length - counter; i++){
//				if(arr[i + 1] < arr[i]){
//					int temp = arr[i];
//					arr[i] = arr[i + 1];
//					arr[i + 1] = temp;
//				}
//			}
//			
//			counter++;
//		}
//	}
//	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr){
		int counter = 1;
		while(counter <= arr.length - 1){
			for(int i = 0; i < arr.length - counter; i++){
				if(arr[i + 1].compareTo(arr[i]) < 0){
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			
			counter++;
		}
	}
	
	public static <T> void bubbleSort(T[] arr, Comparator<T> ufc){
		int counter = 1;
		while(counter <= arr.length - 1){
			for(int i = 0; i < arr.length - counter; i++){
				if(ufc.compare(arr[i + 1], arr[i]) < 0){
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			
			counter++;
		}
	}

}
