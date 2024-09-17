package BLL;

import DAL.DataHangHoa;

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
}
