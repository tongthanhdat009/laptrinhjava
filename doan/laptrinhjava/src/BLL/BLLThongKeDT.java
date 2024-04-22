package BLL;
import DAL.dataCoSo;
import DTO.DSCoSo;
public class BLLThongKeDT {
    private dataCoSo dataCoSo;
    public BLLThongKeDT()
    {
        dataCoSo = new dataCoSo();
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
