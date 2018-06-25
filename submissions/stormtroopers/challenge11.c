#include <ctype.h>
#define X(i,j) i*width+j

#define UP 0
#define DOWN 1
#define LEFT 2
#define RIGHT 3

#define EMPTY ' '
#define LASER '*'
#define EXPLOSION 'x'

int width,height;
char *scene,*laser;

char* copy(char* s) {
	char* r = (char*) malloc((strlen(s)+1) * sizeof(char));
	*(r+strlen(s)) = 0;
	strcpy(r, s);
	return r;
}
int find_item(char* map, char c, int *i, int *j) {
	char* p;
	int ii, jj;
	for(ii=*i;ii<height;ii++) {
		for(jj=*j+1;jj<width;jj++) {
			p = map+X(ii,jj);
			if (*p == c) {
				*i = ii;
				*j = jj;
				printf("%c found (%d, %d)\n", c, *j, *i);
				return 1;
			}
		}
	}
	*i = *j = 0;
	return 0;
}
void step(int i, int j, int dir) {
	int ii, jj, found;
	char c;

	c = scene[X(i,j)];
	if (isdigit(c)) {
		ii = jj = 0;
		found = find_item(scene, c, &ii, &jj);
		if (ii == i && jj == j) 
			found = find_item(scene, c, &ii, &jj);
		if (found)
			step(ii,jj,dir);
		return;
	}
	laser[X(i,j)] = (laser[X(i,j)] == EMPTY) ? LASER : EXPLOSION;
	if (c == '#' || c == '@' || c == 'v' || c == '^' || c == '>' || c == '<')
		return;
	if (c == '\\') {
		switch(dir) {
			case UP:
				dir = LEFT;
			break;
			case DOWN:
				dir = RIGHT;
			break;
			case LEFT:
				dir = DOWN;
			break;
			case RIGHT:
				dir = UP;
			break;
		}
	} else if (c == '/') {
		switch(dir) {
		case UP:
				dir = RIGHT;
		break;
		case DOWN:
				dir = LEFT;
		break;
		case LEFT:
				dir = UP;
		break;
		case RIGHT:
				dir = DOWN;
		break;
		}
	}
	switch(dir) {
		case UP:
			if (i>0)
				step(i-1,j,dir);
		break;
		case DOWN:
			if (i<height-1)
				step(i+1,j,dir);
		break;
		case LEFT:
			if (j>0)
				step(i,j-1,dir);
		break;
		case RIGHT:
			if (j<width-3)
				step(i,j+1,dir);
		break;
	}
}
void f(char* str) {
	int i,j,found;
	char *p;
	scene = copy(str);
	for (i=0, height=1, p = scene; p[i]; i++) {
		height += (p[i] == '\n');
	}
	printf("height %d\n", height);
	char *t = strtok(scene, "\n");
	width = strlen(t) + 2;
	printf("width %d\n", width);
	laser = (char*) malloc(width*height*sizeof(char));
	memset(laser, EMPTY, sizeof(laser));
	laser[strlen(laser)-1] = 0;
	
	i = j = 0;
	while(find_item(scene, '^', &i, &j))
		step(i, j, UP);
	i = j = 0;
	while(find_item(scene, 'v', &i, &j))
		step(i, j, DOWN);
	i = j = 0;
	while(find_item(scene, '<', &i, &j))
		step(i, j, LEFT);
	i = j = 0;
	while(find_item(scene, '>', &i, &j))
		step(i, j, RIGHT);

	if(find_item(laser, EXPLOSION, &i, &j)) {
		printf(":/");
		return;
	}

	i = j = 0;
	while(find_item(scene, '@', &i, &j)) {
		if (laser[X(i,j)] == EMPTY) {
			printf(":(");
			return;
		}
	}
	printf(":D");
	return;
}
