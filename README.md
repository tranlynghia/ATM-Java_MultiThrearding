# ATM_JavaMultithreading

Dự án **ATM_JavaMultithreading** mô phỏng một hệ thống ATM với các chức năng cơ bản như kiểm tra số dư, rút tiền và nạp tiền. Chương trình sử dụng kỹ thuật **đa luồng** (Multithreading) trong Java để mô phỏng các giao dịch đồng thời của nhiều người dùng trên cùng một tài khoản.

## Mô tả

Dự án này được xây dựng bằng ngôn ngữ **Java**, sử dụng đa luồng để xử lý các giao dịch trên một tài khoản ATM. Các chức năng chính của hệ thống bao gồm:
- Kiểm tra số dư tài khoản
- Nạp tiền vào tài khoản
- Rút tiền từ tài khoản

Các giao dịch rút tiền và nạp tiền được xử lý trên các luồng riêng biệt, và hệ thống đảm bảo tính đồng bộ để tránh xung đột dữ liệu khi nhiều giao dịch xảy ra đồng thời.

## Các tính năng chính
- **Đa luồng (Multithreading):** Các giao dịch rút tiền và nạp tiền được xử lý đồng thời trên các luồng khác nhau.
- **Đồng bộ dữ liệu:** Sử dụng cơ chế đồng bộ (`synchronized`) để đảm bảo rằng các thay đổi trên tài khoản không bị xung đột khi thực hiện các giao dịch đồng thời.
- **Giao diện người dùng đơn giản:** Dự án cung cấp một giao diện dòng lệnh cho người dùng để thực hiện các giao dịch như kiểm tra số dư, rút tiền, và nạp tiền.

## Cấu trúc dự án

```
ATM_JavaMultithreading/
├── src/
│   ├── Account.java                # Lớp mô phỏng tài khoản ATM
│   ├── Client.java                 # Lớp điều khiển ứng dụng (Giao diện dòng lệnh)
│   ├── LoadDrawTask.java           # Lớp thực hiện nạp tiền vào tài khoản
│   ├── WithDrawTask.java           # Lớp thực hiện rút tiền từ tài khoản
│   └── README.md                  # Tài liệu hướng dẫn sử dụng
└── build.gradle                   # Cấu hình dự án (nếu sử dụng Gradle)
```

## Cài đặt và sử dụng

### Yêu cầu hệ thống
- **Java 8** hoặc phiên bản cao hơn.
- IDE hỗ trợ Java như IntelliJ IDEA, Eclipse, hoặc bạn có thể sử dụng terminal/command line.

### Cài đặt
1. Clone repository về máy:
   ```bash
   git clone https://github.com/tranlynghia/ATM-Java_MultiThrearding.git
   ```

2. Mở dự án trong IDE của bạn hoặc biên dịch thông qua terminal:
   ```bash
   javac src/*.java
   ```

3. Chạy ứng dụng:
   ```bash
   java Client
   ```

### Hướng dẫn sử dụng
Khi ứng dụng chạy, bạn sẽ được hiển thị menu lựa chọn với các tùy chọn:
- **1. Kiểm tra số dư:** Hiển thị số dư hiện tại của tài khoản.
- **2. Nạp tiền:** Bạn có thể nhập số tiền cần nạp vào tài khoản.
- **3. Rút tiền:** Nhập số tiền cần rút. Nếu tài khoản đủ số dư, giao dịch sẽ được thực hiện; nếu không, thông báo sẽ xuất hiện.
- **4. Thoát:** Thoát khỏi ứng dụng.

### Ví dụ
Khi người dùng chọn **Nạp tiền**, hệ thống sẽ tạo một luồng mới để thực hiện giao dịch nạp tiền. Cùng lúc đó, người dùng có thể thực hiện các giao dịch rút tiền trên các luồng khác mà không gặp xung đột dữ liệu, nhờ vào cơ chế **đồng bộ** của Java.

## Các lớp chính

### **Account.java**
Lớp này mô phỏng tài khoản ATM. Nó bao gồm các phương thức để kiểm tra số dư, nạp tiền và rút tiền. Các giao dịch thay đổi số dư tài khoản sẽ được thực hiện trong một khối đồng bộ (`synchronized`) để đảm bảo an toàn khi truy cập đồng thời từ nhiều luồng.

- **Phương thức `withdraw(double a)`**: Rút tiền từ tài khoản, yêu cầu kiểm tra số dư và đồng bộ hóa khi thay đổi số dư.
- **Phương thức `checkDraw()`**: Hiển thị số dư hiện tại của tài khoản.
- **Phương thức `loadDraw(int a)`**: Nạp tiền vào tài khoản, yêu cầu đồng bộ hóa khi thay đổi số dư.

### **Client.java**
Lớp điều khiển chính của ứng dụng. Người dùng sẽ chọn các tùy chọn từ menu để thực hiện các giao dịch. Các giao dịch nạp tiền và rút tiền sẽ được thực hiện trên các luồng riêng biệt. Sử dụng `Thread.join()` để đảm bảo các luồng hoàn thành trước khi tiếp tục.

### **LoadDrawTask.java**
Lớp này là một lớp thực thi `Runnable`, được sử dụng để thực hiện giao dịch nạp tiền trong một luồng riêng biệt.

### **WithDrawTask.java**
Lớp này cũng là một lớp thực thi `Runnable`, được sử dụng để thực hiện giao dịch rút tiền trong một luồng riêng biệt.

## Liên hệ

Nếu bạn có bất kỳ câu hỏi nào về dự án hoặc muốn đóng góp, hãy liên hệ với tôi qua GitHub hoặc email: tranlynghia2202@gmail.com.

---

Hy vọng rằng README này sẽ giúp bạn mô tả rõ ràng về dự án của mình. Bạn có thể điều chỉnh nội dung và chi tiết theo nhu cầu thực tế của dự án.
