public class binarySearchRecursion {
public static void main(String[]args) {
	int[] a = {0,2,5,6,8,9,15,20,33};
	int s = 7;
	System.out.println(s+" is found at position: " + binarySearch(a,s,0,a.length) +"(-1 = not found)");
    }

    public static int binarySearch(int[] a, int s, int left, int right) {
    	int middle = left+right/2;
			if(left>right) return -1;
    		if(a[middle]==s) return middle;
    		else if(a[middle]>s) return binarySearch(a,s,left,middle-1);
    		else return binarySearch(a,s,middle+1,right);
    }

}