def minCostToSupplyWater(n, wells, pipes):
    p = [i for i in range(n + 1)]

    all_pipes = pipes + [[0, i + 1, w] for i, w in enumerate(wells)]
    all_pipes.sort(key=lambda x: x[2])

    ans = 0
    for a, b, c in all_pipes:
        pa = find(a, p)
        pb = find(b, p)
        if pa != pb:
            p[pa] = pb
            ans += c
            n -= 1
            if n == 0:
                return ans
    return ans

def find(x, p):
    if p[x] != x:
        p[x] = find(p[x], p)
    return p[x]

if __name__ == "__main__":
    n = 2
    wells = [1, 1]
    pipes = [[1, 2, 1], [1, 2, 2]]
    print(minCostToSupplyWater(n, wells, pipes))
