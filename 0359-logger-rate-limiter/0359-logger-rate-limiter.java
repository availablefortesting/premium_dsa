class Logger {
    HashMap<String, Integer> cache;
        
    public Logger() {
       cache = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int time_limit = this.cache.getOrDefault(message, timestamp);
    
        if (timestamp >= time_limit) {
            this.cache.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */