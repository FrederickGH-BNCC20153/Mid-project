package Data;

public class Admin extends Karyawan{

	private String kode;

	public Admin(String nama, String gender, double gaji, String kode) {
		super(nama, gender, gaji + 4000000);
		this.kode = kode;

	}

	public String getKode() {
		return kode;
	}

	public void raise() {
		gaji += gaji * 0.05;
	}
}
