package BLL;
import DAL.DataCoSo;
import DTO.DSCoSo;
import DTO.dsHangHoaCoSo;
public class BLLThongKeDT {
    private DataCoSo dataCoSo;
    public BLLThongKeDT()
    {
        dataCoSo = new DataCoSo();
    }
    public DSCoSo layDSCoSo()
    {
        return dataCoSo.layDSCoSo();
    }
    public DSCoSo timKiemCoSo (String tenCoSo)
    {
        return dataCoSo.timKiemCoSo(tenCoSo);
    }
}
