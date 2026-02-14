import { Routes, Route } from 'react-router';
import { WireframePage } from './pages/WireframePage.jsx';

function App() {
  return (
    <Routes>
      <Route path="/" element={<WireframePage />} />
    </Routes>
  )
}

export default App
