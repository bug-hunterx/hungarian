func f(s string) {
	var princess, bowser string
	var coins, life, star int
	end := false
	coins, life, star = 0, 3, 0
	princess, bowser = "Princess", "Bowser"
	if len(s) != 0 {
		var tale[] string = strings.Split(s, " ")
		for _,element := range tale {
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
					} else {
						switch status {
							case 3:
								life+=1
							case 4:
								star = 2	
							case 5:
								if (star < 0) {
									life-=1
								}
							case 6:
								if (star < 0) {
									life-=1
								}
							case 7:
								if (star < 0) {
									life-=1
								}
							case 8:
								life+=1
						}	
					}
				}
				star--
				if life == 0 {
					fmt.Println("GAME OVER")
					end = true
					break
				}
			}
		}
	}
	if !end {
		fmt.Println("???")
	}
}