
#include <iostream>
#include <fstream>
#include <sstream>
#include <string.h>
#include <iomanip>

CODEGOLF_METHOD_PLACEHOLDER


int main(int argc, char* argv[])
{
    std::string building = "4:2|1:5|2:0\n1:1|2:0\n2:0\n1:0\n1:5|3:6|1:0\n1:1|1:3|2:5";
                    int capacity = 11;
                    
    f(building, capacity);

    return 0;
}

