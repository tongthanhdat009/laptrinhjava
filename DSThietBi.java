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
    public void sua(String maThietBi, String tenThietBi, int thoiGianBaoHanh)
    {
        try
        {
            for(ThietBi i:dsThietBi)
            if(i.getMaThietBi().equals(maThietBi))
            {
                i.setThoiGianBaoHanh(thoiGianBaoHanh);
                i.setTenThietBi(tenThietBi);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Sai thoi gian bao hanh");
        }
    }

}
