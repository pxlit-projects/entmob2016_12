-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 30 sep 2016 om 16:04
-- Serverversie: 10.1.9-MariaDB
-- PHP-versie: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `regendans`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `airpressure`
--

CREATE TABLE `airpressure` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `locationid` int(11) DEFAULT NULL,
  `pressure` float NOT NULL,
  `timestamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `humidity`
--

CREATE TABLE `humidity` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `humidity` float NOT NULL,
  `timestamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `temperature`
--

CREATE TABLE `temperature` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `temperature` float NOT NULL,
  `timestamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `userlocation`
--

CREATE TABLE `userlocation` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `airpressure`
--
ALTER TABLE `airpressure`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userid` (`userid`),
  ADD KEY `locationid` (`locationid`);

--
-- Indexen voor tabel `humidity`
--
ALTER TABLE `humidity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `location_id` (`location_id`),
  ADD KEY `userid` (`userid`),
  ADD KEY `location_id_2` (`location_id`);

--
-- Indexen voor tabel `temperature`
--
ALTER TABLE `temperature`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userid` (`userid`),
  ADD KEY `location_id` (`location_id`),
  ADD KEY `userid_2` (`userid`),
  ADD KEY `location_id_2` (`location_id`);

--
-- Indexen voor tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `userlocation`
--
ALTER TABLE `userlocation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userid` (`userid`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `airpressure`
--
ALTER TABLE `airpressure`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `humidity`
--
ALTER TABLE `humidity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `temperature`
--
ALTER TABLE `temperature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `userlocation`
--
ALTER TABLE `userlocation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `airpressure`
--
ALTER TABLE `airpressure`
  ADD CONSTRAINT `airpressure_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `airpressure_ibfk_2` FOREIGN KEY (`locationid`) REFERENCES `userlocation` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `humidity`
--
ALTER TABLE `humidity`
  ADD CONSTRAINT `humidity_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `humidity_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `userlocation` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `temperature`
--
ALTER TABLE `temperature`
  ADD CONSTRAINT `temperature_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `temperature_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `userlocation` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `userlocation`
--
ALTER TABLE `userlocation`
  ADD CONSTRAINT `userlocation_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
