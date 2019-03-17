package list.arraylist.implementation;

class ArrayList1 {
	private Object[] data;
	private int size;
	private int index;

	public ArrayList1() {
		this.size = 1;
		this.data = new Object[this.size];
		this.index = 0;
	}

	public void add(Object obj) {
		if (this.index == this.size - 1)
			doubling();
		data[this.index] = obj;
		this.index++;
		System.out.println("*** index: " + this.index + ", size: " + this.size + ", data size: " + this.data.length);
	}

	private void doubling() {
		this.size = this.size * 2;
		Object[] newData = new Object[this.size];
		for (int k = 0; k < data.length; k++)
			newData[k] = data[k];
		this.data = newData;
		System.out.println("*** index: " + this.index + ", size: " + this.size + ", data size: " + this.data.length);
	}

	public Object get(int i) throws Exception {
		if (i > this.index - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		} else if (i < 0) {
			throw new Exception("Negative Value");
		}
		return this.data[i];
	}

	public void remove(int i) throws Exception {
		if (i > this.index - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		} else if (i < 0) {
			throw new Exception("Negative Value");
		}
		for (int x = i; x < this.data.length - 1; x++) {
			data[x] = data[x + 1];
		}
		this.index--;
	}
}

public class ArrayList_1 {
	public static void main(String[] args) throws Exception {
		ArrayList1 al = new ArrayList1();
		al.add("0");
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		al.add("5");
		al.add("6");
		al.add("7");
		al.add("8");
		al.add("9");
		System.out.println(al.get(5));
		al.remove(5);
		System.out.println(al.get(5));

	}

}
