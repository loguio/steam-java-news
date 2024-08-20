import axios from "axios";
import { model } from "../model/model";

export const getGames = async (): Promise<model[] | null> => {
  try {
    return await axios.get("/top100");
  } catch (e) {
    console.error(e);
    return null;
  }
};
