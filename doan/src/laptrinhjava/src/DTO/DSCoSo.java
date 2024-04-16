package DTO;
import java.util.ArrayList;
public class DSCoSo {
    public ArrayList<CoSo> dsCoSo;
    public DSCoSo()
    {
        dsCoSo = new ArrayList<>();
    }
    public DSCoSo(ArrayList<CoSo> dsCoSo)
    {
        this.dsCoSo = dsCoSo;
    }
    public ArrayList<CoSo> getDsCoSo()
    {
        return dsCoSo;
    }
    public void them(CoSo coSo)
    {
        dsCoSo.add(coSo);
    }
}
