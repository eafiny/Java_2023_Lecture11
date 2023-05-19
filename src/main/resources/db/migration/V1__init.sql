CREATE TABLE departments (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO departments (name) VALUES
('ikt'),
('khtp');

CREATE TABLE prepods (id bigserial PRIMARY KEY, name VARCHAR(255), salary bigint, department_id bigint, FOREIGN KEY (department_id) REFERENCES departments(id));
INSERT INTO prepods (name, salary, department_id) VALUES
('John', 60000, 2),
('Peter', 50000, 1),
('Ted', 100000, 1);