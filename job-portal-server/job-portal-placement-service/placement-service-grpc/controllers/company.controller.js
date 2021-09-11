const db = require("../models");
const company = db.company;
const Op = db.Op;

// Create and Save a new company
exports.create = (_company) => {
  // Save company in database\
  return new Promise((resolve, reject) => {
    company
      .create(_company)
      .then((res) => {
        resolve("Company saved successfully!");
      })
      .catch((err) => {
        reject("Couldn't save a company. Try Again!");
      });
  });
};

// Retrieve all company from the database.
exports.findAll = () => {
  return new Promise((resolve, reject) => {
    company
      .findAll()
      .then((res) => {
        resolve(res);
      })
      .catch((err) => {
        reject("An error occured while retrieving Companies.");
      });
  });
};

// Find a single company with an id
exports.findOne = (companyId) => {
  const id = companyId;
  return new Promise((resolve, reject) => {
    company
      .findByPk(id)
      .then((_company) => {
        if (_company) resolve(_company);
        else throw new Error(`No Company exists with id: ${id}`);
      })
      .catch((err) => {
        reject(err.message);
      });
  });
};

// Update a company by the id in the request
exports.update = (_company) => {
  const id = _company.id;
  return new Promise((resolve, reject) => {
    company
      .update(_company, {
        where: { id: id },
      })
      .then((updated) => {
        if (updated == 1) {
          resolve("Company updated successfully.");
        } else {
          throw new Error(
            `Couldn't update company with id: ${id}. Maybe company was not found or it is empty!`
          );
        }
      })
      .catch((err) => {
        reject(err.message);
      });
  });
};

// Delete a company with the specified id in the request
exports.delete = (companyId) => {
  const id = companyId;

  return new Promise((resolve, reject) => {
    company
      .destroy({
        where: { id: id },
      })
      .then((deleted) => {
        // deleted: an array containing 1 integer -> 1 for success, 0 otherwise
        if (deleted == 1) {
          resolve("Company deleted successfully!");
        } else {
          throw new Error(
            `Couldn't delete company with id: ${id}. Maybe company was not found!`
          );
        }
      })
      .catch((err) => {
        reject(err.message);
      });
  });
};

// Retrieve all company from the database.
exports.getPlacementDetails = (companyId) => {
  const id = companyId;

  return new Promise((resolve, reject) => {
    company
      .findOne({
        where: { id: id },
        include: ["placement_details"],
      })
      .then((res) => {
        resolve(res);
      })
      .catch((err) => {
        reject(
          "An error occured while retrieving placement details for given company."
        );
      });
  });
};
