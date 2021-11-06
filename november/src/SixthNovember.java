import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SixthNovember {
    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            int count = 0;
            if(map.containsKey(i)) {
                map.remove(i);
            }
            else {
                map.put(i, count+1);
            }
        }
        List<Integer> targetList = new ArrayList<>(map.keySet());
        int[] array = targetList.stream().mapToInt(i->i).toArray();
        return array;
    }
}
