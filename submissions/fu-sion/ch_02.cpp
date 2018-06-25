void f(char s[]){
	//char[]char[] r = { "`1234567890-=~!@#$%^&*()_+", "qwertyuiop[]QWERTYUIOP{}", "asdfghjkl;\'\\ASDFGHJKL:\"", "zxcvbnm,./ZXCVBNM<>?" };
    int i=0, c=1,m = -1, f[256] = {0};
    for(; s[i] != '\0'; i++){
        int a = ++f[s[i]];
        if ( m < a) { m = a; }
    }

    for(; c <= m; c ++) {
        for(i=0; i < 256; i++){
            if(f[i] == c ){
                for(;f[i]--;printf("%c",i));
            }
        }
    }
}
