import React, { useEffect } from "react";
import "./App.css";

import {} from "./student_pb";
import { StudentServiceClient } from "./student_grpc_web_pb";

export const client = new StudentServiceClient(
  "http://localhost:8080",
  null,
  null
);

const App = () => {
  useEffect(() => {}, []);

  return <div className="App"></div>;
};

export default App;
