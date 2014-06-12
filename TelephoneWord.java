import java.util.Arrays;


public class TelephoneWord {

	public static void main(String[] args) {
		int[] tel = new int[7];
		tel[0] = (int)(Math.random()*9 + 1);
		for (int i = 1; i< 7; i++) {
			tel[i] = (int)(Math.random()*10);
		}
		System.out.println(Arrays.toString(tel));
		//int telephoneKey = 0 ;
		//int place = 0;
		
		int[] pla = new int[7];
		for (int i = 0; i< 7; i++) {
			pla[i] = (int)(Math.random()*3 +1);
		}
		System.out.println(Arrays.toString(pla));
		/*String st = "";
		for (int i = 0; i < 7; i++) {

				//telephoneKey = tel[i];
				telephoneKey = tel[i];
				place = pla[i];
				st = st + GetCharKey(telephoneKey, place);
				//char res = GetCharKey(telephoneKey, place);
				//System.out.println(res);
				
			
		}*/
		
		
		String st = allstring(tel,pla);
		System.out.println(st);
		
		//chartonumber(st);
		
		Object[] revtonumber= chartonumber(st);
		int[] aa = (int[]) revtonumber[0]; 
		int[] bb = (int[]) revtonumber[1];
		
		System.out.println(Arrays.toString(aa));
		System.out.println(Arrays.toString(bb));
		/*int telephoneKey = 3;
		int place = 2;
		
		char res = GetCharKey(telephoneKey, place);
		//System.out.println(res);
		System.out.println("["+telephoneKey+ ", " + place +"] = "+res);*/
	}

	private static Object[] chartonumber(String str) {
		int[] tell = new int[str.length()];
		int[] plal = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char ch1 = str.charAt(i);
			int abc = (int)ch1;
			if(ch1 == '*' || ch1 =='#') {
				plal[i] = 1;
				if (ch1 == '*') {
					tell[i] = 1;
				} else {
					tell[i] = 0;					
				}
			} else {
				tell[i] = (abc-65)/3 + 2;
				plal[i] = (abc-65) % 3 +1;
			}
		}
		//int[][] obj = {tell, plal};
		Object[] obj = {tell, plal};
		return obj;
		//System.out.println(Arrays.toString(tell));
		//System.out.println(Arrays.toString(plal));
		
	}

	private static String allstring(int[] tel, int[] pla) {
		String st = "";
		for (int i = 0; i < tel.length; i++) {
				st = st + GetCharKey(tel[i], pla[i]);
		}
		return st;	
	}

	private static char GetCharKey(int k, int p) {//k= key,p= position
		char ch ;
		
		if( k == 1 || k == 0) {
			if (k==0) {
				return 35;	//  35 = #
			} else {
				return 42 ;  //42  = *
			}
			
		} else {
			ch = (char)(( k - 2) * 3  + p -1 + 65);
		}
		return ch;
	}
}
