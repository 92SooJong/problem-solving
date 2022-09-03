class Solution {
    public String longestCommonPrefix(String[] strs) {
        String sub = "";
        int length =strs[0].length();

        for(int i=0; i<length; i++){
            sub = strs[0].substring(0, i+1);
            for(int j=0; j<strs.length; j++){
                if(!strs[j].startsWith(sub)){
                    return sub.substring(0,i);
                }
            }

        }

        return sub;
    }
}
