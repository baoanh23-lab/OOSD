# LAB3 - Quản lý khách sạn

## 1. Thông tin sinh viên

- Họ và tên: [HỌ TÊN]
- MSSV: [MSSV]
- Tên bài Lab: LAB3
- Môn học: Phân tích và thiết kế hướng đối tượng / OOSD

## 2. Môi trường thực hiện

- Hệ điều hành: Windows 11
- IDE: Visual Studio Code
- Java: JDK 21
- Spring Boot: 4.1.1
- Database: SQL Server
- Công cụ quản lý CSDL: SQL Server Management Studio
- Trình duyệt: Google Chrome

## 3. Nội dung đã thực hiện

- Xây dựng hệ thống quản lý khách sạn.
- Xây dựng cơ sở dữ liệu SQL Server.
- Xây dựng Backend bằng Java Spring Boot.
- Xây dựng giao diện Web.
- Xây dựng chức năng quản lý phòng.
- Xây dựng chức năng quản lý tiện nghi.
- Xây dựng chức năng quản lý dịch vụ.
- Xây dựng chức năng thống kê.
- Xây dựng API kết nối giữa giao diện và cơ sở dữ liệu.

## 4. Kết quả

- Chương trình chạy được trên máy cá nhân.
- Kết nối thành công với cơ sở dữ liệu.
- Các chức năng đã thực hiện và kiểm tra được.
- Kết quả thực tế được chụp màn hình và đưa vào báo cáo.

## 5. Lỗi gặp phải

Trong quá trình thực hiện, một số lỗi đã gặp:
- Lỗi kết nối cơ sở dữ liệu.
- Lỗi tên bảng hoặc tên cột không trùng với Entity.
- Lỗi API chưa trả về dữ liệu.
- Lỗi khi ánh xạ dữ liệu giữa Backend và giao diện.

## 6. Cách khắc phục

- Kiểm tra lại thông tin kết nối cơ sở dữ liệu.
- Kiểm tra tên bảng và tên cột trong SQL Server.
- Kiểm tra Entity, Repository và Controller.
- Kiểm tra URL API và dữ liệu trả về từ Backend.
- Chạy lại chương trình và kiểm tra trên trình duyệt.

## 7. Hướng dẫn giảng viên kiểm tra

### Bước 1: Clone repository

Clone repository LAB_OOSD về máy.

### Bước 2: Chuẩn bị môi trường

Cài đặt:
- JDK 21
- SQL Server
- Visual Studio Code

### Bước 3: Cấu hình cơ sở dữ liệu

- Mở SQL Server.
- Tạo database theo file SQL được cung cấp.
- Kiểm tra dữ liệu mẫu.

### Bước 4: Cấu hình project

- Mở thư mục LAB3 bằng Visual Studio Code.
- Kiểm tra cấu hình kết nối database.
- Đảm bảo SQL Server đang hoạt động.

### Bước 5: Chạy chương trình

Chạy project Spring Boot.

Sau khi chương trình khởi động thành công, truy cập địa chỉ:

http://localhost:8080

### Bước 6: Kiểm tra chức năng

Giảng viên có thể kiểm tra các chức năng:
- Quản lý phòng
- Quản lý tiện nghi
- Quản lý dịch vụ
- Thống kê
- Các chức năng khác được trình bày trong báo cáo.

## 8. Bằng chứng thực hiện

Các hình ảnh trong thư mục `Evidence` và báo cáo là bằng chứng được thực hiện trên máy cá nhân.

- Hình ảnh giao diện chương trình.
- Hình ảnh cơ sở dữ liệu.
- Hình ảnh kết quả chạy chương trình.
- Hình ảnh output của các chức năng.

## 9. Lưu ý

Không chứa trong repository:
- Thông tin cá nhân nhạy cảm.
- Mật khẩu.
- API Key hoặc Access Token.
- Ảnh chụp của người khác.
- Các thông tin không liên quan đến bài Lab.