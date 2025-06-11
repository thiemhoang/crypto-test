CREATE TABLE IF NOT EXISTS crypto_latest_price (
                                     symbol VARCHAR(10) NOT NULL PRIMARY KEY,
                                     bid_price DECIMAL(25, 8) NOT NULL ,
                                     ask_price DECIMAL(25, 8) NOT NULL,
                                     last_update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

