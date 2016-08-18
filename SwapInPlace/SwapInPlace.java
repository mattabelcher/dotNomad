
public class SwapInPlace {

	public static void main(String[] args) {
		int first = 420;
		int second = 322;
		System.out.println(first + " " + second);
		
		first += second;
		second = first - second;
		first -= second;
		
		System.out.println(first + " " + second);
	}

}
