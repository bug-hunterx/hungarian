function f(input) {
	var c = '`1234567890-=~!@#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;\'ASDFGHJKL:"zxcvbnm,./ZXCVBNM<>?';
	var p = '0000000000000000000000000011111111111111111111111111222222222222222222222233333333333333333333';

	var out = [{},{},{},{}];
	var map = {};

	c.split('').map((v, k)=>{
		map[v] = p[k];
		map[v.toUpperCase()] = p[k];
	});

	input.split('').forEach((c)=>{
		out[map[c]][c] = out[map[c]][c] ? out[map[c]][c] + c : c;
	});

	out = out.filter((a)=>{
		return Object.keys(a).length
	});

	out.sort((a,b)=>{
		var alen = Object.keys(a).map(k => a[k]).join('').length;
		var blen = Object.keys(b).map(k => b[k]).join('').length;
		var ak = Object.keys(a);
		var bk = Object.keys(b);
		var al = ak.length;
		var bl = bk.length;
		var x = alen;
		var y = blen;
		//console.log( x, y,Object.keys(a).map(k => a[k]).join(''), Object.keys(b).map(k => b[k]).join('') );
		if(x==y){
			x=al;y=bl;
			if( x == y ) {
				x=map[ak[0]];y=map[bk[0]];
			}
		}
		return x>y?1:-1;
	});

	console.log( Object.keys(out[0]).join(''));
}

//f('FJAFJKLDSKF7JKFDJ');
//f('ASDFDSASDFDSAzxcPOIUY');
//f('qwERfgHJ123456789');
//f('FGhjKL:"\';lkqwerzxcc');
//f('ASDFASDFqwer432!');
//f('EUIyouiepIEjhadSDJ(*Y9y9');
//f('1233AERSdfqw');
//f('ASDF11!*&+1');
//f('}*3%&2098@$2k234#@$M');
//f('wqfdSREA3321');
//f(':X:D:):DDDDDDDxDDDD:(;);];]');