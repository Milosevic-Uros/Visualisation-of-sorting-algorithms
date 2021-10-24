package algoritmi;

import gui.JArray;

public class QuickSort implements ISort {

	int partition(JArray array , int low, int high) 
	{ 
	    int pivot = array.getElemAtIndex(high);    
	    int i = (low - 1);
	    for (int j = low; j <= high- 1; j++) 
	    { 
	        if (array.getElemAtIndex(j) < pivot) 
	        { 
	            i++;    
	            array.swap(i,j,3);  
	        } 
	    } 
	    array.swap(i + 1, high,0);
	    return i + 1; 
	} 
	  

	void quickSort(JArray array, int low, int high) 
	{ 
	    if (low < high) 
	    { 
	        int pi = partition(array, low, high); 
	        quickSort(array, low, pi - 1); 
	        quickSort(array, pi + 1, high); 
	    } 
	} 
	@Override
	public void sort(JArray array) {
		 quickSort(array, 0, array.arraySize()-1);
	}

}
