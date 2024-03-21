public class Main {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, color = 2;
        if (valid(image, sr, sc, color)) {
            floodFill(image, sr, sc, color, image[sr][sc]);
        }

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (image[sr][sc] == newColor || image[sr][sc] != oldColor) return;

        image[sr][sc] = newColor;

        if (sr > 0) floodFill(image, sr - 1, sc, newColor, oldColor); // up
        if (sr < image.length - 1) floodFill(image, sr + 1, sc, newColor, oldColor); // down
        if (sc > 0) floodFill(image, sr, sc - 1, newColor, oldColor); // left
        if (sc < image[0].length - 1) floodFill(image, sr, sc + 1, newColor, oldColor); // right
    }

    public static boolean valid(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        return sr >= 0 && sr < m && sc >= 0 && sc < n && image[sr][sc] >= 0 && image[sr][sc] <= 65536
                && color >= 0 && color <= 65536;
    }
}
