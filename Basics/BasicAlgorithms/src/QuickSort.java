/**
 * 
 */

/**
 * @author mandar
 *
 *Time complexity: O(n*log n) in average case. and O(n^2) in worst case. Its very fast and is an In place sort.
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void swap(int array[],int i,int pIndex){
		int temp=array[i];
		array[i]=array[pIndex];
		array[pIndex]=temp;
	}
	public static int partition(int array[],int start,int end){
		int pivotElement=array[end];
		int pIndex=start;
		for(int i=start;i<end;i++){
			if(array[i]<=pivotElement){
				swap(array, i, pIndex);
				pIndex++;
			}
		}
		swap(array, pIndex, end);
		return pIndex;
	}
	public static void quickSort(int array[],int start,int end){
		if(start<end){
			int pIndex=partition(array, start, end);
			quickSort(array,start,pIndex-1);
			quickSort(array,pIndex+1,end);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={11,2,33,4,65,36,37,187,92,420};
		quickSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
