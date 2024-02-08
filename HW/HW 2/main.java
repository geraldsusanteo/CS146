public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int total = 10; // Assuming there are 10 versions
        int firstBadVersion = main.firstBadVersion(n);
        System.out.println("The first bad version is: " + firstBadVersion);
    }

    public boolean isBadVersion(int version) {
        return version >= 4; 
    }

    public int firstBadVersion(int total) {
        int left = 1;
        int right = total;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
