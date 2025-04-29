-- Desactivar las restricciones de clave foránea
SET foreign_key_checks = 0;

-- TIPUS VIES
INSERT INTO tipus_vies (nom) VALUES ('Esportiva'), ('Clàssica'), ('Gel');

-- MATERIALS
INSERT INTO materials (nom) VALUES
('Corda simple 70m'), ('Corda doble'), ('Arnés'), ('Casco'), ('Peus de gat'), ('Friends n°0.5'), ('Friends n°1'), ('Friends n°2'),
('Tascons assortits'), ('Bagues cosides'), ('Tricams de colors'), ('BigBros extensibles'), ('Set de Spits'), ('Set de Parabolts'),
('Claus de roca'), ('Martell lleuger'), ('Mosquetons simples'), ('Mosquetons de seguretat'), ('Cintes exprés'),
('Dispositiu d''assegurament'), ('Piolet tècnic'), ('Crampons automàtics');

-- TIPUS ROQUES
INSERT INTO tipus_roques (nom) VALUES ('Conglomerat'), ('Granit'), ('Calcaria'), ('Arenisca'), ('Altres');

-- ANCORATGES
INSERT INTO ancoratges (nom) VALUES ('Friends'), ('Tascons'), ('Bagues'), ('Tricams'), ('BigBros'), ('Spits'), ('Parabolts'), ('Químics');

-- DIFICULTATS
INSERT INTO dificultats (nom) VALUES
('5a'), ('5b'), ('5c'), ('6a'), ('6a+'), ('6b'), ('6b+'), ('6c'), ('6c+'),
('7a'), ('7a+'), ('7b'), ('7b+'), ('7c'), ('7c+'), ('8a'), ('8a+'), ('8b'), ('8b+'), ('8c');

-- SECTORS
INSERT INTO sectors (nom, coordenades, aproximacio, numero_vies, popularitat, restriccions, id_escola) VALUES
('El Pati', '41.2610, 0.9610', 'Pista de terra 15 minuts a peu', 50, 'Alta', 'Respectar senyalització.', 2),
('La Cova Gran', '42.0065, 0.8755', 'Accés des de Vilanova de Meià', 30, 'Alta', 'Prohibit en època d''aus.', 8),
('Can Jorba', '41.6090, 1.8365', 'Sender marcat 10 minuts', 20, 'Mitjana', 'Cap restricció.', 3),
('Racó del Boix', '41.2210, 0.8450', 'Pista forestal i 5 min caminant', 15, 'Baixa', 'Tancat a l''hivern.', 1),
('Savassona Bloc', '41.9290, 2.3150', '5 min des de l''aparcament', 25, 'Baixa', 'Només bloc.', 9),
('El Vermell', '41.6170, 1.8320', 'Sender marcat 20 minuts', 40, 'Alta', 'Zones de nidificació.', 3),
('L''Estació', '41.5920, 0.9565', 'Accés curt des de la carretera', 35, 'Mitjana', 'Sense restriccions.', 4),
('La Palomera', '41.7010, 2.8440', 'Caminet des del pàrquing', 10, 'Baixa', 'Cap', 5),
('Font Freda', '42.0030, 0.8670', 'Pista ampla', 12, 'Baixa', 'Accés restringit si plou.', 8),
('El Balcó', '41.6230, 1.6700', '15 min pujant', 18, 'Mitjana', 'Respectar flora.', 7);

-- ESCOLES
INSERT INTO escoles (nom, id_localitzacio, aproximacio, numero_vies, popularitat, restriccions) VALUES
('La Mussara', 6, 'Accés des del Coll de l\'Albarca', 120, 'Alta', 'Prohibit en època de nidificació.'),
('Siurana', 6, 'Pista forestal des de Cornudella', 250, 'Alta', 'Respectar camins senyalitzats.'),
('Montserrat Nord', 9, 'Accés des de Monistrol', 180, 'Mitjana', 'Zones restringides temporals.'),
('Sadernes', 2, 'Pista des de Sadernes fins el refugi', 90, 'Mitjana', 'Prohibit en èpoques de sequera extrema.'),
('Roc de Sant Gaietà', 7, 'A peu des de la platja', 30, 'Baixa', 'Sense restriccions.'),
('Penyal d''Ifac', 1, 'Accés pel Parc Natural', 70, 'Alta', 'Cal permís especial.'),
('La Riba', 6, 'Accés a peu des del poble', 40, 'Mitjana', 'Atenció a les riuades.'),
('Vilanova de Meià', 8, 'Camí des de la pista forestal', 150, 'Alta', 'Zones protegides per aus.'),
('Savassona', 1, 'Accés fàcil des de la carretera', 25, 'Baixa', 'Només escalada de bloc.'),
('Cabrera de Mar', 10, 'Sender des del poble', 35, 'Baixa', 'No escalar després de pluges.');

