public class BinaryHeap {

	int[] data = new int[10];
	int size = 0;

	public void add(int i) {

		if (size >= data.length) {
			growArray();
		}
		data[size] = i;
		size++;
		shiftUp(size - 1);
	}

	void shiftUp(int currentIndex) {

		int parentIndex = parentIndex(currentIndex);
		int parentValue = data[parentIndex];
		int currentValue = data[currentIndex];
		if (currentValue >= parentValue) {
			return;
		}
		data[parentIndex] = currentValue;
		data[currentIndex] = parentValue;
		shiftUp(parentIndex);
	}

	public int remove() {

		int value = data[0];
		data[0] = data[size - 1];
		size--;
		shitDown(0);
		return value;
	}

	void shitDown(int currentIndex) {

		if (rightIndex(currentIndex) > size - 1) {
			return;
		}
		int currentValue = data[currentIndex];
		int child1Index = leftIndex(currentIndex);
		int child2Index = rightIndex(currentIndex);
		int child1Value = data[child1Index];
		int child2Value = data[child2Index];
		int indexToSwapWith;
		if (child1Value < child2Value) {
			indexToSwapWith = child1Index;
		} else {
			indexToSwapWith = child2Index;
		}
		if (currentValue <= data[indexToSwapWith]) {
			return;
		}
		data[currentIndex] = data[indexToSwapWith];
		data[indexToSwapWith] = currentValue;
		shitDown(indexToSwapWith);
	}

	int leftIndex(int i) {
		return i * 2 + 1;
	}

	int rightIndex(int i) {

		return i * 2 + 2;
	}

	int parentIndex(int i) {

		return (i - 1) / 2;
	}

	void growArray() {

		int[] arr = new int[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			arr[i] = data[i];
		}
		data = arr;
	}
}
