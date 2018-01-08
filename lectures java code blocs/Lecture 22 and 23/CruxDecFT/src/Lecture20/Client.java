package Lecture20;

public class Client {

	public static void main(String[] args) throws Exception {
		HashTable<String, Integer> popMap = new HashTable<>(3);
		
		popMap.put("China", 2000);
		popMap.put("India", 1200);
		popMap.put("Pak", 800);
		popMap.put("US", 250);
		popMap.put("UK", 200);
		popMap.put("Ethiopia", 200);
		
		popMap.display();
		
		popMap.put("Utopia", 0);
		popMap.display();
		
		System.out.println(popMap.get("US"));
		popMap.put("US", 300);
		
		popMap.display();
		
		popMap.remove("US");
		popMap.display();
	}

}
