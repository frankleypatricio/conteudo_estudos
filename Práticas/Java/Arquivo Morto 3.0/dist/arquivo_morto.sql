-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 01-Dez-2017 às 19:46
-- Versão do servidor: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arquivo_morto`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `nome_aluno` varchar(300) NOT NULL,
  `resp_aluno` varchar(300) NOT NULL,
  `datanasc_aluno` date NOT NULL,
  `cpf_aluno` varchar(14) DEFAULT NULL,
  `id_aluno` varchar(30) NOT NULL,
  `sexo_aluno` varchar(1) NOT NULL,
  `matricula_aluno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `cpf_user` varchar(14) NOT NULL,
  `nome_user` varchar(300) NOT NULL,
  `email_user` varchar(300) NOT NULL,
  `senha_user` varchar(300) NOT NULL,
  `status_user` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`cpf_user`, `nome_user`, `email_user`, `senha_user`, `status_user`) VALUES
('000.000.000-00', 'admin', 'admin@hotmail.com', 'adm123', 'Ativo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`matricula_aluno`),
  ADD UNIQUE KEY `id_aluno` (`id_aluno`),
  ADD UNIQUE KEY `cpf_aluno` (`cpf_aluno`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cpf_user`),
  ADD UNIQUE KEY `cpf_user` (`cpf_user`),
  ADD UNIQUE KEY `nome_user` (`nome_user`),
  ADD UNIQUE KEY `email_user` (`email_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `matricula_aluno` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
