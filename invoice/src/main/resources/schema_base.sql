CREATE TABLE IF NOT EXISTS INVOICE (
  INVOICE_NUMBER BIGINT NOT NULL AUTO_INCREMENT,
  ORDER_NUMBER VARCHAR(13),
  ID_CUSTOMER BIGINT NOT NULL,
  PRIMARY KEY(INVOICE_NUMBER),
  FOREIGN KEY(ID_CUSTOMER) REFERENCES CUSTOMER(ID)
);

CREATE TABLE IF NOT EXISTS INVOICE_LINE (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  QUANTITY SMALLINT NOT NULL,
  ID_PRODUCT BIGINT NOT NULL,
  INVOICE_NUMBER BIGINT NOT NULL,
  PRIMARY KEY(ID),
  FOREIGN KEY(INVOICE_NUMBER) REFERENCES INVOICE(INVOICE_NUMBER),
  FOREIGN KEY(ID_PRODUCT) REFERENCES PRODUCT(ID)
);