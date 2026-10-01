import axios from "axios";
import type { Measurement } from "../types/Measurement";

const api = axios.create({
  baseURL: "http://localhost:8080/api",
});

export const getMeasurements = async (): Promise<Measurement[]> => {
  const response = await api.get<Measurement[]>("/measurements");

  return response.data;
};

export default api;