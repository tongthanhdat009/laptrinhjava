package BLL;

import DAL.DataHoiVien;

public class BLLDangKy {
    DataHoiVien dataHoiVien;
    public BLLDangKy(){
        dataHoiVien = new DataHoiVien();
    }
    public boolean hoiVienDangKy(String maHV, String tenHV, String gioiTinh, String email, String tk, String mk, int selectedYear, int selectedMonth, int selectedDay){
        if(dataHoiVien.kiemTraHoiVienDangKy(maHV, tenHV, gioiTinh, email, tk, mk, selectedYear, selectedMonth, selectedDay)){
            return true;
        }
        return false;
    }
}
