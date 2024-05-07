package BLL;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;

import DAL.DataHoiVien;
import DAL.DataHoiVienCoSo;
import DAL.DataNhanVien;
import DAL.DataThietBi;
import DAL.DataThietBiCoSo;
import DAL.DataTinhDonGiaHoaDon;
import DAL.DataCoSo;
import DAL.DataDichVu;
import DAL.DataHoaDon;
import DAL.DataHoaDonChiTiet;
import DTO.ChiTietHoaDon;
import DAL.DataHangHoa;
import DAL.DataHangHoaCoSo;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.DTODuyetDonHang;
import DTO.HoaDon;
import DTO.HoiVien;
import DTO.HoiVienCoSo;
import DTO.LoaiThietBi;
import DTO.NhanVien;
import DTO.ThietBiCoSo;
import DTO.dichVu;
import DTO.dsHangHoa;
import DTO.hangHoa;
import DTO.hangHoaCoSo;

public class BLLQuanLyDanhSach{
    private DataHoiVien dataHoiVien;
    private DataCoSo dataCoSo;
    private DataThietBi dataThietBi;
    private DataThietBiCoSo dataThietBiCoSo;
    private DataHoiVienCoSo dataHoiVienCoSo;
    private DataHoaDon dataHoaDon;
    private DataHoaDonChiTiet dataHoaDonChiTiet;
    private DataTinhDonGiaHoaDon dataTinhDonGiaHoaDon;
    private DataHangHoa dataHangHoa;
    private DataNhanVien dataNhanVien;
    private DataDichVu dataDichVu;
    private DataHangHoaCoSo dataHangHoaCoSo;
    public BLLQuanLyDanhSach(){
        dataHoiVien = new DataHoiVien();
        dataCoSo = new DataCoSo();
        dataThietBi = new DataThietBi(); 
        dataThietBiCoSo = new DataThietBiCoSo();
        dataHoiVienCoSo = new DataHoiVienCoSo();
        dataHoaDon = new DataHoaDon();
        dataHoaDonChiTiet = new DataHoaDonChiTiet();
        dataTinhDonGiaHoaDon = new DataTinhDonGiaHoaDon();
        dataHangHoa = new DataHangHoa();
        dataDichVu = new DataDichVu();
        dataNhanVien = new DataNhanVien();
        dataHangHoaCoSo = new DataHangHoaCoSo();
    }
    
    //danh sách hội viên
    public ArrayList<HoiVien> getDataHoiVien(){
        return dataHoiVien.layDanhSachHoiVien();
    }
    public ArrayList<String> layTenCotHoiVien(){
        return dataHoiVien.getTenCot();
    }
    public ArrayList<HoiVien> layDsHV(){
        return dataHoiVien.layDanhSachHoiVien();
    }
    public boolean xoaHV(String maHoiVien){
        return dataHoiVien.xoa(maHoiVien);
    }
    public int kiemTraMaHoiVien(){
        return dataHoiVien.layMaHoiVienChuaTonTai()+1;
    }
    public boolean themHV(HoiVien a){
        return dataHoiVien.them(a);
    }
    public boolean suaThongTinHV(HoiVien a){
        return dataHoiVien.sua(a);
   }
    public boolean timKiemHV(String a){
        return dataHoiVien.timKiemHV(a);
    }
    public boolean kiemTraSDT(String a){
        if(a.matches("(0[3|5|7|8|9])+([0-9]{8})\\b")){
            return true;
        }
        return false;
    }
    //danh sách cơ sở
    public DSCoSo layDsCoSo(){
        return dataCoSo.layDSCoSo();
    }
    public ArrayList<String> layTenCotCoSo(){
        return dataCoSo.layTenCotCoSo();
    }
    public int kiemTraMaCoSo(){
        return dataCoSo.layMaCoSoMoi()+1;
    }
    public boolean themCS(CoSo coSo){
        return dataCoSo.themCoSo(coSo);
    }
    public int kiemTraDoanhThu(String doanhThu){
        if(!(doanhThu!=null && doanhThu.matches("\\d{1,18}$")))
            return -1;
        else
            return 1;
    }
    public boolean xoaCS(String maCoSo){
        return dataCoSo.xoaCS(maCoSo);
    }
    public boolean timKiemCS(String maCoSo){
        return dataCoSo.timKiemCS(maCoSo);
    }
    public boolean suaThongTinCS(CoSo cs){
        return dataCoSo.suaThongTinCS(cs);
    }

