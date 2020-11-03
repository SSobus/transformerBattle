CREATE SEQUENCE TransformerSeq START WITH 1 INCREMENT BY 1;

INSERT INTO Transformer (id, name, type, strength, intelligence, endurance, speed, rank, courage, firepower) values (TransformerSeq.nextval, 'Ironhide', 0, 7, 5, 6, 8, 2, 7, 8);
INSERT INTO Transformer (id, name, type, strength, intelligence, endurance, speed, rank, courage, firepower) values (TransformerSeq.nextval, 'Jolt', 0, 5, 3, 4, 4, 4, 3, 5);
INSERT INTO Transformer (id, name, type, strength, intelligence, endurance, speed, rank, courage, firepower) values (TransformerSeq.nextval, 'Brains', 0, 3, 10, 8, 6, 4, 5, 2);

INSERT INTO Transformer (id, name, type, strength, intelligence, endurance, speed, rank, courage, firepower) values (TransformerSeq.nextval, 'Payload', 1, 7, 2, 5, 5, 4, 9, 8);
INSERT INTO Transformer (id, name, type, strength, intelligence, endurance, speed, rank, courage, firepower) values (TransformerSeq.nextval, 'Soundwave', 1, 5, 4, 7, 10, 8, 7, 5);
INSERT INTO Transformer (id, name, type, strength, intelligence, endurance, speed, rank, courage, firepower) values (TransformerSeq.nextval, 'Bonecrusher', 1, 10, 3, 8, 3, 6, 8, 7);