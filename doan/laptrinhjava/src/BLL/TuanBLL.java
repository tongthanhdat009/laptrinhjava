package BLL;

import DAL.DataHangHoa;
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
        return dataHangHoa.timDSHangBan(ten, maCoSo, loai);
    }
}
