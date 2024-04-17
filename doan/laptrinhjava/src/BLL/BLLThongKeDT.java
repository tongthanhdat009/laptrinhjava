package BLL;
import DAL.DataCoSo;
import DTO.DSCoSo;
public class BLLThongKeDT {
    private DataCoSo dataCoSo;
    public BLLThongKeDT()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public DSCoSo layDSCoSo()
    {
        return dataCoSo.layDSCoSo();
    }
}
