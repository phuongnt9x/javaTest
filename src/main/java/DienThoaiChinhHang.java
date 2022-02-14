
public class DienThoaiChinhHang extends DienThoai {
	int thoiGianBaoHanh;
	String phamViBaoHanh;

	public DienThoaiChinhHang(int id,String tenDienThoai, float giaBan, int soLuong, String nhaSanXuat, int thoiGianBaoHanh,
			String phamViBaoHanh) {
		super(id,tenDienThoai, giaBan, soLuong, nhaSanXuat);
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.phamViBaoHanh = phamViBaoHanh;
	}

	public DienThoaiChinhHang() {

	}

	@Override
	public String xuatDuLieu() {
		return id + "," + tenDienThoai + "," + giaBan + "," + soLuong + "," + nhaSanXuat + "," + thoiGianBaoHanh + ","
				+ phamViBaoHanh+","+PhanLoaiDienThoai.CHINH_HANG+"\n";
	}

	@Override
	public String toString() {
		return "DienThoaiChinhHang [TenDienThoai=" + tenDienThoai + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", nhaSanXuat="
				+ nhaSanXuat +"thoiGianBaoHanh=" + thoiGianBaoHanh + ", phamViBaoHanh=" + phamViBaoHanh+ "]";
	}

}
