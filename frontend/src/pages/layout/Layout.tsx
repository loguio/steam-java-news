import "./LayoutStyle.css";
import { useNavigate } from "react-router-dom";

interface ReactNodeProps {
  children: React.ReactNode;
}

const Layout = (props: ReactNodeProps) => {
  const navigate = useNavigate();

  return (
    <>
      <div
        style={{
          height: "80px",
          width: "100%",
          backgroundColor: "#1F2833",
          alignItems: "center",
          display: "flex",
          gap: "100px",
          paddingLeft: "20px",
          alignContent: "center",
        }}
      >
        <button onClick={() => navigate("/")} className="button-9">
          Popular Game
        </button>
        <button onClick={() => navigate("/discount")} className="button-9">
          Discount Game
        </button>
      </div>
      {props.children}
    </>
  );
};
export default Layout;
