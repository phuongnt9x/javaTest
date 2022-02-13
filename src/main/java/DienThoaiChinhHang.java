
public class DienThoaiChinhHang extends DienThoai {
	int thoiGianBaoHanh;
	String phamViBaoHanh;

	public DienThoaiChinhHang(String tenDienThoai, float giaBan, int soLuong, String nhaSanXuat, int thoiGianBaoHanh,
			String phamViBaoHanh) {
		super(tenDienThoai, giaBan, soLuong, nhaSanXuat);
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.phamViBaoHanh = phamViBaoHanh;
		id++;
	}

	public DienThoaiChinhHang() {

	}

	@Override
	public String xuatDuLieu() {
		return id + "," + tenDienThoai + "," + giaBan + "," + soLuong + "," + nhaSanXuat + "," + thoiGianBaoHanh + ","
				+ phamViBaoHanh;
	}

	@Override
	public String toString() {
		return "DienThoaiChinhHang [thoiGianBaoHanh=" + thoiGianBaoHanh + ", phamViBaoHanh=" + phamViBaoHanh
				+ ", tenDienThoai=" + tenDienThoai + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", nhaSanXuat="
				+ nhaSanXuat + "]";
	}

}
