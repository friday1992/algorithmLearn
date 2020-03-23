package java8.lamada;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LamadaTest {
    List<Employee> employeeList = Arrays.asList(new Employee(20,5000),new Employee(20,3000),new Employee(22,6000),new Employee(25,8000));
    @Test
    public void test(){
//        employeeList.stream().filter(((employee) -> employee.getAge()>21)).forEach(System.out::println);
          employeeList.stream().filter((employee -> employee.getSalary()>6000)).forEach(System.out::println);
    }
    @Test
    public  void test2(){
        Runnable runnable  = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        };
        runnable.run();
        Runnable runnable1 = () -> System.out.println("hello2");
        runnable1.run();

    }
    @Test
    public  void test3(){

        Consumer consumer = (x) -> System.out.println(x);
        consumer.accept(11);
    }
    @Test
    public void test4(){
        Comparator<Integer> com = (Integer x, Integer y) ->{
            System.out.println("函数式接口");
            int compare = Integer.compare(x, y);
            return compare;
        };
        System.out.println(com.compare(1,1));
    }
    @Test
    public void test5(){
        Collections.sort(employeeList,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return Integer.compare(e1.getSalary(),e2.getSalary());
            }else{
               return -1;
            }
        });
        for(Employee emp:employeeList){
            System.out.println(emp.toString());
        }
    }
    @Test
    public void test6(){
      String a=  hander("abc",(str)->{return  str.toUpperCase();
        });
        System.out.println(a);
    }
    public String hander(String str,MyFunction<String> fun){
        return fun.getValue(str);
    }
}
