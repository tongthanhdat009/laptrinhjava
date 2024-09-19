package BLL;

import java.util.ArrayList;

import DAL.DataDonNhap;
import DTO.DonNhap;

public class BLLDonNhap {
    private DataDonNhap dataDonNhap;
    public BLLDonNhap(){
        dataDonNhap = new DataDonNhap();
    }
    public ArrayList<DonNhap> layDsDonNhap(String maCoSo){
        return dataDonNhap.layDSDonNhapTheoCoSo(maCoSo);
    }
    public void duyetDon(String maDonNhap){
        dataDonNhap.capNhatTrangThai(maDonNhap,"Đã Duyệt");
    }
    public ArrayList<DonNhap> searchTheoTen(String maCoSo,String tenNV){
        return dataDonNhap.searchTheoTen(maCoSo,tenNV);
    }
    public ArrayList<DonNhap> searchTheoTenVaTrangThai(String maCoSo,String tenNV,String tinhTrang){
        return dataDonNhap.searchTheoTenVaTrangThai(maCoSo, tenNV, tinhTrang);
    }
}
