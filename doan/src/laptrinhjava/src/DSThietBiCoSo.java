import java.util.ArrayList;
public class DSThietBiCoSo
{
    private ArrayList<ThietBiCoSo> dsThietBiCoSo;
    public DSThietBiCoSo()
    {
        dsThietBiCoSo = new ArrayList<>();
    }
    public DSThietBiCoSo(ArrayList<ThietBiCoSo> dsThietBiCoSo)
    {
        this.dsThietBiCoSo = dsThietBiCoSo;
    }
    public ArrayList<ThietBiCoSo> getDSThietBiCoSo()
    {
        return dsThietBiCoSo;
    }
}
