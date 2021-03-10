package Data;

abstract public class Karyawan {

// private String kode;
	protected String nama;
	protected String gender;
	protected double gaji;

	public Karyawan(String nama, String gender, double gaji) {
		this.nama = nama;
		this.gender = gender;
		this.gaji = gaji;
	}

	public String getNama() {
		return nama;
	}

	public String getGender() {
		return gender;
	}

	public double getGaji() {
		return gaji;
	}

//	public void setgaji(double gaji){
//        this.gaji = gaji;
//    }
//	

	public abstract void raise();
}