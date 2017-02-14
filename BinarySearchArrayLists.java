import java.util.*;
public class BinarySearchArrayLists {		// ArrayList sort / binarySearch
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	int search = in.nextInt();
	int[] ary = {10,2,1,6,4,5,8,7,9,3};
	ArrayList<Integer> array = new ArrayList<Integer>();

	for(Integer x : ary) {
	array.add(x);
		}

	Collections.sort(array);
	System.out.print("Element: "+search+" found at position: "+ Collections.binarySearch(array,search));
    }
}