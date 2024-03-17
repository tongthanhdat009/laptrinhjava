import java.util.ArrayList;

public class dsHangHoa {
    ArrayList<hangHoa> dsHH;
    //hàm khởi tạo
    dsHangHoa(){
        this.dsHH = new ArrayList<>();
    }
    dsHangHoa(ArrayList<hangHoa> dsHangHoa){
        this.dsHH = dsHangHoa;
    }
    
    //hàm get&set
    public void setDsHangHoa(ArrayList<hangHoa> dsHangHoa){
        this.dsHH = dsHangHoa;
    }
    ArrayList<hangHoa> getDsHangHoa(){
        return this.dsHH;
    }

    //hàm chức năng
    //thêm
    void them(String maHangHoa, String loaiHangHoa, String tenHangHoa){
        hangHoa hang = new hangHoa();
        try{
            hang.setMaHangHoa(maHangHoa);
        }
        catch(IllegalArgumentException e){
            System.out.print("Ma hang hoa khong hop le!"); //sửa cho giao diện hiện thông báo
        }
        try{
            hang.setLoaiHangHoa(loaiHangHoa);
        }
        catch(IllegalArgumentException e){
            System.out.print("Loai hang hoa khong hop le!"); //sửa cho giao diện hiện thông báo
        }
        try{
            hang.setTenHangHoa(tenHangHoa);
        }
        catch(IllegalArgumentException e){
            System.out.print("Ten hang hoa khong hop le!"); //sửa cho giao diện hiện thông báo
        }
        dsHH.add(hang);
    }
    //sửa
    void sua(String maHangHoa, String newLoaiHangHoa, String newTenHangHoa){
        for(hangHoa i: dsHH){
            if(i.getMaHangHoa().equals(maHangHoa)){
                try{
                    i.setLoaiHangHoa(newLoaiHangHoa);
                    i.setTenHangHoa(newTenHangHoa);
                    break;
                }
                catch (IllegalArgumentException e){
                    System.out.print("Thong tin can sua khong hop le!");//sửa cho giao diện hiện thông báo
                }
            }
        }
    }
    //xóa
    void xoa(String maHangHoa){
        for(hangHoa i : dsHH){
            if(i.getMaHangHoa().equals(maHangHoa)){
                dsHH.remove(i);
                break;
            }
        }
    }
}
