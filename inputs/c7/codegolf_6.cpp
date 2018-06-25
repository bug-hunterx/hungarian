
#include <iostream>
#include <fstream>
#include <sstream>
#include <string.h>
#include <iomanip>

CODEGOLF_METHOD_PLACEHOLDER


int main(int argc, char* argv[])
{
    std::string building = "1:3\n1:5|1:2\n1:3|1:1\n1:2|1:0\n1:1";
                    int capacity = 2;
                    
    f(building, capacity);

    return 0;
}

