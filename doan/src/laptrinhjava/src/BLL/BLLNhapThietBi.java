package BLL;

import DAL.DataThietBi;
import DTO.DSLoaiThietBi;

public class BLLNhapThietBi {
    private DataThietBi dataThietBi;
    public BLLNhapThietBi()
    {
        dataThietBi = new DataThietBi();
    }
    public DSLoaiThietBi layDSLoaiThietBi()
    {
        return dataThietBi.layDanhSach();
    }
}
