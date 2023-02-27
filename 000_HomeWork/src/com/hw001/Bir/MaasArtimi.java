package com.hw001.Bir;

public class MaasArtimi {
	private static int workHoursNormal = 40;
	private static int overtimeCharge = 30;
	private static int dateNow = 2022;
	private String name;
	private double salary;
	private int workHours;
	private int hireYear;
	private double tax;
	private double bonus;
	private double salaryRaise;
	private double totalSalary;

	public MaasArtimi(String name, double salary, int workHours, int hireYear) {
		super();
		this.name = name;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getWorkHouse() {
		return workHours;
	}

	public void setWorkHouse(int workHouse) {
		this.workHours = workHouse;
	}

	public int getHireYear() {
		return hireYear;
	}

	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getSalaryRaise() {
		return salaryRaise;
	}

	public void setSalaryRaise(double salaryRaise) {
		this.salaryRaise = salaryRaise;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public double tax() {
		if (this.salary > 2000) {
			this.tax = this.salary * 0.05;
			this.setTotalSalary(this.getTotalSalary() + this.getSalary() + this.tax);
		} else {
			System.out.println("Vergilendirme yapılmayacaktır...!");
		}
		return tax;
	}

	public double bonus() {
		if (this.workHours > 40) {
			int diffHours = this.workHours - workHoursNormal;
			double bonusCharge = diffHours * overtimeCharge;
			this.setBonus(bonusCharge);
			this.setTotalSalary(this.getSalary() + this.getTotalSalary() + this.getBonus());
		} else {
			System.out.println("Aktif Bonus bulunamadı...!");
		}
		return bonus;
	}

	public double raiseSalary() {
		int diffYears = dateNow - this.hireYear;
		if (diffYears < 10) {
			this.salaryRaise = this.salary * 0.05;
		} else if (diffYears > 10 && diffYears < 20) {
			this.salaryRaise = this.salary * 0.10;
		} else if (diffYears >= 20) {
			this.salaryRaise = this.salary * 0.15;
		}
		return this.salaryRaise;
	}

	public double totalSalary() {
		this.totalSalary = this.salary + this.tax + this.bonus + this.salaryRaise;
		return totalSalary;
	}

	public void getInfo() {
		System.out.println("Adı : " + this.getName());
		System.out.println("Maaşı : " + this.getSalary());
		System.out.println("Çalışma Saati : " + this.getWorkHouse());
		System.out.println("Başlangıç Yılı : " + this.getHireYear());
		System.out.println("Vergi : " + this.getTax());
		System.out.println("Bonus : " + this.getBonus());
		System.out.println("Maaş Artışı : " + this.getSalaryRaise());
		System.out.println(
				"Vergi ve Bonuslar ile birlikte maaş :" + this.getSalary() + " Toplam maaş : " + totalSalary());
	}

}
