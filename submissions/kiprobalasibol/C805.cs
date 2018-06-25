public class Mario
{
    public string Execute(string sequence)
    {
        var coin = 0;
        var life = 3;
        var mush = false;
        var invi = 0;
        int num;
        var win = false;

        foreach (var part in sequence.Split(' '))
        {
            if (part.Length == 0) continue;
            if (invi > 0) invi--;
            if (int.TryParse(part, out num))
            {
                coin += num;
                if (coin > 99)
                {
                    life += coin / 100;
                    coin = coin % 100;
                }
            }
            else {
                var c = part[0];
                switch (c)
                {
                    case 'S': invi = 3; break;
                    case 'M': mush = true; break;
                    case '1': life++; break;
                    default:
                        if ("gkp".IndexOf(c) > -1)
                        {
                            if (invi == 0)
                            {
                                if (mush) mush = false;
                                else life--;
                            }
                        }
                        else if ("PB".IndexOf(c) > -1)
                        {
                            win = true;
                            break;
                        }
                        else goto fail;
                        break;
                }
            }
            if (life == 0) break;
        }

        if (win) return "WIN";
        if (life == 0) return "GAME OVER";
        fail:
        return "???";
    }
}

static void f(string b)
{
    Console.WriteLine(new Mario().Execute(b));
}
