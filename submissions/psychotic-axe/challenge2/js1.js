function f(input) {
	var rows = ['`1234567890-=!@#$%^&*()_+',
		'qwertyuiop[]\\QWERTYUIOP{}|',
		'asdfghjkl;\'ASDFGHJKL:"',
		'zxcvbnm,./ZXCVBNM<>?'];

	var occurances = ['', '', '', ''];
	var frequencies = [0, 0, 0, 0];

	rows.forEach(function(row, i) {
		for(var j = 0; j < row.length; j++) {
			var c = row.charAt(j);
			var frequency = (input.match(new RegExp(c.replace(/([^\w\d])/g, '\\$1'), 'g')) || []).length;
			if (frequency > 0) {
				occurances[i] += c;
				frequencies[i] += frequency;
			}
		}
	});

	var sortedFrequencies = [];
	for (var i = 0; i < 4; i++) {
		sortedFrequencies.push([frequencies[i], i, occurances[i].length]);
	}

	sortedFrequencies = sortedFrequencies.filter(function(a) {return a[0] != 0}).sort(function(a, b) {
			var byFreq = a[0] - b[0];
			var byRow = a[1] - b[1];
			var byUniqueChars = a[2] - b[2];
			if (byFreq != 0) return byFreq;
			if (byUniqueChars != 0) return byUniqueChars;
			if (byRow != 0) return byRow;
		});
	console.log(occurances[sortedFrequencies[0][1]]+'\n');
}
