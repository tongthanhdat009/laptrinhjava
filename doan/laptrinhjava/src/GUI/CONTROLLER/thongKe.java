package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import BLL.BLLThongKeDonHang;
import DTO.DTOThongKeDonHang;

public class thongKe {
//	private ArrayList<DTOThongKeDonHang> ds;
//	private Vector<String> dsTenCoSo;
//	private String luaChon;
//	private JPanel rightPanel;
	public thongKe() {
//		this.ds = ds;
//		this.dsTenCoSo = dsTenCoSo;
//		this.luaChon = luaChon;
//		this.rightPanel = rightPanel;
	}
	public void thongKeTheoSoLuong(ArrayList<DTOThongKeDonHang> ds, Vector<String> dsTenCoSo, String luaChon, JPanel rightPanel)
    {
        rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        rightPanel.repaint(); // Vẽ lại JPanel
        rightPanel.setLayout(null);

        JPanel canGiua = new JPanel(new FlowLayout());
        canGiua.setBounds(5,5,rightPanel.getWidth(),55);
        canGiua.setBackground(new Color(204,252,203));
        JLabel titleNhapThietBi = new JLabel("Thống kê Đơn hàng");
        titleNhapThietBi.setFont(new Font("Times New Roman",1,40));

        canGiua.add(titleNhapThietBi);
        rightPanel.add(canGiua);

        JPanel filter = new JPanel(null);
        filter.setBounds(5,70,rightPanel.getWidth(),55);
        JLabel timTheoTen = new JLabel("Tên sản phẩm:");
        timTheoTen.setBounds(10, 15, 100, 30);
        JTextField tenSanPham = new JTextField();
        tenSanPham.setBounds(105, 15, 125, 30);

        JLabel labelDSCoSo = new JLabel("Chọn cơ sở:");
        labelDSCoSo.setBounds(250, 15, 75, 30);
        @SuppressWarnings("rawtypes")
        JComboBox comboBoxTenCoSo = new JComboBox<>(dsTenCoSo);
        comboBoxTenCoSo.setBounds(330, 15, 120, 30);
        comboBoxTenCoSo.setBackground(Color.white);
        JLabel labelLoai = new JLabel("Loại:");
        labelLoai.setBounds(480, 15, 60, 30);
        String[] loai = {"Theo doanh thu","Theo số lượng"};
        @SuppressWarnings("rawtypes")
        JComboBox comboBoxLoai = new JComboBox<>(loai);
        comboBoxLoai.setBounds(535, 15, 150, 30);
        comboBoxLoai.setBackground(Color.white);

        Vector<String> year = new Vector<>();
        Vector<String> month = new Vector<>();
        Vector<String> day = new Vector<>();
        for(int i = 1990 ; i <= 2100;i++)
        year.add(String.valueOf(i));
        year.add(0,"YY");
        for(int i = 1 ; i <= 12;i++)
        month.add(String.valueOf(i));
        month.add(0,"MM");
        for(int i = 1 ; i <= 31;i++)
        day.add(String.valueOf(i));
        day.add(0,"DD");

        @SuppressWarnings("rawtypes")
        JComboBox dayStart = new JComboBox<>(day);
        dayStart.setBackground(Color.white);
        @SuppressWarnings("rawtypes")
        JComboBox monthStart = new JComboBox<>(month);
        monthStart.setBackground(Color.white);
        @SuppressWarnings("rawtypes")
        JComboBox yearStart = new JComboBox<>(year);
        yearStart.setBackground(Color.white);
        dayStart.setBounds(695, 15, 45, 30);
        monthStart.setBounds(740, 15, 45, 30);
        yearStart.setBounds(785, 15, 45, 30);
        filter.add(dayStart);
        filter.add(monthStart);
        filter.add(yearStart);

        JLabel to = new JLabel("đến");
        to.setBounds(835, 15, 25, 30);
        filter.add(to);

        @SuppressWarnings("rawtypes")
        JComboBox dayEnd = new JComboBox<>(day);
        dayEnd.setBackground(Color.white);
        @SuppressWarnings("rawtypes")
        JComboBox monthEnd = new JComboBox<>(month);
        monthEnd.setBackground(Color.white);
        @SuppressWarnings("rawtypes")
        JComboBox yearEnd = new JComboBox<>(year);
        yearEnd.setBackground(Color.white);
        
        dayEnd.setBounds(865, 15, 45, 30);
        monthEnd.setBounds(910, 15, 45, 30);
        yearEnd.setBounds(955, 15, 45, 30);
        filter.add(dayEnd);
        filter.add(monthEnd);
        filter.add(yearEnd);

        JButton timkiem = new JButton("Tìm kiếm");
        timkiem.setBackground(Color.white);
        timkiem.setBounds(1050, 15, 100, 29);
        filter.add(timTheoTen);
        filter.add(tenSanPham);
        filter.add(timkiem);
        filter.add(labelDSCoSo);
        filter.add(comboBoxTenCoSo);
        filter.add(labelLoai);
        filter.add(comboBoxLoai);
        filter.setBackground(new Color(119, 230, 163));
        rightPanel.add(filter);

        int chieuNgang = rightPanel.getWidth() - 550;
        int chieuDoc = ds.size() * 75;
        JPanel thongKe = new JPanel(null);
        thongKe.setBackground(Color.WHITE);
        timkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String tenHang = tenSanPham.getText();
                String tenCoSo = comboBoxTenCoSo.getSelectedItem().toString();
                String d1 = dayStart.getSelectedItem().toString();
                String m1 = monthStart.getSelectedItem().toString();
                String y1 = yearStart.getSelectedItem().toString();
                String d2 = dayEnd.getSelectedItem().toString();
                String m2 = monthEnd.getSelectedItem().toString();
                String y2 = yearEnd.getSelectedItem().toString();

                boolean flag = true;
                if(tenHang.equals("")) tenHang = "NULL";
                if(tenCoSo.equals("Tất cả cơ sở")) tenCoSo = "NULL";
                String date1 = new String();
                if(d1.equals("DD")&&m1.equals("MM")&&y1.equals("YY")) date1 ="1990-01-01";
                else if(!d1.equals("DD")&&!m1.equals("MM")&&!y1.equals("YY")) date1 = y1+"-"+m1+"-"+d1;
                else 
                {
                    JOptionPane.showMessageDialog(rightPanel,"Sai ngày bắt đầu");
                    flag = false;
                }
                String date2 = new String();
                if(d2.equals("DD")&&m2.equals("MM")&&y2.equals("YY")) date2 = "2025-01-01";
                else if(!d2.equals("DD")&&!m2.equals("MM")&&!y2.equals("YY")) date2 = y2+"-"+m2+"-"+d2;
                else 
                {
                    JOptionPane.showMessageDialog(rightPanel,"Sai ngày kết thúc");
                    flag = false;
                }

                if(flag == true)
                {
                    BLLThongKeDonHang bllThongKeDonHang = new BLLThongKeDonHang();
                    ArrayList<DTOThongKeDonHang> dtoThongKeDonHang = bllThongKeDonHang.layDSDLoc(tenHang, tenCoSo, date1, date2);
                    thongKeTheoSoLuong(dtoThongKeDonHang,dsTenCoSo,comboBoxLoai.getSelectedItem().toString(),rightPanel);                    
                }
            }
        });
        if(luaChon.equals("Theo doanh thu"))
        {
            int max = 0;
            for(DTOThongKeDonHang dtoThongKeDonHang : ds)
            if(max<dtoThongKeDonHang.getDoanhThu()) max = dtoThongKeDonHang.getDoanhThu();
            double tiLe ;
            if(max != 0) tiLe = chieuNgang * 1.0 / max;
            else tiLe = 0;
            int y = 0;
            thongKe.setPreferredSize(new Dimension((int) (max * tiLe) + 450, chieuDoc));
            for(int i=0;i<ds.size();i++)
            {
                JPanel thongKe1MonHang = new JPanel(null);
                thongKe1MonHang.setBackground(Color.WHITE);
                thongKe1MonHang.setBounds(20, y, 1000, 75);
                JLabel tenHang = new JLabel(ds.get(i).getTenHangHoa());
                tenHang.setBounds(0, 0, 250, 30);
                tenHang.setFont(new Font("Times New Roman",1,13));
                JLabel cot = new JLabel();
                cot.setBounds(255, 0, (int) (ds.get(i).getDoanhThu()*tiLe) , 30);
                cot.setOpaque(true); // Thêm dòng này để cho phép vẽ nền màu
                cot.setBackground(Color.BLUE);
                JLabel doanhThu = new JLabel(String.valueOf(ds.get(i).getDoanhThu()) + " đ");
                doanhThu.setBounds(cot.getWidth()+tenHang.getWidth()+10,0,200,30);

                thongKe1MonHang.add(tenHang);
                thongKe1MonHang.add(cot);
                thongKe1MonHang.add(doanhThu);
                thongKe.add(thongKe1MonHang);
                y+=75;
            }
            JScrollPane jScrollPane = new JScrollPane(thongKe);
            jScrollPane.setBounds(2, 150, rightPanel.getWidth() - 20, 700);
            rightPanel.add(jScrollPane);
        }
        else
        {
            int max = 0;
            for(DTOThongKeDonHang dtoThongKeDonHang : ds)
            if(max<dtoThongKeDonHang.getSoLuong()) max = dtoThongKeDonHang.getSoLuong();
            double tiLe ;
            if(max != 0) tiLe = chieuNgang * 1.0 / max;
            else tiLe = 0;
            int y = 0;
            thongKe.setPreferredSize(new Dimension((int) (max * tiLe) + 450, chieuDoc));
            for(int i=0;i<ds.size();i++)
            {
                JPanel thongKe1MonHang = new JPanel(null);
                thongKe1MonHang.setBackground(Color.WHITE);
                thongKe1MonHang.setBounds(20, y, 1000, 75);
                JLabel tenHang = new JLabel(ds.get(i).getTenHangHoa());
                tenHang.setBounds(0, 0, 250, 30);
                tenHang.setFont(new Font("Times New Roman",1,13));
                JLabel cot = new JLabel();
                cot.setBounds(255, 0, (int) (ds.get(i).getSoLuong()*tiLe) , 30);
                cot.setOpaque(true); // Thêm dòng này để cho phép vẽ nền màu
                cot.setBackground(Color.BLUE);
                JLabel doanhThu = new JLabel(String.valueOf(ds.get(i).getSoLuong()));
                doanhThu.setBounds(cot.getWidth()+tenHang.getWidth()+10,0,200,30);

                thongKe1MonHang.add(tenHang);
                thongKe1MonHang.add(cot);
                thongKe1MonHang.add(doanhThu);
                thongKe.add(thongKe1MonHang);
                y+=75;
            }
            JScrollPane jScrollPane = new JScrollPane(thongKe);
            jScrollPane.setBounds(2, 150, rightPanel.getWidth() - 20, 700);
            rightPanel.add(jScrollPane);
        }
        
        rightPanel.setBackground(new Color(241,255,250));
    }
}
