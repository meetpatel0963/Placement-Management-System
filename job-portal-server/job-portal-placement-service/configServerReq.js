const axios = require('axios');

const configServerReq = () => {
  return new Promise((resolve, reject) => {
    axios
      .get('http://localhost:8888/placement-service/default/master')
      .then((response) => {
        resolve(response);
      })
      .catch((err) => {
        reject(err.message);
      });
  });
};

module.exports.configServerReq = configServerReq;