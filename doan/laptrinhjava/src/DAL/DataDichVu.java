package DAL;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.dichVu;

public class DataDichVu {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public ArrayList<String> tenCot = new ArrayList<String>();
	private Component GUIAdmin;
    
    public DataDichVu()
    {
        try{
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public ArrayList<String> getTenCot(){
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DichVu");
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i=1; i<=rsmd.getColumnCount();i++){
                this.tenCot.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this.tenCot; 
    }
    public ArrayList<dichVu> layDanhSachDichVu()
    {
        ArrayList<dichVu> dsDichVu = new ArrayList<>();
        String truyVan = "SELECT * FROM DichVu";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            dsDichVu.add(new dichVu(rs.getString("MaDV"),rs.getString("TenDV"),rs.getLong("GiaDV"),rs.getInt("ThoiGian"),rs.getString("MoTa"),rs.getString("HinhAnh")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return dsDichVu;
    }
    public boolean themDV(dichVu dv) {
    	String check_madv = "SELECT * FROM DichVu WHERE MaDV = ?";
    	String query= "INSERT INTO DichVu (MaDV, TenDV, GiaDV, ThoiGian, MoTa, HinhAnh) VALUES (?,?,?,?,?,?) ";
    	try {
    		PreparedStatement ps_check = con.prepareStatement(check_madv);
    		ps_check.setString(1, dv.getMaDichVu());
    		ResultSet rs = ps_check.executeQuery();
    		while(rs.next()) {
    			JOptionPane.showMessageDialog(GUIAdmin,"Mã dịch vụ đã tồn tại","Error",JOptionPane.ERROR_MESSAGE );
    			return false;
    		}
    		
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dv.getMaDichVu());
			ps.setString(2, dv.getTenDichVu());
			ps.setLong(3, dv.getGiaDichVu());
			ps.setInt(4, dv.getThoiGian());
			ps.setString(5, dv.getMoTa());
			ps.setString(6, dv.getHinhAnh());
			int n = ps.executeUpdate();
			if(n != 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return false;
    }
    public boolean xoaDV(String madv) {
    	String query = "DELETE FROM DichVu WHERE MaDV = ?";
    	try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, madv);
			int check = ps.executeUpdate();
			if(check > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return false;
    }
    public boolean suaDV(dichVu dv) {
    	String query = "UPDATE DichVu SET TenDV = ?, GiaDV = ?, ThoiGian = ?, MoTa = ?, HinhAnh = ? WHERE MaDV = ?";
    	
    	try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dv.getTenDichVu());
			ps.setLong(2, dv.getGiaDichVu());
			ps.setInt(3, dv.getThoiGian());
			ps.setString(4, dv.getMoTa());
			ps.setString(5, dv.getHinhAnh());
			ps.setString(6, dv.getMaDichVu());
			int check = ps.executeUpdate();
			if(check > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return false;
    }
    public ArrayList<dichVu> timkiemDV(String madv){
    	ArrayList<dichVu> result = new ArrayList<>();
    	String query = "SELECT * FROM DichVu WHERE MaDV = ?";
    	try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, madv);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dichVu dv = new dichVu(
						rs.getString("MaDV"),
						rs.getString("TenDV"),
						rs.getLong("GiaDV"),
						rs.getInt("ThoiGian"),
						rs.getString("MoTa"),
						rs.getString("HinhAnh")
						);
				result.add(dv);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return result;
    }
	private boolean kiemTraTonTaiMaDV(String maDV) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS Count FROM DichVu WHERE MaDV = ?");
            ps.setString(1, maDV);
            ResultSet rsExist = ps.executeQuery();
            if (rsExist.next()) {
                int count = rsExist.getInt("Count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	public String taoMaDichvuMoi() {
        try {
            // Tìm mã dịch viên lớn nhất
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(MaDV) AS MaxMaDV FROM DichVu");

            // Lấy mã lớn nhất
            String maxMaDV = "DV001";
            if (rs.next()) {
                String maxMaDVFromDB = rs.getString("MaxMaDV");
                if (maxMaDVFromDB != null) {
                    int nextMaDV = Integer.parseInt(maxMaDVFromDB.substring(2)) + 1;
                    String newMaDV;
                    boolean unique = false;
                    while (!unique) {
                    	newMaDV = String.format("DV%03d", nextMaDV);
                        // Kiểm tra xem mã mới có duy nhất không
                        if (!kiemTraTonTaiMaDV(newMaDV)) {
                        	maxMaDV = newMaDV;
                            unique = true;
                        }
                        nextMaDV++;
                    }
                }
            }
            return maxMaDV; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
}