import java.util.Scanner;

public class BubbleSort {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	in.close();
	int[] array = {6,7,2,3,1,5,8,10,9};		// Unsorted array... (ArrayList > Collections.sort() = cheating in this case
	int n = array.length , temp = 0;

	for(int j=0; j<n; j++) {
	System.out.printf("%s ",array[j]);
		}

	for(int pass=1; pass<n-1; pass++) {	// for until entire array is sorted, O(N^2) speed
	for(int i=0; i<n-1; i++) {	// for 1 loop
		if(array[i]>array[i+1]) {
			temp = array[i+1];
			array[i+1] = array[i];
			array[i] = temp;		// It can run 1 element faster per loop if I exclude the last element if it is the highest value in the array
				}
			}
		}
	System.out.println();
	for(int j=0; j<n; j++) {
	System.out.printf("%s ",array[j]);
		}

    }
}