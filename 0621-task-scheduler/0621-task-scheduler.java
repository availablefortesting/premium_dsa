class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max_freq = 0, max_freq_Cnt = 0;
        
        for(char task : tasks) {
            counter[task - 'A']++;
            
            if(max_freq == counter[task - 'A'])  
                max_freq_Cnt++;
            else if(max_freq < counter[task - 'A']) {
                max_freq = counter[task - 'A'];
                max_freq_Cnt = 1;
            }
        }
        // 3 A, 3 B, 2 C, 1 D, n = 3
        //   A ? ? | A ? ? | A
        //   A B ? | A B ? | A B D
        int windowCount = max_freq - 1;
        // find min_req length of window, but it can be more than that if max_freq_Cnt is high
        int windowMinLength = n - (max_freq_Cnt - 1);    // window length n - most_freq_task will get priority
        int emptySlots = windowCount * windowMinLength;
        
        int remainingTasks = tasks.length - max_freq * max_freq_Cnt;
        // if remainingTasks then we can accomodate it in previous windows, by making it size bigger, so no idles.
        int idles = Math.max(0, emptySlots - remainingTasks); 
        
        return (tasks.length + idles);
    }
}