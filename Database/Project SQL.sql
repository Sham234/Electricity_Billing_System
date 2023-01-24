create database ebs;

use ebs;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ebs`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--
CREATE TABLE `bill` (
  `meter` varchar(30) NOT NULL,
  `month` varchar(30) NOT NULL,
  `units` varchar(30) NOT NULL,
  `amount` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`meter`, `month`, `units`, `amount`) VALUES
('446227', 'January', '500', '4650');

-- --------------------------------------------------------

--
-- Table structure for table `emp`
--

CREATE TABLE `emp` (
  `name` varchar(30) NOT NULL,
  `meter` varchar(30) NOT NULL,
  `address` text NOT NULL,
  `state` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp`
--

INSERT INTO `emp` (`name`, `meter`, `address`, `state`, `city`, `email`, `phone`) VALUES
('Sam', '446227', 'Brgy. To-oy', 'Himamaylan City', 'Malaysia', 'suarez081119@gmail.com', '0188716440');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `name` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `user` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`name`, `username`, `password`, `user`) VALUES
('sham', 'sham', '1702','Admin');
-- --------------------------------------------------------


-- --------------------------------------------------------

--
-- Table structure for table `tax`
--

CREATE TABLE `tax` (
 
  `meter_location` varchar(30) NOT NULL,
  `meter_type` varchar(30) NOT NULL,
  `phase_code` varchar(30) NOT NULL,
  `bill_type` varchar(30) NOT NULL,
  `days` varchar(30) NOT NULL,
  `meter_rent` varchar(30) NOT NULL,
  `MCB_rent` varchar(30) NOT NULL,
  `service_rent` varchar(30) NOT NULL,
  `GST` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tax` (`meter_location`, `meter_type`, `phase_code`, `bill_type`, `days`,  `meter_rent`, `MCB_rent`, `service_rent`,`GST`) VALUES
('Outside', 'Electric Meter', '011', 'Normal', '30', '47', '15','18','6');


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
