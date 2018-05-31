import itertools
import string
import re

# collect word data
data = open("words.txt", "r")
words = data.readlines()
data.close()

# clean up data
words = [w.strip() for w in words]

# generate all 3 digit combinations
combos = list(itertools.combinations(words, 3))

# write to file
out = open("smmdata.txt", "w")

for line in combos:
    out.write(line[0] + "," + line[1] + "," + line[2] + "\n")

out.close()
