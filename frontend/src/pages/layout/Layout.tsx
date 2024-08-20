import "./LayoutStyle.css";

interface ReactNodeProps {
  children: React.ReactNode;
}

const Layout = (props: ReactNodeProps) => {
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
        <button onClick={() => null} className="button-9">
          Popular Game
        </button>
        <button onClick={() => null} className="button-9">
          Discount Game
        </button>
      </div>
      {props.children}
    </>
  );
};
export default Layout;
