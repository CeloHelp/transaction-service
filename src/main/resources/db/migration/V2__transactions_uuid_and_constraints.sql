DROP TABLE IF EXISTS transactions;

CREATE TABLE transactions (
    id VARCHAR(36) PRIMARY KEY,
    account_id VARCHAR(36) NOT NULL,
    amount NUMERIC(14,2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT chk_transactions_id_uuid CHECK (id ~ '^[0-9a-fA-F-]{36}$'),
    CONSTRAINT chk_transactions_account_id_uuid CHECK (account_id ~ '^[0-9a-fA-F-]{36}$'),
    CONSTRAINT chk_transactions_currency_iso CHECK (currency ~ '^[A-Z]{3}$')
);

CREATE INDEX idx_transactions_account_id ON transactions(account_id);
