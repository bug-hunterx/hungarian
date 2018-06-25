using System;
using System.Linq;
using System.Collections.Generic;

namespace Challenges
{
    public class TicTacToe
    {
        public string Execute(string game)
        {
            // 1 | 2 | 3
            //---+---+---
            // 4 | 5 | 6
            //---+---+---
            // 7 | 8 | 9

            var board = new char[10];
            var check = new int[]
            {
            1, 2, 3,
            4, 5, 6,
            7, 8, 9,
            1, 4, 7,
            2, 5, 8,
            3, 6, 9,
            1, 5, 9,
            3, 5, 7
            };

            var player = 'O';

            foreach (var c in game)
            {
                board[Int32.Parse(c.ToString())] = player;
                for (var i = 0; i < 24; i += 3)
                    if (check.Skip(i).Take(3).All(j => board[j] == player))
                        return player.ToString();

                player = player == 'X' ? 'O' : 'X';
            }

            return "?";
        }
    }
}
