const express = require('express');
const { companyService } = require('../client');

const router = express();

router.get('/', (_, res) => {
  companyService.getAllCompanies({}, (err, data) => {
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
  companyService.getCompanyById(
    {
      companyId: id,
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
  companyService.saveCompany(
    {
      company: {
        companyId: body.companyId,
        companyName: body.companyName,
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
  companyService.updateCompany(
    {
      company: {
        companyId: body.companyId,
        companyName: body.companyName,
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
  companyService.deleteCompany(
    {
      companyId: id,
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

router.get('/placement/:id', (req, res) => {
  const id = req.params.id;
  companyService.getPlacementDetails(
    {
      companyId: id,
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
