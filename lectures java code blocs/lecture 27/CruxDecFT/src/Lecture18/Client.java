package Lecture18;

public class Client {

	public static void main(String[] args) {
		BST bst = new BST(12, 25, 37, 50, 62, 75, 87);
		
//		bst.add(50);
//		bst.add(25);
//		bst.add(75);
//		bst.add(12);
//		bst.add(37);
//		bst.add(62);
//		bst.add(87);
		
		bst.display();
		System.out.println(bst.min());
		System.out.println(bst.max());
		System.out.println(bst.find(62));
		System.out.println(bst.find(32));
		
//		int[][] mat = {
//				{0, 1, 0, 1},
//				{1, 0, 1, 0},
//				{0, 0, 0, 1},
//				{1, 1, 0, 1},
//		};
//		printExit(mat);
		
		bst.linearize();
		bst.display();
		
		bst.pir(30, 70);
	}
	
	public static void printExit(int[][] mat){
		int dir = 0; // 0 => right, 1 => down, 2 => left, 3 => up
		int row = 0, col = 0;
		
		while(row < mat.length && col < mat[row].length){
			dir = (dir + mat[row][col]) % 4;
			
			if(dir == 0){
				col++;
			} else if(dir == 1){
				row++;
			} else if(dir == 2){
				col--;
			} else if(dir == 3){
				row--;
			}
		}
		
		if(dir == 0){
			col--;
		} else if(dir == 1){
			row--;
		} else if(dir == 2){
			col++;
		} else if(dir == 3){
			row++;
		}
		
		System.out.println(row + ", " + col);
	}

}
