package String.ex;

// 문자열 치환 확인 알고리즘 문제 
public class String_2 {
	public static void main(String[] args) {
		System.out.println(permutation("ABC", "BCA"));
		System.out.println(permutation("ABC", "BDA"));

	}

	// 배열 정렬을 통한 확인(+길이)
//	private static String sort(String s) {
//		char[] content = s.toCharArray();
//		java.util.Arrays.sort(content);
//		return new String(content);
//	}
//	private static boolean permutation(String s, String t) {
//		if (s.length() != t.length()) return false;
//		return sort(s).equals(sort(t));
//	}
	
	// 아스키 코드를 이용한 풀이 (count해서 결과 출력)
	private static boolean permutation(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[128];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++;
		}
		for (int i = 0; i < t.length(); i++) {
			letters[t.charAt(i)]--;
			if (letters[t.charAt(i)] < 0)
				return false;
		}
		return true;
	}

}
