//package String.ex;
//
//class StringBuilder {
//	private char[] value;
//	private int size;
//	private int index;
//
//	StringBuilder() {
//		size = 1;
//		value = new char[size];
//		index = 0;
//	}
//
//	public void append(char c) {
//		if (c == null)
//			c = "null";
//		int len = c.length();
//		ensureCapacity(len);
//		for (int i = 0; i < c.length(); i++) {
//			value[index] = c.charAt(i);
//			index++;
//		}
//		System.out.println(size + ", " + index);
//	}
//
//	private void ensureCapacity(int len) {
//		if (index + len > size) {
//			size = (size + len) * 2;
//			System.out.println("*** " + size + ", " + index);
//		}
//		char[] newValue = new char[size];
//		for (int i = 0; i < value.length; i++) {
//			newValue[i] = value[i];
//		}
//		value = newValue;
//	}
//
//	public String toString() {
//		return new String(value, 0, index);
//	}
//
//}
//
//public class StringBuilder_1 {
//	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();
//		sb.append("sung");
//		sb.append(" is");
//		sb.append(" pretty");
//		System.out.println(sb.toString());
//	}
//
//}
