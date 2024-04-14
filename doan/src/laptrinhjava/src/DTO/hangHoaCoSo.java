package DTO;

public class hangHoaCoSo{
    private int soLuong;
    private String maHangHoa;
    private String maCoSo;

    //hàm khởi tạo
    hangHoaCoSo(){
        this.soLuong = 0;
        this.maHangHoa = "";
        this.maCoSo = "";
    }
    hangHoaCoSo(int soLuong, String maHangHoa, String maCoSo){
        setSoLuong(soLuong);
        setMaHangHoa(maHangHoa);
        setMaCoSo(maCoSo);
    }

    //hàm get&set
    public void setSoLuong(int soLuong){
        if(!(soLuong < 0))
            this.soLuong = soLuong;
        else
            throw new IllegalArgumentException("So Luong Phai >= 0");
    }
    public void setMaHangHoa(String maHangHoa){
        if(!(maHangHoa.equals("")))
            this.maHangHoa = maHangHoa;
        else
            throw new IllegalArgumentException("Ma Hang Hoa Khong Hop Le!");
    }
    public void setMaCoSo(String maCoSo){
        if(!(maCoSo.equals("")))
            this.maCoSo = maCoSo;
        else throw new IllegalArgumentException("Ma Co So Khong Hop Le!");
    }

    public int getSoLuong(){
        return this.soLuong;
    }
    public String getMaHangHoa(){
        return this.maHangHoa;
    }
    public String getMaCoSo(){
        return this.maCoSo;
    }
    public String toString(){
        return this.maHangHoa + " " + this.maCoSo + " " + this.soLuong;  
    }
    // public void nhap(){ //test
    //     Scanner in = new Scanner(System.in);
    //     int newSoLuong;
    //     String newMaHangHoa = new String();
    //     String newMaCoSo = new String();
    //     System.out.println("Nhap ma hang hoa: ");
    //     newMaHangHoa = in.nextLine();
    //     System.out.println("Nhap ma co so: ");
    //     newMaCoSo = in.nextLine();
    //     System.out.println("Nhap so luong cua hang hoa: ");
    //     newSoLuong = in.nextInt();
    //     setMaCoSo(newMaCoSo);
    //     setMaHangHoa(newMaHangHoa);
    //     setSoLuong(newSoLuong);
    //     System.out.print(newMaCoSo + " " + newMaHangHoa + " " + newSoLuong);
    //     in.close();
    // }

    // public static void main(String[] args){
    //     hangHoaCoSo a = new hangHoaCoSo();
    //     a.nhap();
    // }

}