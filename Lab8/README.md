# LAB8 – HỆ THỐNG QUẢN LÝ CHO THUÊ VĂN PHÒNG CAO ỐC

## 1. Thông tin sinh viên

- **Họ và tên:** Phan Ngọc Bảo Anh
- **MSSV:** 1250080010
- **Tên bài Lab:** LAB8 – Xây dựng hệ thống quản lý cho thuê văn phòng cao ốc

## 2. Môi trường và công nghệ

- **Ngôn ngữ lập trình:** Java
- **Framework Backend:** Spring Boot
- **Giao diện:** Giao diện người dùng của hệ thống
- **Hệ quản trị cơ sở dữ liệu:** Theo cấu hình thực tế của dự án
- **Công cụ thiết kế sơ đồ:** PlantUML
- **Công cụ kiểm thử API:** Postman
- **Hệ thống:** Quản lý cho thuê văn phòng cao ốc

## 3. Nội dung đã thực hiện

### 3.1. Phân tích nghiệp vụ

Phân tích các nghiệp vụ chính của hệ thống quản lý cho thuê văn phòng cao ốc, bao gồm:

- Quản lý tầng và văn phòng cho thuê.
- Quản lý khách hàng và công ty thuê văn phòng.
- Quản lý hợp đồng thuê văn phòng.
- Quản lý gia hạn hợp đồng thuê.
- Quản lý thanh toán tiền thuê văn phòng.
- Quản lý chi phí dịch vụ như điện, nước, Internet.
- Quản lý nhân viên của công ty thuê.
- Quản lý thẻ giữ xe cho nhân viên.
- Quản lý kiểm tra tình trạng văn phòng định kỳ.
- Quản lý vi phạm và xử lý tiền phạt.

### 3.2. Phân tích và thiết kế hệ thống

Sử dụng PlantUML để xây dựng các sơ đồ phục vụ quá trình phân tích và thiết kế hệ thống:

- Sơ đồ Use Case tổng quát.
- Sơ đồ phân rã Use Case.
- Sơ đồ lớp phân tích.
- Sơ đồ hoạt động gia hạn hợp đồng thuê văn phòng.
- Sơ đồ tuần tự gia hạn hợp đồng thuê văn phòng.
- Sơ đồ lớp chi tiết.

Ngoài ra, thực hiện đặc tả các Use Case chính như ký hợp đồng thuê văn phòng và gia hạn hợp đồng thuê văn phòng.

### 3.3. Xây dựng hệ thống Backend

Sử dụng Java và Spring Boot để xây dựng phần xử lý nghiệp vụ phía máy chủ.

Các nhóm chức năng chính của hệ thống gồm:

- Quản lý thông tin tầng và văn phòng.
- Quản lý thông tin khách hàng, công ty thuê.
- Tiếp nhận yêu cầu và lập hợp đồng thuê văn phòng.
- Xử lý yêu cầu gia hạn hợp đồng.
- Theo dõi thời hạn hợp đồng và tình trạng thuê.
- Quản lý thanh toán tiền thuê và chi phí dịch vụ.
- Quản lý thông tin nhân viên và thẻ giữ xe.
- Ghi nhận kết quả kiểm tra văn phòng.
- Quản lý thông tin vi phạm và tiền phạt.

### 3.4. Thiết kế giao diện

Xây dựng giao diện người dùng nhằm hỗ trợ thao tác và quản lý các nghiệp vụ của hệ thống.

Các giao diện được tổ chức theo những chức năng quản lý chính, giúp người dùng theo dõi thông tin văn phòng, khách hàng, hợp đồng và các hoạt động liên quan đến quá trình cho thuê.

### 3.5. Kiểm thử hệ thống

Sử dụng Postman để kiểm tra các API của Backend, bao gồm việc gửi yêu cầu và kiểm tra kết quả trả về từ hệ thống.

Kiểm tra các thao tác xử lý dữ liệu và nghiệp vụ tương ứng với những chức năng đã xây dựng.

## 4. Kết quả thực hiện

Sau quá trình thực hiện bài lab, đạt được các kết quả sau:

