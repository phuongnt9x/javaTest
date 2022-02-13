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
	File file = new File(FILE_NAME);
	Scanner scanner=new Scanner(System.in);

	public void xoaDienThoai() throws IOException, NotFoundProductException {
		int id;
		Boolean found = false;
		do {
			System.out.println("Nhap id dien thoai");
			id = scanner.nextInt();
			found = kiemTraID(id);
			if (found == false) {
				throw new NotFoundProductException();
			}
		} while (found == false);
		try {
			int chon;
			System.out.println("Ban muon xoa khong ?(1==co, khac=khong)");
			chon = scanner.nextInt();
			if (chon == 1) {
				List<String> lisStrings = fileToList();
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fileWriter);
				for (String line : lisStrings) {
					String g[] = line.split(",");
					if (id == Integer.parseInt(g[0]))
						continue;
					bw.write(line);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean kiemTraID(int id) throws IOException {
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			while (line != null) {
				String s[] = line.split(",");
				if (id == Integer.parseInt(s[0]))
					return true;
				line = br.readLine();
			}
			br.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> fileToList() throws IOException {
		List<String> list = new ArrayList<String>();
		try {
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
		System.out.println("Chon loai dien thoai(chinh hang, xach tay): ");
		loaiDienThoai = scanner.nextLine();
		DienThoai dienThoai = phanLoaiDienThoai.getDienThoai(loaiDienThoai);
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		bw.write(dienThoai.xuatDuLieu());
		bw.close();
		System.out.println("Them dien thoai thanh cong !!!");

	}
	public void hienThiDS() throws IOException {
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public List<String> timKiemDT() throws IOException {
		List<String> listDT=fileToList();
		String tenDienThoai = "";
		List<String> listTimKiem=new ArrayList();
		System.out.println("Nhap ten dien thoai");
		tenDienThoai = scanner.nextLine();
		for(String dienThoai:listDT) {
			String s[] = dienThoai.split(",");
			if (Pattern.matches(tenDienThoai, s[1]))
				listTimKiem.add(dienThoai);
		}


		return listTimKiem;
	}
	public void layIdTrongFile() throws IOException {
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			int id = 0;
			String line = br.readLine();
			while (line != null) {
				String s[] = line.split(",");
				id = Integer.parseInt(s[0]);
				if (DienThoai.id < id)
					DienThoai.id = id;
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}
