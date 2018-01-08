package Lecture17;

public class Client {
	// 50 true 25 true 12 false false true 37 false false true 75 true 62 false
	// false true 87 false false
	public static void main(String[] args) {

		
		// BinaryTree bt = new BinaryTree();
		// bt.display();
		//
		//
		//
		// System.out.println(bt.size2());
		// System.out.println(bt.min());
		// System.out.println(bt.max());
		// System.out.println(bt.find(87));
		// System.out.println(bt.find(5));
		//
		// System.out.println(bt.height());

		// bt.display();
		// bt.mirror();
		// bt.display();

		// bt.preOrder();
		// bt.postOrder();
		// bt.inOrder();
		// bt.levelOrder();
		// bt.preOrderI();
		//
		// System.out.println(bt.postOrderPred(50));
		// System.out.println(bt.postOrderSucc(50));
		//
		// bt.multiCalculator();

		int[] pre = { 50, 25, 12, 49, 75, 51, 87 };
		int[] in = { 12, 25, 49, 50, 51, 75, 87 };

		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();
		
		System.out.println(bt.diameter());
		System.out.println(bt.diameterBtr());
		
		System.out.println(bt.isBST());
		System.out.println(bt.isBSTBtr());
		System.out.println(bt.isBST3());
		
		bt.levelOrderLW();
		System.out.println(bt.levelOrderAL());
		bt.levelOrderLWZZ();
	}

}
