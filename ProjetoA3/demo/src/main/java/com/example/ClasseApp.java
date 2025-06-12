/* 

package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ClasseApp {
    public static void main(String[] args) {
   // Interface Swing deve rodar na thread de eventos
        javax.swing.SwingUtilities.invokeLater(() -> { 
            ConnectionFactory.getConnection();
       
         // ========== INSERINDO DADOS INICIAIS ==========

            // CATEGORIA
            CategoriaDAO categoriaDAO = new CategoriaDAO();  // Criando Categoria
            categoriaDAO.adicionar(new Categoria(2, "Tênis"));
            categoriaDAO.adicionar(new Categoria(3, "Chinelo"));
            categoriaDAO.adicionar(new Categoria(4, "Sandália"));
            categoriaDAO.adicionar(new Categoria(5, "Bota"));

            // PRODUTO
            ProdutoDAO produtoDAO = new ProdutoDAO();  // Criando Produto
           // TÊNIS
            produtoDAO.adicionar(new Produto(10, "Tênis Adidas Originals Campus", 2, 100, 50, new BigDecimal("539.90")));
            produtoDAO.adicionar(new Produto(11, "Tênis Nike Court Vision Low", 2, 200, 100, new BigDecimal("379.99")));
            produtoDAO.adicionar(new Produto(12, "Tênis Nike Air Force", 2, 300, 80, new BigDecimal("759.99")));
            produtoDAO.adicionar(new Produto(13, "Tênis Vans Old Skool", 2, 100, 30, new BigDecimal("231.90")));
           
           // CHINELO
            produtoDAO.adicionar(new Produto(14, "Chinelo Havaianas", 3, 50, 10, new BigDecimal("29.90")));
            produtoDAO.adicionar(new Produto(15, "Chinelo Nike Calm", 3, 100, 70, new BigDecimal("289.99")));
            produtoDAO.adicionar(new Produto(16, "Chinelo Lacoste Slide Croco", 3, 100, 90, new BigDecimal("300.00")));
            produtoDAO.adicionar(new Produto(17, "Chinelo Rider Comuter Pack", 3, 150, 100, new BigDecimal("376.99")));
          
          // SANDÁLIA
            produtoDAO.adicionar(new Produto(18, "Sandália Carmim", 4, 50, 20, new BigDecimal("510.00")));
            produtoDAO.adicionar(new Produto(19, "Sandália Santa Lolla Couro Nobre Soft", 4, 120, 110, new BigDecimal("449.90")));
            produtoDAO.adicionar(new Produto(20, "Sandália Schutz Mila Mid", 4, 130, 50, new BigDecimal("259.00")));
            produtoDAO.adicionar(new Produto(21, "Sandália Arezzo Escarpin Preto", 4, 60, 15, new BigDecimal("429.90")));

         // BOTA
            produtoDAO.adicionar(new Produto(22, "Bota Arezzo Cano Curto", 5, 90, 15, new BigDecimal("500.00")));
            produtoDAO.adicionar(new Produto(23, "Bota Schutz Coturno Couro", 5, 110, 105, new BigDecimal("499.90")));
            produtoDAO.adicionar(new Produto(24, "Bota Carmim Hamburgo", 5, 90, 85, new BigDecimal("898.90")));
            produtoDAO.adicionar(new Produto(25, "Bota Carmim Honduras", 5, 60, 15, new BigDecimal("880.99")));


            // USUÁRIO
            UsuarioDAO usuarioDAO = new UsuarioDAO();  // C riando Usuário
            usuarioDAO.adicionar(new Usuario(40, "Luiza", "luizakdb@gmail.com", "senha123", true));
            usuarioDAO.adicionar(new Usuario(41, "Isabella Genuino", "isabella@gmail.com", "12senha", true));
            usuarioDAO.adicionar(new Usuario(42, "Thauanny Aguiar", "thauanny@gmail.com", "1234", true));
            usuarioDAO.adicionar(new Usuario(43, "Dhara Harumi", "dhara@gmail.com", "senha12", false));   
            usuarioDAO.adicionar(new Usuario(44, "Luiza Cardoso", "luiza@gmail.com", "12345senha", false));
            usuarioDAO.adicionar(new Usuario(45, "Carlos Miguel", "carlos@gmail.com", "senha", false));
            usuarioDAO.adicionar(new Usuario(46, "Mariana Beraldo", "mariana@gmail.com", "senha123456", false));
            usuarioDAO.adicionar(new Usuario(47, "João Miguel", "joao@gmail.com", "senha1", false));
            
            
            // PEDIDO
            PedidoDAO pedidoDAO = new PedidoDAO();  // Criando Pedido
            pedidoDAO.adicionar(new Pedido(60, new BigDecimal("539.90"), "PAGO", LocalDate.now(), 40));
            pedidoDAO.adicionar(new Pedido(61, new BigDecimal("379.99"), "PAGO", LocalDate.now(), 41));

            // ITEM DO PEDIDO
            ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();   // Criando Item do Pedido
            itemPedidoDAO.adicionar(new Item_Pedido(70, 10, 60, 1)); // 1x Tênis Adidas Originals Campus
            itemPedidoDAO.adicionar(new Item_Pedido(71, 11, 61, 1)); // 1x Tênis Nike Court Vision Low
           
            

            // ========== INICIANDO INTERFACE ==========
       
             new TelaLogin();
       
       
       
       
       
       
       
       
       
       
       
       
       
            });
    }
 
}

*/


 package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;    //usuario 1   produto 2  pedido 3 categoria 4 item pedido 5

