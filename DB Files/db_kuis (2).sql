-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2023 at 03:13 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

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
  `is_correct` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jawaban_quiz`
--

INSERT INTO `jawaban_quiz` (`id`, `id_pertanyaan`, `teks_jawaban`, `is_correct`) VALUES
(1, 2, 'jawabannya saya tidak tahu', '1'),
(2, 22, 'gggg', 'Benar'),
(1212, 222, 'asdfghjkl', '1');

-- --------------------------------------------------------

--
-- Table structure for table `pertanyaan_quiz`
--

CREATE TABLE `pertanyaan_quiz` (
  `id` int(5) NOT NULL,
  `teks_pertanyaan` varchar(255) NOT NULL,
  `id_jawaban_benar` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pertanyaan_quiz`
--

INSERT INTO `pertanyaan_quiz` (`id`, `teks_pertanyaan`, `id_jawaban_benar`) VALUES
(0, '5', NULL),
(5, 'hihihihi', NULL);

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
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
