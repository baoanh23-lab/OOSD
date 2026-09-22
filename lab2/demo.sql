

-- 2. Xóa b?ng c? n?u ?ã t?n t?i (theo th? t? ph? thu?c khóa ngo?i)
IF OBJECT_ID('dbo.PhieuPhat', 'U') IS NOT NULL DROP TABLE dbo.PhieuPhat;
IF OBJECT_ID('dbo.ChiTietPhieuMuon', 'U') IS NOT NULL DROP TABLE dbo.ChiTietPhieuMuon;
IF OBJECT_ID('dbo.PhieuMuon', 'U') IS NOT NULL DROP TABLE dbo.PhieuMuon;
IF OBJECT_ID('dbo.TheDocGia', 'U') IS NOT NULL DROP TABLE dbo.TheDocGia;
IF OBJECT_ID('dbo.DocGia', 'U') IS NOT NULL DROP TABLE dbo.DocGia;
IF OBJECT_ID('dbo.DauSach', 'U') IS NOT NULL DROP TABLE dbo.DauSach;
IF OBJECT_ID('dbo.NhaXuatBan', 'U') IS NOT NULL DROP TABLE dbo.NhaXuatBan;
IF OBJECT_ID('dbo.TheLoai', 'U') IS NOT NULL DROP TABLE dbo.TheLoai;
IF OBJECT_ID('dbo.NhanVien', 'U') IS NOT NULL DROP TABLE dbo.NhanVien;
GO

-- 3. B?ng Nhân viên
CREATE TABLE dbo.NhanVien (
    MaNhanVien NVARCHAR(20) NOT NULL PRIMARY KEY,
    Ho NVARCHAR(50) NOT NULL,
    Ten NVARCHAR(50) NOT NULL,
    Phai NVARCHAR(10) NOT NULL,
    NgaySinh DATE NOT NULL,
    ChucVu NVARCHAR(80) NOT NULL,
    SoDienThoai NVARCHAR(20) NULL
);

-- 4. B?ng Th? lo?i
CREATE TABLE dbo.TheLoai (
    MaTheLoai NVARCHAR(20) NOT NULL PRIMARY KEY,
    TenTheLoai NVARCHAR(100) NOT NULL UNIQUE
);

-- 5. B?ng Nhà xu?t b?n
CREATE TABLE dbo.NhaXuatBan (
    MaNhaXuatBan NVARCHAR(20) NOT NULL PRIMARY KEY,
    DiaChi NVARCHAR(200) NULL,
    SoDienThoai NVARCHAR(20) NULL
);

-- 6. B?ng ??u sách (BR12, BR13: 1 ??u sách thu?c 1 th? lo?i, 1 NXB)
CREATE TABLE dbo.DauSach (
    MaDauSach NVARCHAR(20) NOT NULL PRIMARY KEY,
    TenSach NVARCHAR(200) NOT NULL,
    NamXuatBan INT NOT NULL,
    SoLuongHienCo INT NOT NULL CONSTRAINT CK_DauSach_SoLuong CHECK (SoLuongHienCo >= 0),
    MaTheLoai NVARCHAR(20) NOT NULL,
    MaNhaXuatBan NVARCHAR(20) NOT NULL,
    CONSTRAINT FK_DauSach_TheLoai FOREIGN KEY (MaTheLoai) REFERENCES dbo.TheLoai(MaTheLoai),
    CONSTRAINT FK_DauSach_NhaXuatBan FOREIGN KEY (MaNhaXuatBan) REFERENCES dbo.NhaXuatBan(MaNhaXuatBan)
);

-- 7. B?ng ??c gi?
CREATE TABLE dbo.DocGia (
    MaDocGia NVARCHAR(20) NOT NULL PRIMARY KEY,
    HoTen NVARCHAR(100) NOT NULL,
    NgaySinh DATE NOT NULL,
    Phai NVARCHAR(10) NOT NULL,
    SoDienThoai NVARCHAR(20) NULL,
    DiaChi NVARCHAR(200) NULL,
    Email NVARCHAR(100) NULL,
    AnhDaiDien NVARCHAR(255) NULL
);

