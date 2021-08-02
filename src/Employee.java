import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Employee {

	private String empId;
	private String empDepartmentCode;
	
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
	
	public static BiFunction<String, List<Employee>, List<String>> fun=(k,v)->{
		List<String> list=new ArrayList<>();
		v.forEach(val->list.add(val.getEmpId()));
		return list;
	};
	
	public static final Consumer<Employee> cons=c -> System.out.println(c.getEmpId());
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpDepartmentCode() {
		return empDepartmentCode;
	}
	public void setEmpDepartmentCode(String empDepartmentCode) {
		this.empDepartmentCode = empDepartmentCode;
	}
	
	public static void main(String[] args) {
		
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
		
		List<Employee> list = Arrays.asList(e1,e2,e3,e4);
		//Find all employees with dept code 2
		list.stream().filter(index -> index.empDepartmentCode.equals(2)).collect(Collectors.toList());
		List<String> intList = list.stream().map(e -> e.getEmpId()).collect(Collectors.toList());
		System.out.println(intList);
		
		Map<String, List<Employee>> map1=list.stream().collect(Collectors.groupingBy(Employee::getEmpDepartmentCode));		
	//	Map<String, List<String>> map=map1.replaceAll(fun);
		Map<String, List<String>> map=myfunc.apply(map1);
		
		Runnable runnable=()->{
			
			System.out.println("In Run Method");
		};
		
		MyEmp myEmp=()->{
			
			System.out.println("In myEmp Method");
			return "success";
		};
		
		System.out.println("my Emp "+myEmp.getEmp());
		
		Consumer<Employee> consumer = s ->{
			System.out.println(s.getEmpDepartmentCode()); 
		};
		//list.forEach(consumer);
		
		//Map<String, String> map2=list.stream().collect(Collectors.toMap(Employee::getEmpDepartmentCode, Employee::getEmpId));
		
		list.forEach(e->{
			
			System.out.println(e.getEmpId());
		});
		
		list.forEach(cons);		
	}
}
