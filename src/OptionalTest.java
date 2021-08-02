import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalTest {

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
		
		List<Employee> list2=list.stream().filter(emp-> emp.getEmpDepartmentCode().equals("3")).collect(Collectors.toList());
		//Optional
		
		Optional<Employee> op=list.stream().filter(emp-> emp.getEmpDepartmentCode().equals("3")).findFirst();
		
		
		if(op.isPresent()) {
			Employee e=op.get();
		}
		
		Employee emp=op.orElse(new Employee());
		
		//stream map
		
		List<String> myList=list.stream().map(e->{
			return e.getEmpDepartmentCode();
		}).collect(Collectors.toList());
		
		
	}

}