    //danh sách thiết bị
    public DSLoaiThietBi layDSLoaiThietBi(){
        return dataThietBi.layDanhSach();
    }
    public ArrayList<String> layTenCotThietBi(){
        return dataThietBi.layTenCotThietBi();
    }
    public boolean timKiemTheoMaTB(String maTB){
        return dataThietBi.timKiemTheoMaTB(maTB);
    }
    public boolean xoaTB(String maTB){
        return dataThietBi.xoaTB(maTB);
    }
    public boolean themTB(LoaiThietBi tb){
        return dataThietBi.themTB(tb);
    }
    public int kiemTraMaThietBi(){
        return dataThietBi.layMaThietBiMoi()+1;
    }
    public int kiemTraGiaThietBi(String doanhThu){
        if(!(doanhThu!=null && doanhThu.matches("\\d{1,18}$")))
            return -1;
        else
            return 1;
    }
    public boolean suaThongTinTB(LoaiThietBi tb){
        return dataThietBi.suaThongTinTB(tb);
    }
    //danh sách thiết bị cơ sở
    public String themThietBiCoSo(String maThietBiCoSo,String maCoSo, String maThietBi, Date ngayNhap, Date hanBaoHanh)
    {
        if(dataThietBi.kiemTraMa(maThietBi))
        {
            ThietBiCoSo a = new ThietBiCoSo(maThietBiCoSo, maCoSo, maThietBi, ngayNhap, hanBaoHanh);
            if(dataThietBiCoSo.them(a)) return "ThanhCong";
            else return "Them that bai";
        }
        else return "Ma thiet bi khong ton tai";
    }
    public String layMaThietBiCoSo()
    {
        return "TBCS"+ dataThietBiCoSo.layMaThietBiCuoi();
    }   
    public Date layHanBaoHanh(String maThietBi, Date ngayNhap)
    {
        LocalDate hanBaoHanh = ngayNhap.toLocalDate();
        hanBaoHanh = hanBaoHanh.plusDays(dataThietBi.timSoNgayBaoHanh(maThietBi));
        return Date.valueOf(hanBaoHanh);
    }
    public boolean xoaThietBiCoSO(String maThietBiCoSO)
    {
        if(dataThietBiCoSo.xoa(maThietBiCoSO)) return true;
        return false;
    }
    public String suaThietBiCoSo(String maThietBiCoSo,String maCoSo, String maThietBi, Date ngayNhap, Date hanBaoHanh)
    {
        if(dataThietBi.kiemTraMa(maThietBi))
        {
            ThietBiCoSo a = new ThietBiCoSo(maThietBiCoSo, maCoSo, maThietBi, ngayNhap, hanBaoHanh);
            if(dataThietBiCoSo.sua(a)) return "ThanhCong";
            else return "That Bai";
        }
        else return "Ma Thiet Bi Khong Ton Tai";
    }
    public ArrayList<ThietBiCoSo> layDanhSachThietBiCoSo()
    {
        return dataThietBiCoSo.layDSLoaiThietBiCoSo();
    }
    public ArrayList<ThietBiCoSo> timKiemThietBiCoSo(String maThietBiCoSo)
    {
        return dataThietBiCoSo.timKiem(maThietBiCoSo);
    }

