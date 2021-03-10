package Data;

public class Supervisor extends Karyawan {

	private String kode;

	public Supervisor(String nama, String gender, double gaji, String kode) {
		super(nama, gender, gaji + 6000000);
		this.kode = kode;

	}

	public String getKode() {
		return kode;
	}

	public void raise() {
		gaji += gaji * 0.075;
	}
}