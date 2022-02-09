package th;

public class DienThoaiXachTay extends DienThoai {
	private String quocGia;
	private String trangThai;

	public String getQuocGia() {
		return quocGia;
	}

	public DienThoaiXachTay(String quocGia, String trangThai) {
		this.quocGia = quocGia;
		this.trangThai = trangThai;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return getId() + "," + getTenDienThoai() + "," + getGiaBan() + "," + getSoLuong() + "," + getNhaSanXuat() + ","
				+ getQuocGia() + "," + getTrangThai();
	}

}