    //danh sách hội viên cơ sở
    public ArrayList<HoiVienCoSo> layDSHoiVienCoSo()
    {
        return dataHoiVienCoSo.layDanhSach();
    }
    public ArrayList<HoiVienCoSo> timKiemHoiVienCoSo(String maHoiVien, String maCoSo)
    {
        if(maHoiVien.equals("")) maHoiVien = "NULL";
        if(maCoSo.equals("Chọn cơ sở")) maCoSo = "NULL";
        return dataHoiVienCoSo.timKiem(maHoiVien, maCoSo);
    }
    public String themHoiVienCoSo(String maHoiVien, String maCoSo, Date thoiGianKetThuc)
    {
        if(dataHoiVien.timKiemHV(maHoiVien) == false) return "Mã hội viên không tồn tại";
        if(dataHoiVienCoSo.them(new HoiVienCoSo(thoiGianKetThuc, maHoiVien, maCoSo))) return "Thành công";
        return "Lỗi";
    }
    public String xoaHoiVienCoSo(String maHoiVien, String maCoSo)
    {
        if(dataHoiVienCoSo.xoa(maHoiVien, maCoSo)) return "Thành công";
        return "Bộ không tồn tại";
    }
    public String suaHoiVienCoSo(String maHoiVien, String maCoSo, Date hanTap)
    {
        if(dataHoiVien.timKiemHV(maHoiVien) == false) return "Mã hội viên không tồn tại";
        if(dataHoiVienCoSo.sua(new HoiVienCoSo(hanTap, maHoiVien, maCoSo))) return "Thành công";
        return "Bộ không tồn tại";
    } 
    public Vector<String> layDSMaCoSo()
    {
        Vector<String> a = new Vector<>();
        a = dataCoSo.DSMaCoSo();
        a.add(0,"Chọn cơ sở");
        return a;
    }

