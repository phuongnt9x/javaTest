public abstract class DienThoai {
	static int id = 0;
	String tenDienThoai;
	float giaBan;
	int soLuong;
	String nhaSanXuat;

	public DienThoai() {
	}

	public DienThoai(String tenDienThoai, float giaBan, int soLuong, String nhaSanXuat) {
		this.tenDienThoai = tenDienThoai;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.nhaSanXuat = nhaSanXuat;
	}

	@Override
	public String toString() {
		return "DienThoai [tenDienThoai=" + tenDienThoai + ", giaBan=" + giaBan + ", soLuong=" + soLuong
				+ ", nhaSanXuat=" + nhaSanXuat + "]";
	}

	abstract public String xuatDuLieu();

}