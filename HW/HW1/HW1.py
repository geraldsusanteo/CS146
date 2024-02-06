
numbers = [17, 27, 2003, 12, 1, 500, 1000, 5]
target = 6
answer = [0, 0]

for i in range(len(numbers)):
    key = target - numbers[i]
    for j in range(len(numbers)):
        if numbers[j] == key and j != i:
            answer[0] = j
            answer[1] = i
            break

print(answer[0])
print(answer[1])
