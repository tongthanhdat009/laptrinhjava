package BLL;
import java.util.ArrayList;


import DAL.DataHoiVien;
import DAL.DataThietBi;
import DAL.DataCoSo;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.DSThietBiCoSo;
import DTO.HoiVien;
import DTO.LoaiThietBi;
import DTO.dsHoiVien;

public class BLLQuanLyDanhSach{
    private DataHoiVien dataHoiVien;
    private DataCoSo dataCoSo;
    private DataThietBi dataThietBi;
    public BLLQuanLyDanhSach(){
        dataHoiVien = new DataHoiVien();
        dataCoSo = new DataCoSo();
        dataThietBi = new DataThietBi(); 
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
}