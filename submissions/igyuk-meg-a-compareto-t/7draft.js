function f(building, capacity) {
    
    var maxItem = 0;
    
    function splitter(floors, level) {
        
        var levels = ['|', ':'];
        
        var outer = [];
        
        if (level == 0) {
            floors.forEach(function (floor) {
                outer.push(splitter(floor.split(levels[level]), 1));
            });            
        }
        
        if (level == 1) {
            var inner = [];
            
            floors.forEach(function (item) {
                inner.push({
                    ppl:Number(item.split(levels[level])[0]),
                    fl:Number(item.split(levels[level])[1]) 
                })
                maxItem++;
            });
            
            return inner;
        }
        
        return outer;         
    }
    
    console.log('xxxxx, ',building);
    console.log('yyyyyy', capacity);
    
    var floorData = splitter(building.split('\n').reverse(), 0);
    
    var state = {
        actualFloor: 0,
        direction: 1,
        maxFloor: floorData.length-1,
        stops: 0,
        people: 0,
        maxItem: maxItem,
        zeroItem: 0
    }
        
    function engine() {                          
        state.actualFloor+=state.direction;
        state.stops++;      
    }
    
    function nextDirection() {
        if (state.actualFloor == state.maxFloor) {
            state.direction = -1;
        }
        if (state.actualFloor == 0) {
            state.direction = 1;
        }        
    }
    
    function movin(actualFloor) {
        actualFloor.forEach(function (item)  {
            if (state.direction == 1) {
                if (item.fl > state.actualFloor) {
                    state.people+=item.ppl;
                    item.moveOut = true;
                }
            }
            
            if (state.direction == -1) {
                if (item.fl < state.actualFloor) {
                    state.people+=item.ppl;
                    item.moveOut = true;
                }
            }
        });
    }
    
    function moveout() {
        floorData.forEach(function (item) {
            item.forEach(function (subItem) {                
                if (subItem.moveOut == true && subItem.fl == state.actualFloor) {
                    
                    if (subItem.ppl != 0) {
                        state.zeroItem++;
                    }
                    
                    state.people-=subItem.ppl;
                    subItem.ppl = 0;                                                            
                }
            });
        })
    }
    
    function decision() {
        if (state.people >= capacity) {
            console.log('polite after ',state.stops, ' at ',state.actualFloor, 'floor');
            state.done = true;
        }
                
        if (state.zeroItem == state.maxItem) {
            console.log('lonely after ',state.stops, ' at ',state.actualFloor, 'floor');
            state.done = true;
        }       
    }
    
/*    for (var i = 0; i < 7; i++) {
        nextDirection();    
        console.log('cicle: ' + i);
        console.log('before movout   ' , state);
        moveout();
        console.log('after movout    ' , state);
        console.log('before movin    ' , state);
        movin(floorData[state.actualFloor]);
        console.log('after movin     ' , state);
        console.log('before decision ' , state);     
        decision();
        console.log('after decision  ' , state);
        console.log('before engine   ' , state);
        engine();
        console.log('after engine    ' , state);
        
        
        console.log(floorData);
        
        console.log('--------------------------------');
        console.log(state.zeroItem);
    }*/
    
    do {
        nextDirection();
        moveout();
        movin(floorData[state.actualFloor]);
        decision();
        engine();
    } while (!state.done);
    
}

/*var house = '1:0|1:1\n' + '3:2|5:0\n' + '1:1|2:2';
var house2 = '2:1|3:2\n' + '1:0|1:1\n' + '3:2|5:0\n' + '1:1|2:2';
var cap = 6;
var cap2 = 10;*/ 

/*capacity:6
1:0|1:1 stop:2 5
3:2|5:0 stop:1 6
1:1|2:2 stop:0 4


capacity: 10
2:1|3:2
1:0|1:1 stop2: 1
3:2|5:0 stop1: 6
1:1|2:2 stop0: 4*/