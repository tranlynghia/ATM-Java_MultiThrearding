package Baitap1;

public class Account {
    private String name;
    private double amount;

    public Account(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Rút tiền (đồng bộ)
    public void withdraw(double a) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " -> Dang kiem tra so du:" + amount);

        synchronized(this) {  //Chỉ đồng bộ phần thay đổi dữ liệu
            if (this.getAmount() >= a) {
                System.out.println(threadName + " -> Dang rut: " + a);
                Thread.sleep(1000);

                this.setAmount(this.getAmount() - a);
                System.out.println(threadName + " -> So du hien tai: " + this.getAmount());
            } else {
                System.out.println(threadName + " -> Khong du tien!");
            }
        }
    }

    // Kiểm tra số dư (không cần đồng bộ vì không thay đổi dữ liệu)
    public void checkDraw() {
        System.out.println("Số dư hiện tại: " + this.amount);
    }

    // Nạp tiền (đồng bộ)
    public void loadDraw(int a) throws InterruptedException {
        if (a <= 0) {
            System.out.println("Số tiền không hợp lệ!");
            return;
        }

        synchronized (this) {
            System.out.println("Đang nạp: " + a);
            Thread.sleep(1000);

            this.amount += a;
            System.out.println("Số dư hiện tại: " + this.amount);
        }
    }
}
