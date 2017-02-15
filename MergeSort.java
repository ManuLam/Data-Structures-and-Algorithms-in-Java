public class MergeSort {
public static void main(String[] args) {
		int[] array =  {10,1,15,25,20};// {9,10,6,2,1,8,4,3,8};//{5,1,2,6,4,9,8,10,34,12,63,62,75,45};
		int size = array.length-1;

		for(Integer x: array) {
		System.out.printf("%s ",x);
			}

		array = mergeSort(array);
		System.out.println();

		for(Integer x: array) {
		System.out.printf("%s ",x);
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
}
