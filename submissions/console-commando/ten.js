function f(i,s) {
  var
    l,
    c,
    a,
    r = [],
    t = {
      l:0,
      u:0
    },
    u = {},
    lines = s.split('\n'),
    d = lines[0].length;
  for (l = 0; lines[l]; l++) {
    for (c = 0; lines[l][c]; c++) {
      r[c] = (r[c] || '') + lines[l][c];
    }
  }
  for (l = 0; r[l]; l++) {
    a = r[l].match(/\$[|\\/]+X$/) || [];
    if (a[0]&&b(a[0])) {
      t.l++;
    }
    a = r[l].match(/\.[|\\/]+X$/) || [];
    if (a[0]&&b(a[0])) {
      u[t.u] = {x: l, y: r[l].length - a[0].length};
      t.u++;
    }
  }
  function b(s) {
    return !/(\\\\|\/\/)/.test(s) && ((s.match(/\\/g) || []).length - (s.match(/\//g) || []).length) == 0;
  }

  if (t.u + t.l == 0) {
    console.log(':(');
  } else if (i > t.u + t.l) {
    console.log(i - t.u - t.l);
  } else if (i < t.l) {
    console.log(i-t.l);
  } else {
    for (l = 0; t.l + l < i; l++) {
      s = light(s, (d+1)*u[l].y + u[l].x);
    }
    console.log(s);
  }
  function light(str, index) {
    return str.substr(0,index) + '$' + str.substr(index+1);
  }
}

f(2,
  "      #   \n" +
  "  . \\     \n" +
  "$ | | $   \n" +
  "| X / !   \n" +
  "    X X  ")

f(2,
  "*    *  .    \n" +
  "   ~ .  \\    \n" +
  "  .  |  |  $ \n" +
  "  |  X  /  | \n" +
  "  X     X  X ")
f(2,
  "       &        \n" +
  "    *   ##      \n" +
  "  ~    .   *  * \n" +
  "     . \\     *  \n" +
  "  .  | |  $     \n" +
  "  |  X /  |     \n" +
  "  X    X  X     ")
f(2,
  "    .    \n" +
  "  . \\    \n" +
  ". \\ | $  \n" +
  "| / / |  \n" +
  "X X X X  ")


f(5,
  "    .   \n" +
  "  . \\   \n" +
  "$ | | $ \n" +
  "| X / | \n" +
  "X   X X ")
f(1,
  "    .   \n" +
  "  . \\   \n" +
  "$ | | $ \n" +
  "| X / | \n" +
  "X   X X ")