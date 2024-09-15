package BLL;

import java.io.File;

public class BLLXuatFileExcel {
	//kiểm tra tên file hợp lệ
	public boolean kiemTraTenFile(String tenFile) {
		if (tenFile.matches("^[^\\\\\\\\/:*?\\\"<>|]{1,255}$")) {
			return true;
		}
		return false;
	}
	
	//kiểm tra trong đường dẫn có file bị trùng không
//	public boolean kiemTraFileTrung(String tenFile, String path) {
//		String fileExtension = ".xlsx";
//		File file = new File(path.trim() + tenFile.trim() + fileExtension);
//		while (file.exists()) {
//			file = new File(folderPath + fileName + "(" + counter + ")" + fileExtension);
//		    counter++;
//		}
//	}
	
	public static boolean kiemTraSheetName(String sheetName) {
        // Kiểm tra độ dài của tên sheet
        if (sheetName.length() > 31) {
            return false;
        }
        
        // Kiểm tra các ký tự không hợp lệ
        String invalidChars = "[:/*?\\[\\]]";
        if (sheetName.matches(".*" + invalidChars + ".*")) {
            return false;
        }

        // Kiểm tra tên trống
        if (sheetName.isEmpty()) {
            return false;
        }

        return true;
    }
}
