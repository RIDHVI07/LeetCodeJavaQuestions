class Solution {
    public int lengthOfLastWord(String str) {
         List<String> list = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                
                if (word.length() > 0) {
                    list.add(word.toString());
                    word = new StringBuilder();
                }
            } else {
                word.append(c);
            }
        }
        

        if (word.length() > 0) {
            list.add(word.toString());
        }
        
        return list.isEmpty() ? 0 : list.get(list.size() - 1).length();
    }
}