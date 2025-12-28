CREATE TABLE tb_accounts (
                             id UUID NOT NULL,
                             customer_id UUID NOT NULL,
                             balance DECIMAL(19, 2) NOT NULL,
                             status VARCHAR(50) NOT NULL,
                             created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                             updated_at TIMESTAMP WITHOUT TIME ZONE,

                             CONSTRAINT pk_tb_accounts PRIMARY KEY (id),
                             CONSTRAINT uc_tb_accounts_customer_id UNIQUE (customer_id)
);