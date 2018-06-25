function f(n, s){
    var s=s.split("\n"),
        wicks=[],
        flames=[],
        rl=s.length-1,
        torchAmount=0,
        right, left;
    for(j=0;j<s[rl].length;j++) {
        if(s[rl][j] != 'X') continue;
        right = left = 0;
        for (i=rl-1;i>=0;i--) {
            if(s[i][j]=='|')continue
            if(s[i][j]=='\\'){right++;continue;}
            if(s[i][j]=='/'){left++;continue;}
            if(s[i][j]=='.' && right == left) {
                wicks.push(j,i);torchAmount++;
            };
            if(s[i][j]=='$' && right == left) {
                flames.push(j,i);torchAmount++;
            };
            break;
        }
    }
    if(!torchAmount) console.log(":(");
    else if(torchAmount < n) console.log(n-torchAmount);
    else {
        i=0;
        while(n < torchAmount) {
            n++;
            s[wicks[i]][wicks[i+1]] = "$";
            i+=2;
        }
        console.log(s.join("\n"));
    }
}
