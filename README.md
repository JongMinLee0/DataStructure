# DataStructure



### Doubling
#### ArrayList_1.java
```java
private void doubling() {
		this.size = this.size * 2;
		Object[] newData = new Object[this.size];
		for (int k = 0; k < data.length; k++)
			newData[k] = data[k];
		this.data = newData;
	}
```
- ArrayList의 사이즈가 채워지면 그 두배만큼을 만든다.
- 내부적으로 이뤄지는 동작이지만 꽤 많은 시간으 잡아먹는다.



### HashTable
#### HashTable_1.java
```java
int getHashCode(String key) {
		int hashcode = 0;
		for (char c : key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
	}
int convertToIndex(int hashcode) {
	return hashcode % data.length;
	}
```
- 들어온 문자열을 아스키 코드로 변환하여 hashcode로 만든다.
- hashcode를 리스트의 사이즐 나누어 index로 활용하게 만든다.



### Character.getCharNumber
#### String_4.java
```java
	private static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <=z)
			return val-a;
		return-1;
	}
```
- 문자를 아스키 코드값으로 바꿔준다.



### StringBuilder 초기화
#### String_6.java
```java
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
```
- StringBuilder는 메모리를 동적으로 할당해준다.
- 그러나 뒤에서의 동작에 무리가 가므로 사이즈를 미리 구해줘 필요한 만큼만 초기화 시킨다.



