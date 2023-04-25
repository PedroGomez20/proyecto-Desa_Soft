-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-04-2023 a las 00:29:24
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventas`
--
CREATE DATABASE IF NOT EXISTS `bd_ventas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd_ventas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `id_act` int(10) NOT NULL,
  `id_vendedor` int(11) UNSIGNED NOT NULL,
  `accion` varchar(30) NOT NULL,
  `fec_hor` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Nombres` varchar(244) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Direccion` varchar(244) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Dni`, `Nombres`, `Direccion`) VALUES
(1, 'A', 'PEDRO', 'SAN JOSE'),
(4, 'S', 'ALAN', 'CENTRO'),
(5, 'D', 'JUAN', 'CENTRO'),
(6, 'E', 'RAMON', 'SAN ANTONIO'),
(7, 'R', 'JIMENA', 'SAN JOSE'),
(8, 'T', 'ESDRAS', 'PELIGRO'),
(9, 'G', 'MARIA', 'OJO DE AGUA'),
(10, 'H', 'ANAHI', 'SAN MIGUEL 17'),
(11, 'W', 'KARLA', '1 DE ENERO'),
(12, '1', 'CARLOS', 'FRANCISCO I.'),
(13, 'W', 'JUANES', 'aguadulce');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Dni_rfc` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`IdDetalleVentas`, `IdVentas`, `IdProducto`, `Dni_rfc`, `Cantidad`, `PrecioVenta`) VALUES
(1, 21, 2, 'A', 1, 23),
(3, 23, 1, 'S', 1, 20),
(4, 24, 2, 'S', 1, 20),
(5, 25, 3, 'D', 1, 35),
(6, 26, 4, 'A', 1, 12),
(7, 27, 5, 'R', 1, 29),
(8, 28, 10, 'R', 1, 22),
(9, 29, 7, 'S', 1, 16),
(10, 30, 6, 'T', 1, 27),
(11, 31, 10, 'H', 1, 22),
(12, 32, 8, 'A', 1, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Precio` double NOT NULL,
  `Stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IdProducto`, `Nombres`, `Precio`, `Stock`) VALUES
(1, 'JABON', 20, 11),
(2, 'SABRITAS', 20, 15),
(3, 'COCA COLA 2 LITROS', 35, 3),
(4, 'SOPA NISSI', 12, 8),
(5, 'ACEITE', 29, 9),
(6, 'LECHE LALA ENTERA', 27, 20),
(7, 'SABRITAS TAKIS', 16, 7),
(8, 'AGUA CIEL', 15, 20),
(9, 'PASTA DENTAL COLGATE', 19, 7),
(10, 'ATUN DE AGUA', 22, 6),
(11, 'ELOTES EN LATA', 25, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `nombre_rol` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `nombre_rol`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'VENDEDOR'),
(5, 'GERENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `IdVendedor` int(11) UNSIGNED NOT NULL,
  `Dni` blob DEFAULT NULL,
  `Nombres` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Telefono` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `User` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`IdVendedor`, `Dni`, `Nombres`, `Telefono`, `User`, `id_rol`) VALUES
(2, 0x4b542f6839456c4636456a3038384756696a646438513d3d, 'PEDRO', '9765438902', 'root', 1),
(4, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'ALAN', '22222333', 'alan', 1),
(5, 0x622b41356d624a705736435575653665797a45635a413d3d, 'ESDRAS', '1230985436', 'emp01', 2),
(6, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'NADIA', '987654322', 'nadia', 5),
(7, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'ALEXA', '9875643222', 'alexa', 5),
(8, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'JUAN', '5566778832', 'juan', 2),
(9, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'victor', '0987654321', 'victor', 5),
(11, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'KARLA', '9753145678', 'karla', 2),
(12, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'RAMON', '9823456781', 'ramon', 5),
(13, 0x356a4c3864686e6e6e4f4472544155425362567a66513d3d, 'alex', '4562819034', 'alex', 2),
(14, 0x564169336a4d553149654a6a784c69457262667076413d3d, 'JIMENA', '1234321567', 'jimena', 2),
(15, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'aaa', '2223334445', 'aaa', 2),
(16, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'MARIXA', '6543287907', 'mari', 1),
(17, 0x75742f587a4166567868635669766c532b3576354d513d3d, 'divano', '2223334456', 'divano', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdVendedor` int(11) UNSIGNED NOT NULL,
  `RFC` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IdVentas`, `IdCliente`, `IdVendedor`, `RFC`, `FechaVentas`, `Monto`) VALUES
(21, 1, 5, 'A', '2023-04-17', 23),
(23, 4, 5, 'S', '2023-04-10', 20),
(24, 4, 5, 'S', '2023-04-10', 20),
(25, 5, 5, 'D', '2023-04-10', 35),
(26, 1, 8, 'A', '2023-04-10', 12),
(27, 7, 15, 'R', '2023-04-11', 29),
(28, 7, 5, 'R', '2023-04-11', 22),
(29, 4, 13, 'S', '2023-04-11', 16),
(30, 8, 5, 'T', '2023-04-12', 27),
(31, 10, 14, 'H', '2023-04-12', 22),
(32, 1, 5, 'A', '2023-04-13', 15);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`id_act`),
  ADD KEY `id_vendedor` (`id_vendedor`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`,`Dni`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`),
  ADD KEY `IdVentas_fk` (`IdVentas`),
  ADD KEY `IdProducto_fk` (`IdProducto`),
  ADD KEY `rfc` (`Dni_rfc`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`IdVendedor`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `IdCliente_fk` (`IdCliente`),
  ADD KEY `IdVendedor_fk` (`IdVendedor`),
  ADD KEY `RFC` (`RFC`),
  ADD KEY `rfc_cliente_id` (`IdCliente`,`RFC`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `id_act` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `IdVendedor` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `id_ven_act` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedor` (`IdVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `IdProducto_fk` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IdVentas_fk` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD CONSTRAINT `vendedor_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `IdVendedor_fk` FOREIGN KEY (`IdVendedor`) REFERENCES `vendedor` (`IdVendedor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_traba_user` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rfc_cliente_id` FOREIGN KEY (`IdCliente`,`RFC`) REFERENCES `cliente` (`IdCliente`, `Dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
