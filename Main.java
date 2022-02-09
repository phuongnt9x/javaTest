package th;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	public static void main(String[] args) throws IOException {
		int n;
		String fileName = "dienthoai.csv";
		File file = new File(fileName);
		Scanner sc = new Scanner(System.in);
		int id;
		do {
			System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI –");
			System.out.println("Chọn chức năng theo số (để tiếp tục):");
			System.out.println("1. Thêm mới");
			System.out.println("2. Xóa");
			System.out.println("3. Xem danh sách điện thoại");
			System.out.println("4. Tìm kiếm");
			System.out.println("5. Thoát");
			System.out.println("Chọn chức năng");
			n = sc.nextInt();
			switch (n) {
			case 1:
				themMoi(file);
				break;
			case 2:
				xoaDienThoai(file, sc);
				
				break;
			case 3:
				hienThiDS(file);

				break;
			case 4:
				timKiemDT(file);
				break;
			case 5:
				break;
			default:
				System.out.println("NHap sai so");
			}
		} while (n != 5);

	}

	public static void xoaDienThoai(File file, Scanner sc) throws IOException {
		int id;
		System.out.println("Nhap id dien thoai");
		id=sc.nextInt();
		Boolean found=false;
		List<String> list=new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			while (line != null) {
				list.add(line);
				String s[] = line.split(",");
				if (id==Integer.parseInt(s[0]))
					found=true;
				line = br.readLine();
			}
			int chon;
			if(found==true) {
				System.out.println("Ban muon xoa khong ?(1==co, khac=khong)");
				chon=sc.nextInt();
				if(chon==1) {
					FileWriter fileWriter = new FileWriter(file);
					for(String s:list) {
						String g[] = line.split(",");
						if (id==Integer.parseInt(g[0]))
							continue;
						fileWriter.append(s);
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void hienThiDS(File file) throws IOException {
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void themMoi(File file) {
		Scanner sc = new Scanner(System.in);
		String loaiDienThoai;
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, true);
			System.out.println("Nhap loai dien thoai(chinh hang, xach tay)");
			loaiDienThoai = sc.nextLine();
			DienThoai dienThoai = null;
			int thoiGianBH = -1;
			String phamViBH = "";
			String quocGiaXT = "";
			String trangThai = "";
			if (loaiDienThoai.equals("chinh hang")) {
				System.out.println("Nhap thoi gian bao hanh");
				thoiGianBH = sc.nextInt();
				sc.nextLine();
				do {
					System.out.println("Nhap pham vi bao hanh");
					phamViBH = sc.nextLine();
				} while (!phamViBH.equals("Toan quoc") && !phamViBH.equals("Quoc te"));
				dienThoai = new DienThoaiChinhHang(thoiGianBH, phamViBH);
			} else if (loaiDienThoai.equals("xach tay")) {

				do {
					System.out.println(" Nhap quoc gia sach tay");
					quocGiaXT = sc.nextLine();
				} while (quocGiaXT.equals("Viet Nam"));
				do {
					System.out.println("Trang thai:");
					trangThai = sc.nextLine();
				} while (!trangThai.equals("Da sua chua") || !trangThai.equals("Chua sua chua"));
				dienThoai = new DienThoaiXachTay(quocGiaXT, trangThai);
			}
			System.out.println("Nhap ten dien thoai:");
			dienThoai.setTenDienThoai(sc.nextLine());
			System.out.println("Nhap gia ban:");
			dienThoai.setGiaBan(sc.nextFloat());
			System.out.println("Nhap so luong:");
			dienThoai.setSoLuong(sc.nextInt());
			sc.nextLine();
			System.out.println("Nhap nha SX:");
			dienThoai.setNhaSanXuat(sc.nextLine());
			ghiFileCSV(fileWriter, dienThoai);
			if (loaiDienThoai.equals("chinh hang")) {
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(thoiGianBH));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(phamViBH);
				fileWriter.append(NEW_LINE_SEPARATOR);

			} else if (loaiDienThoai.equals("xach tay")) {
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(quocGiaXT);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(trangThai);
				fileWriter.append(NEW_LINE_SEPARATOR);

			}
			DienThoai.id++;
			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}

	public static void ghiFileCSV(FileWriter fileWriter, DienThoai dienThoai) throws IOException {
		fileWriter.append(String.valueOf(dienThoai.getId()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(dienThoai.getTenDienThoai());
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(dienThoai.getGiaBan()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(dienThoai.getSoLuong()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(dienThoai.getNhaSanXuat());
	}

	public static void timKiemDT(File file) throws IOException {
		String tenDienThoai = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten dien thoai");
		tenDienThoai = sc.nextLine();
		System.out.println("Danh sach tim kiem");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			while (line != null) {
				String s[] = line.split(",");
				if (Pattern.matches(tenDienThoai, s[1]))
					System.out.println(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
