
-- 1. B?nh nhân
INSERT INTO BenhNhan
    (HoTen, DiaChi, NgaySinh, SoDienThoai, Anh3x4)
VALUES
    (N'Nguy?n V?n An', N'TP. H? Chí Minh', '2003-05-12', '0901234567', N'an.jpg'),
    (N'Tr?n Th? Bình', N'Bình D??ng', '2002-08-20', '0912345678', N'binh.jpg'),
    (N'Lê Minh Khang', N'??ng Nai', '2004-02-15', '0923456789', N'khang.jpg');
GO

-- 2. H? s? b?nh án
INSERT INTO HoSoBenhAn
    (MaBenhNhan, MaHoSoCode, NgayLap, NgayHetHanPhi, TrangThai)
VALUES
    (1, 'HS0001', '2026-01-10', '2027-01-09', N'?ang ho?t ??ng'),
    (2, 'HS0002', '2026-02-15', '2027-02-14', N'?ang ho?t ??ng'),
    (3, 'HS0003', '2026-03-20', '2027-03-19', N'?ang ho?t ??ng');
GO

-- 3. ??ng ký khám
INSERT INTO DangKyKham
    (MaBenhNhan, NgayDangKy, LyDoKham, TrangThai)
VALUES
    (1, '2026-10-10', N'?au ??u, chóng m?t', N'?ã ??ng ký'),
    (2, '2026-10-11', N'Khám s?c kh?e ??nh k?', N'?ã ??ng ký'),
    (3, '2026-10-12', N'S?t và m?t m?i', N'?ã ??ng ký');
GO

-- 4. Khoa
INSERT INTO Khoa (TenKhoa)
VALUES
    (N'Khoa N?i'),
    (N'Khoa Ngo?i'),
    (N'Khoa Xét nghi?m');
GO

-- 5. Bác s?
INSERT INTO BacSi (HoTen, SoDienThoai, MaKhoa)
VALUES
    (N'Nguy?n Hoàng Nam', '0934567890', 1),
    (N'Tr?n Minh Tu?n', '0945678901', 2),
    (N'Lê Thu Hà', '0956789012', 3);
GO

-- 6. Phi?u khám
INSERT INTO PhieuKham
    (MaHoSo, MaDangKy, MaBacSi, MaKhoa,
     NgayGioKham, TrieuChung, NhietDo, HuyetAp, KetLuan)
VALUES
    (1, 1, 1, 1, '2026-10-10T08:30:00',
     N'?au ??u, chóng m?t', 37.2, N'120/80', N'Theo dõi s?c kh?e'),

    (2, 2, 2, 2, '2026-10-11T09:00:00',
     N'Khám ??nh k?', 36.8, N'118/78', N'S?c kh?e ?n ??nh'),

    (3, 3, 1, 1, '2026-10-12T10:00:00',
     N'S?t, m?t m?i', 38.5, N'125/82', N'C?n xét nghi?m');
GO

-- 7. Yêu c?u xét nghi?m
INSERT INTO YeuCauXetNghiem
    (MaPhieuKham, LoaiXetNghiem, NgayChiDinh, TrangThai)
VALUES
    (1, N'Xét nghi?m máu', '2026-10-10', N'?ã hoàn thành'),
    (3, N'Xét nghi?m máu', '2026-10-12', N'?ã hoàn thành');
GO

-- 8. K?t qu? xét nghi?m
INSERT INTO KetQuaXetNghiem
    (MaYeuCau, NgayThucHien, KetQua, GhiChu)
VALUES
    (1, '2026-10-10',
     N'Các ch? s? trong gi?i h?n tham chi?u',
     N'Theo dõi thêm n?u còn tri?u ch?ng'),

    (2, '2026-10-12',
     N'Có ch? s? c?n bác s? ?ánh giá',
     N'?? ngh? tái khám theo h??ng d?n');
GO

-- 9. Danh m?c thu?c
INSERT INTO Thuoc (TenThuoc, DonViTinh, MoTa)
VALUES
    (N'Paracetamol', N'Viên', N'Thu?c gi?m ?au, h? s?t'),
    (N'Vitamin C', N'Viên', N'Vitamin b? sung'),
    (N'Oresol', N'Gói', N'Dung d?ch bù n??c và ?i?n gi?i');
GO

-- 10. Toa thu?c
INSERT INTO ToaThuoc (MaPhieuKham, NgayKeToa, LoiDan)
VALUES
    (1, '2026-10-10',
     N'S? d?ng thu?c theo h??ng d?n c?a bác s?'),

    (3, '2026-10-12',
     N'Ngh? ng?i, u?ng ?? n??c và theo dõi thân nhi?t');
GO

-- 11. Chi ti?t toa thu?c
INSERT INTO ChiTietToaThuoc
    (MaToaThuoc, MaThuoc, LieuLuong, CachDung, SoLuong, SoNgayDung)
VALUES
    (1, 1, N'500 mg', N'U?ng theo ch? ??nh c?a bác s?', 6, 3),
    (1, 2, N'500 mg', N'U?ng theo ch? ??nh c?a bác s?', 3, 3),
    (2, 1, N'500 mg', N'U?ng theo ch? ??nh c?a bác s?', 6, 3),
    (2, 3, N'1 gói', N'Pha và s? d?ng theo h??ng d?n', 3, 3);
GO

-- 12. Thanh toán
INSERT INTO ThanhToan
    (MaHoSo, MaPhieuKham, NgayThanhToan,
     SoTien, LoaiThanhToan, TrangThai)
VALUES
    (1, NULL, '2026-01-10', 200000,
     N'Phí qu?n lý h? s? n?m', N'?ã thanh toán'),

    (2, NULL, '2026-02-15', 200000,
     N'Phí qu?n lý h? s? n?m', N'?ã thanh toán'),

    (3, NULL, '2026-03-20', 200000,
     N'Phí qu?n lý h? s? n?m', N'?ã thanh toán'),

    (NULL, 1, '2026-10-10', 350000,
     N'Phí khám b?nh', N'?ã thanh toán'),

    (NULL, 3, '2026-10-12', 500000,
     N'Phí khám và xét nghi?m', N'?ã thanh toán');
GO