    //danh sách hóa đơn
    public ArrayList<HoaDon> layDSHoaDon()
    {
        return dataHoaDon.layDSHoaDon();
    }
    public ArrayList<ChiTietHoaDon> layDSChiTietHoaDon()
    {
        return dataHoaDonChiTiet.layDSHoaDon();
    }
    public String layMaHoaDon()
    {
        return dataHoaDon.layMa();
    }
    public String themHoaDon(Date ngayXuatHoaDon, String maHV, String maCoSo, String trangThai)
    {
        String maHoaDon = layMaHoaDon();
        if(dataHoiVien.timKiemHV(maHV) == false) return "Hội Viên không tồn tại";
        HoaDon hoaDon = new HoaDon(maHoaDon, ngayXuatHoaDon,0, maHV, maCoSo, trangThai);
        if(dataHoaDon.them(hoaDon) == true) return "Thành công";
        return "Lỗi";
    }
    public String xoaHoaDon(String maHoaDon)
    {
        if(dataHoaDon.xoa(maHoaDon) == true) return "Thành công";
        return "Mã hóa đơn không tồn tại";
    }
    public ArrayList<HoaDon> timKiemHoaDon(String maHoaDon)
    {
        return dataHoaDon.timKiem(maHoaDon);
    }
    public String suaHoaDon(String maHoaDon, Date ngayXuatHoaDon, String maHV, String maCoSo, String trangThai)
    {
        if(dataHoiVien.timKiemHV(maHV) == false) return "Hội Viên không tồn tại";
        if(dataHoaDon.sua(new HoaDon(maHoaDon, ngayXuatHoaDon,0, maHV, maCoSo, trangThai)) == true) return "Thành công";
        return "Mã hóa đơn không tồn tại";
    }
    //danh sách chi tiết hóa đơn
    public String themChiTietHoaDon(String maHoaDon, String maHangHoa, int soLuong)
    {
        if(dataHoaDon.kiemTraTonTai(maHoaDon) == false) return "Mã hóa đơn không tồn tại";
        if(dataHangHoa.timKiemHH(maHangHoa) == false) return "Mã hàng hóa không tồn tại";
        if(soLuong <= 0) return "Số lượng không hợp lệ";
        if (dataHoaDonChiTiet.them(new ChiTietHoaDon(soLuong, maHoaDon, maHangHoa)) == false) return "Thất bại";
        int tong = dataTinhDonGiaHoaDon.tinhDonGia(maHoaDon);
        if(dataHoaDon.suaTongTien(maHoaDon, tong) == true) return "Thành công";
        return "Lỗi";
    }
    public String xoaChiTietHoaDon(String maHoaDon, String maHangHoa)
    {
        if(dataHoaDonChiTiet.xoa(maHoaDon, maHangHoa) == false) return "Thất bại";
        int tong = dataTinhDonGiaHoaDon.tinhDonGia(maHoaDon);
        if(dataHoaDon.suaTongTien(maHoaDon, tong) == true) return "Thành công";
        return "Lỗi";
    }
    public String suaChiTietHoaDon(String maHoaDon, String maHangHoa, int soLuong)
    {
        if(soLuong <= 0 ) return "Sai số lượng";
        if(dataHoaDonChiTiet.sua(maHoaDon, maHangHoa, soLuong) == false) return "Thất bại";
        int tong = dataTinhDonGiaHoaDon.tinhDonGia(maHoaDon);
        if(dataHoaDon.suaTongTien(maHoaDon, tong) == true) return "Thành công";
        return "Lỗi";
    }
    public ArrayList<ChiTietHoaDon> timKiemChiTietHoaDon(String maHoaDon, String maHangHoa)
    {
        if(maHoaDon.equals("")) maHoaDon = "NULL";
        if(maHangHoa.equals("")) maHangHoa = "NULL";
        return dataHoaDonChiTiet.timKiem(maHoaDon, maHangHoa);
    }
    public ArrayList<HoaDon> timKiemHoaDon2(String maHoaDon, String maCoSo, String maHoiVien)
    {
        if(maHoaDon.equals("")) maHoaDon ="NULL";
        if(maCoSo.equals("Chọn cơ sở")) maCoSo ="NULL";
        if(maHoiVien.equals("")) maHoiVien ="NULL";
        return dataHoaDon.timKiem2(maHoaDon, maCoSo, maHoiVien);
    }
    public ArrayList<HoaDon> layDSHoaDonChuaDuyet()
    {
        return dataHoaDon.layHoaDonChuaDuyet();
    }
    public ArrayList<DTODuyetDonHang> dsDTODuyetDonHang(String maHoaDon)
    {
        return dataHoaDonChiTiet.timDSChiTietHoaDon(maHoaDon);
    }
    public boolean duyetHoaDon(String maHoaDon)
    {
        return dataHoaDon.duyetHoaDon(maHoaDon);
    }
    //danh sách hàng hóa
    public dsHangHoa layDsHangHoa(){
        return dataHangHoa.layDanhSachHangHoa();
    }
    public ArrayList<String> layTenCotHangHoa(){
        return dataHangHoa.getTenCot();
    }
    public int kiemTraMaHangHoa(){
        return dataHangHoa.layMaHangHoaMoi()+1;
    }
    public int kiemTraGiaNhapHangHoa(String giaNhap){
        if(!(giaNhap != null && giaNhap.matches("\\d{1,18}$")))
            return -1;
        else
            return 1;
    }
    public boolean themHH(hangHoa hh){
        return dataHangHoa.themHangHoa(hh);
    }
    public boolean xoaHangHoa(String maHH){
        return dataHangHoa.xoaHangHoa(maHH);
    }
    public boolean timKiemTheoMaHH(String maHH){
        return dataHangHoa.timKiemHH(maHH);
    }
    public boolean suaThongTinHH(hangHoa hh){
        return dataHangHoa.suaHangHoa(hh);
    }
    
