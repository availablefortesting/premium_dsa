class Solution {
    public String validIPAddress(String queryIP) {
        /*
            Sprinklr - 3 | Apple - 2 | Deutsche Bank - 2 | ServiceNow - 2
        */
        if(isIPv4(queryIP)) 
            return "IPv4";
        else if(isIPv6(queryIP)) 
            return "IPv6";
        else 
            return "Neither";
    }
    
    private boolean isIPv4(String ip) {
        String[] arr = ip.split("\\.", -1);
        for(String a: arr) {
            try{
                if(Integer.parseInt(a) >  255 || (a.charAt(0)=='0' && a.length() != 1)) 
                    return false;
            } catch (NumberFormatException e) { return false; }
        }
        return arr.length == 4;
    }
    
    private boolean isIPv6(String ip) {
        String[] arr = ip.split(":", -1);
        for(String a: arr) {
            try{
                if(Integer.parseInt(a, 16) > 65535 || a.length() > 4) 
                    return false;
            } catch (NumberFormatException e) { return false; }
        }
        return arr.length == 8;
    }
    
}