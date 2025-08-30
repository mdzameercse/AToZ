class Solution {
    public String freqSort(String s) {
       Map<Character,Integer> map=new HashMap<>();
       StringBuilder sb=new StringBuilder();
        
       for(char c:s.toCharArray())
        map.put(c,map.getOrDefault(c,0)+1);
        
        List<Character> list=new ArrayList<>(map.keySet());
        
        // Sort by frequency ascending, then lexicographically
        list.sort((ob1,ob2)->map.get(ob1)-map.get(ob2)); //lamda expression
        
        // Sort by frequency ascending, then lexicographically if needed
        // list.sort((a, b) -> {
        //     int freqCompare = map.get(a) - map.get(b); // ascending frequency
        //     if (freqCompare == 0)
        //         return a - b; // lexicographic order if same frequency
        //     return freqCompare;
        // });

        
        for(char c:list){
          for(int i=0;i<map.get(c);i++)/// for more then one times repeted aaa bbb
              sb.append(c);
        }
       return sb.toString(); 
    }
    
// Strings in Java are immutable → every += creates a new string.
// This makes your code O(n²) for long strings.
// ✅ Always use StringBuilder.

//     🔎 What it is
// list.sort(...) sorts the list in-place.

// (ob1, ob2) -> ... is a lambda expression that defines how two elements (ob1, ob2) should be compared.

// Here, list is a List<Character>.

// map stores frequencies of each character.

// So the comparator says:
// 👉 "Compare two characters (ob1 and ob2) based on their frequencies in the map."

// 🔎 How it works

// map.get(ob1) - map.get(ob2)

// If result is negative → ob1 comes before ob2.

// If result is positive → ob2 comes before ob1.

// If result is 0 → they are considered equal in sorting.
};
