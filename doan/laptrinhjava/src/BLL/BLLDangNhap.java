package BLL;
import java.util.ArrayList;

import DAL.DataCoSo;
import DAL.DataTaiKhoan;
import DTO.DTOTaiKhoan;

public class BLLDangNhap {
    private DataTaiKhoan data;
    private DataCoSo dataCoSo;
    private DataTaiKhoan dataTaiKhoan;
    public BLLDangNhap()
    {
    	dataCoSo = new DataCoSo();
        data = new DataTaiKhoan();
    }
    public String KiemTraDangNhap(String taiKhoan, String matKhau)
    {
        return data.KiemTraDangNhap(taiKhoan, matKhau);
    }
    public boolean kiemTraTaiKhoanCoSo(DTOTaiKhoan tk, String maCoSo) {
    	return data.kiemTraTaiKhoanCoSo(tk, maCoSo);
    }
    public ArrayList<String> dsMaCS(){
    	return dataCoSo.DSMaCoSoARR();
    }
    // public boolean kiemTraPhienDangNhap(DTOTaiKhoan tk){
    //     if(dataTaiKhoan.kiemTraPhienDangNhap(tk)){

    //     }
    // }
}
