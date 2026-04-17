class MyCalendar {
    TreeMap<Integer, Integer> data;

    public MyCalendar() {
        data = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Map.Entry<Integer, Integer> prev = data.floorEntry(startTime);
        if (prev != null && prev.getValue() > startTime) return false;

        Map.Entry<Integer, Integer> next = data.ceilingEntry(startTime);
        if (next != null && endTime > next.getKey()) return false;

        data.put(startTime, endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */