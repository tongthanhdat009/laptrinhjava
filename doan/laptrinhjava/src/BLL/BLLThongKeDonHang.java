package BLL;

import java.util.ArrayList;
import java.util.Vector;

import DAL.dataCoSo;
import DAL.DataLamThongKe;
import DTO.DTOThongKeDonHang;

public class BLLThongKeDonHang {
    private DataLamThongKe dataLamThongKe;
    private dataCoSo dataCoSo;
    public BLLThongKeDonHang()
    {
        dataLamThongKe = new DataLamThongKe();
        dataCoSo = new dataCoSo();
    }
    public ArrayList<DTOThongKeDonHang> layDSDLoc(String tenHangHoa, String tenCoSo, String tuNgay, String denNgay)
    {
        return dataLamThongKe.locLayDanhSach(tenHangHoa,tenCoSo,tuNgay,denNgay);
    }
    public Vector<String> DSMaCoSo()
    {
        Vector<String> DSTenCoSo = dataCoSo.DSMaCoSo();
        String s = "Tất cả cơ sở";
        DSTenCoSo.add(0,s);
        return DSTenCoSo;
    }
}
