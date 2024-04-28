package BLL;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;

import DAL.DataHoiVien;
import DAL.DataHoiVienCoSo;
import DAL.DataThietBi;
import DAL.DataThietBiCoSo;
import DAL.DataCoSo;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.DSThietBiCoSo;
import DTO.HoiVien;
import DTO.HoiVienCoSo;
import DTO.LoaiThietBi;
import DTO.ThietBiCoSo;
import DTO.dsHoiVien;

public class BLLQuanLyDanhSach{
    private DataHoiVien dataHoiVien;
    private DataCoSo dataCoSo;
    private DataThietBi dataThietBi;
    private DataThietBiCoSo dataThietBiCoSo;
    private DataHoiVienCoSo dataHoiVienCoSo;
    public BLLQuanLyDanhSach(){
        dataHoiVien = new DataHoiVien();
        dataCoSo = new DataCoSo();
        dataThietBi = new DataThietBi(); 
        dataThietBiCoSo = new DataThietBiCoSo();
        dataHoiVienCoSo = new DataHoiVienCoSo();
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
}