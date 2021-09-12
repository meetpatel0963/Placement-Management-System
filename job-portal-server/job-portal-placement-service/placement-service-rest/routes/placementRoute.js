const express = require('express');
const { placementService } = require('../client');

const router = express();

router.get('/', (_, res) => {
  placementService.getAllPlacementEntries({}, (err, data) => {
    if (!err) {
      console.log(data);
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
        console.log(data);
        res.send(data);
      } else {
        res.status(err.code).send(err.message);
      }
    }
  );
});

router.post('/', (req, res) => {
  const body = req.body;
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
        console.log(data);
        res.send(data);
      } else {
        res.status(err.code).send(err.message);
      }
    }
  );
});

router.put('/', (req, res) => {
  const body = req.body;
  placementService.deletePlacementEntry(
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
        console.log(data);
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
        console.log(data);
        res.send(data);
      } else {
        res.status(err.code).send(err.message);
      }
    }
  );
});

module.exports = router;
