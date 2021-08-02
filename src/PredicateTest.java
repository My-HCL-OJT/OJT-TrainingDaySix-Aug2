import java.util.function.Predicate;

public class PredicateTest {

	  static void pred(int number, Predicate<Integer> predicate)
      {
          if (predicate.test(number)) {
              System.out.println("Number " + number);
          }
      }
	  
	public static void main(String[] args) {
		
		// Example 1
        Predicate<Integer> lesserthan = i -> {
        	return (i < 18); 	
        };
  
        System.out.println(lesserthan.test(10)); 
        
        // Example 2
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20; 
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);
  
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
                
      // Example 3
        pred(10, (i) -> i > 7);
	}
}
