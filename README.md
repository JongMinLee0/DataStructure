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
- 내부적으로 이뤄지는 동작이지만 꽤 많은 시간을 잡아먹는다.
 
<br>

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

<br> 
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

<br> 
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


<br> 
### String.contains(string)

- String안에 string이 포함되어 있으면 true를 반환한다.


<br> <br> 
## HashMap의 필요성
#### Array_3.java
배열의 두 값을 더해서 특정 숫자가 나오게 하느 index 찾기 문제이다.
총 3가지 방법이 존재하지마 그 중 2가지를 비교해보자

#### 1. Array를 이용한 풀이
이 중 for문을 돌면서 가능한 index를 탐색한다.
```java
class Solution{	
public int[] twoSum(int[] nums, int target) {
	for(int i=0; i<nums.length; i++) {
		for(int j=i+1; j<nums.length; j++) {
			if(target == nums[i] + nums[j]) {
				return new int[] {i, j};
			}
		}
	}
	throw new IllegalArgumentException("No two sum solution");
   }
}
```


#### 2. HashMap을 이용한 풀이
HashMap을 한번 돌며 target과 키값의 차를 가지는 키값이 존재하면 index를 반환한다.
```java
class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);
		for (int i1 = 0; i1 < nums.length; i1++) {
			Integer i2 = map.get(target - nums[i1]);
			if (i2 != null && i1 != 12)
				return new int[] { i1, i2 };
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
```  
두 방법 모두 정답이지만 1번의 경우 O(n^2)이지만 2번의 경우 O(n)이 걸린다.  
따라서 좀 더 나은 방법을 찾는 것이 중요하겠다. HashMap의 경우 보통 O(n)의 시간이 소요되므로. 
그 사용법을 익히는 것이 필요하다.


<br> <br> 
## Sorting
- Quick Sort

   {3,4,6,8,7,0} 의 경우 가운데를 기준으로 나눈뒤 앞쪽과 뒷쪽 정렬을 각각 실행한다.
   앞쪽과 뒷쪽의 가운데를 기준으로 다시 정렬을 진행하며, 모두 정렬될 때까지 반복진행한다.


- Bubble Sort

   {2,5,4,3}의 경우 인덱스를 하나씩 증가시키며 다음 값과 비교한다.
   앞의 갚이 더 큰 경우 값을 바꿔주며 배열의 끝까지 진행한다.
   진행될 수록 끝의 앞까지만 진행하며 정렬한다.


- Merge Sort

   배열을 두개단위 까지 나눈뒤 4개단위로 합친다.
   합칠때 값을 비교하여 작은 값 먼저 배열에 저장한다. 이 과정을 반복진행하여 정렬한다.


- Selection Sort

   배열을 끝까지 돌며 가장 작은값을 찾고 제일 앞으로 옮긴다.
   그 다음은 두번째 index 부터 진행하며, 반복하며 정렬한다.



<br>

## Generic
Generic은 다양한 type의 객체들을 다루는 method나 collection class에 컴파일시의 type check를 해주는 기능이다. 
**즉, class내부에서 사용할 data type을 나중에 instance를 생성할 때 확정 짓는 것이다. **
```java
class Person<T>{
   public T info;
   
}
public class GenericDemo {
   public static void main(String[] args) {
    
     Person<String> p1 = new Person<String>();
     Person<StringBuilder> p2 = new Person<StringBuilder>();
   }
}
```
p1일시 data type은 String이 된다.(instance 생성 시 String Generic 생성)
p2일시 data type은 StringBuilder가 된다.
다양한 사용법이 있은 찾아보도록 하자.



<br> 
## Super
class가 instance화 될 때 생성자가 실행되면서 객체의 초기화를 한다. 그 때 자신의 생성자만 실행되느 것이 아니고,
부모의 생성자 부터 실행된다.
##### Ex)
###### 부모생성자
```java
public class Car{
      public Car(){
          System.out.println("Car의 기본생성자입니다.");
	  }
}
public class Bus extends Car{
      public Bus(){
          System.out.println("Bus의 기본생성자입닏.");
	  }
}
```
###### 실행결과
```sh
Car의 기본생성자입니다.
Bus의 기본생성자입니다.
```
#### super
- 자신을 가리키는 키워드가 this라면, 부모를 가리키는 키워드느 super이다.
- super()는 부모으 생성자를 의미한다.
- 부모의 생성자를 임의로 호출하지 않으면, 부모class의 기본생성자가 자동으로 호출된다.
- 아래처럼 호출하면 위에서 super()르 호출하지 않을때와 같다.

```java
public class Bus extends Car{
      public Bus(){
          super();
          
          System.out.println("Bus의 기본생성자입니다.");
	  }
}
```


#### 다른 예시
```java
public class Car{
      public Car(String name){
          System.out.println(name + "을 받는 생성자 입니다.");
	  }
}
```
Car class가 위처럼 바뀌면 부모의 기본생성자가 없기에 Bus생성자에 오류가 발생한다.



```java
public Bus(){
      super("슈퍼맨");
      System.out.println("Bus의 기본생성자 입니다.");
}
```
이런 문제를 해결하기 위해 위와 같이 자식 class의 생성자에서 직접 부모 생성자를 호출해야 한다.


<br><br>

## Enum
Enum은 열거형이라 불리며, **서로 연관된 상수들의 집합을 의미**합니다.


#### Enum의 장점
 - 코드 단순해지며, 가독성이 좋다.
 - instance 생성과 상속을 방지하여 상수값의 안정성이 보장된다.
 - enum class를 사용해 새로운 상수들의 type을 정의함으로 정의한 type이외의 type을 가진 data값을 체크.
 - 키워드 enum을 사용하 때문에 구현의 의도가 열거임을 분명하게 알 수 있다.
 
기존에 상수를 정의하던 방법과 비교해보자
 
```java
public class EnumExample {
    public static final String MALE = "MALE";
    public static final String FEMALE = "FEMALE";
    public static void main (String[] args) {
        String gender1;
         
        gender1 = EnumExample.MALE;
        gender1 = EnumExample.FEMALE;
        
        gender1 = "boy";
         
         
        Gender gender2;
        gender2 = Gender.MALE;
        gender2 = Gender.FEMAL;
        
        gender2 = "boy";
         
    }
     
}

enum Gender {
    MALE,FEMAL;
}
```
gender1의 경우 상수로 정의 한 값을 변경하려고 했지만 컴파일시 에러가 발생하지 않는다.그러나 런타임시 오류가 발생한다. 이번에는 gender2를 보자. 먼저 Gender type으로 선언해 주었다. 

gender2에 "boy"를 넣으려고 한다면 컴파일 에러가 발생한다. Gender type인 gender2에 String type을 집어 넣으려고 했기 때문이다.




