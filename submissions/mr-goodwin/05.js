function f(str) {
    str = str.replace('/|||||||||||||||||\\', '#8');
    str = str.replace('/|||||||||||||||\\', '#7');
    str = str.replace('/|||||||||||||\\', '#6');
    str = str.replace('/|||||||||||\\', '#5');
    str = str.replace('/|||||||||\\', '#4');
    str = str.replace('/|||||||\\', '#3');
    str = str.replace('/|||||\\', '#2');
    str = str.replace('/|||\\', '#1');
    str = str.replace('/|\\', '#0');
    var s = ('          ' + str + '           ').split('');

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

    console.log(s.join('').trim()
        .replace('#0', '/|\\')
        .replace('#1', '//|\\\\')
        .replace('#2', '///|\\\\\\')
        .replace('#3', '////|\\\\\\\\')
        .replace('#4', '/////|\\\\\\\\\\')
        .replace('#5', '//////|\\\\\\\\\\\\')
        .replace('#6', '///////|\\\\\\\\\\\\\\')
        .replace('#7', '////////|\\\\\\\\\\\\\\\\')
        .replace('#8', '/////////|\\\\\\\\\\\\\\\\\\'));



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

        else if (k.indexOf('|\\') == 1) {
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


//
//console.log('__\\', ' => ', f('__\\'));
//console.log('/__', ' => ', f('/__'));
//console.log('/|\\', ' => ', f('/|\\'));
//console.log('__\\\\', ' => ', f('__\\\\'));
//console.log('//__', ' => ', f('//__'));
//console.log('//__|__\\\\', ' => ', f('//__|__\\\\'));
//console.log('/| /|', ' => ', f('/| /|'));
//console.log('/||||', ' => ', f('/||||'));     //  ////_
//console.log('/||||__', ' => ', f('/||||__'));   //  /////_
//console.log('/||||/', ' => ', f('/||||/'));   //  /////_
//console.log('/||||\\', ' => ', f('/||||\\')); //  ////_\            ??????
//console.log('||||\\', ' => ', f('||||\\'));   //  _\\\\
//console.log('__||||\\', ' => ', f('__||||\\'));   //  _\\\\\
//
//console.log('|/ \\|/ \\|/ \\|/ \\|', ' => ', f('|/ \\|/ \\|/ \\|/ \\|'));
//console.log('// |', ' => ', f('// |'));
//console.log('| \\\\', ' => ', f('| \\\\'));
//console.log('///|\\\\\\', ' => ', f('///|\\\\\\'));
//console.log('/| ', ' => ', f('/| '));
//console.log('/| |', ' => ', f('/| |'));
//console.log('/__\\', ' => ', f('/__\\'));
//console.log('/\\', ' => ', f('/\\'));
//console.log('/ \\', ' => ', f('/ \\'));
//
//console.log('****')
//console.log('\\||||\\', ' => ', f('\\||||\\'));   //  _\\\\\
//console.log('/||\\', ' => ', f('/||\\'));
//console.log('// ///|\\\\ \\ | \\ \\//\\|||| ||\\ ||// | | |\\| \\ ||/|', ' => ', f('// ///|\\\\ \\ | \\ \\//\\|||| ||\\ ||// | | |\\| \\ ||/|'));
//console.log('/', ' => ', f('/'));
//console.log('\\', ' => ', f('\\'));
//console.log('/ \\', ' => ', f('/ \\'));
//console.log('', ' => ', f(''));
//console.log(' ', ' => ', f(' '));
//console.log('|', ' => ', f('|'));
//console.log('  \\||||\\  // ', ' => ', f('  \\||||\\  // '));   //  _\\\\\
//
//console.log('****')
//console.log('/|||||\\', ' => ', f('/|||||\\'));   //  _\\\\\
