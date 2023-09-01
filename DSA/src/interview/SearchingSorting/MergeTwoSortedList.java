package interview.SearchingSorting;

public class MergeTwoSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {1, 3, 5, 7};
		int b[] = {2, 4, 6, 8};
		int m = a.length;
		int n = b.length;
		int res_arr[] = mergeTwoSortedList(a,b,m,n);
		for(int i = 0 ; i<res_arr.length ; i++)
			System.out.print(res_arr[i] + " ");

	}

	private static int[] mergeTwoSortedList(int[] a, int[] b, int m, int n) {
		int c[] = new int[m+n];
		int i=0,j=0,k=0;
		while(i<m && j<n){
			if(a[i] < b[j]){
				c[k] = a[i];
				k++;
				i++;
			}else{
				c[k] = b[j];
				k++;
				j++;
			}
		}
		while (i < m) 
            c[k++] = a[i++]; 
      
        while (j < n) 
            c[k++] = b[j++]; 
		return c;
	}

}
