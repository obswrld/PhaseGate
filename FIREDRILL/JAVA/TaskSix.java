public class TaskSix{
	public static void main(String[] args){
		
		for(int i = 1; i <= 10; i++){
			for(int counter = 0; counter <= 5; counter++){
				int num;
				if(i % 4 == 0){
					num = i * i;
					counter += 1;
					System.out.println(num);
				}
			}
		}
	}
}