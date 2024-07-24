CREATE TABLE Job (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     title VARCHAR(255) NOT NULL,
                     city VARCHAR(255) NOT NULL,
                     description VARCHAR(255) NOT NULL,
                     skills VARCHAR(255) NOT NULL,
                     experience VARCHAR(255) NOT NULL
);
CREATE TABLE User (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      firstName VARCHAR(255) NOT NULL,
                      lastName VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL
)

