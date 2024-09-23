package BLL;

import DAL.DataHangHoa;
import DAL.DataHoaDon;
import DAL.DataHoaDonChiTiet;
import DTO.ChiTietChiTietHoaDon;
import DTO.ChiTietHoaDon;
import DTO.GioHang;
import DTO.HoaDon;
import DTO.HoaDonVaGia;
import DTO.ThongTinChiTietHangHoa;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class TuanBLL {
    private DataHangHoa dataHangHoa;
    private DataHoaDon dataHoaDon;
    private DataHoaDonChiTiet dataHoaDonChiTiet;
    public TuanBLL()
    {
        dataHangHoa = new DataHangHoa();
        dataHoaDon = new DataHoaDon();
        dataHoaDonChiTiet = new DataHoaDonChiTiet();
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
    public String thanhToan(String IDTaiKhoan)
    {
        String maHoaDon = dataHoaDon.layMa();
        if(maHoaDon.equals("Loi")) return "Lỗi không sinh được mã hóa đơn";
        LocalDate today = LocalDate.now();
        Date todayDate = Date.valueOf(today);
        if(dataHoaDon.them(new HoaDon(maHoaDon, todayDate, IDTaiKhoan)))
        {
            ArrayList<GioHang> ds = new ArrayList<>();
            ds = dataHangHoa.layDSGioHang(IDTaiKhoan);
            boolean flag = true;
            for(int i=0;i<ds.size();i++)
            {
                flag = dataHoaDonChiTiet.them(new ChiTietHoaDon(ds.get(i).getSoLuong(), maHoaDon, ds.get(i).getMaHangHoa(), ds.get(i).getGia() * ds.get(i).getSoLuong(), ds.get(i).getMaCoSo(),"Chưa duyệt"));
                if(flag == false) return "Lỗi thêm chi tiết hóa đơn";
            }
            if(flag ==  true && dataHangHoa.xoaGioHangCua(IDTaiKhoan)) return "Thanh toán thành công";
            else return "Lỗi xóa giỏ hàng";
            
        }
        return "Lỗi thêm hóa đơn";
    }
    public ArrayList<HoaDonVaGia> layDSHoaDonCua(String IDTaiKhoan)
    {
        return dataHoaDon.layDSHoaDonVaGiaCua(IDTaiKhoan);
    }
    public ArrayList<ChiTietChiTietHoaDon> layDSChiTietHoaDonCua(String IDTaiKhoan, String maHD)
    {
        return dataHoaDon.chiTietHoaDon(IDTaiKhoan,maHD);
    }
    public ArrayList<HoaDonVaGia> layDSHDCuaCoSo(String maCoSo, String trangThai)
    {
        return dataHoaDon.layDSHoaDonCuaCoSo(maCoSo, trangThai);
    }
    public ArrayList<ChiTietChiTietHoaDon> layDSChiTietHoaDonCuaCoSo(String IDTaiKhoan, String maHD, String maCoSo)
    {
        return dataHoaDon.chiTietHoaDonCuaCoSo(IDTaiKhoan,maHD,maCoSo);
    }
    public boolean duyetHoaDonCuaCoSo(String maHoaDon, String maCoSo)
    {
        return dataHoaDon.duyetHoaDonCuaCoSo(maHoaDon, maCoSo);
    }
}
