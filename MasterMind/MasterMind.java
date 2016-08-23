import java.util.Random;
import java.util.Scanner;

public class MasterMind {

	static boolean win = false;
	static String compCode = "";
	static String myGuess = "";
	static int[] freq = new int[4];
	
	public static void main(String[] args) {
		int numGuesses = 0;
		generateCode();
		while(numGuesses < 15 && !win){
			guess();
			checkGuess();
			numGuesses++;
			if( !win ){
				System.out.println("Number of guesses remaining: " + (15-numGuesses));
			}
		}
		if(win){
			System.out.println("Correct! You Win!");
		} else {
			System.out.println("The correct answer was " + compCode);
		}
	}

	private static void checkGuess() {
		int numHits = 0;
		int numMisses = 0;
		int[] newFreq = new int[4];
		System.arraycopy(freq, 0, newFreq, 0, freq.length);
		for( int x = 0; x < 4; x++){
			if(compCode.charAt(x) == myGuess.charAt(x)){
				numHits++;
				if( compCode.charAt(x) == 'R'){
					newFreq[0]--;
				} else if( compCode.charAt(x) == 'G'){
					newFreq[1]--;
				} else if( compCode.charAt(x) == 'B'){
					newFreq[2]--;
				} else if( compCode.charAt(x) == 'Y'){
					newFreq[3]--;
				}
			} 
		}
		for( int x = 0; x < 4; x++){
			if( myGuess.charAt(x) == 'R' && newFreq[0] > 0){
				numMisses++;
				newFreq[0]--;
			} else if( myGuess.charAt(x) == 'G' && newFreq[1] > 0){
				numMisses++;
				newFreq[1]--;
			} else if( myGuess.charAt(x) == 'B' && newFreq[2] > 0){
				numMisses++;
				newFreq[2]--;
			} else if( myGuess.charAt(x) == 'Y' && newFreq[3] > 0){
				numMisses++;
				newFreq[3]--;
			}
		}
		
		if( numHits == 1){
			System.out.println(numHits + " Hit");
		} else if( numHits == 2 || numHits == 3){
			System.out.println(numHits + " Hits");
		} else if( numHits == 4){
			win = true;
		}
		if( numMisses == 1){
			System.out.println(numMisses + " Miss");
		} else if( numMisses > 1){
			System.out.println(numMisses + " Misses");
		}
		if( numHits == 0 && numMisses == 0){
			System.out.println("No luck, Try again.");
		}
	}

	private static void guess() {
		System.out.println("-------------------------------");
		System.out.print("Enter your guess: ");
		Scanner scan = new Scanner(System.in);
		myGuess = scan.nextLine();
	}

	private static void generateCode() {
		Random rand = new Random();
		for(int x = 0; x < 4; x++){
			int y = rand.nextInt(4);
			switch (y){
			case 0:
				compCode += "R";
				freq[0] += 1;
				break;
			case 1:
				compCode += "G";
				freq[1] += 1;
				break;
			case 2:
				compCode += "B";
				freq[2] += 1;
				break;
			case 3:
				compCode += "Y";
				freq[3] += 1;
				break;
			}			
		}		
	}

}
