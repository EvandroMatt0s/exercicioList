package ListEmployee.application;

import ListEmployee.entitie.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee>list = new ArrayList<>();

        System.out.print("How many employees will be registered ?");
        int n = sc.nextInt();

        for (int i =0; i < n ; i++){
            System.out.println("Emplyoee #"+ (i + 1) +": ");
            System.out.print("id: ");
            int id = sc.nextInt();
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.println();
            list.add(new Employee(id, name,salary));
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }


        System.out.println();
        System.out.println("List of Employees");
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println();
        System.out.println("List of Employees");
        for (Employee employee : list) {
            System.out.println(employee);
        }


        sc.close();

    }
    public  static boolean hasId(List<Employee>list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}