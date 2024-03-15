package laptrinhjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoSo {
    private String maCoSo;
    private String diaChi;
    private String std;
    private static String tenCoSo = "Gym SGU";
    private static int soLuongCoSo = 0;
    public CoSo()
    {
        maCoSo = String.valueOf(++soLuongCoSo);
        diaChi = "NULL";
        std = "NULL";
    }
    public CoSo(String diaChi, String std)
    {
        setStd(std);
        maCoSo = String.valueOf(++soLuongCoSo);
        setDiaChi(diaChi);
    }
    public String getDiaChi() {
        return diaChi;
    }
    public String getMaCoSo() {
        return maCoSo;
    }
    public static int getSoLuongCoSo() {
        return soLuongCoSo;
    }
    public String getStd() {
        return std;
    }
    public static String getTenCoSo() {
        return tenCoSo;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public void setStd(String std) {
        String regex = "(^0|^84)[0-9]{9,11}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(std);
        if(matcher.matches()) this.std = std;
        else throw new IllegalArgumentException("Số điện thoại không hợp lệ");
    }
    public String toString()
    {
        return maCoSo+" "+diaChi+" "+std+" "+tenCoSo;
    }
}