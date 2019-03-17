package String.ex;
// 반복문자 압축하기 
public class String_6 {
	public static void main(String[] args) {
		System.out.println(compressString("aaabbccccddddd"));
		System.out.println(compressString("abcd"));
	}
	
	private static String compressString(String str) {
		String newStr = compress(str);
		return str.length() < newStr.length()? str : newStr;
	}
	
	private static String compress(String str) {
		int count = 0;
		StringBuilder newString = new StringBuilder(getTotal(str));
		for(int i=0; i<str.length(); i++) {
			count++;
			if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				newString.append(str.charAt(i));
				newString.append(count);
				count = 0;
			}
		}
		return newString.toString();
	}
	private static int getTotal(String str) {
		int count = 0;
		int total = 0;
		for(int i=0; i<str.length(); i++) {
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				total += 1 + String.valueOf(count).length();
				count = 0;
			}
		}
		return total;
	}
	
}
