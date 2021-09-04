package com.study.enety.demo13.service.impl;

import com.study.enety.demo13.entity.Student;
import com.study.enety.demo13.service.StudentService;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> stuList = new ArrayList();

    /**
     * 添加
     */
    @Override
    public void addStu() {
        System.out.println("请输入学生信息...");
        System.out.println("请输入学号");
        String sid = new String();
        while(true){
            int count = 0;
             sid = sc.nextLine();
            //判断学号是否存在
            for (int i = 0; i < stuList.size(); i++) {
                Student stu = stuList.get(i);
                String id = stu.getSid();
                if (sid.equals(id)) {
                    System.out.println("该学号已经存在，请重新录入...");
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
        }
        System.out.println("请输入姓名");
        String name = sc.nextLine();
        System.out.println("请输入年龄");
        String age = sc.nextLine();
        System.out.println("请输入地址");
        String address = sc.nextLine();
        Student stu = new Student();

        stuList.add(new Student(sid,name,age,address));
        System.out.println("添加学生信息成功!");
    }

    /**
     * 删除
     */
    @Override
    public void delStu() {
        System.out.println("请输入删除方式...");
        System.out.println("1.按学号查找");
        System.out.println("2.删除全部");
        String del = sc.nextLine();
        switch (del) {
            case "1":
                System.out.println("请输入要删除的学生学号...");
                String id = sc.nextLine();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    String sid = stu.getSid();
                    if(id.equals(sid)) {
                        stuList.remove(stu);
                        System.out.println("删除学生信息成功");
                        return;
                    }
                    System.out.println("该学校没有该学生，请重新输入...");
                }
            case  "2":
                stuList.removeAll(stuList);
                System.out.println("信息已全部清空");
        }
    }

    /**
     * 修改
     */
    @Override
    public void updStu() {
        System.out.println("请输入要修改的学生学号...");
        String id = sc.nextLine();
        for (int i = 0; i < stuList.size(); i++) {
            Student stu = stuList.get(i);
            String sid = stu.getSid();
            if (id.equals(sid)) {
                System.out.println("请选择要修改的信息...");
                System.out.println("1.修改姓名");
                System.out.println("2.修改年龄");
                System.out.println("3.修改地址");
                System.out.println("4.全部修改");
                String upd = sc.nextLine();
                switch(upd) {
                    case "1":
                        System.out.println("请录入新的姓名...");
                        String newName = sc.nextLine();
                        stu.setName(newName);
                        System.out.println("姓名修改成功！");
                        break;
                    case "2":
                        System.out.println("请录入新的年龄...");
                        String newAge = sc.nextLine();
                        stu.setAge(newAge);
                        System.out.println("年龄修改成功！");
                        break;
                    case "3":
                        System.out.println("请录入新的地址...");
                        String newAddress = sc.nextLine();
                        stu.setAddress(newAddress);
                        System.out.println("地址修改成功！");
                        break;
                    case "4":
                        System.out.println("请录入新的姓名...");
                        String newNameA = sc.nextLine();
                        System.out.println("请录入新的年龄...");
                        String newAgeA = sc.nextLine();
                        System.out.println("请录入新的地址...");
                        String newAddressA = sc.nextLine();
                        stu.setName(newNameA);
                        stu.setAge(newAgeA);
                        stu.setAddress(newAddressA);
                        System.out.println("修改学生信息成功！");
                        break;
                }
                return;
            }
            System.out.println("该学校没有该学生，请重新输入...");
        }


    }

    @Override
    public void selStu() {
        System.out.println("请输入查找方式...");
        System.out.println("1.按学号查找");
        System.out.println("2.查看全部");
        String sel = sc.nextLine();
        switch (sel) {

            case "1":
                System.out.println("请输入要查询学生的学号...");
                String id = sc.nextLine();
                System.out.println("学生信息如下...");
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    String sid = stu.getSid();
                    String name = stu.getName();
                    String age = stu.getAge();
                    String address = stu.getAddress();
                    if (id.equals(sid)) {
                        System.out.println(sid + "\t" + name + "\t" + age + "\t" + address + "\t");
                    }
                }
                break;

            case "2":
                System.out.println("学生信息如下...");
                System.out.println("学号\t姓名\t年龄\t地址");
                for (Student stu: stuList) {
                    System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress() + "\t");
                }
                break;
        }
        System.out.println("查询学生信息成功!");
    }
}
