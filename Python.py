def coinChange(coins, amount):
    dp = [amount + 1] * (amount + 1)
    dp[0] = 0

    for i in range(1, amount + 1):
        for coin in coins:
            if coin <= i:
                dp[i] = min(dp[i], 1 + dp[i - coin])

    return -1 if dp[amount] > amount else dp[amount]

if __name__ == "__main__":
    coins = [1, 2, 5]
    amount = 11
    print(coinChange(coins, amount))