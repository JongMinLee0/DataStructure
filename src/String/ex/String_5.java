package String.ex;

// 삽입, 삭제, 교체 기능이 있는 편집기에서 하나의 기능만 사용됬는지 판단하기 
public class String_5 {
	public static void main(String[] args) {
		System.out.println(isOneAway("pal", "pale"));
		System.out.println(isOneAway("pale", "pal"));
		System.out.println(isOneAway("pale", "bale"));

		System.out.println(isOneAway("pal", "pales"));
		System.out.println(isOneAway("pal", "p"));
	}

	private static boolean isOneAway(String s1, String s2) {
		String ss, ls;
		if (s1.length() < s2.length()) {
			ss = s1;
			ls = s2;
		} else {
			ss = s2;
			ls = s1;
		}
		if (ls.length() - ss.length() > 1)
			return false;
		boolean flag = false;
		for (int i = 0, j = 0; i < ss.length(); i++, j++) {
			if (ss.charAt(i) != ls.charAt(j)) {
				if (flag) {
					return false;
				}
				flag = true;
				if (ss.length() != ls.length()) {
					j++;
				}
			}
		}
		return true;
	}
}
