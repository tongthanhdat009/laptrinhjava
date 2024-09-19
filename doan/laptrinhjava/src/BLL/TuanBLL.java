package BLL;

import DAL.DataHangHoa;
import DTO.GioHang;
import DTO.ThongTinChiTietHangHoa;
import java.util.ArrayList;

public class TuanBLL {
    private DataHangHoa dataHangHoa;
    public TuanBLL()
    {
        dataHangHoa = new DataHangHoa();
    }
    public String layThongTinChiTietHangHoa(String maHangHoa, String maCoSo)
    {
        return dataHangHoa.timThongTinChiTietHangHoa(maHangHoa, maCoSo);
    }
    public ArrayList<ThongTinChiTietHangHoa> timDSHangBan(String ten, String maCoSo, String loai)
    {
        if(ten.equals("")) ten = "NULL";
        if(maCoSo.equals("")) maCoSo = "NULL";
        if(loai.equals("") || loai.equals("Tất cả")) loai = "NULL";
        if(loai.equals("Tạ")) loai = "Ta";
        if(loai.equals("Máy chạy")) loai = "MayChay";
        if(loai.equals("Xà")) loai = "Xa";
        return dataHangHoa.timDSHangBan(ten, maCoSo, loai);
    }
    public String themVaoGioHang(String maHangHoa, String IDTaiKhoan, String maCoSo, int soLuongMua)
    {
        int soLuongDangCo = dataHangHoa.timSoLuongHangHoaCoSo(maHangHoa,maCoSo);
        if(soLuongMua > soLuongDangCo) return "Kho không đủ hàng";
        else {
            int soLuongConLai = soLuongDangCo - soLuongMua;
            if(dataHangHoa.suaSoLuongHangHoaOCoSo(maHangHoa,maCoSo,soLuongConLai)){
                if(dataHangHoa.choVaoGioHang(IDTaiKhoan, maHangHoa,maCoSo, soLuongMua))
                return "Thành công";
                else 
                {
                    dataHangHoa.suaSoLuongHangHoaOCoSo(maHangHoa,maCoSo,soLuongDangCo);
                    return "Lỗi giỏ hàng";
                }
            }
            else return "Lỗi hàng hóa cơ sở";
        }
    }
    public ArrayList<GioHang> layDSGioHang(String IDTaiKhoan)
    {
        return dataHangHoa.layDSGioHang(IDTaiKhoan);
    }
    public String xoaGioHang(String IDTaiKhoan, String maHangHoa, String maCoSo, int soLuongHangHoa)
    {
        if(dataHangHoa.xoaGioHang(maHangHoa, IDTaiKhoan, maCoSo))
        {
            int soLuongHienTai = dataHangHoa.timSoLuongHangHoaCoSo(maHangHoa, maCoSo);
            if(dataHangHoa.suaSoLuongHangHoaOCoSo(maHangHoa, maCoSo, soLuongHangHoa +soLuongHienTai)) return "Thành công";
            else return "Lỗi sửa số lượng hhcs";
        }
        return "Lỗi xóa giỏ hàng";
    }
}
