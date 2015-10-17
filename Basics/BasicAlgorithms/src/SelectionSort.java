/**
 * 
 */

/**
 * @author mandar
 *
 *This sort is exactly similar to the way we sort playing cards in hand.
 *This is an in-place sort.
 *
 *T(N)= a*n^2 + b*n + c.
 *
 *Time complexity comes out to be O(n^2). 
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void selectionSort(int array[],int lenth){
		for(int i=0;i<lenth-1;i++){  //number of passes which we need to run
			int iMinimum=i;
			for(int j=i+1;j<lenth;j++){     //find the minimum item location
				if(array[j]<array[iMinimum]){
					iMinimum=j;
				}				
			}
			//replace ith item with minimum item
			int temp=array[i];
			array[i]=array[iMinimum];
			array[iMinimum]=temp;
		}
	}
	
	public static void main(String[] args) {
		int array[]={11,2,33,4,65,36,37,187,92,420};
		selectionSort(array,array.length);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
