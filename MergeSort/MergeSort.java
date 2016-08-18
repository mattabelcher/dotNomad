import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		System.out.print("Enter number of elements: ");
		Scanner scan = new Scanner(System.in);
		int numElements = scan.nextInt();
		
		int[] initArray = generateRandom(numElements);
		System.out.print("Unsorted ");
		printElements(initArray);
		
		int[] finalArray = mergeSort(initArray);
		System.out.print("  Sorted ");
		printElements(finalArray);
		
		scan.close();
	}


	private static int[] mergeSort(int[] initArray) {
		if( initArray.length == 1){
			return initArray;
		} else {
			return breakUp(initArray);
		}
	}


	private static int[] breakUp(int[] breakArray) {
		int[] firstArray;
		int[] secondArray;
		
		if(breakArray.length > 1){
			
			firstArray = Arrays.copyOfRange(breakArray, 0, breakArray.length/2);
			if(firstArray.length > 1){
				firstArray = breakUp(firstArray);
			}
			
			secondArray = Arrays.copyOfRange(breakArray, breakArray.length/2, breakArray.length);
			if(secondArray.length > 1){
				secondArray = breakUp(secondArray);
			}
			
			return merge(firstArray, secondArray);
		} else {
			return breakArray;
		}
	}


	private static int[] merge(int[] firstArray, int[] secondArray) {
		int[] sortedArray = new int[firstArray.length + secondArray.length];
		int firstCounter = 0;
		int secondCounter = 0;
		int sortedCounter = 0;
		
		while((firstCounter < firstArray.length) || (secondCounter < secondArray.length)){
			if(firstCounter < firstArray.length){
				if(secondCounter >= secondArray.length){
					sortedArray[sortedCounter] = firstArray[firstCounter];
					firstCounter++;
				} else {
					if(firstArray[firstCounter] <= secondArray[secondCounter]){
						sortedArray[sortedCounter] = firstArray[firstCounter];
						firstCounter++;
					} else {
						sortedArray[sortedCounter] = secondArray[secondCounter];
						secondCounter++;
					}
				}
			} else {
				sortedArray[sortedCounter] = secondArray[secondCounter];
				secondCounter++;
			}
			sortedCounter++;
		}
		return sortedArray;
	}


	private static void printElements(int[] printArray) {
		System.out.print("Elements in the array: ");
		for(int x = 0; x < printArray.length; x++){
			System.out.print(printArray[x] + " ");
		}
		System.out.print("\n");		
	}

	private static int[] generateRandom(int num) {
		int[] filledArray = new int[num];
		Random rand = new Random();
		for(int x = 0; x < filledArray.length; x++){
			filledArray[x] = rand.nextInt(100);
		}
		return filledArray;
	}
}
