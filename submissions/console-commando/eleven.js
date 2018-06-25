function f(s) {
  var
    r,
    l,
    x,
    y,
    isBlocked,
    m = [],
    t,
    tu = [],
    tud = {
      'v': {x: 1, y:0},
      '^': {x: -1, y:0},
      '>': {x: 0, y:1},
      '<': {x: 0, y:-1}
    },
    tmp,
    po = {},
    tc = {},
    beams = 'qwertzuiopasdfghjklyxcvbnm',
    bc = 0,
    b,
    d,
    isCleared = true,
    isHappy = true,
    lines = (s || '').split('\n');

  for (l = 0; lines[l]; l++) {
    m[l] = [];
    for (r = 0; lines[l][r]; r++) {
      (function(e) {
        m[l][r] = e;
        if (/\d/.test(e)) {
          po[e] = (po[e] || []);
          po[e].push({x:l, y:r});
        }
        if (/[v>^<]/.test(e)) {
          tu.push({x:l, y:r, t:e, b:beams[bc++]});
        }
        if (e=='@') {
          tc[l+':'+r] = 0;
        }
      })(lines[l][r]);
    }
  }
  for (l=0; tu[l]; l++) {
    x = tu[l].x; y = tu[l].y;
    t = tu[l].t; b = tu[l].b;
    isBlocked = false;
    d = tud[t];
    while(isHappy && !isBlocked && m[x] && m[x][y]) {
      x+=d.x;y+=d.y;
      if (m[x])
      switch (m[x][y]) {
        case ' ':
          m[x][y]=b;
          break;
        case '@':
          tc[x+':'+y] = 1;
        case '#':
          isBlocked = true;
          break;
        case '/':
          tmp = (JSON.parse(JSON.stringify(d)));
          d.x = -1*tmp.y;
          d.y = -1*tmp.x;
          break;
        case '\\':
          tmp = (JSON.parse(JSON.stringify(d)));
          d.x = 1*tmp.y;
          d.y = 1*tmp.x;
          break;
        case 'v':
          isBlocked = true;
          if (d.x==-1&&d.y==0) isHappy = false;
          break;
        case '^':
          isBlocked = true;
          if (d.x==1&&d.y==0) isHappy = false;
          break;
        case '<':
          isBlocked = true;
          if (d.x==0&&d.y==1) isHappy = false;
          break;
        case '>':
          isBlocked = true;
          if (d.x==0&&d.y==-1) isHappy = false;
          break;
        default:
          tmp = m[x][y];
          if (/\d/.test(tmp)) {
            if (po[tmp][0].x == x && po[tmp][0].y == y) {
              x = po[tmp][1].x; y = po[tmp][1].y;
            } else {
              x = po[tmp][0].x; y = po[tmp][0].y;
            }
          } else {
           isHappy = false;
          }
          break;
      }
    }
  }
  var k = Object.keys(tc);
  for (l = 0; k[l] && isCleared; l++) {
    isCleared = tc[k[l]] > 0;
  }
  if (!isHappy) {
    console.log(':/');
  } else if (isCleared){
    console.log(':D');
  } else {
    console.log(':(');
  }
}
