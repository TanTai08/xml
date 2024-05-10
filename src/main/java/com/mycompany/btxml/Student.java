/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btxml;

import java.util.ArrayList;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author TAN TAI
 */
public class Student {

    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + ", gpa=" + gpa + '}';
    }

    public static void main(String[] args) {
        // Tạo danh sách sinh viên
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John", 20, 3.8));
        studentList.add(new Student("Emily", 21, 3.9));
        studentList.add(new Student("David", 19, 3.6));

        // Xuất danh sách sinh viên thành tệp XML
        try {
            // Khởi tạo context JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(StudentListWrapper.class);

            // Khởi tạo marshaller
            Marshaller marshaller = jaxbContext.createMarshaller();

            // Định dạng đầu ra là XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Tạo một đối tượng wrapper để đóng gói danh sách sinh viên
            StudentListWrapper wrapper = new StudentListWrapper();
            wrapper.setStudents(studentList);

            // Xuất danh sách sinh viên thành tệp XML
            marshaller.marshal(wrapper, new File("students.xml"));
            System.out.println("Đã xuất danh sách sinh viên thành công vào tệp students.xml");
        } catch (JAXBException e) {
        }
    }
}
