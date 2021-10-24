package algoritmi;

import gui.JArray;

public class BubbleSort implements ISort {

	@Override
	public void sort(JArray array) {
		int len = array.arraySize();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array.getElemAtIndex(j) > array.getElemAtIndex(j + 1)) {
                    array.swap(j, j + 1,0);
                }
            }
        }
	}
}
