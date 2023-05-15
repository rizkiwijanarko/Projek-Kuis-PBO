-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2023 at 04:00 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kuis`
--

-- --------------------------------------------------------

--
-- Table structure for table `jawaban_quiz`
--

CREATE TABLE `jawaban_quiz` (
  `id` int(5) NOT NULL,
  `id_pertanyaan` int(5) NOT NULL,
  `teks_jawaban` varchar(255) NOT NULL,
  `is_correct` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pertanyaan_quiz`
--

CREATE TABLE `pertanyaan_quiz` (
  `id` int(5) NOT NULL,
  `teks_pertanyaan` varchar(255) NOT NULL,
  `id_jawaban_benar` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jawaban_quiz`
--
ALTER TABLE `jawaban_quiz`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_pertanyaan` (`id_pertanyaan`);

--
-- Indexes for table `pertanyaan_quiz`
--
ALTER TABLE `pertanyaan_quiz`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jawaban_tepat` (`id_jawaban_benar`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pertanyaan_quiz`
--
ALTER TABLE `pertanyaan_quiz`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jawaban_quiz`
--
ALTER TABLE `jawaban_quiz`
  ADD CONSTRAINT `id_pertanyaan` FOREIGN KEY (`id_pertanyaan`) REFERENCES `pertanyaan_quiz` (`id`);

--
-- Constraints for table `pertanyaan_quiz`
--
ALTER TABLE `pertanyaan_quiz`
  ADD CONSTRAINT `jawaban_tepat` FOREIGN KEY (`id_jawaban_benar`) REFERENCES `jawaban_quiz` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
