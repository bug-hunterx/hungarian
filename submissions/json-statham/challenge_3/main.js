function f() {

var terms = ["", 
"Ghostbusters", 
"If there's something strange",
"In you neighborhood", 
"Who you gonna call",
"If there's something weird",
"And it don't look good",
"I ain't afraid of no ghost",
"If you're seeing things",
"Running through your head",
"An invisible man",
"Sleeping in your bed",
"If you're all alone",
"Pick up the phone",
"And call",
"I here it likes the girls",
"Yeah yeah yeah yeah",
"Who ya gonna call",
"If you've had a dose of a",
"Freaky ghost baby",
"You better call",
"Lemme tell ya something",
"Bustin' makes me feel good",
"Don't get caught alone no no",
"When it comes through your door",
"Unless you just want some more",
"I think you better call",
"I can't hear you",
"Louder",
"Who can ya call",
"Who can you call"
];

var lyrics = [1,2,3,4,1,5,6,4,1,0,7,7,0,8,9,30,1,10,11,4,1,0,7,7,0,4,1,12,13,14,1,0,7,15,7,16,0,17,1,0,18,19,20,1,0,21,22,0,7,7,0,23,0,1,0,24,25,26,1,0,17,1,0,17,1,0,26,1,0,17,1,0,27,17,1,0,28,1,0,17,1,0,29,1,0,17,1,0];
for (i = 0; i < lyrics.length; i++) {
    console.log(terms[lyrics[i]]);
}

}