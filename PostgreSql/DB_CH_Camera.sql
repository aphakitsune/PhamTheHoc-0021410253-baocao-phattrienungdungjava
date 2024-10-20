CREATE TABLE Quyen (
    ID_Q INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    PhanQuyen VARCHAR(10) NOT NULL,
    GhiChu VARCHAR(500),
    TrangThai VARCHAR(10) NOT NULL
);

CREATE TABLE Taikhoan(
    ID_TK INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    ID_Q INT,
    TaiKhoan_TK VARCHAR(50) NOT NULL,
    MatKhau_Tk VARCHAR(50) NOT NULL,
    NgayDK_TK DATE NOT NULL,
    FOREIGN KEY (ID_Q) REFERENCES Quyen(ID_Q)
);

CREATE TABLE KhachHang (
    ID_KH INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    ID_TK INT,
    AnhDaiDien_KH TEXT,
    HoVaTen_KH VARCHAR(50) NOT NULL,
    SDT_KH VARCHAR(20) NOT NULL,
    DC_KH VARCHAR(50) NOT NULL,
    Email_KH VARCHAR(50) NOT NULL,
    FOREIGN KEY (ID_TK) REFERENCES Taikhoan(ID_TK)
);

CREATE TABLE NhaCungCap(
    ID_NCC INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    Ten_NCC VARCHAR(50) NOT NULL,
    LoaiSP VARCHAR(50) NOT NULL,
    DiaChi_NCC VARCHAR(50) NOT NULL,
    Email_NCC VARCHAR(50) NOT NULL,
    SDT_NCC VARCHAR(20) NOT NULL
);

CREATE TABLE SANPHAM (
    ID_SP INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    HinhAnh TEXT NOT NULL,
    Ten_SP VARCHAR(50) NOT NULL,
    MauSac_SP VARCHAR(20) NOT NULL,
    Loai_SP VARCHAR(50) NOT NULL,
    ID_NCC INT,
    SoLuong_SP INT NOT NULL,
    GiaMD_SP NUMERIC(10,2) NOT NULL,
    GiaKM_SP NUMERIC(10,2) NOT NULL,
    HoanTra_SP VARCHAR(50) NOT NULL,
    DVVanChuyen_SP VARCHAR(50) NOT NULL,
    DanhGia_SP VARCHAR(500),
    MoTa_SP VARCHAR(500),
    FOREIGN KEY (ID_NCC) REFERENCES NhaCungCap(ID_NCC)
);

CREATE TABLE NhanVien(
    ID_NV INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    Ten_NV VARCHAR(50) NOT NULL,
    VaiTro_NV VARCHAR(50) NOT NULL,
    DiaChi_NV VARCHAR(50) NOT NULL,
    Email_NV VARCHAR(50) NOT NULL,
    SDT_NV VARCHAR(20) NOT NULL,
    NgayTuyenDung_NV DATE NOT NULL
);

CREATE TABLE DonHang (
    ID_DH INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    ID_KH INT,
    ID_SP INT,
    ID_NV INT,
    NgayDatHang_DH DATE NOT NULL,
    TongTien_DH NUMERIC(10,2),
    TrangThai_DH VARCHAR(50) NOT NULL,
    DiaChiNguoiNhan_DH VARCHAR(50) NOT NULL,
    NgayGiao_DH DATE NOT NULL,
    GhiChu_DH VARCHAR(500) NOT NULL,
    LuuYChoNguoiBan_DH VARCHAR(500) NOT NULL,
    FOREIGN KEY (ID_NV) REFERENCES NhanVien(ID_NV),
    FOREIGN KEY (ID_KH) REFERENCES KhachHang(ID_KH),
    FOREIGN KEY (ID_SP) REFERENCES SANPHAM(ID_SP)
);

CREATE TABLE CTDonHang(
    ID_CTDH INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    ID_DH INT,
    ID_SP INT,
    SoLuongMua_CTDH INT NOT NULL,
    GiaTriThuc_CTDH NUMERIC(10,2) NOT NULL,
    GiaDaGiam_CTDH NUMERIC(10,2) NOT NULL,
    TienGiaoHang_CTDH NUMERIC(10,2) NOT NULL,
    ThanhTien_CTDH NUMERIC(10,2) NOT NULL
);

-- Thêm dữ liệu vào bảng Quyen
INSERT INTO Quyen(PhanQuyen, GhiChu, TrangThai) VALUES
    ('ADMIN', 'Tài khoản admin', 'Active'), 
    ('USER', 'Tài khoản user', 'Active'),
    ('USER', 'Tài khoản user bị cấm do boom hàng', 'Inactive'),
    ('TEST', 'Tài khoản test', 'Active');

-- Thêm dữ liệu vào bảng TaiKhoan
INSERT INTO Taikhoan (ID_Q, TaiKhoan_TK, MatKhau_Tk, NgayDK_TK) VALUES 
(1, 'admin', 'admin123', '2023-01-01'),
(2, 'user1', 'user123', '2023-02-01'),
(2, 'user2', 'user123', '2023-03-01'),
(3, 'user3', 'user123', '2023-04-01'),
(4, 'tester1', 'tester1', '2023-05-01');

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (ID_TK, AnhDaiDien_KH, HoVaTen_KH, SDT_KH, DC_KH, Email_KH) VALUES 
(1, 'link_to_image1.jpg', 'Nguyễn Văn A', '123456789', 'Hà Nội', 'a@example.com'),
(2, 'link_to_image2.jpg', 'Lê Thị A', '987654321', 'PT Cao Lãnh', 'b@example.com'),
(3, 'link_to_image3.jpg', 'Huỳnh Văn A', '555666777', 'Đà Nẵng', 'c@example.com'),
(4, 'link_to_image4.jpg', 'Nguyễn Văn Boom hàng', '444333222', 'Hải Phòng', 'd@example.com'),
(5, 'link_to_image5.jpg', 'Phan Thị Tester', '888999000', 'Cần Thơ', 'e@example.com');

