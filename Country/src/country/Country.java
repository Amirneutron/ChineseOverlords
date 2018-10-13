
public class Country {
	private String name;
	private double gdp;
	private double population;
	private double amountInj;
	private double amountDebt;
	private String capital;
	private String president;
	private String mayor;
	private final int CLASS_CONS_ONE = 1000;
	private final int CLASS_CONS_TWO = 10000;
	final String END_OF_LINE = System.lineSeparator();

	Country(String name, double gdp, double population, String capital, String president) {
		this.name = name;
		this.gdp = gdp;
		this.population = population;
		this.capital = capital;
		this.president = president;

	}

	public String getName() {
		return name;
	}

	public double getgdp() {
		return gdp;
	}

	public double getPopulation() {
		return population;
	}

	public void setName(String newname) {
		this.name = newname;
	}

	public void setPopulation(double newpopulation) {
		this.population = newpopulation;
	}

	public double gdp_per_capita() {
		double gdpCap;
		gdpCap = gdp / population;
		return gdpCap;
	}

	public String getClassification() {
		String classification = "";
		if (gdp_per_capita() >= CLASS_CONS_TWO) {
			classification = "Developed country";
		} else if ((gdp_per_capita() >= CLASS_CONS_ONE) && (CLASS_CONS_TWO > gdp_per_capita())) {
			classification = "Economy in transition";
		} else if (gdp_per_capita() < CLASS_CONS_ONE) {
			classification = "Developing country";
		}

		return classification;
	}

	public void injectMoney(double amountInj) {
		if (amountInj > 0) {
			gdp = amountInj + gdp;
		} else {
			System.err.println("Error when injecting money in " + this.name + ". Amount has to be higher than zero");
		}
	}

	public void payDebt(double amountDebt) {
		if (amountDebt < 0 || amountDebt > gdp) {
			System.out.println("Error when paying " + this.name + "'s debt. Amount has to be higher than zero");
		} else if (amountDebt > 0) {
			gdp = gdp - amountDebt;
		}

	}

	@Override
	public String toString() {
		String print = this.name + " : ( " + getClassification() + " )" + END_OF_LINE;
		print += "Population : " + getPopulation() + END_OF_LINE;
		print += "gdp : " + getgdp() + END_OF_LINE;
		print += gdp_per_capita() + "gdp per capita ." + END_OF_LINE;
		print += "President : " + getPresident() + END_OF_LINE;
		print += "capital : " + getcapital() + END_OF_LINE;

		return print;
	}

	public String getcapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public String getMayor() {
		return mayor;
	}

	public void setMayor(String mayor) {
		this.mayor = mayor;
	}

	public double getAmountInj() {
		return amountInj;
	}

	public void setAmountInj(double amountInj) {
		this.amountInj = amountInj;
	}

	public double getAmountDebt() {
		return amountDebt;
	}

	public void setAmountDebt(double amountDebt) {
		this.amountDebt = amountDebt;
	}

}
