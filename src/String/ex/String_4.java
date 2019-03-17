package String.ex;

// 회문을 만들 수 있는지 여부 
public class String_4 {
	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("aa bb cc dd"));
		System.out.println(isPermutationOfPalindrome("aa bb cc dd e"));
		System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff"));

	}

	// (1)홀수개의 문자를 찾아서 2개이상이면 false 1개면 true
//	private static boolean isPermutationOfPalindrome(String s) {
//		int[] table = buildCharFrequencyTable(s);
//		return checkMaxOneOdd(table);
//	}
//
//	private static int[] buildCharFrequencyTable(String s) {
//		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];
//		for(char c : s.toCharArray()) {
//			int x = getCharNumber(c);
//			if(x != -1) {
//				table[x]++;
//			}
//		}
//		return table;
//	}
//
//	private static int getCharNumber(Character c) {
//		int a = Character.getNumericValue('a');
//		int z = Character.getNumericValue('z');
//		int val = Character.getNumericValue(c);
//		if(a <= val && val <=z)
//			return val-a;
//		return-1;
//	}
//	
//	private static boolean checkMaxOneOdd(int[] table) {
//		boolean foundOdd = false;
//		for(int count : table) {
//			if(count % 2 ==1) {
//				if(!foundOdd) {
//					foundOdd = true;
//				} else {
//					return false;
//				}
//			}
//		}
//		return true;
//	}

	// (2) (1)을 간략화 한 방법
//	private static boolean isPermutationOfPalindrome(String s) {
//		int countOdd = 0;
//		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
//		for (char c : s.toCharArray()) {
//			int x = getCharNumber(c);
//			if (x != -1) {
//				table[x]++;
//				if (table[x] % 2 == 1) {
//					countOdd++;
//				} else {
//					countOdd--;
//				}
//			}
//		}
//		return countOdd <= 1;
//	}
//
//	private static int getCharNumber(Character c) {
//		int a = Character.getNumericValue('a');
//		int z = Character.getNumericValue('z');
//		int val = Character.getNumericValue(c);
//		if (a <= val && val <= z)
//			return val - a;
//		return -1;
//	}

	// bit연산을 통한 방법
	private static boolean isPermutationOfPalindrome(String s) {
		int bitVector = createBitVector(s);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}

	private static int createBitVector(String s) {
		int bitVector = 0;
		for (char c : s.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}

	private static int toggle(int bitVector, int index) {
		if (index < 0)
			return bitVector;
		int mask = 1 << index;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}

	private static boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}

	private static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z)
			return val - a;
		return -1;
	}

}
