## cs230-Challenge-1

# Sample Output

PS C:\Users\ryano\CompSci\cs230\cs230-Challenge-1> java Simulation -a
Running in Anarchy mode...

Day 1: famine
-------------------------
farmer: 10 7 10
doctor: 10 7 10
carpenter: 10 7 10
hunter: 10 9 10


Day 2: famine
-------------------------
farmer: 10 4 10
doctor: 10 4 10
carpenter: 10 4 10
hunter: 10 6 10


Day 3: famine
-------------------------
farmer: 10 4 10
doctor: 10 1 10
carpenter: 10 1 10
hunter: 10 3 10


Day 4: wolves
-------------------------
farmer: 7 3 10
doctor: 7 1 10
carpenter: 7 1 10
hunter: 9 2 10


Day 5: disease
-------------------------
farmer: 5 2 10
doctor: 5 1 10
carpenter: 5 1 10
hunter: 7 1 10


Day 6: famine
-------------------------
farmer: 5 2 10
doctor: 5 0 10
carpenter: 5 0 10
hunter: 7 0 10

doctor is dead
carpenter is dead
hunter is dead

Day 7: hurricane
-------------------------
farmer: 5 1 7


Day 8: hurricane
-------------------------
farmer: 5 0 4

farmer is dead

Everyone is dead

8 days

# Anarcy Average:
12.06 days

# Society Average:
194.14 days

# Write-Up
To start, I of course assumed that the society mode would run longer on average than anarchy mode.
I wasn't sure, however, just how long each mode would last. There was a stretch of time where I 
would only get 365 days for society mode, and I wasn't sure if that was accurate or if I wasn't
implementing the society mode properly. I soon fixed that issue, however, proven by the average
which is less than 365. I think this is an incredibly idealistic version of reality. I think that
if this exact situation were to play out, but with real people that have more complex emotions,
there's way more room for greed and the Tragedy of the Commons that we learned about in class.
I think more in line with Hobbes, that in a dire situation, the natural state of being is greed
and destruction of resources. Unless you have 4 very rational and intelligent people who are able
to analyze the Tragedy of the commons type situation, even the "society" mode would fail. 