import { Route, Routes } from "react-router-dom";
import NoMatch from "../pages/NoMatch";
import { GameDetails } from "../pages/GameDetails";
import { PopularGame } from "../pages/PopularGame";
import Layout from "../pages/layout/Layout";
import { Discount } from "../pages/Discount";

const AppRoot = () => {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<PopularGame />} />
        <Route path="/discount" element={<Discount />} />
        <Route path="/detail/:id" element={<GameDetails />} />
        <Route path="*" element={<NoMatch />} />
      </Routes>
    </Layout>
  );
};
export default AppRoot;
