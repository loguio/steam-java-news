import { BrowserRouter } from "react-router-dom";
import "./App.css";
import AppRoot from "./rooting/AppRoute";
import axios from "axios";
import { API_URL } from "./constantes/environnement";

function App() {
  axios.defaults.baseURL = API_URL;

  return (
    <BrowserRouter>
      <AppRoot></AppRoot>
    </BrowserRouter>
  );
}

export default App;
