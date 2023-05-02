// Helpful template which generates random lists of integers

import java.util.Random;
import java.util.Arrays;

class Sorting {


	private static void swap(int[] arr, int i, int j){
		System.out.println(Arrays.toString(arr) + " " + i + "<->" + j);
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

	}

	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){

			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			for(int j = i; j < arr.length; j++){
				if(arr[j] < min){
					min = arr[j];
					minIdx = j;
				}
			}
			swap(arr, i, minIdx);
		}

	}

	public static void insertionSort(int[] arr){
		for (int i = 0; i<arr.length; i++){
			if (i!=0){
				int curr = arr[i];
				int j = 0;
				while(j<=i){
					if (curr <arr[j]){
						int change = arr[j];
						arr[i] = change;
						arr[j] = curr;
						j++;
					}
					else{
						j++;
					}
				}
			}
		}
	}

	public static void main(String[] args){

		if(args.length != 2){
			System.out.println("Please specify sorted/unsorted/reversed and provide a length");
			System.out.println("Example: java Template unsorted 5");
			System.exit(1);
		}

		String ordered = args[0];
		int length = 0;
		try{
			length = Integer.parseInt(args[1]);
		} catch(NumberFormatException e1){
			System.out.println(args[1] + " cannot be converted to Integer.");
			System.exit(2);
		}


		int[] arr = new int[length];
		Random r = new Random();
		if(ordered.equals("sorted")){	
			int val = r.nextInt(10);
			for(int i = 0; i < length; i++){
				arr[i] = val;
				val = val + r.nextInt(4);
			}
		} else if(ordered.equals("unsorted")){
			for(int i = 0; i < length; i++){
				arr[i] = r.nextInt(25);
			}
		} else if(ordered.equals("reversed")){	
			int val = r.nextInt(100);
			for(int i = 0; i < length; i++){
				arr[i] = val;
				val = val - r.nextInt(4);
			}
		} else{
			System.out.println("Please select 'sorted' or 'unsorted' or 'reversed'.   '" + args[0] + "' is not valid");
			System.exit(3);
		}

		System.out.println("Generated List: " + Arrays.toString(arr));

		// Swap out the selection sort for your insertion sort!

		selectionSort(arr);
		System.out.println("After Selection Sort: " + Arrays.toString(arr));

		insertionSort(arr);
		System.out.println("After Insertion Sort: " + Arrays.toString(arr));

	}
}