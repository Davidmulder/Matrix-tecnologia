import { Link } from 'react-router-dom';
import styles from './Cabecalho.module.css';
import CabecalhoLink from './CabecalhoLink';

function Cabecalho() {

   // const userId = localStorage.getItem('userId');

    return (
        <header className={styles.cabecalho}>
             
            <Link to="./">
                <img className={styles.logo} src="/imagens/logo.jpg" alt="Facil Tecnologia"></img>
                
            </Link>
            
            <nav>
            
            
           
            <CabecalhoLink url="./">
                    Login
            </CabecalhoLink>           
          
            
            <CabecalhoLink url="./contratos">
                    Contratos
            </CabecalhoLink>
            <CabecalhoLink url="./usuarios">
                    Usuario
            </CabecalhoLink>

            <CabecalhoLink url="./logout">
                    Sair do Sistema
            </CabecalhoLink>
               
            </nav>  
            
           
        </header>
    )
}

export default Cabecalho;