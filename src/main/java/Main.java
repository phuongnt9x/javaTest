import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		int chucNang;
		Scanner scanner = new Scanner(System.in);
		QuanLyDienThoai qLyDienThoai = new QuanLyDienThoai();
		qLyDienThoai.layIdTrongFile();
		do {
			hienThiMenu();
			chucNang = scanner.nextInt();
			switch (chucNang) {
			case 1:
				qLyDienThoai.themMoi();
				break;
			case 2:
				try {
				qLyDienThoai.xoaDienThoai();
				}catch(NotFoundProductException e) {
					System.out.println(e);
				}
				break;
			case 3:
				System.out.println("Danh sach dien thoai");
				qLyDienThoai.hienThiDS();
				break;
			case 4:
				List<String> listTK=qLyDienThoai.timKiemDT();
				if(listTK==null) {
					System.out.println("Khong tim thay");
				}else {
					System.out.println("Danh sach tim kiem");
					for(String dienThoai:listTK) {
						System.out.println(dienThoai);
					}
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Nhap sai so");
			}
		} while (chucNang != 5);

	}

	public static void hienThiMenu() {
		System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI –");
		System.out.println("Chọn chức năng theo số (để tiếp tục):");
		System.out.println("1. Thêm mới");
		System.out.println("2. Xóa");
		System.out.println("3. Xem danh sách điện thoại");
		System.out.println("4. Tìm kiếm");
		System.out.println("5. Thoát");
		System.out.println("Chọn chức năng");
	}

}