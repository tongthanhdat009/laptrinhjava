import java.util.ArrayList;
import java.util.Iterator;
public class DSCoSo implements Iterable<CoSo> {
    private ArrayList<CoSo> dsCoSo;
    public DSCoSo()
    {
        dsCoSo = new ArrayList<>();
    }
    public DSCoSo(ArrayList<CoSo> dsCoSo)
    {
        this.dsCoSo = dsCoSo;
    }
    public void them(String std, String diaChi)
    {
        try 
        {
            CoSo newCoSo = new CoSo(diaChi,std);
            dsCoSo.add(newCoSo);
        } 
        catch(IllegalArgumentException e) 
        {
            System.out.println("SDT khong hop le");
        }
    }
    public void xoa(String maCoSo)
    {
        for(CoSo i:dsCoSo)
        if(i.getMaCoSo().equals(maCoSo)) dsCoSo.remove(i);
    }
    public void sua(String maCoSo, String std, String diaChi)
    {
        try
        {
            for(CoSo i:dsCoSo)
            if(i.getMaCoSo().equals(maCoSo))
            {
                i.setStd(std);
                i.setDiaChi(diaChi);
            }
        }
        catch(IllegalArgumentException e) 
        {
            System.out.println("SDT khong hop le");
        }
    }
    @Override
    public Iterator<CoSo> iterator() {
        return dsCoSo.iterator();
    }
}
