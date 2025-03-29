package com.bridgelabz.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 60000));
        employees.add(new Employee(2, "Jane Smith", "HR", 55000));

        // Serialize employees
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize employees
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            deserializedEmployees.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}