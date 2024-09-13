package DTO;

public class Xa extends LoaiThietBi {
    private String loaiXa;
    private String chatLieu;
    private float chieuDai;
    private float duongKinh;
    private float chieuCao;
    private float taiTrong;

    // Constructor của lớp Xa
    public Xa(String maThietBi, String tenThietBi, String hinhAnh, String giaThietBi, int ngayBaoHanh, String loai,
              String loaiXa, String chatLieu, float chieuDai, float duongKinh, float chieuCao, float taiTrong) {
        super(maThietBi, tenThietBi, hinhAnh, giaThietBi, ngayBaoHanh, loai); // Gọi constructor của lớp cha
        this.loaiXa = loaiXa;
        this.chatLieu = chatLieu;
        this.chieuDai = chieuDai;
        this.duongKinh = duongKinh;
        this.chieuCao = chieuCao;
        this.taiTrong = taiTrong;
    }

    // Getter và Setter cho các thuộc tính
    public String getLoaiXa() {
        return loaiXa;
    }

    public void setLoaiXa(String loaiXa) {
        this.loaiXa = loaiXa;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public float getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(float chieuDai) {
        this.chieuDai = chieuDai;
    }

    public float getDuongKinh() {
        return duongKinh;
    }

    public void setDuongKinh(float duongKinh) {
        this.duongKinh = duongKinh;
    }

    public float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public float getTaiTrong() {
        return taiTrong;
    }

    public void setTaiTrong(float taiTrong) {
        this.taiTrong = taiTrong;
    }
}
