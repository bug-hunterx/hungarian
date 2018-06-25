
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
    var s string = "10 40 koopa goomba 20 30 piranha piranha"
                                 
    f(s)
}

func f(s string) {
	var princess, bowser string
	var coins, life, star int
	end := false
	coins, life, star = 0, 3, 0
	princess, bowser = "Princess", "Bowser"
	var tale[] string = strings.Split(s, " ")
	for index,element := range tale {
		if len(element) > 0 {
			if element == princess || element == bowser{
				fmt.Println("WIN")
				end = true
				break
			} else {
				status := len(element)
				if coin, err := strconv.Atoi(element); err == nil {
					coins += coin
					var newlife int
					newlife = coins / 100
					if newlife >= 1 {
						life += newlife
						coins -= newlife*100
					}
					fmt.Println("||life||"+strconv.Itoa(life)+"||")
					fmt.Println("||coins||"+strconv.Itoa(coins)+"||")
				} else {
					fmt.Println("||status||"+strconv.Itoa(status)+"||")
					switch status {
						case 3:
							fmt.Println("||getlife||")
							life+=1
						case 4:
							fmt.Println("||getstar||")
							star = 2	
						case 5:
							if (star < 0) {
								fmt.Println("||looselife||")
								life-=1
							}
						case 6:
							if (star < 0) {
								fmt.Println("||looselife||")
								life-=1
							}
						case 7:
							if (star < 0) {
								fmt.Println("||looselife||")
								life-=1
							}
						case 8:
							fmt.Println("||getlife||")
							life+=1
					}	
				}
				fmt.Println("||life2||"+strconv.Itoa(life)+"||")
				fmt.Println(strconv.Itoa(index)+element+princess+bowser)
			}
			star--
			if life == 0 {
				fmt.Println("GAME OVER")
				end = true
				break
			}
		}
	}
	if !end {
		fmt.Println("???")
	}
}


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