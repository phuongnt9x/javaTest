import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QuanLyDienThoai {
	public static final String FILE_NAME = "dienthoai.csv";
	Scanner scanner = new Scanner(System.in);
	List<DienThoai> listDT = new ArrayList<DienThoai>();

	public QuanLyDienThoai() throws IOException {
		fileToListDT();
	}

	public void xoaDienThoai() throws IOException, NotFoundProductException {
		int id;
		DienThoai found = null;
		do {
			System.out.println("Nhap id dien thoai");
			id = scanner.nextInt();
			found = timKiemDT_Id(id);
			if (found == null) {
				throw new NotFoundProductException();
			}
		} while (found == null);
		try {
			int chon;
			System.out.println("Ban muon xoa khong ?(1==co, khac=khong)");
			chon = scanner.nextInt();
			if (chon == 1) {
				listDT.remove(found);
				List<String> lisStrings = fileToListString();
				File file = new File(FILE_NAME);
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fileWriter);
				for(DienThoai dienThoai:listDT) {
					bw.write(dienThoai.xuatDuLieu());
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean kiemTraID(int id) {
		for (DienThoai dienThoai : listDT) {
			if (id == dienThoai.id) {
				return true;
			}
		}
		return false;
	}
	public DienThoai timKiemDT_Id(int id) {
		for (DienThoai dienThoai : listDT) {
			if (id == dienThoai.id) {
				return dienThoai;
			}
		}
		return null;
	}

	public List<String> fileToListString() throws IOException {
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(FILE_NAME);
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			while (line != null) {
				list.add(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void themMoi() throws IOException {
		String loaiDienThoai;
		PhanLoaiDienThoai phanLoaiDienThoai = new PhanLoaiDienThoai();
		do {
			System.out.println("Chon loai dien thoai(chinh hang, xach tay): ");
			loaiDienThoai = scanner.nextLine();
		}while(!loaiDienThoai.equals(phanLoaiDienThoai.CHINH_HANG) && !loaiDienThoai.equals(phanLoaiDienThoai.XACH_TAY) );
		DienThoai dienThoai = phanLoaiDienThoai.getDienThoai(loaiDienThoai,tangID());
		listDT.add(dienThoai);
		File file = new File(FILE_NAME);
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		bw.write(dienThoai.xuatDuLieu());
		bw.close();
		System.out.println("Them dien thoai thanh cong !!!");

	}

	public void hienThiDS() throws IOException {
		for (DienThoai dienThoai : listDT) {
			System.out.println(dienThoai.toString());
		}
	}

	public List<DienThoai> timKiemDT() {
		String tenDienThoai = "";
		List<DienThoai> listTimKiem = new ArrayList<DienThoai>();
		System.out.println("Nhap ten dien thoai");
		tenDienThoai = scanner.nextLine();
		String pattern=".*"+tenDienThoai+".*";
		for (DienThoai dienThoai : listDT) {
			if (dienThoai.tenDienThoai.matches(pattern))
				listTimKiem.add(dienThoai);
		}

		return listTimKiem;
	}

	public List<DienThoai> fileToListDT() throws IOException {
		try {
			File file = new File(FILE_NAME);
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			while (line != null) {
				String s[] = line.split(",");
				if (PhanLoaiDienThoai.CHINH_HANG.equalsIgnoreCase(s[7])) {
					listDT.add(new DienThoaiChinhHang(Integer.parseInt(s[0]), s[1], Float.parseFloat(s[2]),
							Integer.parseInt(s[3]), s[4], Integer.parseInt(s[5]), s[6]));
				} else if (PhanLoaiDienThoai.XACH_TAY.equalsIgnoreCase(s[7])) {
					listDT.add(new DienThoaiXachTay(Integer.parseInt(s[0]), s[1], Float.parseFloat(s[2]),
							Integer.parseInt(s[3]), s[4], s[5], s[6]));
				}
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listDT;
	}

	public int tangID() {
		int id = 0;
		for (DienThoai dienThoai : listDT) {
			if (id < dienThoai.id) {
				id = dienThoai.id;
			}
		}
		return ++id;
	}

}
