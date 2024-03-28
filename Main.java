import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        
        if (isValidInput(numCourses, prerequisites)) {
            System.out.println(canFinish(numCourses, prerequisites));
        }
    }

    public static boolean isValidInput(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || numCourses > 2000 || prerequisites.length < 0 || prerequisites.length > 5000)
            return false;
        
        for (int[] prerequisite : prerequisites) {
            if (prerequisite.length != 2)
                return false;
        }
        return true;
    }

    public static boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);

            if (adj[current] != null) {
                for (int next : adj[current]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return ans.size() == n;
    }
}
