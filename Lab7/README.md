# LAB7 – HỆ THỐNG QUẢN LÝ NHÂN SỰ

## 1. Thông tin sinh viên

- **Họ và tên:** Phan Ngọc Bảo Anh 
- **MSSV:** 1250080010
- **Tên bài Lab:** LAB7 – Xây dựng hệ thống quản lý nhân sự

## 2. Môi trường và công nghệ

- **Hệ quản trị cơ sở dữ liệu:** Microsoft SQL Server
- **Công cụ quản lý cơ sở dữ liệu:** SQL Server Management Studio (SSMS)
- **Ngôn ngữ truy vấn:** SQL
- **Công cụ thiết kế sơ đồ:** PlantUML
- **Hệ thống:** Quản lý nhân sự

## 3. Nội dung đã thực hiện

### 3.1. Phân tích nghiệp vụ

Phân tích các nghiệp vụ chính của hệ thống quản lý nhân sự, bao gồm:

- Quản lý tuyển dụng và thử việc.
- Quản lý hợp đồng lao động.
- Quản lý hồ sơ bảo hiểm y tế và bảo hiểm xã hội.
- Quản lý quyết định chức vụ, quyết định lương và phụ cấp.
- Lập kế hoạch phân ca và quản lý chấm công.
- Quản lý quyết định khen thưởng, kỷ luật.
- Tính lương hằng tháng và lập phiếu thu chi.

### 3.2. Phân tích và thiết kế hệ thống

Đã xây dựng các sơ đồ phục vụ phân tích và thiết kế hệ thống:

- Sơ đồ Use Case tổng quát.
- Sơ đồ phân rã Use Case quản lý tuyển dụng và thử việc.
- Sơ đồ phân rã Use Case tính và lập bảng lương.
- Sơ đồ lớp phân tích.
- Sơ đồ hoạt động quản lý tuyển dụng và thử việc.
- Sơ đồ hoạt động tính và lập bảng lương.
- Sơ đồ lớp chi tiết.
- Sơ đồ tuần tự quản lý tuyển dụng và thử việc.
- Sơ đồ tuần tự tính và lập bảng lương.

### 3.3. Xây dựng cơ sở dữ liệu

Tạo cơ sở dữ liệu `QuanLyNhanSu` trên SQL Server.

Các bảng chính gồm:

1. `PhongBan`
2. `NhanVien`
3. `QuyetDinhTuyenDung`
4. `HopDongLaoDong`
5. `HoSoBaoHiem`
6. `QuyetDinhChucVu`
7. `QuyetDinhLuong`
8. `BangChamCong`
9. `PhieuGhiNhanPhuTroi`
10. `QuyetDinhKhenThuongKyLuat`
11. `PhieuThuChi`
12. `BangLuong`

Các bảng được thiết kế với khóa chính, khóa ngoại và một số ràng buộc dữ liệu nhằm đảm bảo tính liên kết giữa các nghiệp vụ.

### 3.4. Dữ liệu mẫu

Đã thêm dữ liệu mẫu cho các bảng phòng ban, nhân viên, quyết định tuyển dụng, hợp đồng lao động, hồ sơ bảo hiểm, quyết định lương, quyết định khen thưởng và phiếu thu chi.

### 3.5. Thiết kế giao diện

Các giao diện dự kiến hoặc đã thiết kế theo nội dung bài lab:

- Giao diện chính (Main).
- Giao diện danh mục phòng ban.
- Giao diện tuyển dụng.
- Giao diện khen thưởng.

## 4. Kết quả thực hiện

- Phân tích được các nghiệp vụ cơ bản của hệ thống quản lý nhân sự.
- Xây dựng được các sơ đồ UML phục vụ phân tích và thiết kế.
- Xây dựng script tạo cơ sở dữ liệu và các bảng liên quan.
- Khai báo các khóa chính, khóa ngoại và ràng buộc dữ liệu.
- Thêm dữ liệu mẫu để phục vụ kiểm tra cơ sở dữ liệu.
- Xác định được các giao diện chính cần có của hệ thống.

## 5. Lỗi gặp phải và cách khắc phục

Trong quá trình thực hiện, cần kiểm tra các vấn đề sau:

- **Lỗi tạo bảng do thứ tự phụ thuộc:** Tạo bảng được tham chiếu trước khi tạo bảng có khóa ngoại.
- **Lỗi khóa ngoại:** Kiểm tra kiểu dữ liệu và giá trị khóa được tham chiếu phải tồn tại.
- **Lỗi dữ liệu trùng lặp:** Kiểm tra các cột có ràng buộc `UNIQUE` trước khi thêm dữ liệu.
- **Lỗi dữ liệu không hợp lệ:** Kiểm tra các ràng buộc `CHECK`, kiểu dữ liệu và trường bắt buộc trước khi thực hiện câu lệnh `INSERT`.

Nếu gặp lỗi khi chạy script, đọc thông báo lỗi trong SSMS, xác định bảng hoặc câu lệnh bị lỗi và sửa trước khi chạy lại.

## 6. Hướng dẫn chạy lại bài Lab

### Bước 1: Mở SQL Server Management Studio

Kết nối đến SQL Server đang sử dụng trên máy tính.

### Bước 2: Tạo cơ sở dữ liệu

Mở file SQL của bài lab, thực hiện phần tạo cơ sở dữ liệu:

```sql
CREATE DATABASE QuanLyNhanSu;
GO

USE QuanLyNhanSu;
GO
```

Nếu cơ sở dữ liệu đã tồn tại, không chạy lại lệnh tạo database; có thể sử dụng database hiện có hoặc tạo một database mới để kiểm tra.

### Bước 3: Tạo các bảng

Chạy các câu lệnh `CREATE TABLE` theo đúng thứ tự trong script SQL, bắt đầu từ bảng `PhongBan`, `NhanVien` và các bảng nghiệp vụ liên quan.

### Bước 4: Thêm dữ liệu mẫu

Chạy các câu lệnh `INSERT INTO` để thêm dữ liệu mẫu vào các bảng.

### Bước 5: Kiểm tra kết quả

Sử dụng các câu lệnh sau để kiểm tra dữ liệu:

```sql
USE QuanLyNhanSu;
GO

SELECT * FROM PhongBan;
SELECT * FROM NhanVien;
SELECT * FROM QuyetDinhTuyenDung;
SELECT * FROM HopDongLaoDong;
SELECT * FROM HoSoBaoHiem;
SELECT * FROM QuyetDinhLuong;
SELECT * FROM BangChamCong;
SELECT * FROM PhieuGhiNhanPhuTroi;
SELECT * FROM QuyetDinhKhenThuongKyLuat;
SELECT * FROM PhieuThuChi;
SELECT * FROM BangLuong;
GO
```

### Bước 6: Kiểm tra sơ đồ UML

Mở mã PlantUML của từng sơ đồ và xuất hình để kiểm tra nội dung, mối quan hệ giữa các lớp và trình tự xử lý nghiệp vụ.

## 7. Kết luận
Bài LAB7 đã thực hiện việc phân tích nghiệp vụ, thiết kế các sơ đồ UML và xây dựng cơ sở dữ liệu cho hệ thống quản lý nhân sự. Hệ thống hướng đến việc hỗ trợ quản lý hồ sơ nhân viên, tuyển dụng, hợp đồng, chấm công, tiền lương và khen thưởng, kỷ luật.


