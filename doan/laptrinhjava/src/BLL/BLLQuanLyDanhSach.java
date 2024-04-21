package BLL;
import java.util.ArrayList;
import DAL.DataHoiVien;
import DTO.HoiVien;
import DTO.dsHoiVien;

public class BLLQuanLyDanhSach{
    private DataHoiVien dataHoiVien;
    public BLLQuanLyDanhSach(){
        dataHoiVien = new DataHoiVien();
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
    public dsHoiVien timKiemHV(HoiVien a){
        return dataHoiVien.timKiem(a);
    }
}