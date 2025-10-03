# ⚡ Electric Bill Calculator - React TypeScript UI

A beautiful, modern web interface for calculating and splitting electricity bills between upper and lower house units.

## 🚀 Features

- **Interactive Input Form**: Easy-to-use form for entering bill details
- **Real-time Calculations**: Instant bill splitting calculations
- **Responsive Design**: Works perfectly on desktop, tablet, and mobile devices
- **Modern UI**: Beautiful gradient backgrounds and smooth animations
- **TypeScript**: Type-safe code for better development experience
- **Component-Based Architecture**: Clean, maintainable React components

## 📋 What It Does

This calculator helps split electricity bills between two houses (upper and lower) by:
- Calculating average cost per unit
- Determining units consumed by each house based on meter readings
- Adding water rent to upper house bill
- Computing the settlement amount

## 🛠️ Tech Stack

- **React 18** - UI library
- **TypeScript** - Type safety
- **Vite** - Build tool and dev server
- **CSS3** - Styling with modern features

## 📦 Installation

1. **Install dependencies:**
   ```bash
   cd react-ui
   npm install
   ```

2. **Start the development server:**
   ```bash
   npm run dev
   ```

3. **Open your browser:**
   Navigate to `http://localhost:5173`

## 🏗️ Build for Production

```bash
npm run build
```

The production-ready files will be in the `dist` folder.

## 📱 Usage

1. **Enter Bill Information:**
   - Billing period (e.g., "JULY - AUG 2024")
   - Total bill amount in ₹
   - Total units consumed
   - Last month's meter reading
   - Current month's meter reading
   - Water rent amount

2. **Click "Calculate Bill":**
   The app will display:
   - Average cost per unit
   - Upper house consumption and bill
   - Lower house consumption and bill
   - Settlement amount to return

## 📁 Project Structure

```
react-ui/
├── src/
│   ├── components/
│   │   ├── ElectricBillCalculator.tsx    # Main calculator component
│   │   ├── ElectricBillCalculator.css
│   │   ├── BillInputForm.tsx              # Input form component
│   │   ├── BillInputForm.css
│   │   ├── BillResultsDisplay.tsx         # Results display component
│   │   └── BillResultsDisplay.css
│   ├── types/
│   │   └── BillCalculation.ts             # TypeScript interfaces
│   ├── App.tsx
│   ├── App.css
│   ├── main.tsx
│   └── index.css
├── index.html
├── package.json
├── tsconfig.json
├── vite.config.ts
└── README.md
```

## 🎨 Features Highlight

- **Gradient Backgrounds**: Beautiful purple gradient backdrop
- **Card-Based Layout**: Clean separation of concerns
- **Hover Effects**: Interactive elements with smooth transitions
- **Color-Coded Results**: Different colors for different house sections
- **Responsive Grid**: Adapts to any screen size
- **Input Validation**: Proper number handling

## 🔧 Available Scripts

- `npm run dev` - Start development server
- `npm run build` - Build for production
- `npm run preview` - Preview production build
- `npm run lint` - Run ESLint

## 📝 Example Calculation

**Input:**
- Total Amount: ₹2,661
- Total Units: 515 kWh
- Last Month Reading: 9,320
- Current Month Reading: 9,564
- Water Rent: ₹300

**Output:**
- Avg Cost/Unit: ₹5.17
- Upper House: 244 units, ₹1,261.48 + ₹300 water = ₹1,561.48
- Lower House: 271 units, ₹1,399.52
- Amount to Return: ₹1,099.52

## 🤝 Contributing

Feel free to fork this project and customize it for your needs!

## 📄 License

MIT License - feel free to use this project for personal or commercial purposes.

---

Built with ❤️ using React and TypeScript
