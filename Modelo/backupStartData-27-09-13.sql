--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.12
-- Dumped by pg_dump version 9.2.2
-- Started on 2013-09-27 15:10:19

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 1966 (class 0 OID 36970)
-- Dependencies: 153
-- Data for Name: basic_data; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--

INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (1, 'BUDGET', 'RESIDENCIAL', 'BUILDING TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (2, 'BUDGET', 'COMERCIAL', 'BUILDING TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (3, 'BUDGET', 'EMPRESARIAL', 'BUILDING TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (4, 'BUDGET', 'HOSPITAL', 'BUILDING TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (5, 'BUDGET', 'HOTEL', 'BUILDING TYPE', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (6, 'BUDGET', 'INDUSTRIAL', 'BUILDING TYPE', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (7, 'BUDGET', 'PASAJERO', 'ELEVATOR TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (9, 'BUDGET', 'PANORAMICO', 'ELEVATOR TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (10, 'BUDGET', 'CARGA', 'ELEVATOR TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (12, 'BUDGET', 'MONTA PLATO', 'ELEVATOR TYPE', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (13, 'BUDGET', 'WINCHE', 'ELEVATOR TYPE', false, 7, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (14, 'BUDGET', '320 Kg - 4 Pers', 'ELEVATOR CAPACITANCE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (15, 'BUDGET', '450 Kg - 6 Pers', 'ELEVATOR CAPACITANCE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (16, 'BUDGET', '600 Kg - 8 Pers', 'ELEVATOR CAPACITANCE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (61, 'BUDGET', 'PL-PERFORADO LISO (HIERRO)', 'ROOF TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (56, 'BUDGET', 'FORMICA - HORIZONTAL CON ESQUINERO EN ACERO INOX. REDONDO', 'DESIGN', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (57, 'BUDGET', 'FORMICA - VERTICAL TIPO PANEL', 'DESIGN', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (58, 'BUDGET', 'FORMICA', 'DESIGN', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (59, 'BUDGET', 'PL-3 ACERO ESPEJO LED', 'ROOF TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (60, 'BUDGET', 'PL-PERFORADO CURVO (HIERRO)', 'ROOF TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (62, 'BUDGET', 'CORTA', 'BUTTON TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (53, 'BUDGET', 'DISENO LISO', 'CABIN MODEL', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (54, 'BUDGET', 'DISENO PANEL', 'CABIN MODEL', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (55, 'BUDGET', 'FORMICA - HORIZONTAL CON ESQUINERO EN ACERO INOX. RECTO', 'DESIGN', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (63, 'BUDGET', 'CORTA CON CITOFONO', 'BUTTON TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (64, 'BUDGET', 'RECTO', 'RAILING', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (65, 'BUDGET', 'TUBULAR', 'RAILING', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (66, 'BUDGET', 'DOBLE PASAMANO TUBULAR', 'RAILING', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (67, 'BUDGET', 'VINIL', 'FLOOR TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (68, 'BUDGET', 'VULCA DE SEGURIDAD', 'FLOOR TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (70, 'BUDGET', 'OTROS', 'FLOOR TYPE', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (71, 'BUDGET', '1 - 450 KG', 'FAN', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (72, 'BUDGET', '1 - 600 KG', 'FAN', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (73, 'BUDGET', '2 - 800 KG', 'FAN', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (74, 'BUDGET', '2 - 1000 KG', 'FAN', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (75, 'BUDGET', '2 - 1200 KG', 'FAN', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (76, 'BUDGET', '2 - 1500 KG', 'FAN', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (77, 'BUDGET', 'APERTURA TELESCOPICA IZQUIERDA', 'DOOR TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (78, 'BUDGET', 'APERTURA TELESCOPICA DERECHA', 'DOOR TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (79, 'BUDGET', 'APERTURA TELESCOPICA CENTRAL', 'DOOR TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (80, 'BUDGET', 'APERTURA CENTRAL', 'DOOR TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (81, 'BUDGET', 'BATIENTE IZQUIERDA', 'DOOR TYPE', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (82, 'BUDGET', 'ALTO TRAFICO ELECTRONICA PANASONIC', 'DOOR SYSTEM', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (83, 'BUDGET', '40 X 50', 'DOOR FRAME TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (84, 'BUDGET', 'ABIERTO RECTO', 'DOOR FRAME TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (85, 'BUDGET', 'OCULTO', 'DOOR FRAME TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (11, 'BUDGET', 'MONTA COCHE', 'ELEVATOR TYPE', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (17, 'BUDGET', '750 Kg - 10 Pers', 'ELEVATOR CAPACITANCE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (18, 'BUDGET', '1050 Kg - 13 Pers', 'ELEVATOR CAPACITANCE', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (19, 'BUDGET', '1200 Kg - 16 Pers', 'ELEVATOR CAPACITANCE', false, 7, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (20, 'BUDGET', '1500 Kg - 20 Pers', 'ELEVATOR CAPACITANCE', false, 8, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (21, 'BUDGET', '2000 Kg - 26 Pers', 'ELEVATOR CAPACITANCE', false, 9, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (23, 'BUDGET', 'SIN SALA DE MAQUINA MRL', 'MACHINE TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (32, 'BUDGET', '0.5', 'SPEED', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (24, 'BUDGET', 'HIDRAULICO', 'MACHINE TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (25, 'BUDGET', 'WINCHE', 'MACHINE TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (26, 'BUDGET', '1 PUERTA', 'BUILDING EMBARQUE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (22, 'BUDGET', 'CON SALA DE MAQUINA VVVF', 'MACHINE TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (27, 'BUDGET', '2 PUERTAS (DOBLE ACCESO - 180)', 'BUILDING EMBARQUE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (28, 'BUDGET', '2 PUERTAS (DOBLE ACCESO - 90)', 'BUILDING EMBARQUE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (29, 'BUDGET', '2 PUERTAS (DOBLE ACCESO - 270)', 'BUILDING EMBARQUE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (30, 'BUDGET', '208V', 'ELECTRICITY TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (31, 'BUDGET', '440V', 'ELECTRICITY TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (33, 'BUDGET', '1', 'SPEED', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (34, 'BUDGET', '1.2', 'SPEED', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (35, 'BUDGET', '1.6', 'SPEED', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (36, 'BUDGET', '1.75', 'SPEED', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (37, 'BUDGET', '2', 'SPEED', false, 7, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (38, 'BUDGET', '2.5', 'SPEED', false, 8, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (39, 'BUDGET', '60 HZ', 'FREQUENCY', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (40, 'BUDGET', '50 HZ', 'FREQUENCY', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (41, 'BUDGET', '110V', 'VOLTAGE LIGHTING', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (42, 'BUDGET', '220V', 'VOLTAGE LIGHTING', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (43, 'BUDGET', '180 HORAS (STANDARD)', 'HOUR MACHINE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (44, 'BUDGET', '240 HORAS (ALTO TRAFICO)', 'HOUR MACHINE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (45, 'BUDGET', 'COLECTIVA EN DESC SIMPLEX (UN BOTON)', 'MANEUVER TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (46, 'BUDGET', 'COLECTIVA EN DESC DUPLEX (UN BOTON)', 'MANEUVER TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (47, 'BUDGET', 'COLECTIVA EN DESC TRIPLEX (UN BOTON)', 'MANEUVER TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (48, 'BUDGET', 'COLECTIVA EN DESC CUADRUPLEX (UN BOTON)', 'MANEUVER TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (49, 'BUDGET', 'COLECTIVO EN ASC Y DESC SIMPLEX (DOS BOTONES)', 'MANEUVER TYPE', false, 9, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (50, 'BUDGET', 'COLECTIVO EN ASC Y DESC DUPLEX (DOS BOTONES)', 'MANEUVER TYPE', false, 10, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (51, 'BUDGET', 'COLECTIVO EN ASC Y DESC TRIPLEX (DOS BOTONES)', 'MANEUVER TYPE', false, 11, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (52, 'BUDGET', 'COLECTIVO EN ASC Y DESC CUADRUPLEX (DOS BOTONES)', 'MANEUVER TYPE', false, 12, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (130, 'BUDGET', 'ESTANDAR SEGUN MODELO', 'MACHINE BASE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (131, 'BUDGET', 'ESPECIAL', 'MACHINE BASE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (133, 'BUDGET', 'SIN ESPEJO', 'MIRROR', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (134, 'BUSINESS PARTNER', 'G', 'RIF TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (101, 'BUDGET', 'STEP TFT DE 7''''', 'FLOOR DISPLAY', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (100, 'BUDGET', 'STEP LCD AZUL', 'FLOOR DISPLAY', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (95, 'BUDGET', 'STEP ACERO STANDARD', 'BOOTH BUTTON', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (97, 'BUDGET', 'STEP TOUCH VIDRIO', 'BOOTH BUTTON', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (116, 'BUDGET', 'STEP ACERO STANDARD', 'HALL BUTTON', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (122, 'BUDGET', 'PL-MODULAR ESCALONADO (FERIA)', 'ROOF TYPE', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (86, 'BUDGET', '700 mm', 'FREE ADMISSION', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (87, 'BUDGET', '800 mm', 'FREE ADMISSION', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (88, 'BUDGET', '900 mm', 'FREE ADMISSION', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (89, 'BUDGET', '1000 mm', 'FREE ADMISSION', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (90, 'BUDGET', '1100 mm', 'FREE ADMISSION', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (91, 'BUDGET', '1200 mm', 'FREE ADMISSION', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (92, 'BUDGET', '2000 mm', 'HEIGHT', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (93, 'BUDGET', '2100 mm', 'HEIGHT', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (94, 'BUDGET', 'CONTROL ELECTRONICO PLC-24 (INTELIGENTE CON MICROPROCESADOR, DETECTOR DE AVERIAS Y VARIADOR DE FRECUENCIA)', 'CONTROL TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (96, 'BUDGET', 'STEP ACERO SATINADO', 'BOOTH BUTTON', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (98, 'BUDGET', 'STEP LCD AZUL', 'BOOTH DISPLAY', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (99, 'BUDGET', 'STEP TFT DE 7''''', 'BOOTH DISPLAY', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (102, 'BUDGET', 'MEDIO ESPEJO', 'MIRROR', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (103, 'BUDGET', 'ESPEJO COMPLETO', 'MIRROR', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (104, 'BUDGET', 'COLECTIVA EN ASC SIMPLEX (UN BOTON)', 'MANEUVER TYPE', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (105, 'BUDGET', 'COLECTIVA EN ASC DUPLEX (UN BOTON)', 'MANEUVER TYPE', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (106, 'BUDGET', 'COLECTIVA EN ASC TRIPLEX (UN BOTON)', 'MANEUVER TYPE', false, 7, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (107, 'BUDGET', 'COLECTIVA EN ASC CUADRUPLEX (UN BOTON)', 'MANEUVER TYPE', false, 8, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (108, 'BUDGET', 'BATIENTE DERECHA', 'DOOR TYPE', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (109, 'BUDGET', 'GUILLOTINA', 'DOOR TYPE', false, 7, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (110, 'BUDGET', 'TIPO CORTINA', 'DOOR TYPE', false, 8, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (111, 'BUDGET', 'ACERO INOX. 304-4 HORIZONTAL CON ESQUINERO EN ACERO INOX.', 'DESIGN', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (112, 'BUDGET', 'ACERO INOX. 304-4 VERTICAL', 'DESIGN', false, 7, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (113, 'BUDGET', 'GRIS', 'DOOR FRAME HAMMERED', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (114, 'BUDGET', 'BEIGE', 'DOOR FRAME HAMMERED', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (115, 'BUDGET', 'ESPECIAL CURVO (FERIA)', 'DOOR FRAME TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (117, 'BUDGET', 'STEP ACERO SATINADO', 'HALL BUTTON', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (118, 'BUDGET', '1.5', 'SPEED', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (120, 'BUDGET', 'ACERO INOX. 430', 'DESIGN', false, 10, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (121, 'BUDGET', 'PL-ACRILICO CON ACERO INOX. LED', 'ROOF TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (124, 'BUDGET', 'ACERO INOX. ESPEJO - VERTICAL', 'DESIGN', false, 8, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (125, 'BUDGET', 'ACERO INOX. ESPEJO - HORIZONTAL CON ESQUINERO EN ACERO INOX.', 'DESIGN', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (126, 'BUDGET', 'ACERO INOX. ESPEJO', 'DESIGN', false, 11, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (127, 'BUSINESS PARTNER', 'J', 'RIF TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (128, 'BUSINESS PARTNER', 'V', 'RIF TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (129, 'BUSINESS PARTNER', 'E', 'RIF TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (132, 'BUDGET', 'OTRA', 'ELEVATOR CAPACITANCE', false, 10, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (69, 'BUDGET', 'PORCELANATO NEGRO', 'FLOOR TYPE', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (119, 'BUDGET', 'ACERO INOX. 304-4', 'DESIGN', false, 9, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (123, 'BUDGET', 'ACRILICO CON PERFIL DE ALUMINIO', 'ROOF TYPE', false, 6, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (135, 'ITEM', 'PRECIO FIJO', 'PRICE TYPE', false, 1, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (136, 'ITEM', 'PRECIO VARIABLE', 'PRICE TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (137, 'BUDGET', 'OTRO', 'DESIGN', false, 12, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (138, 'BUDGET', 'PORCELANATO BEIGE', 'FLOOR TYPE', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (139, 'BUDGET', 'NO APLICA', 'RAILING', false, 4, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (8, 'BUDGET', 'CAMILLERO - RAMPA VERTICAL', 'ELEVATOR TYPE', false, 2, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (140, 'BUDGET', 'OTROS', 'FREE ADMISSION', false, 7, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (141, 'BUDGET', 'OTROS', 'HEIGHT', false, 3, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (142, 'BUDGET', '900 Kg - 12 Pers', 'ELEVATOR CAPACITANCE', false, 5, NULL, 'A', NULL);
INSERT INTO basic_data (id_basic, data_base_name, name, field, editable, priority, imageurl, status, parent_id_basic) VALUES (143, 'BUDGET', 'STEP TOUCH VIDRIO', 'HALL BUTTON', false, 3, NULL, 'A', NULL);


--
-- TOC entry 1982 (class 0 OID 0)
-- Dependencies: 152
-- Name: basic_data_idbasic_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('basic_data_idbasic_seq', 143, true);


--
-- TOC entry 1971 (class 0 OID 36994)
-- Dependencies: 158
-- Data for Name: business_partner; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--



--
-- TOC entry 1961 (class 0 OID 36946)
-- Dependencies: 148
-- Data for Name: security_user; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--

INSERT INTO security_user (id_security_user, name, email, password, phone, new_feature, status) VALUES (1, 'Administrador', 'sistemas@ascensoresnardi.com', '67cb5c15db4909600cd6d485e7aad4305d3d9f85efdf598f5435736a8efa37fe', '0414-3534887', false, 'A');


--
-- TOC entry 1974 (class 0 OID 37004)
-- Dependencies: 161
-- Data for Name: budget; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--



--
-- TOC entry 1983 (class 0 OID 0)
-- Dependencies: 159
-- Name: budget_id_budget_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('budget_id_budget_seq', 1, true);


--
-- TOC entry 1984 (class 0 OID 0)
-- Dependencies: 160
-- Name: budget_number_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('budget_number_seq', 1, true);


--
-- TOC entry 1985 (class 0 OID 0)
-- Dependencies: 157
-- Name: business_partner_id_business_partner_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('business_partner_id_business_partner_seq', 1, true);


--
-- TOC entry 1963 (class 0 OID 36954)
-- Dependencies: 150
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--



--
-- TOC entry 1986 (class 0 OID 0)
-- Dependencies: 149
-- Name: contact_id_contact_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('contact_id_contact_seq', 1, true);


--
-- TOC entry 1958 (class 0 OID 36933)
-- Dependencies: 145
-- Data for Name: security_group; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--

INSERT INTO security_group (id_security_group, name, status) VALUES (3, 'SALES COORDINATOR', 'A');
INSERT INTO security_group (id_security_group, name, status) VALUES (4, 'LOGISTIC', 'A');
INSERT INTO security_group (id_security_group, name, status) VALUES (1, 'ADMIN', 'A');
INSERT INTO security_group (id_security_group, name, status) VALUES (2, 'SELLER', 'A');


--
-- TOC entry 1964 (class 0 OID 36963)
-- Dependencies: 151
-- Data for Name: group_user; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--

INSERT INTO group_user (id_security_user, id_security_group) VALUES (1, 1);


--
-- TOC entry 1968 (class 0 OID 36981)
-- Dependencies: 155
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--



--
-- TOC entry 1969 (class 0 OID 36987)
-- Dependencies: 156
-- Data for Name: item_basic_data; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--



--
-- TOC entry 1976 (class 0 OID 37016)
-- Dependencies: 163
-- Data for Name: quotation; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--



--
-- TOC entry 1977 (class 0 OID 37025)
-- Dependencies: 164
-- Data for Name: item_by_quotation; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--



--
-- TOC entry 1987 (class 0 OID 0)
-- Dependencies: 154
-- Name: item_id_item_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('item_id_item_seq', 1, true);


--
-- TOC entry 1988 (class 0 OID 0)
-- Dependencies: 162
-- Name: quotation_id_quotation_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('quotation_id_quotation_seq', 1, true);


--
-- TOC entry 1956 (class 0 OID 36925)
-- Dependencies: 143
-- Data for Name: security_role; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--

INSERT INTO security_role (id_security_role, name, status) VALUES (1, 'ROLE_USER', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (2, 'ROLE_SECURITY_PROFILE', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (3, 'ROLE_SECURITY_GROUPS', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (4, 'ROLE_BUDGET', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (5, 'ROLE_MENU', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (6, 'ROLE_REPORT', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (7, 'ROLE_WINDOW_BUDGETS', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (8, 'ROLE_SECURITY_USERS_MASTER', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (9, 'ROLE_QUOTATION', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (10, 'ROLE_WINDOW_QUOTATIONS', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (11, 'ROLE_BUSINESS_PARTNER', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (12, 'ROLE_SALES_SUMMARY', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (13, 'ROLE_ITEM_MASTER', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (14, 'ROLE_GENERIC_HELP', 'A');
INSERT INTO security_role (id_security_role, name, status) VALUES (15, 'ROLE_EFFECTIVE_SALES', 'A');


--
-- TOC entry 1959 (class 0 OID 36939)
-- Dependencies: 146
-- Data for Name: role_group; Type: TABLE DATA; Schema: public; Owner: interlift_admin
--

INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 1);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (2, 1);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 2);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (2, 2);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 4);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (2, 4);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 5);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (2, 5);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 6);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (2, 6);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 7);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (2, 7);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 1);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 2);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 4);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 5);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 6);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 7);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 9);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 10);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 11);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (2, 11);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 11);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (3, 12);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (4, 1);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (4, 2);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (4, 5);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (4, 6);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (4, 12);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 3);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 8);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 9);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 10);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 12);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 13);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 14);
INSERT INTO role_group (id_security_group, id_security_role) VALUES (1, 15);


--
-- TOC entry 1989 (class 0 OID 0)
-- Dependencies: 144
-- Name: security_group_id_security_group_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('security_group_id_security_group_seq', 1, true);


--
-- TOC entry 1990 (class 0 OID 0)
-- Dependencies: 142
-- Name: security_role_id_security_role_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('security_role_id_security_role_seq', 14, true);


--
-- TOC entry 1991 (class 0 OID 0)
-- Dependencies: 147
-- Name: security_user_id_security_user_seq; Type: SEQUENCE SET; Schema: public; Owner: interlift_admin
--

SELECT pg_catalog.setval('security_user_id_security_user_seq', 1, true);


-- Completed on 2013-09-27 15:10:19

--
-- PostgreSQL database dump complete
--

