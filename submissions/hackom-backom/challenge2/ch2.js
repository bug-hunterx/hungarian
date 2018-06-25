function f(input) {
    var shortest,
        keyboards = [
        {
            template: "`1234567890-=~!@#$%^&*()_+",
            found: ''
        },
        {
            template: "qwertyuiop[]\\QWERTYUIOP{}|",
            found: ''
        },
        {
            template: "asdfghjkl;'ASDFGHJKL:\"",
            found: ''
        },
        {
            template: "zxcvbnm,./ZXCVBNM<>?",
            found: ''
        }
    ];
    keyboards.forEach((kb) => {
        kb.template.split('').forEach((c, index) => {
            if (input.indexOf(c) > -1) {
                kb.found += c;
                if (!shortest) {
                    shortest = kb;
                } else if (kb.found.length < shortest.found.length && index < keyboards.indexOf(shortest)) {
                    shortest = kb;
                }
            }
        });
    });
    
    console.log(shortest.found);
}