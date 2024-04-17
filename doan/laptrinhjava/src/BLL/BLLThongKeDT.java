package BLL;
import DAL.DataCoSo;
import DTO.DSCoSo;
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
}
