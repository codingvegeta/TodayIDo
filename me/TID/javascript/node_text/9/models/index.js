'use strict';

const fs = require('fs');
const path = require('path');
const Sequelize = require('sequelize');
const process = require('process');
const basename = path.basename(__filename);
const env = process.env.NODE_ENV || 'development';
const config = require(__dirname + '/../config/config.json')[env];
const db = {};
const sequelize = new Sequelize(config.database, config.username, config.password, config)

db.sequelize = sequelize;

const vasename = path.basename(__filename);
fs.readdirSync(__dirname)
.filter(file => {
  return (file.indexOf('.')!== 0) && (file!== basename) && (file.slice(-3) === '.js');
})
.forEach(file => {
  const model = require(path.join(__dirname, file));
  console.log(file, model.name)
  db[model.name] = model;
  model.initiate(sequelize);
});

Object.keys(db).forEach(modelName => {
  if (db[modelName].associate) {
    db[modelName].associate(db);
  }
});

module.exports = db;
