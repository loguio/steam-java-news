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
        }}
      >
        <div
          onClick={() => null}
          style={{
            height: "50px",
            width: "150px",
            backgroundColor: "lightpink",
            justifyContent: "center",
            alignItems: "center",
            display: "flex",
            marginLeft: "150px",
          }}
        >
          Popular Game
        </div>
        <div
          onClick={() => null}
          style={{
            height: "50px",
            width: "150px",
            backgroundColor: "lightpink",
            justifyContent: "center",
            alignItems: "center",
            display: "flex",
            marginLeft: "150px",
          }}
        >
          Discount Game
        </div>
      </div>
      {props.children}
    </>
  );
};
export default Layout;
