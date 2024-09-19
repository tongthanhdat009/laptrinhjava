package BLL;

import java.util.ArrayList;

import DAL.dataChiTietDonNhap;
import DTO.chiTietPhieuNhap;

public class BLLChiTietDonNhap {
    private dataChiTietDonNhap dataChiTietDonNhap;
    public BLLChiTietDonNhap(){
        dataChiTietDonNhap=new dataChiTietDonNhap();
    }
    public ArrayList<chiTietPhieuNhap> getChiTietPhieuNhap(String maDonNhap){
        return dataChiTietDonNhap.getChiTietDonNhap(maDonNhap);
    }
    public String getTenHH(String maHH){
        return dataChiTietDonNhap.getTenHH(maHH);
    }
    public String getLoaiHH(String maHH){
        return dataChiTietDonNhap.getLoaiHH(maHH);
    }
    public int getTongTien(String maDonNhap){
        return dataChiTietDonNhap.getTongTien(maDonNhap);
    }
    public void themHoacCapNhatHangHoa(String maCoSo,String maDonNhap){
        ArrayList<chiTietPhieuNhap> chiTietPhieuNhaps = dataChiTietDonNhap.getChiTietDonNhap(maDonNhap);
        for(chiTietPhieuNhap ct: chiTietPhieuNhaps){
            dataChiTietDonNhap.themHoacCapNhatHangHoa(maCoSo, ct.getMaHangHoa(), ct.getSoLuong(), ct.getGiaTien());
        }
    }
}
