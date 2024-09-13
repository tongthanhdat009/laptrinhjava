package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTOChucNang;
import DTO.DTOQuyen;

public class DataPhanQuyen {
	private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    
    public ArrayList<String> layDSPhanQuyen() {
		ArrayList<String> ds = new ArrayList<String>();
        String query = "SELECT DISTINCT q.IDQuyen, From PhanQuyen pq, Quyen q, ChucNang cn WHERE pq.IDQuyen = q.IDQuyen AND pq.IDChucNang = cn.IDChucNang";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    
    public ArrayList<DTOChucNang> layDSChucNang() {
		ArrayList<DTOChucNang> ds = new ArrayList<DTOChucNang>();
        String query = "SELECT DISTINCT cn.IDChucNang,cn.TenChucNang From PhanQuyen pq, Quyen q, ChucNang cn WHERE pq.IDQuyen = q.IDQuyen AND pq.IDChucNang = cn.IDChucNang";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(new DTOChucNang (rs.getString(1),rs.getString(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
	
    public ArrayList<DTOQuyen> layDSTenPhanQuyen() {
		ArrayList<DTOQuyen> ds = new ArrayList<DTOQuyen>();
        String query = "SELECT DISTINCT  pq.IDQuyen, q.TenQuyen From PhanQuyen pq, Quyen q, ChucNang cn WHERE pq.IDQuyen = q.IDQuyen AND pq.IDChucNang = cn.IDChucNang";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(new DTOQuyen(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    
    public ArrayList<DTOChucNang> layDsChucNangTheoIDQuyen(String iDQuyen){
    	ArrayList<DTOChucNang> ds = new ArrayList<DTOChucNang>();
        String query = "SELECT pq.IDChucNang, cn.TenChucNang From PhanQuyen pq, Quyen q, ChucNang cn WHERE pq.IDQuyen = q.IDQuyen AND pq.IDChucNang = cn.IDChucNang AND pq.IDQuyen = '"+iDQuyen+"'";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(new DTOChucNang(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    
}
