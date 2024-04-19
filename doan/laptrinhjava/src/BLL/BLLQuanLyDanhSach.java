package BLL;
import java.util.ArrayList;
import DAL.DataHoiVien;
import DTO.HoiVien;

public class BLLQuanLyDanhSach{
    private DataHoiVien dataHoiVien;
    public BLLQuanLyDanhSach(){
        dataHoiVien = new DataHoiVien();
    }
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
}