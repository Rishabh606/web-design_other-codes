package Lecture23;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int ntc = scn.nextInt();
		int counter = 1;
		while (counter <= ntc) {
			int soa = scn.nextInt();

			int[] arr = new int[soa];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			Arrays.sort(arr);

			int numOps = getNumOps(arr, arr[0], arr[arr.length - 1]);
			System.out.println(numOps);

			counter++;
		}
	}

	public static int getNumOps(int[] arr, int min, int max) {
		if (min == max) {
			return 0;
		}

		int delta = max - min;

		if (delta == 1) {
			arr[arr.length - 1] = max - 1;

			for (int i = arr.length - 1; i > 0; i--) {
				if (arr[i - 1] > arr[i]) {
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				} else {
					break;
				}
			}

			return 1 + getNumOps(arr, min, arr[arr.length - 1]);
		} else if (delta >= 2 && delta <= 4) {
			arr[arr.length - 1] = max - 2;

			for (int i = arr.length - 1; i > 0; i--) {
				if (arr[i - 1] > arr[i]) {
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				} else {
					break;
				}
			}

			return 1 + getNumOps(arr, min, arr[arr.length - 1]);
		} else {
			arr[arr.length - 1] = max - 5;

			for (int i = arr.length - 1; i > 0; i--) {
				if (arr[i - 1] > arr[i]) {
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				} else {
					break;
				}
			}

			return 1 + getNumOps(arr, min, arr[arr.length - 1]);
		}
	}

}
