def find_the_city(n, edges, distance_threshold):
    dis = [[float('inf') // 2] * n for _ in range(n)]
    res, smallest = 0, n

    for e in edges:
        dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2]

    for i in range(n):
        dis[i][i] = 0

    # Floyd-Warshall Algorithm
    for k in range(n):
        for i in range(n):
            for j in range(n):
                dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j])

    for i in range(n):
        count = sum(1 for j in range(n) if dis[i][j] <= distance_threshold)
        if count <= smallest:
            res = i
            smallest = count

    return res


if __name__ == "__main__":
    n = 4
    edges = [[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]]
    distance_threshold = 4

    print(find_the_city(n, edges, distance_threshold))
