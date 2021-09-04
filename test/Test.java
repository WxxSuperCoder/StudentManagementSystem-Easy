package com.study.enety.demo13.test;

import com.study.enety.demo13.entity.Student;
import com.study.enety.demo13.service.StudentService;
import com.study.enety.demo13.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImpl();

        System.out.println("*****学生管理系统*****");

        while(true) {
            System.out.println("请选择您要进行的操作");
            System.out.println("1.添加学生信息");
            System.out.println("2.删除学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.查看学生信息");
            System.out.println("5.退出当前系统");
            String s = sc.nextLine();
            switch(s) {
                case "1":
                    service.addStu();
                    break;
                case "2":
                    service.delStu();
                    break;
                case "3":
                    service.updStu();
                    break;
                case "4":
                    service.selStu();
                    break;
                case "5":
                    System.out.println("退出系统成功");
                    System.exit(0);
                default:
                    System.out.println("录入有误，请重新录入");
            }
        }

    }
}