- Phân tích được các nghiệp vụ cơ bản của hệ thống quản lý cho thuê văn phòng cao ốc.
- Xác định được các đối tượng sử dụng và chức năng tương ứng.
- Xây dựng được các sơ đồ UML phục vụ phân tích và thiết kế hệ thống.
- Đặc tả được nghiệp vụ ký hợp đồng và gia hạn hợp đồng thuê văn phòng.
- Xây dựng phần Backend bằng Java Spring Boot.
- Xây dựng giao diện phục vụ thao tác với hệ thống.
- Thực hiện kiểm tra các API bằng Postman.

## 5. Lỗi gặp phải và cách khắc phục

Trong quá trình xây dựng hệ thống, một số lỗi có thể gặp phải và cách xử lý như sau:

| Lỗi | Cách khắc phục |
|---|---|
| Lỗi kết nối cơ sở dữ liệu | Kiểm tra thông tin kết nối, tên database, tài khoản và cấu hình trong file `application.properties`. |
| Lỗi khi khởi động Spring Boot | Kiểm tra thông báo lỗi trong Terminal, cấu hình dự án và các dependency. |
| Lỗi API không trả về dữ liệu | Kiểm tra URL, HTTP Method, Controller và Service xử lý nghiệp vụ. |
| Lỗi khi thêm hoặc cập nhật dữ liệu | Kiểm tra kiểu dữ liệu, trường bắt buộc và các ràng buộc trong cơ sở dữ liệu. |
| Lỗi giao diện không hiển thị dữ liệu | Kiểm tra địa chỉ API, dữ liệu phản hồi và quá trình kết nối giữa giao diện với Backend. |

Khi xảy ra lỗi, cần đọc thông báo trong Terminal hoặc Postman, xác định nguyên nhân và kiểm tra lại phần code hoặc cấu hình liên quan trước khi chạy lại.

## 6. Hướng dẫn chạy lại bài Lab

### Bước 1: Chuẩn bị môi trường

Cài đặt và kiểm tra các công cụ cần thiết:

- JDK tương thích với dự án.
- Visual Studio Code hoặc IntelliJ IDEA.
- Maven.
- Hệ quản trị cơ sở dữ liệu được cấu hình trong dự án.
- Postman để kiểm tra API.

### Bước 2: Mở mã nguồn dự án

Mở thư mục dự án bằng Visual Studio Code hoặc IntelliJ IDEA.

Kiểm tra file `pom.xml` để đảm bảo các thư viện cần thiết được khai báo đầy đủ.

### Bước 3: Cấu hình cơ sở dữ liệu

Mở file `application.properties` hoặc `application.yml` trong thư mục cấu hình của Spring Boot.

Kiểm tra và cập nhật thông tin kết nối cơ sở dữ liệu phù hợp với máy tính đang sử dụng.

### Bước 4: Khởi động Backend

Mở Terminal tại thư mục chứa file `pom.xml` và chạy lệnh:

```bash
mvn spring-boot:run
```

Nếu dự án sử dụng Maven Wrapper trên Windows, có thể chạy:

```cmd
mvnw.cmd spring-boot:run
```

Chờ đến khi Spring Boot khởi động thành công.

### Bước 5: Chạy giao diện

Mở phần giao diện của dự án và thực hiện chạy theo cấu hình thực tế của dự án. Nếu giao diện đã được tích hợp trong Spring Boot thì truy cập theo địa chỉ được cấu hình sau khi Backend khởi động.

### Bước 6: Kiểm tra chức năng

Mở Postman để gửi các yêu cầu đến API của hệ thống.

Kiểm tra kết quả trả về và đối chiếu với dữ liệu trong cơ sở dữ liệu để xác nhận các chức năng hoạt động đúng.

---

**Kết luận:** Bài LAB8 đã thực hiện phân tích nghiệp vụ, thiết kế hệ thống, xây dựng Backend bằng Java Spring Boot và giao diện cho hệ thống quản lý cho thuê văn phòng cao ốc. Các nội dung đã thực hiện là cơ sở để tiếp tục hoàn thiện những chức năng quản lý và vận hành hệ thống.