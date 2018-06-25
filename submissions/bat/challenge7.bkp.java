enum State {POLITE, LONELY, OK}

static class Intention
{
	NavigableMap<Integer, Integer> i = new TreeMap<>();

	public Intention(String s)
	{
		if (!s.isEmpty())
		{
			String[] f = s.split("\\|");
			for (String g : f)
			{
				i.put(Integer.valueOf(g.split(":")[1]), Integer.valueOf(g.split(":")[0]));
			}
		}
	}

	@Override
	public String toString()
	{
		return String.join("|", i.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).toArray(String[]::new));
	}
}

static class Elevator
{
	int c;
	int pp = 1;

	enum D {UP, DOWN}
	D direction = D.UP;
	Intention i = new Intention("");

	Elevator(int cc)
	{
		c = cc;
	}

	int nextFloor(int f)
	{
		return (direction == D.UP ? i.i.higherKey(f) : i.i.lowerKey(f));
	}

	State check(Intention intention, int f)
	{
		if (i.i.containsKey(f)) pp -= i.i.remove(f);
		Map<Integer, Integer> in = getNewPassengers(intention, f, 0);
		in.keySet().forEach(k -> {
			Integer ppF = i.i.get(k);
			Integer inF = in.get(k);
			i.i.put(k, inF + (ppF == null ? 0 : ppF));
			pp += inF;
		});
		in.clear();

		return pp > c ? State.POLITE : (pp == 1 ? State.LONELY : State.OK);
	}

	Map<Integer, Integer> getNewPassengers(Intention intention, int f, int counter)
	{
		Map<Integer, Integer> in = new HashMap<>();
		if (counter > 1) return in;
		if (counter > 0) direction = (direction == D.UP) ? D.DOWN : D.UP;
		if (direction == D.UP)
		{
			in = intention.i.tailMap(f);
			if (in.isEmpty() && i.i.tailMap(f).isEmpty()) return getNewPassengers(intention, f, counter+1);
		}
		else
		{
			in = intention.i.headMap(f);
			if (in.isEmpty() && i.i.headMap(f).isEmpty()) return getNewPassengers(intention, f, counter+1);
		}
		return in;
	}
}

static void f(String s, int c)
{
	Scanner sc = new Scanner(s).useDelimiter("\n");
	List<Intention> i = new ArrayList<>();
	sc.forEachRemaining(l -> i.add(new Intention(l)));

	Collections.reverse(i);
	if (i.size() >= 4) i.add(4, new Intention(""));

	solveChallenge(i, c);
}

static void solveChallenge(List<Intention> i, int c)
{
	int f = 0, s = 0;
	Elevator elevator = new Elevator(c);
	while (true)
	{
		Intention intention = i.get(f);
		State state = elevator.check(intention, f);
		if (state != State.OK)
		{
			e(state == State.POLITE ? "polite" : "lonely", s, f);
			return;
		}
		f = elevator.nextFloor(f);
		s++;
	}
}

static void e(String m, int s, int f)
{
	System.out.print(m + " after " + s + " stops at " + f + " floor");
}