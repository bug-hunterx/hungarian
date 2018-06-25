
You are building a Rube Goldberg device, and you plan to push a button with a string of dominos. You are trying to find the coolest configuration of dominos, and to save your time, you build a small simulator for this.

*The task*

```f(input: string)```

Simulate the final state of the dominos described in the input argument and print it to `STDOUT`. Trailing/leading white-spaces are ignored.


*Rules*

Dominoes have four states, represented by the following strings:
```
| standing
\ left-tilted
/ right-tilted
__ fallen
```

Your dominos follow the law of physic (to a degree); they push their neighbours and make them fall too:
```
|\ => \\
/| => //
```

However, dominos will stop falling, if they have a stable neighbour already:
```
/|\ => /|\
__\ => __\
/__ => /__
```

Thus, these are all stable configurations:
```
__\\  //__  //|\\ //__|__\\
```

You are building this machine in your garage, where the floor slightly tilts to the right, so left-tilted dominos fall slower than right-tilted ones:
```
/ \ => __\
```


*Example Test-Cases*

> Note: you submission will be tested using a lot more inputs

1. `///|\\\` => `///|\\\`
2. `| \\` => `|__\`
3. `// |` => `/__|`
4. `|/ \|/ \|/ \|/ \|` => `|__\|__\|__\|__\|`
5. `/||||` => `////__`
6. `/| /|` => `/__/__`
