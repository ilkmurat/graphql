
CREATE TABLE author (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);


CREATE TABLE book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      genre VARCHAR(100) NOT NULL,
                      author_id BIGINT,
                      FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE SET NULL
);

-- Insert authors
INSERT INTO author (id, name) VALUES (1, 'J.K. Rowling');
INSERT INTO author (id, name) VALUES (2, 'George R.R. Martin');
INSERT INTO author (id, name) VALUES (3, 'J.R.R. Tolkien');

-- Insert books
INSERT INTO book (id, title, genre, author_id) VALUES (1, 'Harry Potter and the Sorcerer''s Stone', 'Fantasy', 1);
INSERT INTO book (id, title, genre, author_id) VALUES (2, 'Harry Potter and the Chamber of Secrets', 'Fantasy', 1);
INSERT INTO book (id, title, genre, author_id) VALUES (3, 'A Game of Thrones', 'Fantasy', 2);
INSERT INTO book (id, title, genre, author_id) VALUES (4, 'A Clash of Kings', 'Fantasy', 2);
INSERT INTO book (id, title, genre, author_id) VALUES (5, 'A Storm of Swords', 'Fantasy', 2);
INSERT INTO book (id, title, genre, author_id) VALUES (6, 'The Hobbit', 'Fantasy', 3);
INSERT INTO book (id, title, genre, author_id) VALUES (7, 'The Fellowship of the Ring', 'Fantasy', 3);
INSERT INTO book (id, title, genre, author_id) VALUES (8, 'The Two Towers', 'Fantasy', 3);
