/**
 * @author mandar
 *
 *Merge sort is a divide and conquer approach based algorithm.
 *The time complexity is O(n*log n) in worst case. with O(n) space complexity.
 *
 *
 */
public class MergeSortRecursive {

	/**
	 * @param args
	 */
	public static void mergeSort(int [] array){
		int n=array.length;
		if(n<2){
			return;
		}else{
			int mid=n/2;
			int [] leftArray=new int[mid];
			int [] rightArray=new int[n-mid];
			for(int i=0;i<mid;i++){
				leftArray[i]=array[i];
			}
			for(int j=mid;j<n;j++){
				rightArray[j-mid]=array[j];
			}
			mergeSort(leftArray);
			mergeSort(rightArray);
			merge(leftArray, rightArray, array);
		}		
	}
	
	public static void merge(int leftArray[],int rightArray[], int array[]){
		int nL=leftArray.length;
		int rL=rightArray.length;
		int i=0; //smallest unpicked in leftArray
		int j=0; //smallest unpicked in rightArray
		int k=0; //position where the new number to be stored in actual array
		
		//putting the smallest of two positions into main array.
		while(i<nL && j<rL){
			if(leftArray[i]<=rightArray[j]){
				array[k]=leftArray[i];
				i++;
			}else if(leftArray[i]>rightArray[j]){
				array[k]=rightArray[j];
				j++;
			}
			k=k+1;
		}
		
		//if one of the array gets exhausted then directly copy the remainder of left OR right into main array.
		while(i<nL){
			array[k]=leftArray[i];
			i++;
			k++;
		}
		while(j<rL){
			array[k]=rightArray[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		
		int array[]={11,2,33,4,65,36,37,187,92,420};
		mergeSort(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
