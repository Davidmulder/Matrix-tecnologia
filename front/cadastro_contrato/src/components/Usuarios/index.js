import './Usuarios.module.css'
import React, { useEffect, useState } from 'react';
    
    function Usuarios() {
        const [usuarios, setUsuarios] = useState([]);
        const [error, setError] = useState('');
    
        useEffect(() => {
            const fetchUsuarios = async () => {
                try {
                    const response = await fetch('http://localhost:8080/usuarios/todos');
                    if (!response.ok) {
                        throw new Error('Erro ao buscar Usuario');
                    }
                    const data = await response.json();
    
                    // Acessar o campo 'content' que contém a lista de usuários
                    setUsuarios(data.content);
                } catch (error) {
                    setError(error.message);
                }
            };
    
            fetchUsuarios();
        }, []);
    
        

          // Verifica o perfil do usuário tem permissão somente que nivel gestor pode ver o botão
          const userPerfil = localStorage.getItem('userPerfil');

    return (    
        <div className="contrato-container">
        <h2>Lista de Usuarios</h2>
        {userPerfil === '2' && (   
        <div className="button-container"  style={{ marginBottom: '20px',marginLeft:'79%'}} >
                <button 
                    onClick={() => window.location.href = '/cadastrousuario'}
                    className="botao-cadastro" style={{ width: '200px' }}>
                    Cadastrar Novo Usuario
                </button>
            </div>
         )}
        {error && <div className="error">{error}</div>}        

        {usuarios.length > 0 ? (
            <table>
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>E-mail</th>
                        <th>Perfil</th>
                        
                    </tr>
                </thead>
                <tbody>
                    {usuarios.map((usuario) => (
                        <tr key={usuario.id}>
                            <td>{usuario.nome}</td>                            
                            <td>{usuario.email}</td>
                            <td>{usuario.perfil === '1' ? 'Usuário' : 'Gestor'}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        ) : (
            <div>Nenhum Usuario encontrado.</div>
        )}


    </div>
    )
    }
    
    export default Usuarios;