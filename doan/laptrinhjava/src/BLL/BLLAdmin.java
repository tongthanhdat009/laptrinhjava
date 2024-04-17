package BLL;

import java.util.ArrayList;

import DAL.DataHoiVien;
import DTO.HoiVien;
import DTO.dsHoiVien;
import GUI.GUIAdmin;

public class BLLAdmin {
    private DataHoiVien dataHoiVien;
    public BLLAdmin(){
        dataHoiVien = new DataHoiVien();
    }
    public ArrayList<HoiVien> getDataHoiVien(){
        return dataHoiVien.layDanhSachHoiVien();
    }
    public void xuLyBangHoiVien(){
        DataHoiVien data = new DataHoiVien();
        dsHoiVien ds = new dsHoiVien();
        ds.dshv = data.layDanhSachHoiVien();
        for(int i=0;i<ds.dshv.size();i++){
            System.out.println(ds.dshv.get(i).getMaHoiVien());
        }
    }
    public ArrayList<String> layTenCotHoiVien(){
        return dataHoiVien.getTenCot();
    }
    public ArrayList<HoiVien> layDsHV(){
        return dataHoiVien.layDanhSachHoiVien();
    }
    public static void main(String[] args){
        new GUIAdmin();
    }
}
