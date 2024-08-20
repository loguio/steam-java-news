interface ReactNodeProps {
  children: React.ReactNode;
}

const Layout = (props: ReactNodeProps) => {
  return <>{props.children}</>;
};
export default Layout;
