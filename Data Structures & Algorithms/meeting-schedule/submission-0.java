class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals == null || intervals.size() <= 1)return true;

        intervals.sort(Comparator.comparingInt(a -> a.start));

        for (int i = 0; i < intervals.size() - 1; i++) {
            
            if (intervals.get(i).end > intervals.get(i + 1).start) return false;
        }
        return true;
    }
}