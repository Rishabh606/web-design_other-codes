package Lecture23;

public class Client {

	public static void main(String[] args) {
//		System.out.println(search("abasdnfbamsmdbf", "d"));
		
//		Trie trie = new Trie();
//		
//		trie.addWord("art");
//		trie.addWord("arts");
//		trie.addWord("as");
//		trie.addWord("stop");
//		trie.addWord("stock");
//		trie.addWord("sell");
//		trie.addWord("sea");
//		trie.addWord("see");
//		trie.addWord("buy");
//		trie.addWord("bull");
//		
//		trie.displayWords();
//		trie.displayAsTree();
//		
//		System.out.println(trie.searchWord("arts"));
//		trie.removeWord("arts");
//		System.out.println(trie.searchWord("arts"));
//		
//		System.out.println(trie.searchWord("art"));
//		trie.removeWord("art");
//		System.out.println(trie.searchWord("art"));
		
		HCoder hcoder = new HCoder("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccdd");
		System.out.println(hcoder.encode("abcabcabcadd"));
		System.out.println(hcoder.decode("1010011010011010011000000"));
	}
	
	public static int search(String src, String pat){
		for(int i = 0; i <= src.length() - pat.length(); i++){
			int j = 0;
			
			for(j = 0; j < pat.length(); j++){
				if(src.charAt(i + j) != pat.charAt(j)){
					break;
				}
			}
			
			if(j == pat.length()){
				return i;
			}
		}
		
		return -1;
	}

}
