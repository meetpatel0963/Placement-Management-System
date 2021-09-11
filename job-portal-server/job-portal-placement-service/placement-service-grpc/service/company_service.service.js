const grpc = require("grpc");
const companyController = require("../controllers/company.controller");

const getAllCompanies = async (call, callback) => {
  try {
    const res = await companyController.findAll();

    let companies = [];
    res.forEach((company) => {
      company = company.dataValues;
      const _company = {
        companyId: company.id,
        companyName: company.name,
        createdAt: company.created_at.toISOString(),
        updatedAt: company.updated_at.toISOString(),
      };
      companies.push(_company);
    });

    callback(null, { companies });
  } catch (err) {
    callback(
      {
        code: 500,
        message: err.message,
        status: grpc.status.UNKNOWN,
      },
      null
    );
  }
};

const getCompanyById = async (call, callback) => {
  try {
    const res = await companyController.findOne(call.request.companyId);

    const company = {
      companyId: res.dataValues.id,
      companyName: res.dataValues.name,
      createdAt: res.created_at.toISOString(),
      updatedAt: res.updated_at.toISOString(),
    };

    callback(null, { company });
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

const saveCompany = async (call, callback) => {
  try {
    const company = call.request.company;
    const _company = {
      id: company.companyId,
      name: company.companyName,
    };

    const message = await companyController.create(_company);
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

const updateCompany = async (call, callback) => {
  try {
    const company = call.request.company;
    const _company = {
      id: company.companyId,
      name: company.companyName,
    };

    const message = await companyController.update(_company);
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

const deleteCompany = async (call, callback) => {
  try {
    const message = await companyController.delete(call.request.companyId);
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

const getPlacementDetails = async (call, callback) => {
  try {
    let res = await companyController.getPlacementDetails(
      call.request.companyId
    );

    res = res.dataValues.placement_details;

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
        message: err.message,
        status: grpc.status.UNKNOWN,
      },
      null
    );
  }
};

module.exports = {
  getAllCompanies,
  getCompanyById,
  saveCompany,
  updateCompany,
  deleteCompany,
  getPlacementDetails,
};
