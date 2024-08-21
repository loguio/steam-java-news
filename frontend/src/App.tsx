import { BrowserRouter } from "react-router-dom";
import "./App.css";
import AppRoot from "./rooting/AppRoute";
import axios from "axios";
import { API_URL } from "./constantes/environnement";

function App() {
  axios.defaults.baseURL = API_URL;
  axios.defaults.headers.post["Access-Control-Allow-Origin"] = "*";
  axios.defaults.headers.post["Content-Type"] =
    "application/json;charset=utf-8";

  return (
    <BrowserRouter>
      <AppRoot></AppRoot>
    </BrowserRouter>
  );
}

export default App;
