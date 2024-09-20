package DTO;

public class hangHoaCoSo extends hangHoa{
    private String maHangHoa;
    private String maCoSo;
    private String trangThai;
    private int soLuong;
    private int giaBan;
    //hàm khởi tạo
    hangHoaCoSo(){
        this.soLuong = 0;
        this.maHangHoa = "";
        this.maCoSo = "";
        this.giaBan = 0;
        this.trangThai ="";
    }
    public hangHoaCoSo(String maHangHoa, String maCoSo, String trangThai, Integer soLuong, Integer giaBan, String loai, String tenLoaiHangHoa, String hinhAnh){
    	super(maHangHoa, loai, tenLoaiHangHoa, hinhAnh);
        setMaHangHoa(maHangHoa);
        setMaCoSo(maCoSo);
        setTrangThai(trangThai);
        setSoLuong(soLuong);
        setGiaBan(giaBan);
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
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}