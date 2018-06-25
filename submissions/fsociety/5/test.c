void f(char*s)
{
	int l=strlen(s);
	char a[l+3];
	char b[l+3];
	strcpy(a+1,s);
	strcpy(b+1,s);
	*a=' ';
	*b=' ';
	a[l+2]=0;
	b[l+2]=0;
	
	char*i=b+1,*o=a+1,*x;
	int c,t;
	do
	{
		t=0;
		x=i;
		i=o;
		o=x;
		//printf("(%s) ", i);
		for(c=0;c<l;c++)
		{	
			o[c] = i[c];
			if(i[c] == '|')
			{
				if(i[c-1] == '/')
				{
					if(i[c+1] != '\\')
					{
						o[c]='/';
						t++;
					}
				}
				else if(i[c+1] == '\\')
				{
					if(i[c-1] != '/')
					{
						o[c]='\\';
						t++;
					}
				}
			}
			else if(i[c] == '\\')
			{
				if(i[c-1] <= ' ')
				{
					o[c] = '_';
					o[c-1] = '_';
					i[c-1] = '_';
					t++;
				}
			}
			else if(i[c] == '/')
			{
				if(i[c+1] <= ' ')
				{
					o[c] = '_';
					o[c+1] = '_';
					i[c+1] = '_';
					t++;
				}
			}
		}
	} while(t);

	printf("%s\n", i-1);
}