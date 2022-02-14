
public class DienThoaiXachTay extends DienThoai {
	String quocGia;
	String trangThai;

	public DienThoaiXachTay() {
		super();
	}

	public DienThoaiXachTay(int id,String tenDienThoai, float giaBan, int soLuong, String nhaSanXuat, String quocGia,
			String trangThai) {
		super(id,tenDienThoai, giaBan, soLuong, nhaSanXuat);
		this.quocGia = quocGia;
		this.trangThai = trangThai;
		id++;
	}

	@Override
	public String xuatDuLieu() {
		return id + "," + tenDienThoai + "," + giaBan + "," + soLuong + "," + nhaSanXuat + "," + quocGia + ","
				+ trangThai +","+ PhanLoaiDienThoai.XACH_TAY+"\n";
	}

	@Override
	public String toString() {
		return "DienThoaiXachTay [tenDienThoai=" + tenDienThoai
				+ ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", nhaSanXuat=" + nhaSanXuat +", quocGia=" + quocGia + ", trangThai=" + trangThai +"]";
	}

}
