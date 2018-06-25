function f(frequencyString) {
    
   var map = new Map();
   frequencyString.split('').map(k=>{
        if (!map.has(k)) {
           map.set(k, 0);
       }
       map.set(k, map.get(k)+1);
   });
   
  var map2 = new Map();
  for (var k of map.keys()) {
      var v = map.get(k);
      if (!map2.has(v)) {
         map2.set(v,'')
      }
      map2.set(v, map2.get(v)+k);
    }

    var result = "";
    Array.from(map2).sort((a,b) => a[0]-b[0]).forEach(a => 
    {
        var tmp="";
        for (i = 0 ; i<a[0];i++){
            tmp += a[1];
        }
        result += tmp.split('').sort().join('');
    }
    );
    console.log(result)
}