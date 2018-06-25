
/*
 Challenge #5 Domino machine
 ----------------
 You are building a Rube Goldberg device, and you plan to push a button with a string of dominos. You are trying to find the coolest configuration of dominos, and to save your time, you build a small simulator for this.

 ​*The task*​

 ```f(input: string)```

 Simulate the final state of the dominos described in the input argument and print it to `STDOUT`. Trailing/leading white-spaces are ignored.


 ​*Rules*​

 Dominoes have four states, represented by the following strings:
 ```| standing
 \ left-tilted
 / right-tilted
 __ fallen
 ```

 Your dominos follow the law of physic (to a degree); they push their neighbours and make them fall too:
 ```|\ => \\
 /| => //
 ```

 However, dominos will stop falling, if they have a stable neighbour already:
 ```/|\ => /|\
 __\ => __\
 /__ => /__
 ```

 Thus, these are all stable configurations:
 ```__\\  //__  //|\\ //__|__\\
 ```

 You are building this machine in your garage, where the floor slightly tilts to the right, so left-tilted dominos fall slower than right-tilted ones:
 ```/ \ => __\
 ```


 ​*Example Test-Cases*​

 > Note: you submission will be tested using a lot more inputs

 1. `///|\\\` => `///|\\\`
 2. `| \\` => `|__\`
 3. `// |` => `/__|`
 4. `|/ \|/ \|/ \|/ \|` => `|__\|__\|__\|__\|`
 5. `/||||` => `////__`
 6. `/| /|` => `/__/__`
 */



function f(str) {
    str = str.replace('/|||||||\\', '#3');
    str = str.replace('/|||||\\', '#2');
    str = str.replace('/|||\\', '#1');
    str = str.replace('/|\\', '#0');
    var s = (' ' + str + ' ').split('');

    /*
     /|      >> //    && != /|\
     /\      >> _\
     /' '    >> _      space remove after
     |\      >> \\    && != /|\
     ' '\    >> _      space remove before
     */

    var ch = true

    while (ch) {
        ch = false
        for (var i=0; i < Math.ceil(s.length/2); i++) {
            // console.log(s.length, i, s.length -1 -i)
            // console.log(Math.ceil(s.length/2), i, s.length -1 -i)
            b = i
            e = s.length - 1 - i

            work(s, b)
            work(s, e)
        }
    }

    return s.join('').trim()
        .replace('#0', '/|\\')
        .replace('#1', '//|\\\\')
        .replace('#2', '///|\\\\\\')
        .replace('#3', '////|\\\\\\\\');


    function work(s, j) {
        var d = s[j],
            k = neighb(j, -1) + d + neighb(j, 1);

        // debugger

        if (k.indexOf('/|') == 0 && k != '/|\\') {
            s[j] = '/'
            ch = true;
        }

        // if (k.indexOf(' /|') == 0) {
        //     s[j+1] = '/'
        //     ch = true;
        // }

        // else if (k.indexOf('|\\') == 2) {
        //     s[j] = '\\'
        //     ch = true;
        // }

        // WATCH
        // if (k.indexOf('//|') == 0) {
        //     s[j+1] = '/'
        //     ch = true;
        // }

        // WATCH
        // else if (k.indexOf('|\\') == 0) {
        //     s[j-1] = '\\'
        //     ch = true;
        // }

        else if (k.indexOf('/ ') == 0) {
            s[j-1] = '_'
            s[j] = '_'
            ch = true;
        }

        else if (k.indexOf('// ') == 0) {
            s[j] = '_'
            s[j+1] = '_'
            ch = true;
        }

/*
        else if (k.indexOf('|\\') == 1 ) {
            s[j] = '\\'
            ch = true;
        }
*/

        else if (k.indexOf('|\\') == 1 && k != '/|\\') {
            s[j] = '\\'
            ch = true;
        }

/*
        else if (k.indexOf('|\\') == 1 && k == '/|\\') {
            s[j] = '\\'
            ch = true;
        }
*/

        // WATCH
        // else if (k.indexOf(' \\') == 0) {
        //     s[j] = '__'
        //     ch = true
        // }

        else if (k.indexOf(' \\') == 1) {
            s[j] = '_'
            s[j+1] = '_'
            ch = true;
        }
    }

    function neighb(ind, offs) {
        var n = s[ind + offs]
        return n ? n : ' ';
    }
}

// TODO \||||\  =>  __|\\\\


console.log('__\\', ' => ', f('__\\'));
console.log('/__', ' => ', f('/__'));
console.log('/|\\', ' => ', f('/|\\'));
console.log('__\\\\', ' => ', f('__\\\\'));
console.log('//__', ' => ', f('//__'));
console.log('//__|__\\\\', ' => ', f('//__|__\\\\'));
console.log('/| /|', ' => ', f('/| /|'));
console.log('/||||', ' => ', f('/||||'));     //  ////_
console.log('/||||__', ' => ', f('/||||__'));   //  /////_
console.log('/||||/', ' => ', f('/||||/'));   //  /////_
console.log('/||||\\', ' => ', f('/||||\\')); //  ////_\            ??????
console.log('||||\\', ' => ', f('||||\\'));   //  _\\\\
console.log('__||||\\', ' => ', f('__||||\\'));   //  _\\\\\

console.log('|/ \\|/ \\|/ \\|/ \\|', ' => ', f('|/ \\|/ \\|/ \\|/ \\|'));
console.log('// |', ' => ', f('// |'));
console.log('| \\\\', ' => ', f('| \\\\'));
console.log('///|\\\\\\', ' => ', f('///|\\\\\\'));
console.log('/| ', ' => ', f('/| '));
console.log('/| |', ' => ', f('/| |'));
console.log('/__\\', ' => ', f('/__\\'));
console.log('/\\', ' => ', f('/\\'));
console.log('/ \\', ' => ', f('/ \\'));

console.log('****')
console.log('\\||||\\', ' => ', f('\\||||\\'));   //  _\\\\\
console.log('/||\\', ' => ', f('/||\\'));
console.log('// ///|\\\\ \\ | \\ \\//\\|||| ||\\ ||// | | |\\| \\ ||/|', ' => ', f('// ///|\\\\ \\ | \\ \\//\\|||| ||\\ ||// | | |\\| \\ ||/|'));
console.log('/', ' => ', f('/'));
console.log('\\', ' => ', f('\\'));
console.log('/ \\', ' => ', f('/ \\'));
console.log('', ' => ', f(''));
console.log(' ', ' => ', f(' '));
console.log('|', ' => ', f('|'));
console.log('  \\||||\\  // ', ' => ', f('  \\||||\\  // '));   //  _\\\\\

console.log('****')
console.log('/|||||\\', ' => ', f('/|||||\\'));   //  _\\\\\
