import'./CContrato.module.css'
import React, { useState, useEffect  } from 'react';

function CContrato() {
    const [titulo, setTitulo] = useState('');
    const [texto, setTexto] = useState(''); // Alterado de 'descricao' para 'texto'
    const [valor, setValor] = useState(''); 
    const [idService, setIdService] = useState(''); // Adicionado para 'id_service'
    const [servicos, setServicos] = useState([]); // Estado para armazenar os serviços
    const [message, setMessage] = useState('');
    
   // Fetch para carregar os serviços da API
        useEffect(() => {
            const fetchServicos = async () => {
                try {
                    const response = await fetch('http://localhost:8080/servicos/todos');
                    if (!response.ok) {
                        throw new Error('Erro ao buscar serviços');
                    }
                    const data = await response.json();
                    setServicos(data); // Atualiza o estado com a lista de serviços
                } catch (error) {
                    console.error('Erro ao buscar serviços:', error);
                }
            };

            fetchServicos();
        }, []);
   
    //=================================================================================================
    const handleSubmit = async (e) => {
        e.preventDefault();

        
        const contratoData = {
            titulo: titulo,
            texto: texto,  // Envia 'texto' em vez de 'descricao'
            valor: valor,
            id_service: idService  // Envia 'id_service' no lugar de 'usuario'
        };

        try {
            const response = await fetch('http://localhost:8080/contratos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(contratoData),
            });

            if (response.ok) { // Verifica se o status HTTP está entre 200-299
                setMessage('Contrato cadastrado com sucesso!');
                // Limpar os campos após o sucesso
                setTitulo('');
                setTexto('');
                setValor('');
                setIdService('');
            } else {
                setMessage(`Erro ao cadastrar contrato. Código: ${response.status}`);
            }
        } catch (error) {
            console.error('Erro ao enviar os dados:', error);
            setMessage('Erro ao cadastrar contrato.');
        }
    };

    return (
    
        <div className="ccontrato-container"style={{ maxWidth: '400px', margin: '0 auto', padding: '20px', textAlign: 'center' }}>
        <h2>Cadastrar Contrato</h2>
        {message && <p>{message}</p>}
        <form className="login-form" onSubmit={handleSubmit}>
            <div>
                <label>Título:</label>
                <input
                    type="text"
                    value={titulo}
                    onChange={(e) => setTitulo(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Descrição:</label>
                <textarea
                        value={texto}
                        onChange={(e) => setTexto(e.target.value)} // Alterado para 'setTexto'
                        required
                    />
            </div>
            <div>
                    <label>Valor (R$):</label> 
                    <input
                        type="number"
                        step="0.01" // Para aceitar valores decimais
                        value={valor}
                        onChange={(e) => setValor(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Serviço (ID) :</label> 
                    <select
                        value={idService}
                        onChange={(e) => setIdService(e.target.value)} // Atualiza o id do serviço
                        required
                    >
                        <option value="">Selecione um serviço</option>
                        {servicos.map((servico) => (
                            <option key={servico.id} value={servico.id}>
                                {servico.titulo}
                            </option>
                        ))}
                    </select>
                </div>
           
            
            <div>
                <button type="submit">Cadastrar</button>
            </div>
        </form>
    </div>
    )
    }
    
    export default CContrato;