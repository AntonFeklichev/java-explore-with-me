DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
    user_id  BIGINT GENERATED BY DEFAULT AS IDENTITY,
    email    VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id),
    CONSTRAINT uq_email UNIQUE (email)
);

CREATE TABLE category
(
    category_id   BIGINT GENERATED BY DEFAULT AS IDENTITY,
    category_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (category_id),
    CONSTRAINT uq_category_name UNIQUE (category_name)
);

CREATE TABLE IF NOT EXISTS location
(
    location_id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    latitude    DECIMAL(8, 6) NOT NULL,
    longitude   DECIMAL(9, 6) NOT NULL,
    CONSTRAINT pk_location PRIMARY KEY (location_id),
    CONSTRAINT uq_location UNIQUE (latitude, longitude)
);
CREATE TABLE IF NOT EXISTS event
(
    event_id           BIGINT GENERATED BY DEFAULT AS IDENTITY,
    annotation         VARCHAR(1023)               NOT NULL,
    category_id        BIGINT,
    confirmed_requests BIGINT,
    description        VARCHAR(2047),
    created_on         TIMESTAMP WITHOUT TIME ZONE,
    event_date         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    initiator_id       BIGINT,
    location_id        BIGINT,
    is_paid            BOOLEAN                     NOT NULL,
    participant_limit  INT,
    published_on       TIMESTAMP WITHOUT TIME ZONE,
    is_moderated       BOOLEAN DEFAULT TRUE,
    state              VARCHAR(255),
    title              VARCHAR(255)                NOT NULL,
    views              BIGINT,
    CONSTRAINT pk_event PRIMARY KEY (event_id),
    CONSTRAINT fk_event_user FOREIGN KEY (initiator_id) REFERENCES users (user_id),
    CONSTRAINT fk_event_location FOREIGN KEY (location_id) REFERENCES location (location_id),
    CONSTRAINT fk_event_category FOREIGN KEY (category_id) REFERENCES category (category_id)
);