public class MultiTable{
	public static void main(String[] args){
		System.out.print("   ");
		for(int i = 1; i < 10; i++){
			//�����һ�е����֣�����֮����2���ո����
			//��������3���ո�						
			System.out.print(i+"  ");			
		}
		System.out.print('\n');
		System.out.println("________________________________");
		//���1-9��ÿһ��
		for(int j = 1; j < 10; j++){
			//���һ�е�����
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