CREATE DATABASE IF NOT EXISTS ponto_do_calcados;
USE ponto_do_calcados;

-- Tabela de usuários
CREATE TABLE IF NOT EXISTS Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    administrador BOOLEAN NOT NULL
);

INSERT INTO Usuario (nome_usuario, email, senha, administrador)
VALUES ('JOSEFINA', 'JOSEFINA@GMAIL.COM', '123', true);


-- Tabela de categorias
CREATE TABLE IF NOT EXISTS Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome_categoria VARCHAR(100) NOT NULL
);

-- Tabela de produtos
CREATE TABLE IF NOT EXISTS Produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(150) NOT NULL,
    id_categoria INT NOT NULL,
    quantidade_entrada INT NOT NULL,
    quantidade_saida INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
 FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

ALTER TABLE Produto ADD COLUMN numero_calcado INT NOT NULL;
ALTER TABLE Produto MODIFY COLUMN numero_calcado VARCHAR(10);

SHOW COLUMNS FROM produto LIKE 'numero_calcado';


-- Tabela de pedidos
CREATE TABLE IF NOT EXISTS Pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    total_pedido DECIMAL(10,2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    data DATE NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Tabela de itens do pedido
CREATE TABLE IF NOT EXISTS itempedido (
    id_item_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_produto INT NOT NULL,
    id_pedido INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido)
);

 