-- LOCALITZACIONS
INSERT INTO localitzacions (ciutat, regio, codipostal) VALUES
('Girona', 'Girona', '17001'), ('Olot', 'Girona', '17800'), ('Blanes', 'Girona', '17300'), ('Figueres', 'Girona', '17600'),
('Lloret de Mar', 'Girona', '17310'), ('Tarragona', 'Tarragona', '43001'), ('Reus', 'Tarragona', '43201'),
('Lleida', 'Lleida', '25001'), ('Manresa', 'Barcelona', '08240'), ('Sabadell', 'Barcelona', '08201');

-- TRAMS
INSERT INTO trams (id_via, id_dificultat, llargada) VALUES
(1, 10, 25), (2, 12, 30), (3, 15, 28), (4, 18, 35), (5, 13, 22), (6, 17, 40), (7, 19, 38), (8, 11, 26), (9, 16, 34), (10, 14, 29),
(11, 13, 30), (12, 19, 32), (13, 15, 27), (14, 17, 36), (15, 18, 39), (16, 12, 31), (17, 16, 33), (18, 11, 29), (19, 14, 24), (20, 10, 20),
(21, 18, 37), (22, 16, 28), (23, 11, 25), (24, 12, 32), (25, 19, 35), (26, 17, 31), (27, 15, 26), (28, 14, 30), (29, 13, 29), (30, 10, 22),
(31, 12, 31), (32, 18, 35), (33, 17, 34), (34, 14, 29), (35, 19, 38), (36, 13, 26), (37, 15, 27), (38, 16, 32), (39, 10, 23), (40, 12, 28),
(41, 17, 35), (42, 18, 36), (43, 14, 30), (44, 11, 26), (45, 19, 39), (46, 13, 24), (47, 16, 33), (48, 15, 27), (49, 10, 25), (50, 12, 30),
(51, 19, 37), (52, 17, 32), (53, 14, 29), (54, 16, 31), (55, 11, 28), (56, 18, 38), (57, 13, 26), (58, 15, 27), (59, 10, 24), (60, 12, 31);

