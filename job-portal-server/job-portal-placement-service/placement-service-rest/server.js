const express = require("express");
const cors = require("cors");
const bodyParser = require("body-parser");
const dotenv = require("dotenv");

const placementRoutes = require("./routes/placement.routes");
const companyRoutes = require("./routes/company.routes");
dotenv.config({ path: "./config/config.env" });

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cors());

app.use("/placement/", placementRoutes);
app.use("/company/", companyRoutes);

const REST_PORT = process.env.REST_PORT || 4000;
app.listen(REST_PORT, () => {
  console.log("Server running at port %d 🚀🚀🚀", REST_PORT);
});
