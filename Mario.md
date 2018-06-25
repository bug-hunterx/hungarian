
Princess Peach is kidnapped again by Bowser! Help Mario to save her.

*The task*

```f(storyboard: string)```

The `storyboard` is a space-separated list of simple Super Mario game objects, describing a game. You have to process it and you have to check if the player wins or not.

:one: If Mario reaches Bowser or Princess without dying, print `WIN` to `STDOUT`
:two: If Mario dies, print `GAME OVER` 
:three: If `storyboard` describes an incomplete game, print `???`

A game is incomplete when Mario is still alive by the end, but did not reach Bowser or Princess.


*Rules*

The storyboard consists of `enemies`, coins (`positive integers`), `bonus` objects that can be picked up and `goals` separated by one or more spaces. Mario initially has 3 lifes, 0 coins and is in Small mode. When all 3 lifes are lost, Mario dies and the game ends.

_Enemies_

Mario hurt his leg, so he cannot jump over the enemies, but walks into them, losing a life. When he is in Super mode, instead of losing a life, he turns back into Small Mario.
```
goomba
koopa
piranha
```

_Coins_

All positive numbers represent the same amount of coins. Every 100 coin grants Mario an extra life.

_Bonuses_

Bonus objects grant Mario special abilities.

- `Mushroom` turns Small Mario into Super Mario
- `Star` grants invulnerability for the next *two steps*.
- `1Up` gives Mario an extra life

_Goals_

When Mario reaches `Bowser` or `Princess`, the game is won.
> Note: they may not be at the end of the storyboard


*Example Test-Cases*

> Note: you submission will be tested using a lot more inputs

1. `piranha Princess piranha` => `WIN`
2. `1Up koopa goomba piranha Bowser` => `WIN`
3. `Star Mushroom  piranha goomba piranha goomba Princess` => `WIN`
4. ` piranha piranha piranha piranha` => `GAME OVER`
5. `piranha piranha Star goomba goomba Princess` => `WIN`
6. `10 40 koopa goomba 20 30 piranha piranha` => `GAME OVER`
