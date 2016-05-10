public class Calender{
	public static void main(String[] args){
		int year = 2005;
		int day = 3;
		int febDays = 28;
		if(year%4==0&&year%100!=0||year%400==0)
		{
			febDays = 29;			
		}
		
		for(int month = 1; month <= 12; month++){
			switch(month)
			{
				case 1: 
				case 3: 
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
				
				for(int i = 0;i < = day ; i++){
					System.out.print("  ");
				}
				
				break;
				case 4:
				case 6:
				case 9:
				case 11:
				
				
				break;
				case 2:
			
			}
			
		}
		
		
		}
		}