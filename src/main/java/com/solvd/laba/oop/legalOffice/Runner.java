package com.solvd.laba.oop.legalOffice;

import java.lang.reflect.*;

public class Runner {
    public static void main(String[] args) {
        Class<Employee> employeeClass = Employee.class;

        Field[] fields = employeeClass.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            System.out.println("Field name: " + field.getName()
                    + ", Modifiers: " + Modifier.toString(modifiers)
                    + ", Type: " + field.getType());
        }

        Constructor<?>[] constructors = employeeClass.getDeclaredConstructors();
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : constructors) {
            int modifiers = constructor.getModifiers();
            System.out.println("Constructor name: " + constructor.getName()
                    + ", Parameters: " + constructor.getParameterCount()
                    + ", Modifiers: " + Modifier.toString(modifiers));
        }

        Method[] methods = employeeClass.getDeclaredMethods();
        System.out.println("\nMethods:");
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            System.out.println("Method name: " + method.getName()
                    + ", Return Type: " + method.getReturnType()
                    + ", Parameters: " + method.getParameterCount()
                    + ", Modifiers: " + Modifier.toString(modifiers));
        }

        try {
            Constructor<Employee> constructor = employeeClass.getDeclaredConstructor(String.class, String.class, int.class, String.class, int.class, ContactInfo.class);
            Employee employeeInstance = constructor.newInstance("Mike", "Johnson", 35, "Senior Lawyer", 10, new ContactInfo("123456789", "mikejonson@example.com"));
            System.out.println();
            employeeInstance.printDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}