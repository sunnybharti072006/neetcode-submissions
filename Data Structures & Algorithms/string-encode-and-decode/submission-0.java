class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        // Loop through each string and prefix it with its length + '#'
        // Example: ["neet", "code"] becomes "4#neet4#code"
        for(String s: strs){
            sb.append(s.length()).append("#").append(s);
        }
        
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0; 
        
        while (i < str.length()){
            
            int slash = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, slash));
            int startindex = slash + 1;
            int endindex = startindex + length;
            result.add(str.substring(startindex, endindex));
            
            i = endindex;
        }
        
        return result;
    }
}