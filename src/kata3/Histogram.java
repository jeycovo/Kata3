package kata3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram <K, integer> {
  private final Map <K, Integer> map = new HashMap <>();
  
  public Integer get(K key){
      Integer integer = map.get(key);
      return integer;
  }
  
  public Set<K> KeySet(){
      return map.keySet();
  }
  
  
  public void increment(K key){
      map.put(key, map.containsKey(key)? map.get(key)+1 : 1);
  }
  
}
