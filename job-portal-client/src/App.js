import React, { useState, useEffect } from "react";
import "./App.css";

import {
  saveStudent,
  getStudentContactDetails,
  getAllStudents,
  getStudentById,
  updateStudent,
  deleteStudent,
} from "./utils";
import { StudentServiceClient } from "./student_grpc_web_pb";

export const client = new StudentServiceClient(
  "http://localhost:8080",
  null,
  null
);

const App = () => {
  const [selectedFile, setSelectedFile] = useState(null);

  useEffect(() => {
    // saveStudent(client);
    // getStudentContactDetails(client);
    // getAllStudents(client);
    // getStudentById(client);
    // updateStudent(client);
    // deleteStudent(client);
  }, []);

  const handleSelect = (e) => {
    // console.log(e.target.files[0]);
    setSelectedFile(e.target.files[0]);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const reader = new FileReader();
    reader.readAsArrayBuffer(selectedFile);

    reader.onloadend = function (evt) {
      if (evt.target.readyState === FileReader.DONE) {
        let arrayBuffer = evt.target.result,
          fileByteArray = new Uint8Array(arrayBuffer);
        saveStudent(client, fileByteArray);
      }
    };
  };

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <input type="file" onChange={handleSelect} />
        <input type="submit" value="Submit" />
      </form>
    </div>
  );
};

export default App;
