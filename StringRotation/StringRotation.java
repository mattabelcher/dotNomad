import java.util.Scanner;


public class StringRotation {

	public static void main(String[] args) {
		System.out.println("Enter a String: ");
		Scanner scan = new Scanner(System.in);
		String firstString = scan.nextLine();
		
		System.out.println("Enter another String: ");
		String secondString = scan.nextLine();
		
		boolean isRot = isRotation(firstString, secondString);
		
		if( isRot ){
			System.out.println(secondString + " is a rotation of " + firstString + "!");
		} else {

			System.out.println(secondString + " is not a rotation of " + firstString + "!");
		}
		scan.close();
	}

	private static boolean isRotation(String firstString, String rotString) {
		for( int x = 0; x < firstString.length(); x++){
			if( firstString.charAt(x) == rotString.charAt(0)){
				String check = new String();
				for( int y = x; y < firstString.length(); y++){
					check += firstString.charAt(y);
				}
				for( int y = 0; y < x; y++){
					check += firstString.charAt(y);
				}
				if( isSubString(rotString, check)){
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isSubString(String fullString, String subString) {
		boolean isSub = false;
		for( int x = 0; x < fullString.length(); x++){
			if( fullString.charAt(x) == subString.charAt(0) && x <= fullString.length() - subString.length()){
				int z = x;
				for( int y = 0; y < subString.length(); y++){
					if( fullString.charAt(z) == subString.charAt(y)){
						isSub = true;
					} else { 
						isSub = false;
						break;
					}
					z++;
				}
				if( isSub ){
					return isSub;
				}
			}
		}
		return isSub;
	}
}
