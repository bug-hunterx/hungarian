func f(s string) {
	var princess, bowser string
	var coins, life, star int
	end, super := false, false
	coins, life, star = 0, 3, -1
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
					if coin, err := strconv.Atoi(element); err == nil && coin > 0 {
						coins += coin
						var newlife int
						newlife = coins / 100
						if newlife >= 1 {
							life += newlife
							coins -= newlife*100
						}
					} else {
						switch element {
							case "1Up":
								life+=1
							case "Star":
								star = 2	
							case "koopa":
								if (star < 0) {
									life-=1
									super = false
								}
							case "goomba":
								if (star < 0) {
									life-=1
									super = false
								}
							case "piranha":
								if (star < 0) {
									life-=1
									super = false
								}
							case "Mushroom":
								if (!super) {
									life+=1
									super = true
								}
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