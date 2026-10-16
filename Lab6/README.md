# LAB6 – Hệ thống quản lý bệnh viện

## 1. Thông tin sinh viên

- **Họ và tên:** Phan Ngọc Bảo Anh
- **MSSV:** 1250080010
- **Môn học:** Lập trình hướng đối tượng (OOSD)
- **Tên bài Lab:** LAB6 – Xây dựng hệ thống quản lý bệnh viện

## 2. Môi trường và phiên bản

| Thành phần | Công nghệ / Phiên bản |
|---|---|
| Hệ điều hành | Windows |
| Ngôn ngữ lập trình | Java |
| JDK | Kiểm tra theo phiên bản đã cài đặt |
| Framework | Spring Boot |
| Giao diện | HTML, Thymeleaf, CSS |
| Cơ sở dữ liệu | Microsoft SQL Server |
| Công cụ quản lý cơ sở dữ liệu | SQL Server Management Studio (SSMS) |
| IDE | Visual Studio Code |
| Công cụ xây dựng | Maven |

## 3. Nội dung đã thực hiện

Bài Lab6 xây dựng hệ thống quản lý bệnh viện nhằm hỗ trợ lưu trữ thông tin bệnh nhân, quản lý hồ sơ bệnh án và thực hiện một số nghiệp vụ khám chữa bệnh.

Các chức năng chính:

- Đăng ký bệnh nhân mới.
- Lưu thông tin bệnh nhân gồm họ tên, ngày sinh, địa chỉ và số điện thoại.
- Tạo hồ sơ bệnh án và mã hồ sơ riêng cho bệnh nhân.
- Ghi nhận khoản thanh toán phí quản lý hồ sơ.
- Xây dựng giao diện khám bệnh.
- Lập toa thuốc cho bệnh nhân theo phiếu khám.
- Lưu thông tin toa thuốc và chi tiết từng loại thuốc vào cơ sở dữ liệu.
- Kết nối Java Spring Boot với SQL Server thông qua JDBC.
- Sử dụng câu lệnh SQL để kiểm tra dữ liệu đã lưu.

## 4. Kết quả thực hiện

Sau khi xây dựng chương trình, các nội dung được kiểm tra gồm:

- Giao diện đăng ký bệnh nhân hiển thị trên trình duyệt.
- Thông tin bệnh nhân được lưu vào bảng `BenhNhan`.
- Hồ sơ bệnh án được tạo trong bảng `HoSoBenhAn`.
- Thông tin thanh toán được ghi nhận trong bảng `ThanhToan`.
- Giao diện lập toa thuốc hiển thị danh sách thuốc từ cơ sở dữ liệu.
- Toa thuốc được lưu vào bảng `ToaThuoc`.
- Chi tiết thuốc được lưu vào bảng `ChiTietToaThuoc`.
- Dữ liệu có thể được kiểm tra trực tiếp bằng các câu lệnh SQL trong SSMS.

**Lưu ý:** Chỉ xác nhận những chức năng đã chạy thành công trên máy. Nếu chức năng nào chưa kiểm thử được thì cần kiểm tra lại trước khi nộp bài.

## 5. Lỗi gặp phải và cách khắc phục

### 5.1. Lỗi không tìm thấy trang đăng ký bệnh nhân

**Biểu hiện:** Trình duyệt hiển thị lỗi Whitelabel Error Page hoặc mã lỗi 404 khi truy cập đường dẫn đăng ký bệnh nhân.

**Nguyên nhân có thể:**
- Controller chưa khai báo đúng đường dẫn.
- Spring Boot chưa quét được package chứa Controller.
- File HTML chưa nằm đúng thư mục templates.

**Cách khắc phục:**
- Kiểm tra các phương thức `@GetMapping` và `@PostMapping`.
- Đặt Controller trong package con của package chứa lớp khởi chạy Spring Boot.
- Đặt file HTML trong `src/main/resources/templates/`.
- Kiểm tra dependency Thymeleaf trong `pom.xml`.

### 5.2. Lỗi kết nối SQL Server

**Nguyên nhân có thể:** URL kết nối, tên database, tài khoản hoặc mật khẩu không chính xác; SQL Server chưa chạy.

**Cách khắc phục:**
- Kiểm tra cấu hình trong file `application.properties`.
- Kiểm tra database `QuanLyBenhVien` đã tồn tại.
- Kiểm tra SQL Server đang hoạt động và thông tin đăng nhập chính xác.

