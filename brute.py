import itertools
import time


# brute force solve
def solve():
    for s in range(1,10):
        for e in range(0,10):
            for n in range(0,10):
                for d in range(0,10):
                    for m in range(1,10):
                        for o in range(0,10):
                            for r in range(0,10):
                                for y in range(0,10):
                                    send = (1000 * s) + (100 * e) + (10 * n) + d
                                    more = (1000 * m) + (100 * o) + (10 * r) + e
                                    money = (10000 * m) + (1000 * o) + (100 * n) + (10 * e) + y

                                    if((send + more) == money):
                                        l = [s, e, n, d, m, o, r, y]

                                        if(len(l) == len(set(l))):
                                            print('s = {} e = {} n = {} d = {} m = {} o = {} r = {} y = {}'.format(s, e, n, d, m, o, r, y))


# keep track of computational time
start = time.time()

print("SEND+MORE=MONEY")
solve()

print('---- computation took ' + str(time.time() - start) + ' seconds ----')
