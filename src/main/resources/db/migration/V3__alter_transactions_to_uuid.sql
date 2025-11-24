ALTER TABLE transactions
    DROP CONSTRAINT IF EXISTS chk_transactions_id_uuid,
    DROP CONSTRAINT IF EXISTS chk_transactions_account_id_uuid;

ALTER TABLE transactions
    ALTER COLUMN id TYPE uuid USING id::uuid,
    ALTER COLUMN account_id TYPE uuid USING account_id::uuid;
