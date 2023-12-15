class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> m = new HashMap<>();
        
        for (List<String> path : paths) {
            m.put(path.get(0), path.get(1));
        }
        
        String start = paths.get(0).get(0);
        while (m.containsKey(start)) {
            start = m.get(start);
        }
        
        return start;
    }
}