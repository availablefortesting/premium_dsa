class Solution {
    public int minLength(String s) {
        String result = s.chars()  // convert to IntStream
            .mapToObj(c -> (char) c)  // convert to Character stream
            .reduce(new StringBuilder(),
                (sb, c) -> {
                    System.out.println(sb + " , " + c);
                    int len = sb.length();
                    if (len > 0) {
                        char last = sb.charAt(len - 1);
                        if ((last == 'A' && c == 'B') || (last == 'C' && c == 'D')) {
                            sb.deleteCharAt(len - 1);  // Remove the pair
                            return sb;
                        }
                    }
                    sb.append(c);
                    return sb;
                },
                (sb1, sb2) -> sb1.append(sb2)  // combine (not used in sequential)
            ).toString();

        return result.length();
    }
}