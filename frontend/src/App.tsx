import { BrowserRouter } from "react-router-dom";
import "./App.css";
import AppRoot from "./rooting/AppRoute";

function App() {
  return (
    <BrowserRouter>
      <AppRoot></AppRoot>
    </BrowserRouter>
  );
}

export default App;
