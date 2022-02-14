import java.util.Scanner;

public class PhanLoaiDienThoai {
	public static final String CHUA_SUA_CHUA = "Chua sua chua";
	public static final String DA_SUA_CHUA = "Da sua chua";
	public static final String VIET_NAM = "Viet Nam";
	public static final String XACH_TAY = "xach tay";
	public static final String QUOC_TE = "Quoc te";
	public static final String TOAN_QUOC = "Toan quoc";
	public static final String CHINH_HANG = "chinh hang";
	Scanner scanner=new Scanner(System.in);
	public DienThoai getDienThoai(String type,int id) {
		if (CHINH_HANG.equalsIgnoreCase(type)) {
			return new DienThoaiChinhHang(id,nhapTenDienThoai(),nhapGiaBan(),nhapSoLuong(),nhapNhaSX(),nhapThoiGianBH(),nhapPhamViBH());
		} else if (XACH_TAY.equalsIgnoreCase(type)) {
			return new DienThoaiXachTay(id,nhapTenDienThoai(),nhapGiaBan(),nhapSoLuong(),nhapNhaSX(),nhapQuocGiaXT(),nhapTrangThai());
		}
		return null;
	}

	public String nhapTenDienThoai() {
		String ten = "";
		do {
			System.out.print("Nhap ten dien thoai: ");
			ten = scanner.nextLine();
		} while (ten.equals(""));
		return ten;
	}
	public String nhapNhaSX() {
		String tenNhaSX = "";
		do {
			System.out.print("Nhap nha san xuat dien thoai: ");
			tenNhaSX = scanner.nextLine();
		} while (tenNhaSX.equals(""));
		return tenNhaSX;
	}

	public Float nhapGiaBan() {
		Float giaBan = 0f;
		boolean check = false;
		do {
			System.out.println("Nhap gia dien thoai: ");
			giaBan = scanner.nextFloat();
			if (giaBan > 0) {
				check = true;
			} else {
				System.out.println("Gia ban phai > 0");
			}
		} while (!check);
		return giaBan;
	}

	public int nhapSoLuong() {
		int soLuong = 0;
		boolean check = false;
		do {
			System.out.println("Nhap so luong dien thoai: ");
			soLuong = scanner.nextInt();
			scanner.nextLine();
			if (soLuong > 0) {
				check = true;
			} else {
				System.out.println("So luong phai > 0");
			}
		} while (!check);
		return soLuong;
	}

	public int nhapThoiGianBH() {
		int thoiGianBH = 0;
		boolean check = false;
		do {
			System.out.print("Nhap thoi gian bao hanh(ngay): ");
			thoiGianBH = scanner.nextInt();
			scanner.nextLine();
			if (thoiGianBH > 0 && thoiGianBH <= 730) {
				check = true;
			} else {
				System.out.println("Thoi gian bao hanh phai > 0 va < 730 ngay");
			}

		} while (!check);
		return thoiGianBH;
	}

	public String nhapPhamViBH() {
		String phamViBH = "";
		boolean check = false;
		do {
			System.out.print("Nhap pham vi bao hanh(toan quoc, quoc te): ");
			phamViBH = scanner.nextLine();
			if (phamViBH.equalsIgnoreCase(TOAN_QUOC) || phamViBH.equalsIgnoreCase(QUOC_TE)) {
				check = true;
			} else {
				System.out.println("Pham vi bao hanh chi co the la toan quoc hoac quoc te");
			}
		} while (!check);
		return phamViBH;
	}
	public String nhapQuocGiaXT() {
		String quocGiaXT = "";
		boolean check = false;
		do {
			System.out.print("Nhap quoc gia xach tay: ");
			quocGiaXT = scanner.nextLine();
			if (!quocGiaXT.equalsIgnoreCase(VIET_NAM)) {
				check = true;
			} else {
				System.out.println("Quoc gia xach tay khong duoc la Viet Nam");
			}
		} while (!check);
		return quocGiaXT;
	}
	public String nhapTrangThai() {
		String trangThai = "";
		boolean check = false;
		do {
			System.out.print("Nhap trang thai dien thoai(Da sua chua, Chua sua chua): ");
			trangThai = scanner.nextLine();
			if (trangThai.equalsIgnoreCase(DA_SUA_CHUA) || trangThai.equalsIgnoreCase(CHUA_SUA_CHUA)) {
				check = true;
			} else {
				System.out.println("Pham vi bao hanh chi co the la toan quoc hoac quoc te");
			}
		} while (!check);
		return trangThai;
	}


}
