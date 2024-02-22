def three_sum(numbers):
    answer = []
    numbers.sort()  

    for i in range(len(numbers) - 2):
        # Skip duplicates
        if i > 0 and numbers[i] == numbers[i - 1]:
            continue
        
        j = i + 1
        k = len(numbers) - 1

        while j < k:
            s = numbers[i] + numbers[j] + numbers[k]
            
            # If sum is zero, add the triplet to the answer
            if s == 0:
                answer.append([numbers[i], numbers[j], numbers[k]])
                j += 1
                k -= 1
                
                # Skip duplicates for j and k
                while j < k and numbers[j] == numbers[j - 1]:
                    j += 1
                while j < k and numbers[k] == numbers[k + 1]:
                    k -= 1
            elif s < 0:  # If sum is less than zero, move j pointer to the right
                j += 1
            else:  # If sum is greater than zero, move k pointer to the left
                k -= 1

    return answer  # Return the list of triplets summing up to zero

def main():
    numbers = [-10000, -5, 0, 5, 10, -10, 0, 10000]

    # If the array length is valid, proceed to find triplets summing up to zero
    if len(numbers) < 3 or len(numbers) > 3000:
        print("Invalid length")
    elif numbers[0] < -10000 or numbers[-1] > 10000:
        print("Invalid size for input")
    else:
        triplets = three_sum(numbers)
        print(triplets)

if __name__ == "__main__":
    main()
