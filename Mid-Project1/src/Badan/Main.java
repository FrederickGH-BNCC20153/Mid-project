package Badan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import Data.Admin;
import Data.Karyawan;
import Data.Manager;
import Data.Supervisor;

public class Main {

	private Scanner scan = new Scanner(System.in);
	private Random rn =  new Random();
	private ArrayList<Karyawan> list = new ArrayList<>();

	public Main() {
		MainMenu();
	}

	private void MainMenu() {
		int menu = 0;

		do {
			System.out.println("Menu\n" + 
					"------------\n" + 
					"1. Insert Employee Data\n" + 
					"2. View Employee Data\n" + 
					"3. Update Employee Data\n" + 
					"4. Delete Employee Data\n" + 
					"5. Exit");
			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
			case 1:
				newEmployee();
				break;
			case 2:
				ViewEmployee();
				break;
			case 3:
				UpdateEmployee();
				break;
			case 4:
				DeleteEmployee();
				break;
			}
		} while (menu != 5);
	}

	int Manager=0;
	int Supervisor=0;
	int Admin=0;
	int flag1=0;
	int flag2=0;
	int flag3=0;
	int bonus1=0,bonus2=0,bonus3=0;
	
	private void newEmployee() {
		String nama, job, gender;
		int gaji = 0;
		int isi=0;
		
		do {
			System.out.print("Input nama karyawan [>= 3] : ");
			nama = scan.nextLine();
			isi = nama.length();
		} while (nama.trim().isEmpty() && isi<3);

		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		}while(!gender.equals("Laki-laki") && !gender.equals("Perempuan"));
		

		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			job = scan.nextLine();
		} while (!job.equals("Manager") && !job.equals("Supervisor") && !job.equals("Admin"));

		int code =0;
		int angka =0;
		String kode ="";
		for(int x=0;x<2;x++)
		{
			code = rn.nextInt(26)+65;
			kode = kode + (char)code;
		}
		kode = kode + "-";
		for(int x=0;x<4;x++)
		{
			angka = rn.nextInt(10);
			kode = kode + angka;
		}
		System.out.println("Berhasil menambahkan karyawan dengan id " + kode);

		if (job.equals("Manager")) {
			list.add(new Manager(nama, gender, gaji, kode));
			Manager++;
		} else if (job.equals("Supervisor")) {
			list.add(new Supervisor(nama, gender, gaji, kode));
			Supervisor++;
		} else if (job.equals("Admin")) {
			list.add(new Admin(nama, gender, gaji, kode));
			Admin++;
		}
		
		int test1=Manager%3;
		int test2=Supervisor%3;
		int test3=Admin%3;
		
		 for(Karyawan karyawan : list) {
			if(Manager>3&&test1==1) {
				if(bonus1==0&&job.equals("Manager")) {
					System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
					bonus1++;
				}
				if(karyawan instanceof Manager && job.equals("Manager") && flag1<Manager-test1) {
					if(flag1<Manager-2) {
						System.out.printf(" %s,",((Manager) karyawan).getKode());
					}else if(flag1<Manager-test1) {
						System.out.printf(" %s\n",((Manager) karyawan).getKode());
					}
					karyawan.raise();
					flag1++;
					
				}
			}
			if(Supervisor>3&&test2==1) {
				if(bonus2==0&&job.equals("Supervisor")) {
					System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
					bonus2++;
				}
				if(karyawan instanceof Supervisor && job.equals("Supervisor")&& flag2<Supervisor-test2) {
					if(flag2<Supervisor-2) {
						System.out.printf(" %s,",((Supervisor) karyawan).getKode());
					}else if(flag2<Supervisor-test2) {
						System.out.printf(" %s\n",((Supervisor) karyawan).getKode());
					}
					karyawan.raise();
					flag2++;
				}
			}
			if(Admin>3&&test3==1) {
				if(bonus3==0&&job.equals("Admin")) {
					System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");
					bonus3++;
				}
				if(karyawan instanceof Admin && job.equals("Admin") && flag3<Admin-test3) {
					if(flag3<Admin-2) {
						System.out.printf(" %s,",((Admin) karyawan).getKode());
					}else if(flag3<Admin-test3) {
						System.out.printf(" %s\n",((Admin) karyawan).getKode());
					}
					karyawan.raise();
					flag3++;
				}
			}
		}
		 flag1=0;bonus1=0;
		 flag2=0;bonus2=0;
		 flag3=0;bonus3=0;
	}

	private void ViewEmployee() {
		
		Collections.sort(list, new Comparator<Karyawan>() {

			@Override
			public int compare(Karyawan temp1, Karyawan temp2) {
				return temp1.getNama().compareTo(temp2.getNama());
			}
		});
		
		int x = 0;
		System.out.printf("| %-4s | %-15s | %-20s | %-15s | %-10s | %-20s |\n","No","Kode Karyawan","Nama Karyawan","Jenis Kelamin","Jabatan","Gaji Karyawan");
		for (Karyawan karyawan : list) {
			x++;
			if (karyawan instanceof Manager) {
				System.out.printf("| %4d | %15s | %20s | %15s | %10s | %20f |\n", x,
						((Manager) karyawan).getKode(), karyawan.getNama(), karyawan.getGender(),
						karyawan.getClass().getSimpleName(), karyawan.getGaji());
			} else if (karyawan instanceof Supervisor) {
				System.out.printf("| %4d | %15s | %20s | %15s | %10s | %20f |\n", x,
						((Supervisor) karyawan).getKode(), karyawan.getNama(), karyawan.getGender(),
						karyawan.getClass().getSimpleName(), karyawan.getGaji());
			} else if (karyawan instanceof Admin) {
				System.out.printf("| %4d | %15s | %20s | %15s | %10s | %20f |\n", x,
						((Admin) karyawan).getKode(), karyawan.getNama(), karyawan.getGender(),
						karyawan.getClass().getSimpleName(), karyawan.getGaji());
			}
		}
	}
	
	private void UpdateEmployee() {
		String nama, job, gender;
		int gaji = 0;
		int isi = 0;
		int pilihan=0;
		
		ViewEmployee();
		
		do {
			System.out.println("Input number that want to update [1..."+list.size()+"]: ");
			pilihan = scan.nextInt();scan.nextLine();
		}while(pilihan<1 || pilihan>list.size());
		
		do {
			System.out.print("Input nama karyawan [>= 3] : ");
			nama = scan.nextLine();
			isi = nama.length();
		} while (nama.trim().isEmpty() && isi<3);

		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		}while(!gender.equals("Laki-laki") && !gender.equals("Perempuan"));
		

		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			job = scan.nextLine();
		} while (!job.equals("Manager") && !job.equals("Supervisor") && !job.equals("Admin"));

		int code =0;
		int angka =0;
		String kode ="";
		for(int x=0;x<2;x++)
		{
			code = rn.nextInt(26)+65;
			kode = kode + (char)code;
		}
		kode = kode + "-";
		for(int x=0;x<4;x++)
		{
			angka = rn.nextInt(10);
			kode = kode + angka;
		}
		
		 if (job.equals("Manager")) {
			 Manager update = new Manager(nama,gender,gaji,kode);
			 list.set(pilihan-1, update);
			 Manager++;
		 } else if (job.equals("Supervisor")) {
			 Supervisor update = new Supervisor(nama,gender,gaji,kode);
			 list.set(pilihan-1, update);
			 Supervisor++;
		 } else if (job.equals("Admin")) {
			 Admin update = new Admin(nama,gender,gaji,kode);
			 list.set(pilihan-1, update);
			 Admin++;
		 }
		 
		 int test1=Manager%3;
			int test2=Supervisor%3;
			int test3=Admin%3;
			
			 for(Karyawan karyawan : list) {
				if(Manager>3&&test1==1) {
					if(bonus1==0&&job.equals("Manager")) {
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
						bonus1++;
					}
					if(karyawan instanceof Manager && job.equals("Manager") && flag1<Manager-test1) {
						if(flag1<Manager-2) {
							System.out.printf(" %s,",((Manager) karyawan).getKode());
						}else if(flag1<Manager-test1) {
							System.out.printf(" %s\n",((Manager) karyawan).getKode());
						}
						karyawan.raise();
						flag1++;
						
					}
				}
				if(Supervisor>3&&test2==1) {
					if(bonus2==0&&job.equals("Supervisor")) {
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
						bonus2++;
					}
					if(karyawan instanceof Supervisor && job.equals("Supervisor")&& flag2<Supervisor-test2) {
						if(flag2<Supervisor-2) {
							System.out.printf(" %s,",((Supervisor) karyawan).getKode());
						}else if(flag2<Supervisor-test2) {
							System.out.printf(" %s\n",((Supervisor) karyawan).getKode());
						}
						karyawan.raise();
						flag2++;
					}
				}
				if(Admin>3&&test3==1) {
					if(bonus3==0&&job.equals("Admin")) {
						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");
						bonus3++;
					}
					if(karyawan instanceof Admin && job.equals("Admin") && flag3<Admin-test3) {
						if(flag3<Admin-2) {
							System.out.printf(" %s,",((Admin) karyawan).getKode());
						}else if(flag3<Admin-test3) {
							System.out.printf(" %s\n",((Admin) karyawan).getKode());
						}
						karyawan.raise();
						flag3++;
					}
				}
			}
			 flag1=0;bonus1=0;
			 flag2=0;bonus2=0;
			 flag3=0;bonus3=0;
	}
	
	private void DeleteEmployee() {
		ViewEmployee();
		int pilihan2=0;
		
		do {
			System.out.println("Input number that want to update [1..."+list.size()+"]: ");
			pilihan2 = scan.nextInt();scan.nextLine();
		}while(pilihan2<1 || pilihan2>list.size());
		
		list.remove(pilihan2-1);
	}

	public static void main(String[] args) {
		new Main();
	}

}