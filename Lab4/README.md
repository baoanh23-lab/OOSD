LAB4 - HỆ THỐNG CỬA HÀNG ONLINE e-SHOPPING
1. Thông tin sinh viên
Họ và tên: Bảo Anh
MSSV: 1250080010
Tên bài Lab: LAB4 - Hệ thống phần mềm Cửa hàng online e-SHOPPING
2. Môi trường và phiên bản
Hệ điều hành: Windows 11
IDE: Visual Studio Code
Java: JDK 21
Spring Boot: 3.4.4
Build Tool: Maven
Database: Microsoft SQL Server
Giao diện: HTML, CSS, Thymeleaf
ORM: Spring Data JPA / Hibernate
Quản lý mã nguồn: GitHub
3. Nội dung đã thực hiện

Trong LAB4, em xây dựng một phần hệ thống cửa hàng online e-SHOPPING bằng Java Spring Boot, Thymeleaf và SQL Server.

Các nội dung đã thực hiện:

Phân tích bài toán hệ thống cửa hàng online e-SHOPPING.
Xây dựng cơ sở dữ liệu SQL Server cho hệ thống.
Kết nối ứng dụng Spring Boot với SQL Server.
Xây dựng các Entity tương ứng với cơ sở dữ liệu.
Xây dựng Repository để truy vấn dữ liệu.
Xây dựng Controller xử lý các chức năng.
Sử dụng Thymeleaf để hiển thị dữ liệu lên giao diện.
Hiển thị danh sách nhóm sản phẩm.
Hiển thị danh sách sản phẩm.
Lọc sản phẩm theo nhóm sản phẩm.
Hiển thị thông tin sản phẩm.
Xây dựng chức năng thêm sản phẩm vào giỏ hàng.
Lưu thông tin giỏ hàng vào cơ sở dữ liệu.
Tự động tăng số lượng khi thêm lại cùng một sản phẩm.
Tính tổng tiền của giỏ hàng.
Hiển thị thông tin giỏ hàng.
4. Cơ sở dữ liệu

Cơ sở dữ liệu sử dụng trong LAB4 là:

eSHOPPING

Các bảng chính:

KhachHang
NhomSanPham
SanPham
GioHang
ChiTietGioHang
DonDatHang
ChiTietDonHang
ThongTinNguoiNhan
TheTinDung

Trong đó:

SanPham lưu thông tin sản phẩm.
NhomSanPham quản lý nhóm sản phẩm.
GioHang lưu giỏ hàng của khách hàng.
ChiTietGioHang lưu các sản phẩm và số lượng trong giỏ hàng.
5. Kết quả

Sau khi hoàn thành LAB4:

Ứng dụng Spring Boot chạy thành công.
Kết nối thành công với SQL Server.
Hiển thị được danh sách sản phẩm từ cơ sở dữ liệu.
Hiển thị được nhóm sản phẩm.
Có thể lọc sản phẩm theo nhóm.
Có thể thêm sản phẩm vào giỏ hàng.
Khi thêm lại cùng một sản phẩm, số lượng sản phẩm được tăng lên.
Tổng tiền giỏ hàng được tính lại theo số lượng và đơn giá.
Có thể xem thông tin giỏ hàng trên giao diện web.
6. Lỗi gặp phải

Trong quá trình thực hiện LAB4, em gặp một số lỗi:

Hibernate tự động chuyển tên bảng SanPham thành san_pham.
Lỗi Invalid object name 'san_pham' khi truy vấn dữ liệu.
Lỗi do tên bảng và tên cột trong Entity không trùng với SQL Server.
Lỗi khi cấu hình kết nối Spring Boot với SQL Server.
File CSS chưa được áp dụng cho giao diện.
Chức năng "Thêm vào giỏ" ban đầu chỉ hiển thị nút nhưng chưa lưu dữ liệu vào cơ sở dữ liệu.
7. Cách khắc phục
Khai báo rõ tên bảng bằng @Table.
Khai báo rõ tên cột bằng @Column.
Cấu hình Hibernate không tự đổi tên bảng và cột bằng:
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
Kiểm tra lại tên bảng và tên cột trong SQL Server.
Kiểm tra thông tin kết nối database trong application.properties.
Đặt file CSS trong thư mục:
src/main/resources/static/css
Sử dụng Controller để xử lý chức năng thêm sản phẩm vào giỏ hàng.
Sau khi thêm sản phẩm, cập nhật lại số lượng và tổng tiền trong cơ sở dữ liệu.
8. Hướng dẫn chạy lại
Bước 1: Chuẩn bị môi trường

Cần cài đặt:

JDK 21
Visual Studio Code
SQL Server
Maven
Bước 2: Tạo cơ sở dữ liệu

Mở SQL Server và chạy file SQL của LAB4 để tạo database:

eSHOPPING

Sau đó kiểm tra các bảng đã được tạo đầy đủ.

Bước 3: Kiểm tra cấu hình database

Mở file:

src/main/resources/application.properties

Kiểm tra các thông tin:

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=eSHOPPING;encrypt=true;trustServerCertificate=true

spring.datasource.username=sa

spring.datasource.password=MAT_KHAU_SQL_SERVER

Thay MAT_KHAU_SQL_SERVER bằng mật khẩu SQL Server trên máy cần chạy.

Bước 4: Chạy chương trình

Mở Terminal tại thư mục project và chạy:

mvnw spring-boot:run

Hoặc chạy class Spring Boot chính của project trong Visual Studio Code.

Bước 5: Kiểm tra chức năng sản phẩm

Mở trình duyệt:

http://localhost:8080/san-pham

Kiểm tra:

Danh sách sản phẩm.
Nhóm sản phẩm.
Lọc sản phẩm theo nhóm.
Thông tin sản phẩm.
Nút Thêm vào giỏ.
Bước 6: Kiểm tra giỏ hàng

Sau khi thêm sản phẩm vào giỏ, truy cập:

http://localhost:8080/gio-hang

Kiểm tra:

Mã sản phẩm.
Số lượng.
Đơn giá.
Thành tiền.
Tổng tiền giỏ hàng.
9. Cấu trúc project
LAB4
│
├── src
│   └── main
│       ├── java
│       │   └── lab4
│       │       └── lab4
│       │           ├── controller
│       │           ├── entity
│       │           └── repository
│       │
│       └── resources
│           ├── static
│           │   └── css
│           │       └── style.css
│           │
│           ├── templates
│           │   ├── sanpham.html
│           │   └── giohang.html
│           │
│           └── application.properties
│
├── pom.xml
└── README.md
10. Kết luận

LAB4 đã thực hiện được các chức năng chính của hệ thống e-SHOPPING trong phạm vi bài Lab, bao gồm kết nối cơ sở dữ liệu, hiển thị sản phẩm, lọc sản phẩm theo nhóm và quản lý giỏ hàng. Source code được lưu trên GitHub để phục vụ việc kiểm tra và chạy lại.