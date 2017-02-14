import java.util.Scanner;

public class BinarySearch {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	int search = in.nextInt();
	int[] array = {1,2,3,4,5,6,7,8,9,10};	// has to be a sorted array
	int n = array.length-1;
	int first = 0 , last = n , middle = (first+last)/2;

	while(first<last) {
		if(array[middle]==search) {
			System.out.println("Element "+search+" found at position: "+middle);
			break;
		}
		else if(array[middle]>search) {
			last = middle-1;	// between start and middle
		}
		else {
			first = middle+1;	// between middle and finish
		}
		middle = (first+last)/2;
		first++;
			}

    }
}