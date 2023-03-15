package lesson024;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class FileIslemler {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		FileIslemler fileIslemler = new FileIslemler();
		fileIslemler.menu();

	}

	public void menu() {

		int input = 0;
		do {
			System.out.println("0- Çıkış");
			System.out.println("1- Dosya Oluştur");
			System.out.println("2- Ekle");
			System.out.println("3- Okuma");
			System.out.println("4- Dosya Silme");
			System.out.println("Lütfen işleminizi Seçiniz");
			input = sc.nextInt();
			switch (input) {
			case 1:
				try {
					dosyaOlustur(FileSabitler.file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				dosyayaYaz(FileSabitler.file);
				break;
			case 3:
				doysayadanOku(FileSabitler.file);
				break;
			case 4:
				dosyaSilme(FileSabitler.file);
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Lütfen Geçerli Bir Sayı Girin (0-4)!!!!!");
				break;
			}
		} while (input != 0);

	}

	private void dosyaSilme(File file) {
		if (file.exists()) {
			System.out.println("Dosyanız Siliniyor...");
			try {
				Thread.sleep(2000);
				file.delete();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Bilinmeyen Hata!....");
			}
			System.out.println("Dosya başarı ile silinmiştir...");
		}

	}

	private void doysayadanOku(File file) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
			int oku = fileReader.read();
			while (oku != -1) {
				System.out.print((char) oku);
				oku = fileReader.read();
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Bilinmeyen Hata!....");
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void dosyayaYaz(File file) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, true);
			System.out.println("Ne yazmak istersiniz ?");
			String text = sc.next() + "\n";
			fileWriter.write(text);
			System.out.println("Dosyaya yazılıyor");
			Thread.sleep(2000);
			System.out.println("Dosyaya yazıldı...");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Bilinmeyen Hata!....");
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void dosyaOlustur(File file) throws Exception {
		if (file.exists()) {
			throw new FileAlreadyExistsException("Zaten bu dosya var..!");
		} else {
			file.createNewFile();
			System.out.println("Dosyanız Oluşturuluyor..");
			Thread.sleep(1000);
			System.out.println("Dosya oluşturuldu");
		}
	}

}