-- 8. B?ng Th? ??c gi? (BR02, BR03)
CREATE TABLE dbo.TheDocGia (
    MaThe NVARCHAR(20) NOT NULL PRIMARY KEY,
    MaDocGia NVARCHAR(20) NOT NULL,
    NgayCap DATE NOT NULL,
    HanSuDung DATE NOT NULL,
    DaDongLePhi BIT NOT NULL DEFAULT 0,
    TrangThai BIT NOT NULL DEFAULT 1, -- 1: ?ang ho?t ??ng, 0: H?t hi?u l?c
    CONSTRAINT FK_TheDocGia_DocGia FOREIGN KEY (MaDocGia) REFERENCES dbo.DocGia(MaDocGia),
    CONSTRAINT CK_TheDocGia_HanSuDung CHECK (HanSuDung >= NgayCap)
);
-- Ràng bu?c BR02: T?i m?t th?i ?i?m m?i ??c gi? ch? có t?i ?a 1 th? ?ang ho?t ??ng (TrangThai = 1)
CREATE UNIQUE INDEX UIX_TheDocGia_DocGia_HoatDong 
ON dbo.TheDocGia(MaDocGia) 
WHERE TrangThai = 1;

-- 9. B?ng Phi?u m??n (BR01, BR08)
CREATE TABLE dbo.PhieuMuon (
    MaPhieuMuon NVARCHAR(20) NOT NULL PRIMARY KEY,
    MaDocGia NVARCHAR(20) NOT NULL,
    MaNhanVien NVARCHAR(20) NOT NULL,
    NgayMuon DATE NOT NULL DEFAULT GETDATE(),
    NgayHenTra DATE NOT NULL,
    TrangThai NVARCHAR(50) NOT NULL DEFAULT N'?ang m??n', -- N'?ang m??n', N'?ã tr?', N'Quá h?n'
    CONSTRAINT FK_PhieuMuon_DocGia FOREIGN KEY (MaDocGia) REFERENCES dbo.DocGia(MaDocGia),
    CONSTRAINT FK_PhieuMuon_NhanVien FOREIGN KEY (MaNhanVien) REFERENCES dbo.NhanVien(MaNhanVien),
    CONSTRAINT CK_PhieuMuon_NgayHenTra CHECK (NgayHenTra >= NgayMuon)
);

-- 10. B?ng Chi ti?t phi?u m??n (BR06)
CREATE TABLE dbo.ChiTietPhieuMuon (
    MaChiTiet NVARCHAR(20) NOT NULL PRIMARY KEY,
    MaPhieuMuon NVARCHAR(20) NOT NULL,
    MaDauSach NVARCHAR(20) NOT NULL,
    NgayTraThucTe DATE NULL,
    TinhTrangTra NVARCHAR(100) NULL, -- N'Bình th??ng', N'M?t', N'Rách/H? h?ng'
    CONSTRAINT FK_CTPM_PhieuMuon FOREIGN KEY (MaPhieuMuon) REFERENCES dbo.PhieuMuon(MaPhieuMuon),
    CONSTRAINT FK_CTPM_DauSach FOREIGN KEY (MaDauSach) REFERENCES dbo.DauSach(MaDauSach),
    -- Ràng bu?c BR06: Trong m?t phi?u m??n không ???c trùng ??u sách
    CONSTRAINT UQ_PhieuMuon_DauSach UNIQUE (MaPhieuMuon, MaDauSach)
);

-- 11. B?ng Phi?u ph?t (BR09, BR10)
CREATE TABLE dbo.PhieuPhat (
    MaPhieuPhat NVARCHAR(20) NOT NULL PRIMARY KEY,
    MaChiTiet NVARCHAR(20) NOT NULL,
    MaNhanVien NVARCHAR(20) NOT NULL,
    NgayPhat DATE NOT NULL DEFAULT GETDATE(),
    LyDoPhat NVARCHAR(200) NOT NULL,
    PhiPhat DECIMAL(18, 2) NOT NULL CONSTRAINT CK_PhieuPhat_PhiPhat CHECK (PhiPhat >= 0),
    CONSTRAINT FK_PhieuPhat_ChiTietPhieuMuon FOREIGN KEY (MaChiTiet) REFERENCES dbo.ChiTietPhieuMuon(MaChiTiet),
    CONSTRAINT FK_PhieuPhat_NhanVien FOREIGN KEY (MaNhanVien) REFERENCES dbo.NhanVien(MaNhanVien)
);
GO
