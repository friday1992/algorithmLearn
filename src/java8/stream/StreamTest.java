package java8.stream;

import java8.lamada.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    List<Employee> employeeList = Arrays.asList(new Employee(20,5000),new Employee(20,3000),new Employee(22,6000),new Employee(25,8000));

    @Test
    public  void test(){
        //通过Collections 的stream方法和parallelStream
        List<String> list = new ArrayList<>();
        Stream<String>  stream = list.stream();
        //Arrays的stream方法
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1=Arrays.stream(employees);
        //Steam的of静态方法
        Stream.of("abc");
        //无限流
        Stream<Integer> steam4=Stream.iterate(0,(x)->x+2);
        steam4.limit(10).forEach(System.out::println);
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
    }
    @Test
    public void test2(){
        employeeList.stream().filter((e)->e.getAge()>20).forEach(System.out::println);
    }
    @Test
    public void test3(){
        List<String> list = Arrays.asList("aaa","bbb","cccc");
        list.stream().map((str)->str.toUpperCase()).forEach(System.out::println);
        employeeList.stream().map(Employee::getAge).forEach(System.out::println);
    }
    @Test
    public  void test4(){
        Integer[] nums ={1,2,3,4,5};
        Arrays.stream(nums).map((x)->x*x).forEach(System.out::println);
    }
    @Test
    public void test5(){
       Optional optional= employeeList.stream().map((e)->1).reduce(Integer::sum);
        System.out.println(optional.get());
    }
}
