module.exports = (sequelize, Sequelize, DataTypes) => {
  return sequelize.define(
    "company", // Model name
    {
      // Model attributes
      id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
      },
      name: {
        type: DataTypes.STRING,
      },
    },
    {
      // Options
      timestamps: true,
      underscrored: true,
      createdAt: "created_at",
      updatedAt: "updated_at",
    }
  );
};
