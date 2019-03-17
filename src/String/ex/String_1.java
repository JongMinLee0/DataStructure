package String.ex;

// 문자열에 중복된 문자가 있는지 찾는 문제. 
import java.util.HashMap;

public class String_1 {
	public static void main(String[] args) {
		System.out.println(isUnique("abcsdwq"));
		System.out.println(isUnique("asdfqwerzxcva"));

	}

	// 아스키 코드를 이용한 풀이
//	private static boolean isUnique(String str) {
//		if(str.length() > 128) return false;
//		boolean[] char_set = new boolean[128];
//		for(int i=0; i< str.length(); i++) {
//			int val = str.charAt(i);
//			if(char_set[val]) {
//				return false;
//			}
//			char_set[val] = true;
//		}
//		return true;
//		}

	// HashMap을 이용한 풀이
//	private static boolean isUnique(String str) {
//		HashMap<Integer, Boolean> hashmap = new HashMap<Integer, Boolean>();
//		for (int k = 0; k < str.length(); k++) {
//			int c = str.charAt(k);
//			if (hashmap.containsKey(c))
//				return false;
//			hashmap.put(c, true);
//		}
//		return true;
//	}
	
	// bit 연산을 이용한 풀이 
	private static boolean isUnique(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	
}
