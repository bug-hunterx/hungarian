func f(i int, s string, l float64, file string, c byte, count int) {
	r := []string{}
	for j := 0; j < count; j++ {
	    r = append(r, strconv.FormatInt(int64(i), 10))
	    r = append(r, s)
	    r = append(r, strconv.FormatFloat(l, 'g', -1, 64))
	    r = append(r, file)
	    r = append(r, string(c))
	}

	fmt.Println(strings.Join(r, ""))
}