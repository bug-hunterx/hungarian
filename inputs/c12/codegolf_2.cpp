
#include <iostream>
#include <fstream>
#include <sstream>
#include <string.h>
#include <iomanip>

CODEGOLF_METHOD_PLACEHOLDER


int main(int argc, char* argv[])
{
    std::string scene = "        \nv><vw<<^\nvv>>>^^v\nv<HwW<<^\nvW^W>Hw^\nv<<h<<<^\nv>>>>>>^\n >>>>>>h";
                    int width = 3;
                    int height = 2;
                    
    f(scene, width, height);

    return 0;
}

