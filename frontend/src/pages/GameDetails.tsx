import { useEffect, useState } from "react";
import { getDetails } from "../api/api";
import { model } from "../model/model";
import { useParams } from "react-router-dom";

export const GameDetails = () => {
  const [games, setGames] = useState<model>();
  const { id } = useParams();
  useEffect(() => {
    retrieveGames();
  }, []);
  const retrieveGames = async () => {
    const result = await getDetails(parseInt(id as string));
    if (result) setGames(result);
  };

  const calculatePositivePercentage = (positive: number, negative: number) => {
    const total = positive + negative;
    return total === 0 ? 0 : Math.round((positive / total) * 100);
  };

  const getColorForPercentage = (percentage: number) => {
    if (percentage >= 80) {
      return "green";
    } else if (percentage >= 50) {
      return "orange";
    } else {
      return "red"; // Default color if needed
    }
  };

  const styles = {
    card: {
      border: "1px solid #ccc",
      borderRadius: "8px",
      padding: "16px",
      margin: "16px",
      maxWidth: "80%",
      boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
      backgroundColor: "#ffffff",
    },
    title: {
      fontSize: "24px",
      marginBottom: "8px",
      color: "#333",
    },
    detail: {
      marginBottom: "8px",
      color: "#555",
    },
    image: {
      width: "50%",
      height: "auto",
      borderRadius: "8px",
      margin: "6px",
    },
    video: {
      width: "40%",
      height: "auto",
      borderRadius: "8px",
      margin: "6px",
    },
  };

  return (
    <>
      <h1>Page discount</h1>

      <div>
        {!games ? (
          <>CHARGEMENT...</>
        ) : (
          <>
            <div style={styles.card}>
              <h1>{games.name}</h1>
              <img
                src={games.capsule_image}
                alt={games.name}
                style={styles.image}
              />
              <video style={styles.video} src={games.mp4} controls>
                Votre navigateur ne supporte pas la lecture de vidéos.
              </video>
              <br />
              <div>Développeur: {games.developer}</div>
              <br />
              <div>Éditeur: {games.publisher}</div>
              <br />
              <div>Description: {games.short_description}</div>
              <br />
              <div>Date de sortie: {games.release_date}</div>
              <br />
              <div>
                website:{" "}
                <a target="_blank" href={games.website}>
                  {games.website}
                </a>
              </div>
              <div>
                Page steam:{" "}
                <a
                  target="_blank"
                  href={"https://store.steampowered.com/app/" + games.appid}
                >
                  {games.name}
                </a>
              </div>
              <br />
              <div>Window: {games.windows ? "oui" : "non"}</div>
              <div>Mac: {games.mac ? "oui" : "non"}</div>
              <div>Linux: {games.linux ? "oui" : "non"}</div>
              <br />
              <div>Soldes: -{games.discount_percent}%</div>
              <div>Prix initiales: {games.initial_formatted}</div>
              <div>
                Prix soldé:{" "}
                {games.final_formatted != ""
                  ? games.final_formatted
                  : "Gratuit"}
              </div>
              <br />
              <div>Joueur connecté hier: {games.ccu}</div>
              <div>
                Avis positifs:{" "}
                <span
                  style={{
                    color: getColorForPercentage(
                      calculatePositivePercentage(
                        games.positive,
                        games.negative
                      )
                    ),
                  }}
                >
                  {calculatePositivePercentage(games.positive, games.negative)}%
                </span>
              </div>
            </div>
          </>
        )}
      </div>
    </>
  );
};
