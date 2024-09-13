package BLL;

import java.util.ArrayList;

import DAL.DataPhanQuyen;
import DTO.DTOChucNang;
import DTO.DTOQuyen;

public class BLLPhanQuyen {
	private DataPhanQuyen dataPhanQuyen; 
	public BLLPhanQuyen() {
		this.dataPhanQuyen = new DataPhanQuyen();
	}
	public ArrayList<DTOQuyen> layDSNguoiDung(){
		return dataPhanQuyen.layDSTenPhanQuyen();
	}
	public ArrayList<DTOChucNang> layDSChucNang(){
		return dataPhanQuyen.layDSChucNang();
	}
	public ArrayList<DTOChucNang> layDsCNTheoIDQuyen(String iDQuyen){
		return dataPhanQuyen.layDsChucNangTheoIDQuyen(iDQuyen);
	}
}
