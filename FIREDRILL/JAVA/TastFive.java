public class TastFive{
	public static void main(String[] args){
		for(int i = 1; i <= 10; i++){
			for(int counter = 0; counter <= 8; counter++){
				if(i % 4 == 0){
					System.out.println(i);
					counter += 1;
				}	
			}	
		}	
	}
}