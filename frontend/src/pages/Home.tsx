import { useEffect, useState } from "react";
import { model } from "../model/model";
import { getGames } from "../api/api";

export const Home = () => {
  const [games, setGames] = useState<model[]>();

  useEffect(() => {
    retrieveGames();
  }, []);
  const retrieveGames = async () => {
    const result = await getGames();
    if (result) setGames(result);
  };
  return (
    <>
      <h1>HOMEEE</h1>
    </>
  );
};
