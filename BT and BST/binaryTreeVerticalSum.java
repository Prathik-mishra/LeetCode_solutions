/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root,0,0));
        
        while(!queue.isEmpty()){
            Tuple tuple = queue.remove();
            Node node = tuple.node;
            int horizontal = tuple.horizontal;
            int vertical = tuple.vertical;
            
            if(!map.containsKey(vertical)){
                map.put(vertical,new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(horizontal)){
                map.get(vertical).put(horizontal,new ArrayList<>());
            }
            
            map.get(vertical).get(horizontal).add(node.data);
            
            if(node.left != null){
                queue.add(new Tuple(node.left,horizontal+1,vertical-1));
            }
            if(node.right != null){
                queue.add(new Tuple(node.right,horizontal+1,vertical+1));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(TreeMap<Integer,ArrayList<Integer>> values : map.values()){
            int sum = 0;
            for(ArrayList<Integer> lis : values.values()){
                for(int nums : lis){
                    sum += nums;
                }
            }
            ans.add(sum);
        }
        
        return ans;
    }
}

class Tuple{
    Node node;
    int horizontal;
    int vertical;
    public Tuple(Node _node,int _horizontal,int _vertical){
        this.node = _node;
        this.horizontal = _horizontal;
        this.vertical = _vertical;
    }
}
