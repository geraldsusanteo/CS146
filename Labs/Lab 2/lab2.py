t = "God"
s = "dog"

t = t.lower()  # incase of uppercase letters, we make sure all characters are lowercased.
s = s.lower()  

if len(t) == len(s):  # checks if they have the same amount of characters, since for words to be anagram they must have the same amount of words.
    char_T = sorted(t)  # sorts the characters alphabetically.
    char_S = sorted(s)

    if char_T == char_S:  # checks if the given words are anagram.
        print(True)
    else:
        print(False)
else:
        print(False)

