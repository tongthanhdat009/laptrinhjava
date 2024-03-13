import java.util.ArrayList;

public class DSThietBi {
    private ArrayList<ThietBi> dsThietBi;
    public DSThietBi()
    {
        dsThietBi = new ArrayList<>();
    }
    public DSThietBi(ArrayList<ThietBi> dsThietBi)
    {
        this.dsThietBi=dsThietBi;
    }
    public void them(String tenThietBi, int thoiGianBaoHanh)
    {
        try
        {
            ThietBi newThietBi = new ThietBi(tenThietBi,thoiGianBaoHanh);
            dsThietBi.add(newThietBi);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Sai thoi gian bao hanh");
        }
    }
    public void xoa(int intdex)
    {
        dsThietBi.remove(intdex);
    }
    public void sua(int index, String tenThietBi, int thoiGianBaoHanh)
    {
        try
        {
            dsThietBi.get(index).setThoiGianBaoHanh(thoiGianBaoHanh);
            dsThietBi.get(index).setTenThietBi(tenThietBi);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Sai thoi gian bao hanh");
        }
    }

}
