package algoritmi;
import gui.JArray;

public class InsertionSort implements ISort {

	@Override
	public void sort(JArray array) {
		int n = array.arraySize(); 
        for (int i = 1; i < n; ++i) { 
            int key = array.getElemAtIndex(i); 
            int j = i - 1; 
            //slucajno sam ovde ostavio temp 
            while (j >= 0 && array.getElemAtIndex(j) > key) { 
            	array.swap(j+1,j,0);
                j = j - 1; 
            } //izbacena bespotrebna linija koda
        } 
		
	}
	
	
	
}
