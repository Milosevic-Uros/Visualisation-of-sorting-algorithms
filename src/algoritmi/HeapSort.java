package algoritmi;

import gui.JArray;

public class HeapSort implements ISort {

	private boolean isChildLargerThanRoot(int child, int largest, int n, JArray array) {
        return child < n && array.getElemAtIndex(child) > array.getElemAtIndex(largest);
    }

    private void toBinaryTreeArray(JArray array,  int n, int rootIndex) {
        int largest    = rootIndex;
        int leftChild  = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (isChildLargerThanRoot(leftChild, largest, n, array)) {
            largest = leftChild;
        }
        if (isChildLargerThanRoot(rightChild, largest, n, array)) {
            largest = rightChild;
        }
        if (largest != rootIndex) {
            array.swap(rootIndex, largest, 2);
            toBinaryTreeArray(array, n, largest);
        }
    }


	@Override
	public void sort(JArray array) {
		 int n = array.arraySize();
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            toBinaryTreeArray(array, n, i);
	        }
	        for (int i = n - 1; i >= 0; i--) {
	            array.swap(0, i, 1);
	            toBinaryTreeArray(array, i, 0);
	        }
	}
	
}
