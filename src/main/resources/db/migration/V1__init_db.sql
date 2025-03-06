DROP SEQUENCE IF EXISTS "author_id_seq";
CREATE SEQUENCE author_id_seq START WITH 1 INCREMENT BY 1;

DROP TABLE IF EXISTS "authors";
CREATE TABLE "authors" (
    "id" INTEGER NOT NULL DEFAULT nextval('author_id_seq'),
    "age" SMALLINT,
    "description" VARCHAR(512),
    "image" VARCHAR(512),
    "name" VARCHAR(512),
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "books";
CREATE TABLE "books" (
    "isbn" VARCHAR(19) NOT NULL,
    "description" VARCHAR(2048),
    "image" VARCHAR(512),
    "title" VARCHAR(512),
    "author_id" INTEGER,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "books_author_id_fkey"
    FOREIGN KEY ("author_id") REFERENCES "authors"("id")
    ON DELETE SET NULL
);