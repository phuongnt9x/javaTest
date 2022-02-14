public abstract class DienThoai {
	int id;
	String tenDienThoai;
	float giaBan;
	int soLuong;
	String nhaSanXuat;

	public DienThoai() {
	}

	public DienThoai(int id,String tenDienThoai, float giaBan, int soLuong, String nhaSanXuat) {
		this.id=id;
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