from collections import deque

def can_finish(num_courses, prerequisites):
    
    adj = [[] for _ in range(num_courses)]
    indegree = [0] * num_courses

   
    for course, prerequisite in prerequisites:
        adj[prerequisite].append(course)
        indegree[course] += 1

    
    queue = deque()
    for i in range(num_courses):
        if indegree[i] == 0:
            queue.append(i)

    #topological sorting
    ans = []
    while queue:
        current = queue.popleft()
        ans.append(current)

        for next_course in adj[current]:
            indegree[next_course] -= 1
            if indegree[next_course] == 0:
                queue.append(next_course)

    # If all courses are in the ans list, return True if not return false
    return len(ans) == num_courses

if __name__ == "__main__":
    num_courses = 2
    prerequisites = [[1, 0]]

    print(can_finish(num_courses, prerequisites))
