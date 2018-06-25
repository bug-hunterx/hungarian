static void f(int i, char *s, double l, char *file, char *c, int count){
	char buf[256];
	snprintf(buf, sizeof buf, "%i%s%.12g%s%s", i, s, l, file, c);
	int a;
	for(a=0; a<count; a++) {
		printf("%s", buf);
	}
}