// package BLL;

// import DAL.DataCoSo;
// import DAL.DataThietBi;
// import DAL.DataThietBiCoSo;
// import DTO.DSCoSo;
// import DTO.DSLoaiThietBi;

// public class BLLNhapThietBi {
//     private DataThietBi dataThietBi;
//     private DataThietBiCoSo dataThietBiCoSo;
//     private DataCoSo dataCoSo;
//     public BLLNhapThietBi()
//     {
//         dataThietBi = new DataThietBi();
//         dataThietBiCoSo = new DataThietBiCoSo();
//         dataCoSo = new DataCoSo();
//     }
//     public DSLoaiThietBi layDSLoaiThietBi()
//     {
//         return dataThietBi.layDanhSach();
//     }
//     // public int laySoLuongThietBi()
//     // {
//     //     return dataThietBi.laySoLuong();
//     // }
//     public void nhapHangVeCoSo(String maLoaiThietBi,String maCoSo, int soLuong, int soNgayBaoHanh)
//     {
//         dataThietBiCoSo.nhapThietBi(maLoaiThietBi, maCoSo, soLuong, soNgayBaoHanh);
//     }
//     // public DSLoaiThietBi timKiem(String ten)
//     // {
//     //     return dataThietBi.timKiem(ten);
//     // }
//     public DSCoSo layDsCoSo()
//     {
//         return dataCoSo.layDSCoSo();
//     }
// }
