package DTO;
import java.util.ArrayList;

public class DSLoaiThietBi {
    private ArrayList<LoaiThietBi> dsThietBi;
    public DSLoaiThietBi()
    {
        dsThietBi = new ArrayList<>();
    }
    public DSLoaiThietBi(ArrayList<LoaiThietBi> dsThietBi)
    {
        this.dsThietBi=dsThietBi;
    }
    public ArrayList<LoaiThietBi> getDsThietBi()
    {
        return dsThietBi;
    }
    public void them(LoaiThietBi thietBi)
    {
        dsThietBi.add(thietBi);
    }
}
