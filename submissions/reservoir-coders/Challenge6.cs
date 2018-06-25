static void f(int c)
{
    int tip;
    if (c<2000)
    {
        tip = (100 - (c % 100)) % 100;
    }
    else if (c<5000)
    {
        tip = (500 - (c % 500)) % 500;
    }
    else
    {
        tip = (int)(c / 10);
        var a = (c+tip) % 500;
        if (a>250)
        {
            tip += 500-a;
    	}
        else
        {
            tip -= a;
        }
    }
    if (tip == 0 || tip > 1500)
    {
        Console.WriteLine("PAID BY CARD");
    }
    else if (tip % 100 > 0)
    {
        Console.WriteLine("KEEP THE CHANGE YOU FILTY ANIMAL");
    }
    else
    {
        Console.WriteLine("HERE IS {0}", tip+c);
    }
}