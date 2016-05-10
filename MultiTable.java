public class MultiTable{
	public static void main(String[] args){
		System.out.print("   ");
		for(int i = 1; i < 10; i++){
			//输出第一行的数字，数字之间用2个空格隔开
			//首行缩进3个空格						
			System.out.print(i+"  ");			
		}
		System.out.print('\n');
		System.out.println("________________________________");
		//输出1-9的每一行
		for(int j = 1; j < 10; j++){
			//输出一行的行首
			System.out.print(j+" |");
			for(int k = 1; k < 10; k++){
				int result = j * k;
				if(result < 10){
					System.out.print(result+"  ");
				}else{
					System.out.print(result+" ");
				}
			
			}
			System.out.println();
		}
	}
}