-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 14, 2023 at 06:24 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `injection`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `email`, `username`, `password`, `full_name`, `image`, `gender`, `date`) VALUES
(1, 'admin@gmail.com', 'admin', 'admin', 'admin', NULL, NULL, '2023-08-11');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `appointment_id` int(50) NOT NULL,
  `patient_id` bigint(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `vaccine_id` int(100) DEFAULT NULL,
  `brand` varchar(200) DEFAULT NULL,
  `productName` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `date` date NOT NULL,
  `date_modify` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `doctor` varchar(50) NOT NULL,
  `specialized` varchar(100) DEFAULT NULL,
  `schedule` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`id`, `appointment_id`, `patient_id`, `name`, `gender`, `description`, `vaccine_id`, `brand`, `productName`, `type`, `date`, `date_modify`, `date_delete`, `status`, `doctor`, `specialized`, `schedule`) VALUES
(1, 1, 20230002, 'test', 'Male', 'test', 1, 'Test', 'Test', 'Type4', '2023-08-11', '2023-08-13', '2023-08-11', 'Active', 'DID-1', NULL, '2023-08-25'),
(2, 2, 20230001, 'lala', 'Male', 'test', 1, 'test1', 'Test', 'Type4', '2023-08-11', '2023-08-12', NULL, 'Active', 'DID-1', 'Allergist', '2023-08-13'),
(3, 3, 20230001, 'lala', NULL, 'test', 2, 'test1', 'test1', 'Type2', '2023-08-13', '2023-08-13', NULL, 'Inactive', 'DID-1', 'Allergist', '2023-08-29');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `doctor_id` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `mobile_number` bigint(100) DEFAULT NULL,
  `specialized` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `date` date NOT NULL,
  `modify_date` date DEFAULT NULL,
  `delete_date` date DEFAULT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `doctor_id`, `password`, `full_name`, `email`, `gender`, `mobile_number`, `specialized`, `address`, `image`, `date`, `modify_date`, `delete_date`, `status`) VALUES
(1, 'DID-1', 'khang', 'Nguyen Vinh Khang', 'khang@gmail.com', 'Male', 123456, 'Allergist', 'Nguyen Vinh Khang', NULL, '2023-08-11', '2023-08-12', NULL, 'Active'),
(2, 'DID-2', '12345678', 'Khang', 'khang@123', 'Male', 12345678, 'Allergist', 'Khang', NULL, '2023-08-11', '2023-08-13', NULL, 'Active'),
(3, 'DID-3', '12345678', 'Khang', 'test', 'Male', 123456, 'Allergist', 'HN', NULL, '2023-08-12', '2023-08-13', NULL, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `patient_id` bigint(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `mobile_number` bigint(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `doctor` varchar(100) DEFAULT NULL,
  `specialized` varchar(200) DEFAULT NULL,
  `date` date NOT NULL,
  `date_modify` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(100) NOT NULL,
  `status_pay` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `patient_id`, `password`, `full_name`, `gender`, `mobile_number`, `address`, `image`, `description`, `doctor`, `specialized`, `date`, `date_modify`, `date_delete`, `status`, `status_pay`) VALUES
(1, 20230001, '12345678', 'lala', 'Male', 12345678, 'Hanoi', NULL, NULL, 'DID-1', NULL, '2023-08-11', '2023-08-11', NULL, 'Active', ''),
(2, 20230002, '12345678', 'New', 'Male', 123456789, 'Hnoi', NULL, NULL, 'DID-1', 'Allergist', '2023-08-11', '2023-08-12', NULL, 'Active', NULL),
(3, 20230003, '12345678', 'a', 'Male', 12345678, 'a', NULL, NULL, 'DID-2', NULL, '2023-08-11', '2023-08-13', NULL, 'Inactive', NULL),
(6, 20230004, '12345678', 'B', 'Male', 12345678, 'a', NULL, NULL, 'DID-1', 'Allergist', '2023-08-12', '2023-08-12', NULL, 'Inactive', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor` varchar(250) DEFAULT NULL,
  `total_days` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `date_checkout` date DEFAULT NULL,
  `date_pay` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vaccine`
--

CREATE TABLE `vaccine` (
  `id` int(11) NOT NULL,
  `vaccine_id` int(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `image` varchar(100) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vaccine`
--

INSERT INTO `vaccine` (`id`, `vaccine_id`, `brand`, `productName`, `type`, `status`, `price`, `image`, `date`) VALUES
(1, 1, 'Test', 'Test', 'Type4', 'Available', 123, 'D:\\\\vaccine_center_icon\\\\biglogo.png', '2023-08-12'),
(2, 2, 'test1', 'test1', 'Type2', 'Available', 123, 'D:\\\\vaccine_center_icon\\\\smalllogo.png', '2023-08-12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vaccine`
--
ALTER TABLE `vaccine`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vaccine`
--
ALTER TABLE `vaccine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
