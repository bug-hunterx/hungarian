static void f(int input)
        {
            int tip = 0;
            if (input < 2000)
            {
                tip = ((input + 99) / 100) * 100 - input;
            } else if (input < 5000)
            {
                tip = ((input + 499) / 500) * 500 - input;
            } else
            {
                tip = (((int)(input * 1.1) + 499) / 500) * 500 - (int)(input);
            }

            if (tip == 0 || tip > 1500) {
                Console.WriteLine("PAID BY CARD");
            }
            else if(((double)tip /100) > Math.Floor((double)((double)tip / 100)))
            {
                Console.WriteLine("KEEP THE CHANGE YOU FILTY ANIMAL");
            } else
            {
                Console.WriteLine("HERE IS " + ((int)tip + (int)input));
            }
        }