import axios from "axios";
import type { Measurement } from "../types/Measurement";

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL + "/api",
});

export const getMeasurements = async (): Promise<Measurement[]> => {
  const response = await api.get<Measurement[]>("/measurements");

  return response.data;
};

export default api;