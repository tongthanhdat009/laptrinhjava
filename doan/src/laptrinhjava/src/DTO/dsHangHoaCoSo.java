package DTO;
import java.util.ArrayList;
public class dsHangHoaCoSo {
    ArrayList<hangHoaCoSo> dsHHCS;
    //hàm thiết lập
    dsHangHoaCoSo(){
        dsHHCS = new ArrayList<>();
    }
    dsHangHoaCoSo(ArrayList<hangHoaCoSo> dsHHCS){
        this.dsHHCS = dsHHCS;
    }

    // hàm get&set
    void setDsHangHoaCoSo(ArrayList<hangHoaCoSo> dsHHCS){
        this.dsHHCS = dsHHCS;
    }
    ArrayList<hangHoaCoSo> getDsHHCS(){
        return this.dsHHCS;
    }

    //hàm chức năng
    //thêm
    void them(int soLuong, String maHangHoa, String maCoSo){
        hangHoaCoSo a = new hangHoaCoSo();
        try{
            a.setMaHangHoa(maHangHoa);
        }
        catch (IllegalArgumentException e){
            System.out.print("Ma hang hoa khong hop le!");//sửa cái này thành thông báo trong giao diện
        }
        try{
            a.setSoLuong(soLuong);
        }
        catch(IllegalArgumentException e){
            System.out.print("So luong hang hoa khong hop le!");//sửa cái này thành thông báo trong giao diện
        }
        try{
            a.setMaCoSo(maCoSo);
        }
        catch(IllegalArgumentException e){
            System.out.print("Ma co so khong hop le");//sửa cái này thành thông báo trong giao diện
        }
        dsHHCS.add(a);
    }
    //sửa
    void sua(int soLuong, String maHangHoa, String maCoSo){
        for(hangHoaCoSo i : dsHHCS){
            if(i.getMaCoSo().equals(maCoSo) && i.getMaHangHoa().equals(maHangHoa)){
                try{
                    i.setSoLuong(soLuong);
                    break;
                }
                catch(IllegalArgumentException e){
                    System.out.println("So luong khong hop le!"); //sửa cái này thành thông báo trong giao diện
                }
                break;
            }
        }
    }
    //xóa
    void xoa(String maHangHoa, String maCoSo){
        for(hangHoaCoSo i : dsHHCS){
            if(i.getMaCoSo().equals(maCoSo) && i.getMaHangHoa().equals(maHangHoa)){
                dsHHCS.remove(i);
                break;
            }
        }
    }

}
