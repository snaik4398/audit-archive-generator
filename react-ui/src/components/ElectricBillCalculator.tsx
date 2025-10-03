import { useState } from 'react'
import { BillInputs, BillResults } from '../types/BillCalculation'
import BillInputForm from './BillInputForm'
import BillResultsDisplay from './BillResultsDisplay'
import './ElectricBillCalculator.css'

const ElectricBillCalculator = () => {
  const [inputs, setInputs] = useState<BillInputs>({
    totalAmount: 2661,
    totalUnit: 515,
    lastMonthUnit: 9320,
    currentMonthUnit: 9564,
    waterRent: 300,
    billingPeriod: 'JULY - AUG 2024'
  })

  const [results, setResults] = useState<BillResults | null>(null)

  const calculateBill = (billInputs: BillInputs): BillResults => {
    const avgCostPerUnit = billInputs.totalAmount / billInputs.totalUnit
    const upperHouseUnit = billInputs.currentMonthUnit - billInputs.lastMonthUnit
    const upperHouseElectricBill = avgCostPerUnit * upperHouseUnit
    const downHouseUnit = billInputs.totalUnit - upperHouseUnit
    const downHouseElectricBill = billInputs.totalAmount - upperHouseElectricBill
    const totalUpperBill = upperHouseElectricBill + billInputs.waterRent
    const amountToReturn = billInputs.totalAmount - totalUpperBill

    return {
      avgCostPerUnit: parseFloat(avgCostPerUnit.toFixed(2)),
      upperHouseUnit,
      upperHouseElectricBill: parseFloat(upperHouseElectricBill.toFixed(2)),
      downHouseUnit,
      downHouseElectricBill: parseFloat(downHouseElectricBill.toFixed(2)),
      totalUpperBill: parseFloat(totalUpperBill.toFixed(2)),
      amountToReturn: parseFloat(amountToReturn.toFixed(2))
    }
  }

  const handleCalculate = () => {
    const calculatedResults = calculateBill(inputs)
    setResults(calculatedResults)
  }

  const handleInputChange = (newInputs: BillInputs) => {
    setInputs(newInputs)
  }

  return (
    <div className="calculator-container">
      <header className="calculator-header">
        <h1>⚡ Electric Bill Calculator</h1>
        <p className="subtitle">Split your electricity bill between upper and lower house</p>
      </header>

      <div className="calculator-content">
        <BillInputForm 
          inputs={inputs} 
          onInputChange={handleInputChange}
          onCalculate={handleCalculate}
        />
        
        {results && (
          <BillResultsDisplay 
            results={results} 
            inputs={inputs}
          />
        )}
      </div>
    </div>
  )
}

export default ElectricBillCalculator