-- VIES
INSERT INTO vies (nom, id_tipus_via, estat, orientacio, id_ancoratge, id_tipus_roca, id_material, id_sector, creador) VALUES
("Somni Vertical", 1, "Apte", "S", 6, 3, 1, 1, 1), ("Llum d'Estiu", 1, "Apte", "E", 7, 1, 2, 2, 2), ("Fissura Roja", 2, "Apte", "O", 1, 2, 3, 3, 3), ("Gel Eterno", 3, "Apte", "N", 8, 3, 4, 4, 4),
("Paret dels Somnis", 1, "Construccio", "NE", 6, 1, 5, 5, 5), ("Ruta del Vent", 2, "Apte", "SO", 1, 4, 6, 6, 6), ("Cascada de Gel", 3, "Apte", "NO", 8, 2, 7, 7, 7), ("El Ultim Repte", 1, "Apte", "SE", 7, 3, 8, 8, 8),
("Trepitjant el Cel", 1, "Apte", "S", 7, 3, 9, 9, 9), ("Via del Fenix", 1, "Tancada", "N", 6, 3, 10, 10, 10), ("Mur de la Llibertat", 1, "Apte", "E", 6, 1, 11, 1, 11), ("Cami de Gel", 3, "Apte", "O", 8, 2, 12, 2, 12),
("Somiant l'Amanida", 2, "Apte", "S", 2, 3, 13, 3, 13), ("Cresta Blanca", 2, "Apte", "N", 2, 4, 14, 4, 14), ("Relliscant pel Gel", 3, "Construccio", "NO", 8, 3, 15, 5, 15), ("Cupula de Llum", 1, "Apte", "SE", 7, 1, 16, 6, 16),
("Cami Perdut", 1, "Apte", "SO", 7, 4, 17, 7, 17), ("Penya Segada", 1, "Apte", "N", 6, 2, 18, 8, 18), ("Mur de les Animes", 2, "Tancada", "O", 1, 2, 19, 9, 19), ("Verticals Blau", 1, "Apte", "E", 7, 3, 20, 10, 20),
("Columna de Gel", 3, "Apte", "S", 8, 1, 21, 1, 21), ("Sol Ixent", 1, "Apte", "SE", 6, 3, 22, 2, 22), ("Brisa Salada", 1, "Apte", "E", 6, 1, 1, 3, 23), ("Espina Daurada", 2, "Construccio", "SO", 2, 4, 2, 4, 24),
("Fosses de Gel", 3, "Apte", "N", 8, 2, 3, 5, 25), ("Vertex Sud", 1, "Apte", "SE", 7, 3, 4, 6, 26), ("La Cripta", 2, "Tancada", "NO", 2, 2, 5, 7, 27), ("Mur Brut", 1, "Apte", "N", 6, 3, 6, 8, 28),
("Pont Gelid", 3, "Apte", "NO", 8, 4, 7, 9, 29), ("Ruta de la Boira", 1, "Apte", "S", 7, 2, 8, 10, 30), ("Ombres de Pedra", 1, "Apte", "E", 6, 1, 9, 1, 31), ("Gel de Nit", 3, "Construccio", "N", 8, 2, 10, 2, 32),
("Torre de Fang", 2, "Apte", "SO", 1, 4, 11, 3, 33), ("Roca Viva", 1, "Apte", "SE", 7, 3, 12, 4, 34), ("Cami d'Estrelles", 2, "Apte", "NE", 2, 3, 13, 5, 35), ("Columna Salvatge", 1, "Apte", "O", 7, 4, 14, 6, 36),
("Serpentina Blanca", 1, "Apte", "NO", 7, 1, 15, 7, 37), ("Mon Gelid", 3, "Tancada", "N", 8, 2, 16, 8, 38), ("Sender Vertical", 1, "Apte", "SE", 6, 3, 17, 9, 39), ("Arbre Blau", 2, "Apte", "O", 1, 3, 18, 10, 40),
("Limits Infinits", 1, "Apte", "E", 7, 2, 19, 1, 41), ("Pont de la Gelor", 3, "Apte", "NO", 8, 4, 20, 2, 42), ("Drecera de Gel", 3, "Apte", "N", 8, 1, 21, 3, 43), ("Caminant a l'Horitzo", 1, "Apte", "SO", 7, 3, 22, 4, 44),
("Mur del Nord", 1, "Apte", "N", 7, 2, 1, 5, 45), ("Passadis del Gel", 3, "Construccio", "NO", 8, 4, 2, 6, 46), ("Parets Vermelles", 2, "Tancada", "E", 2, 1, 3, 7, 47), ("Arc de Roca", 1, "Apte", "SE", 7, 3, 4, 8, 48),
("Raco Esborrat", 1, "Apte", "SO", 7, 4, 5, 9, 49), ("Glacada Blanca", 3, "Apte", "N", 8, 3, 6, 10, 50), ("Pujada Improbable", 1, "Apte", "N", 6, 2, 7, 1, 51), ("Vertical Sud", 1, "Apte", "S", 7, 1, 8, 2, 52),
("Sender Gelid", 3, "Apte", "NO", 8, 4, 9, 3, 53), ("Escletxa de Llum", 1, "Apte", "SE", 7, 2, 10, 4, 54), ("Via de la Tramuntana", 1, "Apte", "NE", 7, 3, 11, 5, 55), ("Columna Fosca", 3, "Tancada", "O", 8, 2, 12, 6, 56),
("Raco de l'Estiu", 2, "Apte", "SO", 2, 1, 13, 7, 57), ("Gelor Eternal", 3, "Apte", "N", 8, 3, 14, 8, 58), ("Pont d'Estrelles", 1, "Apte", "E", 7, 4, 15, 9, 59), ("Relliscada Suau", 1, "Apte", "S", 7, 1, 16, 10, 60);



