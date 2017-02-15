import java.util.Scanner;
public class BinarySearchWithMergeSort {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	int search = in.nextInt();
	int[] array = {10,6,9,8,7,5,2,1,3,4};

	array = mergeSort(array);

	if(binarySearch(array,search)!= -1) {
		System.out.println(search+" found at position: "+binarySearch(array,search));
		}
	}

	public static int[] mergeSort(int[] A) {
		if(A.length==1) {
			return A;
		}

		int n = A.length/2;
		int[] L = new int[n];
		int[] R = new int[A.length-n];

		for(int i=0; i<=A.length-1; i++) {
			if(n>i) {
				L[i] = A[i];
			}
			else {
				R[i-n] = A[i];
			}
		}
		L = mergeSort(L);
		R = mergeSort(R);
		A = merge(L,R);
		return A;
	}

	public static int[] merge(int[] L, int[] R) {
		int nL = L.length , nR = R.length;
		int[] temp = new int[nL+nR];
		int a=0 , b=0;

		for(int i=0; i<=temp.length-1; i++) {
			if(a>=nL) {
				temp[i] = R[b];
				b++;
			}
			else if(b>=nR) {
				temp[i] = L[a];
				a++;
			}
			else if(L[a]<R[b]) {
				temp[i] = L[a];
				a++;
			}
			else {
				temp[i] = R[b];
				b++;
			}
		}
		return temp;
	}

	public static int binarySearch(int[] A, int s) {
		int n = A.length-1 , found = 0;
		int start=0 , end=n , middle=(start+end)/2;

		while(start<=end) {
			if(A[middle]==s) {
				found = middle;
				break;
			}
			else if(A[middle]>s) {
				end = middle-1;
			}
			else {
				start = middle+1;
			}
			middle = (start+end)/2;
		}
		return found;
	}
}