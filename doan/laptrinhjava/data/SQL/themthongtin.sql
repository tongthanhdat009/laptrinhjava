USE [main]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[SoLuongHang] [int] NULL,
	[MaHD] [char](5) NULL,
	[MaHH] [char](5) NULL,
	[Gia] [int] NULL,
	[MaCoSo] [char](5) NULL,
	[TrangThai] [nchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhap](
	[MaPhieuNhap] [char](5) NULL,
	[MaHangHoa] [char](5) NULL,
	[SoLuong] [int] NULL,
	[GiaNhap] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucNang]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucNang](
	[IDChucNang] [char](5) NOT NULL,
	[TenChucNang] [nchar](40) NULL,
 CONSTRAINT [PK_ChucNang] PRIMARY KEY CLUSTERED 
(
	[IDChucNang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CoSo]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CoSo](
	[MaCoSo] [char](5) NOT NULL,
	[TenCoSo] [nvarchar](20) NOT NULL,
	[DiaChi] [nvarchar](40) NULL,
	[ThoiGianHoatDong] [nvarchar](30) NULL,
	[SoDienThoai] [char](10) NULL,
	[DoanhThu] [numeric](18, 0) NOT NULL,
 CONSTRAINT [PK_CoSo] PRIMARY KEY CLUSTERED 
(
	[MaCoSo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDV] [char](5) NOT NULL,
	[TenDV] [nchar](30) NULL,
	[GiaDV] [numeric](18, 0) NULL,
	[ThoiGian] [int] NULL,
	[MoTa] [nvarchar](300) NULL,
	[HinhAnh] [char](200) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHang]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHang](
	[IDTaiKhoan] [char](5) NOT NULL,
	[MaHangHoa] [char](5) NOT NULL,
	[SoLuongHangHoa] [int] NULL,
	[MaCoSo] [char](5) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HangHoa]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangHoa](
	[MaHangHoa] [char](5) NOT NULL,
	[Loai] [nvarchar](20) NULL,
	[TenLoaiHangHoa] [nvarchar](50) NULL,
	[HinhAnh] [char](100) NULL,
 CONSTRAINT [PK_HangHoa] PRIMARY KEY CLUSTERED 
(
	[MaHangHoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HangHoaOCoSo]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangHoaOCoSo](
	[MaCoSo] [char](5) NOT NULL,
	[MaHangHoa] [char](5) NOT NULL,
	[TrangThai] [nchar](20) NULL,
	[SoLuong] [int] NULL,
	[GiaBan] [int] NULL,
 CONSTRAINT [PK_HangHoaOCoSo] PRIMARY KEY CLUSTERED 
(
	[MaCoSo] ASC,
	[MaHangHoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [char](5) NOT NULL,
	[NgayXuatHD] [date] NULL,
	[IDTaiKhoan] [char](5) NULL,
 CONSTRAINT [PK_HoaDon_1] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoiVien]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoiVien](
	[MaHV] [char](5) NOT NULL,
	[HoTenHV] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](3) NULL,
	[Gmail] [char](500) NULL,
	[NgaySinh] [date] NULL,
	[SoDienThoai] [char](10) NULL,
	[IDTaiKhoan] [char](5) NULL,
	[Anh] [nvarchar](50) NULL,
 CONSTRAINT [PK_HoiVien] PRIMARY KEY CLUSTERED 
(
	[MaHV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MayChay]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MayChay](
	[CongSuat] [decimal](6, 2) NULL,
	[TocDoToiDa] [decimal](6, 2) NULL,
	[NhaSanXuat] [nvarchar](50) NULL,
	[KichThuoc] [nvarchar](20) NULL,
	[MaHangHoa] [char](5) NOT NULL,
 CONSTRAINT [PK_MayChay] PRIMARY KEY CLUSTERED 
(
	[MaHangHoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [char](5) NOT NULL,
	[HoTenNV] [nchar](50) NULL,
	[GioiTinh] [nchar](3) NULL,
	[NgaySinh] [date] NULL,
	[SoDienThoai] [char](10) NULL,
	[SoCCCD] [char](12) NULL,
	[MaCoSo] [char](5) NULL,
	[VaiTro] [nchar](30) NULL,
	[Luong] [numeric](18, 0) NULL,
	[IDTaiKhoan] [char](5) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanQuyen]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanQuyen](
	[IDChucNang] [char](5) NOT NULL,
	[IDQuyen] [char](5) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPhieuNhap] [char](5) NOT NULL,
	[TrangThai] [nchar](20) NULL,
	[MaNV] [char](5) NULL,
	[NgayNhap] [date] NULL,
 CONSTRAINT [PK_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[MaPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quyen](
	[IDQuyen] [char](5) NOT NULL,
	[TenQuyen] [nchar](30) NULL,
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[IDQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ta]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ta](
	[MaHangHoa] [char](5) NOT NULL,
	[KhoiLuong] [int] NULL,
	[ChatLieu] [nvarchar](50) NULL,
	[MauSac] [nvarchar](50) NULL,
 CONSTRAINT [PK_Ta] PRIMARY KEY CLUSTERED 
(
	[MaHangHoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[IDTaiKhoan] [char](5) NOT NULL,
	[TaiKhoan] [char](20) NULL,
	[MatKhau] [char](20) NULL,
	[IDQuyen] [char](5) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[IDTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Xa]    Script Date: 9/23/2024 7:52:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Xa](
	[LoaiXa] [nvarchar](20) NULL,
	[ChatLieu] [nvarchar](20) NULL,
	[ChieuDai] [decimal](5, 2) NULL,
	[DuongKinh] [decimal](5, 2) NULL,
	[ChieuCao] [decimal](5, 2) NULL,
	[TaiTrong] [decimal](7, 2) NULL,
	[MaHangHoa] [char](5) NOT NULL,
 CONSTRAINT [PK_Xa] PRIMARY KEY CLUSTERED 
(
	[MaHangHoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHoaDon] ([SoLuongHang], [MaHD], [MaHH], [Gia], [MaCoSo], [TrangThai]) VALUES (30, N'HD1  ', N'HH003', 165000000, N'CS001', N'Đã duyệt            ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuongHang], [MaHD], [MaHH], [Gia], [MaCoSo], [TrangThai]) VALUES (5, N'HD2  ', N'HH012', 1100000, N'CS003', N'Chưa duyệt          ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuongHang], [MaHD], [MaHH], [Gia], [MaCoSo], [TrangThai]) VALUES (20, N'HD2  ', N'HH015', 44000000, N'CS003', N'Chưa duyệt          ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuongHang], [MaHD], [MaHH], [Gia], [MaCoSo], [TrangThai]) VALUES (5, N'HD2  ', N'HH009', 13750300, N'CS001', N'Đã duyệt            ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuongHang], [MaHD], [MaHH], [Gia], [MaCoSo], [TrangThai]) VALUES (5, N'HD3  ', N'HH012', 1100000, N'CS003', N'Đã duyệt            ')
INSERT [dbo].[ChiTietHoaDon] ([SoLuongHang], [MaHD], [MaHH], [Gia], [MaCoSo], [TrangThai]) VALUES (5, N'HD3  ', N'HH001', 6187500, N'CS001', N'Đã duyệt            ')
GO
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN001', N'HH003', 30, 5000000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN001', N'HH007', 25, 2000000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN003', N'HH001', 20, 2000000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN003', N'HH009', 15, 2500055)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN004', N'HH012', 10, 200000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN005', N'HH002', 1, 20000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN001', N'HH001', 10, 250000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN003', N'HH010', 10, 2000000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN004', N'HH015', 100, 2000000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN006', N'HH001', 1, 20000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN007', N'HH002', 1, 20000)
INSERT [dbo].[ChiTietPhieuNhap] ([MaPhieuNhap], [MaHangHoa], [SoLuong], [GiaNhap]) VALUES (N'PN008', N'HH016', 200, 2000000)
GO
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN001', N'Quản lý danh sách                       ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN002', N'Duyệt đơn hàng                          ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN003', N'Xuất file danh sách                     ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN004', N'Nhập hàng                               ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN005', N'Quản lý nhân viên                       ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN006', N'Quản lý hội viên                        ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN007', N'Quản lý hàng hóa                        ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN008', N'Duyệt phiếu nhập                        ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN009', N'Mua hàng                                ')
INSERT [dbo].[ChucNang] ([IDChucNang], [TenChucNang]) VALUES (N'CN010', N'Thông tin cá nhân                       ')
GO
INSERT [dbo].[CoSo] ([MaCoSo], [TenCoSo], [DiaChi], [ThoiGianHoatDong], [SoDienThoai], [DoanhThu]) VALUES (N'CS001', N'GYM SGU 1', N'Thành Phố Hồ Chí Minh', N'6:00 - 24:00 hàng ngày', N'0123456789', CAST(49778224 AS Numeric(18, 0)))
INSERT [dbo].[CoSo] ([MaCoSo], [TenCoSo], [DiaChi], [ThoiGianHoatDong], [SoDienThoai], [DoanhThu]) VALUES (N'CS002', N'GYM SGU 2', N'Thành Phố Đà Nẵng', N'6:00 - 24:00 hàng ngày', N'0123456789', CAST(25243400 AS Numeric(18, 0)))
INSERT [dbo].[CoSo] ([MaCoSo], [TenCoSo], [DiaChi], [ThoiGianHoatDong], [SoDienThoai], [DoanhThu]) VALUES (N'CS003', N'GYM SGU 3', N'Thủ Đô Hà Nội', N'6:00 - 24:00 hàng ngày', N'0123456789', CAST(24219619 AS Numeric(18, 0)))
GO
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [GiaDV], [ThoiGian], [MoTa], [HinhAnh]) VALUES (N'DV001', N'Thiết bị luyện tập            ', CAST(300000 AS Numeric(18, 0)), 30, N'Bao gồm máy chạy bộ, máy đạp xe, máy leo dốc, máy tập cơ, và các thiết bị tập luyện khác để phát triển sức mạnh, sức bền và linh hoạt.', N'src/asset/img/dichvu/DV001.png                                                                                                                                                                          ')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [GiaDV], [ThoiGian], [MoTa], [HinhAnh]) VALUES (N'DV002', N'Khu vực thể dục ngoài trời    ', CAST(350000 AS Numeric(18, 0)), 30, N'Bao gồm máy chạy bộ ngoài trời, máy đạp xe ngoài trời, yoga và pilates, cardio,...', N'src/asset/img/dichvu/DV002.png                                                                                                                                                                          ')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [GiaDV], [ThoiGian], [MoTa], [HinhAnh]) VALUES (N'DV003', N'Bơi lội                       ', CAST(250000 AS Numeric(18, 0)), 30, N'Bao gồm cung cấp khăn tắm, xà phồng và các dịch vụ khác trong hồ bơi', N'src/asset/img/dichvu/DV003.png                                                                                                                                                                          ')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [GiaDV], [ThoiGian], [MoTa], [HinhAnh]) VALUES (N'DV004', N'Dịch vụ khác                  ', CAST(200000 AS Numeric(18, 0)), 30, N'Bao gồm tư vấn dinh dưỡng, hướng dẫn tập luyện các nhân,...', N'src/asset/img/dichvu/DV004.png                                                                                                                                                                          ')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [GiaDV], [ThoiGian], [MoTa], [HinhAnh]) VALUES (N'DV005', N'Spa và Massage                ', CAST(30 AS Numeric(18, 0)), 30, N'Bao gồm massage, xông hơi, và jacuzzi để giúp khách hàng thư giãn và phục hồi sau khi tập luyện,...', N'src/asset/img/dichvu/DV005.png                                                                                                                                                                          ')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [GiaDV], [ThoiGian], [MoTa], [HinhAnh]) VALUES (N'DV006', N'Spa và Massage                ', CAST(300000 AS Numeric(18, 0)), 30, N'Bao gồm massage, xông hơi, và jacuzzi để giúp khách hàng thư giãn và phục hồi sau khi tập luyện,...', N'src/asset/img/dichvu/DV005.png                                                                                                                                                                          ')
GO
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH001', N'Tạ', N'Tạ 5kg', N'src/asset/img/hanghoa/HH003.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH002', N'Tạ', N'Tạ 10kg', N'src/asset/img/hanghoa/HH004.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH003', N'Tạ', N'Tạ 15kg', N'src/asset/img/hanghoa/HH005.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH004', N'Tạ', N'Tạ 20kg', N'src/asset/img/hanghoa/HH006.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH005', N'Tạ', N'Tạ 25kg', N'src/asset/img/hanghoa/HH007.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH006', N'Tạ', N'Tạ 1kg', N'src/asset/img/hanghoa/HH008.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH007', N'Máy chạy', N'Máy chạy', N'src/asset/img/hanghoa/HH015.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH008', N'Máy chạy', N'Máy chạy bộ', N'src/asset/img/hanghoa/HH016.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH009', N'Xà', N'Xà đơn gắn tường', N'src/asset/img/hanghoa/HH001.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH010', N'Xà', N'Xà đơn gắn tường 2015', N'src/asset/img/hanghoa/HH095.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH011', N'Khác', N'Băng cổ chân thể thao Pseudois', N'src/asset/img/hanghoa/HH090.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH012', N'Khác', N'Đai quấn gối hỗ trợ AOLIKES A-1516', N'src/asset/img/hanghoa/HH091.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH013', N'Khác', N'Dây kéo tay lò xo đa năng K1016', N'src/asset/img/hanghoa/HH093.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH014', N'Khác', N'Ghế Tập Tạ Zasami SVT-8310', N'src/asset/img/hanghoa/HH096.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH015', N'Khác', N'Ghế cong tập bụng Zasami SGC-8511', N'src/asset/img/hanghoa/HH096.jpg                                                                     ')
INSERT [dbo].[HangHoa] ([MaHangHoa], [Loai], [TenLoaiHangHoa], [HinhAnh]) VALUES (N'HH016', N'Tạ', N'Tạ đòn', N'src/asset/img/hanghoa/HH032.jpg                                                                     ')
GO
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS001', N'HH001', N'Đang bán            ', 25, 1237500)
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS001', N'HH002', N'Khóa                ', 1, 22000)
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS001', N'HH003', N'Đang bán            ', 0, 5500000)
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS001', N'HH007', N'Đang bán            ', 25, 2200000)
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS001', N'HH009', N'Đang bán            ', 10, 2750060)
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS001', N'HH010', N'Đang bán            ', 10, 2200000)
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS001', N'HH016', N'Đang bán            ', 200, 2200000)
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS003', N'HH012', N'Đang bán            ', 0, 220000)
INSERT [dbo].[HangHoaOCoSo] ([MaCoSo], [MaHangHoa], [TrangThai], [SoLuong], [GiaBan]) VALUES (N'CS003', N'HH015', N'Đang bán            ', 80, 2200000)
GO
INSERT [dbo].[HoaDon] ([MaHD], [NgayXuatHD], [IDTaiKhoan]) VALUES (N'HD1  ', CAST(N'2024-09-22' AS Date), N'TK002')
INSERT [dbo].[HoaDon] ([MaHD], [NgayXuatHD], [IDTaiKhoan]) VALUES (N'HD2  ', CAST(N'2024-09-22' AS Date), N'TK002')
INSERT [dbo].[HoaDon] ([MaHD], [NgayXuatHD], [IDTaiKhoan]) VALUES (N'HD3  ', CAST(N'2024-09-22' AS Date), N'TK084')
GO
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV001', N'Trịnh Trần Phương Tuấn', N'Nam', N'HV001@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1997-04-12' AS Date), N'0395632027', N'TK001', N'src\asset\img\avatar\jack_3.jpg')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV002', N'Trần Thị Bàng', N'Nữ', N'HV002@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1995-05-10' AS Date), N'0987654321', N'TK002', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV003', N'Lê Đình Huy', N'Nam', N'HV003@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1988-03-15' AS Date), N'0456789123', N'TK003', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV004', N'Phạm Thị Duyên', N'Nữ', N'HV004@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1992-11-20' AS Date), N'0654321987', N'TK004', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV005', N'Hoàng Văn Thắng', N'Nam', N'HV005@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1987-09-25' AS Date), N'0789456123', N'TK005', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV006', N'Mai Thị Bánh', N'Nữ', N'HV006@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1998-07-30' AS Date), N'0321654987', N'TK006', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV007', N'Vũ Đức Khang', N'Nam', N'HV007@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1984-04-09' AS Date), N'0395632027', N'TK007', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV008', N'Trần Văn Hào', N'Nam', N'HV008@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1989-02-12' AS Date), N'0369852147', N'TK008', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV009', N'Nguyễn Thị Nô', N'Nữ', N'HV009@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1994-06-18' AS Date), N'0852741963', N'TK009', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV010', N'Lê Văn Kiến Vinh', N'Nam', N'HV010@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1993-08-22' AS Date), N'0741852963', N'TK010', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV011', N'Trần Thanh Phúc', N'Nam', N'HV011@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1986-12-28' AS Date), N'0951753852', N'TK011', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV012', N'Hoàng Thị Duy', N'Nữ', N'HV012@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1997-10-15' AS Date), N'0258369147', N'TK012', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV013', N'Phạm Văn Lâm', N'Nam', N'HV013@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1996-02-09' AS Date), N'0147258369', N'TK013', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV014', N'Mai Thanh Kiên', N'Nam', N'HV014@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1985-05-03' AS Date), N'0369147258', N'TK014', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV015', N'Nguyễn Thị Phát', N'Nữ', N'HV015@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1999-11-08' AS Date), N'0852963147', N'TK015', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV016', N'Lê Văn Quang', N'Nam', N'HV016@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1990-07-12' AS Date), N'0963852741', N'TK016', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV017', N'Trần Thị Rành', N'Nữ', N'HV017@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1995-03-20' AS Date), N'0753951852', N'TK017', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV018', N'Hoàng Văn Sao', N'Nam', N'HV018@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1988-09-18' AS Date), N'0852369147', N'TK018', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV019', N'Phạm Thị Tồng', N'Nữ', N'HV019@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1992-01-25' AS Date), N'0369852147', N'TK019', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV020', N'Nguyễn Văn Un', N'Nam', N'HV020@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1991-06-03' AS Date), N'0147852369', N'TK020', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV021', N'Mai Thị Vinh', N'Nữ', N'HV021@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1989-04-28' AS Date), N'0369147852', N'TK021', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV022', N'Trần Văn Xầu', N'Nam', N'HV022@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1994-12-05' AS Date), N'0852963741', N'TK022', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV023', N'Lê Thị Mỹ', N'Nữ', N'HV023@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1993-02-17' AS Date), N'0753951852', N'TK023', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV024', N'Hoàng Văn Trương', N'Nam', N'HV024@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1996-08-30' AS Date), N'0963852741', N'TK024', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV025', N'Nguyễn Văn Tèo', N'Nam', N'HV025@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1995-10-28' AS Date), N'0123456789', N'TK025', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV026', N'Trần Thị Mai', N'Nữ', N'HV026@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1994-09-15' AS Date), N'0987654321', N'TK026', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV027', N'Lê Văn Đôi', N'Nam', N'HV027@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1993-07-22' AS Date), N'0456789123', N'TK027', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV028', N'Phạm Thị Đan', N'Nữ', N'HV028@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1992-04-05' AS Date), N'0654321987', N'TK028', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV029', N'Mai Thanh Hoàng', N'Nam', N'HV029@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1991-01-18' AS Date), N'0789456123', N'TK029', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV030', N'Vũ Đình Đại', N'Nam', N'HV030@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1990-11-10' AS Date), N'0321654987', N'TK030', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV031', N'Trần Thị Mai', N'Nữ', N'HV031@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1989-08-22' AS Date), N'0159487263', N'TK031', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV032', N'Lê Văn Tám', N'Nam', N'HV032@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1988-05-03' AS Date), N'0369852147', N'TK032', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV033', N'Nguyễn Thị Bảy', N'Nữ', N'HV033@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1987-02-15' AS Date), N'0852741963', N'TK033', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV034', N'Phạm Văn Sáu', N'Nam', N'HV034@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1996-12-08' AS Date), N'0147258369', N'TK034', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV035', N'Mai Thị Năm', N'Nữ', N'HV035@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1995-10-30' AS Date), N'0369147258', N'TK035', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV036', N'Trần Văn Bốn', N'Nam', N'HV036@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1994-09-18' AS Date), N'0951753852', N'TK036', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV037', N'Hoàng Thị Là', N'Nữ', N'HV037@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1993-07-25' AS Date), N'0258369147', N'TK037', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV038', N'Phạm Văn Đồng', N'Nam', N'HV038@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1992-04-08' AS Date), N'0741852963', N'TK038', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV039', N'Mai Quốc Khánh', N'Nam', N'HV039@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1991-01-20' AS Date), N'0963852741', N'TK039', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV040', N'Nguyễn Thị Thập', N'Nữ', N'HV040@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1990-11-05' AS Date), N'0852963147', N'TK040', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV041', N'Trần Văn Cường', N'Nam', N'HV041@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1989-08-18' AS Date), N'0147852369', N'TK041', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV042', N'Lê Thị Định', N'Nữ', N'HV042@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1988-06-23' AS Date), N'0369147852', N'TK042', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV043', N'Hoàng Văn Thụ', N'Nam', N'HV043@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1987-03-30' AS Date), N'0852963741', N'TK043', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV044', N'Phạm Thị Thanh', N'Nữ', N'HV044@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1986-12-15' AS Date), N'0963852741', N'TK044', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV045', N'Mai Thị Nở', N'Nữ', N'HV045@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1985-09-10' AS Date), N'0852369147', N'TK045', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV046', N'Nguyễn Văn Hai', N'Nam', N'HV046@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', CAST(N'1984-06-25' AS Date), N'0741852963', N'TK046', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV047', N'Tống Thành Đạt', N'Nam', N'gamingthanhdat@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ', CAST(N'2004-05-14' AS Date), N'0395632027', N'TK047', N'src/asset/img/avatar/user.png')
INSERT [dbo].[HoiVien] ([MaHV], [HoTenHV], [GioiTinh], [Gmail], [NgaySinh], [SoDienThoai], [IDTaiKhoan], [Anh]) VALUES (N'HV048', N'Hội Viên', N'Nam', N'a@gmail.com                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ', CAST(N'2004-05-03' AS Date), N'0395632027', N'TK084', N'src\asset\img\avatar\large_1588936738888_1.jpg')
GO
INSERT [dbo].[MayChay] ([CongSuat], [TocDoToiDa], [NhaSanXuat], [KichThuoc], [MaHangHoa]) VALUES (CAST(1000.00 AS Decimal(6, 2)), CAST(15.00 AS Decimal(6, 2)), N'LifeSport', N'200x90', N'HH007')
INSERT [dbo].[MayChay] ([CongSuat], [TocDoToiDa], [NhaSanXuat], [KichThuoc], [MaHangHoa]) VALUES (CAST(1500.00 AS Decimal(6, 2)), CAST(15.00 AS Decimal(6, 2)), N'LifeSport', N'200x90', N'HH008')
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV001', N'Nguyễn Văn An                                     ', N'Nam', CAST(N'1990-01-31' AS Date), N'0123456789', N'123222456789', N'CS001', N'Nhân viên                     ', CAST(15000000 AS Numeric(18, 0)), N'TK048')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV002', N'Trần Thị Bảo                                      ', N'Nữ ', CAST(N'1995-02-15' AS Date), N'0987654321', N'987654321231', N'CS001', N'Nhân viên                     ', CAST(14000000 AS Numeric(18, 0)), N'TK049')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV003', N'Phạm Văn Chí                                      ', N'Nam', CAST(N'1987-05-20' AS Date), N'0369852147', N'654782219321', N'CS002', N'Nhân viên                     ', CAST(16000000 AS Numeric(18, 0)), N'TK050')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV004', N'Lê Thị Dung                                       ', N'Nữ ', CAST(N'1988-10-10' AS Date), N'0123456789', N'987654225321', N'CS002', N'Nhân viên                     ', CAST(14500000 AS Numeric(18, 0)), N'TK051')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV005', N'Hoàng Văn Em                                      ', N'Nam', CAST(N'1992-12-30' AS Date), N'0987654321', N'123454446789', N'CS003', N'Nhân viên                     ', CAST(15500000 AS Numeric(18, 0)), N'TK052')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV006', N'Trần Văn Tới                                      ', N'Nam', CAST(N'1985-06-25' AS Date), N'0369852147', N'654781129321', N'CS003', N'Nhân viên                     ', CAST(16500000 AS Numeric(18, 0)), N'TK053')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV007', N'Nguyễn Thị Giang                                  ', N'Nữ ', CAST(N'1989-03-05' AS Date), N'0123456789', N'987656664321', N'CS003', N'Nhân viên                     ', CAST(14500000 AS Numeric(18, 0)), N'TK054')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV008', N'Lê Văn Họ                                         ', N'Nam', CAST(N'1993-08-20' AS Date), N'0987654321', N'123455786789', N'CS003', N'Nhân viên                     ', CAST(16000000 AS Numeric(18, 0)), N'TK055')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV009', N'Phạm Thị In                                       ', N'Nữ ', CAST(N'1994-04-17' AS Date), N'0369852147', N'654789463321', N'CS002', N'Nhân viên                     ', CAST(15000000 AS Numeric(18, 0)), N'TK056')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV010', N'Hoàng Thị Kim                                     ', N'Nữ ', CAST(N'1990-11-03' AS Date), N'0123456789', N'987652414321', N'CS002', N'Nhân viên                     ', CAST(14000000 AS Numeric(18, 0)), N'TK057')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV011', N'Lê Văn Liêm                                       ', N'Nam', CAST(N'1986-07-07' AS Date), N'0987654321', N'123454236789', N'CS001', N'Nhân viên                     ', CAST(15500000 AS Numeric(18, 0)), N'TK058')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV012', N'Nguyễn Văn Mang                                   ', N'Nam', CAST(N'1984-09-12' AS Date), N'0369852147', N'654712489321', N'CS002', N'Nhân viên                     ', CAST(16000000 AS Numeric(18, 0)), N'TK059')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV013', N'Trần Thị Nặng                                     ', N'Nữ ', CAST(N'1988-02-28' AS Date), N'0123456789', N'987654354521', N'CS001', N'Nhân viên                     ', CAST(15000000 AS Numeric(18, 0)), N'TK060')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV014', N'Phạm Văn Phượng                                   ', N'Nam', CAST(N'1991-06-15' AS Date), N'0987654321', N'123455436789', N'CS003', N'Nhân viên                     ', CAST(14500000 AS Numeric(18, 0)), N'TK061')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV015', N'Hoàng Thị Quang                                   ', N'Nữ ', CAST(N'1997-04-22' AS Date), N'0369852147', N'658674789321', N'CS002', N'Nhân viên                     ', CAST(15500000 AS Numeric(18, 0)), N'TK062')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV016', N'Lê Văn Rồi                                        ', N'Nam', CAST(N'1998-09-09' AS Date), N'0123456789', N'987654343221', N'CS001', N'Nhân viên                     ', CAST(16000000 AS Numeric(18, 0)), N'TK063')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV017', N'Đào Nhị Khang                                     ', N'Nam', CAST(N'2004-01-01' AS Date), N'0129494949', N'122345678909', N'CS003', N'Nhân viên                     ', CAST(11500000 AS Numeric(18, 0)), N'TK064')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV018', N'Trần Thị Tân                                      ', N'Nữ ', CAST(N'1982-08-08' AS Date), N'0369852147', N'654783219321', N'CS003', N'Nhân viên                     ', CAST(14500000 AS Numeric(18, 0)), N'TK065')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV019', N'Phạm Văn Un                                       ', N'Nam', CAST(N'1989-10-05' AS Date), N'0123456789', N'987654346221', N'CS002', N'Nhân viên                     ', CAST(15500000 AS Numeric(18, 0)), N'TK066')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV020', N'Hoàng Thị Vi                                      ', N'Nữ ', CAST(N'1986-03-03' AS Date), N'0987654321', N'123456852789', N'CS002', N'Nhân viên                     ', CAST(16000000 AS Numeric(18, 0)), N'TK067')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV021', N'Nguyễn Thị Hương                                  ', N'Nữ ', CAST(N'1996-05-25' AS Date), N'0987654321', N'456782479012', N'CS001', N'Nhân viên                     ', CAST(16000000 AS Numeric(18, 0)), N'TK068')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV022', N'Trần Văn Minh                                     ', N'Nam', CAST(N'1995-07-30' AS Date), N'0123456789', N'123456362789', N'CS002', N'Nhân viên                     ', CAST(15500000 AS Numeric(18, 0)), N'TK069')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV023', N'Lê Thị Lan                                        ', N'Nữ ', CAST(N'1987-12-20' AS Date), N'0369852147', N'987654214321', N'CS003', N'Nhân viên                     ', CAST(15000000 AS Numeric(18, 0)), N'TK070')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV024', N'Phạm Văn Tuấn                                     ', N'Nam', CAST(N'1984-04-03' AS Date), N'0987654321', N'789578012345', N'CS003', N'Nhân viên                     ', CAST(14500000 AS Numeric(18, 0)), N'TK071')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV025', N'Hoàng Thị Mai                                     ', N'Nữ ', CAST(N'1993-01-02' AS Date), N'0123456789', N'654312321789', N'CS003', N'Nhân viên                     ', CAST(14000000 AS Numeric(18, 0)), N'TK072')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV026', N'Nguyễn Văn Nam                                    ', N'Nam', CAST(N'1981-02-10' AS Date), N'0369852147', N'321756789012', N'CS003', N'Nhân viên                     ', CAST(16500000 AS Numeric(18, 0)), N'TK073')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV027', N'Trần Thị Thảo                                     ', N'Nữ ', CAST(N'1992-09-18' AS Date), N'0987654321', N'012323445678', N'CS001', N'Nhân viên                     ', CAST(15500000 AS Numeric(18, 0)), N'TK074')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV028', N'Lê Văn Hùng                                       ', N'Nam', CAST(N'1985-11-22' AS Date), N'0123456789', N'678905671234', N'CS002', N'Nhân viên                     ', CAST(16000000 AS Numeric(18, 0)), N'TK075')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV029', N'Phạm Thị Hạnh                                     ', N'Nữ ', CAST(N'1990-07-07' AS Date), N'0369852147', N'345672345890', N'CS001', N'Nhân viên                     ', CAST(15000000 AS Numeric(18, 0)), N'TK076')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV030', N'Hoàng Văn Đức                                     ', N'Nam', CAST(N'1988-03-15' AS Date), N'0987654321', N'901234534567', N'CS002', N'Nhân viên                     ', CAST(14500000 AS Numeric(18, 0)), N'TK077')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV031', N'Nguyễn Minh Tuấn                                  ', N'Nam', CAST(N'1979-04-28' AS Date), N'0123456789', N'123222456789', N'CS001', N'Quản lý                       ', CAST(150000000 AS Numeric(18, 0)), N'TK078')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV033', N'Tống Thành Đạt                                    ', N'Nam', CAST(N'1975-10-12' AS Date), N'0123456789', N'123222456789', N'CS003', N'Quản lý                       ', CAST(150000000 AS Numeric(18, 0)), N'TK079')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [GioiTinh], [NgaySinh], [SoDienThoai], [SoCCCD], [MaCoSo], [VaiTro], [Luong], [IDTaiKhoan]) VALUES (N'NV034', N'Nguyễn Trọng Đạt                                  ', N'Nam', CAST(N'1979-04-05' AS Date), N'0395632027', N'123222456789', N'CS002', N'Quản lý                       ', CAST(150000000 AS Numeric(18, 0)), N'TK080')
GO
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN001', N'Q0002')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN003', N'Q0002')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN003', N'Q0003')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN006', N'Q0002')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN001', N'Q0003')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN004', N'Q0002')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN002', N'Q0002')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN007', N'Q0003')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN009', N'Q0001')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN004', N'Q0003')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN007', N'Q0002')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN005', N'Q0003')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN008', N'Q0003')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN005', N'Q0002')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN002', N'Q0003')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN008', N'Q0002')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN006', N'Q0003')
INSERT [dbo].[PhanQuyen] ([IDChucNang], [IDQuyen]) VALUES (N'CN010', N'Q0001')
GO
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (N'PN001', N'Đã Duyệt            ', N'NV001', CAST(N'2024-09-22' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (N'PN002', N'Đã Duyệt            ', N'NV001', CAST(N'2024-09-22' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (N'PN003', N'Đã Duyệt            ', N'NV002', CAST(N'2024-09-22' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (N'PN004', N'Đã Duyệt            ', N'NV018', CAST(N'2024-09-22' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (N'PN005', N'Đã Duyệt            ', N'NV001', CAST(N'2024-09-22' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (N'PN006', N'Chưa duyệt          ', N'NV001', CAST(N'2024-09-22' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (N'PN007', N'Chưa duyệt          ', N'NV001', CAST(N'2024-09-22' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (N'PN008', N'Đã Duyệt            ', N'NV001', CAST(N'2024-09-22' AS Date))
GO
INSERT [dbo].[Quyen] ([IDQuyen], [TenQuyen]) VALUES (N'Q0001', N'Hội viên                      ')
INSERT [dbo].[Quyen] ([IDQuyen], [TenQuyen]) VALUES (N'Q0002', N'Nhân viên                     ')
INSERT [dbo].[Quyen] ([IDQuyen], [TenQuyen]) VALUES (N'Q0003', N'Quản lý                       ')
INSERT [dbo].[Quyen] ([IDQuyen], [TenQuyen]) VALUES (N'Q0004', N'Admin                         ')
INSERT [dbo].[Quyen] ([IDQuyen], [TenQuyen]) VALUES (N'Q0005', N'Nhân viên nhập hàng           ')
GO
INSERT [dbo].[Ta] ([MaHangHoa], [KhoiLuong], [ChatLieu], [MauSac]) VALUES (N'HH001', 5, N'Đen', N'Thép')
INSERT [dbo].[Ta] ([MaHangHoa], [KhoiLuong], [ChatLieu], [MauSac]) VALUES (N'HH002', 10, N'Đen', N'Thép')
INSERT [dbo].[Ta] ([MaHangHoa], [KhoiLuong], [ChatLieu], [MauSac]) VALUES (N'HH003', 15, N'Đen', N'Thép')
INSERT [dbo].[Ta] ([MaHangHoa], [KhoiLuong], [ChatLieu], [MauSac]) VALUES (N'HH004', 20, N'Đen', N'Thép')
INSERT [dbo].[Ta] ([MaHangHoa], [KhoiLuong], [ChatLieu], [MauSac]) VALUES (N'HH005', 25, N'Đen', N'Thép')
INSERT [dbo].[Ta] ([MaHangHoa], [KhoiLuong], [ChatLieu], [MauSac]) VALUES (N'HH006', 1, N'Tím', N'Thép')
INSERT [dbo].[Ta] ([MaHangHoa], [KhoiLuong], [ChatLieu], [MauSac]) VALUES (N'HH016', 25, N'Thép', N'Đen')
GO
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK001', N'jack97              ', N'123456              ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK002', N'TKHV002             ', N'MKHV002             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK003', N'TKHV003             ', N'MKHV003             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK004', N'TKHV004             ', N'MKHV004             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK005', N'TKHV005             ', N'MKHV005             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK006', N'TKHV006             ', N'MKHV006             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK007', N'TKHV007             ', N'MKHV007             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK008', N'TKHV008             ', N'MKHV008             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK009', N'TKHV009             ', N'MKHV009             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK010', N'TKHV010             ', N'MKHV010             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK011', N'TKHV011             ', N'MKHV011             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK012', N'TKHV012             ', N'MKHV012             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK013', N'TKHV013             ', N'MKHV013             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK014', N'TKHV014             ', N'MKHV014             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK015', N'TKHV015             ', N'MKHV015             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK016', N'TKHV016             ', N'MKHV016             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK017', N'TKHV017             ', N'MKHV017             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK018', N'TKHV018             ', N'MKHV018             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK019', N'TKHV019             ', N'MKHV019             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK020', N'TKHV020             ', N'MKHV020             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK021', N'TKHV021             ', N'MKHV021             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK022', N'TKHV022             ', N'MKHV022             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK023', N'TKHV023             ', N'MKHV023             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK024', N'TKHV024             ', N'MKHV024             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK025', N'TKHV025             ', N'MKHV025             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK026', N'TKHV026             ', N'MKHV026             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK027', N'TKHV027             ', N'MKHV027             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK028', N'TKHV028             ', N'MKHV028             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK029', N'TKHV029             ', N'MKHV029             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK030', N'TKHV030             ', N'MKHV030             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK031', N'TKHV031             ', N'MKHV031             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK032', N'TKHV032             ', N'MKHV032             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK033', N'TKHV033             ', N'MKHV033             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK034', N'TKHV034             ', N'MKHV034             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK035', N'TKHV035             ', N'MKHV035             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK036', N'TKHV036             ', N'MKHV036             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK037', N'TKHV037             ', N'MKHV037             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK038', N'TKHV038             ', N'MKHV038             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK039', N'TKHV039             ', N'MKHV039             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK040', N'TKHV040             ', N'MKHV040             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK041', N'TKHV041             ', N'MKHV041             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK042', N'TKHV042             ', N'MKHV042             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK043', N'TKHV043             ', N'MKHV043             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK044', N'TKHV044             ', N'MKHV044             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK045', N'TKHV045             ', N'MKHV045             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK046', N'TKHV046             ', N'MKHV046             ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK047', N'thanhdat1405        ', N'dat12345            ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK048', N'TKNV001             ', N'MKNV001             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK049', N'TKNV002             ', N'MKNV002             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK050', N'TKNV003             ', N'MKNV003             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK051', N'TKNV004             ', N'MKNV004             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK052', N'TKNV005             ', N'MKNV005             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK053', N'TKNV006             ', N'MKNV006             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK054', N'TKNV007             ', N'MKNV007             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK055', N'TKNV008             ', N'MKNV008             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK056', N'TKNV009             ', N'MKNV009             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK057', N'TKNV010             ', N'MKNV010             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK058', N'TKNV011             ', N'MKNV011             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK059', N'TKNV012             ', N'MKNV012             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK060', N'TKNV013             ', N'MKNV013             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK061', N'TKNV014             ', N'MKNV014             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK062', N'TKNV015             ', N'MKNV015             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK063', N'TKNV016             ', N'MKNV016             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK064', N'TKNV017             ', N'MKNV017             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK065', N'TKNV018             ', N'MKNV018             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK066', N'TKNV019             ', N'MKNV019             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK067', N'TKNV020             ', N'MKNV020             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK068', N'TKNV021             ', N'MKNV021             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK069', N'TKNV022             ', N'MKNV022             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK070', N'TKNV023             ', N'MKNV023             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK071', N'TKNV024             ', N'MKNV024             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK072', N'TKNV025             ', N'MKNV025             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK073', N'TKNV026             ', N'MKNV026             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK074', N'TKNV027             ', N'MKNV027             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK075', N'TKNV028             ', N'MKNV028             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK076', N'TKNV029             ', N'MKNV029             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK077', N'TKNV030             ', N'MKNV030             ', N'Q0002')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK078', N'TKQL001             ', N'MKQL001             ', N'Q0003')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK079', N'TKQL002             ', N'MKQL002             ', N'Q0003')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK080', N'TKQL003             ', N'MKQL003             ', N'Q0003')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK081', N'TKHV011             ', N'123456              ', N'Q0001')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK082', N'admin               ', N'admin               ', N'Q0004')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK083', N'tongthanhdat009     ', N'dat12345            ', N'Q0004')
INSERT [dbo].[TaiKhoan] ([IDTaiKhoan], [TaiKhoan], [MatKhau], [IDQuyen]) VALUES (N'TK084', N'taikhoan            ', N'123456              ', N'Q0001')
GO
INSERT [dbo].[Xa] ([LoaiXa], [ChatLieu], [ChieuDai], [DuongKinh], [ChieuCao], [TaiTrong], [MaHangHoa]) VALUES (N'Xà đơn', N'Thép', CAST(1.50 AS Decimal(5, 2)), CAST(0.05 AS Decimal(5, 2)), CAST(2.00 AS Decimal(5, 2)), CAST(150.00 AS Decimal(7, 2)), N'HH009')
INSERT [dbo].[Xa] ([LoaiXa], [ChatLieu], [ChieuDai], [DuongKinh], [ChieuCao], [TaiTrong], [MaHangHoa]) VALUES (N'Xà đơn', N'Thép carbon', CAST(0.80 AS Decimal(5, 2)), CAST(0.04 AS Decimal(5, 2)), CAST(1.80 AS Decimal(5, 2)), CAST(100.00 AS Decimal(7, 2)), N'HH010')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_CoSo] FOREIGN KEY([MaCoSo])
REFERENCES [dbo].[CoSo] ([MaCoSo])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_CoSo]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HangHoa] FOREIGN KEY([MaHH])
REFERENCES [dbo].[HangHoa] ([MaHangHoa])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HangHoa]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon1] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon1]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_HangHoa] FOREIGN KEY([MaHangHoa])
REFERENCES [dbo].[HangHoa] ([MaHangHoa])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_HangHoa]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap] FOREIGN KEY([MaPhieuNhap])
REFERENCES [dbo].[PhieuNhap] ([MaPhieuNhap])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [FK_GioHang_HangHoa] FOREIGN KEY([MaHangHoa])
REFERENCES [dbo].[HangHoa] ([MaHangHoa])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [FK_GioHang_HangHoa]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [FK_GioHang_TaiKhoan] FOREIGN KEY([IDTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([IDTaiKhoan])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [FK_GioHang_TaiKhoan]
GO
ALTER TABLE [dbo].[HangHoaOCoSo]  WITH CHECK ADD  CONSTRAINT [FK_HangHoaOCoSo_CoSo] FOREIGN KEY([MaCoSo])
REFERENCES [dbo].[CoSo] ([MaCoSo])
GO
ALTER TABLE [dbo].[HangHoaOCoSo] CHECK CONSTRAINT [FK_HangHoaOCoSo_CoSo]
GO
ALTER TABLE [dbo].[HangHoaOCoSo]  WITH CHECK ADD  CONSTRAINT [FK_HangHoaOCoSo_HangHoa] FOREIGN KEY([MaHangHoa])
REFERENCES [dbo].[HangHoa] ([MaHangHoa])
GO
ALTER TABLE [dbo].[HangHoaOCoSo] CHECK CONSTRAINT [FK_HangHoaOCoSo_HangHoa]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_TaiKhoan] FOREIGN KEY([IDTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([IDTaiKhoan])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_TaiKhoan]
GO
ALTER TABLE [dbo].[HoiVien]  WITH CHECK ADD  CONSTRAINT [FK_HoiVien_TaiKhoan1] FOREIGN KEY([IDTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([IDTaiKhoan])
GO
ALTER TABLE [dbo].[HoiVien] CHECK CONSTRAINT [FK_HoiVien_TaiKhoan1]
GO
ALTER TABLE [dbo].[MayChay]  WITH CHECK ADD  CONSTRAINT [FK_MayChay_HangHoa] FOREIGN KEY([MaHangHoa])
REFERENCES [dbo].[HangHoa] ([MaHangHoa])
GO
ALTER TABLE [dbo].[MayChay] CHECK CONSTRAINT [FK_MayChay_HangHoa]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([MaCoSo])
REFERENCES [dbo].[CoSo] ([MaCoSo])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan1] FOREIGN KEY([IDTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([IDTaiKhoan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan1]
GO
ALTER TABLE [dbo].[PhanQuyen]  WITH CHECK ADD  CONSTRAINT [FK_PhanQuyen_Quyen] FOREIGN KEY([IDChucNang])
REFERENCES [dbo].[ChucNang] ([IDChucNang])
GO
ALTER TABLE [dbo].[PhanQuyen] CHECK CONSTRAINT [FK_PhanQuyen_Quyen]
GO
ALTER TABLE [dbo].[PhanQuyen]  WITH CHECK ADD  CONSTRAINT [FK_PhanQuyen_Quyen1] FOREIGN KEY([IDQuyen])
REFERENCES [dbo].[Quyen] ([IDQuyen])
GO
ALTER TABLE [dbo].[PhanQuyen] CHECK CONSTRAINT [FK_PhanQuyen_Quyen1]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhanVien]
GO
ALTER TABLE [dbo].[Ta]  WITH CHECK ADD  CONSTRAINT [FK_Ta_HangHoa] FOREIGN KEY([MaHangHoa])
REFERENCES [dbo].[HangHoa] ([MaHangHoa])
GO
ALTER TABLE [dbo].[Ta] CHECK CONSTRAINT [FK_Ta_HangHoa]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_Quyen] FOREIGN KEY([IDQuyen])
REFERENCES [dbo].[Quyen] ([IDQuyen])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_Quyen]
GO
ALTER TABLE [dbo].[Xa]  WITH CHECK ADD  CONSTRAINT [FK_Xa_HangHoa] FOREIGN KEY([MaHangHoa])
REFERENCES [dbo].[HangHoa] ([MaHangHoa])
GO
ALTER TABLE [dbo].[Xa] CHECK CONSTRAINT [FK_Xa_HangHoa]
GO
