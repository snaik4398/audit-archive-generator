package sanjay.project;

public class ElectrciBillCalculator {
	private static final int WATER_RENT = 300;

	public static void main(String[] args) {

		System.out.println("===================ELECTRIC BILL ====================");
		System.out.println("JULY - AUG 2024");
		System.out.println("=========================");
		int totalAmount = 2661;
		int totalUnit = 515;
		int lastMonthUnit = 9320;
		int currentMonthUnit = 9564;

		double avg = totalAmount / totalUnit;

		int upperHouseUnit = currentMonthUnit - lastMonthUnit;

		double electricBillNeedstoPay = avg * upperHouseUnit;

		System.out.println("Total Electric Bill :" + totalAmount);
		System.out.println("         Total Unit :" + totalUnit);
		System.out.println();
		System.out.println("                 Avg:" + avg);
		System.out.println("    Upper House Unit:" + upperHouseUnit);
		System.out.println(" Electric bill upper:" + electricBillNeedstoPay);
		System.out.println();

		System.out.println("     Down House Unit:" + (totalUnit - upperHouseUnit));
		System.out.println("  Electric bill Down:" + (totalAmount - electricBillNeedstoPay));
		System.out.println();

		System.out.println("       Electric Bill:" + electricBillNeedstoPay);
		System.out.println("          Water Rent:" + WATER_RENT);
		double finalAmount = electricBillNeedstoPay + WATER_RENT;
		System.out.println("    TOTAL UPPER BILL:" + finalAmount);

		System.out.println();

		System.out.println("Amount Needs to Return:" + (totalAmount - finalAmount));
		// System.out.println("Total Unit:" + (totalUnit - upperHouseUnit));

	}
}
