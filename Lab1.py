s = "kayak"
s = s.lower()  # Turn to lowercase

# Remove non-alphanumeric characters
s = ''.join(c for c in s if c.isdigit() or c.isalpha())

reversed_str = s[::-1]  # Reverse the string

if reversed_str == s:
            print(True)
else:
    print(False)