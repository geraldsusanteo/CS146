def flood_fill(image, sr, sc, new_color, old_color):
    if image[sr][sc] == new_color or image[sr][sc] != old_color:
        return

    image[sr][sc] = new_color

    if sr > 0:
        flood_fill(image, sr - 1, sc, new_color, old_color)  # up
    if sr < len(image) - 1:
        flood_fill(image, sr + 1, sc, new_color, old_color)  # down
    if sc > 0:
        flood_fill(image, sr, sc - 1, new_color, old_color)  # left
    if sc < len(image[0]) - 1:
        flood_fill(image, sr, sc + 1, new_color, old_color)  # right


def valid(image, sr, sc, color):
    m = len(image)
    n = len(image[0])

    return 0 <= sr < m and 0 <= sc < n and 0 <= image[sr][sc] <= 65536 and 0 <= color <= 65536


def main():
    image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
    sr, sc, color = 1, 1, 2

    if valid(image, sr, sc, color):
        flood_fill(image, sr, sc, color, image[sr][sc])

    for row in image:
        print(' '.join(map(str, row)))


if __name__ == "__main__":
    main()
