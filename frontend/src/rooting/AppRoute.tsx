import { Route, Routes } from "react-router-dom";
import Layout from "../pages/layout/layout";
import NoMatch from "../pages/NoMatch";
import { Home } from "../pages/home";

const AppRoot = () => {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="*" element={<NoMatch />} />
      </Routes>
    </Layout>
  );
};
export default AppRoot;
