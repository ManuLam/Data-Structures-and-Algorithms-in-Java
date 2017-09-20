//One of the fastest sorting algorithm when n elements are low, O(n) best case, O(N^2) worst case
//Inserting / swapping two positions until no more can be made

public class insertion {
	private static int[]ar = {3,2,1,5,7,6};	//declare an unsorted array

    public static void main(String[]args) {
    	for(Integer x : ar) {
    		System.out.printf("%s ",x);		//printing out the array in unsorted form
    		}
    	System.out.println();
		insertionSort(ar);					//calling the sort method
    	for(Integer x : ar) {
    		System.out.printf("%s ",x);		//printing out the array in sorted form
    		}
    	}

    public static void insertionSort(int[] a) {
    	int n = a.length;

    	for(int i=0; i<n; i++) {			//loop numbers to choose from
    		for(int j=i+1; j<n; j++) {		//looping the numbers to swap with
    			if(a[i]>=a[j]) {			//if left number is larger than the right number
    			int temp = a[i];			//hold a temp for the left side
    			a[i] = a[j];				//swap the left with the right
    			a[j] = temp;				//swap the right with the left (temp)
    		}
    	}
    	}

    	ar = a;								//return the array / store it
    }

}