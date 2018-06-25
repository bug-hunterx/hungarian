package hackathon;

import java.util.Arrays;

public class ChallengeTwo {
	
	public static void main(String[] args) {
		f("FJAFJKLDSKF7JKFDJ");//7
		f("ASDFDSASDFDSAzxcPOIUY");//zxc
		f("qwERfgHJ123456789");//qwER
		f("FGhjKL:\"';lkqwerzxcc");//zxc
		
		f("ASDFASDFqwer432!"); // 234!
		f("EUIyouiepIEjhadSDJ(*Y9y9");
		f("1233AERSdfqw");
		f("}*3%&2098@$2k234#@$M");
	}
	
	public static void f(String input){		
		String charaters = "`1234567890-=~!@#$%^&*()_+qwertyuiop[]QWERTYUIOP{}  asdfghjkl;'ASDFGHJKL:\"    zxcvbnm,./ZXCVBNM<>?";		
		int[] frequencyCounter = new int[4];		
		String[] inputStringSeparatorByIndex = {"","","",""}; 
		
		input.chars().forEach(x -> {			
			int quertyIndex = charaters.indexOf(Character.toLowerCase((char)x));
			frequencyCounter[quertyIndex/26]++;
			
			String s = inputStringSeparatorByIndex[quertyIndex/26];
			if(s.indexOf((char)x)<0){
				inputStringSeparatorByIndex[quertyIndex/26] += (char)x;
			}
			
		});
		
		int minIndex = 0,minValue=99,length=99;
		
		for(int z = 0; z< 4;z++){
			if(frequencyCounter[z] <= minValue && frequencyCounter[z] > 0){
				String word = inputStringSeparatorByIndex[minIndex];
				if(frequencyCounter[z]==minValue && word.length() <= length ){
					
				}else{
					minValue = frequencyCounter[z];minIndex=z;
					length = word.length();
				}
				
			}
		}
		String winner = inputStringSeparatorByIndex[minIndex];
		charaters.chars().forEach(x -> {
									if(winner.indexOf(x) >-1) 
										System.out.print((char)x);}
								) ;
		System.out.println();
		
	}

}
