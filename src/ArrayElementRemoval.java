public class ArrayElementRemoval {

	public static String[] remElement(String[] string, int element) {

		int length = string.length;
		String[] newString = new String[length-1];
		
		for (int i = 0; i < newString.length; i++) {
			if (i<element) {
				newString[i]=string[i];
			}
			else {
				newString[i]=string[i+1];
			}
		}
		return newString;

	}

	public static void main(String[] args) {
		
		String[] arr = { "The ", "quick ", "brown ", "fox ", "jumps ", "over ",
				"the ", "lazy ", "dog." };
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+' ');
		}
		
		System.out.print('\n');
		
		arr=remElement(arr, 3);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ' ');
		}

	}
}
