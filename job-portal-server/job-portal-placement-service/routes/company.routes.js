const express = require('express');
const { companyService } = require('../placementClient');
const nconf = require('nconf');

const router = express();

router.get('/', (_, res) => {
  companyService.getAllCompanies({}, (err, data) => {
    if (!err) {
      res.send(data);
    } else {
      console.log(err);
      res.status(err.code).send(err.message);
    }
  });
});


router.post('/', (req, res) => {
  const body = req.body.company;
  companyService.saveCompany(
    {
      company: {
        companyId: body.companyId,
        companyName: body.companyName,
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

router.put('/:id', (req, res) => {
  const body = req.body.company;
  companyService.updateCompany(
    {
      company: {
        companyId: req.params.id,
        companyName: body.companyName,
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
  companyService.deleteCompany(
    {
      companyId: id,
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

router.get('/placement/:id', (req, res) => {
  const id = req.params.id;
  companyService.getPlacementDetails(
    {
      companyId: id,
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
