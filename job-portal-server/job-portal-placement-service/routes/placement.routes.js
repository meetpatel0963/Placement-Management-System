const express = require('express');
const { placementService } = require('../placementClient');
const { studentService } = require('../studentClient');

const router = express();

router.get('/', (_, res) => {
  placementService.getAllPlacementEntries({}, (err, data) => {
    if (!err) {
      res.send(data);
    } else {
      res.status(err.code).send(err.message);
    }
  });
});

router.get('/:id', (req, res) => {
  const id = req.params.id;
  placementService.getPlacementEntryById(
    {
      studentId: id,
    },
    (err, data) => {
      if (!err) {
        res.send(data);
      } else {
        res.status(err.code).send(err.message);
      }
    }
  );
});

router.post('/', (req, res) => {
  const body = req.body.placementEntry;
  studentService.getStudentById(
    {
      studentId: body.studentId,
    },
    (error, data) => {
      if (!error) {
        if (data !== null) {
          placementService.savePlacementEntry(
            {
              placementEntry: {
                studentId: body.studentId,
                companyId: body.companyId,
                year: body.year,
                LPA: body.year,
              },
            },
            (err, data) => {
              if (!err) {
                res.send(data);
              } else {
                res.status(500).send("Internal Server Error Try Again!!!");
              }
            }
          );
        }
      } else {
        res.status(400).send("Couldn't find student with given Id");
      }
    }
  );
});

router.put('/:id', (req, res) => {
  const body = req.body.placementEntry;
  placementService.updatePlacementEntry(
    {
      placementEntry: {
        studentId: req.params.id,
        companyId: body.companyId,
        year: body.year,
        LPA: body.LPA,
      },
    },
    (err, data) => {
      if (!err) {
        res.send(data);
      } else {
        res.status(err.code).send(err.message);
      }
    }
  );
});

router.delete('/:id', (req, res) => {
  const id = req.params.id;
  placementService.deletePlacementEntry(
    {
      studentId: id,
    },
    (err, data) => {
      if (!err) {
        res.send(data);
      } else {
        res.status(err.code).send(err.message);
      }
    }
  );
});

module.exports = router;
