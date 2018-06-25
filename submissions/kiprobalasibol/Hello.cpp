void f(int i, std::string s, double l, std::string file, char c, int count) {
	std::stringstream sstm;
	sstm << std::setprecision(12) << i << s << l << file << c;
	for(int a=0; a<count; a++) {
		std::cout << sstm.str();
	}
}