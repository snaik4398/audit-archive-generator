import { BillInputs } from '../types/BillCalculation'
import './BillInputForm.css'

interface BillInputFormProps {
  inputs: BillInputs
  onInputChange: (inputs: BillInputs) => void
  onCalculate: () => void
}

const BillInputForm = ({ inputs, onInputChange, onCalculate }: BillInputFormProps) => {
  const handleChange = (field: keyof BillInputs, value: string | number) => {
    onInputChange({
      ...inputs,
      [field]: value
    })
  }

  return (
    <div className="input-form-container">
      <h2 className="form-title">📋 Bill Information</h2>
      
      <div className="form-grid">
        <div className="form-group">
          <label htmlFor="billingPeriod">Billing Period</label>
          <input
            id="billingPeriod"
            type="text"
            value={inputs.billingPeriod}
            onChange={(e) => handleChange('billingPeriod', e.target.value)}
            placeholder="e.g., JULY - AUG 2024"
          />
        </div>

        <div className="form-group">
          <label htmlFor="totalAmount">Total Bill Amount (₹)</label>
          <input
            id="totalAmount"
            type="number"
            value={inputs.totalAmount}
            onChange={(e) => handleChange('totalAmount', parseFloat(e.target.value) || 0)}
            placeholder="Enter total amount"
          />
        </div>

        <div className="form-group">
          <label htmlFor="totalUnit">Total Units Consumed</label>
          <input
            id="totalUnit"
            type="number"
            value={inputs.totalUnit}
            onChange={(e) => handleChange('totalUnit', parseFloat(e.target.value) || 0)}
            placeholder="Enter total units"
          />
        </div>

        <div className="form-group">
          <label htmlFor="lastMonthUnit">Last Month Meter Reading</label>
          <input
            id="lastMonthUnit"
            type="number"
            value={inputs.lastMonthUnit}
            onChange={(e) => handleChange('lastMonthUnit', parseFloat(e.target.value) || 0)}
            placeholder="Enter last month reading"
          />
        </div>

        <div className="form-group">
          <label htmlFor="currentMonthUnit">Current Month Meter Reading</label>
          <input
            id="currentMonthUnit"
            type="number"
            value={inputs.currentMonthUnit}
            onChange={(e) => handleChange('currentMonthUnit', parseFloat(e.target.value) || 0)}
            placeholder="Enter current month reading"
          />
        </div>

        <div className="form-group">
          <label htmlFor="waterRent">Water Rent (₹)</label>
          <input
            id="waterRent"
            type="number"
            value={inputs.waterRent}
            onChange={(e) => handleChange('waterRent', parseFloat(e.target.value) || 0)}
            placeholder="Enter water rent"
          />
        </div>
      </div>

      <button className="calculate-btn" onClick={onCalculate}>
        Calculate Bill
      </button>
    </div>
  )
}

export default BillInputForm
