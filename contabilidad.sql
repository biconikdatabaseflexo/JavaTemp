﻿-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 23-10-2018 a las 03:49:46
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;

--
-- Base de datos: `contabilidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresomercaderia`
--

CREATE TABLE `ingresomercaderia` (
  `CODIGO` int(10) NOT NULL,
  `DESCRIPCION` varchar(60) NOT NULL,
  `MODELO` varchar(20) NOT NULL,
  `CANTIDAD` int(5) NOT NULL,
  `COSTOUNIT` double NOT NULL,
  `COSTOTOTAL` double NOT NULL,
  `FACTURA` varchar(20) NOT NULL,
  `FECHA` date NOT NULL,
  `PROVEEDOR` varchar(60) NOT NULL,
  `ESTADO` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ingresomercaderia`
--

INSERT INTO `ingresomercaderia` (`CODIGO`, `DESCRIPCION`, `MODELO`, `CANTIDAD`, `COSTOUNIT`, `COSTOTOTAL`, `FACTURA`, `FECHA`, `PROVEEDOR`, `ESTADO`) VALUES
(100107400, 'NAND DE 2 ENTRADAS CUADRUPLE', '74LS00', 10, 1, 10, '0001-0000765', '2015-10-20', 'PEPE S.A.', 'ANULADO'),
(200125220, 'RESISTENCIA DE PELICULA 220 - 1/4W', 'S/N', 20, 0.05, 1, '0001-0000765', '2015-10-20', 'PEPE S.A.', 'ANULADO'),
(200225010, 'RESISTENCIA DE PELICULA 10K - 1/4W', 'S/N', 15, 0.05, 0.75, '0001-0000765', '2015-10-20', 'PEPE S.A.', 'ANULADO'),
(300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 9, 0.1, 0.9, '0001-0000765', '2015-10-20', 'PEPE S.A.', 'ANULADO'),
(100174138, 'DECODIFICADOR DEMULTIPLE XOR', '74LS138', 9, 1.3, 11.7, '0001-0000801', '2015-10-20', 'JUDAS S.A.', 'CONFORME'),
(100107474, 'FLIP-FLOP TIPO D', '74LS74', 8, 2, 16, '0001-0000801', '2015-10-20', 'JUDAS S.A.', 'CONFORME'),
(100206116, 'MEMORIA RAM ESTATICA DE 2K*8 HY 6116', '6116', 8, 5.5, 44, '0001-0000801', '2015-10-20', 'JUDAS S.A.', 'CONFORME'),
(300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 6, 0.1, 0.6, '0001-0000801', '2015-10-20', 'JUDAS S.A.', 'CONFORME'),
(100107400, 'NAND DE 2 ENTRADAS CUADRUPLE', '74LS00', 4, 1, 4, '0001-0000666', '2015-10-20', 'KARINA S.A.', 'CONFORME'),
(100107402, 'NOR DE 2 ENTRADAS CUADRUPLE', '74LS02', 11, 0.1, 1.1, '0001-0000666', '2015-10-20', 'KARINA S.A.', 'CONFORME'),
(100107404, 'INVERSORES X6', '74LS04', 8, 1, 8, '0001-0000666', '2015-10-20', 'KARINA S.A.', 'CONFORME'),
(200225100, 'RESISTENCIA DE PELICULA 100K - 1/4W', 'S/N', 10, 0.05, 0.5, '0001-0000564', '2016-09-15', 'TIMOTEO S.A.', 'ANULADO'),
(300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 11, 0.1, 1.1, '0001-0000564', '2016-09-15', 'TIMOTEO S.A.', 'ANULADO'),
(100107400, 'NAND DE 2 ENTRADAS CUADRUPLE', '74LS00', 16, 1, 16, '0001-0001560', '2016-09-15', 'BARNY S.A.', 'CONFORME'),
(100107402, 'NOR DE 2 ENTRADAS CUADRUPLE', '74LS02', 2, 0.1, 0.2, '0001-0001560', '2016-09-15', 'BARNY S.A.', 'CONFORME'),
(200225100, 'RESISTENCIA DE PELICULA 100K - 1/4W', 'S/N', 13, 0.05, 0.65, '0001-0001560', '2016-09-15', 'BARNY S.A.', 'CONFORME'),
(300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 8, 0.1, 0.8, '0001-0001560', '2016-09-15', 'BARNY S.A.', 'CONFORME'),
(100206116, 'MEMORIA RAM ESTATICA DE 2K*8 HY 6116', '6116', 7, 5.5, 38.5, '0001-0005201', '2016-09-15', 'DEXTER S.A.', 'CONFORME'),
(200125220, 'RESISTENCIA DE PELICULA 220 - 1/4W', 'S/N', 8, 0.05, 0.4, '0001-0005201', '2016-09-15', 'DEXTER S.A.', 'CONFORME'),
(200225010, 'RESISTENCIA DE PELICULA 10K - 1/4W', 'S/N', 9, 0.05, 0.45, '0001-0005201', '2016-09-15', 'DEXTER S.A.', 'CONFORME'),
(100107432, 'OR DE 2 ENTRADAS CUADRUPLE', '74LS32', 10, 0.9, 9, '0001-0001563', '2017-07-18', 'BARNY S.A.', 'CONFORME'),
(100174148, 'ENCODER DE 8 A 3', '74LS148', 7, 1.5, 10.5, '0001-0001563', '2017-07-18', 'BARNY S.A.', 'CONFORME'),
(100174138, 'DECODIFICADOR DEMULTIPLE XOR', '74LS138', 3, 1.3, 3.9, '0001-0001563', '2017-07-18', 'BARNY S.A.', 'CONFORME'),
(200125220, 'RESISTENCIA DE PELICULA 220 - 1/4W', 'S/N', 1, 0.05, 0.05, '0001-0000767', '2017-07-18', 'PEPE S.A.', 'CONFORME'),
(200225010, 'RESISTENCIA DE PELICULA 10K - 1/4W', 'S/N', 2, 0.05, 0.1, '0001-0000767', '2017-07-18', 'PEPE S.A.', 'CONFORME'),
(200225001, 'RESISTENCIA DE PELICULA 1K - 1/4W', 'S/N', 3, 0.05, 0.15, '0001-0000767', '2017-07-18', 'PEPE S.A.', 'CONFORME'),
(100206116, 'MEMORIA RAM ESTATICA DE 2K*8 HY 6116', '6116', 9, 5.5, 49.5, '0001-0000566', '2018-07-18', 'TIMOTEO S.A.', 'CONFORME'),
(200125220, 'RESISTENCIA DE PELICULA 220 - 1/4W', 'S/N', 9, 0.05, 0.45, '0001-0000566', '2018-07-18', 'TIMOTEO S.A.', 'CONFORME'),
(300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 9, 0.1, 0.9, '0001-0000566', '2018-07-18', 'TIMOTEO S.A.', 'CONFORME'),
(100107448, 'DECODIFICADOR BINARIO A 7 SEGMENTOS', '74LS48', 7, 3, 21, '0001-0000668', '2018-07-18', 'KARINA S.A.', 'CONFORME'),
(100200555, 'OSCILADOR TEMPORIZADOR', 'NE555', 10, 0.1, 1, '0001-0000668', '2018-07-18', 'KARINA S.A.', 'CONFORME'),
(100107474, 'FLIP-FLOP TIPO D', '74LS74', 7, 2, 14, '0001-0000668', '2018-07-18', 'KARINA S.A.', 'CONFORME');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `CODIGO` varchar(10) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  `MODELO` varchar(10) NOT NULL,
  `STOCK` int(5) NOT NULL,
  `COSTO` float NOT NULL,
  `PRECIO` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`CODIGO`, `DESCRIPCION`, `MODELO`, `STOCK`, `COSTO`, `PRECIO`) VALUES
('100107400', 'NAND DE 2 ENTRADAS CUADRUPLE', '74LS00', 100, 1, 1.4),
('100107402', 'NOR DE 2 ENTRADAS CUADRUPLE', '74LS02', 30, 0.1, 1.5),
('100107404', 'INVERSORES X6', '74LS04', 30, 1, 1.4),
('100107432', 'OR DE 2 ENTRADAS CUADRUPLE', '74LS32', 30, 0.9, 1.3),
('100174148', 'ENCODER DE 8 A 3', '74LS148', 30, 1.5, 2.2),
('100174138', 'DECODIFICADOR DEMULTIPLE XOR', '74LS138', 30, 1.3, 2),
('100107448', 'DECODIFICADOR BINARIO A 7 SEGMENTOS', '74LS48', 30, 3, 3.8),
('100200555', 'OSCILADOR TEMPORIZADOR', 'NE555', 100, 0.1, 0.6),
('100107474', 'FLIP-FLOP TIPO D', '74LS74', 30, 2, 2.6),
('100206116', 'MEMORIA RAM ESTATICA DE 2K*8 HY 6116', '6116', 100, 5.5, 6.4),
('200125220', 'RESISTENCIA DE PELICULA 220 - 1/4W', 'S/N', 83, 0.05, 0.1),
('200225010', 'RESISTENCIA DE PELICULA 10K - 1/4W', 'S/N', 100, 0.05, 0.1),
('200225001', 'RESISTENCIA DE PELICULA 1K - 1/4W', 'S/N', 100, 0.05, 0.1),
('200225100', 'RESISTENCIA DE PELICULA 100K - 1/4W', 'S/N', 100, 0.05, 0.1),
('300216022', 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 100, 0.1, 0.2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `TICKET` int(10) NOT NULL,
  `FECHA` date NOT NULL,
  `CODIGO` int(10) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  `MODELO` varchar(10) NOT NULL,
  `CANTIDAD` int(10) NOT NULL,
  `COSTOUNIT` double NOT NULL,
  `COSTOTOTAL` double NOT NULL,
  `ESTADO` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`TICKET`, `FECHA`, `CODIGO`, `DESCRIPCION`, `MODELO`, `CANTIDAD`, `COSTOUNIT`, `COSTOTOTAL`, `ESTADO`) VALUES
(1, '2016-10-14', 100107400, 'NAND DE 2 ENTRADAS CUADRUPLE', '74LS00', 4, 1.4, 5.6, 'CONFORME'),
(1, '2016-10-14', 100107402, 'NOR DE 2 ENTRADAS CUADRUPLE', '74LS02', 4, 1.5, 6, 'CONFORME'),
(1, '2016-10-14', 300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 4, 0.2, 0.8, 'CONFORME'),
(2, '2016-10-15', 100200555, 'OSCILADOR TEMPORIZADOR', 'NE555', 5, 0.6, 3, 'CONFORME'),
(2, '2016-10-15', 100107474, 'FLIP-FLOP TIPO D', '74LS74', 5, 2.6, 13, 'CONFORME'),
(2, '2016-10-15', 100206116, 'MEMORIA RAM ESTATICA DE 2K*8 HY 6116', '6116', 5, 6.4, 32, 'CONFORME'),
(3, '2016-10-16', 100174148, 'ENCODER DE 8 A 3', '74LS148', 6, 2.2, 13.2, 'ANULADO'),
(3, '2016-10-16', 100174138, 'DECODIFICADOR DEMULTIPLE XOR', '74LS138', 6, 2, 12, 'ANULADO'),
(4, '2017-06-15', 100174148, 'ENCODER DE 8 A 3', '74LS148', 7, 2.2, 15.4, 'CONFORME'),
(4, '2017-06-15', 100174138, 'DECODIFICADOR DEMULTIPLE XOR', '74LS138', 7, 2, 14, 'CONFORME'),
(4, '2017-06-15', 100206116, 'MEMORIA RAM ESTATICA DE 2K*8 HY 6116', '6116', 7, 6.4, 44.8, 'CONFORME'),
(4, '2017-06-15', 200125220, 'RESISTENCIA DE PELICULA 220 - 1/4W', 'S/N', 7, 0.1, 0.7, 'CONFORME'),
(5, '2017-06-16', 100107448, 'DECODIFICADOR BINARIO A 7 SEGMENTOS', '74LS48', 8, 3.8, 30.4, 'CONFORME'),
(5, '2017-06-16', 100200555, 'OSCILADOR TEMPORIZADOR', 'NE555', 8, 0.6, 4.8, 'CONFORME'),
(5, '2017-06-16', 100107474, 'FLIP-FLOP TIPO D', '74LS74', 8, 2.6, 20.8, 'CONFORME'),
(5, '2017-06-16', 300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 8, 0.2, 1.6, 'CONFORME'),
(6, '2017-06-17', 200225010, 'RESISTENCIA DE PELICULA 10K - 1/4W', 'S/N', 2, 0.1, 0.2, 'ANULADO'),
(6, '2017-06-17', 200225100, 'RESISTENCIA DE PELICULA 100K - 1/4W', 'S/N', 4, 0.1, 0.4, 'ANULADO'),
(6, '2017-06-17', 300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 3, 0.2, 0.6, 'ANULADO'),
(7, '2018-07-11', 100107400, 'NAND DE 2 ENTRADAS CUADRUPLE', '74LS00', 7, 1.4, 9.8, 'CONFORME'),
(7, '2018-07-11', 100107474, 'FLIP-FLOP TIPO D', '74LS74', 2, 2.6, 5.2, 'CONFORME'),
(7, '2018-07-11', 200225001, 'RESISTENCIA DE PELICULA 1K - 1/4W', 'S/N', 6, 0.1, 0.6, 'CONFORME'),
(8, '2018-07-12', 100107400, 'NAND DE 2 ENTRADAS CUADRUPLE', '74LS00', 4, 1.4, 5.6, 'ANULADO'),
(8, '2018-07-12', 100107402, 'NOR DE 2 ENTRADAS CUADRUPLE', '74LS02', 8, 1.5, 12, 'ANULADO'),
(9, '2018-07-13', 100107432, 'OR DE 2 ENTRADAS CUADRUPLE', '74LS32', 6, 1.3, 7.8, 'CONFORME'),
(9, '2018-07-13', 100174148, 'ENCODER DE 8 A 3', '74LS148', 4, 2.2, 8.8, 'CONFORME'),
(9, '2018-07-13', 100174138, 'DECODIFICADOR DEMULTIPLE XOR', '74LS138', 7, 2, 14, 'CONFORME'),
(10, '2018-07-14', 100107404, 'INVERSORES X6', '74LS04', 3, 1.4, 4.2, 'CONFORME'),
(10, '2018-07-14', 100200555, 'OSCILADOR TEMPORIZADOR', 'NE555', 2, 0.6, 1.2, 'CONFORME'),
(10, '2018-07-14', 200225001, 'RESISTENCIA DE PELICULA 1K - 1/4W', 'S/N', 8, 0.1, 0.8, 'CONFORME'),
(10, '2018-07-14', 300216022, 'CONDENSADOR ELECTROLITICO 22UF - 16V', 'S/N', 4, 0.2, 0.8, 'CONFORME'),
(10, '2018-07-14', 100107432, 'OR DE 2 ENTRADAS CUADRUPLE', '74LS32', 2, 6, 1.3, 'CONFORME'),
(10, '2018-09-22', 200225010, 'RESISTENCIA DE PELICULA 10K - 1/4W', 'S/N', 2, 0.1, 0.2, 'CONFORME'),
(10, '2018-09-22', 200125220, 'RESISTENCIA DE PELICULA 220 - 1/4W', 'S/N', 7, 0.1, 0.7000000000000001, 'CONFORME');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;