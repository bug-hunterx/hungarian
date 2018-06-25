function f(s) {

  var rows = [];
  rows.push(create('`1234567890-=~!@#$%^&*()_+'), create('qwertyuiop[]QWERTYUIOP{}\\|'), create('asdfghjkl;\'ASDFGHJKL:"'), create('zxcvbnm,./ZXCVBNM<>?'));
  
  for(var i = 0; i < s.length; i++){
    var reg = new RegExp(s[i].replace(/([.?*+^$[\]\\(){}|-])/g, "\\$1"), "g");
    rows.forEach(function(row,j){
      var res = reg.exec(row.reg);
      if(res !== null){
        row.counter++;
        if(!row.set.has(s[i])){
          row.order.push({char: s[i], index: res['index']});
        }
        row.set.add(s[i]);
      }
    });
  }
  var result = null;
  rows.forEach(function(row){
    if(row.counter > 0){
      if(result === null || 
         row.counter < result.counter || (row.counter === result.counter && row.set.size < result.set.size)){
        result = row;
      } 
    }
  });
  result.order.sort(function(a,b){
    return a.index - b.index;
  })
  var finalResult = '';
  result.order.forEach(function(c) {
    finalResult = finalResult + c.char;
  });
  console.log(finalResult);
  
  function create(reg){
    var r = {counter: 0, reg: reg, set: new Set(), order: []};
    return r;
  }
}