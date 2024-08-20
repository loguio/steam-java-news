import axios from "axios";
import { model } from "../model/model";

export const getGames = async (page: number = 0): Promise<model[] | null> => {
  try {
    const response = await axios.get("http://localhost:8080/steam_api/top100", {
      params: {
        page: page,
      },
    });
    return response.data as model[];
  } catch (e) {
    console.error(e);
    return null;
  }
};
export const getDiscount = async (
  page: number = 0
): Promise<model[] | null> => {
  try {
    const response = await axios.get(
      "http://localhost:8080/steam_api/discount",
      {
        params: {
          page: page,
        },
      }
    );
    return response.data as model[];
  } catch (e) {
    console.error(e);
    return null;
  }
};

export const getDetails = async (id: number): Promise<model | null> => {
  try {
    const response = await axios.get(
      "http://localhost:8080/steam_api/details?id=" + id
    );
    return response.data as model;
  } catch (e) {
    console.error(e);
    return null;
  }
};
