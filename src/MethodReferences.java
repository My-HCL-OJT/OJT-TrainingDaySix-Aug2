import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReferences {

	public static void main(String[] args) {

		//Method reference to static method – Class::staticMethodName
		List<Integer> integers = Arrays.asList(1,12,433,5);
        
		Optional<Integer> max = integers.stream().reduce( Math::max); 
		 
		//Method reference to instance method from instance – ClassInstance::instanceMethodName
		max.ifPresent( System.out::println ); 
		
		// Method reference to instance method from class type – Class::instanceMethodName
		List<String> strings = Arrays
		        .asList("how", "are", "you", "doing");
		 
		List<String> sorted = strings
		        .stream()
		        .sorted((s1, s2) -> s1.compareTo(s2))
		        .collect(Collectors.toList());
		 
		System.out.println(sorted);
		 
		List<String> sortedAlt = strings
		        .stream()
		        .sorted(String::compareTo)
		        .collect(Collectors.toList());
		 
		System.out.println(sortedAlt);
		
		//Reference to constructor – Class::new

		List<Integer> in = IntStream
                .range(1, 100)
                .boxed()
                .collect(Collectors.toCollection( ArrayList::new ));
 
			Optional<Integer> max2 = in.stream().reduce(Math::max); 
 
			max2.ifPresent(System.out::println); 
		
			
			//It works with Stream
			//Just remember what we can use at left side and right side
	}

}
