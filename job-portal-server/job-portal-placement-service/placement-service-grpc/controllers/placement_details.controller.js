const db = require("../models");
const placementDetails = db.placementDetails;
const Op = db.Op;

// Create and Save a new PlacementEntry
exports.create = (placementEntry) => {
  // Save PlacementEntry in database
  return new Promise((resolve, reject) => {
    placementDetails
      .create(placementEntry)
      .then((res) => {
        resolve("PlacementEntry saved successfully!");
      })
      .catch((err) => {
        reject("Couldn't create a PlacementEntry. Try Again!");
      });
  });
};

// Retrieve all PlacementEntry from the database.
exports.findAll = () => {
  return new Promise((resolve, reject) => {
    placementDetails
      .findAll()
      .then((res) => {
        resolve(res);
      })
      .catch((err) => {
        reject("An error occured while retrieving PlacementEntries.");
      });
  });
};

// Find a single PlacementEntry with an id
exports.findOne = (studentId) => {
  const id = studentId;
  return new Promise((resolve, reject) => {
    placementDetails
      .findByPk(id)
      .then((res) => {
        if (res) resolve(res);
        else throw new Error(`No PlacementEntry exists with id: ${id}.`);
      })
      .catch((err) => {
        reject(err.message);
      });
  });
};

// Update a PlacementEntry by the id in the request
exports.update = (placementEntry) => {
  const id = placementEntry.student_id;

  return new Promise((resolve, reject) => {
    placementDetails
      .update(placementEntry, {
        where: { student_id: id },
      })
      .then((updated) => {
        if (updated == 1) {
          resolve("PlacementEntry updated successfully.");
        } else {
          throw new Error(
            `Couldn't update PlacementEntry with id: ${id}. Maybe PlacementEntry was not found or it is empty!`
          );
        }
      })
      .catch((err) => {
        reject(err.message);
      });
  });
};

// Delete a PlacementEntry with the specified id in the request
exports.delete = (studentId) => {
  const id = studentId;
  return new Promise((resolve, reject) => {
    placementDetails
      .destroy({
        where: { student_id: id },
      })
      .then((deleted) => {
        if (deleted == 1) {
          resolve("PlacementEntry deleted successfully!");
        } else {
          throw new Error(
            `Couldn't delete PlacementEntry with id: ${id}. Maybe PlacementEntry was not found!`
          );
        }
      })
      .catch((err) => {
        reject(err.message);
      });
  });
};