-- ESCALADORS ADDICIONALS
INSERT INTO escaladors (nom, alies, edat, nivell_maxim, via_nivell_max, estil_preferit) VALUES
('Pau Vidal', 'Puça', 24, '6b', 2, 'Esportiva'), ('Joan Riera', 'Tritó', 31, '7a', 4, 'Clàssica'), ('Marina Font', 'Mimi', 22, '6c+', 5, 'Esportiva'),
('Oriol Bosch', 'Niu', 27, '7b', 7, 'Clàssica'), ('Laia Serra', 'Sargantana', 26, '6b+', 8, 'Esportiva'), ('Arnau Puig', 'Tàndem', 29, '7c', 10, 'Gel'),
('Marc Rovira', 'Tigre', 28, '7a+', 11, 'Esportiva'), ('Eva Vila', 'Vora', 24, '6c', 12, 'Gel'), ('Albert Prats', 'Escarabat', 30, '7b+', 13, 'Clàssica'),
('Carla Casals', 'Muguet', 23, '6a+', 14, 'Esportiva'), ('Guillem Sala', 'Tauró', 25, '7c+', 15, 'Clàssica'), ('Marta Bosch', 'Corall', 26, '7a', 16, 'Gel'),
('Sergi Roig', 'Llop', 29, '7b', 17, 'Esportiva'), ('Anna Vidal', 'Lluna', 22, '6b', 18, 'Clàssica'), ('Roger Grau', 'Ratolí', 27, '7c', 19, 'Gel'),
('Núria Roca', 'Mussol', 25, '7a+', 20, 'Esportiva'), ('Gerard Puig', 'Illa', 26, '7b', 21, 'Gel'), ('Laura Cabot', 'Pols', 28, '6c+', 22, 'Clàssica'),
('Xavier Soler', 'Dofí', 30, '7c+', 23, 'Esportiva'), ('Judith Mir', 'Orella', 23, '6b+', 24, 'Gel'), ('Pere Bosch', 'Aligot', 29, '7a', 25, 'Clàssica'),
('Aina Vidal', 'Brisa', 24, '6c', 26, 'Esportiva'), ('Jordi Vidal', 'Falcó', 27, '7b+', 27, 'Gel'), ('Carme Rovira', 'Esquirol', 25, '6b', 28, 'Esportiva'),
('David Font', 'Àguila', 30, '7c', 29, 'Clàssica'), ('Irene Sala', 'Drac', 28, '7a+', 30, 'Gel'), ('Toni Roca', 'Foca', 26, '6c+', 31, 'Esportiva'),
('Clara Vidal', 'Garça', 23, '6b+', 32, 'Clàssica'), ('Ferran Grau', 'Tortuga', 31, '7b', 33, 'Esportiva'), ('Elena Vila', 'Voltor', 27, '7a', 34, 'Gel'),
('Elena Vila', 'Esquirol', 21, '7c', 28, 'Esportiva');

-- HISTORIAL_ESTATS_VIES
INSERT INTO historial_estats_vies (id_via, estat_previ, estat_actual, data_canvi) VALUES
(1, 'Construcció', 'Apte', '2024-03-01'), (2, 'Apte', 'Tancada', '2024-04-10'), (3, 'Tancada', 'Apte', '2024-02-20'),
(4, 'Construcció', 'Apte', '2024-03-15'), (5, 'Apte', 'Construcció', '2024-04-05'), (6, 'Apte', 'Tancada', '2024-05-02'),
(7, 'Tancada', 'Apte', '2024-02-27'), (8, 'Construcció', 'Apte', '2024-03-22'), (9, 'Apte', 'Apte', '2024-03-30'),
(10, 'Tancada', 'Apte', '2024-04-12'), (11, 'Construcció', 'Apte', '2024-04-01'), (12, 'Apte', 'Tancada', '2024-03-25'),
(13, 'Apte', 'Apte', '2024-03-05'), (14, 'Tancada', 'Apte', '2024-02-28'), (15, 'Apte', 'Construcció', '2024-03-15'),
(16, 'Apte', 'Apte', '2024-04-20'), (17, 'Construcció', 'Apte', '2024-03-18'), (18, 'Apte', 'Tancada', '2024-04-07'),
(19, 'Tancada', 'Apte', '2024-03-30'), (20, 'Apte', 'Apte', '2024-04-10'), (21, 'Construcció', 'Apte', '2024-03-01'),
(22, 'Apte', 'Apte', '2024-04-05'), (23, 'Tancada', 'Apte', '2024-02-24'), (24, 'Apte', 'Construcció', '2024-04-15'),
(25, 'Apte', 'Tancada', '2024-04-03'), (26, 'Construcció', 'Apte', '2024-03-20'), (27, 'Apte', 'Apte', '2024-03-10'),
(28, 'Tancada', 'Apte', '2024-02-18'), (29, 'Apte', 'Construcció', '2024-03-05'), (30, 'Apte', 'Apte', '2024-03-30');

-- Desactivar las restricciones de clave foránea
SET foreign_key_checks = 1;