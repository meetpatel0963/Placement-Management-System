const config = require("../config/config.js");
const { Sequelize, DataTypes, Op } = require("sequelize");

const sequelize = new Sequelize(
  config.db.DB_NAME,
  config.db.DB_USER,
  config.db.DB_PASS,
  {
    host: config.db.DB_HOST,
    dialect: config.db.dialect,
    port: config.db.MYSQL_PORT,

    poll: {
      max: config.db.pool.max,
      min: config.db.pool.min,
      acquire: config.db.pool.acquire,
      idle: config.db.pool.idle,
    },
  }
);

async function check() {
  try {
    await sequelize.authenticate();
    console.log("Connection has been established successfully.");
  } catch (error) {
    console.error("Unable to connect to the database:", error);
  }
}

check();

const db = {};

db.Sequelize = Sequelize;
db.Op = Op;
db.sequelize = sequelize;

db.placementDetails = require("./placement_details.model.js")(
  sequelize,
  Sequelize,
  DataTypes
);
db.company = require("./company.model.js")(sequelize, Sequelize, DataTypes);

db.company.hasMany(db.placementDetails, {
  as: "placement_details",
  foreignKey: "company_id",
});

module.exports = db;
