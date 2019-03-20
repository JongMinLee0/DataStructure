package Stack_Queue;

import java.util.Stack;

// Stack을 구현하고 가장 작은 값을 알아내는 알고리즘 풀이.

// 1개의 stack으로 min값을 node에 저장하여 알아내는 방법.
//class NodeWithMin {
//	int value;
//	int min;
//
//	public NodeWithMin(int v, int min) {
//		value = v;
//		this.min = min;
//	}
//}
//
//class StackWithMin extends Stack<NodeWithMin> {
//	public int min() {
//		if (this.isEmpty()) {
//			return Integer.MAX_VALUE;
//		} else {
//			return peek().min;
//		}
//	}
//
//	public void push(int value) {
//		int newMin = Math.min(value, min());
//		super.push(new NodeWithMin(value, newMin));
//	}
//}

// 2개의 stack으로 한개의 stack에는 min값을 저장.
class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;

	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}

	public void push(int value) {
		if (value < min()) {
			s2.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}
}

public class stack_2 {
	public static void main(String[] args) {
		StackWithMin2 stack = new StackWithMin2();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
		System.out.println("min: " + stack.min());

	}

}
