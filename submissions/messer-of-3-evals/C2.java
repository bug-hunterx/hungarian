package hackathon;

import java.util.Arrays;
public class C2{
	
public static void f(String s){
	
		String e1 = new String("1234567890-=!@#$%^&*()_+");
		String k1 = new String("qwertyuiopQWERTYUIOP{}|");
		String h1 = new String("asdfghjklASDFGHJKL:\"");
		String n1 = new String("zxcvbnm,./ZXCVBNM<>?");
	
		// counts of chars in keyboard lines; tmp, order 
		Integer [] y={0,0,0,0,0,1,2,3,4};
		
				
		String l1 = new String();
		String l2 = new String();
		String l3 = new String();
		String l4 = new String();
		
		for(char q : s.toCharArray()) 
		{

		String a = String.valueOf(q);
		
		if(e1.contains(a))
			{
			y[0]+=1;
			if (!l1.contains(a))
			l1=l1.concat(a);
			};
		if(k1.contains(a))
			{
			y[1]+=1;
			if (!l2.contains(a))
			l2=l2.concat(a);
			};
		if(h1.contains(a))
			{
			y[2]+=1;
			if (!l3.contains(a))
			l3=l3.concat(a);
			};
		if(n1.contains(a))
			{
			y[3]+=1;
			if (!l4.contains(a))
				l4=l4.concat(a);
			};
		}


System.out.println("-----------");
System.out.println(l1);
System.out.println(l2);
System.out.println(l3);
System.out.println(l4);


for (int i = 0; i < 4; i++) {
    for (int j = 1; j < (4 - i); j++) {
        if (y[j - 1] > y[j]) {
        	y[4] = y[j - 1];
            y[j - 1] = y[j];
            y[j] = y[4];
        }
    }
}


System.out.println("-----------");
System.out.println(y[0]);
System.out.println(y[1]);
System.out.println(y[2]);
System.out.println(y[3]);

/*System.out.println("-----------");
System.out.println(y[5]);
System.out.println(y[6]);
System.out.println(y[7]);
System.out.println(y[8]);
*/

if(y[0]==0 && y[1]==0 && y[2]==0)
	{System.out.println(y[3]);}

// there is a biggest line
if(y[3]>y[2])
{
	// if third bigger than second, then syso third
if (y[2]>y[1])	
	System.out.println();

}

	

}



public static void main(String[] args){
String s = "FJAFJKLDSKF7JKFDJ";
f(s);
s = "ASDFDSASDFDSAzxcPOIUY";
f(s);
s = "FJAFJKLDSKF7JKFDJ";
f(s);
s = "qwERfgHJ123456789";
f(s);
s = "FJAFJKLDSKF7JKFDJ";
f(s);
s = "FGhjKL:\";'lkqwerzxcc`";
f(s);
 s = "ASDFASDFqwer432!";
f(s);
s = "EUIyouiepIEjhadSDJ(*Y9y9`";
f(s);
s = "1233AERSdfqw";
f(s);
s = "ASDF11!*&+1`";
f(s);
s = "}*3%&2098@$2k234#@$M";
f(s);
s = "wqfdSREA3321";
f(s);
s = ":X:D:):DDDDDDDxDDDD:(;);];]";
f(s);





}
}
