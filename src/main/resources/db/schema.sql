CREATE TABLE group_categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    active BOOLEAN NOT NULL,
    price INT NOT NULL
);

CREATE TABLE teachers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    patronymic VARCHAR(100),
    teacher_degree ENUM('TEACHER', 'NANNY', 'ASSISTANT') NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE TABLE groups (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    max_children_count INT NOT NULL,
    price INT NOT NULL,
    nanny_id BIGINT NOT NULL,
    group_category_id BIGINT NOT NULL,
    teacher_id BIGINT NOT NULL,
    CONSTRAINT fk_group_nanny FOREIGN KEY (nanny_id) REFERENCES teachers(id),
    CONSTRAINT fk_group_category FOREIGN KEY (group_category_id) REFERENCES group_categories(id),
    CONSTRAINT fk_group_teacher FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);

CREATE TABLE children (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    patronymic VARCHAR(100),
    date_of_birth DATE NOT NULL
);

CREATE TABLE group_children (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    children_id BIGINT NOT NULL,
    group_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    price INT,
    CONSTRAINT fk_gc_children FOREIGN KEY (children_id) REFERENCES childrens(id),
    CONSTRAINT fk_gc_group FOREIGN KEY (group_id) REFERENCES groups(id)
);

CREATE TABLE payments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    group_children_id BIGINT NOT NULL,
    amount INT NOT NULL,
    payment_date DATE NOT NULL,
    CONSTRAINT fk_payment_gc FOREIGN KEY (group_children_id) REFERENCES group_childrens(id)
);