package lesson004;

public class Question35 {

	public static void main(String[] args) {
		// Java,Spring,Postgre,React
		
		String str = "Java,Spring,Postgre,React";
		String[] list = str.split(",");
		for(int i = 0;i<list.length;i++) {
			System.out.println(list[i]);
		}
		//Alternatif
		//Substring
		
		String str2 = "Java,Spring,Postgre,React";
//		System.out.println(str2.substring(0, 4));
//		System.out.println(str2.substring(5, 11));
//		System.out.println(str2.substring(12, 19));
//		System.out.println(str2.substring(20, 25));
		
		int index = 0;
		for(int i=0;i<str2.length();i++){
			if(str2.charAt(i)==',') {
				System.out.println(str2.substring(index,i));
				index = i+1;
			}
		}
		System.out.println(str2.substring(index));
		
		
		//Alternatif2
		for(int i = 0;i<str2.length();i++) {
			if(str2.charAt(i)==',') {
				System.out.println();
			}
			else {
				System.out.print(str2.charAt(i));
			}
		}
		
		
		
		
	}

}