-- Thêm dữ liệu vào bảng NhaCungCap
INSERT INTO NhaCungCap (Ten_NCC, LoaiSP, DiaChi_NCC, Email_NCC, SDT_NCC) VALUES 
('NCC 1', 'Camera', 'Hà Nội', 'ncc1@example.com', '111222333'),
('NCC 2', 'Lens', 'Lạng Sơn', 'ncc2@example.com', '444555666'),
('NCC 3', 'Tripod', 'Đà Nẵng', 'ncc3@example.com', '777888999'),
('NCC 4', 'Lighting', 'Hải Phòng', 'ncc4@example.com', '999000111'),
('NCC 5', 'Microphone', 'Cần Thơ', 'ncc5@example.com', '222333444');

-- Thêm dữ liệu vào bảng SanPham
INSERT INTO SANPHAM (HinhAnh, Ten_SP, MauSac_SP, Loai_SP, ID_NCC, SoLuong_SP, GiaMD_SP, GiaKM_SP, HoanTra_SP, DVVanChuyen_SP, DanhGia_SP) VALUES 
('image1.jpg', 'Camera A', 'Đen', 'Camera', 1, 10, 5000000.00, 4500000.00, '30 ngày', 'Giao nhanh', ''),
('image2.jpg', 'Lens B', 'Trắng', 'Lens', 2, 20, 2000000.00, 1800000.00, '15 ngày', 'Giao tiêu chuẩn', ''),
('image3.jpg', 'Tripod C', 'Đỏ', 'Tripod', 3, 30, 1500000.00, 1400000.00, '20 ngày', 'Giao nhanh', ''),
('image4.jpg', 'Lighting D', 'Xanh', 'Lighting', 4, 15, 2500000.00, 2300000.00, '10 ngày', 'Giao tiêu chuẩn', ''),
('image5.jpg', 'Microphone E', 'Vàng', 'Microphone', 5, 5, 1000000.00, 950000.00, '25 ngày', 'Giao nhanh', '');

-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (Ten_NV, VaiTro_NV, DiaChi_NV, Email_NV, SDT_NV, NgayTuyenDung_NV) VALUES 
('Nguyễn Văn X', 'Quản lý', 'Hà Nội', 'x@example.com', '0123456789', '2022-01-01'),
('Trần Thị Y', 'Nhân viên bán hàng', 'HCM', 'y@example.com', '0987654321', '2022-02-01'),
('Lê Văn Z', 'Kỹ thuật', 'Đà Nẵng', 'z@example.com', '0765432198', '2022-03-01'),
('Nguyễn Thị W', 'Marketing', 'Hải Phòng', 'w@example.com', '0654321876', '2022-04-01'),
('Trần Văn V', 'Hỗ trợ khách hàng', 'Cần Thơ', 'v@example.com', '0543210987', '2022-05-01');

-- Thêm dữ liệu vào bảng DonHang
INSERT INTO DonHang (ID_KH, ID_SP, ID_NV, NgayDatHang_DH, TongTien_DH, TrangThai_DH, DiaChiNguoiNhan_DH, NgayGiao_DH, GhiChu_DH, LuuYChoNguoiBan_DH) VALUES 
(1, 1, 1, '2023-10-01', 4500000.00, 'Đang giao', 'Hà Nội', '2023-10-05', 'Ghi chú về đơn hàng 1', 'Lưu ý cho người bán 1'),
(2, 2, 2, '2023-10-02', 1800000.00, 'Đã giao', 'PT Cao Lãnh', '2023-10-06', 'Ghi chú về đơn hàng 2', 'Lưu ý cho người bán 2'),
(3, 3, 3, '2023-10-03', 1400000.00, 'Đang giao', 'Đà Nẵng', '2023-10-07', 'Ghi chú về đơn hàng 3', 'Lưu ý cho người bán 3'),
(4, 4, 4, '2023-10-04', 2300000.00, 'Đang chờ', 'Hải Phòng', '2023-10-08', 'Ghi chú về đơn hàng 4', 'Lưu ý cho người bán 4'),
(5, 5, 5, '2023-10-05', 950000.00, 'Đã giao', 'Cần Thơ', '2023-10-09', 'Ghi chú về đơn hàng 5', 'Lưu ý cho người bán 5');

-- Thêm dữ liệu vào bảng CTDonHang
INSERT INTO CTDonHang (ID_DH, ID_SP, SoLuongMua_CTDH, GiaTriThuc_CTDH, GiaDaGiam_CTDH, TienGiaoHang_CTDH, ThanhTien_CTDH) VALUES 
(1, 1, 1, 4500000.00, 4500000.00, 0.00, 4500000.00),
(2, 2, 1, 1800000.00, 1800000.00, 0.00, 1800000.00),
(3, 3, 2, 2800000.00, 2600000.00, 200000.00, 2800000.00),
(4, 4, 1, 2300000.00, 2300000.00, 0.00, 2300000.00),
(5, 5, 1, 950000.00, 950000.00, 0.00, 950000.00);

