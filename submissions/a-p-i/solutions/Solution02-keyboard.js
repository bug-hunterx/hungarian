
f('FJAFJKLDSKF7JKFDJ');
console.log("7\n")

f('ASDFDSASDFDSAzxcPOIUY')
console.log("zxc\n")

f('FGhjKL:\"\';lkqwerzxcc')
console.log("zxc\n")

f('EUIyouiepIEjhadSDJ(*Y9y9')
console.log("9*(\n")

f('ASDFASDFqwer432!')
console.log("234!\n")

f('1233AERSdfqw')
console.log("123")


function f (input) {

	keyboard = [
	            "`1234567890-=~!@#$%&*()_+",
	            "qwertyuiop[]\\QWERTYUIOP{}|",
	            "asdfghjkl;'ASDFGHJKL:\"",
	            "zxcvbnm,./ZXCVBNM<>?"];
	
	
	c = charsNotInRow(input)
	s = selectShortest(	c)
	o = sortToKeyboardOrder(s)
	console.log(o)
	
}



function charsNotInRow(input) {

    result = [];

    for (keyboardRowCheckedAgainst = 0; keyboardRowCheckedAgainst < 4; keyboardRowCheckedAgainst++) {

        remainingCharacters = removeCharacters(input, keyboard[keyboardRowCheckedAgainst]);

        for (actualRow = 0; actualRow < 4; actualRow++) {
            if (keyboardRowCheckedAgainst != actualRow) {

                charsInThisRow = actualRow.toString();

                remainingCharacters.split("").forEach(function(c) {
            	
                	if (keyboard[actualRow].indexOf(c) >= 0) {
                		charsInThisRow = charsInThisRow.concat(c);
                    }
                })
                
                if (charsInThisRow.length > 1) {
                	result.push(charsInThisRow);
                }

            }
        }

    }
    
    //console.log(result);

    return result;
}

function removeCharacters(input, characters) {

    var result = '';
    input.split("").forEach(function(c) {

    	if (characters.indexOf(c) < 0) {

        	result = result.concat(c);
        }
    })

    return result;
}

function selectShortest(input) {

    filtered = getShortest(input)

    if (filtered.length > 1) {

    	filtered = getShortest(removeDuplicateFromArray(filtered));

    }

    //todo sorting
    
    return filtered[0].substring(1);

}

function getShortest(input){
	minLength = getShortestLength(input);
	
	return input.filter(function(i){
		return i.length == minLength;  
	}).sort();
}

function removeDuplicateFromArray(input) {
	result = [];
	input.forEach(function(i){ 
		result.push(removeDuplicatedChars(i));
	})
	
	return result;
}


function removeDuplicatedChars(input) {
	replaced = input.replace(/(.)(?=.*\1)/g, "");
	return replaced;
}

function getShortestLength(input) {

    minLength = 99;

    input.forEach(function(row) {
        size = row.length;
        if (minLength > size && size != 0) {
            minLength = size;
        }
    })

    return minLength;
}

function sortToKeyboardOrder(input) {

    var result = "";

    for (row = 0; row < 4; row ++ ) {

        keyboard[row].split('').forEach(function(c) {
            index = input.indexOf(c);
            if (index >=0 ) {
            	result = result.concat(input[index]);
            }
        })

    }

    return result;
}