package GUI;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DTO.DTOTaiKhoan;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIUser extends JFrame {
	//logo
    ImageIcon logo = new ImageIcon("src/asset/img/label/logo.png");
    Image scaleLogoIcon = logo.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
    ImageIcon logo1 = new ImageIcon("src/asset/img/label/logo1.png");
    
    //icon chức năng thống kê
    ImageIcon analyticsIcon = new ImageIcon("src/asset/img/icon/analytics-icon.png");
    Image scaleAnalyticsIcon = analyticsIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon chức năng danh sách
    ImageIcon checkListIcon = new ImageIcon("src/asset/img/icon/checklist-icon.png");
    Image scaleCheckListIcon = checkListIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon tiêu đề phụ chức năng
    ImageIcon managementIcon = new ImageIcon("src/asset/img/icon/project-management-icon.png");
    Image scaleManagementIcon = managementIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);

    ImageIcon upArrowIcon = new ImageIcon("src/asset/img/icon/up-Arrow-icon.png");
    Image scaleUpArrowIcon = upArrowIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    ImageIcon downArrowIcon = new ImageIcon("src/asset/img/icon/down-Arrow-icon.png");
    Image scaleDownArrowIcon = downArrowIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập thiết bị
    ImageIcon dumbbellIcon = new ImageIcon("src/asset/img/icon/dumbbell-icon.png");
    Image scaleDumbbellIcon = dumbbellIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập hàng hóa
    ImageIcon goodsIcon = new ImageIcon("src/asset/img/icon/goods-icon.png");
    Image scaleGoodsIcon = goodsIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);

    //icon chức năng duyệt đơn hàng
    ImageIcon billIcon = new ImageIcon("src/asset/img/icon/bill-icon.png");
    Image scaleBillIcon = billIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon chức năng thống kê doanh thu
    ImageIcon chartIcon = new ImageIcon("src/asset/img/icon/stonk-icon.jpg");
    Image scaleChartIcon = chartIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    public GUIUser(DTOTaiKhoan tk) {
		this.setSize(1600, 900);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        
        JPanel managementPanel = new JPanel();
        managementPanel.setLayout(null);
        managementPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
        		"Chức năng", TitledBorder.LEADING, TitledBorder.TOP, new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30), new Color(240, 255, 255)));
        managementPanel.setBackground(new Color(135, 206, 250));
        managementPanel.setBounds(25, 245, 352, 526);
        getContentPane().add(managementPanel);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 255, 255));
        rightPanel.setBorder(new LineBorder(new Color(64, 0, 64), 2));
        rightPanel.setBounds(400, 0, 1200, 900);
        
        JButton listBTN = new JButton("Quản lý danh sách");
        listBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
                rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
                rightPanel.repaint(); // Vẽ lại JPanel
                xuLyDanhSach();
        	}
        });
        listBTN.setSelectedIcon(null);
        listBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        listBTN.setFocusPainted(false);
        listBTN.setBounds(23, 42, 300, 50);
        managementPanel.add(listBTN);
        
        JButton billBTN = new JButton("Duyệt đơn hàng");
        billBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        billBTN.setFocusPainted(false);
        billBTN.setBounds(23, 103, 300, 50);
        managementPanel.add(billBTN);
        
        JButton goodsBTN = new JButton("Nhập thiết bị");
        goodsBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        goodsBTN.setFocusPainted(false);
        goodsBTN.setBounds(23, 164, 300, 50);
        managementPanel.add(goodsBTN);
        
        JButton statBTN = new JButton("Thống kê đơn hàng");
        statBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        statBTN.setFocusPainted(false);
        statBTN.setBounds(23, 225, 300, 50);
        managementPanel.add(statBTN);
        
        JButton delegationBTN = new JButton("Phân quyền");
        delegationBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        delegationBTN.setBounds(23, 408, 300, 50);
        managementPanel.add(delegationBTN);
        
        JButton employeeMNG = new JButton("Quản lý nhân viên");
        employeeMNG.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        employeeMNG.setBounds(23, 286, 300, 50);
        managementPanel.add(employeeMNG);
        
        JButton memberMNG = new JButton("Quản lý hội viên");
        memberMNG.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        memberMNG.setBounds(23, 347, 300, 50);
        managementPanel.add(memberMNG);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new LineBorder(new Color(64, 0, 64), 2));
        leftPanel.setBackground(new Color(0, 191, 91));
        leftPanel.setBounds(0, 0, 400, 900);
        getContentPane().add(leftPanel);
        leftPanel.setLayout(null);
        
        JLabel currUserLB = new JLabel("Người dùng hiện tại: ");
        currUserLB.setBounds(26, 220, 186, 26);
        currUserLB.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        leftPanel.add(currUserLB);
        
        JLabel leftLabel = new JLabel();
        leftLabel.setBounds(49, 0, 300, 200);
        leftLabel.setIcon(new ImageIcon("src/asset/img/label/logo1.png"));
        leftPanel.add(leftLabel);
        
        JButton logOutBTN = new JButton("Đăng xuất");
        logOutBTN.setBounds(10, 786, 146, 37);
        leftPanel.add(logOutBTN);
        logOutBTN.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        
        
        getContentPane().add(rightPanel);
        this.setIconImage(logo.getImage());
        this.setVisible(true);
	}
	public static void main(String[] args) {
		DTOTaiKhoan tKhoan = new DTOTaiKhoan("TK500", "TKHV500", "MKHV500", "Q0001");
        new GUIUser(tKhoan);
    }
}
