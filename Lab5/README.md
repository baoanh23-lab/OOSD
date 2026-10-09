# BÁO CÁO THỰC HÀNH HỌC PHẦN OOSD - LAB 3

## 1. Thông tin sinh viên
* **Họ và tên:** Phan Ngọc Bảo Anh
* **Mã số sinh viên (MSSV):** 1250080010
* **Lớp:** 12_ĐH_CNPM1
* **Trường:** Trường Đại học Tài nguyên và Môi trường TP.HCM (HCMRE)

---

## 2. Thông tin bài Lab
* **Tên bài Lab:** Xây dựng hệ thống giao diện và chức năng nghiệp vụ phần mềm Quản lý Công ty Du lịch (Travel Company Management System).
* **Môi trường & Công nghệ sử dụng:**
  * **Ngôn ngữ lập trình:** Java (JDK 17/21)
  * **Framework:** Spring Boot (Spring MVC, Thymeleaf)
  * **Frontend:** HTML5, CSS3, Bootstrap 5 (Giao diện giả lập Desktop ứng dụng Windows Forms)
  * **Database & Quản trị:** Microsoft SQL Server, SQL Server Management Studio (SSMS)
  * **IDE phát triển:** Visual Studio Code / IntelliJ IDEA

---

## 3. Nội dung đã thực hiện
* **Xây dựng cấu trúc dự án Spring Boot:**
  * Thiết lập cấu hình `TrangChuController` điều hướng linh hoạt sử dụng cơ chế `forward` tĩnh cho các module giao diện hệ thống.
* **Hoàn thiện các phân hệ giao diện & nghiệp vụ:**
  * **Phân hệ Danh mục & Xe:** Quản lý thông tin phương tiện, danh mục hệ thống (`danhmuc.html`).
  * **Phân hệ Quản lý Tour & Hành trình:** Thiết lập chi tiết hành trình gồm Tab Tour (`tour.html`), Điểm dừng (`tour-diem-dung.html`), Phương tiện theo chặng (`tour-phuong-tien.html`), và Điểm tham quan (`tour-diem-tham-quan.html`).
  * **Phân hệ Đặt vé & Quản lý chuyến:** Lịch chuyến khách lẻ (`lich-chuyen-le.html`), Đăng ký và thanh toán vé khách lẻ (`dang-ky-le.html`), Phiếu đăng ký đoàn và danh sách đoàn (`dang-ky-doan.html`).
  * **Phân hệ Phân công & Kết thúc tour:** Phân công Hướng dẫn viên (`phan-cong.html`), Thanh toán sau tour đoàn & Khảo sát khách hàng (`ket-thuc-tour.html`, `khao-sat-khach-hang.html`).
  * **Phân hệ Thống kê & Báo cáo:** Quản lý lương Hướng dẫn viên và thống kê tổng hợp doanh thu, khảo sát (`luong-huong-dan-vien.html`, v.v.).

---

## 4. Kết quả đạt được
* Xây dựng thành công toàn bộ giao diện đồng bộ theo phong cách ứng dụng Desktop (Windows Forms) tích hợp trực quan trên nền tảng Web thông qua Thymeleaf và Bootstrap 5.
* Kết nối thành công hệ thống định tuyến (Controller) với các file HTML tĩnh, đảm bảo trải nghiệm người dùng mượt mà khi chuyển đổi giữa các tab và phân hệ nghiệp vụ.

---

## 5. Lỗi gặp phải và Cách khắc phục
* **Lỗi 1 (404 Not Found khi gọi route):**
  * *Nguyên nhân:* Spring Boot hiểu nhầm các đường dẫn URI (như `/danh-muc`, `/tour-hanh-trinh`) là tìm file tĩnh trong thư mục `static` thay vì gọi vào phương thức của Controller.
  * *Cách khắc phục:* Khai báo tường minh các phương thức `@GetMapping` trong `TrangChuController` trả về giá trị `forward:/filename.html` kết hợp đặt đúng vị trí file trong thư mục tài nguyên.
* **Lỗi 2 (Hiển thị giao diện lệch kích thước khung cửa sổ desktop):**
  * *Cách khắc phục:* Sử dụng khung bao bọc `.desktop-window` kết hợp CSS tùy chỉnh bo viền, màu nền xám đặc trưng (`#e2e8f0` và `#f1f1f1`) để giả lập chính xác giao diện phần mềm desktop trên trình duyệt web.

---

## 6. Hướng dẫn kiểm tra và chạy lại ứng dụng
1. Clone repository về máy cá nhân hoặc mở trực tiếp bằng IDE (VS Code / IntelliJ).
2. Đảm bảo cấu hình kết nối cơ sở dữ liệu `QuanLyCongTyDuLich` trên SQL Server tại `application.properties` (nếu có kết nối DB thực tế).
3. Chạy lệnh khởi động Spring Boot ứng dụng:
   ```bash
   mvn spring-boot:run