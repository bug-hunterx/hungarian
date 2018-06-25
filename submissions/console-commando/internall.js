function f(s) {
  var i,
      j,
      regexpList=[
        /[`\d-=~!@#$%^&*()_+]/g,
        /[qwertyuiop[\]\\{\}\|]/ig,
        /[asdfghjkl:";']/ig,
        /[zxcvbnm,.\/<>?]/ig
      ],
      result = {
        m:9007199254740991
      },
      order='`1234567890-=~!@#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;\'ASDFGHJKL:"zxcvbnm,./ZXCVBNM<>?';
  for (i=0; regexpList[i]; i++) {
    (function(rowCharacterList) {
      var temp = {}, uniqueList = [];
      for (j=0; rowCharacterList[j]; j++) {
        if (!temp[rowCharacterList[j]]) {
          temp[rowCharacterList[j]] = 1;
          uniqueList[j]=rowCharacterList[j];
        }
      }
      (function(charList, uniqueList) {
        var numberOfChars = charList.length, numberOfUniqueChars = uniqueList.length;
        if((numberOfChars>0&&numberOfChars<result.m)||(numberOfChars>0&&numberOfChars===result.m&&result.u>numberOfUniqueChars)){
          result.m=numberOfChars; result.l=i; result.u=numberOfUniqueChars; result.ul=uniqueList;
        }
      })(rowCharacterList, uniqueList);
    })((s.match(regexpList[i])||[]));
  }
  console.log(result.ul.sort(function(a,b) {return order.indexOf(a)-order.indexOf(b)}).join(''));
}

f('FJAFJKLDSKF777JKFDJ')