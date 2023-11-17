class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
		
		StringBuilder ip = new StringBuilder();
        
		for(int a = 1 ; a <= 3 ; ++a)
		for(int b = 1 ; b <= 3 ; ++b)
	    for(int c = 1 ; c <= 3 ; ++c)
		for(int d = 1 ; d <= 3 ; ++d) {
			if(a + b + c + d == n) {
				int n1 = Integer.parseInt(s.substring(0, a));
				int n2 = Integer.parseInt(s.substring(a, a+b));
				int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
				int n4 = Integer.parseInt(s.substring(a+b+c));
                
				if(n1 < 256 && n2 < 256 && n3 < 256 && n4 < 256) {
					ip.append(n1).append('.')
                      .append(n2).append('.')
                      .append(n3).append('.')
                      .append(n4);
                    
                    // this check is because parseInt can convert "01" -> 1, "00" -> 0
					if(ip.length() == s.length() + 3) res.add(ip.toString());  // +3 for '.' 's
					ip.delete(0, ip.length());
				}
			}
		}
        
		return res;
        
    }
}