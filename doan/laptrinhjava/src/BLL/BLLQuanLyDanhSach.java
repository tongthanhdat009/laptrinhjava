package BLL;
import java.awt.Component;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import DAL.DataHoiVien;
import DAL.dataCoSo;
import DTO.DSCoSo;
import DTO.HoiVien;
import DTO.dsHoiVien;

public class BLLQuanLyDanhSach{
    private DataHoiVien dataHoiVien;
    private dataCoSo dataCoSo;
    public BLLQuanLyDanhSach(){
        dataHoiVien = new DataHoiVien();
        dataCoSo = new dataCoSo();
    }
    //xóa những gì đã hiển thị của một danh sách
    public void xoaHienThi(JPanel rightPanel){
        int x = 6; // Thay thế ... bằng tọa độ x của điểm bạn muốn kiểm tra
        int y = 460; // Thay thế ... bằng tọa độ y của điểm bạn muốn kiểm tra
        int x1 = 6;
        int y1 = 176;

        Component component = rightPanel.getComponentAt(x, y);
        Component component1 = rightPanel.getComponentAt(x1, y1);
        Component[] btn = rightPanel.getComponents();
        if (component != null && component.isShowing()) {
            // Component tại điểm đã cho tồn tại và đang được hiển thị
            for(Component a : btn){
                if(a instanceof JButton){
                    rightPanel.remove(a);
                }
            }
            rightPanel.remove(component);
            rightPanel.remove(component1);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }
    //danh sách hội viên
    public ArrayList<HoiVien> getDataHoiVien(){
        return dataHoiVien.layDanhSachHoiVien();
    }
    public ArrayList<String> layTenCotHoiVien(){
        return dataHoiVien.getTenCot();
    }
    public ArrayList<HoiVien> layDsHV(){
        return dataHoiVien.layDanhSachHoiVien();
    }
    public boolean xoaHV(String maHoiVien){
        return dataHoiVien.xoa(maHoiVien);
    }
    public int kiemTraMaHoiVien(){
        return dataHoiVien.layMaHoiVienChuaTonTai()+1;
    }
    public boolean themHV(HoiVien a){
        return dataHoiVien.them(a);
    }
    public boolean suaThongTinHV(HoiVien a){
        return dataHoiVien.sua(a);
   }
    public boolean timKiemHV(String a){
        return dataHoiVien.timKiemHV(a);
    }
    
    //danh sách cơ sở
    public DSCoSo layDsCoSo(){
        return dataCoSo.layDSCoSo();
    }
    public ArrayList<String> layTenCotCoSo(){
        return dataCoSo.layTenCotCoSo();
    }

}