### 5.3. Lỗi khóa ngoại khi lưu toa thuốc

**Nguyên nhân có thể:** Mã phiếu khám hoặc mã thuốc không tồn tại trong cơ sở dữ liệu.

**Cách khắc phục:**
- Kiểm tra dữ liệu trong bảng `PhieuKham`.
- Kiểm tra danh sách thuốc trong bảng `Thuoc`.
- Chọn mã phiếu khám và mã thuốc hợp lệ trước khi lưu toa.

### 5.4. Lỗi trùng toa thuốc

**Nguyên nhân có thể:** Phiếu khám đã có toa thuốc và cột `MaPhieuKham` được thiết lập ràng buộc duy nhất.

**Cách khắc phục:** Kiểm tra toa thuốc đã tồn tại trước khi tạo mới hoặc sử dụng một phiếu khám khác để kiểm thử.

## 6. Hướng dẫn chạy lại chương trình

### Bước 1. Chuẩn bị môi trường

Cài đặt Java JDK, Maven hoặc Maven Wrapper, Visual Studio Code và Microsoft SQL Server.

### Bước 2. Mở dự án

Mở thư mục chứa dự án LAB6 trong Visual Studio Code. Mở Terminal tại thư mục có file `pom.xml`.

### Bước 3. Tạo và kiểm tra cơ sở dữ liệu

Mở SQL Server Management Studio, tạo database có tên:

```sql
CREATE DATABASE QuanLyBenhVien;
```

Nếu database đã tồn tại thì không cần tạo lại. Tiếp theo, chạy script SQL tạo bảng và dữ liệu mẫu của dự án theo đúng thứ tự phụ thuộc giữa các bảng.

### Bước 4. Cấu hình kết nối

Mở file:

```text
src/main/resources/application.properties
```

Kiểm tra cấu hình kết nối SQL Server. Ví dụ:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=QuanLyBenhVien;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

spring.thymeleaf.cache=false
```

Thay `YOUR_PASSWORD` bằng mật khẩu SQL Server của môi trường chạy thực tế. Nếu SQL Server sử dụng instance hoặc cổng khác, cần sửa URL cho phù hợp.

### Bước 5. Khởi chạy ứng dụng

Chạy các lệnh sau trong Terminal:

```bash
mvn clean
mvn spring-boot:run
```

Nếu dự án sử dụng Maven Wrapper trên Windows, có thể chạy:

```powershell
.\mvnw.cmd spring-boot:run
```

Chờ đến khi Terminal thông báo ứng dụng đã khởi chạy thành công.

### Bước 6. Truy cập giao diện

Mở trình duyệt và truy cập:

```text
http://localhost:8080/dang-ky-benh-nhan
```

Để mở giao diện khám bệnh:

```text
http://localhost:8080/kham-benh
```

### Bước 7. Kiểm tra dữ liệu

Sau khi đăng ký bệnh nhân, mở SSMS và chạy:

```sql
USE QuanLyBenhVien;

SELECT TOP 10 *
FROM BenhNhan
ORDER BY MaBenhNhan DESC;

SELECT TOP 10 *
FROM HoSoBenhAn
ORDER BY MaHoSo DESC;

SELECT TOP 10 *
FROM ThanhToan
ORDER BY MaThanhToan DESC;
```

Sau khi lưu toa thuốc, kiểm tra:

```sql
SELECT TOP 10 *
FROM ToaThuoc
ORDER BY MaToaThuoc DESC;

SELECT TOP 20 *
FROM ChiTietToaThuoc
ORDER BY MaChiTiet DESC;
```

Nếu dữ liệu vừa nhập xuất hiện trong các bảng tương ứng thì có thể xác nhận dữ liệu đã được ghi vào cơ sở dữ liệu.
## 8. Kết luận

Bài LAB6 giúp vận dụng Java Spring Boot để xây dựng ứng dụng quản lý bệnh viện trên nền tảng web. Chương trình kết nối SQL Server để lưu trữ thông tin bệnh nhân, hồ sơ bệnh án, thanh toán và toa thuốc. Qua bài thực hành, sinh viên làm quen với việc xây dựng giao diện web, xử lý dữ liệu bằng JDBC và kiểm tra dữ liệu trực tiếp trên hệ quản trị cơ sở dữ liệu.