public class ClasseApp {
    public static void main(String[] args) {
        // Interface Swing deve rodar na thread de eventos
        javax.swing.SwingUtilities.invokeLater(() -> {
            ConnectionFactory.getConnection();

            // ========== INSERINDO DADOS INICIAIS ==========

         /*  // USUÁRIO
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.adicionar(new Usuario(1, "Luiza", "luizakdb@gmail.com", "senha123", true));
            usuarioDAO.adicionar(new Usuario(2, "Thauanny Aguiar", "isabella@gmail.com", "12senha", true));
            usuarioDAO.adicionar(new Usuario(3, "Isabella Genuino", "thauanny@gmail.com", "12senha", true));
            usuarioDAO.adicionar(new Usuario(4, "Dhara Harumi", "dhara@gmail.com", "senha12", false));
            usuarioDAO.adicionar(new Usuario(5, "Luiza Cardoso", "luiza@gmail.com", "12345senha", false));
            usuarioDAO.adicionar(new Usuario(6, "Carlos Miguel", "carlos@gmail.com", "senha", false));
            usuarioDAO.adicionar(new Usuario(7, "Mariana Beraldo", "mariana@gmail.com", "senha123456", false));
            usuarioDAO.adicionar(new Usuario(8, "João Miguel", "joao@gmail.com", "senha1", false));

                


         /*  // CATEGORIA
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.adicionar(new Categoria(1, "Tênis"));
            categoriaDAO.adicionar(new Categoria(2, "Chinelo"));
            categoriaDAO.adicionar(new Categoria(3, "Sandália"));
            categoriaDAO.adicionar(new Categoria(4, "Bota"));

            // PRODUTO
            ProdutoDAO produtoDAO = new ProdutoDAO();
            // TÊNIS
            produtoDAO.adicionar(new Produto(10, "Tênis Adidas Originals Campus", 1, 100, 50, new BigDecimal("539.90")));
            produtoDAO.adicionar(new Produto(11, "Tênis Nike Court Vision Low", 1, 200, 100, new BigDecimal("379.99")));
            produtoDAO.adicionar(new Produto(12, "Tênis Nike Air Force", 1, 300, 80, new BigDecimal("759.99")));
            produtoDAO.adicionar(new Produto(13, "Tênis Vans Old Skool", 1, 100, 30, new BigDecimal("231.90")));

            // CHINELO
            produtoDAO.adicionar(new Produto(14, "Chinelo Havaianas", 2, 50, 10, new BigDecimal("29.90")));
            produtoDAO.adicionar(new Produto(15, "Chinelo Nike Calm", 2, 100, 70, new BigDecimal("289.99")));
            produtoDAO.adicionar(new Produto(16, "Chinelo Lacoste Slide Croco", 2, 100, 90, new BigDecimal("300.00")));
            produtoDAO.adicionar(new Produto(17, "Chinelo Rider Comuter Pack", 2, 150, 100, new BigDecimal("376.99")));

            // SANDÁLIA
            produtoDAO.adicionar(new Produto(18, "Sandália Carmim", 3, 50, 20, new BigDecimal("510.00")));
            produtoDAO.adicionar(new Produto(19, "Sandália Santa Lolla Couro Nobre Soft", 3, 120, 110, new BigDecimal("449.90")));
            produtoDAO.adicionar(new Produto(20, "Sandália Schutz Mila Mid", 3, 130, 50, new BigDecimal("259.00")));
            produtoDAO.adicionar(new Produto(21, "Sandália Arezzo Escarpin Preto", 3, 60, 15, new BigDecimal("429.90")));

            // BOTA
            produtoDAO.adicionar(new Produto(22, "Bota Arezzo Cano Curto", 4, 90, 15, new BigDecimal("500.00")));
            produtoDAO.adicionar(new Produto(23, "Bota Schutz Coturno Couro", 4, 110, 105, new BigDecimal("499.90")));
            produtoDAO.adicionar(new Produto(24, "Bota Carmim Hamburgo", 4, 90, 85, new BigDecimal("898.90")));
            produtoDAO.adicionar(new Produto(25, "Bota Carmim Honduras", 4, 60, 15, new BigDecimal("880.99")));

            
            // PEDIDO
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.adicionar(new Pedido(3, new BigDecimal("539.90"), "PAGO", LocalDate.now(), 12));
            pedidoDAO.adicionar(new Pedido(3, new BigDecimal("379.99"), "PAGO", LocalDate.now(), 12));

            // ITEM DO PEDIDO
            ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
            itemPedidoDAO.adicionar(new Item_Pedido(5, 2, 3, 1)); // Tênis Adidas para pedido 1
            itemPedidoDAO.adicionar(new Item_Pedido(5, 2, 3, 1)); // Tênis Nike para pedido 2
*/

            // ========== INICIANDO INTERFACE ==========
        
            new TelaLogin();

          

        });
    }
}
