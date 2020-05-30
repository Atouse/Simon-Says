package SimonSays;

public class Utils {
	
	//reset vars for different levels with increasing iterations
	final static int[] RESET_4 = {5,5}; // reset default user input sequence arr

	//
	
	public static boolean areEqual(int[] arr1, int[] arr2) {
		for(int i = 0; i < arr1.length; ++i) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void delay(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int[] increase(int[] arr1) {
		int[] arr=new int[arr1.length+1];
		for(int i=0;i<arr.length;i++) {
			arr[i]=5;
		}
		return arr;
	}
	
	public static int[] increased(int[] arr) {
		int[]arr1=new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			arr1[i]=arr[i];
		}
		return arr1;
	}
	
	
}
