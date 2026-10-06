package com.jvmArchitecture.ClassclassDefinition;

public class VerifyClassObject {

    public static void main(String[] args) {
       
        StudentClass student = new StudentClass();

        Class<?> studentClass = student.getClass();
        System.out.println("Class object of Student: " + studentClass.getName());

        StudentClass anotherStudent = new StudentClass();
        Class<?> anotherStudentClass = anotherStudent.getClass();
        System.out.println("Class object of another Student: " + anotherStudentClass.getName());

        System.out.println("Are both class objects the same? " + (studentClass == anotherStudentClass));

        System.out.println("Hash code of student class object: " + studentClass.hashCode());
        System.out.println("Hash code of another student class object: " + anotherStudentClass.hashCode());


    }
    
}
