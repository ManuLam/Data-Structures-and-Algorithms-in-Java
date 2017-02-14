import java.util.*;

public class LinearSearch {
public static void main(String[]args) {
	Scanner input = new Scanner(System.in);
	int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};
	int search = input.nextInt();		// Linear search will take O(n) speed vs Binary search will take O(log2n) speed
	int count = 0;

	for(int i=0; i<array.length; i++) {
		count++;
		if(i==search) {
			System.out.println(search+" was found at position: "+i);
			break;
			}
		}

		System.out.println(count+" Steps taken for search");

    }
}