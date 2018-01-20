-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2018 at 07:03 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rental_mobil`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_mobil`
--

CREATE TABLE `tb_mobil` (
  `id_mobil` varchar(4) NOT NULL,
  `nama_mobil` varchar(50) DEFAULT NULL,
  `merk_mobil` varchar(50) DEFAULT NULL,
  `plat_mobil` varchar(10) DEFAULT NULL,
  `harga_sewa` bigint(7) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mobil`
--

INSERT INTO `tb_mobil` (`id_mobil`, `nama_mobil`, `merk_mobil`, `plat_mobil`, `harga_sewa`, `status`) VALUES
('M01', 'Rush', 'Toyota', 'DA 6578 MB', 10000, 'READY'),
('M02', 'New Avanza', 'Toyota', 'DA 1231 PG', 400000, 'Pilih');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian`
--

CREATE TABLE `tb_pengembalian` (
  `id_pengembalian` varchar(4) NOT NULL,
  `id_rental` varchar(4) DEFAULT NULL,
  `id_penyewa` varchar(4) DEFAULT NULL,
  `id_mobil` varchar(4) DEFAULT NULL,
  `tgl_rental` date DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `lama` bigint(3) DEFAULT NULL,
  `total_bayar` bigint(8) DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pengembalian`
--

INSERT INTO `tb_pengembalian` (`id_pengembalian`, `id_rental`, `id_penyewa`, `id_mobil`, `tgl_rental`, `tgl_kembali`, `lama`, `total_bayar`, `status`) VALUES
('K01', 'A01', 'P01', 'M01', '2018-01-10', '2018-01-24', 14, 7000000, 'KEMBALI'),
('K02', 'A03', 'P03', 'M01', '2018-01-06', '2018-01-17', 11, 110000, 'KEMBALI');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penyewa`
--

CREATE TABLE `tb_penyewa` (
  `id_penyewa` varchar(4) NOT NULL,
  `nama_penyewa` varchar(25) DEFAULT NULL,
  `alamat` varchar(25) DEFAULT NULL,
  `no_hp` varchar(12) DEFAULT NULL,
  `no_ktp` varchar(16) DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penyewa`
--

INSERT INTO `tb_penyewa` (`id_penyewa`, `nama_penyewa`, `alamat`, `no_hp`, `no_ktp`, `status`) VALUES
('P01', 'Rudi Hartono', 'Banjarmasin', '085761511781', '63001910191809', 'NOTREADY'),
('P02', 'Rudi', 'Banjarbaru', '085117161818', '99872920202', 'NOTREADY'),
('P03', 'Doni', 'Martapura', '085755435664', '630086434567875', 'NOTREADY');

-- --------------------------------------------------------

--
-- Table structure for table `tb_rental`
--

CREATE TABLE `tb_rental` (
  `id_rental` varchar(4) NOT NULL,
  `id_penyewa` varchar(4) DEFAULT NULL,
  `id_mobil` varchar(4) DEFAULT NULL,
  `nama_penyewa` varchar(25) DEFAULT NULL,
  `nama_mobil` varchar(10) DEFAULT NULL,
  `harga_sewa` varchar(7) DEFAULT NULL,
  `tgl_sewa` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_rental`
--

INSERT INTO `tb_rental` (`id_rental`, `id_penyewa`, `id_mobil`, `nama_penyewa`, `nama_mobil`, `harga_sewa`, `tgl_sewa`, `status`) VALUES
('A01', 'P01', 'M01', 'Rudi Hartono', 'Rush', '500000', '2018-01-10', 'SELESAI'),
('A02', 'P01', 'M01', 'Rudi Hartono', 'Rush', '10000', '2018-01-16', 'SEWA'),
('A03', 'P03', 'M01', 'Doni', 'Rush', '10000', '2018-01-06', 'SELESAI');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_mobil`
--
ALTER TABLE `tb_mobil`
  ADD PRIMARY KEY (`id_mobil`);

--
-- Indexes for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`);

--
-- Indexes for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  ADD PRIMARY KEY (`id_penyewa`);

--
-- Indexes for table `tb_rental`
--
ALTER TABLE `tb_rental`
  ADD PRIMARY KEY (`id_rental`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
