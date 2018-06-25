
#include <iostream>
#include <fstream>
#include <sstream>
#include <string.h>
#include <iomanip>

CODEGOLF_METHOD_PLACEHOLDER


int main(int argc, char* argv[])
{
    std::string building = "1:0|1:1\n1:3|5:5|2:0\n\n3:2|5:0\n1:1|2:2";
                    int capacity = 10;
                    
    f(building, capacity);

    return 0;
}

