import java.util.ArrayList;
public class dsDichVu {
    ArrayList<dichVu> dsDV;
    //hàm khởi tạo
    dsDichVu(){
        dsDV = new ArrayList<>();
    }
    dsDichVu(ArrayList<dichVu>dsDV){
        this.dsDV = dsDV;
    }
    
    //hàm get&set
    public void setDsDV(ArrayList<dichVu> dsDV) {
        this.dsDV = dsDV;
    }
    public ArrayList<dichVu> getDsDV(){
        return this.dsDV;
    }
    
    //hàm chức năng
    void them(String maDichVu, String tenDichVu, String loaiDichVu, long giaDichVu){
        dichVu a = new dichVu();
        try{
            a.setMaDichVu(maDichVu);
        }
        catch(IllegalArgumentException e){
            System.out.print("Ma dich vu khong hop le!"); //chỉnh cái này thành thông báo trong giao diện
        }
        try{
            a.setTenDichVu(tenDichVu);
        }
        catch(IllegalArgumentException e){
            System.out.print("Ten dich vu khong hop le!"); //chỉnh cái này thành thông báo trong giao diện
        }
        try{
            a.setLoaiDichVu(loaiDichVu);
        }
        catch(IllegalArgumentException e){
            System.out.print("Loai dich vu khong hop le!"); //chỉnh cái này thành thông báo trong giao diện
        }
        try{
            a.setGiaDichVu(giaDichVu);
        }
        catch(IllegalArgumentException e){
            System.out.print("Gia dich vu khong hop le!"); //chỉnh cái này thành thông báo trong giao diện
        }
    }

    //sửa
    void sua(String maDichVu, String tenDichVu, String loaiDichVu, long giaDichVu){
        for(dichVu i : dsDV){
            if(i.getMaDichVu().equals(maDichVu)){
                try{
                    i.setTenDichVu(tenDichVu);
                }
                catch(IllegalArgumentException e){
                    System.out.print("Ma dich vu khong hop le!"); //chỉnh cái này thành thông báo trong giao diện
                }
                try{
                    i.setLoaiDichVu(loaiDichVu);
                }
                catch(IllegalArgumentException e){
                    System.out.print("Loai dich vu khong hop le!"); //chỉnh cái này thành thông báo trong giao diện
                }
                try{
                    i.setGiaDichVu(giaDichVu);
                }
                catch(IllegalArgumentException e){
                    System.out.print("Loai dich vu khong hop le!"); //chỉnh cái này thành thông báo trong giao diện
                }
                break;
            }
        }
    }
    
    //xóa
    void xoa(String maDichVu){
        for(dichVu i : dsDV){
            if(i.getMaDichVu().equals(maDichVu)){
                dsDV.remove(i);
                break;
            }
        }
    }
}
