void f(std::string input, int n, int width) {
    int numberOfLines = input.length() / (n*width);
    if(input.length() % (n*width) != 0) {
        ++numberOfLines;
    }
    
    for(int line=1;line<=numberOfLines;++line) {
        for(int col=1;col<=n;++col) {
            for(int ch=0;ch<width;++ch) {
                int index = (numberOfLines*width)*(col-1) + ((line-1)*width) +ch;
                std::cout << (index>=input.length() ? ' ' : input.at(index));
            }
            if(col!=n) std::cout << "|";
        }
        //if(line!=numberOfLines)
        std::cout << "\n";
    }
}