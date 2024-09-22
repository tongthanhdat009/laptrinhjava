package BLL;

import java.util.ArrayList;

import DAL.dataChiTietDonNhap;
import DAL.dataNhapHang;
import DTO.DTOdonNhap;

public class BLLNhapHang {
    dataNhapHang dataNhapHang;
    dataChiTietDonNhap dataChiTietDonNhap;
    public BLLNhapHang(){
        dataNhapHang=new dataNhapHang();
        dataChiTietDonNhap=new dataChiTietDonNhap();
    }
    public String getTenNVbyMaTK(String maTK){
        return dataNhapHang.getTenNVbyMaTK(maTK);
    }
    public ArrayList<DTOdonNhap> getDonNhap(String maTK,String maCoSo){
        return dataNhapHang.getDsDonNhapTheoTK(maTK, maCoSo);
    }
    public boolean deletePhieuNhap(String maPhieuNhap){
        return dataNhapHang.xoaPhieuNhap(maPhieuNhap);
    }
    public ArrayList<String> getDsHH(){
        return dataNhapHang.getDsHH();
    }
    public boolean deleteChiTietPhieuNhap(String maPhieuNhap,String maHangHoa){
        return dataChiTietDonNhap.deleteChiTietPhieuNhap(maPhieuNhap, maHangHoa);
    }
    public boolean updateGiavaSoLuong(String maPhieuNhap, String maHanghoa, int soluong, int giaNhap){  
        return dataChiTietDonNhap.updateChiTietPhieuNhap(maPhieuNhap, maHanghoa, soluong, giaNhap);
    }
    public boolean checkHangHoa(String maPhieuNhap, String maHangHoa){
        return dataChiTietDonNhap.checkHangHoa(maPhieuNhap, maHangHoa);
    }
}
