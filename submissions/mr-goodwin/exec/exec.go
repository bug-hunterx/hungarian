
package main

import (
    "fmt"
    "strings"
    "bytes"
    "io/ioutil"
    "strconv"
    "runtime"
)

func main() {
    var i int = 12
                    var s string = "apple"
                    var l float64 = 3.14
                    var filex string = "/challenge_input/c0/input1.txt"
                    var c byte = 'a'
                    var count int = 3
                    
    f(i, s, l, filex, c, count)
}

CODEGOLF_METHOD_PLACEHOLDER


func dummyfuncforincludes(){
    dat, err := ioutil.ReadFile("pear")

    if err != nil {
        panic(err)
    }

    fmt.Println(string(dat))

    var buffer bytes.Buffer
    fmt.Println(buffer.String())

    b, err := strconv.ParseBool("true")
    if err != nil {
        panic(err)
    }

    fmt.Println(strconv.FormatBool(b))

    r := []string{}
    strings.Join(r, "")

    fmt.Println(runtime.Compiler, runtime.GOARCH, runtime.GOOS)
    fmt.Println(strconv.IntSize)
}



