// class Solution {
//     public String replaceWords(List<String> dictionary, String sentence) {
//         Set<String> set = new HashSet<>();
        
//         for(int i=0; i<dictionary.size(); i++){
//             set.add(dictionary.get(i));
//         }
        
//         StringBuilder result = new StringBuilder();
//         String[] arr = sentence.split(" ");
        
//         for(int x=0; x<arr.length; x++){
//             String str = arr[x];
//             StringBuilder sb = new StringBuilder();
//             boolean isAppended = false;
            
//             for(int i=0; i<str.length(); i++){
//                 sb.append(str.charAt(i));
//                 if(set.contains(sb.toString())){
//                     result.append(sb);
//                     if(x != arr.length-1){
//                         result.append(" ");
//                     }
//                     isAppended = true;
//                     break;
//                 }
//             }
            
//             if(!isAppended && x != arr.length-1){
//                 result.append(sb.toString());
//                 result.append(" ");
//             }else if(!isAppended){
//                 result.append(sb.toString());
//             }
//         }
        
//         return result.toString();
//     }
// }
// editorials approach: 
class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordArray = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);

        // Replace each word in sentence with the corresponding shortest root
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = shortestRoot(wordArray[i], dictSet);
        }

        return String.join(" ", wordArray);
    }

    private String shortestRoot(String word, Set<String> dictSet) {
        // Find the shortest root of the word in the dictionary
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dictSet.contains(root)) {
                return root;
            }
        }
        // There is not a corresponding root in the dictionary
        return word;
    }
}
