package org.example;


import org.example.model.Employee;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractise {
    public static void main(String[] args) throws IOException {
        separateOddAndEvenNumbers();
        removeDuplicatesFromList();
        findFrequencyOfEachChar();
        sortTheListInReverseOrder();
        addPrefixSuffixDelimiter();
        findMaxAndMin();
        secondLargestElement();
        mergeTwoUnsortedArrays();
        firstThreeMaxAndMinNumber();
        findAnagrams();
        sortStringLenght();
        sumOfAllDigitsOfANumber();
        commonElementsBetweenArray();
        sumAndAverageOfArray();
        reverseEachWordInString();
        reverseIntegerArray();
        sumFirstNaturalNumbers();
        findStringStartWithNumber();
        pallindromeProgram();
        findDuplicateElement();
        lastElementOfArray();
        employeeSecondHighestSalary();
        findMalesAndFemales();
        printDeptNames();
        averageAgeofMalesAndFemaleEmployees();
        highestPaidEmployee();
        employeeJoinedAfter2015();
        countEmployeesInEachDept();
        avgSalaryOfEachDept();
        youngestMaleEmployeeInProdDept();
        mostSeniorPersonInTheOrganisation();
        malesAndFemalesInSalesAndMarketingTeam();
        avgSalaryOfMaleAndFemaleEmployees();
        employeesInEachDept();
        avgandTotalSalary();
        separateEmployeesOfAge25();
        detailsofOldestEmployee();
        countOfMalesAndFemalesInEachDept();
    }

    private static void countOfMalesAndFemalesInEachDept() {
        System.out.println("countOfMalesAndFemalesInEachDept");
        List<Employee> empList = getEmployeeList();
        empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender,Collectors.counting())))
                .entrySet()
                .stream()
                .forEach(entry->{
                    System.out.println(entry.getKey());
                    entry.getValue().entrySet().stream().forEach(ent->System.out.println(ent.getKey()+" "+ent.getValue()));
                });
    }

    private static void detailsofOldestEmployee() {
        System.out.println("Who is the oldest employee in the organization? What is his age and which department he belongs to?");
        List<Employee> empList = getEmployeeList();
        empList.stream().max(Comparator.comparing(Employee::getAge)).ifPresent(employee -> System.out.print(employee.getDepartment()+" "+employee.getAge()));
    }

    private static void separateEmployeesOfAge25() {
        System.out.println("Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years");
        List<Employee> empList = getEmployeeList();
        empList.stream().collect(Collectors.partitioningBy(emp->emp.getAge()<=25))
                .entrySet()
                .stream()
                .forEach(emp->System.out.println(emp.getKey()+" "+emp.getValue()));
    }

    public static double avgandTotalSalary() {
        System.out.println("What is the average salary and total salary of the whole organization?");
        List<Employee> empList = getEmployeeList();
        DoubleSummaryStatistics data = empList.stream().collect(Collectors.summarizingDouble(Employee::getEmpSalary));
        System.out.println(data.getSum());
        System.out.println(data.getAverage());
        return data.getSum();
    }

    private static void employeesInEachDept() {
        System.out.println("List down the names of all employees in each department?");
        List<Employee> empList = getEmployeeList();
        empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()))
                .entrySet()
                .stream()
                .forEach(entry->{
                    System.out.println(entry.getKey());
                    System.out.println("================");
                entry.getValue().forEach(emp->System.out.println(emp.getEmpName()+" "));
                });
    }

    private static void avgSalaryOfMaleAndFemaleEmployees() {
        System.out.println("What is the average salary of male and female employees?");
        List<Employee> empList = getEmployeeList();
        empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getEmpSalary)))
                .entrySet()
                .stream()
                .forEach(emp->System.out.print(emp.getKey()+" "+emp.getValue()));
    }

    private static void malesAndFemalesInSalesAndMarketingTeam() {
        System.out.println("How many male and female employees are there in the sales and marketing team?");
        List<Employee> empList = getEmployeeList();
        empList.stream().filter(emp-> emp.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
    }

    private static void mostSeniorPersonInTheOrganisation() {
        System.out.println("Who has the most working experience in the organization?");
        List<Employee> empList = getEmployeeList();
        empList.stream().min(Comparator.comparing(Employee::getYearOfJoining)).ifPresent(emp->System.out.println(emp.toString()));
    }

    private static void youngestMaleEmployeeInProdDept() {
        System.out.println("Get the details of youngest male employee in the product development department?");
        List<Employee> empList = getEmployeeList();
        empList.stream().filter(employee -> employee.getDepartment().equalsIgnoreCase("Product Development"))
                .min(Comparator.comparing(Employee::getAge)).ifPresent(emp->System.out.println(emp.toString()));
    }

    private static void avgSalaryOfEachDept() {
        System.out.println("avgSalaryOfEachDept");
        List<Employee> empList = getEmployeeList();
        empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getEmpSalary)))
                .entrySet()
                .stream()
                .forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
    }

    private static void countEmployeesInEachDept() {
        System.out.println("countEmployeesInEachDept");
        List<Employee> empList = getEmployeeList();
        empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
    }

    private static void employeeJoinedAfter2015() {
        System.out.println("employeeJoinedAfter2015");
        List<Employee> empList = getEmployeeList();
        empList.stream().filter(employee -> employee.getYearOfJoining()>2015).forEach(emp->System.out.println(emp.toString()));
    }

    private static void highestPaidEmployee() {
        System.out.println("averageAgeofMalesAndFemaleEmployees");
        List<Employee> empList = getEmployeeList();
        empList.stream().max(Comparator.comparing(Employee::getEmpSalary)).ifPresent(emp->System.out.println(emp.toString()));
    }

    private static void averageAgeofMalesAndFemaleEmployees() {
        System.out.println("averageAgeofMalesAndFemaleEmployees");
        List<Employee> empList = getEmployeeList();
        empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)))
                .entrySet()
                .stream()
                .forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));

    }

    private static void printDeptNames() {
        System.out.println("printDeptNames");
        List<Employee> empList = getEmployeeList();
        empList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    }

    private static void findMalesAndFemales() {
        System.out.println("findMalesAndFemales");
        List<Employee> empList = getEmployeeList();
        empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry-> System.out.println(entry.getKey()+" "+entry.getValue()));

    }

    private static void employeeSecondHighestSalary() {
        System.out.println("distinct employed salary");
    /*    List<Employee> empList=Arrays.asList(new Employee(1,"Tazeem",100.0),
                                            new Employee(2,"Fatma",200.0),
                                            new Employee(3,"Falak",300.0),
                                            new Employee(4,"Alya",300.0),
                new Employee(5,"Ali",200.0));*/
        List<Employee> empList = getEmployeeList();
        empList.stream()
                .sorted(Comparator.comparing(Employee::getEmpSalary).reversed())
                .distinct().forEach(e->System.out.println(e.getEmpName()));

        System.out.println("employeeSecondHighestSalary");

        empList.stream()
                .map(Employee::getEmpSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(emp->System.out.print(emp));
        System.out.println("employee details for SecondHighestSalary");
        empList.stream()
                .sorted(Comparator.comparing(Employee::getEmpSalary).reversed())
                .filter(emp->emp.getEmpSalary()<empList.stream().max(Comparator.comparing(Employee::getEmpSalary)).get().getEmpSalary())
                .findFirst()
                .ifPresent(emp->System.out.print(emp.getEmpName()));
        System.out.println("all employee details having SecondHighestSalary");
        empList.stream()
                .sorted(Comparator.comparing(Employee::getEmpSalary).reversed())
                .filter(emp->emp.getEmpSalary()==
                        empList.stream().map(Employee::getEmpSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get())
                .forEach(emp->System.out.print(emp.getEmpName()));
        System.out.println("employee salary greater than 100");
        empList.stream()
                .filter(emp->emp.getEmpSalary()>100)
                .collect(Collectors.toList())
                .forEach(employee -> System.out.print(employee.getEmpName() +" "));

    }

    private static List<Employee> getEmployeeList() {
        List<Employee> empList=new ArrayList<>();
        empList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        empList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        empList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        empList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        empList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        empList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        empList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        empList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        empList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        empList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        empList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        empList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        empList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        empList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        empList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        empList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        empList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        return empList;
    }

    private static void lastElementOfArray() {
        System.out.println("findStringStartWithNumber");
        List<String> strList= Arrays.asList("1apple","mango","orange","2banana");
        String s = strList.stream().skip(strList.size() - 1).findFirst().get();
        System.out.println(s+" ");
    }

    private static void findDuplicateElement() {
        System.out.println("findDuplicateElement");
        List<Integer> numbers= Arrays.asList(3,3,4,4,66,66,1);
        numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toList())
               .forEach(val->System.out.print(val.getKey()+" "));

    }

    private static void pallindromeProgram() {
        System.out.println("pallindromeProgram");
        String str="mom";
        boolean s = IntStream.rangeClosed(0, str.length() / 2)
                .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
        System.out.println(s);
    }

    private static void findStringStartWithNumber() {
        System.out.println("findStringStartWithNumber");
        List<String> strList= Arrays.asList("1apple","mango","orange","2banana");
        strList.stream()
                .filter(c->Character.isDigit(c.charAt(0)))
                .collect(Collectors.toList())
                .forEach(System.out::print);
    }

    private static void sumFirstNaturalNumbers() {
        System.out.println("sumFirstNaturalNumbers");
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);
    }

    private static void reverseIntegerArray() {
        System.out.println("reverseIntegerArray");
        int arr[]={1,2,3,4,5};
        IntStream.rangeClosed(1,arr.length)
                .map(i->arr[arr.length-i])
                .forEach(System.out::print);
    }

    private static void reverseEachWordInString() {
        System.out.println("reverseEachWordInString");
        String sent="I am Tazeem Fatma";
        String rev=Arrays.stream(sent.split(" "))
                .map(s->new StringBuffer(s).reverse())
                .collect(Collectors.joining());
        System.out.println(rev);
    }

    private static void sumAndAverageOfArray() {
        System.out.println("sumAndAverageOfArray");
        int arr[]={1,2,3,4,5};
        int sum = Arrays.stream(arr).sum();
        double avg = Arrays.stream(arr).average().getAsDouble();
        System.out.println(sum);
        System.out.println(avg);
        List<Integer> numbers= Arrays.asList(3,3,34,8,34,8,62,18,93,26,84,74);
        IntSummaryStatistics s = numbers.stream().collect(Collectors.summarizingInt(value -> value.intValue()));
        System.out.println(s.getSum());
        System.out.println(s.getAverage());
    }

    private static void commonElementsBetweenArray() {
        System.out.println("commonElementsBetweenArray");
        List<String> strList1= Arrays.asList("apple","mango","orange","banana");
        List<String> strList2= Arrays.asList("apple","mango","orange");
        strList1.stream().filter(c->strList2.contains(c)).collect(Collectors.toList())
                .forEach(x->System.out.print(x+" "));

    }

    private static void sumOfAllDigitsOfANumber() {
        int num=123;
        Integer sum = Stream.of(String.valueOf(num).split(""))
                .collect(Collectors.summingInt(Integer::parseInt));
        sum = Stream.of(String.valueOf(num).split("")).map(Integer::parseInt).reduce(0, (i, j) -> i + j);
        System.out.println(sum);
    }

    private static void findAnagrams() {
        String s1 = "Tom Marvolo Riddle";
        String s2 = "I am Lord Voldemort";
        String str1 = Stream.of(s1.replaceAll(" ", "").toUpperCase().split(""))
                .sorted()
                .collect(Collectors.joining());
        String str2 = Stream.of(s2.replaceAll(" ", "").toUpperCase().split(""))
                .sorted()
                .collect(Collectors.joining());
        System.out.println(str1);
        System.out.println(str2);
        if (str1.equalsIgnoreCase(str2))
            System.out.println("He is Voldermort");
        else
            System.out.println("He is not Voldermort");

    }

    private static void sortStringLenght() {
        System.out.println("sortStringLenght");
        List<String> strList= Arrays.asList("zinc","carbon","vanadium","Ammonium","calcium");
        strList.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    private static void firstThreeMaxAndMinNumber() {
        System.out.println("firstThreeMinNumber");
        List<Integer> numbers= Arrays.asList(3,3,34,8,34,8,62,18,93,26,84,74);
        numbers.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::print);
        System.out.println("firstThreeMaxNumber");
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::print);

    }

    private static void mergeTwoUnsortedArrays() {
        System.out.print("mergeTwoUnsortedArrays");
        int a[]={74,34,45,2,24};
        int b[]={23,35,64,78,42};
        IntStream.concat(Arrays.stream(a),Arrays.stream(b))
                .sorted().forEach(System.out::println);

    }

    private static void secondLargestElement() {
        System.out.print("find second largest");
        //List<Integer> numbers= Arrays.asList(3,3,34,8,34,8,62,18,93,26,84,74);
        List<Integer> numbers=new ArrayList<>();
        Optional<Integer> secondLargest = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        numbers.stream().sorted(Comparator.reverseOrder()).skip(1).max(Comparator.naturalOrder())
                .ifPresent(System.out::print);
        secondLargest.ifPresentOrElse(System.out::print, new Runnable() {
            @Override
            public void run() {
                System.out.print("empty");
            }
        });

    }

    private static void findMaxAndMin() {
        System.out.print("find max");
        List<Integer> numbers= Arrays.asList(3,3,34,8,34,8,62,18,93,26,84,74);
        Integer res = numbers.stream()
                      .max(Comparator.naturalOrder()).get();
                     //  .max((i,j)-> i.compareTo(j)).get();
        System.out.println(res);
        System.out.print("find min");
      //  List<Integer> numbers= Arrays.asList(3,3,34,8,34,8,62,18,93,26,84,74);
         res = numbers.stream()
                .min(Comparator.naturalOrder()).get();
        //  .max((i,j)-> i.compareTo(j)).get();
        System.out.println(res);


    }

    private static void addPrefixSuffixDelimiter() {
        System.out.println("addPrefixSuffixDelimiter");
        List<String> strList= Arrays.asList("apple","mango","orange","banana","omega");
        String res = strList.stream().collect(Collectors.joining("-", "fruit", "yummy"));
        System.out.println(res);

    }

    private static void sortTheListInReverseOrder() {
        System.out.print("sort the list in reverse order");
        List<Integer> numbers= Arrays.asList(3,3,34,8,34,8,62,18,93,26,84,74);
        numbers.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.print("sort the list of string in reverse order");
        List<String> strList= Arrays.asList("apple","mango","orange","banana","omega");
        strList.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    private static void findFrequencyOfEachChar() {
        System.out.println("findFrequencyOfEachCharInString");
        String str="Tazeem Fatma";
        Map<Character, Long> strmap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strmap);
        System.out.println("findFrequencyOfEachElementInList");

        List<String> strList=Arrays.asList("apple","mango","apple","banana");
        Map<String, Long> strmp = strList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strmp);
        System.out.println("findFrequencyOfEachElementInArray");
        String strArray[]= {"apple", "mango", "apple", "banana"};
        Map<String, Long> strArrayMap = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strArrayMap);
    }

    private static void removeDuplicatesFromList() {
        System.out.println("remove duplicates from list");
        List<Integer> numbers= Arrays.asList(3,3,34,8,34,8,62,18,93,26,84,74);
        numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::print);
        System.out.println("remove duplicate from string");
        List<String> str=Arrays.asList("apple","mango","apple","mango");
        str.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::print);
    }

    private static void separateOddAndEvenNumbers() {
        System.out.println("separate even and odd numbers");
        List<Integer> numbers= Arrays.asList(3,34,8,62,18,93,26,84,74);

        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(result);

    }
}
