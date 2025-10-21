-- V1__init.sql
CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS client (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  risk_profile VARCHAR(64),
  liquidity NUMERIC
);

CREATE TABLE IF NOT EXISTS asset (
  id SERIAL PRIMARY KEY,
  ticker VARCHAR(64),
  asset_class VARCHAR(64),
  risk NUMERIC,
  exp_return NUMERIC
);

CREATE TABLE IF NOT EXISTS portfolio (
  id SERIAL PRIMARY KEY,
  client_id INTEGER REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS position (
  id SERIAL PRIMARY KEY,
  portfolio_id INTEGER REFERENCES portfolio(id),
  asset_id INTEGER REFERENCES asset(id),
  weight NUMERIC
);
