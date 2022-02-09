package th;

public abstract class DienThoai {
	static int id=1;
	private String tenDienThoai;
	private float giaBan;
	private int soLuong;
	private String nhaSanXuat;
	public DienThoai() {
	}
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}
	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}
	public int getId() {
		return id;
	}
	public String getTenDienThoai() {
		return tenDienThoai;
	}
	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return getId()+","+getTenDienThoai()+","+getGiaBan()+","+getSoLuong()+","+getNhaSanXuat();
	}

}
