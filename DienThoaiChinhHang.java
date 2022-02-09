package th;

public class DienThoaiChinhHang extends DienThoai {
	private int thoiGianBaoHanh;

	public DienThoaiChinhHang(int thoiGianBaoHanh, String phamViBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.phamViBaoHanh = phamViBaoHanh;
	}

	public DienThoaiChinhHang() {
	}

	private String phamViBaoHanh;

	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public String getPhamViBaoHanh() {
		return phamViBaoHanh;
	}

	public void setPhamViBaoHanh(String phamViBaoHanh) {
		this.phamViBaoHanh = phamViBaoHanh;
	}

	@Override
	public String toString() {
		return getId() + "," + getTenDienThoai() + "," + getGiaBan() + "," + getSoLuong() + "," + getNhaSanXuat() + ","
				+ getThoiGianBaoHanh() + "," + getPhamViBaoHanh();
	}

}
