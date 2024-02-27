import heapq

def main():
    intervals = [[0, 30], [5, 10], [15, 20]]
    
    intervals.sort(key=lambda x: x[0])  # Sorts the intervals based on start times
    
    if not valid_intervals(intervals):
        print("Interval Time is invalid")
    else:
        print(min_meeting_rooms(intervals))

# Calcs the min number of meeting rooms required
def min_meeting_rooms(intervals):
    total_servers = 0
    end_times = []
    
    for start, end in intervals:
        while end_times and end_times[0] <= start:
            heapq.heappop(end_times)
        heapq.heappush(end_times, end)
        
        total_servers = max(total_servers, len(end_times))
    
    return total_servers

# Checks whether the intervals are valid
def valid_intervals(intervals):
    if len(intervals) <= 1 or len(intervals) >= 1000000:
        return False
    return intervals[0][0] >= 0 and intervals[-1][1] <= 100000  # Checks whether start time of the first interval is non-negative and end time of the last interval is within bounds

if __name__ == "__main__":
    main()
