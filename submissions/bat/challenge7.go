var	sRows = []string{
		"`1234567890-=~!@#$%^&*()_+",
		"qwertyuiop[]QWERTYUIOP{}|\\",
		"asdfghjkl;'ASDFGHJKL:\"",
		"zxcvbnm,./ZXCVBNM<>?",
	}

func removeDuplicates(a []string) []string {
        result := []string{}
        seen := map[string]bool{}
        for _, val := range a {
                if _, ok := seen[val]; !ok {
                        result = append(result, val)
                        seen[val] = true
                }
        }
        return result
} 

var ind = 0

type byJa []string

func (s byJa) Len() int {
	return len(s)
}

func (s byJa) Swap(i,j int) {
	s[i], s[j] = s[j], s[i]
}

func (s byJa) Less(i, j int) bool {
	return strings.Index(sRows[ind], s[i]) < strings.Index(sRows[ind], s[j])
}

func f(s string) {
	#s := "qwERfgHJ123456789"
	kRows := []*regexp.Regexp{
		regexp.MustCompile("[^`1234567890-=~!@#$%^&*()_+]"),
		regexp.MustCompile("[^qwertyuiop\\[\\]\\|{}QWERTYUIOP]"),
		regexp.MustCompile("[^asdfghjkl;'ASDFGHJKL:\"]"),
		regexp.MustCompile("[^zxcvbnm,./ZXCVBNM<>?]"),
	}

	lines := []string{s,s,s,s}

	m := 0
	minL := ""

	for i, line := range lines {
		l := kRows[i].ReplaceAllString(line, "");
		if len(l) > 0 && (len(l) <= m || m == 0) {
			if len(l) == m {
				lU := len(removeDuplicates(strings.Split(l,"")))
				mU := len(removeDuplicates(strings.Split(minL,"")))
				if lU <= mU {
					if lU == mU {
						if ind > 1 {
							m = len(l)
							minL = l
							ind = i
						}
					} else {
						m = len(l)
						minL = l
						ind = i
					}
				}
			} else {
				m = len(l)
				minL = l
				ind = i
			}
		}
	}

	splited := strings.Split(minL,"")
	sort.Sort(byJa(splited))
	uniq := removeDuplicates(splited)	
	fmt.Println(strings.Join(uniq, ""))
}