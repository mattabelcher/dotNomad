
public class ScatteredEmptyStrings {

	public static void main(String[] args) {
		String[] stringArr = new String[]{"attack","","","","bard","","","dragon","","","dungeon","",""};
		System.out.println(findString("dragon",stringArr));
	}

	private static int findString(String string, String[] stringArr) {
		int location = 0;
		for(int x = 0; x < stringArr.length; x++){
			if(string.equals(stringArr[x])){
				location = x;
				break;
			}
		}
		
		return location;
	}

}
