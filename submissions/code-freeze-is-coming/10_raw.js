function f(n, sc){
  var scene = sc.split("\n").reverse();
  var wicks = [];
  var result = '';
  var torch = 0;
  for(var i = 0; i < scene[0].length; i++){
    if(scene[0][i] === 'X'){
      var balance = 0;
      var valid = true;
      for(var j = 1; j < scene.length; j++){
        switch(scene[j][i]){
          case '|':
            break;
          case '/':
            if(balance < 1){
              balance++;
            } else {
              valid = false;
            }
            break;
          case '\\':
            if(balance > -1) {
              balance--;
            } else {
              valid = false;
            }
            break;
          case '.':
            if(balance === 0){
              wicks.push({line: j, column: i});
              torch++;
            } else{
              valid = false;
            }
            break;
          case '$':
            if(balance === 0){
              n--;
              torch++;
            } else {
              valid = false;
            }
            break;
          default:
            valid = false;
            break;
        }
        if(!valid){break;}
      }
    }
  }
  if(!torch){
    result = ':(';
  } else if(n < 0){
    result = n;
  } else if(n > wicks.length){
    result = n-wicks.length;
  } else {
    for(var k = 0; k < n; k++){
      var wick = wicks[k];
      scene[wick.line] = replaceAt(scene[wick.line], wick.column, '$');
    }
  }
  if(!result){
    result = scene[0];
    for(var l = 1; l < scene.length; l++){
      result = scene[l] + "\n" + result;
    }
  }
  console.log(result);  
  
  function replaceAt(str, index, character) {
    return str.substr(0, index) + character + str.substr(index+character.length);
  }
}