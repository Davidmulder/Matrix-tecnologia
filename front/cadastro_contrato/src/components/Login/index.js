import './Login.componete.css'
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [error, setError] = useState('');
    const [success, setSuccess] = useState('');
    const redirecionar = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/usuarios/login', {
        email: email,
        senha: senha,
      });

       // A resposta provavelmente já contém o usuário diretamente
       const usuario = response.data;

       // Verifica se o objeto do usuário foi retornado corretamente
       if (usuario && usuario.id) {
        setSuccess('Login realizado com sucesso!');
        setError('');
        // Armazenar o ID do usuário e nome no localStorage
        
        localStorage.setItem('userId', usuario.id);
        localStorage.setItem('userNome', usuario.nome);
        localStorage.setItem('userPerfil', usuario.perfil);

        redirecionar('/contratos');


      } else {
        setError(response.data.message);
        setSuccess('');
      }
    } catch (err) {
      setError('Erro ao tentar fazer login.');
      setSuccess('');
    }
  };
 
    return (
        <div className="login-container">
      <form className="login-form" onSubmit={handleLogin}>
        <h2>Area de Acesso</h2>

        {error && <p className="error">{error}</p>}
        {success && <p className="success">{success}</p>}

        <div className="form-group">
        <label htmlFor="email">Email</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            placeholder="Digite seu email"
          />
        </div>

        <div className="form-group">
        <label htmlFor="senha">Senha</label>
          <input
            type="password"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            required
            placeholder="Digite sua senha"
          />
        </div>

        <button type="submit">Entrar</button>
      </form>
    </div>
    
    )
}

export default Login;