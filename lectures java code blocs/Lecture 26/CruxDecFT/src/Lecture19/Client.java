package Lecture19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Client {

	public static void main(String[] args) {
//		HashMap<String, Integer> popMap = new HashMap<>();
//		
//		popMap.put("India", 120);
//		popMap.put("US", 100);
//		popMap.put("UK", 25);
//		popMap.put("China", 200);
//		
//		System.out.println(popMap);
//		
//		popMap.put("India", 150);
//		System.out.println(popMap);
//		
//		System.out.println(popMap.get("India"));
//		System.out.println(popMap.get("Pak"));
//		
//		System.out.println(popMap.containsKey("India"));
//		System.out.println(popMap.containsKey("Pak"));
//		
//		System.out.println(popMap.remove("China"));
//		System.out.println(popMap.remove("China"));
//		
//		System.out.println(popMap);
//		
//		/* Keys */
//		Set<String> keys = popMap.keySet();
//		System.out.println(keys);
//		
//		for(String key: keys){
//			System.out.println(key);
//		}
//		
//		/* Values */
//		Collection<Integer> values = popMap.values();
//		System.out.println(values);
//		
//		for(Integer value: values){
//			System.out.println(value);
//		}
//		
//		/* Entries */
//		Set<Map.Entry<String, Integer>> allEntries = popMap.entrySet();
//		
//		System.out.println(allEntries);
//		for(Map.Entry<String, Integer> entry: allEntries){
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//		}
		
//		System.out.println(getHighestFreqChar("aajsjdhflasdbckja"));
		
//		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6));
//		System.out.println(getConsecutiveSeq(nums));
		
//		int[] one = {1, 1, 2, 2, 2, 3, 5};
//		int[] two = {1, 1, 1, 2, 2, 4, 5};
//		
//		System.out.println(getCommonElements(one, two));
		
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(-1, 1, -1, 1, 1, 2, -2, -2, 3, 0, 0, 0, 0, 0));
		zsp(nums);
	}
	
	public static Character getHighestFreqChar(String word){
		
		HashMap<Character, Integer> freqMap = new HashMap<>();
		
		for(int i = 0; i < word.length(); i++){
			Character ch = word.charAt(i);
			
			if(freqMap.containsKey(ch)){
				int ov = freqMap.get(ch);
				int nv = ov + 1;
				
				freqMap.put(ch, nv);
			} else {
				freqMap.put(ch, 1);
			}
		}
		
		
		Set<Map.Entry<Character, Integer>> entries = freqMap.entrySet();
		
		int maxFreq = Integer.MIN_VALUE;
		Character mfc = null;
		
		for(Map.Entry<Character, Integer> entry: entries){
			if(entry.getValue() > maxFreq){
				maxFreq = entry.getValue();
				mfc = entry.getKey();
			}
		}
		
		return mfc;
	}

	public static ArrayList<Integer> getUniqueNums(ArrayList<Integer> numbers){
		HashMap<Integer, Integer> map = new HashMap<>();
		
		Set<Integer> keys = map.keySet();
		ArrayList<Integer> rv = new ArrayList<>(keys);
		
		return rv;
	}

	public static ArrayList<Integer> getConsecutiveSeq(ArrayList<Integer> numbers){
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(Integer num: numbers){
			int nm1 = num - 1;
			int np1 = num + 1;
			
			if(map.containsKey(nm1)){
				map.put(num, false);
			} else {
				map.put(num, true);
			}
			
			if(map.containsKey(np1)){
				map.put(np1, false);
			}
		}
		
		Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
		int lsl = 0, lss = 0;
		
		for(Map.Entry<Integer, Boolean> entry: entries){
			if(entry.getValue() == false){
				continue;
			}
			
			int seql = 0, seqs = entry.getKey();
			while(map.containsKey(seqs + seql)){
				seql++;
			}
			
			if(seql > lsl){
				lsl = seql;
				lss = seqs;
			}
		}
		
		ArrayList<Integer> rv = new ArrayList<>();
		for(int i = 0; i < lsl; i++){
			rv.add(lss + i);
		}
		
		return rv;
	}

	public static ArrayList<Integer> getCommonElements(int[] one, int[] two){
		
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int val: one){
			map.put(val, false);
		}
		
		for(int val: two){
			if(map.containsKey(val)){
				map.put(val, true);
			}
		}
		
		ArrayList<Integer> rv = new ArrayList<>();
		
		Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
		for(Map.Entry<Integer, Boolean> entry: entries){
			if(entry.getValue()){
				rv.add(entry.getKey());
			}
		}
		
		return rv;
	}

	public static void zsp(ArrayList<Integer> nums){
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		
		for(int val: nums){
			if (freqMap.containsKey(val)){
				int ov = freqMap.get(val);
				freqMap.put(val, ov + 1);
				
			} else {
				freqMap.put(val, 1);
			}
		}
		
		Set<Map.Entry<Integer, Integer>> entries = freqMap.entrySet();
		for(Map.Entry<Integer, Integer> entry: entries){
			if(entry.getKey() < 0){
				Integer nwf = entry.getValue();
				Integer pwf = freqMap.get(-1 * entry.getKey());
				
				pwf = (pwf == null? 0: pwf);
				int lf = Math.min(nwf, pwf);
				
				for(int i = 0; i < lf; i++){
					System.out.println(entry.getKey() + " " + Math.abs(entry.getKey()));
				}
				
			} else if(entry.getKey() == 0){
				int lf = entry.getValue();
				for(int i = 0; i < lf / 2; i++){
					System.out.println("0  0");
				}
			}
		}
		
		
	}
}
