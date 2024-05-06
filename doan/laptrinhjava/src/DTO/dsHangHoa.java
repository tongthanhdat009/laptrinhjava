package DTO;
import java.util.ArrayList;

public class dsHangHoa {
    public ArrayList<hangHoa> dsHangHoa;
    //hàm khởi tạo
    public dsHangHoa(){
        this.dsHangHoa = new ArrayList<hangHoa>();
    }
    public dsHangHoa(ArrayList<hangHoa> dsHangHoa){
        this.dsHangHoa = dsHangHoa;
    }
    
    //hàm get&set
    public void setDsHangHoa(ArrayList<hangHoa> dsHangHoa){
        this.dsHangHoa = dsHangHoa;
    }
    ArrayList<hangHoa> getDsHangHoa(){
        return this.dsHangHoa;
    }

    //hàm chức năng
    //thêm
    public void them(hangHoa hang){
        this.dsHangHoa.add(hang);
    }
    //sửa
    public void sua(String maHangHoa, String newLoaiHangHoa, String newTenHangHoa){
        for(hangHoa i: dsHangHoa){
            if(i.getMaHangHoa().equals(maHangHoa)){
                try{
                    i.setLoaiHangHoa(newLoaiHangHoa);
                    i.setTenLoaiHangHoa(newTenHangHoa);
                    break;
                }
                catch (IllegalArgumentException e){
                    System.out.print("Thong tin can sua khong hop le!");//sửa cho giao diện hiện thông báo
                }
            }
        }
    }
    //xóa
    public void xoa(String maHangHoa){
        for(hangHoa i : dsHangHoa){
            if(i.getMaHangHoa().equals(maHangHoa)){
                dsHangHoa.remove(i);
                break;
            }
        }
    }
}
