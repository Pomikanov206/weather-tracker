import { useEffect, useState } from "react";
import {
  MapContainer,
  Marker,
  Popup,
  TileLayer,
} from "react-leaflet";

import "leaflet/dist/leaflet.css";
import "./index.css";

import type { Measurement } from "./types/Measurement";
import { getMeasurements } from "./services/api";

function App() {
  const [measurements, setMeasurements] = useState<Measurement[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getMeasurements()
      .then((data) => {
        setMeasurements(data);
      })
      .catch((error) => {
        console.error("Ошибка загрузки измерений:", error);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  const defaultPosition: [number, number] = [
    48.4647,
    35.0462,
  ];

  return (
    <div style={{ width: "100vw", height: "100vh" }}>
      {loading && <div>Загрузка...</div>}

      <MapContainer
        center={defaultPosition}
        zoom={13}
        style={{ width: "100%", height: "100%" }}
      >
        <TileLayer
          attribution='&copy; OpenStreetMap contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />

        {measurements.map((measurement) => (
          <Marker
            key={measurement.id}
            position={[
              measurement.latitude,
              measurement.longitude,
            ]}
          >
            <Popup>
              <b>Измерение #{measurement.id}</b>

              <br />

              🌡 Температура:{" "}
              {measurement.temperature} °C

              <br />

              💧 Влажность:{" "}
              {measurement.humidity} %

              <br />

              📍 {measurement.latitude},{" "}
              {measurement.longitude}

              <br />

              🕐{" "}
              {new Date(
                measurement.createdAt
              ).toLocaleString()}
            </Popup>
          </Marker>
        ))}
      </MapContainer>
    </div>
  );
}

export default App;