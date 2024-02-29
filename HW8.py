def longest_palindrome(s: str) -> int:
    char_count = {}
    for char in s:
        char_count[char] = char_count.get(char, 0) + 1

    odd_found = False
    max_length = 0

    for count in char_count.values():
        if count % 2 == 0:
            max_length += count
        else:
            max_length += count - 1
            odd_found = True

    if odd_found:
        max_length += 1  # where we include the one odd count character

    return max_length

# Main function
if __name__ == "__main__":
    s = "speediskey" # 2nd test case output should be 5
    if 1 <= len(s) <= 2000:
        print(longest_palindrome(s))
    else:
        print("Length Invalid")
