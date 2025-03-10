package Baitap1;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Account a = new Account("A", 0);

        int n = 1;
        Scanner sc = new Scanner(System.in);

        while(n != 0) {
            System.out.println("Menu: ");
            System.out.println("1. Kiem tra so du: ");
            System.out.println("2. Nap tien: ");
            System.out.println("3. Rut tien: ");
            System.out.println("4. Thoat ");
            n = sc.nextInt();
            switch(n) {
                case 1:
                    a.checkDraw();
                    break;
                case 2:
                    System.out.println("Nhap so tien can nap: ");
                    int c = sc.nextInt();
                    Runnable task1 = new LoadDrawTask(a, c);
                    Thread t1 = new Thread(task1);
                    t1.start();
                    try {
                        t1.join();  // Đợi luồng nạp tiền hoàn thành trước khi tiếp tục
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Nhap so tien can rut nguoi 1: ");
                    int d = sc.nextInt();
                    System.out.println("Nhap so tien can rut nguoi 2: ");
                    int v = sc.nextInt();
                    Runnable task3 = new WithDrawTask(a, d);
                    Thread t3 = new Thread(task3);
                    t3.start();
                    Runnable task2 = new WithDrawTask(a, v);
                    Thread t2 = new Thread(task2);
                    t2.start();
                    try {
                        t2.join();  // Đợi luồng nạp tiền hoàn thành trước khi tiếp tục
                        t3.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Thoat ");
                    return;
            }
        }
     }
}
