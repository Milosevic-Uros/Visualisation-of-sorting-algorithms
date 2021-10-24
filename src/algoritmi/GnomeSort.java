package algoritmi;

import gui.JArray;

public class GnomeSort implements ISort{

	@Override
	public void sort(JArray array) {
		int index = 0;
        while (index < array.arraySize()) {
            if (index == 0) {
                index++;
            }
            if (array.getElemAtIndex(index) >= array.getElemAtIndex(index - 1)) {
                index++;
            } else {
                array.swap(index, index - 1,0);
                index--;
            }
        }
		
	}

}
