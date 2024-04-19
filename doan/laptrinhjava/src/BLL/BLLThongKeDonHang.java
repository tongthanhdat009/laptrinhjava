package BLL;

import java.util.ArrayList;
import java.sql.*;
import DAL.DataLamThongKe;
import DTO.DTOThongKeDonHang;

public class BLLThongKeDonHang {
    private DataLamThongKe dataLamThongKe;
    public BLLThongKeDonHang()
    {
        dataLamThongKe = new DataLamThongKe();
    }
    public ArrayList<DTOThongKeDonHang> layDSDLoc(String tenHangHoa, String tenCoSo, Date tuNgay, Date denNgay)
    {
        return dataLamThongKe.locLayDanhSach(tenHangHoa,tenCoSo,tuNgay,denNgay);
    }
}
