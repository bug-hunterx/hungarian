import re
def f(scene, width, height):
	poslx=0
	posly=0
	snapshots=[]
	(origtable,H,W, direction) = ([line for line in scene.split('\n')], True, True, '>')
	while '' in origtable:
		origtable.remove('')
	while(True):
		newsnapshot = take_snapshot(origtable, poslx, posly, width, height)
		(newsnapshot,H,W) = updatedSnapshot(newsnapshot,poslx, posly, width, height, H, W)
		if isOut(origtable, newsnapshot,poslx, posly, width, height):
			print("9!")
			break
		if isStuck(snapshots, newsnapshot, poslx, posly, width, height, direction):
			print("8!")
			break
		else:
			snapshots.append(newsnapshot+direction+str(poslx)+str(posly))
		(m, direction) = calculateMove(newsnapshot, direction)
		if m == '<':
			poslx -= 1
		elif m == '>':
			poslx += 1
		elif m == 'v':
			posly += 1
		else:
			posly -= 1

def take_snapshot(table, x, y,width, height):
	return ''.join([table[i][max(x,0):min(x+width, len(table[0]) - 1)] for i in range(max(y,0),min(y+height,len(table) - 1))])

def isOut(table,newsnapshot,x, y, width, height):
    return (x <= -width) or (x >= len(table) - 1) or (y <= -height) or (y >= len(table[0]) - 1 or (newsnapshot.strip == 0))

def isStuck(snapshots, newsnapshot, x, y, width, height, direction):
	if len(snapshots) > 0:
		print("-->****",(newsnapshot+direction+str(x)+str(y))[-4])
	if newsnapshot+direction+str(x)+str(y) in snapshots:
		print("Snapshot found!")
		return True
	elif newsnapshot.strip == 0:
		return False
	else:
		return False

def checkSnapshot(snapshots, snapshot, x, y):
	for i in snapshots:
		if i[-4] == snapshot[-4] and snapshot.count('<') == i.count('<') and snapshot.count('>') == i.count('>') and snapshot.count('>') == i.count('>') and snapshot.count('v') == i.count('v'):
			return True
	return False

    
def updatedSnapshot(snapshot,x, y, width, height, H, W):
	field = snapshot[:]
	newH = H;
	newW = W;
	if H == False:
		if snapshot.count('H') <= snapshot.count('h'):
			field.replace('>', '').replace('<', '')
		else:
			newH = True

	if W == False:
		if snapshot.count('W') <= snapshot.count('w'):
			field.replace('^', '').replace('v', '')
		else:
			newW = True
	return (field, newH, newW)

def calculateMove(snapshot, direction):
	left=snapshot.count('<')
	right=snapshot.count('>')
	up=snapshot.count('^')
	down=snapshot.count('v')

	upCandidate = up - down
	leftCandidate = left - right
	if upCandidate > 0:
		if leftCandidate == upCandidate:
			if direction == '^' or direction == 'v':
				return ('v', 'v')
			else:
				return ('>', '>')
		elif -leftCandidate == upCandidate:
			if direction == '^' or direction == 'v':
				return ('^', '^')
			else:
				return ('>', '>')
		elif leftCandidate > upCandidate:
			return ('<', '<')
		elif -leftCandidate > upCandidate:
			return ('>', '>')
		else:
			return ('^', '^')
	elif upCandidate == 0:
		if leftCandidate > 0:
			return ('<', '<')
		else:
			return ('>', '>')
	else:
		if leftCandidate == upCandidate:
			if direction == '^' or direction == 'v':
				return ('v', 'v')
			else:
				return ('>', '>')
		elif -leftCandidate == upCandidate:
			if direction == '^' or direction == 'v':
				return ('v', 'v')
			else:
				return ('>', '>')
		elif leftCandidate < upCandidate:
			return ('>', '>')
		elif leftCandidate > upCandidate and leftCandidate < -upCandidate:
				return ('v', 'v')
		elif leftCandidate > -upCandidate:
				return ('<', '<')
		else:
			return ('v', 'v')
