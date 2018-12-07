import java.util.Random ;
import java.util.Arrays ;


public class ProbOne {

	/* 

	We learned a couple of sorting algorithms over the last two weeks. Your task in this problem is to
	implement one of the most efficient algorithms, namely quick sort.

	Hint: When selecting a pivot, use the hint given in the slides to avoid the worst case scenario


	 (1) A single executable program implementing quick sort.

	 (2) At the beginning, the program should create an array of 100 values randomly selected from the
	range of [1..1000]. That will be the array to be sorted.

	 (3) The output of the algorithm is a file containing several lines. Each line will list the current state
	of the 100 values (comma separated). After each iteration of the algorithm, one line should be added to
	the output file. Certainly, the last line should have all values completely sorted.


	 */

	// main function 
	public static void main (String[] args) { 

		Random rand = new Random () ; 
		int[] array = new int[100] ; 
		for (int i = 0 ; i < 100 ; i++) {
			array[i] = rand.nextInt(1000) + 1 ; 
		}

		System.out.println("Orignial randomly generated array is: " + '\n' + Arrays.toString(array) + '\n') ;	

		int start = 0 ; 
		int end = 99 ;
		
		int [] finalArray = new int [100] ; 
		finalArray = quickSort(array, start, end) ; 
		
		System.out.println('\n' + "The final, sorted array is: " + '\n' + Arrays.toString(finalArray)) ; 

	}


	// quick sort function
	static int [] quickSort(int[] array, int start, int end)  {

		if (start < end) { 

			int q = partition(array, start, end) ; 
			quickSort(array, start, q - 1) ; 
			quickSort(array, q + 1, end) ; 
		}
		

		System.out.println(Arrays.toString(array)) ;	
		return array ; 
	}


	
	static int partition(int [] array, int start, int end) { 

		int midIndex = (end - start)/2 ;  
		

		// Pick an element to be the pivot in array 
		int rightmostElt = array[start] ; 
		int middleElt = array[midIndex] ; 
		int leftmostElt = array[end] ;


		// find good pivot
		int pivot = findPivot(leftmostElt, middleElt, rightmostElt) ;


		// switch pivot and element in rightmost position 

		// if pivot is the last elt
		if (array[end] == pivot) { 
			array[end] = pivot;
		}
		// if pivot is the first element 
		else if (array[start] == pivot) { 
			// switch elts 
			array[start] = array[end] ; 
			array[end] = pivot ; 
		}
		// if pivot is the middle element 
		else if (array[midIndex] == pivot) { 
			array[midIndex] = array[end] ; 
			array[end] = pivot ; 
		}


		// if p is beginning of array is it 0? 
		// index its gonna reset and shift
		int i = start - 1 ; 
		for (int j = start ; j < end ; j++) {
			if (array[j] <= pivot) { 
				i = i + 1 ; 
				// exchange A[i] with A[j]
				int temp = 0 ; 
				temp = array[i]  ; 
				array[i] = array[j] ; 
				array[j] = temp ; 
			}
		}
		// exchange A[i + 1] with A[r]
		int temp = 0 ; 
		temp = array[i + 1] ; 
		array[i + 1] = array[end] ; 
		array[end] = temp ; 
		return i + 1; 
	}





	static int findPivot (int leftmostElt, int middleElt, int rightmostElt) { 

		// order rightmost, leftmost, and middle element
		int [] medianList = new int [3] ;


		// R is least 
		if ((rightmostElt <= leftmostElt) && (rightmostElt <= middleElt)) { 
			medianList[0] = rightmostElt ; 
			if (leftmostElt <= middleElt) { 
				medianList[1] = leftmostElt ; 
				medianList[2] = middleElt ; 
			} else { 
				medianList[1] = middleElt ; 
				medianList[2] = leftmostElt ; 
			}
		}
		// L is least 
		else if ((leftmostElt <= rightmostElt) && (leftmostElt <= middleElt)) { 
			medianList[0] = leftmostElt ; 
			if (rightmostElt <= middleElt) { 
				medianList[1] = rightmostElt ; 
				medianList[2] = middleElt ; 
			} else { 
				medianList[1] = middleElt ; 
				medianList[2] = rightmostElt ; 
			}
		}
		// middle is least
		else { 
			medianList[0] = middleElt ; 
			if (leftmostElt <= middleElt) { 
				medianList[1] = leftmostElt ; 
				medianList[2] = rightmostElt ; 
			} else { 
				medianList[1] = rightmostElt ; 
				medianList[2] = leftmostElt ; 
			}
		}

		int median = medianList[1] ; 
		return median ; 


	}

}
