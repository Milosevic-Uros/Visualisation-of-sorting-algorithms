package algoritmi;

import gui.JArray;

public class SelectionSort implements ISort {

	@Override
	public void sort(JArray array) {
		int length = array.arraySize();
		for (int i = 0; i < length-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < length; j++) 
				if(array.getElemAtIndex(j)<array.getElemAtIndex(minIndex)) 
					minIndex = j;
					
				array.swap(minIndex,i,20);
		}
				
	}
}
