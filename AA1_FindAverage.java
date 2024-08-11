
// Write a program to find the average marks of each student and the highest average marks among all the students.


import java.util.HashMap;
import java.util.ArrayList;
public class AA1_FindAverage
{
	public static void main(String[] args) {
	    String[][] marks = { {"Alice", "96"}, {"Bob", "84"}, {"Charlie", "91"}, {"Alice", "78"}, {"Charlie", "95"} };
    
        HashMap<String, ArrayList<Integer> > map = new HashMap<>();
        
        for(String[] arr: marks){
            if(map.containsKey(arr[0])){
                ArrayList<Integer> total = map.get(arr[0]);
                int totalMarks = total.get(0);
                int totalCount = total.get(1);
                total.set(0, totalMarks + Integer.parseInt(arr[1]));
                total.set(1, totalCount + 1);
            }else{
                ArrayList<Integer> total = new ArrayList<>();
                total.add(Integer.parseInt(arr[1]));
                total.add(1);
                map.put(arr[0], total);
            }
        }
        
        int highest = Integer.MIN_VALUE;
        for(String stu: map.keySet()){
            ArrayList<Integer> total = map.get(stu);
            int average = total.get(0) / total.get(1) ;
            System.out.println(stu + " : " + average);
            highest = Math.max(highest, average);
        }
        System.out.println(highest);
	}
}
