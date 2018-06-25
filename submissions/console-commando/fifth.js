function f(s) {
  var
    i,
    next,
    prev,
    prevPrev,
    canSomethingMove = 1;
  s = s.replace(/__/g,'_');
  while(canSomethingMove) {
    var whatCanMove = {},
      partial = '';
    canSomethingMove = 0;
    for (i = 0; s[i]; i++) {
      switch (s[i]) {
        case '|':
          next = s[i+1];
          prev = s[i-1];
          if (prev == '/' && (next == undefined || next!='\\')) {
            canSomethingMove = 1;
            whatCanMove[i]='/';
          } else if (next == '\\' && (prev == undefined || prev != '/')) {
            canSomethingMove = 1;
            whatCanMove[i]='\\';
          }
          break;
        case '\\':
          prev = s[i-1];
          prevPrev = s[i-2];
          if (prev == ' ' && prevPrev != '/' || prev == undefined) {
            canSomethingMove = 1;
            whatCanMove[i]='_';
            whatCanMove[i-1]='';
          }
          break;
        case '/':
          next = s[i+1];
          if (next == ' ' || !next) {
            canSomethingMove = 1;
            whatCanMove[i]='_';
            whatCanMove[i+1]='';
          }
          break;
      }
    }
    for (i = 0; s[i]; i++) {
      partial += whatCanMove[i] != undefined ? whatCanMove[i] : s[i];
    }
    s = partial;
  }
  console.log(s.replace(/_/g,'__'));
}


f('|/ \\|/ \\|/ \\|/ \\|')
f('///|\\\\\\')
f('| \\\\')
f('// |')
f('/||||')
f('/| /|')

console.log('own')
f('|\\ /| / /__')
f('|/____\\/______/')
f('\\\\|\\|__ |\\__')
f('__/__ |\\\\/\\__')
f('//__/\\ /\\\\\\')
f('__/ __\\__\\__ __')
f('\\\\____/\\\\|\\/')
f('/ ____/____\\ |')
f('\\____///____///\\\\__|')
f('// //  /__\\/__/__\\')
f('__ | \\__/|__/| \\|/')
f('__/__\\|/ \\__ / __/__')