
public class DienThoaiXachTay extends DienThoai {
	String quocGia;
	String trangThai;

	public DienThoaiXachTay() {
		super();
	}

	public DienThoaiXachTay(String tenDienThoai, float giaBan, int soLuong, String nhaSanXuat, String quocGia,
			String trangThai) {
		super(tenDienThoai, giaBan, soLuong, nhaSanXuat);
		this.quocGia = quocGia;
		this.trangThai = trangThai;
		id++;
	}

	@Override
	public String xuatDuLieu() {
		return id + "," + tenDienThoai + "," + giaBan + "," + soLuong + "," + nhaSanXuat + "," + quocGia + ","
				+ trangThai;
	}

	@Override
	public String toString() {
		return "DienThoaiXachTay [quocGia=" + quocGia + ", trangThai=" + trangThai + ", tenDienThoai=" + tenDienThoai
				+ ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", nhaSanXuat=" + nhaSanXuat + "]";
	}

}
