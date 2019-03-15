package list.doublylinkedlist.implement.copy;

public class Main {
	public static void main(String[] args) {
		DoublyLinkedList numbers = new DoublyLinkedList();
//		numbers.addFirst(30);
//		numbers.addFirst(20);
//		numbers.addFirst(10);
		
		numbers.addLast(30);
		numbers.addLast(20);
		numbers.addLast(10);
		
		//System.out.println(numbers.removeFirst());
//		System.out.println(numbers.remove(1));
//		System.out.println(numbers);
//		System.out.println(numbers.size());
//		System.out.println(numbers.get(1));
//		System.out.println(numbers.indexOf(5));
		DoublyLinkedList.ListIterator i = numbers.listIterator();
//		System.out.println(i.next());
//		System.out.println(i.hasNext());
//		System.out.println(i.next());
//		System.out.println(i.next());
//		System.out.println(i.hasNext());
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
//		i.add(5);
		i.next();
//		i.add(15);
//		System.out.println(numbers);
		i.remove();
	}
	
}
