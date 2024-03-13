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
    public void xoa(int index)
    {
        dsCoSo.remove(index);
    }
    public void sua(int index, String std, String diaChi)
    {
        try
        {
            dsCoSo.get(index).setStd(std);
            dsCoSo.get(index).setDiaChi(diaChi);
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
