import './CUsuario.module.css'
import React, { useState } from 'react';

function CUsuario() {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [perfil, setPerfil] = useState('0'); // Perfil '0' para para escolher
    const [message, setMessage] = useState('');
    const [error, setError] = useState('');
    
     
     const handleSubmit = async (e) => {
        e.preventDefault(); 

        // Preparando os dados para envio
        const idusuario = localStorage.getItem('userId'); 
        const userData = {
            nome: nome,
            email: email,
            senha: senha,
            perfil: perfil,
            usuario:idusuario
        };

        try {
            // Fazendo a requisição POST para a API
            const response = await fetch('http://localhost:8080/usuarios', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userData)
            });

            // Verificando se a resposta foi bem-sucedida
            if (response.ok) { // Verifica se o status HTTP está entre 200-299
                setMessage('Usuário cadastrado com sucesso!');
                // Limpa os campos do formulário
                setNome('');
                setEmail('');
                setSenha('');
                setPerfil('0'); 
            } else {
                const data = await response.json(); // Tenta ler a resposta da API
                setError(data.message || 'Erro ao cadastrar usuário.'); // Utilize uma mensagem específica se houver
            }
        } catch (error) {
            console.error('Erro ao enviar os dados:', error);
            setError('Erro ao cadastrar usuário.');
        }
    };


    return (    
        <div className="cusuario-container" style={{ maxWidth: '400px', margin: '0 auto', padding: '20px', textAlign: 'center' }}>
        <h2>Cadastrar Usuário</h2>
        {message && <p className="success">{message}</p>}
        {error && <p className="error">{error}</p>}
        <form className="login-form" onSubmit={handleSubmit}>
            <div>
                <label>Nome:</label>
                <input
                    type="text"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Email:</label>
                <input
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Senha:</label>
                <input
                    type="password"
                    value={senha}
                    onChange={(e) => setSenha(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Perfil:</label>
                <select value={perfil} onChange={(e) => setPerfil(e.target.value)} required>
                   <option value="0" >Escolha o Perfil</option>
                    <option value="1">Usuário</option>
                    <option value="2">Gestor</option>
                </select>
            </div>
            <div style={{ marginTop: '20px' }}>
                <button type="submit" style={{ padding: '10px 20px' }}>Cadastrar</button>
            </div>
        </form>
    </div>
          )
    }
    
    export default CUsuario;