
import Inicio from "./pages/Inicio";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Cabecalho from "./components/Cabecalho";
import Rodape from "./components/Rodape";
import ListaContratos from "./pages/ListaContratos";
import ListaUsuarios from "./pages/ListaUsuarios";
import CadastroUsuario from "./pages/CadastroUsuario";
import CadastroContrato from "./pages/CadastroContrato";
import Erro404 from "./pages/Erro404";
import SairdoSistema from "./pages/SairdoSistema";


function AppRoutes() {
    return (
        <BrowserRouter>        
           <Cabecalho/>
            <Routes>  {/* pagina inicial */}
                <Route path="/" element={<Inicio/>}></Route>
                <Route path="/contratos" element={<ListaContratos/>}></Route>               
                <Route path="/usuarios" element={<ListaUsuarios/>}></Route>
                <Route path="/cadastrousuario" element={<CadastroUsuario/>}></Route> 
                <Route path="/cadastrocontrato" element={<CadastroContrato/>}></Route>
                <Route path="/logout" element={<SairdoSistema/>}></Route>  
                {/* pagina inexistente */}
                <Route path="*" element={<Erro404/>}></Route>     
            </Routes>           
          <Rodape/>
        </BrowserRouter>
    )
}

export default AppRoutes;