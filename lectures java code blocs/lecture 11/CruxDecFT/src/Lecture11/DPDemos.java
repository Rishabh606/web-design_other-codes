package Lecture11;

import Lecture10.TnSDemos;

public class DPDemos {

	public static void main(String[] args) {
		int N = 16;

		/*
		 * TnSDemos.startTimer(); System.out.println(Fib(N));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(FibRS(N, new int[N + 1]));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(FibI(N));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(FibIS(N));
		 * System.out.println(TnSDemos.endTimer());
		 */

		/*
		 * TnSDemos.startTimer(); System.out.println(cbp(N, 0));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cbpRS(N, 0, new int[N +
		 * 1])); System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cbpI(N));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cbpIS(N));
		 * System.out.println(TnSDemos.endTimer());
		 */

		TnSDemos.startTimer();
		System.out.println(cmp(N, N, 0, 0));
		System.out.println(TnSDemos.endTimer());

		TnSDemos.startTimer();
		System.out.println(cmpRS(N, N, 0, 0, new int[N + 1][N + 1]));
		System.out.println(TnSDemos.endTimer());
		
		TnSDemos.startTimer();
		System.out.println(cmpI(N, N));
		System.out.println(TnSDemos.endTimer());
		
		TnSDemos.startTimer();
		System.out.println(cmpIS(N, N));
		System.out.println(TnSDemos.endTimer());
	}

	public static int Fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);
		int fn = fnm1 + fnm2;

		return fn;
	}

	public static int FibRS(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = FibRS(n - 1, strg);
		int fnm2 = FibRS(n - 2, strg);
		int fn = fnm1 + fnm2;

		strg[n] = fn;
		return fn;
	}

	public static int FibI(int n) {
		int[] strg = new int[n + 1];

		// init
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int FibIS(int n) {
		int[] strg = new int[2];

		// init (fib of 0 and fib of 1)
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n; i++) {
			int ofib = strg[0];
			strg[0] = strg[1];
			strg[1] = ofib + strg[0];
		}

		return strg[0];
	}

	public static int cbp(int end, int curr) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += cbp(end, curr + dice);
		}

		return count;
	}

	public static int cbpRS(int end, int curr, int[] strg) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += cbpRS(end, curr + dice, strg);
		}

		strg[curr] = count;
		return count;
	}

	public static int cbpI(int end) {
		int[] strg = new int[end + 1];

		// init
		strg[end] = 1;

		for (int i = end - 1; i >= 0; i--) {
			int sum = 0;

			for (int dice = 1; dice <= 6 && (i + dice) < strg.length; dice++) {
				sum += strg[i + dice];
			}

			strg[i] = sum;
		}

		return strg[0];
	}

	public static int cbpIS(int end) {
		int[] strg = new int[6];

		// init , lets assume end = 100
		strg[0] = 1; // 0 is aligned with 100
		strg[1] = 0; // 1 is aligned with 101
		strg[2] = 0; // 2 is aligned with 102
		strg[3] = 0; // 3 is aligned with 103
		strg[4] = 0; // 4 is aligned with 104
		strg[5] = 0; // 5 is aligned with 105

		for (int i = end - 1; i >= 0; i--) {
			// shift left

			int sum = 0;
			for (int j = 5; j >= 0; j--) {
				sum += strg[j];

				if (j != 0) {
					strg[j] = strg[j - 1];
				} else {
					strg[0] = sum;
				}
			}
		}

		return strg[0];
	}

	public static int cmp(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		count += cmp(er, ec, cr + 1, cc);
		count += cmp(er, ec, cr, cc + 1);

		return count;
	}

	public static int cmpRS(int er, int ec, int cr, int cc, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int count = 0;

		count += cmpRS(er, ec, cr + 1, cc, strg);
		count += cmpRS(er, ec, cr, cc + 1, strg);

		strg[cr][cc] = count;
		return count;
	}

	public static int cmpI(int er, int ec) {
		int[][] strg = new int[er + 1][ec + 1];

		// init
		strg[er][ec] = 1;

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row + 1 > er || col + 1 > ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];
	}

	public static int cmpIS(int er, int ec){
		int[] strg = new int[ec + 1];
		
		// init
		for(int i = 0; i < strg.length; i++){
			strg[i] = 1;
		}
		
		for(int i = er - 1; i >= 0; i--){
			// shift up
			for(int j = ec; j >= 0; j--){
				if(j == ec){
					strg[j] = 1;
				} else {
					strg[j] = strg[j] + strg[j + 1];
				}
			}
		}
		
		return strg[0];
	}
}

// lcs, edit distance, knapsack, mcm
