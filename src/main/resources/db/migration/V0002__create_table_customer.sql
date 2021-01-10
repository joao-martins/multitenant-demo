CREATE TABLE customer (
    id uuid PRIMARY KEY,
    name varchar,
    tenant_id varchar,

    CONSTRAINT fk_customer_tenant FOREIGN KEY(tenant_id) REFERENCES tenant(id)
);
