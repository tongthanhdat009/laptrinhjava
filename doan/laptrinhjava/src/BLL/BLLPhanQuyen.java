package BLL;

import java.util.ArrayList;

import DAL.DataPhanQuyen;
import DTO.DTOChucNang;
import DTO.DTOPhanQuyen;
import DTO.DTOQuyen;

public class BLLPhanQuyen {
	private DataPhanQuyen dataPhanQuyen; 
	public BLLPhanQuyen() {
		this.dataPhanQuyen = new DataPhanQuyen();
	}
	public ArrayList<DTOQuyen> layDSNguoiDung(){
		return dataPhanQuyen.layDSTenPhanQuyen();
	}
	//lấy danh sách chức năng
	public ArrayList<DTOChucNang> layDSChucNang(){
		return dataPhanQuyen.layDSChucNang();
	}
	//lấy danh sách chức năng theo IDQuyền
	public ArrayList<DTOChucNang> layDsCNTheoIDQuyen(String iDQuyen){
		return dataPhanQuyen.layDsChucNangTheoIDQuyen(iDQuyen);
	}
	//lấy danh sách chức năng chưa có theo IDQuyen
	public ArrayList<DTOChucNang> layDsCNChuaCoTheoIDQuyen(String iDQuyen){
		return dataPhanQuyen.layDsChucNangChuaCoTheoIDQuyen(iDQuyen);
	}
	
	//Xóa phân quyền
	public Boolean xoaPhanQuyen(DTOPhanQuyen pq) {
		return dataPhanQuyen.xoaPQ(pq);
	}

	//thêm phân quyền
	public boolean themPhanQuyen(DTOPhanQuyen pq) {
		return dataPhanQuyen.themPQ(pq);
	}
}
