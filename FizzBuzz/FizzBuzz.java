public class FizzBuzz {
	public static void main(String args[]){
		String fb;
		for(int i = 1; i <= 100; i++){
			fb = "";
			if(i % 3 == 0){
				fb += "Fizz";
			}
			if(i % 5 == 0){
				fb += "Buzz";
			}
			if(fb == ""){
				System.out.println(i);
			} else {
				System.out.println(fb);
			}
		}
	}
}
