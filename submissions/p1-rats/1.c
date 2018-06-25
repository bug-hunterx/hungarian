void f(char *s)
{
   char string[500];
   int c,v,z,a = 0, count[255] = {0}, value[50];
   snprintf(string, sizeof string, "%s%", s);
   while (string[c] != '\0')
   {
		 int ci = (int)string[c];
         count[ci]++;
 
      c++;
   }
   for(v = 0; v < 50; v++)
   {
   	 for(z = 0; z < 255 ; z++)
   	 {
   	 	if(count[z] == v){
   	 		char ch = z;
   	 		for(a = 0 ; a < v ; a++){
   	 		printf("%c",ch);}
   	 	}
   	 }
   }
}