/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import model.CadastroUsuarioModel;

/**
 *
 * @author 015.509576
 */
public class CadastroUsersDAO {
    
    public boolean cadastrar(CadastroUsuarioModel user){
    
    String sql = "INSERT INTO users" + 
            "(username, pass, nome, sobrenome, matricula, cpf, sexo, email, telefone, funcao, cep, endereco, numero, bairro, cidade, estado, complemento)" + 
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)";
            
            try (var con = ConnectionFactory.getConnection()){
                PreparedStatement stmt = con.prepareStatement(sql);
                
                stmt.setString(1, user.getNome());
                stmt.setString(2, user.getSobrenome());
                stmt.setString(3, user.getMatricula());
                stmt.setString(4, user.getCpf());
                stmt.setLong(5, user.getCep());
                stmt.setString(6, user.getEndereco());
                stmt.setString(7, user.getBairro());
                stmt.setString(8, user.getCidade());
                stmt.setString(9, user.getEstado());
                stmt.setString(10, user.getComplemento());
                stmt.setLong(11, user.getNumero());
                stmt.setString(12, user.getUsuario());
                stmt.setString(13, user.getSenha());
                
                
                stmt.executeUpdate();
                
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
    
            }
    
}
