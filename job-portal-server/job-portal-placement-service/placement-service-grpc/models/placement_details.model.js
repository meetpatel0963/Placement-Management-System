module.exports = (sequelize, Sequelize, DataTypes) => {
  return sequelize.define(
    "placement_details", // Model name
    {
      // Model attributes
      student_id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
      },
      year: {
        type: DataTypes.BIGINT,
      },
      LPA: {
        type: DataTypes.DOUBLE,
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
