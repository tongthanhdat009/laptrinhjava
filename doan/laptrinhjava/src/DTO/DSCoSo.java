package DTO;
import java.util.ArrayList;
public class DSCoSo {
    public ArrayList<CoSo> dsCoSo = new ArrayList<CoSo>();
    public DSCoSo()
    {
        dsCoSo = new ArrayList<CoSo>();
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
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
}
