import { BillInputs, BillResults } from '../types/BillCalculation'
import './BillResultsDisplay.css'

interface BillResultsDisplayProps {
  results: BillResults
  inputs: BillInputs
}

const BillResultsDisplay = ({ results, inputs }: BillResultsDisplayProps) => {
  return (
    <div className="results-container">
      <h2 className="results-title">📊 Calculation Results</h2>
      <div className="billing-period-badge">{inputs.billingPeriod}</div>

      <div className="results-grid">
        {/* Summary Section */}
        <div className="result-card summary-card">
          <h3>📌 Summary</h3>
          <div className="result-row">
            <span className="label">Total Electric Bill:</span>
            <span className="value">₹ {inputs.totalAmount}</span>
          </div>
          <div className="result-row">
            <span className="label">Total Units:</span>
            <span className="value">{inputs.totalUnit} kWh</span>
          </div>
          <div className="result-row highlight">
            <span className="label">Average Cost per Unit:</span>
            <span className="value">₹ {results.avgCostPerUnit}</span>
          </div>
        </div>

        {/* Upper House Section */}
        <div className="result-card upper-house-card">
          <h3>🏠 Upper House</h3>
          <div className="result-row">
            <span className="label">Units Consumed:</span>
            <span className="value">{results.upperHouseUnit} kWh</span>
          </div>
          <div className="result-row">
            <span className="label">Electric Bill:</span>
            <span className="value">₹ {results.upperHouseElectricBill}</span>
          </div>
          <div className="result-row">
            <span className="label">Water Rent:</span>
            <span className="value">₹ {inputs.waterRent}</span>
          </div>
          <div className="result-row total">
            <span className="label">Total Upper Bill:</span>
            <span className="value">₹ {results.totalUpperBill}</span>
          </div>
        </div>

        {/* Lower House Section */}
        <div className="result-card lower-house-card">
          <h3>🏘️ Lower House</h3>
          <div className="result-row">
            <span className="label">Units Consumed:</span>
            <span className="value">{results.downHouseUnit} kWh</span>
          </div>
          <div className="result-row">
            <span className="label">Electric Bill:</span>
            <span className="value">₹ {results.downHouseElectricBill}</span>
          </div>
        </div>

        {/* Settlement Section */}
        <div className="result-card settlement-card">
          <h3>💰 Settlement</h3>
          <div className="result-row highlight">
            <span className="label">Amount to Return:</span>
            <span className="value amount-return">₹ {results.amountToReturn}</span>
          </div>
          <p className="settlement-note">
            {results.amountToReturn > 0 
              ? "This amount should be returned to the lower house."
              : "No amount to return."}
          </p>
        </div>
      </div>
    </div>
  )
}

export default BillResultsDisplay