    // Danh sách nhân viên
    public ArrayList<NhanVien> getDataNhanVien() {
        return dataNhanVien.layDanhSachNhanVien();
    }

    public ArrayList<String> layTenCotNhanVien() {
        return dataNhanVien.getTenCot();
    }

    // Xóa nhân viên
    public boolean xoaNV(String maNhanVien) {
        return dataNhanVien.xoanv(maNhanVien);
    }

    public String layMaNVchuaTonTai() {
    	return dataNhanVien.taoMaNhanVienMoi();
    }

    // Kiểm tra và tạo mã nhân viên mới
    public String kiemTraMaNhanVien() {
        String maMoi = "NV" + dataNhanVien.layMaNhanVienChuaTonTai();
        ArrayList<NhanVien> ds = dataNhanVien.timkiemnhanvien(maMoi);
        if(!ds.isEmpty()) {
        	maMoi = "NV" + dataNhanVien.layMaNhanVienChuaTonTai();
        	ds = dataNhanVien.timkiemnhanvien(maMoi);
        }
        return maMoi;
    }

    // Thêm nhân viên mới
    public boolean themNV(NhanVien nv) {
    	return dataNhanVien.them(nv);
    }

    // Sửa thông tin nhân viên
    public boolean suaThongTinNV(NhanVien nv) {
        return dataNhanVien.suanv(nv);
    }

    // Tìm kiếm nhân viên
    public ArrayList<NhanVien> timKiemNV(String manv) {
        return dataNhanVien.timkiemnhanvien(manv);
    }
    
    // Danh sách dịch vụ
    public ArrayList<dichVu> getDataDichvu(){
    	return dataDichVu.layDanhSachDichVu();
    }
    public ArrayList<String> layTenCotDichVu() {
        return dataDichVu.getTenCot();
    }
    public String layMaDichVuchuaTonTai() {
    	return dataDichVu.taoMaDichvuMoi();
    }
    public boolean themDV(dichVu dv) {
    	return dataDichVu.themDV(dv);
    }
    public boolean xoaDV(String madv) {
    	return dataDichVu.xoaDV(madv);
    }
    public boolean suaDV(dichVu dv) {
    	return dataDichVu.suaDV(dv);
    }
    public ArrayList<dichVu> timKiemDV (String madv){
    	return dataDichVu.timkiemDV(madv);
    }
    public ArrayList<hangHoaCoSo> layDSHangHoaCoSo()
    {
        return dataHangHoaCoSo.layDanhSachHangHoaCoSo();
    }
    public ArrayList<hangHoaCoSo> timKiemHangHoaCoSo(String maCoSo, String maHangHoa)
    {
        if(maHangHoa.equals("")) maHangHoa ="NULL";
        if(maCoSo.equals("Chọn cơ sở")) maCoSo ="NULL";
        return dataHangHoaCoSo.timKiem(maCoSo, maHangHoa);
    }
    public String themHangHoaCoSo(String maHangHoa, String maCoSo, int soLuong)
    {
        if(dataHangHoa.timKiemHH(maHangHoa) == false) return "Mã hàng hóa không tồn tại";
        if(soLuong <= 0) return "Số lượng không hợp lệ";
        if(dataHangHoaCoSo.them(new hangHoaCoSo(maCoSo, soLuong, maHangHoa)) == true) return "Thành công";
        return "Bộ đã tồn tại";
    }
    public String xoaHangHoaCoSo(String maCoSo, String maHangHoa)
    {
        if(dataHangHoaCoSo.xoa(maCoSo, maHangHoa) == true) return "Thành công";
        return "Bộ không tồn tại";
    }
    public String suaHangHoaCoSo(String maCoSo, String maHangHoa, int soLuong)
    {
        if(dataHangHoaCoSo.sua(new hangHoaCoSo(maCoSo, soLuong, maHangHoa)) == true) return "Thành công";
        return "Bộ không tồn tại";
    }
}