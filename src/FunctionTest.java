import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionTest {

	public static final Function<Map<String,List<Employee>>,Map<String,List<String>>> myfunc=(map)->{		
		Map<String,List<String>> myMap=new HashMap<>();		
		Set<String> keys=map.keySet();		
		keys.forEach(k ->{
			List<String> list=new ArrayList<>();
			map.get(k).forEach(v->list.add(v.getEmpId()));
			myMap.put(k, list);
		});
		return myMap;
	};
	
	public static final Function<List<Employee>,List<String>> newFunc= list->{
		
		List<String> myList=new ArrayList<>();
		list.forEach(f->{
			myList.add(f.getEmpDepartmentCode());
		});
		return myList;
	};
	
	public static final Function<Employee,String> newFunc2= e->e.getEmpDepartmentCode();
	
	public static BiFunction<String, List<Employee>, List<String>> fun=(k,v)->{
		List<String> list=new ArrayList<>();
		v.forEach(val->list.add(val.getEmpId()));
		return list;
	};
	
	public static void main(String[] args) {
		
		List<Employee> list=new ArrayList<>();
		Employee e1=new Employee();
		e1.setEmpId("emp1");
		e1.setEmpDepartmentCode("1");
		
		Employee e2=new Employee();
		e2.setEmpId("emp2");
		e2.setEmpDepartmentCode("1");
		
		Employee e3=new Employee();
		e3.setEmpId("emp3");
		e3.setEmpDepartmentCode("2");
		
		Employee e4=new Employee();
		e4.setEmpId("emp4");
		e4.setEmpDepartmentCode("2");
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		Map<String, List<Employee>> map1=list.stream().collect(Collectors.groupingBy(Employee::getEmpDepartmentCode));
		
		Map<String,List<String>> map=new HashMap<>();
		
		//keyset
		//entryset
		
		
		// My requirement is to convert the map<String, List<Employee> to Map<String,List<String>
		map1.forEach((k,v) ->{
			
			
		});
		
		
		
		map1.forEach((k,v)->{
			map.put(k, fun.apply(k, v));
		});
		
		List<String> deptList=list.stream().map(newFunc2).collect(Collectors.toList());
		
		List<String> deptList2=list.stream().map( e->e.getEmpDepartmentCode()).collect(Collectors.toList());
	
	}
	
}
