import "./LayoutStyle.css";

interface ReactNodeProps {
  children: React.ReactNode;
}

const Layout = (props: ReactNodeProps) => {
  return (
    <>
      <div
        style={{
          height: "120px",
          width: "100%",
          backgroundColor: "lightblue",
          alignItems: "center",
          display: "flex",
          gap: "100px",
          paddingLeft: "20px",
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
