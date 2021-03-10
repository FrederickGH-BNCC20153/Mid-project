package Data;

public class Manager extends Karyawan {

	private String kode;

	public Manager(String nama, String gender, double gaji, String kode) {
		super(nama, gender, gaji + 8000000);
		this.kode = kode;

	}

	public String getKode() {
		return kode;
	}

	public void raise() {
		gaji += gaji * 0.1;
	}
}