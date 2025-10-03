export interface BillInputs {
  totalAmount: number;
  totalUnit: number;
  lastMonthUnit: number;
  currentMonthUnit: number;
  waterRent: number;
  billingPeriod: string;
}

export interface BillResults {
  avgCostPerUnit: number;
  upperHouseUnit: number;
  upperHouseElectricBill: number;
  downHouseUnit: number;
  downHouseElectricBill: number;
  totalUpperBill: number;
  amountToReturn: number;
}
