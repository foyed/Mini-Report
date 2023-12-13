import java.util.Random;

public class Sorts {
	
	private int[] array;
	
	
	public void bubbleSort() {
		for(int i = 0; i < array.length - 1;i++) {
			boolean swapped = false;
			
			for(int j = 0; j < array.length - i - 1; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}

	public void insertion() {
	 for (int i = 1; i < array.length; ++i) {
	        int temp = array[i];
	        int j = i - 1;

	       
	        while(j >= 0 && array[j] > temp) {
	        	array[j + 1] = array[j];
	        	j--;
	        }
	        array[j + 1] = temp;
	    }
	}
	
	public void Selection() {
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}
	
public void mergeNumber(int[] nums, int[] left, int[] right){
		
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		 while(i < leftSize && j < rightSize) {
			 if(left[i] <= right[j]) {
				 nums[k] = left[i];
				 i++;
			 }
			 else {
				 nums[k] = right[j];
				 j++;
			 }
			 k++;
		 }
		 
		 while(i < leftSize) {
			 nums[k] = left[i];
			 i++;
			 k++;
		 }
		 
		 while(j < rightSize) {
			 nums[k] = right[j];
			 j++;
			 k++;
		 }
		
	}

public void mergeSort(int[] nums) {
	
	  if (nums.length > 1) {
		  
          // Find the middle point
          int middle = nums.length / 2;
          
          int[] left = new int[middle];
          int[] right = new int[nums.length - middle];

          // Sort first and second halves
          mergeSort(left);
          mergeSort(right);

          // Merge the sorted halves
          mergeNumber(array, left, right);
      }
	
}

	//https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm
	public void Shell(int[] arrays) {
		 int interval = 1;
		    int elements = arrays.length;
		    int i = 0;
		    while (interval <= elements/3) {
		        interval = interval*3 +1;
		    }
		    while (interval > 0) {
		        System.out.print("iteration " + i + " ");
		        for (int outer = 0; outer < elements; outer++) {
		            int valueToInsert = arrays[outer];
		            int inner = outer;
		            while (inner > interval -1 && arrays[inner - interval] >= valueToInsert) {
		                arrays[inner] = arrays[inner - interval];
		                inner -= interval;
		                System.out.println(" item moved :" + arrays[inner]);
		            }
		            arrays[inner] = valueToInsert;
		            System.out.println(" item inserted :" + valueToInsert + ", at position :" + inner);
		        }
		        interval = (interval -1) /3;
		        i++;
		    }
		
	}
	
	// https://www.geeksforgeeks.org/quick-sort/
	// https://www.youtube.com/watch?v=h8eyY7dIiN4
	//https://www.baeldung.com/java-quicksort
	public void Quick(int[] arrays, int high, int low) {
		
		if(low >= high) {
			return;
		}
		
		int pivot = arrays[high];
		
		int left = partition(arrays, high, low, pivot);
		
		Quick(arrays, low, left - 1);
		Quick(arrays, left + 1, high);
		
	}

	private int partition(int[] arrays, int high, int low, int pivot) {
		int left = low;
		int right = high;
		
		while(left < right) {
			
			while(arrays[left] < pivot && left < right) {
				left++;
			}
			
			while(arrays[right] >= pivot && left < right) {
				right--;
			}
			
			swap(arrays, left, right);
		}
		
		swap(arrays, left, high);
		return left;
	}
	
	private static void swap(int[] arrays, int index1, int index2) {
		int temp = arrays[index1];
		arrays[index1] = arrays[index2];
		arrays[index2] = temp;
		
	}
	
	// https://www.geeksforgeeks.org/heap-sort/
	// the book
	public void Heap(int[] arrays) {
		
		for(int i = arrays.length/ 2 - 1; i >= 0; i--) {
			heapify(arrays, arrays.length, i);
		}
		
		for(int i = arrays.length - 1; i > 0; i--) {
			int temp = arrays[0];
			arrays[0] = arrays[i];
			arrays[i] = temp;
			
			heapify(arrays, i, 0);
		}
		
	}
	
	// https://www.youtube.com/watch?v=kU4KBD4NFtw
	//the book 
	// https://www.geeksforgeeks.org/heap-sort/
	public void heapify(int[] arrays, int current, int size) {
		int largest = current;
		int left = 2 * current + 1;
		int right = 2 * current + 2;
		
		if(left < size && arrays[left] > arrays[largest]) {
			largest = left;
		}
		
		if(right < size && arrays[right] > arrays[largest]) {
			largest = right;
		}
		
		if(largest != current) {
			int temp = arrays[current];
			arrays[current] = arrays[largest];
			arrays[largest] = temp;
			heapify(arrays, largest, size);
		}
	}
	
	public boolean validate(int[] finishedArray) {
		for(int i = 0; i < finishedArray.length - 1; i++) {
			if(finishedArray[i] > finishedArray[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public void testBubble() {
		
		
		long startTime = System.currentTimeMillis();
		
		int[] data = makeArray(10000);
		bubbleSort();
		long timespan = System.currentTimeMillis() - startTime;
		
		System.out.println("Bubble Time: " + timespan);
	}
	
	public void testInsertion() {
		long startTime = System.currentTimeMillis();
		
		int[] data = makeArray(10000);
		insertion();
		long timespan = System.currentTimeMillis() - startTime;
		
		System.out.println("Insertion Time: " + timespan);
	}
	
	public void testSelection() {
long startTime = System.currentTimeMillis();
		
		int[] data = makeArray(10000);
		Selection();
		long timespan = System.currentTimeMillis() - startTime;
		
		System.out.println("Selection Time: " + timespan);
	}
	
	public void testMerge() {
long startTime = System.currentTimeMillis();
		
		int[] data = makeArray(10000);
		mergeSort(data);
		long timespan = System.currentTimeMillis() - startTime;
		
		System.out.println("Merge Time: " + timespan);
	}
	
	public void testShell() {
long startTime = System.currentTimeMillis();
		
		int[] data = makeArray(10000);
		Shell(data);
		long timespan = System.currentTimeMillis() - startTime;
		
		System.out.println("Shell Time: " + timespan);
	}
	
	public void testQuick() {
		long startTime = System.currentTimeMillis();
		
		int[] data = makeArray(10000);
		Quick(data, 0, 0);;
		long timespan = System.currentTimeMillis() - startTime;
		
		System.out.println("Quick Time: " + timespan);
	}
	
	public void testHeap() {
		long startTime = System.currentTimeMillis();
		
		int[] data = makeArray(10000);
		Heap(data);
		long timespan = System.currentTimeMillis() - startTime;
		
		System.out.println("Heap Time: " + timespan);
	}
		
	public int[] makeArray(int size){
		array = new int[size];
		Random ran = new Random();
	  for(int i = 0; i < size; i++) {
		  array[i] = ran.nextInt(200000);
	  }
	  return array;
	}
	
	

}

