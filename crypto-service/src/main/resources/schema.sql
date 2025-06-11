CREATE TABLE IF NOT EXISTS crypto_latest_price (
     symbol VARCHAR(10) NOT NULL PRIMARY KEY,
     bid_price DECIMAL(25, 8) NOT NULL ,
     ask_price DECIMAL(25, 8) NOT NULL,
     last_update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_info (
    id INT auto_increment NOT NULL PRIMARY KEY,
    login_id VARCHAR(50)
    last_update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_balance (
    user_id NOT NULL PRIMARY KEY,
    currency_code VARCHAR(10) PRIMARY KEY,
    balance DECIMAL(25,8) NOT NULL DEFAULT 0,
    last_update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references user_info(id)
);


CREATE TABLE IF NOT EXISTS trading_transaction (
    id INT auto_increment NOT NULL PRIMARY KEY,
    symbol VARCHAR(10),
    user_id INT NOT NULL,
    amount DECIMAL(25,8) NOT NULL,
    price DECIMAL(25,8) NOT NULL,
    transaction_type ENUM('SELL', 'BUY') NOT NULL,
    transaction_date_time TIMESTAMP NOT NULL,
    last_update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    KEY transaction_date_time(`user_id`,`transaction_type`, `transaction_date_time`)
);


