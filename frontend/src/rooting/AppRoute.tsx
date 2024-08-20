import { Route, Routes } from "react-router-dom";
import NoMatch from "../pages/NoMatch";
import { GameDetails } from "../pages/GameDetails";
import { Home } from "../pages/Home";
import Layout from "../pages/layout/Layout";

const AppRoot = () => {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/discount" element={<GameDetails />} />
        <Route path="*" element={<NoMatch />} />
      </Routes>
    </Layout>
  );
};
export default AppRoot;
