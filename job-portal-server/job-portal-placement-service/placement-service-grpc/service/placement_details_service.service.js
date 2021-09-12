const grpc = require("grpc");
const placementController = require("../controllers/placement_details.controller");

const getAllPlacementEntries = async (_, callback) => {
  try {
    const res = await placementController.findAll();

    let placementEntries = [];
    res.forEach((placementEntry) => {
      placementEntry = placementEntry.dataValues;
      const _placementEntry = {
        studentId: placementEntry.student_id,
        companyId: placementEntry.company_id,
        year: placementEntry.year,
        LPA: placementEntry.LPA,
        createdAt: placementEntry.created_at.toISOString(),
        updatedAt: placementEntry.updated_at.toISOString(),
      };
      placementEntries.push(_placementEntry);
    });

    callback(null, { placementEntries });
  } catch (err) {
    callback(
      {
        code: 500,
        message: err,
        status: grpc.status.UNKNOWN,
      },
      null
    );
  }
};

const getPlacementEntryById = async (call, callback) => {
  try {
    let res = await placementController.findOne(call.request.studentId);
    res = res.dataValues;

    const placementEntry = {
      studentId: res.student_id,
      companyId: res.company_id,
      year: res.year,
      LPA: res.LPA,
      createdAt: res.created_at.toISOString(),
      updatedAt: res.updated_at.toISOString(),
    };

    callback(null, { placementEntry });
  } catch (err) {
    callback(
      {
        code: 404,
        message: err,
        status: grpc.status.NOT_FOUND,
      },
      null
    );
  }
};

const savePlacementEntry = async (call, callback) => {
  try {
    const placementEntry = call.request.placementEntry;
    console.log(placementEntry);
    const _placementEntry = {
      student_id: placementEntry.studentId,
      company_id: placementEntry.companyId,
      year: placementEntry.year,
      LPA: placementEntry.LPA,
    };

    const message = await placementController.create(_placementEntry);
    callback(null, { message });
  } catch (err) {
    callback(
      {
        code: 500,
        message: err,
        status: grpc.status.UNKNOWN,
      },
      null
    );
  }
};

const updatePlacementEntry = async (call, callback) => {
  try {
    const placementEntry = call.request.placementEntry;
    const _placementEntry = {
      student_id: placementEntry.studentId,
      company_id: placementEntry.companyId,
      year: placementEntry.year,
      LPA: placementEntry.LPA,
    };

    const message = await placementController.update(_placementEntry);
    callback(null, { message });
  } catch (err) {
    callback(
      {
        code: 500,
        message: err,
        status: grpc.status.UNKNOWN,
      },
      null
    );
  }
};

const deletePlacementEntry = async (call, callback) => {
  try {
    const message = await placementController.delete(call.request.studentId);
    callback(null, { message });
  } catch (err) {
    callback(
      {
        code: 500,
        message: err,
        status: grpc.status.UNKNOWN,
      },
      null
    );
  }
};

module.exports = {
  getAllPlacementEntries,
  getPlacementEntryById,
  savePlacementEntry,
  updatePlacementEntry,
  deletePlacementEntry,
};
