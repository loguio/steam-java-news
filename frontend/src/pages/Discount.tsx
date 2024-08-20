import { useEffect, useState } from "react";
import { model } from "../model/model";
import { getGames } from "../api/api";
import { CompactTable } from "@table-library/react-table-library/compact";
import { useTheme } from "@table-library/react-table-library/theme";
import { getTheme } from "@table-library/react-table-library/baseline";
import { useNavigate } from "react-router-dom";
import { ClipLoader } from "react-spinners";

export const Discount = () => {
  const [games, setGames] = useState<model[]>([]);
  const [page, setPage] = useState<number>(0);
  const navigate = useNavigate();

  const data = { nodes: games };

  useEffect(() => {
    retrieveDiscount();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [page]);

  const retrieveDiscount = async () => {
    setGames([]);
    const result = await getDiscount(page);
    if (result) setGames(result);
  };

  const theme = useTheme([
    getTheme(),
    {
      HeaderRow: `
        background-color: #eaf5fd;
      `,
      Row: `
        &:nth-of-type(odd) {
          background-color: #d2e9fb;
        }

        &:nth-of-type(even) {
          background-color: #eaf5fd;
        }
      `,
    },
  ]);

  const COLUMNS = [
    {
      label: "",
      renderCell: (game: model) => (
        <img
          src={game.capsule_image}
          style={{ width: "40%" }}
          onClick={() => navigate("/detail")}
        ></img>
      ),
    },
    {
      label: "Jeu",
      renderCell: (game: model) => (
        <div onClick={() => navigate("/detail")}>{game.name}</div>
      ),
    },
    { label: "Développeur", renderCell: (game: model) => game.developer },
    {
      label: "Prix",
      renderCell: (game: model) =>
        game.final_formatted != "" ? game.final_formatted : "Gratuit",
    },
    {
      label: "Date de sortie",
      renderCell: (game: model) => game.release_date,
    },
  ];
  return (
    <>
      <div
        style={{
          display: "flex",
          flexDirection: "column",
          marginLeft: "10px",
          marginRight: "20px",
        }}
      >
        <div
          style={{
            height: "50px",
            backgroundColor: "white",
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
          }}
        >
          <img
            style={{
              marginLeft: "10px",
              height: "80%",
              width: "30px",
              display: "flex",
            }}
            src="/chevron-left-svgrepo-com.svg"
            onClick={() => setPage(Math.max(0, page - 1))}
          ></img>
          <div>Page {page + 1} </div>
          <img
            style={{
              height: "80%",
              width: "30px",
              display: "flex",
            }}
            src="/chevron-right-svgrepo-com.svg"
            onClick={() => setPage(Math.min(page + 1, 9))}
          ></img>
        </div>
        <CompactTable
          columns={COLUMNS}
          data={data}
          theme={theme}
        ></CompactTable>
        <div
          style={{
            justifyContent: "center",
            display: "flex",
            marginTop: "150px",
          }}
        >
          {games.length == 0 && <ClipLoader size={150}></ClipLoader>}
        </div>
      </div>
    </>
  );
};
