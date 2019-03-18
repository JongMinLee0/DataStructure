package String.ex;

// 문자가 회전된 문자인지 확인하기.
public class String_7 {
	public static void main(String[] args) {
		System.out.println(isRotation("string", "ringst"));
		System.out.println(isRotation("string", "ingstr"));
		System.out.println(isRotation("string", "ingstn"));

	}

	private static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return isSubString(s1 + s1, s2);
	}

	private static boolean isSubString(String s1, String s2) {
		return s1.contains(s2);
	}
}
