package Stack_Queue;

// 고정길이 stack 다시 확인하기. 
import java.util.EmptyStackException;

import Stack_Queue.FixedMultiStacks.FullStackExcpetion;

class FixedMultiStacks {
	private int numOfStacks = 3;
	private int stackSize;
	private int[] values;
	private int[] sizes;

	class FullStackExcpetion extends Exception {
		public FullStackExcpetion() {
			super();
		}

		public FullStackExcpetion(String msg) {
			super(msg);
		}
	}

	public FixedMultiStacks(int stackSize) {
		this.stackSize = stackSize;
		this.sizes = new int[numOfStacks];
		this.values = new int[numOfStacks * stackSize];
	}

	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackSize;
	}

	public int getTopIndex(int stackNum) {
		int offset = stackSize * stackNum;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

	public void push(int stackNum, int data) throws FullStackExcpetion {
		if (isFull(stackNum)) {
			throw new FullStackExcpetion();
		}
		values[getTopIndex(stackNum) + 1] = data;
		sizes[stackNum]++;
	}

	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int top = getTopIndex(stackNum);
		int data = values[top];
		values[top] = 0;
		sizes[stackNum]--;
		return data;
	}

	public int peek(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return values[getTopIndex(stackNum)];
	}

}

public class fixed_Stack {
	public static void main(String[] ages) {
		FixedMultiStacks ms = new FixedMultiStacks(5);
		try {
			ms.push(0, 1);
			ms.push(0, 2);
			ms.push(0, 3);
			ms.push(0, 4);
			ms.push(0, 5);

			ms.push(1, 13);
			ms.push(1, 14);
			ms.push(1, 15);
			ms.push(1, 16);
			ms.push(1, 17);

		} catch (FullStackExcpetion e) {
			System.out.println("It's full");
		}
		try {
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.peek(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.isEmpty(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.isEmpty(0));

			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.peek(1));
			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.isEmpty(1));
			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.isEmpty(1));
		} catch (EmptyStackException e) {
			System.out.println("It's empty");
		}
	}
}
