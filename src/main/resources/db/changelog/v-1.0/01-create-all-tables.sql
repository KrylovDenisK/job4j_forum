CREATE TABLE roles (
	id 			SERIAL PRIMARY KEY,
	name 		VARCHAR(255) NOT NULL UNIQUE
)
GO
INSERT INTO roles(name) VALUES ('ROLE_USER')
GO
CREATE TABLE users (
    id          SERIAL PRIMARY KEY,
    username    VARCHAR(255) UNIQUE,
    password    VARCHAR(255),
    email       VARCHAR(255),
    enabled     BOOLEAN DEFAULT TRUE
)
GO
CREATE TABLE users_roles (
	username_id INTEGER REFERENCES users(id),
	role_id 	INTEGER REFERENCES roles(id),
	PRIMARY KEY(username_id, role_id)
)
GO
CREATE TABLE posts (
	id 			SERIAL PRIMARY KEY,
	name 		VARCHAR(255) NOT NULL,
	description VARCHAR(255),
	author_id 	INTEGER NOT NULL REFERENCES users(id)
)
GO
CREATE TABLE topics (
	id 			SERIAL PRIMARY KEY,
	name 		VARCHAR(255) NOT NULL,
	description VARCHAR(255),
	post_id     INTEGER NOT NULL REFERENCES posts(id),
	author_id 	INTEGER NOT NULL REFERENCES users(id)
)
GO
CREATE TABLE comments (
	id 			SERIAL PRIMARY KEY,
	text 		VARCHAR(255) NOT NULL,
	topic_id    INTEGER NOT NULL REFERENCES topics(id),
	author_id 	INTEGER NOT NULL REFERENCES users(id),
	created     TIMESTAMP
)
GO

