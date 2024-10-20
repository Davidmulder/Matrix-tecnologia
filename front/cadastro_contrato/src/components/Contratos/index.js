import React, { useEffect, useState } from 'react';
import './Contratos.module.css'

function Contratos() {

    const [contratos, setContratos] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchContratos = async () => {
            try {
                const response = await fetch('http://localhost:8080/contratos/todos');
                if (!response.ok) {
                    throw new Error('Erro ao buscar contratos');
                }
                const data = await response.json();
                
               // Define os contratos diretamente do array retornado pela API
               setContratos(data);
            } catch (error) {
                setError(error.message);
            }
        };

        fetchContratos();
    }, []);

    
         
    // para formata os valores 
    const formatarValor = (valor) => {
        return new Intl.NumberFormat('pt-BR', { 
            style: 'currency', 
            currency: 'BRL' 
        }).format(valor);
    };


    return (
        <div className="contrato-container">
        <h2>Lista de Contratos</h2>
            
        <div className="button-container"  style={{ marginBottom: '20px',marginLeft:'79%'}} >
                <button 
                    onClick={() => window.location.href = '/cadastrocontrato'}
                    className="botao-cadastro" style={{ width: '200px' }}>
                    Cadastrar Novo Contrato
                </button>
            </div>
           
        {error && <div className="error">{error}</div>}        

        {contratos.length > 0 ? (
            <table>
                <thead>
                    <tr>
                        <th>Contrato Nº</th>                        
                        <th>Titulo</th>
                        <th>Valor</th>
                        <th>Serviço</th>
                    </tr>
                </thead>
                <tbody>
                    {contratos.map((contrato) => (
                        <tr key={contrato.idContrato}>
                            <td>{contrato.idContrato}</td>                            
                            <td>{contrato.titulo}</td>
                            <td>{formatarValor(contrato.valor)}</td>
                            <td>{contrato.tituloServico}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        ) : (
            <div>Nenhum contrato encontrado.</div>
        )}


    </div>

    
    
    )
}

export default Contratos;